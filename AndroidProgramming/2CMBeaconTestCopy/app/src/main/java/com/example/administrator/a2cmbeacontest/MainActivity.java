package com.example.administrator.a2cmbeacontest;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.a2cmbeacontest.dto.StoreEvent;

public class MainActivity extends AppCompatActivity {
    private LinearLayout rootViewGroup;

    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;

    private static final int REQUEST_ENABLE_BT = 1;

    private TextView testText;

    private StoreEvent storeEvent;

    Button btnStart, btnStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootViewGroup = (LinearLayout) findViewById(R.id.rootViewGroup);

        testText = (TextView)findViewById(R.id.testText);

        storeEvent = new StoreEvent();

        btnStart = (Button)findViewById(R.id.btnStart);

        btnStop = (Button)findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeaconScanService.class);
                startService(intent);
                Log.i("mylog","service Start");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeaconScanService.class);
                stopService(intent);
                Log.i("mylog","service Stop");
            }
        });

        /*testText.setText("1"+storeEvent.getSid());*/

        mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            mBluetoothAdapter = mBluetoothManager.getAdapter();
        } else {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }

        if(mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT);
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.i("MainActivity", "The location permission (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION) is not granted.");
                this.requestLocationPermission();
            } else {
                Log.i("MainActivity", "The location permission (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION) is already granted.");
            }
        }

    }

    private void requestLocationPermission() {
        //사용자에게 지금 이앱이 권한을 왜 요청하고 있는지 설명하는 페이지를 보여줄 것 인지 말것인지 확인 권한 설정 허용 팝업 아님
        if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);
            return;
        }
        //권한 설정을 안할시 스낵바로 한번 더 알림
        Snackbar.make(rootViewGroup, R.string.app_info, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //권한 체크 요청
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);
                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == 10) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(rootViewGroup, "Location permission has been granted. RECO SDK can now work properly", Snackbar.LENGTH_LONG)
                        .show();
            } else {
                Snackbar.make(rootViewGroup, "Location permission for this application is denied. RECO SDK may not work properly", Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
