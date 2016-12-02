package com.example.administrator.a2cmfinal.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.a2cmfinal.R;
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
    int count = 1;//증가 감소
    int price;  //개당금액
    int totalPrice; //한 종류 총 합계금액
    int mid;//extra로 받아온 메뉴 아이디
    int xid1;//옵션아이디
    int xid2;
    int xid3;
    String size, syrup, shot, sid;

    Spinner sizeSpinner, syrupSpinner, shotSpinner;

    Button btnSingleOrder, btnAddMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        final Intent intent = getIntent();

        mid = intent.getIntExtra("menuDetail",0);

        countText = (TextView)findViewById(R.id.textCount);
        minusBtn = (ImageView)findViewById(R.id.btnMinus);
        plusBtn = (ImageView)findViewById(R.id.btnPlus);
        priceText = (TextView)findViewById(R.id.textPrice);
        nameText = (TextView)findViewById(R.id.textName);
        contentText = (TextView)findViewById(R.id.contentText);
        hot_iced = (TextView)findViewById(R.id.hot_iced);
        menuImage = (ImageView)findViewById(R.id.menuImage);
        sizeSpinner = (Spinner)findViewById(R.id.sizeSpinner);
        syrupSpinner = (Spinner)findViewById(R.id.syrupSpinner);

        shotSpinner = (Spinner)findViewById(R.id.shotSpinner);

        ArrayAdapter extraAdapter = ArrayAdapter.createFromResource(this, R.array.syrup, android.R.layout.simple_spinner_dropdown_item);
        extraAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        syrupSpinner.setAdapter(extraAdapter);

        syrupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                syrup = (String) syrupSpinner.getSelectedItem();
                switch (position){
                    case 1:
                        xid2=11;
                        break;
                    case 2:
                        xid2=12;
                        break;
                    case 3:
                        xid2=13;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnAddMenu = (Button)findViewById(R.id.btnAddMenu);
        menuItems(mid);

        btnSingleOrder = (Button)findViewById(R.id.btnSingleOrder);
        btnSingleOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrder = new Intent(DetailMenuActivity.this, OrderActivity.class);
                Log.i("mylog extraSpinner", syrup+" xid :"+xid2);
                intentOrder.putExtra("syrup", syrup);
                intentOrder.putExtra("xid2",""+xid2);
                intentOrder.putExtra("size", size);
                intentOrder.putExtra("xid1",""+xid1);
                intentOrder.putExtra("shot", shot);
                intentOrder.putExtra("xid3",""+xid3);
                intentOrder.putExtra("count",""+count);
                intentOrder.putExtra("mid",""+mid);
                intentOrder.putExtra("price",""+totalPrice);
                intentOrder.putExtra("sid",sid);
                startActivity(intentOrder);
            }
        });

        countText.setText(""+count);


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
                    URL url = new URL("http://192.168.0.58:8080/myweb/detailMenuAndroid?mid="+mid);
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
                if (!menu.getHot_ice().equals(" ")){
                    getSupportActionBar().setTitle(menu.getMname()+" "+menu.getHot_ice());
                    if (menu.getHot_ice().equals("HOT")){
                        hot_iced.setTextColor(ContextCompat.getColor(DetailMenuActivity.this,android.R.color.holo_red_light));
                        hot_iced.setText(menu.getHot_ice());
                    } else if (menu.getHot_ice().equals("ICE")){
                        hot_iced.setTextColor(ContextCompat.getColor(DetailMenuActivity.this,android.R.color.holo_blue_dark));
                        hot_iced.setText(menu.getHot_ice());
                    }

                    ArrayAdapter shotAdapter = ArrayAdapter.createFromResource(DetailMenuActivity.this, R.array.shot, android.R.layout.simple_spinner_dropdown_item);
                    shotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    shotSpinner.setAdapter(shotAdapter);

                    shotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            shot = (String) shotSpinner.getSelectedItem();
                            Log.i("mylog extraSpinner",shot);
                            switch (position){
                                case 1:
                                    xid3=21;
                                    break;
                                case 2:
                                    xid3=22;
                                    break;
                                case 3:
                                    xid3=23;
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    ArrayAdapter sizeAdapter = ArrayAdapter.createFromResource(DetailMenuActivity.this, R.array.size, android.R.layout.simple_spinner_dropdown_item);
                    sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sizeSpinner.setAdapter(sizeAdapter);

                    sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            size = (String) sizeSpinner.getSelectedItem();
                            Log.i("mylog extraSpinner",size);
                            switch (position){
                                case 0:
                                    xid1=1;
                                    break;
                                case 1:
                                    xid1=2;
                                    break;
                                case 2:
                                    xid1=3;
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else {
                    getSupportActionBar().setTitle(menu.getMname());
                    hot_iced.setText(null);
                }

                nameText.setText(menu.getMname());
                menuImage.setImageBitmap(menu.getImage());
                contentText.setText(menu.getMcontents());
                price = menu.getMprice();
                totalPrice = price;
                sid = menu.getSid();
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
            URL url = new URL("http://192.168.0.58:8080/myweb/getImage?fileName=" + fileName);
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
