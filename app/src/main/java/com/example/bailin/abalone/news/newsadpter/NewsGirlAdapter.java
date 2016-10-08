package com.example.bailin.abalone.news.newsadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.news.NewsGirlListener;
import com.example.bailin.abalone.news.newsbean.NewsGirlBean;
import com.example.bailin.abalone.tools.MyApp;


/**
 * 新闻界面娱乐适配器
 * Created by CPC_272 on 16/9/13.
 */
public class NewsGirlAdapter extends BaseAdapter {
    private Context context;

    private NewsGirlBean data;
    private NewsGirlListener newsGirlListener;

    public void setNewsGirlListener(NewsGirlListener newsGirlListener) {
        this.newsGirlListener = newsGirlListener;

    }

    public void setNewsGirlBean(NewsGirlBean newsGirlBean) {
        this.data = newsGirlBean;
        notifyDataSetChanged();
    }

    public NewsGirlAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return data!=null?data.getT1348648517839().size():0;
    }

    @Override
    public Object getItem(int i) {
        return data!=null?data.getT1348648517839().get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder= null;
        if (holder == null) {
            view = LayoutInflater.from(context).inflate(R.layout.news_list_view_item,viewGroup,false);
            holder=new MyViewHolder(view);
            view.setTag(holder);
        }else{
            holder= (MyViewHolder) view.getTag();
        }
        holder.tvTitle.setText(data.getT1348648517839().get(i).getTitle());
        holder.tvTime.setText(data.getT1348648517839().get(i).getLmodify());
//        holder.tvName.setText(data.getT1348648517839().get(i).getSource());

        Glide.with(MyApp.getContext()).load(data.getT1348648517839().get(i).getImgsrc()).into(holder.imageView);
        //接口回调的方法
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getT1348648517839().get(i).getUrl_3w()!= null) {
                    newsGirlListener.onClick(data.getT1348648517839().get(i).getUrl_3w());
                }else{
                    newsGirlListener.onClick(data.getT1348648517839().get(i).getImgsrc());
                }
            }
        });

        return view;
    }
    private class MyViewHolder{
        private ImageView imageView;
        private TextView tvTitle,tvName,tvTime;
        private RelativeLayout relativeLayout;
        public MyViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.img_ls_news);
            tvName = (TextView) view.findViewById(R.id.tv_writer_news);
            tvTime = (TextView) view.findViewById(R.id.tv_tag_news);
            tvTitle = (TextView) view.findViewById(R.id.tv_title_news);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_news_id);
        }
    }
}
