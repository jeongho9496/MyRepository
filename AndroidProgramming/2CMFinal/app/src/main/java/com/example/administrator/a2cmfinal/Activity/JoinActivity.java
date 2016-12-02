package com.example.administrator.a2cmfinal.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.R;

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

public class JoinActivity extends AppCompatActivity {

    ImageView btnJoin;

    EditText editId, editPassword, editEmail, editTel;

    Editable joinId;
    Editable joinPassword;
    Editable joinEmail;
    Editable joinTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        btnJoin = (ImageView)findViewById(R.id.btnJoin);
        editId = (EditText)findViewById(R.id.edit_join_id);
        editPassword = (EditText) findViewById(R.id.edit_join_password);
        editEmail= (EditText) findViewById(R.id.edit_join_email);
        editTel = (EditText)findViewById(R.id.edit_join_tel);
        joinId = editId.getText();           //id
        joinPassword = editPassword.getText();//pw
        joinEmail = editEmail.getText();     //email
        joinTel = editTel.getText();        //tel


        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinConn(joinId, joinEmail, joinPassword, joinTel);
            }
        });




    }

    private void joinConn(final Editable joinId, final Editable joinEmail, final Editable joinPassword , final Editable joinTel)  {
        AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url = new URL("http://192.168.0.58:8080/myweb/joinAndroid");

                    JSONObject body = new JSONObject();
                    body.put("user_id", joinId);
                    body.put("user_email", joinEmail);
                    body.put("user_pw", joinPassword);
                    body.put("user_tel", joinTel );

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
                        StringBuffer sb = new StringBuffer("");
                        String line = "";

                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                            break;
                        }

                        br.close();
                        return sb.toString();

                    } else {
                        return new String("false: "+responseCode);
                    }


                } catch (Exception e) {
                    Log.i("mylog join",e.getMessage());
                }


                return null;
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                Log.i("mylog",s);
                if (!s.equals("false: 500")){
                    Toast.makeText(getApplicationContext(), "회원가입을 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                    startActivity(intent);

                    finish();
                } else{
                    Toast.makeText(getApplicationContext(), "회원가입을 실패 하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();

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
}
