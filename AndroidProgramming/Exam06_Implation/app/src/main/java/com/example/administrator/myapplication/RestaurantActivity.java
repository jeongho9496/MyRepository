package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {

    private LinearLayout bistroContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bistroContainer = (LinearLayout)findViewById(R.id.bistroContainer);
        layoutInflater = getLayoutInflater();

        fillItems();

    }

    public void fillItems(){
        int[] arrImage={
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05,
                R.drawable.food06
        };

        String[] arrTitle={
                "삼겹살",
                "양념장어구이",
                "소금장어구이",
                "비빔밥",
                "볶음밥",
                "떡볶이"
        };

        String[] arrPrice={
                "12,000 WON",
                "34,000 WON",
                "34,000 WON",
                "7,000 WON",
                "7,000 WON",
                "5,000 WON",
        };

        String[] arrContent={
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."

        };

        for (int i =0 ; i < arrImage.length ; i++) {
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.bistro_item, null);

            ImageView bistroImage;
            TextView bistroTitle;
            TextView bistroPrice;
            TextView bistroContent;

            bistroImage = (ImageView) itemLayout.findViewById(R.id.bistroImage);
            bistroImage.setImageResource(arrImage[i]);

            bistroTitle = (TextView) itemLayout.findViewById(R.id.bistroTitle);
            bistroTitle.setText(arrTitle[i]);

            bistroPrice = (TextView) itemLayout.findViewById(R.id.bistroPrice);
            bistroPrice.setText(arrPrice[i]);

            bistroContent = (TextView) itemLayout.findViewById(R.id.bistroContent);
            bistroContent.setText(arrContent[i]);

            bistroContainer.addView(itemLayout);
        }

    }
}
