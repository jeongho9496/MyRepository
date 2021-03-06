package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView bistroList;

    private ImageView imageLarge;

    private BistroAdapter bistroAdapter;

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
                final Bistro bistro = (Bistro)bistroAdapter.getItem(position);
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(bistro.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);
                            }
                        });

                    }
                };
                thread.start();

                Toast.makeText(getApplicationContext(),bistro.getTitle(),Toast.LENGTH_SHORT).show();
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

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.58:8080/myandroid/bistroList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";
                        while (true){
                            String data = br.readLine();
                            if (data == null)break;
                            strJson += data;
                        }
                        br.close(); reader.close(); is.close();
                        Log.i("mylog",strJson);

                        final List<Bistro> list = parseJson(strJson);
                        bistroList.post(new Runnable() {
                            @Override
                            public void run() {
                                bistroAdapter = new BistroAdapter(SecondActivity.this);
                                bistroAdapter.setList(list);
                                bistroList.setAdapter(bistroAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                    }
                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog",e.getMessage());
                }
            }
        };

        thread.start();

    }

    private List<Bistro> parseJson(String strJson) {
        List<Bistro> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);//[
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);//{}

                Bistro bistro = new Bistro();
                bistro.setImage(getBitmap(jsonObject.getString("image")));
                if ( i==0 ){
                    bistro.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                bistro.setImageFileName(jsonObject.getString("image"));
                bistro.setImageLargeFileName(jsonObject.getString("imageLarge"));
                bistro.setTitle(jsonObject.getString("title"));
                bistro.setPrice(jsonObject.getString("price"));
                bistro.setContent(jsonObject.getString("content"));
                list.add(bistro);
            }
        } catch (JSONException e) {
            Log.i("mylog",e.getMessage());
        }

        return list;
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;

        try {
            URL url = new URL("http://192.168.0.58:8080/myandroid/getImage?fileName="+fileName);
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
