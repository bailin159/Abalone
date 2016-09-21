package com.example.bailin.abalone.video.lookfilm;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;
import com.example.bailin.abalone.bean.video.SearchFilmBean;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.tools.RecycleViewAdapter;
import com.example.bailin.abalone.video.ToolsGather;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘士壬 on 16/9/18.
 */
public class LookFilmFragment extends BaseFragment implements View.OnClickListener {


    private EditText searchEt;
    private ImageView searchIm;
    private String areaUrl;
    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_look_film_video;
    }

    @Override
    protected void initView() {
        searchEt = bindView(R.id.video_look_search_et);
        recyclerView = bindView(R.id.video_look_film_rv);
        searchIm = bindView(R.id.video_look_search_Im);
        searchIm.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        String search = searchEt.getText().toString();
        try {
            //转码
            areaUrl = URLEncoder.encode(search, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final String filmUrl = ToolsGather.SEARCH_VIDEO_URL + ToolsGather.SEARCH_APP_KEY + ToolsGather.FILM_NAME + areaUrl;
        Log.d("搜索电影网址", filmUrl);
        tool().getData(filmUrl, SearchFilmBean.class, new NetTool.NetInterface<SearchFilmBean>() {
            @Override
            public void onSuccess(SearchFilmBean searchFilmBean) {
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                recyclerView.setLayoutManager(manager);
                List<SearchFilmBean.ResultBean> list = new ArrayList<SearchFilmBean.ResultBean>();
                list.add(searchFilmBean.getResult());

                recyclerView.setAdapter(new RecycleViewAdapter<SearchFilmBean.ResultBean>(list, MyApp.getContext(), R.layout.item_video_look_recycler) {
                    @Override
                    public void setData(SearchFilmBean.ResultBean resultBean, CommonViewHolder viewHolder) {
                        //viewHolder.setText();
                    }
                });
                recyclerView.setAdapter(new RecycleViewAdapter<SearchFilmBean.ResultBean.VideoRecBean>(searchFilmBean.getResult().getVideo_rec(), MyApp.getContext(), R.layout.item_video_look_recycler) {
                    @Override
                    public void setData(SearchFilmBean.ResultBean.VideoRecBean videoRecBean, CommonViewHolder viewHolder) {
                        Log.d("LookFilmFragment", videoRecBean.getTitle());
                    }
                });




            }
        });
    }
}
