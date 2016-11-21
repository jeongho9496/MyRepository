package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BeaconService extends Service {
    boolean stop;

    public BeaconService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("mylog","onStartCommand실행");

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop){
                    Log.i("mylog", "beaconScanning");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("mylog","onDestroy실행");
        stop=true;
    }
}
