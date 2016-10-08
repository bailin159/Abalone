package com.example.bailin.abalone.news.newsfragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import android.support.v4.view.ViewPager;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.news.newsadpter.NewsBannerAdapter;
import com.example.bailin.abalone.news.NewsChildActivity;
import com.example.bailin.abalone.news.NewsGirlListener;
import com.example.bailin.abalone.news.newsadpter.NewsDocAdapter;
import com.example.bailin.abalone.news.newsadpter.NewsGirlAdapter;
import com.example.bailin.abalone.news.newsbean.NewsGirlBean;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;

import java.util.ArrayList;

/**
 * 新闻页的娱乐fragment
 * Created by CPC_272 on 16/9/13.
 */
public class NewsGirlFragment extends BaseFragment {
    private String newsGirlUrl = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    private ListView mListView;
    private ViewPager viewPager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private NewsGirlAdapter adapter;
    private View view;
    private Handler mHandler;
    private RecyclerView rvDoc;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_girl;


    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.news_girl_lv);
        view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.news_head_girl,null);
        viewPager = (ViewPager) view.findViewById(R.id.news_banner_view_pager);
        rvDoc = (RecyclerView) view.findViewById(R.id.rv_doc);

        mSwipeRefreshLayout = bindView(R.id.swipe_news);

        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                Message message1 = mHandler.obtainMessage();
                message1.what = 1;
                mHandler.sendMessageDelayed(message1, 5000);
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return false;
            }
        });

        Message message = mHandler.obtainMessage();
        message.what = 1;
        mHandler.sendMessageDelayed(message, 5000);
    }

    @Override
    public void onStop() {
        super.onStop();
        mHandler.removeMessages(1);
    }
    @Override
    protected void initData() {
        NewsBannerAdapter newsBannerAdapter = new NewsBannerAdapter();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.yinsuwan);
        list.add(R.mipmap.baoyu_wangzhi);
        list.add(R.mipmap.daiyouxiang);
        newsBannerAdapter.setList(list);
        viewPager.setAdapter(newsBannerAdapter);
        viewPager.setCurrentItem(3000);
        LinearLayoutManager manager = new LinearLayoutManager(MyApp.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        final NewsDocAdapter docAdapter = new NewsDocAdapter();
        docAdapter.setCount(list.size());
        rvDoc.setLayoutManager(manager);
        rvDoc.setAdapter(docAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
               docAdapter.setIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    //    *********************下拉刷新*****************

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tool().getData(newsGirlUrl, NewsGirlBean.class, new NetTool.NetInterface<NewsGirlBean>() {
                    @Override
                    public void onSuccess(NewsGirlBean newsGirlBean) {
                        mListView.setAdapter(null);
                        adapter = new NewsGirlAdapter(MyApp.getContext());
                        adapter.setNewsGirlBean(newsGirlBean);
                        adapter.setNewsGirlListener(new NewsGirlListener() {
                            @Override
                            public void onClick(String urlWeb) {
                                Intent intent = new Intent(getContext(), NewsChildActivity.class);
                                intent.putExtra("url", urlWeb);
                                getContext().startActivity(intent);
                            }
                        });
                        mListView.setAdapter(adapter);
                        mSwipeRefreshLayout.setRefreshing(false);

                    }
                });
            }
        });

        //*********************解析listView的item数据
        tool().getData(newsGirlUrl, NewsGirlBean.class, new NetTool.NetInterface<NewsGirlBean>() {
            @Override
            public void onSuccess(NewsGirlBean newsGirlBean) {
                adapter = new NewsGirlAdapter(MyApp.getContext());
                adapter.setNewsGirlBean(newsGirlBean);
                adapter.setNewsGirlListener(new NewsGirlListener() {

                    //***************************接口回调   点击进去是webView
                    @Override
                    public void onClick(String urlWeb) {
                        Intent intent = new Intent(getContext(), NewsChildActivity.class);
                        intent.putExtra("url", urlWeb);
                        getContext().startActivity(intent);
                    }
                });
                mListView.setAdapter(adapter);
            }
        });
        mListView.addHeaderView(view);

    }
}
