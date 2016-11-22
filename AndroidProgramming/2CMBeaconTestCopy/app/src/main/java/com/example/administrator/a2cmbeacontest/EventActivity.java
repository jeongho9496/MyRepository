package com.example.administrator.a2cmbeacontest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    TextView contentText , beaconText, sidText;
    ImageView eventImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        contentText = (TextView)findViewById(R.id.contentText);
        beaconText = (TextView)findViewById(R.id.beaconText);
        sidText = (TextView)findViewById(R.id.sidText);

        Intent intent = getIntent();

        String beacon = intent.getExtras().getString("sbeacon");
        beaconText.setText("sbeacon: " + beacon);

        String sid = intent.getExtras().getString("sid");
        sidText.setText("sid: " + sid);

        String content = intent.getExtras().getString("content");
       /*final String image = intent.getExtras().getString("image");
        contentText.setText("content: " + content);*/

        eventImage = (ImageView)findViewById(R.id.eventImage);

        /*AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap bitmap = getBitmap(image);
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                eventImage.setImageBitmap(bitmap);
            }
        };
        asyncTask.execute();*/

        storeItems(beacon);

    }

    private void storeItems(final String beacon) {
        AsyncTask<Void, Void, Store> asyncTask = new AsyncTask<Void, Void, Store>() {
            @Override
            protected Store doInBackground(Void... params) {
                Store store = null;
                try {
                    //URL url = new URL("http://192.168.0.58:8080/myweb/testBeacon?sbeacon="+beacon);
                    URL url = new URL("http://192.168.0.3:8080/myweb/testBeacon?sbeacon="+beacon);
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
                        store = parseJson(strJson);
                        Log.i("mylog", strJson);
                    }
                    conn.disconnect();
                } catch (Exception e) {

                }
                return store;
            }
            @Override
            protected void onPostExecute(Store store) {

                contentText.setText("받아온 데이터 값 카페 주소 : "+store.getSaddr()+" 카페이름 : "+store.getSname()+" 카페 지점명 : "+ store.getSlocal()+
                        " 카페 전화 : "+store.getStel()+" OPEN : "+store.getSopen()+" CLOSED : "+store.getSclosed());
            }
        };
        asyncTask.execute();
    }

    private Store parseJson(String strJson) {
        Store store = new Store();

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            store.setSname(jsonObject.getString("sname"));
            store.setSlocal(jsonObject.getString("slocal"));
            store.setSaddr(jsonObject.getString("saddr"));
            store.setStel(jsonObject.getString("stel"));
            store.setSopen(jsonObject.getString("sopen"));
            store.setSclosed(jsonObject.getString("sclosed"));
            store.setSbeacon(jsonObject.getString("sbeacon"));
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return store;
    }


    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;

        try {
            URL url = new URL("http://192.168.0.58:8080/myandroid/getImage?fileName=" + fileName);//get방식 light01.png
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is); //inputStream을 가지고 비트맵을 만들어줌.
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("myLog", e.getMessage());
        }
        return bitmap;
    }

}
