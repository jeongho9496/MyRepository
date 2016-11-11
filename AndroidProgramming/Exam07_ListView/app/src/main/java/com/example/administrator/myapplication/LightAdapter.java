package com.example.administrator.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016-11-11.
 */

public class LightAdapter extends BaseAdapter {
    private List<Light> list;

    public void setList(List<Light> list) {
        this.list = list;   //아이템을 외부에 받아 저장
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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
