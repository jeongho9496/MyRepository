package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView bistroList;
    private List<Bistro> list = new ArrayList<>();
    private ImageView imageLarge;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bistroList = (ListView)findViewById(R.id.bistroList);
        fillItems();

        imageLarge = (ImageView)findViewById(R.id.imageLarge);

        bistroList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bistro bistro = list.get(position);
                imageLarge.setImageResource(bistro.getImageLarge());
                Toast.makeText(getApplicationContext(),list.get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void fillItems(){

        list.add(new Bistro(R.drawable.food01, R.drawable.food01_large, "삼겹살", "12,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro(R.drawable.food02, R.drawable.food02_large,"양념장어구이", "34,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro(R.drawable.food03, R.drawable.food03_large,"소금장어구이", "34,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro(R.drawable.food04, R.drawable.food04_large,"비빔밥", "7,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro(R.drawable.food05, R.drawable.food05_large,"볶음밥", "7,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro(R.drawable.food06, R.drawable.food06_large,"떡볶이", "5,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));

        BistroAdapter bistroAdapter = new BistroAdapter(this);
        bistroAdapter.setList(list);

        bistroList.setAdapter(bistroAdapter);

    }
}
