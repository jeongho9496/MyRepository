package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

    private Button bistroBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLarge = (ImageView) findViewById(R.id.imageLarge);
        bistroBtn = (Button) findViewById(R.id.bistroBtn);

        bistroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        lightList = (ListView) findViewById(R.id.lightList); //초기화 작업
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Light light = (Light) lightAdapter.getItem(position);    //adapter로 얻기

                AsyncTask<Void,Void,Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... params) {
                        Bitmap bitmap = getBitmap(light.getImageLargeFileName());
                        return bitmap;
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap);
                    }
                };
                asyncTask.execute();
            }
        });

        fillItems();
        testAsyncTask();

    }


    public void testAsyncTask() {
        Log.i("mylog", "1: " + Thread.currentThread().getName());
        //1116
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {//제네릭 타입으로 어떠한 타입도 받지 않을때 'Void'를 붙힌다.(Void 는 하나의 참조 타입)
            // <Void(doInBackground의 매개변수 값 타입을 정함), Void(onProgressUpdate의 매개변수 값 지정), Void(doInbackground의 리턴 타입을 정함.->opPostExecute의 매개 타입도 변함.)>
            @Override
            protected String doInBackground(String... params) { //작업스레드를 실행. Void -> 참조타입(작업의 결과가 없을때 사용.)
                Log.i("mylog", "2: " + Thread.currentThread().getName()); //Thread.currentThread().getName() 현재 실행되고 있는 스레드 이름
                Log.i("mylog", params[0]);
                Log.i("mylog", params[1]);
                Log.i("mylog", params[2]);

                for (int i = 1; i <= 100; i++) {
                    if (i == 1) {
                        publishProgress(1);
                    } else if (i == 50) {
                        publishProgress(50);
                    } else if (i == 100) {
                        publishProgress(100);
                    }
                }

                return "작업스레드 결과";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {//메인 스레드 에서 실행 ui변경 코드 올수 있음
                Log.i("mylog", "3: " + Thread.currentThread().getName());
                Log.i("mylog", "작업 진행 정도 : " + values[0]);
            }

            @Override
            protected void onPostExecute(String aVoid) {  //doInBackground가(작업 스레드) 끝났을때 자동으로 실행 메인스레드를 실행 UI변경 코드 를 작성할 수 있음. ui변경 코드 올수 있음.
                super.onPostExecute(aVoid);
                Log.i("mylog", "4: " + Thread.currentThread().getName());
                Log.i("mylog", aVoid);
            }
        };

        asyncTask.execute("실행 매개 값", "실행 매개 값2", "실행 매개 값3");
    }

    public void fillItems() {
        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {
            @Override
            protected List<Light> doInBackground(Void... params) {
                List<Light> list = null;
                try {
                    URL url = new URL("http://192.168.0.3:8080/myandroid/lightList");
                    //URL url = new URL("http://192.168.0.58:8080/myandroid/lightList");
                    //thread생성(MainThread에서 네트워크 통신을 시키면 화면의 UI생성, 변경, 이벤트 처리를 못한다. -> ANR 생성)
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
                        list=parseJson(strJson);
                        Log.i("mylog", strJson);

                    }

                    conn.disconnect();
                } catch (Exception e){
                    Log.i("mylog",e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                lightAdapter = new LightAdapter(MainActivity.this);
                lightAdapter.setList(lights);
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
            }
        };
        asyncTask.execute();


    }


    private List<Light> parseJson(String strJson) {

        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);//매개변수의 배열'[]'을 받아 parsing (<-> 객체이면'{}' JSONObject로 파싱한다.)
            for (int i = 0; i < jsonArray.length(); i++) {   //배열([]) 안에 있는 데이터 길이 만큼 for문을 돌린다.
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Light light = new Light();

                light.setImage(getBitmap(jsonObject.getString("image")));//light01.png
                if (i == 0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                /*light.setImageFileName(jsonObject.getString("image"));*/  //문자열로 되있는(json) 파일이름 을 얻어옴
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return list;
    }

    public Bitmap getBitmap(String fileName) {//작업스레드에서 실행 되야함.
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
