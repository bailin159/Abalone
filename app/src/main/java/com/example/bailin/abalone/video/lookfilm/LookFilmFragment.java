package com.example.bailin.abalone.video.lookfilm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.bean.video.RecentlyFilmBean;
import com.example.bailin.abalone.bean.video.SearchFilmBean;
import com.example.bailin.abalone.tools.CommonAdapter;
import com.example.bailin.abalone.tools.CommonViewHolder;
import com.example.bailin.abalone.tools.MyApp;
import com.example.bailin.abalone.tools.NetTool;
import com.example.bailin.abalone.tools.RecycleViewAdapter;
import com.example.bailin.abalone.video.ToolsGather;
import com.example.bailin.abalone.video.filminformation.SecondVideoActivity;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘士壬 on 16/9/18.
 */
public class LookFilmFragment extends BaseFragment implements View.OnClickListener {


    private EditText searchEt;
    private ImageView searchIm;
    private String areaUrl;
    private RecyclerView recyclerView;
    private TextView titleTv;
    private TextView yearTv;
    private TextView areaTv;
    private TextView dirTv;
    private TextView tagTv;
    private TextView descTv;
    private ImageView iconIv;
    private LinearLayout searchLl;
    private LinearLayout logLl;
    private PopupWindow popupWindow;
    private View contentView;
    private String filmUrl;

    public void setFilmUrl(String filmUrl) {
        this.filmUrl = filmUrl;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_look_film_video;
    }

