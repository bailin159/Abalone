package com.example.bailin.abalone.news;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bailin.abalone.R;

import java.util.ArrayList;

/**
 * Created by leisure on 16/8/4.
 */
public class NewsBannerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    private ArrayList<Integer> images;
    private Context context;
    private ViewPager viewPager;
    private ImageView[] tips;

    public void setTips(ImageView[] tips) {
        this.tips = tips;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public NewsBannerAdapter(Context context) {
        this.context = context;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images == null? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_banner,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_bannner_image_view);

        imageView.setImageResource(images.get(position % images.size()));

        container.addView(view);

        viewPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < tips.length; i++) {

            if(i == position % images.size()){

                tips[i].setImageResource(R.mipmap.t);
            }else {
                tips[i].setImageResource(R.mipmap.ic_launcher);
            }

        }

    }

    // state = 0 state =1 state = 2
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
