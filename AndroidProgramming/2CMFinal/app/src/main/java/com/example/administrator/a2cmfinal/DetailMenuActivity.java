package com.example.administrator.a2cmfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailMenuActivity extends AppCompatActivity {

    TextView midText;
    int mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        midText = (TextView)findViewById(R.id.midText);

        Intent intent = getIntent();
        mid = intent.getIntExtra("MenuDetail",0);

        midText.setText(""+mid);

    }
}
