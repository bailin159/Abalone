package com.example.bailin.abalone.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.zip.Inflater;

/**
 * Created by 刘士壬 on 16/9/14.
 */
public abstract class RecycleViewAdapter<T> extends RecyclerView.Adapter{
    private List<T> beanList;
    private LayoutInflater inflater;
    private int convertViewId;

    public RecycleViewAdapter(List<T> beanList, Context context, int convertViewId) {
        this.beanList = beanList;
        inflater = LayoutInflater.from(context);
        this.convertViewId = convertViewId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder viewHolder = CommonViewHolder.getHolder(inflater, convertViewId, parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setData(beanList.get(position), (CommonViewHolder) holder);
    }

    @Override
    public int getItemCount() {
        return beanList == null ? 0 :beanList.size();
    }

    public abstract void setData(T t, CommonViewHolder viewHolder);




}
