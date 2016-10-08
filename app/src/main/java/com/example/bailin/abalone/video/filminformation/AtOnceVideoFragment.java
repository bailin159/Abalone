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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.tools.RecycleViewAdapter;
import com.example.bailin.abalone.video.ToolsGather;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 刘士壬 on 16/9/18.
 * 即将上映电影
 */
public class AtOnceVideoFragment extends BaseFragment {

    private String areaUrl;
    private RecyclerView atOnceRv;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver broadcastReceiver;
    private String cityName = "大连";



    @Override
    protected int setLayout() {
        return R.layout.fragment_at_once_video;
    }

    @Override
    protected void initView() {
        atOnceRv = bindView(R.id.video_at_once_rv);
// 广播接收器
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.abalone.android.CityName");
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                cityName = intent.getStringExtra("cityName");
                Log.d("接收广播" + "城市名 = ", cityName);
                initAtOnce();
            }
        };
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        initAtOnce();
    }






    @Override
    protected void initData() {


    }

    private void initAtOnce() {

        try {
            areaUrl = URLEncoder.encode(cityName, "utf-8");//转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final String atOnceUrl = ToolsGather.RECENTLY_VIDEO_URL + areaUrl + ToolsGather.APP_KEY;
        tool().getData(atOnceUrl, RecentlyFilmBean.class, new NetTool.NetInterface<RecentlyFilmBean>() {
            @Override
            public void onSuccess(RecentlyFilmBean recentlyFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                atOnceRv.setLayoutManager(manager);
                try{
                    atOnceRv.setAdapter(new RecycleViewAdapter<RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean>
                            (recentlyFilmBean.getResult().getData().get(1).getData(),
                                    MyApp.getContext(), R.layout.item_video_recycler) {

                        @Override
                        public void setData(final RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean dataiteBean, CommonViewHolder viewHolder) {
                            TextView fractionTv = (TextView) viewHolder.setClick(R.id.video_film_fraction);
                            fractionTv.setVisibility(View.GONE);
                            viewHolder.setText(R.id.tv_video_film_title, dataiteBean.getTvTitle());
                            if (dataiteBean.getIconaddress() != null){
                                viewHolder.setImage(R.id.tv_video_film_icon, dataiteBean.getIconaddress());
                            }else {
                                ImageView im = (ImageView) viewHolder.setClick(R.id.tv_video_film_icon);
                                im.setImageResource(R.mipmap.film_no_image);
                            }
                            viewHolder.setText(R.id.tv_video_film_subHead, dataiteBean.getSubHead());
                            viewHolder.setText(R.id.tv_video_film_data, dataiteBean.getPlayDate().getData());
                            viewHolder.setText(R.id.tv_video_film_story, dataiteBean.getStory().getData().getStoryBrief());
                            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                    intent.putExtra("webUrl", dataiteBean.getM_iconlinkUrl());
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }catch (Exception e){
                    Toast.makeText(mContext, "暂不支持该地区哦", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
