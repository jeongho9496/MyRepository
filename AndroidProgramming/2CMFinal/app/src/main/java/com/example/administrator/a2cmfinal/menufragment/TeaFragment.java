package com.example.administrator.a2cmfinal.menufragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.Activity.DetailMenuActivity;
import com.example.administrator.a2cmfinal.NetWork.NetWork;
import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.adapter.MenuAdapter;
import com.example.administrator.a2cmfinal.dto.Menu;
import com.github.kimkevin.cachepot.CachePot;

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


public class TeaFragment extends Fragment {
    private ListView teaList;
    private MenuAdapter teaAdapter;

    List<Menu> list = new ArrayList<>();

    public TeaFragment(){
        setHasOptionsMenu(true);
    }

    public static final String ARG_POSITION = "tea";

    private String sid;

    private int pageNo = 1;

    boolean isLast = false;

    public static Fragment newInstance(int position) {
        TeaFragment fragment = new TeaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            final int position = getArguments().getInt(ARG_POSITION);
            sid = CachePot.getInstance().pop(position);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea, container, false);

        teaList = (ListView)view.findViewById(R.id.teaList);

        setMenuItems(pageNo);

        teaList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (isLast && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    int itemCount = teaAdapter.getCount();
                    int page = itemCount / 8;
                    page = (itemCount % 8 > 0) ? page+1:page;
                    getMoreItem(page+1);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (totalItemCount > 0 && (firstVisibleItem + visibleItemCount >= totalItemCount - 1)) {
                    isLast = true;
                } else {
                    isLast = false;
                }

            }
        });

        teaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menuData = (Menu) teaList.getItemAtPosition(position);

                Intent intent = new Intent(getContext(), DetailMenuActivity.class);
                intent.putExtra("menuDetail",menuData.getMid());
                startActivity(intent);
            }
        });

        return view;
    }

    private void setMenuItems(final int pageNo) {
        AsyncTask<Void, Void, List<Menu>> asyncTask = new AsyncTask<Void, Void, List<Menu>>() {

            ProgressDialog asyncDialog = new ProgressDialog(getContext());
            @Override
            protected void onPreExecute() {
//                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                asyncDialog.setMessage("로딩중입니다..");
//                asyncDialog.show();
            }

            @Override
            protected List<Menu> doInBackground(Void... params) {
                List<Menu> list = null;
                try {
                    URL url = new URL( NetWork.URI+"/menuGroupAndroid?sid="+sid+"&pageNo="+pageNo+"&mgroup=차");
                    Log.i("mylog sid",sid);
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
                        Log.i("mylog total", strJson);

                    }

                    conn.disconnect();
                } catch (Exception e){
                    Log.i("mylog total",e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(final List<Menu> menu) {
                teaAdapter = new MenuAdapter(getContext());
                list.removeAll(menu);
                teaAdapter.setList(menu);
                teaList.setAdapter(teaAdapter);

                asyncDialog.dismiss();
            }
        };
        asyncTask.execute();
    }

    //리스트뷰 확장
    boolean isMoreData = false;
    private void getMoreItem(final int pageNo) {
        if (isMoreData) return;
        isMoreData = true;

        AsyncTask<Void, Void, List<Menu>> asyncTask = new AsyncTask<Void, Void, List<Menu>>() {

            ProgressDialog asyncDialog = new ProgressDialog(getContext());
            @Override
            protected void onPreExecute() {
//                asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                asyncDialog.setMessage("로딩중입니다..");
//                asyncDialog.show();
            }

            @Override
            protected List<Menu> doInBackground(Void... params) {
                List<Menu> list = null;
                try {
                    URL url = new URL( NetWork.URI+"/menuGroupAndroid?sid="+sid+"&pageNo="+pageNo+"&mgroup=차");
                    Log.i("mylog sid",sid);
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
                        Log.i("mylog total", strJson);

                    }

                    conn.disconnect();
                } catch (Exception e){
                    Log.i("mylog total",e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(final List<Menu> menu) {

                teaAdapter.set(menu);
                isMoreData = false;
                asyncDialog.dismiss();
            }
        };
        asyncTask.execute();
    }

    private List<Menu> parseJson(String strJson) {
        List<Menu> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);//매개변수의 배열'[]'을 받아 parsing (<-> 객체이면'{}' JSONObject로 파싱한다.)
            for (int i = 0; i < jsonArray.length(); i++) {   //배열([]) 안에 있는 데이터 길이 만큼 for문을 돌린다.
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Menu menu = new Menu();
                menu.setMid(jsonObject.getInt("mid"));
                menu.setMname(jsonObject.getString("mname"));
                menu.setMprice(jsonObject.getInt("mprice"));
                menu.setHot_ice(jsonObject.getString("hot_ice"));
                menu.setMcontents(jsonObject.getString("mcontents"));
                menu.setImage(getBitmap(jsonObject.getString("msavedfile")));
                list.add(menu);
            }
        } catch (JSONException e) {
            Log.i("mylog total", e.getMessage());
        }
        return list;
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;

        try {
            URL url = new URL( NetWork.URI+"/getImage?fileName=" + fileName);
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


}
