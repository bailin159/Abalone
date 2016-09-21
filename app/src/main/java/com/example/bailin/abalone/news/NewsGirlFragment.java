package com.example.bailin.abalone.news;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private String newsItemUrl="http://c.3g.163.com/";
    private LisatViewForScrollView mListView;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private NewsBannerAdapter myAdapter;
    private ArrayList<Integer> images;

    private Handler handler;
    private boolean flag = true;
    private boolean mm= true;

    private ImageView[] tips;
    private NewsGirlAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_girl;



    }

    @Override
    protected void initView() {
        mListView=bindView(R.id.news_girl_lv);
        viewPager =bindView(R.id.news_banner_view_pager);
        linearLayout = bindView(R.id.ll);
    }

    @Override
    protected void initData() {
        //解析listView的item数据
        tool().getData(newsGirlUrl, NewsGirlBean.class, new NetTool.NetInterface<NewsGirlBean>() {
         @Override
         public void onSuccess(NewsGirlBean newsGirlBean) {
             adapter = new NewsGirlAdapter(MyApp.getContext());
          adapter.setNewsGirlBean(newsGirlBean);
             adapter.setNewsGirlListener(new NewsGirlListener() {

                 //接口回调   点击进去是webView
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

                //轮播图
        myAdapter=new NewsBannerAdapter(MyApp.getContext());
        images = new ArrayList<>();
            images.add(R.mipmap.yinsuwan);
            images.add(R.mipmap.baoyu_wangzhi);
            images.add(R.mipmap.daiyouxiang);

        myAdapter.setImages(images);
        viewPager.setAdapter(myAdapter);
        myAdapter.setViewPager(viewPager);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return false;
            }
        });


        if(mm){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (flag){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.sendEmptyMessage(0);

                    }
                }
            }).start();

            mm =false;
        }

        tips = new ImageView[images.size()];

        for (int i = 0; i < images.size(); i++) {

            ImageView imageView = new ImageView(MyApp.getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(50,50));

            tips[i] = imageView;

            if(i == 0){
                imageView.setImageResource(R.mipmap.t);
            }else {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(
                            50, 50);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;
            linearLayout.addView(imageView,layoutParams);
//          View views= LayoutInflater.from(MyApp.getContext()).inflate(R.layout.news_banner_head_view,null);
//          mListView.addHeaderView(views);
        }
          myAdapter.setTips(tips);



    }



}
