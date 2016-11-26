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
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.a2cmbeacontest.MenuAdapter.TotalAdapter;
import com.example.administrator.a2cmbeacontest.R;

public class TotalFragment extends Fragment {
<<<<<<< HEAD


    private String findSid="test시작전"; //액티비티 와 프레그먼트 데이터 전달 예제
    private TextView frgTotal;
=======
    private ListView totalList;
    private TotalAdapter totalAdapter;
>>>>>>> 6f6717dc1bcbcf6d4aeab54481b2dd46441671ea

    public TotalFragment(){
        setHasOptionsMenu(true);
    }

    public static final String ARG_PAGE = "ARG_PAGE";

    private String sid;

    public static TotalFragment newInstance(String page){
        TotalFragment fragment = new TotalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

<<<<<<< HEAD

=======
>>>>>>> 6f6717dc1bcbcf6d4aeab54481b2dd46441671ea
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_total, container, false);
<<<<<<< HEAD
        Bundle bundle = getArguments();
        if (bundle != null){
            sid =bundle.getString(ARG_PAGE);
            Log.i("mylog",sid);

        }
        frgTotal = (TextView)view.findViewById(R.id.frgTotal);
        frgTotal.setText(findSid);
=======

        totalList = (ListView)view.findViewById(R.id.totalList);
        totalAdapter = new TotalAdapter(getContext());
        totalList.setAdapter(totalAdapter);
>>>>>>> 6f6717dc1bcbcf6d4aeab54481b2dd46441671ea
        return view;
    }






}
