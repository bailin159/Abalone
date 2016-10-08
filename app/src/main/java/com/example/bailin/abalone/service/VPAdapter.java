package com.example.bailin.abalone.service;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 白霖 on 16/9/21.
 */
public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public VPAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return strings.get(position);
    }
}
