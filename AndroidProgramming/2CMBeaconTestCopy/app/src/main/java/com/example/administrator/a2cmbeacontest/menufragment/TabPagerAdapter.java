package com.example.administrator.a2cmbeacontest.menufragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2016-11-24.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TotalFragment totalFragment = new TotalFragment();
                return totalFragment;

            case 1:
                CoffeeFragment coffeeFragment = new CoffeeFragment();
                return coffeeFragment;

            case 2:
                TeaFragment teaFragment = new TeaFragment();
                return teaFragment;

            case 3:
                DessertFragment dessertFragment = new DessertFragment();
                return dessertFragment;

            case 4:
                EtcFragment etcFragment = new EtcFragment();
                return etcFragment;

            default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
