package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {//하위 호환성을 위해 Activity상속이 아닌 AppCompatActivity를 상속 받는다.
    //11.08
    //onCreate - 자동으로 호출됨(LifeCycleMethod : onCreate(), onDestroy()...) 객체의 생성부터 소멸까지 자동으로 실행 On : ~할때
    @Override
    protected void onCreate(Bundle savedInstanceState) {//AppCompatActivity에 있는 onCreate 재정의, 반드시 실행 되야함.화면 객체 초기화시 사용
        super.onCreate(savedInstanceState);     //부모가 가지고 있는 onCreate 메소드를 호출, 부모의 코드가 반드시 실행이 되어야함.
        setContentView(R.layout.activity_main);//xml 파일을 받아 View객체를 만듬. res는 번호(식별번호)로 관리
        Log.i("mylog","onCreate()");//Log.i("검색할 log명","log 내용");

        /*Button btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    protected void onStart() {//서비스 실행할 때 사용
        super.onStart();
        Log.i("mylog", "onStart()");
    }

    @Override
    protected void onResume() {// 사용자가 사용 할 때 사용, 일시정지된 상태(onPause())를 다시 사용자가 사용할때 사용.
        super.onResume();
        Log.i("mylog", "onResume()");
    }

    //화면이 보여지는 부분
    //----------------------------------------------------------------------------------------------------------------------------
    //화면이 사라지는 부분
    @Override
    protected void onPause() {//사용자가 화면을 사용할 수 없는 상태때 사용.(ex. 음악 일시 정지.), 메인 엑티비티의 일부분만 중지 할 시 사용(ex. dialog 띄울때)
        super.onPause();
        Log.i("mylog", "onPause()");
    }

    @Override
    protected void onStop() {//서비스를 중지할 때 사용.
        super.onStop();
        Log.i("mylog", "onStop()");
    }

    @Override
    protected void onDestroy() {
        //종료 할 때 실행 되는 LifeCycleMethod
        super.onDestroy();

        Log.i("mylog", "onDestroy()");
    }

    public void onClickBtnSecond(View view){
        Log.i("mylog","onClickBtnSecond()");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClickBtnThird(View view){
        Log.i("mylog","onClickBtnThird()");
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
