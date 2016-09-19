package com.example.bailin.abalone.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 刘士壬 on 16/9/14.
 */
public abstract class RecycleViewAdapter<T> extends RecyclerView.Adapter<CommonViewHolder>{
    private List<T> beanList;
    private LayoutInflater inflater;
    private int convertViewId;

    public RecycleViewAdapter(List<T> beanList, Context context, int convertViewId) {
        this.beanList = beanList;
        inflater = LayoutInflater.from(context);
        this.convertViewId = convertViewId;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder viewHolder = CommonViewHolder.getHolder(inflater, convertViewId, parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        setData(beanList.get(position), holder);
    }

    @Override
    public int getItemCount() {
        return beanList == null ? 0 :beanList.size();
    }

    public abstract void setData(T t, CommonViewHolder viewHolder);




}
