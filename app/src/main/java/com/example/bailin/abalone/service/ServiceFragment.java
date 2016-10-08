package com.example.bailin.abalone.service;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.service.fragment.InterestingFragment;
import com.example.bailin.abalone.service.fragment.SelectionFragment;
import com.example.bailin.abalone.service.fragment.ShortVideoFragment;

import java.util.ArrayList;

/**
 * Created by 白霖 on 16/9/13.
 */
public class ServiceFragment extends BaseFragment {


    private TabLayout tabLayout;
    private ViewPager vp;

    @Override
    protected int setLayout() {
        return R.layout.fragment_service;
    }

    @Override
    protected void initView() {
        tabLayout = bindView(R.id.tab_service);
        vp = bindView(R.id.vp_service);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setTabTextColors(Color.BLACK, Color.WHITE);

    }

    @Override
    protected void initData() {
        VPAdapter adapter = new VPAdapter(getChildFragmentManager());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("精选");
        strings.add("短片");
        strings.add("趣图");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SelectionFragment());
        fragments.add(new ShortVideoFragment());
        fragments.add(new InterestingFragment());
        adapter.setFragments(fragments);
        adapter.setStrings(strings);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

    }
}
