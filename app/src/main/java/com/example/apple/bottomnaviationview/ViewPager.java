package com.example.apple.bottomnaviationview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPager extends FragmentPagerAdapter {
    //由于页面已经固定,故这里把Adapter需要的fragment提前创建
    private Fragment[] mFragments = new Fragment[]{new HomeFragment(), new NotificationsFragment(), new DashboardFragment()};

    public ViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
