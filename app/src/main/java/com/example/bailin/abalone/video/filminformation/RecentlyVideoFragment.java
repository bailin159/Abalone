package com.example.bailin.abalone.video.filminformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.tools.RecycleViewAdapter;
import com.example.bailin.abalone.video.ToolsGather;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 刘士壬 on 16/9/18.
 * 最近电影
 */
public class RecentlyVideoFragment extends BaseFragment {


    private String areaUrl;
    private RecyclerView videoRecentlyRv;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver broadcastReceiver;
    private String cityName = "大连";

    @Override
    protected int setLayout() {
        return R.layout.fragment_recently_video;
    }

    @Override
    protected void initView() {
//         recyclerView
        videoRecentlyRv = bindView(R.id.video_recently_rv);
        // 广播接收器
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.abalone.android.CityName");
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                cityName = intent.getStringExtra("cityName");
                Log.d("接收广播" + "城市名 = ", cityName);
                initRecently();
            }
        };
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void initData() {
        initRecently();
    }


    private void initRecently() {
        try {
            areaUrl = URLEncoder.encode(cityName, "UTF-8");//转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String recentlyUrl = ToolsGather.RECENTLY_VIDEO_URL + areaUrl + ToolsGather.APP_KEY;
        Log.d("utf-8 转换后的网址", recentlyUrl);

        tool().getData(recentlyUrl, RecentlyFilmBean.class, new NetTool.NetInterface<RecentlyFilmBean>() {
            @Override
            public void onSuccess(final RecentlyFilmBean recentlyFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                videoRecentlyRv.setLayoutManager(manager);
                videoRecentlyRv.setAdapter(new RecycleViewAdapter<RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean>
                        (recentlyFilmBean.getResult().getData().get(0).getData(),
                                MyApp.getContext(), R.layout.item_video_recycler) {

                    @Override
                    public void setData(final RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean dataiteBean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.tv_video_film_title, dataiteBean.getTvTitle());
                        viewHolder.setImage(R.id.tv_video_film_icon, dataiteBean.getIconaddress());
                        viewHolder.setText(R.id.tv_video_film_subHead, dataiteBean.getSubHead());
                        viewHolder.setText(R.id.tv_video_film_story, dataiteBean.getStory().getData().getStoryBrief());
                        viewHolder.setText(R.id.video_film_fraction, dataiteBean.getGrade());
                        LinearLayout linearLayout = (LinearLayout) viewHolder.setClick(R.id.ll_video_id);
                        linearLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", dataiteBean.getM_iconlinkUrl());
                                startActivity(intent);
                                Log.d("RecentlyVideoFragment", dataiteBean.getM_iconlinkUrl());
                            }
                        });
                    }
                });

            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }
}
