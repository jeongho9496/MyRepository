package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowToast(View view) {
        Toast.makeText(getApplicationContext(),"안녕",Toast.LENGTH_SHORT).show();
    }

    public void onClickShowMessageDialog(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("오늘은 잔소리를 들었습니다.\n졸리네 ~ ZZZ")
                .setPositiveButton("확인", null)
                .setNegativeButton("이건",null)
                .setNeutralButton("뭐",null)
                .show();
    }

    public void onClickShowYesNoDialog(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("오늘은 잔소리를 들었습니다.\n졸리네 ~ ZZZ")
                .setPositiveButton("아니오", new DialogInterface.OnClickListener() {//dialog 의 onclicklistener
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아님",Toast.LENGTH_SHORT).show();
                    }
                })//오른쪽
                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"맞음",Toast.LENGTH_SHORT).show();
                    }
                })//왼쪽
                .show();
    }

    public void onClickShowCustomDialog(View view){
        final View content = getLayoutInflater().inflate(R.layout.light_dialog, null);
        Button btnOK = (Button)content.findViewById(R.id.btnOK);
        Button btnCancel = (Button)content.findViewById(R.id.btnCancel);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"이걸 왜삼? ㅋㅋ",Toast.LENGTH_SHORT).show();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"나가 죽어 --!",Toast.LENGTH_SHORT).show();
            }
        });

        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setView(content)
                .show();
    }
}
