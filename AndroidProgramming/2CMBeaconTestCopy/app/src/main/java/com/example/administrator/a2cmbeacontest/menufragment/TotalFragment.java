package com.example.administrator.a2cmbeacontest.menufragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.a2cmbeacontest.R;

public class TotalFragment extends Fragment {

    private static final String SID = "sid";
    private String findSid; //액티비티 와 프레그먼트 데이터 전달 예제
    private TextView frgTotal;

    public TotalFragment(){
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getArguments();
        if(extra != null) {
            findSid = extra.getString("sid");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_total, container, false);
        frgTotal = (TextView)view.findViewById(R.id.frgTotal);
        frgTotal.setText(findSid);
        return view;
    }






}
