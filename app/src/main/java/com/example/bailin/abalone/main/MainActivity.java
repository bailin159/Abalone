package com.example.bailin.abalone.main;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;
import com.example.bailin.abalone.me.MeFragment;
import com.example.bailin.abalone.news.NewsFragment;
import com.example.bailin.abalone.service.ServiceFragment;
import com.example.bailin.abalone.video.VideoFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        RadioGroup radioGroup = bindView(R.id.rg_id);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.rb_news);

        RadioButton rbNews = bindView(R.id.rb_news);
        Drawable dbNews = getResources().getDrawable(R.drawable.selector_news);
        dbNews.setBounds(0, 0, 70, 70);
        rbNews.setCompoundDrawables(null, dbNews, null, null);

        RadioButton rbVideo = bindView(R.id.rb_video);
        Drawable dbVideo = getResources().getDrawable(R.drawable.selector_video);
        dbVideo.setBounds(0, 0, 70, 70);
        rbVideo.setCompoundDrawables(null, dbVideo, null, null);

        RadioButton rbService = bindView(R.id.rb_service);
        Drawable dbService = getResources().getDrawable(R.drawable.selector_service);
        dbService.setBounds(0, 0, 70, 70);
        rbService.setCompoundDrawables(null, dbService, null, null);

        RadioButton rbMe = bindView(R.id.rb_me);
        Drawable dbMe = getResources().getDrawable(R.drawable.selector_me);
        dbMe.setBounds(0, 0, 70, 70);
        rbMe.setCompoundDrawables(null, dbMe, null, null);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (i) {
            case R.id.rb_news:
                fragmentTransaction.replace(R.id.fragment_id, new NewsFragment());
                break;

            case R.id.rb_video:
                fragmentTransaction.replace(R.id.fragment_id, new VideoFragment());
                break;

            case R.id.rb_service:
                fragmentTransaction.replace(R.id.fragment_id, new ServiceFragment());
                break;

            case R.id.rb_me:
                fragmentTransaction.replace(R.id.fragment_id, new MeFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
