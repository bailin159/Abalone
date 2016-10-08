package com.example.bailin.abalone.news.newsfragment;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.news.newsadpter.NewTabAdapter;
import java.util.ArrayList;

/**
 * 新闻界面
 * Created by 车鹏昌 on 16/9/13.
 */
public class NewsFragment extends BaseFragment {
    private ViewPager newsViewPager;
    private TabLayout newsTabLayout;
    private ArrayList<Fragment> datas;
    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
         newsTabLayout=bindView(R.id.news_tl_title);
          newsViewPager= bindView(R.id.news_vp_title);
    }

    @Override
    protected void initData() {
        datas=new ArrayList<>();
        datas.add(new NewsGirlFragment());//娱乐
        datas.add(new NewsALLFragment());//全部
        datas.add(new NewNBFragment());//笑话
        datas.add(new  NewsFourFragment());//

         NewTabAdapter newTabAdapter =new NewTabAdapter(getChildFragmentManager(),datas);
        newsViewPager.setAdapter(newTabAdapter);
        newsTabLayout.setupWithViewPager(newsViewPager);
        //设置选定的标签显示颜色
        newsTabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        newsTabLayout.setTabTextColors(Color.BLACK,Color.WHITE);
//        //改变选中字体的颜色,
//       newsTabLayout.setTabTextColors(Color.rgb(0x98, 0x9d, 0xa8), Color.rgb(0x6c, 0x8f, 0xff));
    }
}
