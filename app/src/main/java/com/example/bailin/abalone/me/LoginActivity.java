package com.example.bailin.abalone.me;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;
import java.util.ArrayList;

/**
 * 登入和注册页面tablayout加Viewpager的主页
 * Created by CPC_272 on 16/8/27.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TabLayout tab_login;
    private ViewPager vp_login;
    private ImageView exit_img_login;
    private ArrayList<Fragment> fragments;
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }
    @Override
    protected void initView() {
        tab_login      = bindView(R.id.tab_login);
        vp_login       = bindView(R.id.viewpager_login);
        exit_img_login = bindView(R.id.desitroy_login_img);
    }

    @Override
    protected void initData() {
        exit_img_login.setOnClickListener(this);
        fragments = new ArrayList<>();
         fragments.add(new LoginFragment());
         fragments.add(new LogonFragment());
         LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),fragments);
         vp_login.setAdapter(adapter);
         tab_login.setupWithViewPager(vp_login);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
