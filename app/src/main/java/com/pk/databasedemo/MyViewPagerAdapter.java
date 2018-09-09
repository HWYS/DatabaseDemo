package com.pk.databasedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> _fragmentList) {
        super(fm);

        fragmentList = _fragmentList;
    }

    @Override
    public Fragment getItem(int i) {

        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
