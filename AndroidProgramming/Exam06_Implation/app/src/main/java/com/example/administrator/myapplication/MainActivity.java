package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;//xml파일을 객체로 만듬

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);//itemContainer 추가
        layoutInflater = getLayoutInflater();

        fillItems();

    }

    public void fillItems() {
        int[] arrImage={
                R.drawable.light1,
                R.drawable.light2,
                R.drawable.light3,
                R.drawable.light4,
                R.drawable.light5
        };

        String[] arrTitle = {
                "인테리어 조명1",
                "인테리어 조명1",
                "인테리어 조명1",
                "인테리어 조명1",
                "인테리어 조명1"
        };

        String[] arrContent = {
                "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다.",
                "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다.",
                "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다.",
                "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다.",
                "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."
        };

        for (int i=0; i<arrImage.length; i++) {
            //inplation
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.light_item, null);//xml의 제일 상위 Layout가 리턴됨.

            //Data Setting
            ImageView lightImage = (ImageView) itemLayout.findViewById(R.id.lightImage);
            lightImage.setImageResource(arrImage[i]);

            TextView lightTitle = (TextView) itemLayout.findViewById(R.id.lightTitle);
            lightTitle.setText(arrTitle[i]);

            TextView lightContent = (TextView) itemLayout.findViewById(R.id.lightContent);
            lightContent.setText(arrContent[i]);

            //itemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }
    }
}
