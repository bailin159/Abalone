package com.example.bailin.abalone.service.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 白霖 on 16/9/21.
 */
public class SkipVideoActivity extends BaseActivity implements Runnable {
    private VideoView mVideoView;
    private MediaController mMediaController;
    private MyMediacontroller myMediacontroller;

    private static final int TIME = 0;
    private static final int BATTERY = 1;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TIME:
                    myMediacontroller.setTime(msg.obj.toString());
                    break;
                case BATTERY:
                    myMediacontroller.setBattery(msg.obj.toString());
                    break;
            }
        }
    };
    @Override
    protected int setLayout() {

        return R.layout.activity_skipvideo;
    }

    @Override
    protected void initView() {
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = SkipVideoActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        //设置视频解码监听
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        mVideoView =(VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(url);//设置播放地址
        mMediaController = new MediaController(this);//实例化控制器
        myMediacontroller = new MyMediacontroller(this,mVideoView,this);
        mVideoView.setMediaController(myMediacontroller);//绑定控制器
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        mMediaController.show(5000);//控制器显示5s后自动隐藏
        mVideoView.requestFocus();//取得焦点
        registerBoradcastReceiver();
        new Thread(this).start();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (mVideoView != null){
            mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(batteryBroadcastReceiver);
        } catch (IllegalArgumentException ex) {

        }
    }

    private BroadcastReceiver batteryBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
                //获取当前电量
                int level = intent.getIntExtra("level", 0);
                //电量的总刻度
                int scale = intent.getIntExtra("scale", 100);
                //把它转成百分比
                //tv.setText("电池电量为"+((level*100)/scale)+"%");
                Message msg = new Message();
                msg.obj = (level*100)/scale+"";
                msg.what = BATTERY;
                mHandler.sendMessage(msg);
            }
        }
    };

    public void registerBoradcastReceiver() {
        //注册电量广播监听
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryBroadcastReceiver, intentFilter);

    }

    @Override
    public void run() {
// TODO Auto-generated method stub
        while (true) {
            //时间读取线程
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String str = sdf.format(new Date());
            Message msg = new Message();
            msg.obj = str;
            msg.what = TIME;
            mHandler.sendMessage(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}