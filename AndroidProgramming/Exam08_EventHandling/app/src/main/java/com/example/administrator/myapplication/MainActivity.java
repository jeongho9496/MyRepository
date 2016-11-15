package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;
    private Button secondBtn;
    private List<Light> list;
    private ImageView imageLarge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLarge = (ImageView)findViewById(R.id.imageLarge);

        lightList = (ListView)findViewById(R.id.lightList); //초기화 작업
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageResource(light.getImageLarge());
            }
        });

        secondBtn = (Button)findViewById(R.id.secondBtn);
       //secondBtn.setOnClickListener(onClickListener);

        fillItems();

       secondBtnClick(secondBtn);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() { //View.OnClickListener 필드 선언
        @Override
        public void onClick(View v) {

        }
    };

    private void secondBtnClick(Button secondBtn) {
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), SecondActivity.class);//현재 화면을 지정한 화면으로 이동하고 싶다.(intent = 의도)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void fillItems() {
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large,"인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large,"인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large,"인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large,"인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1, R.drawable.light1_large,"인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large,"인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large,"인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large,"인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));


        LightAdapter lightAdapter = new LightAdapter(this); //this - MainActivity 가 들어감.
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }

    public void onClickFirstButton(View view){
        Intent intent = new Intent(this, SecondActivity.class);//현재 화면을 지정한 화면으로 이동하고 싶다.(intent = 의도)
        startActivity(intent);
    }
}
