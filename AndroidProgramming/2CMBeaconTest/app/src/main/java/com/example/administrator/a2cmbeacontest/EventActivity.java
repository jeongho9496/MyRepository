package com.example.administrator.a2cmbeacontest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    TextView serviceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        serviceText = (TextView)findViewById(R.id.serviceText);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("beacon");
        serviceText.setText(name+"11");

    }

}
