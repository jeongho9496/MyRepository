package com.example.administrator.a2cmfinal.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.administrator.a2cmfinal.Activity.EventActivity;
import com.example.administrator.a2cmfinal.NetWork.NetWork;
import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.dto.StoreEvent;
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
import java.util.Collection;
import java.util.List;

public class BeaconScanService extends Service implements RECOServiceConnectListener, RECORangingListener {
    private RECOBeaconManager recoBeaconManager;    //beacon설정
    private ArrayList<RECOBeaconRegion> regions;    //beacon 검색 범위 설정

    private long mScanDuration = 1*1000L;


    public BeaconScanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        /*throw new UnsupportedOperationException("Not yet implemented");*/
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        recoBeaconManager = RECOBeaconManager.getInstance(getApplicationContext(), true, false);
        recoBeaconManager.setScanPeriod(mScanDuration);
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
            if (beacon.getAccuracy() < 0.5){
                if (!beacons.contains(bmajor)) {
                    beacons.add(bmajor);
                    /*StoreEvent storeEvent = getStoreEvent(bmajor);
                    popupNotification(storeEvent);*/
                    getStoreEventTest(bmajor);
                }
            } else {

                beacons.remove(new Integer(bmajor));

                //범위를 벗어 낫을때 노티피케이션을 삭제 한다.
                /*NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.cancel(new Integer(bmajor));*/
            }
        }
    }

    private void getStoreEventTest(final int bmajor) {
        AsyncTask<Void, Void, List<StoreEvent>> asyncTask = new AsyncTask<Void, Void, List<StoreEvent>>() {
            @Override
            protected List<StoreEvent> doInBackground(Void... params) {
                List<StoreEvent> list = null;
                try {
                    URL url = new URL(NetWork.URI+"/eventAndroid?sbeacon="+bmajor);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();// url.openConnection() 연결 객체 얻음
                    conn.connect();//연결

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {//200 이면 정상
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);  // 읽기 객체 생성
                        BufferedReader br = new BufferedReader(reader);//성능 향상위해 사용.
                        String strJson = "";
                        while (true) {
                            String data = br.readLine();
                            if (data == null) break;
                            strJson += data;
                        }
                        br.close();
                        reader.close();
                        is.close();
                        list = parseJson(strJson, bmajor);

                        Log.i("mylog beacon", strJson);


                    } else {

                    }

                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<StoreEvent> storeEvents) {
                for (StoreEvent event: storeEvents) {
                    popupNotification(event);
                }
            }
        };
        asyncTask.execute();
    }


    private List<StoreEvent> parseJson(String strJson, int bmajor) {
        List<StoreEvent> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                StoreEvent event = new StoreEvent();

                event.setSid(jsonObject.getString("sid"));
                event.setEtitle(jsonObject.getString("etitle"));
                event.setEcontents(jsonObject.getString("econtents"));
                event.setEstartperiod(jsonObject.getString("estartperiod"));
                event.setElastperiod(jsonObject.getString("elastperiod"));
                event.setImageLarge(jsonObject.getString("esavedfile"));
                event.setBmajor(bmajor);

                list.add(event);

            }

        } catch (JSONException e){
            Log.i("mylog", e.getMessage());
        }

        return list;
    }

    @Override
    public void rangingBeaconsDidFailForRegion(RECOBeaconRegion recoBeaconRegion, RECOErrorCode recoErrorCode) {

    }

    private void popupNotification(StoreEvent storeEvent) {
        if (storeEvent != null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS);
            builder.setSmallIcon(R.drawable.coffeecup24);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.coffeecup));
            builder.setContentTitle(storeEvent.getEtitle());
            builder.setContentText(storeEvent.getEcontents());
            Intent intent = new Intent(getApplicationContext(), EventActivity.class);
            intent.putExtra("sid", storeEvent.getSid());
            intent.putExtra("sbeacon", "" + storeEvent.getBmajor());
            intent.putExtra("content", storeEvent.getEcontents());
            intent.putExtra("image", storeEvent.getImageLarge());

            PendingIntent pendingIntent = PendingIntent.getActivity(    //이벤트후 Activity가 어떤 행동을 할지 미리 정의함.
                    this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
            );

            builder.setContentIntent(pendingIntent);

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(storeEvent.getBmajor(), builder.build());
        }
    }

}
