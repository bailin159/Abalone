package com.example.bailin.abalone.news;

import android.graphics.Color;
import android.widget.ListView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.tools.CommonAdapter;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;

import java.util.ArrayList;

/**
 * Created by CPC_272 on 16/9/13.
 */
public class NewsALLFragment extends BaseFragment {
    private ListView mListView;
     private ArrayList<NewsAllBean>datas;
    private  String newsAllUrl="http://c.3g.163.com/nc/article/headline/T1348647909107/0-20.html";
    @Override
    protected int setLayout() {
        return R.layout.fragment_news_all;
    }

    @Override
    protected void initView() {
        mListView=bindView(R.id.news_all_lv);
    }

    @Override
    protected void initData() {


        tool().getData(newsAllUrl, NewsAllBean.class, new NetTool.NetInterface<NewsAllBean>() {
            @Override
            public void onSuccess(NewsAllBean newsAllBean) {
                mListView.setAdapter(new CommonAdapter<NewsAllBean.T1348647909107Bean>(newsAllBean.getT1348647909107(), MyApp.getContext(),
                                                                                          R.layout.news_list_view_item) {
                    @Override
                    public void setData(NewsAllBean.T1348647909107Bean t1348649079062Bean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.tv_writer_news, t1348649079062Bean.getSource());
                        viewHolder.setText(R.id.tv_title_news,t1348649079062Bean.getTitle());
                        viewHolder.setText(R.id.tv_tag_news,t1348649079062Bean.getLmodify());
                    }
                });
            }
        });



    }
}
