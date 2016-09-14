package com.example.bailin.abalone.news;

import android.support.design.widget.TabLayout;
import android.widget.ListView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;

import java.util.ArrayList;

/**
 * 新闻页的娱乐fragment
 * Created by CPC_272 on 16/9/13.
 */
public class NewsGirlFragment extends BaseFragment {
    private String newsGirlUrl="http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    private ListView mListView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_news_girl;
    }

    @Override
    protected void initView() {
    mListView=bindView(R.id.news_girl_lv);
    }

    @Override
    protected void initData() {
      tool().getData(newsGirlUrl, NewsGirlBean.class, new NetTool.NetInterface<NewsGirlBean>() {
      @Override
      public void onSuccess(NewsGirlBean newsGirlBean) {
          NewsGirlAdapter adapter = new NewsGirlAdapter(MyApp.getContext());
          adapter.setNewsGirlBean(newsGirlBean);
          mListView.setAdapter(adapter);
      }
  });
    }
}
