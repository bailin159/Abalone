package com.example.bailin.abalone.video.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘士壬 on 16/9/18.
 */
public class VideoVPAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private ArrayList<String> list;


    public void setFragments(ArrayList<Fragment> fragments, ArrayList<String> list) {
        this.fragments = fragments;
        this.list = list;
    }


    public VideoVPAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
