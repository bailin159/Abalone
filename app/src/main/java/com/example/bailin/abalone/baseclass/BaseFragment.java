package com.example.bailin.abalone.baseclass;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bailin.abalone.tools.NetTool;

/**
 * Created by 白霖 on 16/9/13.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    protected abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected <T extends View> T bindView(int id) {
        return (T) getView().findViewById(id);
    }

    protected <T extends View> T bindView(View view, int id) {
        return (T) view.findViewById(id);
    }

    protected NetTool tool() {
        return new NetTool();
    }
}
