package com.example.administrator.a2cmfinal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.administrator.a2cmfinal.dto.Menu;
import com.example.administrator.a2cmfinal.menufragment.CoffeeFragment;
import com.example.administrator.a2cmfinal.menufragment.DessertFragment;
import com.example.administrator.a2cmfinal.menufragment.EtcFragment;
import com.example.administrator.a2cmfinal.menufragment.TeaFragment;
import com.example.administrator.a2cmfinal.menufragment.TotalFragment;
import com.github.kimkevin.cachepot.CachePot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-11-24.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;
    List<Menu> menu = new ArrayList<>();
    String sid;

    public TabPagerAdapter(FragmentManager fm, int tabCount, String sid) {
        super(fm);
        this.tabCount = tabCount;
        this.sid = sid;
    }


    @Override
    public Fragment getItem(int position) {
        // 2016. 12. 04 추가
        // 숫자 하드코딩 position으로 변경
        switch (position){
            case 0:
                //TotalFragment totalFragment = new TotalFragment();
                CachePot.getInstance().push(position, sid);
                return TotalFragment.newInstance(position);

            case 1:
                //CoffeeFragment coffeeFragment = new CoffeeFragment();
                CachePot.getInstance().push(position, sid);
                return CoffeeFragment.newInstance(position);

            case 2:
                CachePot.getInstance().push(position, sid);
                return TeaFragment.newInstance(position);

            case 3:
                CachePot.getInstance().push(position, sid);
                return DessertFragment.newInstance(position);

            case 4:
                CachePot.getInstance().push(position, sid);
                return EtcFragment.newInstance(position);
            default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
