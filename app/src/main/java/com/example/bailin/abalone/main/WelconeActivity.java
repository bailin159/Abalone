package com.example.bailin.abalone.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;
import com.example.bailin.abalone.tools.CustomVieoView;

/**
 * Created by 刘士壬 on 16/9/29.
 */
public class WelconeActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        CustomVieoView customVieoView = bindView(R.id.welcome_custom_videoview);
        Button enterBtn = bindView(R.id.welcome_custom_enter_btn);
        enterBtn.setOnClickListener(this);
        customVieoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        //播放
        customVieoView.start();
        //循环播放

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WelconeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
