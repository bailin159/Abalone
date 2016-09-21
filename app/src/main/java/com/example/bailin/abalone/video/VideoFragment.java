package com.example.bailin.abalone.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.DataEvent;
import com.example.bailin.abalone.tools.citylist.CitySelecterActivity;
import com.example.bailin.abalone.video.lookfilm.LookFilmFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 刘士壬 on 16/9/13.
 */

public class VideoFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private Button areaBtn;// 地区
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        //地区
        areaBtn = bindView(R.id.video_area_et);
        areaBtn.setText("大连");
        areaBtn.setOnClickListener(this);
        RadioGroup radioGroup = bindView(R.id.video_rg);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.video_rb_recently);
        // 广播接收器
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.abalone.android.CityName");
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
               areaBtn.setText(intent.getStringExtra("cityName"));
            }
        };
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);

    }




    @Override
    protected void initData() {


    }





    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.video_rb_recently:
                fragmentTransaction.replace(R.id.video_frame_layout, new AmongFragmentemt());
                break;
            case R.id.video_rb_at_once:
                fragmentTransaction.replace(R.id.video_frame_layout, new LookFilmFragment());
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), CitySelecterActivity.class);
        startActivity(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }
}




