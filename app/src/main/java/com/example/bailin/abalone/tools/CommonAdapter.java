package com.example.bailin.abalone.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 白霖 on 16/9/13.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private List<T> beanList;
    private LayoutInflater mLayoutInflater;
    private int convertViewId;

    public CommonAdapter(List<T> beanList, Context context, int id) {
        this.beanList = beanList;
        mLayoutInflater = LayoutInflater.from(context);
        convertViewId = id;
    }



    @Override
    public int getCount() {
        return beanList == null ? 0 : beanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder commonViewHolder = CommonViewHolder.getHolder(view, mLayoutInflater, convertViewId, viewGroup);
        setData(beanList.get(i), commonViewHolder);

        return commonViewHolder.getConvertView();
    }

    public abstract void setData(T t, CommonViewHolder viewHolder);
}
