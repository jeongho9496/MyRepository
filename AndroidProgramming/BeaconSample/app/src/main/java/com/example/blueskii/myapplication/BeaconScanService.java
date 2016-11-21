package com.example.blueskii.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;

import com.perples.recosdk.RECOBeacon;
import com.perples.recosdk.RECOBeaconManager;
import com.perples.recosdk.RECOBeaconRegion;
import com.perples.recosdk.RECOErrorCode;
import com.perples.recosdk.RECORangingListener;
import com.perples.recosdk.RECOServiceConnectListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BeaconScanService extends Service implements RECOServiceConnectListener, RECORangingListener {
    private RECOBeaconManager recoBeaconManager;    //beacon설정
    private ArrayList<RECOBeaconRegion> regions;    //beacon 검색 범위 설정

    public BeaconScanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {  //특정 범위만 service 동작시 사용.(bind service <=> background service = 앱이 종료 되도 계속 실행.)
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        recoBeaconManager = RECOBeaconManager.getInstance(getApplicationContext(), true, false);
        /**
         * getInstance(singleton) 생성 (스캔 대상 및 백그라운드 ranging timeout 설정)
         * RECOBeaconManager.getInstance(context 설정, Reco beacon만 실행시 -> true, 항상 background service로 beacon 검색을 원할시 -> false)
         */
        recoBeaconManager.setScanPeriod(1000);// 새로 검색하는 시간 설정(1초마다 새로운 비콘 검색)
        recoBeaconManager.setRangingListener(this);//RECIRangingListener 리스너를 매개변수로 받음.(BeaconScanService가 구현하고 있으므로 this로 지정)

        regions = new ArrayList<RECOBeaconRegion>(); //범위(지역) 설정 여러 범위를 설정 할수 있으므로 List형태로 만든다.
        RECOBeaconRegion recoRegion = new RECOBeaconRegion("24DDF411-8CF1-440C-87CD-E368DAF9C931", "RECO Sample Region");//uuid, major, minor로 설정 가능
        regions.add(recoRegion);

        recoBeaconManager.bind(this);//recoBeaconManager와 BeaconScanService 연결 확인.

        return START_STICKY;    //앱이 종료 되도 실행 (<=> START_NOT_STICKY 앱이 종료 되면 종료)
    }

    @Override
    public void onServiceConnect() { //RECOServiceConnectListener에서 구현해야 되는 메소드
        for(RECOBeaconRegion region : regions) {
            try {
                recoBeaconManager.startRangingBeaconsInRegion(region);//범위안에 있는 비콘에 대한 알림 전달
            } catch (Exception e) {}
        }
    }

    @Override   //RECOServiceConnectListener에서 구현해야 되는 메소드
    public void onServiceFail(RECOErrorCode recoErrorCode) {
    }

    @Override
    public void onDestroy() {   //서비스 종료 할때 사용되는 메소드
        for(RECOBeaconRegion region : regions) {
            try {
                recoBeaconManager.stopRangingBeaconsInRegion(region);   //알림 종료
            } catch (Exception e) {}
        }
        try {
            recoBeaconManager.unbind(); //service를 destroy한다.
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> beacons = new ArrayList<>();
    @Override //RECORangingListener에서 구현해야 되는 메소드
    public void didRangeBeaconsInRegion(Collection<RECOBeacon> collection, RECOBeaconRegion recoBeaconRegion) {
        for(RECOBeacon beacon : collection) {
            int bminor = beacon.getMinor(); //비콘의 minor 정보 입수
            if (beacon.getAccuracy() < 1) {//1m이내의 비콘 이 있다면
                if(!beacons.contains(bminor)) { //bminor가 becons에 포함되있지 않다면 (똑같은 비콘 정보가 중복으로 알람 띄우는 것을 방지 하기 위해)
                    beacons.add(bminor);        //beacons에 추가
                    StoreEvent storeEvent = getStoreEvent(bminor);//getStoreEvent 메소드에 minor값 추가
                    popupNotification(storeEvent);  //popupNotification 에 storeEvent 클래스 추가
                }
            } else {
                beacons.remove(new Integer(bminor));    //1미터 밖이라면 beacon을 지운다.(다시 해당 구역을 지나갈때 알람이 나와야 하므로)
            }
        }
    }

    @Override//RECORangingListener에서 구현해야 되는 메소드
    public void rangingBeaconsDidFailForRegion(RECOBeaconRegion recoBeaconRegion, RECOErrorCode recoErrorCode) {
    }

    private StoreEvent getStoreEvent(int bminor) {  //서버에서 받는 부분
        StoreEvent storeEvent = new StoreEvent();
        storeEvent.setBminor(bminor);
        storeEvent.setSid(1);
        storeEvent.setSname("스타벅스");
        List<String> events = Arrays.asList("크리스마스 할인 이벤트");
        storeEvent.setEvents(events);
        return storeEvent;
    }

    private void popupNotification(StoreEvent shopEvent) {  //서버에서 받은 데이터를 notification으로 띄어줌
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(shopEvent.getSname() + ": " + shopEvent.getBminor());
        builder.setContentText(shopEvent.getEvents().get(0));

        PendingIntent pendingIntent = PendingIntent.getActivity(    //이벤트후 Activity가 어떤 행동을 할지 미리 정의함.
            this, 0,
            new Intent(this, EventActivity.class),
            PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(shopEvent.getBminor(), builder.build());
    }
}
