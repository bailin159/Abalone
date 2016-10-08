package com.example.bailin.abalone.news.newsadpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.tools.MyApp;

/**
 * Created by CPC_272 on 16/9/22.
 */
public class NewsDocAdapter extends RecyclerView.Adapter<NewsDocAdapter.DocViewHolder> {
    private int count;

    private int index;

    public void setIndex(int index) {
        this.index = index;
        notifyDataSetChanged();
    }

    public void setCount(int count) {
        this.count = count;
        notifyDataSetChanged();
    }

    @Override
    public DocViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_doc, parent, false);
        DocViewHolder viewHolder = new DocViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(DocViewHolder holder, int position) {
        if (index % count == position) {
            holder.iv.setImageResource(R.mipmap.heisedian);
        } else {
            holder.iv.setImageResource(R.mipmap.baisedian);
        }
    }


    @Override
    public int getItemCount() {
        return count;
    }

    public class DocViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public DocViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_doc);
        }
    }
}
