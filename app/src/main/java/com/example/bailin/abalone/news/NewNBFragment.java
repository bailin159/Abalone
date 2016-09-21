package com.example.bailin.abalone.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;
import com.wirelesspienetwork.overview.views.Overview;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by CPC_272 on 16/9/20.
 */
public class NewNBFragment extends BaseFragment {
    boolean mVisible;
    Overview mRecentsView;

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

        ArrayList<Integer> models = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
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
            public void onBindViewHolder(ViewHolder<View, Integer> viewHolder) {
                viewHolder.itemView.setBackgroundColor(viewHolder.model);
            }
        };

        mRecentsView.setTaskStack(stack);

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