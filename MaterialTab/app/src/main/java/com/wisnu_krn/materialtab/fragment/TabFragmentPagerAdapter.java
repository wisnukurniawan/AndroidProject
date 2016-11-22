package com.wisnu_krn.materialtab.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by private on 22/11/2016.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    //nama tab nya
    String[] title = new String[]{
            "Tab 1", "Tab 2"
    };

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //method ini yang akan memanipulasi penampilan Fragment dilayar
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new BlankFragment();
                break;
            case 1:
                fragment = new BlankFragment2();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }
}