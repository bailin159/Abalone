package com.example.bailin.abalone.service.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.service.SelectionVideoBean;
import com.example.bailin.abalone.service.activity.SkipVideoActivity;
import com.example.bailin.abalone.tools.CommonAdapter;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.MySwipeRefreshLayout;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.video.ToolsGather;

/**
 * Created by 白霖 on 16/9/21.
 */
public class SelectionFragment extends BaseFragment {


    private ListView lv;
    private MySwipeRefreshLayout msrl;


    @Override
    protected int setLayout() {
        return R.layout.item_listview;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_overall);
        msrl = bindView(R.id.srl_shangla);
    }

    @Override
    protected void initData() {

        tool().getData(ToolsGather.SELECTION_VIDEO, SelectionVideoBean.class, new NetTool.NetInterface<SelectionVideoBean>() {
            @Override
            public void onSuccess(final SelectionVideoBean selectionVideoBean) {

                for (int i = 0; i < selectionVideoBean.getItem_list().size(); i++) {
                    if (selectionVideoBean.getItem_list().get(i).getRes_title() == null) {
                        selectionVideoBean.getItem_list().remove(i);
                    }
                }

                CommonAdapter<SelectionVideoBean.ItemListBean> adapter = new CommonAdapter<SelectionVideoBean.ItemListBean>(selectionVideoBean.getItem_list(), MyApp.getContext(), R.layout.fragment_selection) {
                    @Override
                    public void setData(final SelectionVideoBean.ItemListBean itemListBean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.tv_selection_title, itemListBean.getRes_title());
                        viewHolder.setText(R.id.tv_selection_count, itemListBean.getPlay_count() + "人点赞");
                        viewHolder.setText(R.id.tv_selection_nickname, itemListBean.getRes_display_type());
                        viewHolder.setImage(R.id.iv_selection_res_cover_url, itemListBean.getRes_cover_url());

                        int minute = itemListBean.getDuration() / 60;
                        int second = itemListBean.getDuration() % 60;
                        String mm = "";
                        String ss = "";
                        if (minute < 10) {
                            mm = "0" + minute;
                        } else {
                            mm = String.valueOf(minute);
                        }
                        if (second < 10) {
                            ss = "0" + second;
                        } else {
                            ss = String.valueOf(second);
                        }
                        viewHolder.setText(R.id.tv_selection_duration, mm + ":" + ss);

                        viewHolder.setClick(R.id.rl_selection).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), SkipVideoActivity.class);
                                intent.putExtra("url", itemListBean.getPlay_url());
                                startActivity(intent);
                            }
                        });

                    }
                };

                lv.setAdapter(adapter);
            }
        });
    }
}
