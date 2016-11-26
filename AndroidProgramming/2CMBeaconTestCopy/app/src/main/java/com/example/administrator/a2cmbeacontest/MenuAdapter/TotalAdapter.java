package com.example.administrator.a2cmbeacontest.MenuAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.a2cmbeacontest.R;

import java.util.List;

/**
 * Created by Administrator on 2016-11-25.
 */

public class TotalAdapter extends BaseAdapter {
    private List<Menu> list;
    public void setList(List<Menu> list){this.list = list;}

    private Context context;
    private LayoutInflater layoutInflater;

    public TotalAdapter(Context context){
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

        ImageView totalImage = (ImageView) convertView.findViewById(R.id.menuImg);
        totalImage.setImageResource(R.drawable.coffeecup);

        TextView totalTitle = (TextView)convertView.findViewById(R.id.menuTitle);
        totalTitle.setText("test제목");

        TextView totalContent = (TextView)convertView.findViewById(R.id.menuContent);
        totalContent.setText("test내용 들어가는 곳");

        return convertView;
    }
}
