package com.example.bailin.abalone.video;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘士壬 on 16/9/13.
 */

public class VideoFragment extends BaseFragment {
    private String result = null;
    @Override
    protected int setLayout() {
        return R.layout.fragment_video;

    }



    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        Map params = new HashMap();// 请求参数
        params.put("key", ToolsGather.APP_KEY);
        params.put("dtype","json");// 返回json格式
        params.put("q","");

    }
}
