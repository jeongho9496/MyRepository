package com.example.administrator.a2cmfinal.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.NetWork.NetWork;
import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.dto.Result;

import org.json.JSONArray;
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
import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {
    private ImageView btnLogin , btnJoin;

    private EditText editId, editPassword;

    private Editable user_id, user_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("2CM");

        editId = (EditText)findViewById(R.id.login_id);
        editPassword = (EditText)findViewById(R.id.login_password);

        btnLogin = (ImageView)findViewById(R.id.btnLogin);

        btnJoin = (ImageView)findViewById(R.id.btnJoinForm);

        user_id = editId.getText();

        user_pw = editPassword.getText();

    }

    public void onLoginClick(View view){
       /* if (!user_id.equals(null)& user_pw.equals(null)){*/
        loginConn(user_id, user_pw);/*}else {
        Toast.makeText(getApplicationContext(),"로그인 정보를 작성 해주세요",Toast.LENGTH_SHORT).show();}*/

        editId.setText("");
        editPassword.setText("");
    }

    public void onJoinClick(View view){
        Intent intent = new Intent(this, JoinActivity.class);
        startActivity(intent);
    }

    private void loginConn(final Editable user_id, final Editable user_pw) {
        AsyncTask<String, Void, Result> asyncTask = new AsyncTask<String, Void, Result>() {
            ProgressDialog asyncDialog = new ProgressDialog(LoginActivity.this);
            @Override
            protected void onPreExecute() {
                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                asyncDialog.setMessage("로딩중입니다..");
                asyncDialog.show();
            }

            @Override
            protected Result doInBackground(String... params) {
                Result result = null;
                try {
                    URL url = new URL( NetWork.URI+"/loginAndroid");

                    JSONObject body = new JSONObject();
                    body.put("user_id", user_id);
                    body.put("user_pw", user_pw);

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
                if (result.getResult().equals("LOGIN_SUCCESS")){
                   /* Toast.makeText(getApplicationContext(),"로그인 성공 하셨습니다.",Toast.LENGTH_SHORT).show();*/
                    SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("id", String.valueOf(user_id));
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), BeaconStartActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"로그인 실패 하셨습니다.",Toast.LENGTH_SHORT).show();
                }

                asyncDialog.dismiss();
            }

        };
        asyncTask.execute();

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

}
