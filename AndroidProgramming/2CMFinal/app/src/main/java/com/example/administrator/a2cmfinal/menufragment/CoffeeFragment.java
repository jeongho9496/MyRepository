package com.example.administrator.a2cmfinal.menufragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.adapter.MenuAdapter;
import com.example.administrator.a2cmfinal.dto.Menu;
import com.github.kimkevin.cachepot.CachePot;

import java.util.ArrayList;
import java.util.List;


public class CoffeeFragment extends Fragment {
    private ListView coffeeList;
    private MenuAdapter coffeeAdapter;

    List<Menu> list = new ArrayList<>();

    public CoffeeFragment(){setHasOptionsMenu(true);}

    public static final String ARG_POSITION = "test";

    private String sid;

    public static CoffeeFragment newInstance(int position){
        CoffeeFragment fragment = new CoffeeFragment();
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
            Toast.makeText(getContext(),sid,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);
        coffeeList = (ListView)view.findViewById(R.id.coffeeList);
        coffeeAdapter = new MenuAdapter(getContext());
        list.removeAll(list);

        /*list.add(new Menu("커피"));
        list.add(new Menu("홍차"));
        list.add(new Menu("케익"));
        list.add(new Menu("베이글"));*/


        coffeeAdapter.setList(list);
        coffeeList.setAdapter(coffeeAdapter);


        return view;
    }

}
