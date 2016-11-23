package com.example.administrator.a2cmbeacontest;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.a2cmbeacontest.dto.Store;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EventActivity extends AppCompatActivity {

    TextView contentText , beaconText, sidText;
    ImageView eventImage;
    Store storeTrans;//객체로 정보 페이지에 넘길때 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent = getIntent();
        String beacon = intent.getExtras().getString("sbeacon");
        String content = intent.getExtras().getString("content");
        String sid = intent.getExtras().getString("sid");


        contentText = (TextView)findViewById(R.id.contentText);
        beaconText = (TextView)findViewById(R.id.beaconText);
        sidText = (TextView)findViewById(R.id.sidText);

        beaconText.setText("sbeacon: " + beacon);
        sidText.setText("sid: " + sid);


       final String image = intent.getExtras().getString("image");
        contentText.setText("content: " + content);

        eventImage = (ImageView)findViewById(R.id.eventImage);

        AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {

            ProgressDialog asyncDialog = new ProgressDialog(EventActivity.this);

            @Override
            protected void onPreExecute() {
                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                asyncDialog.setMessage("로딩중입니다..");
                asyncDialog.show();
            }

            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap bitmap = getBitmap(image);
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                eventImage.setImageBitmap(bitmap);
                asyncDialog.dismiss();
            }
        };
        asyncTask.execute();

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(Integer.parseInt(beacon));

        storeItems(sid);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.store_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_button) {
            Intent intent = new Intent(getApplicationContext(), StoreInfoActivity.class);
            intent.putExtra("store",storeTrans);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void storeItems(final String sid) {
        AsyncTask<Void, Void, Store> asyncTask = new AsyncTask<Void, Void, Store>() {
            @Override
            protected Store doInBackground(Void... params) {
                Store store = null;
                try {
                    URL url = new URL("http://192.168.0.58:8080/myweb/storeAndroid?sid="+sid);
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
                getSupportActionBar().setTitle(store.getSname()+" "+store.getSlocal());
                storeTrans = store;//넘길 객체에 저장
            }
        };
        asyncTask.execute();
    }


    private Store parseJson(String strJson) {
        Store store = new Store();

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            store.setSid(jsonObject.getString("sid"));
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
            URL url = new URL("http://192.168.0.58:8080/myweb/event/showPhoto?esavedfile=" + fileName);//get방식 light01.png
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
