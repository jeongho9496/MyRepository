package com.example.administrator.a2cmfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
    private ImageView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LOG-IN");

        btnLogin = (ImageView)findViewById(R.id.btn_login);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this, BeaconStartActivity.class);
        startActivity(intent);

    }


}
