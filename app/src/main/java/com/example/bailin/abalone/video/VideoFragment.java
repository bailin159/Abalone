package com.example.bailin.abalone.video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.tools.RecycleViewAdapter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 刘士壬 on 16/9/13.
 */

public class VideoFragment extends BaseFragment {

    private EditText areaEt;// 地区
    private String area;// 地区URL
    private String areaUrl;
    private RecyclerView videoRv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        //地区
        areaEt = bindView(R.id.video_area_et);
        // recyclerView
        videoRv = bindView(R.id.video_rv);

    }


    @Override
    protected void initData() {
        areaEt.setText("大连");
        area = areaEt.getText().toString();
        try {
            areaUrl = URLEncoder.encode(area,"utf-8");//转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String recentlyUrl = ToolsGather.RECENTLY_VIDEO_URL + areaUrl + ToolsGather.APP_KEY;
        Log.d("VideoFragment", recentlyUrl);

        tool().getData(recentlyUrl, RecentlyFilmBean.class, new NetTool.NetInterface<RecentlyFilmBean>() {
            @Override
            public void onSuccess(RecentlyFilmBean recentlyFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                videoRv.setLayoutManager(manager);
                videoRv.setAdapter(new RecycleViewAdapter<RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean>
                        (recentlyFilmBean.getResult().getData().get(0).getData(),
                        MyApp.getContext(), R.layout.item_video_recycler) {

                    @Override
                    public void setData(RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean dataiteBean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.tv_video_film_title, dataiteBean.getTvTitle());
                        viewHolder.setImage(R.id.tv_video_film_icon, dataiteBean.getIconaddress());
                        viewHolder.setText(R.id.tv_video_film_subHead, dataiteBean.getSubHead());
                        viewHolder.setText(R.id.tv_video_film_story, dataiteBean.getStory().getData().getStoryBrief());
                    }
                });

            }
        });
    }



}




