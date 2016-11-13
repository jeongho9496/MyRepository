package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       lightList = (ListView)findViewById(R.id.lightList); //초기화 작업

        fillItems();

    }

    public void fillItems() {
        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, "인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, "인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, "인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, "인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2, "인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3, "인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4, "인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5, "인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));


        LightAdapter lightAdapter = new LightAdapter(this); //this - MainActivity 가 들어감.
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }
}
