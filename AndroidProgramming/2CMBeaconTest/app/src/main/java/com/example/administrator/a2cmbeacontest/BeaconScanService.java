package com.example.administrator.a2cmbeacontest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.perples.recosdk.RECOBeacon;
import com.perples.recosdk.RECOBeaconManager;
import com.perples.recosdk.RECOBeaconRegion;
import com.perples.recosdk.RECOErrorCode;
import com.perples.recosdk.RECORangingListener;
import com.perples.recosdk.RECOServiceConnectListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class BeaconScanService extends Service implements RECOServiceConnectListener, RECORangingListener{
    private RECOBeaconManager recoBeaconManager;    //beacon설정
    private ArrayList<RECOBeaconRegion> regions;    //beacon 검색 범위 설정


    public BeaconScanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        /*throw new UnsupportedOperationException("Not yet implemented"); kjh1006*/
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        recoBeaconManager = RECOBeaconManager.getInstance(getApplicationContext(), true, false);
        recoBeaconManager.setScanPeriod(1000);
        recoBeaconManager.setRangingListener(this);

        regions = new ArrayList<RECOBeaconRegion>();
        RECOBeaconRegion recoRegion = new RECOBeaconRegion("24DDF411-8CF1-440C-87CD-E368DAF9C931","RECO Sample Region");
        regions.add(recoRegion);

        recoBeaconManager.bind(this);

        return START_STICKY;
    }

    @Override
    public void onServiceConnect() {
        for(RECOBeaconRegion region : regions) {
            try {
                recoBeaconManager.startRangingBeaconsInRegion(region);//범위안에 있는 비콘에 대한 알림 전달
            } catch (Exception e) {}
        }
    }

    @Override
    public void onServiceFail(RECOErrorCode recoErrorCode) {

    }

    @Override
    public void onDestroy() {
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

    @Override
    public void didRangeBeaconsInRegion(Collection<RECOBeacon> collection, RECOBeaconRegion recoBeaconRegion) {
        for (RECOBeacon beacon : collection) {
            int bmajor = beacon.getMajor();
            if (beacon.getAccuracy() < 0.1){    //5m지정
                if (!beacons.contains(bmajor)) {
                    beacons.add(bmajor);
                    StoreEvent storeEvent = getStoreEvent(bmajor);
                    popupNotification(storeEvent);
                }
            } else {
                beacons.remove(new Integer(bmajor));
            }
        }
    }

    @Override
    public void rangingBeaconsDidFailForRegion(RECOBeaconRegion recoBeaconRegion, RECOErrorCode recoErrorCode) {

    }

    private StoreEvent getStoreEvent(int bmajor) {
        StoreEvent storeEvent = new StoreEvent();
        storeEvent.setBmajor(bmajor);
        storeEvent.setSid("store1");
        List<String> events = Arrays.asList("엄청난 이벤트");
        storeEvent.setEtitle(events);
        return storeEvent;
    }

    private void popupNotification(StoreEvent storeEvent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS /*| Notification.DEFAULT_VIBRATE*/);
        builder.setSmallIcon(R.drawable.coffeecup24);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.coffeecup));
        builder.setContentTitle(storeEvent.getSid() + ": " + storeEvent.getBmajor());
        builder.setContentText(storeEvent.getEtitle().get(0));

        Intent intent = new Intent(getApplicationContext(), EventActivity.class);
        intent.putExtra("beacon",""+storeEvent.getBmajor());

        PendingIntent pendingIntent = PendingIntent.getActivity(    //이벤트후 Activity가 어떤 행동을 할지 미리 정의함.
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        builder.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(storeEvent.getBmajor(), builder.build());
    }

}
