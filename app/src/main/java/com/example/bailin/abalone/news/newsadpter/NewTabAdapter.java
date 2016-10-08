package com.example.bailin.abalone.news.newsadpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * 新闻页的tabLayout和ViewPager的适配器
 * Created by CPC_272 on 16/9/13.
 */
public class NewTabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    //把文字放到集合里
    private  ArrayList<String>title;
    public NewTabAdapter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
        title=new ArrayList<>();
        title.add("八卦");
        title.add("头条");
        title.add("爆笑");
        title.add("时间");
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
