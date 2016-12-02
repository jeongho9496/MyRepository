package com.example.administrator.a2cmfinal.menufragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.a2cmfinal.R;
import com.example.administrator.a2cmfinal.adapter.MenuAdapter;
import com.example.administrator.a2cmfinal.dto.Menu;

import java.util.ArrayList;
import java.util.List;


public class DessertFragment extends Fragment {

    private ListView dessertList;
    private MenuAdapter dessertAdapter;

    List<Menu> list = new ArrayList<>();

    public DessertFragment(){setHasOptionsMenu(true);}

    public static final String ARG_POSITION = "dessert";

    private String sid;

    public static DessertFragment newInstance(int position){
        DessertFragment fragment = new DessertFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dessert, container, false);
    }

}
