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
 * Created by kimjeongho on 2016-11-14.
 */

public class BistroAdapter extends BaseAdapter{
    private List<Bistro> list;

    public void setList(List<Bistro> list) {
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public BistroAdapter(Context context){
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
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.bistro_item,null);
        }

        Bistro bistro = list.get(position);
        ImageView bistroImage = (ImageView)convertView.findViewById(R.id.bistroImage);
        bistroImage.setImageResource(bistro.getImage());

        TextView bistroTitle = (TextView)convertView.findViewById(R.id.bistroTitle);
        bistroTitle.setText(bistro.getTitle());

        TextView bistroPrice = (TextView)convertView.findViewById(R.id.bistroPrice);
        bistroPrice.setText(bistro.getPrice());

        TextView bistroContent= (TextView)convertView.findViewById(R.id.bistroContent);
        bistroContent.setText(bistro.getContent());

        return convertView;
    }
}
