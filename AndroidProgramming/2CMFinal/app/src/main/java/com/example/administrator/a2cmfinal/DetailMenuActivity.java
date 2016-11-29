package com.example.administrator.a2cmfinal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.a2cmfinal.dto.Menu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailMenuActivity extends AppCompatActivity {

    TextView countText, priceText, nameText, contentText, hot_iced;
    ImageView minusBtn, plusBtn, menuImage;
    int count = 1;

    int price;

    int totalPrice;

    int mid;

    String size;

    String extra;

    Spinner sizeSpinner, extraSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        Intent intent = getIntent();

        mid = intent.getIntExtra("menuDetail",0);

        countText = (TextView)findViewById(R.id.countText);

        minusBtn = (ImageView)findViewById(R.id.minusBtn);

        plusBtn = (ImageView)findViewById(R.id.plusBtn);

        priceText = (TextView)findViewById(R.id.priceText);

        nameText = (TextView)findViewById(R.id.nameText);

        contentText = (TextView)findViewById(R.id.contentText);

        hot_iced = (TextView)findViewById(R.id.hot_iced);

        menuImage = (ImageView)findViewById(R.id.menuImage);

        sizeSpinner = (Spinner)findViewById(R.id.sizeSpinner);

        ArrayAdapter sizeAdapter = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_dropdown_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size = (String) sizeSpinner.getSelectedItem();
                Log.i("mylog extraSpinner",size);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        extraSpinner = (Spinner)findViewById(R.id.extraSpinner);

        ArrayAdapter extraAdapter = ArrayAdapter.createFromResource(this, R.array.extra, android.R.layout.simple_spinner_dropdown_item);
        extraAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        extraSpinner.setAdapter(extraAdapter);

        extraSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                extra = (String) extraSpinner.getSelectedItem();
                Log.i("mylog extraSpinner",extra);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        menuItems(mid);

        countText.setText(""+count);

        Log.i("mylog Spinner",extra+","+size);



    }

    private void menuItems(final int mid) {
        AsyncTask<Void, Void, Menu> asyncTask = new AsyncTask<Void, Void, Menu>() {
            ProgressDialog asyncDialog = new ProgressDialog(DetailMenuActivity.this);
            @Override
            protected void onPreExecute() {
                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                asyncDialog.setMessage("로딩중입니다..");
                asyncDialog.show();
            }
            @Override
            protected Menu doInBackground(Void... params) {
                Menu menu = null;
                try{
                    URL url = new URL("http://192.168.0.22:8080/myweb/detailMenuAndroid?mid="+mid);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();// url.openConnection() 연결 객체 얻음
                    conn.connect();//연결
                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {//200 이면 정상
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);  // 읽기 객체 생성
                        BufferedReader br = new BufferedReader(reader);//성능 향상위해 사용.
                        String strJson = "";
                        while (true) {
                            String data = br.readLine();
                            if (data == null) break;
                            strJson += data;
                        }
                        br.close();
                        reader.close();
                        is.close();
                        menu = parseJson(strJson);
                        Log.i("mylog", strJson);
                    }
                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog",e.getMessage());
                }

                return menu;
            }

            @Override
            protected void onPostExecute(Menu menu) {
                super.onPostExecute(menu);
                if (!menu.getHot_ice().equals("없음")){
                    getSupportActionBar().setTitle(menu.getMname()+" "+menu.getHot_ice());
                    if (menu.getHot_ice().equals("HOT")){
                        hot_iced.setTextColor(ContextCompat.getColor(DetailMenuActivity.this,android.R.color.holo_red_light));
                        hot_iced.setText(menu.getHot_ice());
                    } else {
                        hot_iced.setTextColor(ContextCompat.getColor(DetailMenuActivity.this,android.R.color.holo_blue_dark));
                        hot_iced.setText(menu.getHot_ice());
                    }
                } else {
                    getSupportActionBar().setTitle(menu.getMname());
                    hot_iced.setText(null);
                }

                nameText.setText(menu.getMname());
                menuImage.setImageBitmap(menu.getImage());
                contentText.setText(menu.getMcontents());
                price = menu.getMprice();
                totalPrice = price;
                priceText.setText(String.format("%,d",price)+" 원");
                asyncDialog.dismiss();
            }
        };
        asyncTask.execute();
    }

    private Menu parseJson(String strJson) {
        Menu menu = new Menu();

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            menu.setMid(jsonObject.getInt("mid"));
            menu.setMname(jsonObject.getString("mname"));
            menu.setHot_ice(jsonObject.getString("hot_ice"));
            menu.setMprice(jsonObject.getInt("mprice"));
            menu.setMcontents(jsonObject.getString("mcontents"));
            menu.setImage(getBitmap(jsonObject.getString("msavedfile")));
            menu.setSid(jsonObject.getString("sid"));
        } catch (JSONException e){
            Log.i("mylog",e.getMessage());
        }
        return menu;
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;

        try {
            //URL url = new URL("http://192.168.0.3:8080/myweb/getImage?fileName=" + fileName);//get방식 light01.png
            URL url = new URL("http://192.168.0.22:8080/myweb/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is); //inputStream을 가지고 비트맵을 만들어줌.
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("myLog total", e.getMessage());
        }
        return bitmap;
    }

    public void onMinusClick(View v){
        if (count>1){
            count--;
            totalPrice -= price;
        } else {
            totalPrice = price;
        }
        countText.setText(""+count);
        priceText.setText(String.format("%,d",totalPrice)+" 원");
    }

    public void onPlusClick(View v){
        if (count>0){
        count++;
        totalPrice += price;
        }
        countText.setText(""+count);
        priceText.setText(String.format("%,d",totalPrice)+" 원");
    }
}
