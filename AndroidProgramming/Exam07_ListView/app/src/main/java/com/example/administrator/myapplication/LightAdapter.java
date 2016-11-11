package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016-11-11.
 */

public class LightAdapter extends BaseAdapter {

    private List<Light> list;

    public void setList(List<Light> list) {
        this.list = list;   //아이템을 외부에 받아 저장
    }

    private Context context;    //인터페이스. 모든 Activity가 context를 구현.
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context) {
        this.context = context;   //주입
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size(); //아이템의 갯수
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);  //아이템의 포지션 값으로 가져옴.
    }

    @Override
    public long getItemId(int position) {   //데이터에 식별 번호가 있으면 식별번호를 리턴하고 없으면 position 값을 리턴한다.
        return position;    // 리스트 상의 인덱스 - position, 객체 안에 있는 데이터중에서 값을 식별 할수 있는것. - itemId
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//해당위치의 데이터를 보여주는 itemview 객체를 만들어 주는 역할.
        //position -> 아이템 리스트 들의 번호, convertView -> item.xml 객체, 재사용되는 뷰가 넘어감. parent -> ListView
        if (convertView == null) {
            //inflation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }

        //convertView 가 null이 아닐 경우 data setting 한다.
        Light light = list.get(position);
        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageResource(light.getImage());

        TextView lightTitle = (TextView)convertView.findViewById(R.id.lightTitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView)convertView.findViewById(R.id.lightContent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
