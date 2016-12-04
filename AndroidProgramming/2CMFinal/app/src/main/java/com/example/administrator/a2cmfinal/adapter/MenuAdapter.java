package com.example.administrator.a2cmfinal.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.dto.Menu;

import java.util.List;

/**
 * Created by kimjeongho on 2016-11-27.
 */

public class MenuAdapter extends BaseAdapter {

    private List<Menu> list;
    public void setList(List<Menu> list){this.list = list;
    }

    public void set(List<Menu> data){
        list.addAll(data);
        notifyDataSetChanged();//리스트의 데이터가 변경되었다는 것을 리스트에 알려주는 메소드.
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public MenuAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_total, null);
        }

        Menu menu = list.get(position);

        ImageView totalImage = (ImageView) convertView.findViewById(R.id.menuImg);
        totalImage.setImageBitmap(menu.getImage());

        TextView totalTitle = (TextView)convertView.findViewById(R.id.menuTitle);
        totalTitle.setText(menu.getMname());

        /** 2016.12.04 추가 */
        TextView hotIce = (TextView) convertView.findViewById(R.id.menuHotIce);
        String hotOrIce = menu.getHot_ice();
        if (hotOrIce != null && !hotOrIce.equals("")) {
            if (hotOrIce.equals("HOT")) {
                hotIce.setTextColor( ContextCompat.getColor(convertView.getContext(), android.R.color.holo_red_light));
            } else if (hotOrIce.equals("ICE")) {
                hotIce.setTextColor( ContextCompat.getColor(convertView.getContext(), android.R.color.holo_blue_light));
            }
            hotIce.setText("  " + hotOrIce);
        }
        /** // 2016.12.04 추가 */

        TextView totalContent = (TextView)convertView.findViewById(R.id.menuContent);
        totalContent.setText(""+menu.getMprice());

        return convertView;
    }


}

