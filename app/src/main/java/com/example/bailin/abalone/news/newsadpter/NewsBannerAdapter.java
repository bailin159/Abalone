package com.example.bailin.abalone.news.newsadpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.tools.MyApp;

import java.util.ArrayList;

/**
 * Created by leisure on 16/8/4.
 */
public class NewsBannerAdapter extends PagerAdapter {
    private ArrayList<Integer> list;

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.news_banner, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.news_bannner_image_view);
        iv.setImageResource(list.get(position % list.size()));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }
}
