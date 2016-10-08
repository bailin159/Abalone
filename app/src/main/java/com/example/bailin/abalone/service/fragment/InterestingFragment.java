package com.example.bailin.abalone.service.fragment;

import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.service.InterestingBean;
import com.example.bailin.abalone.tools.CommonAdapter;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.video.ToolsGather;

/**
 * Created by 白霖 on 16/9/21.
 */
public class InterestingFragment extends BaseFragment {

    private ListView lv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_interesting;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_interesting);
    }

    @Override
    protected void initData() {
        tool().getData(ToolsGather.INTERESTING, InterestingBean.class, new NetTool.NetInterface<InterestingBean>() {
            @Override
            public void onSuccess(InterestingBean interestingBean) {
                lv.setAdapter(new CommonAdapter<InterestingBean.InfoListBean>(interestingBean.getInfoList(), MyApp.getContext(), R.layout.item_interesting) {
                    @Override
                    public void setData(InterestingBean.InfoListBean infoListBean, CommonViewHolder viewHolder) {
                        TextView tv = (TextView) viewHolder.setClick(R.id.tv_item_interesting);
                        ImageView iv = (ImageView) viewHolder.setClick(R.id.iv_item_interesting);
                        if (infoListBean.getUrl() != null) {
                            if ("gif".equals(infoListBean.getSub_category())) {
                                Glide.with(MyApp.getContext()).load(infoListBean.getUrl()).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.mipmap.ic_launcher).into(iv);
                            } else {
                                Glide.with(MyApp.getContext()).load(infoListBean.getUrl()).error(R.mipmap.ic_launcher).into(iv);
                            }
                            tv.setText(infoListBean.getContent());
                            Log.d("InterestingFragment", infoListBean.getTitle());
                        }
                    }
                });
            }
        });
    }
}
