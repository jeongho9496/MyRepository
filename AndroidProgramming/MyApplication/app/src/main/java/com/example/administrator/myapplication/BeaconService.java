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
    public int onStartCommand(Intent intent, int flags, int startId) {  //서비스 실행시 제일 처음 실행하는 메소드
        Log.i("mylog","onStartCommand실행");

        final Thread thread = new Thread(){
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
        };
        thread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {   //서비스 끝날때 실행 되는 메소드
        super.onDestroy();
        Log.i("mylog","onDestroy실행");
        stop=true;
    }
}
