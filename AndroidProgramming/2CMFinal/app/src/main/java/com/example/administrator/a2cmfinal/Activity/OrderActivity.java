package com.example.administrator.a2cmfinal.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.R;

public class OrderActivity extends AppCompatActivity {

    String user_id;
    String test1,test2,test3,test4,test5,test6,test7,test8,test9,test10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //로그인 테스트
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        user_id = pref.getString("id","");
        Toast.makeText(OrderActivity.this, user_id, Toast.LENGTH_SHORT).show();

        final Intent intent = getIntent();
        test1 = intent.getExtras().getString("syrup");
        test2 = intent.getExtras().getString("xid2");
        test3 = intent.getExtras().getString("size");
        test4 = intent.getExtras().getString("xid1");
        test5 = intent.getExtras().getString("shot");
        test6 = intent.getExtras().getString("xid3");
        test7 = intent.getExtras().getString("count");
        test8 = intent.getExtras().getString("mid");
        test9 = intent.getExtras().getString("price");
        test10 = intent.getExtras().getString("sid");


        Log.i("mylog",test1+"-"+test2+"-"+test3+"-"+test4+"-"+test5+"-"+test6+"-"+test7+"-"+test8+"-"+test9+"-"+user_id+"-"+test10);



    }
}