    @Override
    protected void initView() {
        searchEt = bindView(R.id.video_look_search_et);

        searchIm = bindView(R.id.video_look_search_Im);
        searchIm.setOnClickListener(this);
        /* 搜索布局ID */
        titleTv = bindView(R.id.tv_video_search_title);
        yearTv = bindView(R.id.tv_video_search_year);
        areaTv = bindView(R.id.tv_video_search_area);
        dirTv = bindView(R.id.tv_video_search_dir);
        tagTv = bindView(R.id.tv_video_search_tag);
        descTv = bindView(R.id.tv_video_search_desc);
        iconIv = bindView(R.id.tv_video_search_icon);
        searchLl = bindView(R.id.video_film_search_ll);
        searchLl.setVisibility(View.GONE);
        searchLl.setOnClickListener(this);
        logLl = bindView(R.id.video_search_log_ll);
        logLl.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_look_search_Im:
                searchLl.setVisibility(View.VISIBLE);
                logLl.setVisibility(View.GONE);
                final String search = searchEt.getText().toString();
                try {
                    //转码
                    areaUrl = URLEncoder.encode(search, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                filmUrl = ToolsGather.SEARCH_VIDEO_URL + ToolsGather.SEARCH_APP_KEY + ToolsGather.FILM_NAME + areaUrl;
                Log.d("搜索电影网址", filmUrl);
                tool().getData(filmUrl, SearchFilmBean.class, new NetTool.NetInterface<SearchFilmBean>() {
                    @Override
                    public void onSuccess(SearchFilmBean searchFilmBean) {
                        if (searchFilmBean.getResult() != null) {
                            Log.d("LookFilmFragment", "searchFilmBean.getResult():" + searchFilmBean.getResult());
                            Log.d("LookFilmFragment", "searchFilmBean:" + searchFilmBean);
                            Glide.with(MyApp.getContext()).load(searchFilmBean.getResult().getCover()).into(iconIv);
                            titleTv.setText(searchFilmBean.getResult().getTitle());
                            yearTv.setText(searchFilmBean.getResult().getYear());
                            areaTv.setText(searchFilmBean.getResult().getArea());
                            dirTv.setText(searchFilmBean.getResult().getDir());
                            tagTv.setText(searchFilmBean.getResult().getTag());
                            descTv.setText(searchFilmBean.getResult().getDesc());
                        } else {
                            Toast.makeText(mContext, "查找不到这个电影 T_T", Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, "顺便给你推荐个 海贼王 o_O! ", Toast.LENGTH_SHORT).show();
                            initNet();

                        }
                    }


                });
                break;

            case R.id.video_film_search_ll:
                showPopupWindow();
                break;
        }

    }

    //    private String getUrl(){
//        final String search = searchEt.getText().toString();
//        try {
//            //转码
//            areaUrl = URLEncoder.encode(search, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return areaUrl;
//    }
    private void showPopupWindow() {
        //设置contentView
        contentView = LayoutInflater.from(getContext()).inflate(R.layout.look_film_popuplayout, null);
        popupWindow = new PopupWindow(contentView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(contentView);
        popupWindow.setFocusable(true);
        backgroundAlpha(0.5f);
        final ListView listView = (ListView) contentView.findViewById(R.id.look_film_pop_lv);


        filmUrl = ToolsGather.SEARCH_VIDEO_URL + ToolsGather.SEARCH_APP_KEY + ToolsGather.FILM_NAME + areaUrl;

        Log.d("搜索电影网址 PopupWindow", filmUrl);
        tool().getData(filmUrl, SearchFilmBean.class, new NetTool.NetInterface<SearchFilmBean>() {
            @Override
            public void onSuccess(final SearchFilmBean searchFilmBean) {
                final List<SearchFilmBean.ResultBean.PlaylinksBean> list = new ArrayList<SearchFilmBean.ResultBean.PlaylinksBean>();
//                if (searchFilmBean.getResult() != null)P
                Log.d("LookFilmFragment", filmUrl);

                list.add(searchFilmBean.getResult().getPlaylinks());
                listView.setAdapter(new CommonAdapter<SearchFilmBean.ResultBean.PlaylinksBean>
                        (list, MyApp.getContext(), R.layout.item_video_look_lv) {
                    @Override
                    public void setData(final SearchFilmBean.ResultBean.PlaylinksBean playlinksBean, CommonViewHolder viewHolder) {
                        TextView tvAqy = (TextView) viewHolder.setClick(R.id.item_look_lv_aiqiyi_tv);
                        tvAqy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getQiyi());
                                startActivity(intent);
                            }
                        });

                        TextView tvCntv = (TextView) viewHolder.setClick(R.id.item_look_lv_cntv_tv);
                        tvCntv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getCntv());
                                startActivity(intent);
                            }
                        });
                        TextView tvHsTv = (TextView) viewHolder.setClick(R.id.item_look_lv_huashu_tv);
                        tvHsTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getHuashu());
                                startActivity(intent);
                            }
                        });
                        TextView tvMgTv = (TextView) viewHolder.setClick(R.id.item_look_lv_mangguo_tv);
                        tvMgTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getImgo());
                                startActivity(intent);
                            }
                        });
                        TextView tvLsTv = (TextView) viewHolder.setClick(R.id.item_look_lv_leshi_tv);
                        tvLsTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getLeshi());
                                startActivity(intent);
                            }
                        });
                        TextView tvQQTv = (TextView) viewHolder.setClick(R.id.item_look_lv_qq_tv);
                        tvQQTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getQq());
                                startActivity(intent);
                            }
                        });
                        TextView tvLsVp = (TextView) viewHolder.setClick(R.id.item_look_lv_levp_tv);
                        tvLsVp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getLevp());
                                startActivity(intent);
                            }
                        });
                        TextView tvTdTv = (TextView) viewHolder.setClick(R.id.item_look_lv_tudou_tv);
                        tvTdTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getTudou());
                                startActivity(intent);
                            }
                        });
                        TextView tvShTv = (TextView) viewHolder.setClick(R.id.item_look_lv_souhu_tv);
                        tvShTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getSohu());
                                startActivity(intent);
                            }
                        });
                        TextView tvYkTv = (TextView) viewHolder.setClick(R.id.item_look_lv_youku_tv);
                        tvYkTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getYouku());
                                startActivity(intent);
                            }
                        });
                        TextView tvXlTv = (TextView) viewHolder.setClick(R.id.item_look_lv_xunlei_tv);
                        tvXlTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), SecondVideoActivity.class);
                                intent.putExtra("webUrl", playlinksBean.getXunlei());
                                startActivity(intent);
                            }
                        });

                        if (playlinksBean.getQiyi() != null) {
                            tvAqy.setText("爱奇艺");

                        } else {
                            tvAqy.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getCntv() != null) {
                            tvCntv.setText("CNTV");
                        } else {
                            tvCntv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getHuashu() != null) {
                            tvHsTv.setText("华数TV");
                        } else {
                            tvHsTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getImgo() != null) {
                            tvMgTv.setText("芒果TV");
                        } else {
                            tvMgTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getLeshi() != null) {
                            tvLsTv.setText("乐视TV");
                        } else {
                            tvLsTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getQq() != null) {
                            tvQQTv.setText("腾讯视频");
                        } else {
                            tvQQTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getLevp() != null) {
                            tvLsVp.setText("乐视VP");
                        } else {
                            tvLsVp.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getTudou() != null) {
                            tvTdTv.setText("土豆视频");
                        } else {
                            tvTdTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getSohu() != null) {
                            tvShTv.setText("搜狐视频");
                        } else {
                            tvShTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getYouku() != null) {
                            tvYkTv.setText("优酷视频");
                        } else {
                            tvYkTv.setVisibility(View.GONE);
                        }

                        if (playlinksBean.getXunlei() != null) {
                            tvXlTv.setText("迅雷视频");
                        } else {
                            tvXlTv.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
        popupWindow.showAtLocation(contentView, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
                return false;
            }
        });


    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
    }

    private void initNet() {

        try {
            //转码
            areaUrl = URLEncoder.encode("海贼王", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        filmUrl = ToolsGather.SEARCH_VIDEO_URL + ToolsGather.SEARCH_APP_KEY + ToolsGather.FILM_NAME + areaUrl;
        tool().getData(filmUrl, SearchFilmBean.class, new NetTool.NetInterface<SearchFilmBean>() {
            @Override
            public void onSuccess(SearchFilmBean searchFilmBean) {
                if (searchFilmBean.getResult() != null) {
                    Log.d("LookFilmFragment", "searchFilmBean.getResult():" + searchFilmBean.getResult());
                    Log.d("LookFilmFragment", "searchFilmBean:" + searchFilmBean);
                    Glide.with(MyApp.getContext()).load(searchFilmBean.getResult().getCover()).into(iconIv);
                    titleTv.setText(searchFilmBean.getResult().getTitle());
                    yearTv.setText(searchFilmBean.getResult().getYear());
                    areaTv.setText(searchFilmBean.getResult().getArea());
                    dirTv.setText(searchFilmBean.getResult().getDir());
                    tagTv.setText(searchFilmBean.getResult().getTag());
                    descTv.setText(searchFilmBean.getResult().getDesc());
                }
            }

        });


    }
}
