package com.example.administrator.a2cmfinal.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.dto.Menu;
import com.example.administrator.a2cmfinal.dto.OrderMenu;

import java.util.List;

/**
 * Created by kimjeongho on 2016-11-27.
 */

public class OrderAdapter extends BaseAdapter {

    private List<OrderMenu> list;
    public void setList(List<OrderMenu> list){this.list = list;
    }

    public void set(List<OrderMenu> data){
        list.addAll(data);
        notifyDataSetChanged();//리스트의 데이터가 변경되었다는 것을 리스트에 알려주는 메소드.
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public OrderAdapter(Context context){
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
            convertView = layoutInflater.inflate(R.layout.item_order, null);
        }

        OrderMenu menu = list.get(position);

        TextView orderTitle = (TextView)convertView.findViewById(R.id.menuTitle);
        orderTitle.setText(menu.getMname()+" "+menu.getCount()+"개 ");

        TextView orderHotIce = (TextView)convertView.findViewById(R.id.menuHotIce);
        String hotOrIce = menu.getHot_ice();
        if (hotOrIce != null && !hotOrIce.equals("")) {
            if (hotOrIce.equals("HOT")) {
                orderHotIce.setTextColor( ContextCompat.getColor(convertView.getContext(), android.R.color.holo_red_light));
            } else if (hotOrIce.equals("ICE")) {
                orderHotIce.setTextColor( ContextCompat.getColor(convertView.getContext(), android.R.color.holo_blue_light));
            }
            orderHotIce.setText("  " + hotOrIce);
        }

        TextView menuPrice = (TextView)convertView.findViewById(R.id.menuPrice);
        menuPrice.setText("가격: "+String.format("%,d",menu.getMprice())+"원");

        TextView orderSyrup = (TextView)convertView.findViewById(R.id.menuSyrup);
        orderSyrup.setText("시럽: "+menu.getSyrup()+" "+menu.getSyrupPrice()+"원");

        TextView orderSize = (TextView)convertView.findViewById(R.id.menuSize);
        orderSize.setText("사이즈: "+menu.getSize()+" "+menu.getSizePrice()+"원");

        TextView orderShot = (TextView)convertView.findViewById(R.id.menuShot);
        orderShot.setText("시럽: "+menu.getShot()+" "+menu.getShotPrice()+"원");

        TextView orderPrice = (TextView)convertView.findViewById(R.id.menuTotalPrice);
        orderPrice.setText("총 가격: "+String.format("%,d",menu.getMprice()+menu.getShotPrice()+menu.getSizePrice()+menu.getSyrupPrice())+"원");

        return convertView;
    }


}
