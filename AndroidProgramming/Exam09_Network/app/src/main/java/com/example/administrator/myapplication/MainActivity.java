package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;

    private ImageView imageLarge;

    private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLarge = (ImageView)findViewById(R.id.imageLarge);

        lightList = (ListView)findViewById(R.id.lightList); //초기화 작업
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Light light = (Light)lightAdapter.getItem(position);    //adapter로 얻기
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(light.getImageLargeFileName());   //지역변수가 익명객체 안에서 사용될때 변수에 final을 붙혀야 된다.
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);//큰이미지를 얻어야 됨. UI변경이 이루어 지므로 post에서 runnable로 메인 스레드에서 변경될 수 있도록 요청한다.
                            }
                        });

                    }
                };
                thread.start();
            }
        });

        fillItems();

    }


    public void fillItems() {
        //http통신코드 -> 비용이 적음
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.58:8080/myandroid/lightList");
                    //thread생성(MainThread에서 네트워크 통신을 시키면 화면의 UI생성, 변경, 이벤트 처리를 못한다. -> ANR 생성)
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();// url.openConnection() 연결 객체 얻음
                    conn.connect();//연결

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){//200 이면 정상
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);  // 읽기 객체 생성
                        BufferedReader br =  new BufferedReader(reader);//성능 향상위해 사용.
                        String strJson = "";
                        while (true){
                            String data = br.readLine();
                            if (data == null) break;
                            strJson += data;
                        }
                        br.close(); reader.close(); is.close();
                        Log.i("mylog",strJson);

                        final List<Light> list = parseJson(strJson);
                        lightList.post(new Runnable() { //post = mainthread가 화면구성단을 실행 하게끔 Runnable로 넘겨준다(메인 메소드가 만든 어떤 뷰가 와도 상관 없음.)
                            @Override
                            public void run() {

                                lightAdapter = new LightAdapter(MainActivity.this);
                                lightAdapter.setList(list);
                                lightList.setAdapter(lightAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());

                            }
                        });

                    }

                    conn.disconnect();//연결 끊음
                } catch (Exception e) {
                    Log.i("mylog",e.getMessage());
                }
            }

        };
        thread.start();

    }

    private List<Light> parseJson(String strJson) {

        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);//매개변수의 배열'[]'을 받아 parsing (<-> 객체이면'{}' JSONObject로 파싱한다.)
            for (int i=0; i<jsonArray.length(); i++){   //배열([]) 안에 있는 데이터 길이 만큼 for문을 돌린다.
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Light light = new Light();

                light.setImage(getBitmap(jsonObject.getString("image")));
                if (i==0){
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageFileName(jsonObject.getString("image"));  //문자열로 되있는(json) 파일이름 을 얻어옴
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog",e.getMessage());
        }
        return list;
    }

    public Bitmap getBitmap(String fileName){//작업스레드에서 실행 되야함.
        Bitmap bitmap = null;

        try {
            URL url = new URL("http://192.168.0.58:8080/myandroid/getImage?fileName="+fileName);//get방식
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is); //inputStream을 가지고 비트맵을 만들어줌.
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("myLog",e.getMessage());
        }
        return bitmap;
    }

}
