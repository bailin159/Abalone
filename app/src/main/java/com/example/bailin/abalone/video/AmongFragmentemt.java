package com.example.bailin.abalone.video;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.video.adapter.VideoVPAdapter;
import com.example.bailin.abalone.video.filminformation.AtOnceVideoFragment;
import com.example.bailin.abalone.video.filminformation.RecentlyVideoFragment;

import java.util.ArrayList;

/**
 * Created by 刘士壬 on 16/9/18.
 * 中间一层的fragment
 */
public class AmongFragmentemt extends BaseFragment{

    private TabLayout amongTab;
    private ViewPager amongVP;

    @Override
    protected int setLayout() {
        return R.layout.fragment_among_video;
    }

    @Override
    protected void initView() {
        amongTab = bindView(R.id.video_among_tab);
        amongVP = bindView(R.id.video_among_vp);

    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecentlyVideoFragment());//最近影视
        fragments.add(new AtOnceVideoFragment());// 即将上映影视
        VideoVPAdapter videoVPAdapter = new VideoVPAdapter(getChildFragmentManager());
        ArrayList<String> list = new ArrayList<>();
        list.add("最近上映");
        list.add("即将上映");
        videoVPAdapter.setFragments(fragments, list);
        amongVP.setAdapter(videoVPAdapter);
        amongTab.setupWithViewPager(amongVP);
        amongTab.setTabTextColors(Color.rgb(0x98, 0x9d, 0xa8), Color.rgb(0x6c, 0x8f, 0xff));
    }
}
