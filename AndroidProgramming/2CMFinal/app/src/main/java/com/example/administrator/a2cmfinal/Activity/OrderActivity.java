package com.example.administrator.a2cmfinal.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.adapter.OrderAdapter;
import com.example.administrator.a2cmfinal.dto.Menu;
import com.example.administrator.a2cmfinal.dto.OrderMenu;
import com.example.administrator.a2cmfinal.dto.Result;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    String user_id;
    String syrup,size,shot,count,mid,price,sid;
    int sizePrice, syrupPrice, shotPrice, totalPrice;

    OrderMenu orderMenu;

    ListView orderList;
    OrderAdapter orderAdapter;
    RadioGroup howpayGroup;
    RadioButton btnCash;
    RadioButton btnCard;
    RadioButton btnPayco;
    String howpay;
    TextView orderTotal;

    Button btnOrder;

    List<OrderMenu> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //로그인 테스트
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

        final Intent intent = getIntent();
        user_id = pref.getString("id","");

        orderMenu = (OrderMenu) intent.getSerializableExtra("orderMenu");

        btnOrder = (Button)findViewById(R.id.btnOrder);

        list.add(orderMenu);

        orderList = (ListView)findViewById(R.id.orderList);
        orderAdapter = new OrderAdapter(getApplicationContext());

        orderAdapter.setList(list);
        orderList.setAdapter(orderAdapter);


        howpayGroup = (RadioGroup)findViewById(R.id.howpayGroup);
        btnCash = (RadioButton)findViewById(R.id.btnCash);
        btnCard = (RadioButton)findViewById(R.id.btnCard);
        btnPayco = (RadioButton)findViewById(R.id.btnPayco);
        btnCash.setChecked(true);

        Log.i("order1:",orderMenu.getHot_ice());
        Log.i("order2:",orderMenu.getSid());
        Log.i("order4:",orderMenu.getMname());
        Log.i("order5:",orderMenu.getShot());
        Log.i("order6:",orderMenu.getSize());
        Log.i("order7:",orderMenu.getSyrup());
        Log.i("order8:",""+orderMenu.getMid());
        Log.i("order9:",""+orderMenu.getMprice());
        Log.i("order10:",""+orderMenu.getShotPrice());
        Log.i("order11:",""+orderMenu.getSizePrice());
        Log.i("order12:",""+orderMenu.getSyrupPrice());

        orderTotal = (TextView)findViewById(R.id.orderTotal);
        totalPrice = orderMenu.getMprice()+orderMenu.getShotPrice()+orderMenu.getSizePrice()+orderMenu.getSyrupPrice();
        orderTotal.setText(String.format("%,d",totalPrice)+" 원");
        Log.i("order13:",""+totalPrice);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = howpayGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(id);
                howpay = rb.getText().toString();
                orderConn(orderMenu, howpay, totalPrice,user_id);

            }
        });




    }

    private void orderConn(final OrderMenu orderMenu, final String howpay, final int totalPrice, final String user_id) {
        AsyncTask<String, Void, Result> asyncTask = new AsyncTask<String, Void, Result>() {
            ProgressDialog asyncDialog = new ProgressDialog(OrderActivity.this);
            @Override
            protected void onPreExecute() {
                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                asyncDialog.setMessage("결제중입니다..");
                asyncDialog.show();
            }

            @Override
            protected Result doInBackground(String... params) {
                Result result = null;
                try {
                    URL url = new URL("http://192.168.0.58:8080/myweb/orderTotalAndroid");

                    JSONObject body = new JSONObject();
                    body.put("howpay",howpay);
                    body.put("sid",orderMenu.getSid());
                    body.put("user_id", user_id);
                    body.put("ogtotalprice",totalPrice);
                    body.put("mid",orderMenu.getMid());
                    body.put("ordercount",orderMenu.getCount());
                    body.put("orderSize",orderMenu.getSize());
                    body.put("orderSyrup",orderMenu.getSyrup());
                    body.put("orderShot",orderMenu.getShot());

                    Log.i("mylog", body.toString());

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(15000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                    BufferedWriter writer = new BufferedWriter(osw);
                    writer.write(getPostDataString(body));

                    writer.flush();
                    writer.close();
                    os.close();

                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK){
                        InputStreamReader isp = new InputStreamReader(conn.getInputStream());
                        BufferedReader br = new BufferedReader(isp);
                        //StringBuffer sb = new StringBuffer("");
                        String strJson = "";

                        /*while ((line = br.readLine()) != null) {
                            sb.append(line);
                            break;
                        }*/
                        while (true) {
                            String data = br.readLine();
                            if (data == null) break;
                            strJson += data;
                        }

                        br.close();
                        isp.close();
                        result = parseJson(strJson);
                    }
                } catch (Exception e) {
                    Log.i("mylog login",e.getMessage());
                }


                return result;
            }

            @Override
            protected void onPostExecute(Result result) {
                super.onPostExecute(result);
                Log.i("mylog",result.getResult());
                if (result.getResult().equals("WRITE_SUCCESS")){
                    Toast.makeText(getApplicationContext(),"결제 완료하였습니다.",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"결제 실패하였습니다.",Toast.LENGTH_SHORT).show();
                }

                asyncDialog.dismiss();
            }

        };
        asyncTask.execute();

    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    private Result parseJson(String strJson) {

        Result result = new Result();
        try {
            JSONObject jsonObject = new JSONObject(strJson);
            result.setResult(jsonObject.getString("result"));
        } catch (JSONException e){
            Log.i("mylog", e.getMessage());
        }
        return result;
    }
}
