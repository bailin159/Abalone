package com.example.bailin.abalone.video;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.DataEvent;
import com.example.bailin.abalone.video.lookfilm.LookFilmFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 刘士壬 on 16/9/13.
 */

public class VideoFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {


    private EditText areaEt;// 地区

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        //地区
        areaEt = bindView(R.id.video_area_et);
        areaEt.setText("大连");
        RadioGroup radioGroup = bindView(R.id.video_rg);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.video_rb_recently);

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
                //      EventBus 发送

                DataEvent dataEvent = new DataEvent();
                dataEvent.setArea(areaEt.getText().toString());
                EventBus.getDefault().post(dataEvent);
                break;
            case R.id.video_rb_at_once:
                fragmentTransaction.replace(R.id.video_frame_layout, new LookFilmFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}




