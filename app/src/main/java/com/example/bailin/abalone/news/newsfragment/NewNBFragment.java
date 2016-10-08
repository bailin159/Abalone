package com.example.bailin.abalone.news.newsfragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.news.newsbean.NBBean;
import com.example.bailin.abalone.tools.NetTool;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;
import com.wirelesspienetwork.overview.views.Overview;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by CPC_272 on 16/9/20.
 */
public class NewNBFragment extends BaseFragment {
    private String url="http://japi.juhe.cn/joke/content/list.from?key=3eccd8f5a6b78000f9fe8d98842e5382&page=2&pagesize=10&sort=asc&time=1418745237";
    boolean mVisible;
    Overview mRecentsView;
    private TextView content;

    @Override
    protected int setLayout() {
        return R.layout.fragment_nb;
    }

    @Override
    protected void initView() {
        mRecentsView = bindView(R.id.recents_view);
    }

    @Override
    protected void initData() {
        //开启全屏模式
        mRecentsView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Mark Recents as visible
        mVisible = true;
        tool().getData(url, NBBean.class, new NetTool.NetInterface<NBBean>() {
            @Override
            public void onSuccess(final NBBean nbBean) {
                ArrayList<Integer> models = new ArrayList<>();
                for (int i = 0; i < nbBean.getResult().getData().size(); ++i) {
                    Random random = new Random();
                    random.setSeed(i);
                    models.add(0xffffffff);
                }

                final OverviewAdapter stack = new OverviewAdapter<ViewHolder<View, Integer>, Integer>(models) {
                    @Override
                    public ViewHolder onCreateViewHolder(Context context, ViewGroup parent) {
                        View v = View.inflate(context, R.layout.recents_dummy, null);
                        return new ViewHolder<View, Integer>(v);
                    }

                    @Override
                    public void onBindViewHolder(final ViewHolder<View, Integer> viewHolder) {
                        viewHolder.itemView.setBackgroundColor(viewHolder.model);
                        int i = viewHolder.getPosition();
                        content = (TextView) viewHolder.itemView.findViewById(R.id.recents_nb);
                        content.setText(nbBean.getResult().getData().get(i).getContent());
                        Log.d("NewNBFragment", nbBean.getResult().getData().get(i).getContent());

                    }
                };

                mRecentsView.setTaskStack(stack);
            }



        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                stack.notifyDataSetInserted(new Integer(1), 2);
//            }
//        },2000);
    }
    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
   public void onDestroy() {
        super.onDestroy();
    }
}