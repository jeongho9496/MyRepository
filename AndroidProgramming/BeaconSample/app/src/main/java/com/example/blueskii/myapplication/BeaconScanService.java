package com.example.blueskii.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.perples.recosdk.RECOBeacon;
import com.perples.recosdk.RECOBeaconManager;
import com.perples.recosdk.RECOBeaconRegion;
import com.perples.recosdk.RECOErrorCode;
import com.perples.recosdk.RECORangingListener;
import com.perples.recosdk.RECOServiceConnectListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class BeaconScanService extends Service implements RECOServiceConnectListener, RECORangingListener {
    private RECOBeaconManager recoBeaconManager;
    private ArrayList<RECOBeaconRegion> regions;

    public BeaconScanService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        recoBeaconManager = RECOBeaconManager.getInstance(getApplicationContext(), true, false);
        recoBeaconManager.setScanPeriod(1000);
        recoBeaconManager.setRangingListener(this);

        regions = new ArrayList<RECOBeaconRegion>();
        RECOBeaconRegion recoRegion = new RECOBeaconRegion("24DDF411-8CF1-440C-87CD-E368DAF9C931", "RECO Sample Region");
        regions.add(recoRegion);

        recoBeaconManager.bind(this);

        return START_STICKY;
    }

    @Override
    public void onServiceConnect() {
        for(RECOBeaconRegion region : regions) {
            try {
                recoBeaconManager.startRangingBeaconsInRegion(region);
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
                recoBeaconManager.stopRangingBeaconsInRegion(region);
            } catch (Exception e) {}
        }
        try {
            recoBeaconManager.unbind();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> beacons = new ArrayList<>();
    @Override
    public void didRangeBeaconsInRegion(Collection<RECOBeacon> collection, RECOBeaconRegion recoBeaconRegion) {
        for(RECOBeacon beacon : collection) {
            int bminor = beacon.getMinor();
            if (beacon.getAccuracy() < 1) {
                if(!beacons.contains(bminor)) {
                    beacons.add(bminor);
                    StoreEvent storeEvent = getStoreEvent(bminor);
                    popupNotification(storeEvent);
                }
            } else {
                beacons.remove(new Integer(bminor));
            }
        }
    }

    @Override
    public void rangingBeaconsDidFailForRegion(RECOBeaconRegion recoBeaconRegion, RECOErrorCode recoErrorCode) {
    }

    private StoreEvent getStoreEvent(int bminor) {
        StoreEvent storeEvent = new StoreEvent();
        storeEvent.setBminor(bminor);
        storeEvent.setSid(1);
        storeEvent.setSname("스타벅스");
        List<String> events = Arrays.asList("크리스마스 할인 이벤트");
        storeEvent.setEvents(events);
        return storeEvent;
    }

    private void popupNotification(StoreEvent shopEvent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(shopEvent.getSname() + ": " + shopEvent.getBminor());
        builder.setContentText(shopEvent.getEvents().get(0));

        PendingIntent pendingIntent = PendingIntent.getActivity(
            this, 0,
            new Intent(this, EventActivity.class),
            PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(shopEvent.getBminor(), builder.build());
    }
}
