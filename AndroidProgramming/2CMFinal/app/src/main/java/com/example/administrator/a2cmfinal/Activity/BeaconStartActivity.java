package com.example.administrator.a2cmfinal.Activity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrator.a2cmfinal.Service.BeaconScanService;
import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.dto.StoreEvent;

public class BeaconStartActivity extends AppCompatActivity {
    //MainActivity 이전

    private RelativeLayout rootViewGroup;

    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;

    private static final int REQUEST_ENABLE_BT = 1;

    private StoreEvent storeEvent;

    ToggleButton btnBeacon ;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon);

        getSupportActionBar().setTitle("Beacon Start");

        /*//로그인 테스트
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        String test = pref.getString("id","");
        Toast.makeText(BeaconStartActivity.this, test+"님 반갑습니다.", Toast.LENGTH_SHORT).show();*/

        rootViewGroup = (RelativeLayout)findViewById(R.id.rootViewGroup);

        btnBeacon = (ToggleButton)findViewById(R.id.btnBeacon);

        setting = getSharedPreferences("setting", 0);
        editor= setting.edit();



        btnBeacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    btnBeacon.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.beacon_on));
                    Intent intent = new Intent(BeaconStartActivity.this, BeaconScanService.class);
                    startService(intent);
                    editor.putBoolean("Auto_Login_enabled", true);
                    editor.commit();
                    Log.i("mylog of", "start");

                } else {
                    btnBeacon.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.beacon_off));
                    Intent intent = new Intent(BeaconStartActivity.this, BeaconScanService.class);
                    stopService(intent);
                    editor.clear();
                    editor.commit();
                    Log.i("mylog off", "stop");
                }
            }
        });

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

        if(setting.getBoolean("Auto_Login_enabled", false)){
            btnBeacon.setChecked(true);
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
                        ActivityCompat.requestPermissions(BeaconStartActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);
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

}
