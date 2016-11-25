package com.example.administrator.a2cmfinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.administrator.a2cmfinal.dto.Sphoto;
import com.example.administrator.a2cmfinal.dto.Store;

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
import java.util.HashMap;
import java.util.List;

public class StoreInfoActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout storeImage;
    private TextView storeInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_info);

        Intent intent = getIntent();
        Store store = (Store) intent.getSerializableExtra("store");

        getSupportActionBar().setTitle(store.getSname()+" "+store.getSlocal());

        String sid = store.getSid();

        storeImage = (SliderLayout)findViewById(R.id.sliderImage);
        storeInfo = (TextView)findViewById(R.id.storeInfoText);

        storeInfo.setText(store.getSid()+" "+store.getSname()+" "+store.getSlocal()+" "+store.getSaddr()+" "+store.getSopen()+" "+store.getSclosed()+" "+store.getStel());

        sphotoLoading(sid);
    }

    private void sphotoLoading(final String sid) {
        AsyncTask<Void, Void, List<Sphoto>> asyncTask = new AsyncTask<Void, Void, List<Sphoto>>() {
            ProgressDialog asyncDialog = new ProgressDialog(StoreInfoActivity.this);

            @Override
            protected void onPreExecute() {
                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                asyncDialog.setMessage("로딩중입니다..");
                asyncDialog.show();
            }


            @Override
            protected List<Sphoto> doInBackground(Void... params) {
                List<Sphoto> list = null;
                try {
                    URL url = new URL("http://192.168.0.58:8080/myweb/sphotoAndroid?sid="+sid);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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
                        br.close();
                        reader.close();
                        is.close();
                        list = parseJson(strJson);
                        Log.i("mylog 이다", strJson);
                    }
                    conn.disconnect();

                } catch (Exception e){
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Sphoto> sphotos) {
                super.onPostExecute(sphotos);

                HashMap<String,String> url_maps = new HashMap<String, String>();
                for (int i=0; i<sphotos.size(); i++){
                    url_maps.put("photos"+i, "http://192.168.0.58:8080/myweb/store/showPhoto?savedfile="+sphotos.get(i).getSpic_savedfile());
                }
                storeImage.removeAllSliders();

                for (String name : url_maps.keySet()){
                    TextSliderView textSliderView = new TextSliderView(StoreInfoActivity.this);
                    textSliderView.image((url_maps.get(name)));


                    storeImage.addSlider(textSliderView);
                    storeImage.setPresetTransformer(SliderLayout.Transformer.Default);
                    storeImage.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                }

                asyncDialog.dismiss();
            }
        };
        asyncTask.execute();
    }

    private List<Sphoto> parseJson(String strJson) {

        List<Sphoto> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Sphoto sphoto = new Sphoto();
                sphoto.setSpic_savedfile(jsonObject.getString("spic_savedfile"));
                list.add(sphoto);
            }


        } catch (JSONException e){
            Log.i("mylog",e.getMessage());
        }
        return list;
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
