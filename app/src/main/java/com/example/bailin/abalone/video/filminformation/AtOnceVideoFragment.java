package com.example.bailin.abalone.video.filminformation;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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


    public AtOnceVideoFragment() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_at_once_video;
    }

    @Override
    protected void initView() {
        atOnceRv = bindView(R.id.video_at_once_rv);

        initAtOnce();
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(String str) {
        try {
            areaUrl = URLEncoder.encode(str, "utf-8");//转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final String atOnceUrl = ToolsGather.RECENTLY_VIDEO_URL + areaUrl + ToolsGather.APP_KEY;
        tool().getData(atOnceUrl, RecentlyFilmBean.class, new NetTool.NetInterface<RecentlyFilmBean>() {
            @Override
            public void onSuccess(RecentlyFilmBean recentlyFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                atOnceRv.setLayoutManager(manager);
                atOnceRv.setAdapter(new RecycleViewAdapter<RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean>
                        (recentlyFilmBean.getResult().getData().get(1).getData(),
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


    @Override
    protected void initData() {


    }

    private void initAtOnce() {

        try {
            areaUrl = URLEncoder.encode("大连", "utf-8");//转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final String atOnceUrl = ToolsGather.RECENTLY_VIDEO_URL + areaUrl + ToolsGather.APP_KEY;
        tool().getData(atOnceUrl, RecentlyFilmBean.class, new NetTool.NetInterface<RecentlyFilmBean>() {
            @Override
            public void onSuccess(RecentlyFilmBean recentlyFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                atOnceRv.setLayoutManager(manager);
                atOnceRv.setAdapter(new RecycleViewAdapter<RecentlyFilmBean.ResulttBean.DataiBean.DataiteBean>
                        (recentlyFilmBean.getResult().getData().get(1).getData(),
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
