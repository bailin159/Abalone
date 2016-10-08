package com.example.bailin.abalone.service;

import java.util.List;

/**
 * Created by 白霖 on 16/9/21.
 */
public class SelectionVideoBean {


    private Object on_the_top;
    private boolean clear_cache;
    private int ts;
    private String result;


    private List<ItemListBean> item_list;

    public Object getOn_the_top() {
        return on_the_top;
    }

    public void setOn_the_top(Object on_the_top) {
        this.on_the_top = on_the_top;
    }

    public boolean isClear_cache() {
        return clear_cache;
    }

    public void setClear_cache(boolean clear_cache) {
        this.clear_cache = clear_cache;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ItemListBean> getItem_list() {
        return item_list;
    }

    public void setItem_list(List<ItemListBean> item_list) {
        this.item_list = item_list;
    }

    public static class ItemListBean {
        private String res_type;
        private String play_url;
        private String res_display_type;
        private String res_cover_url;
        private String gcid;
        private int res_subcategories;
        private int poster_width;
        private long id;
        private String play_count;
        private int duration;
        private int poster_height;
        private String ab_type;
        private String display_type;
        private String jump_url;
        private String res_title;
        private String from;
        private String cover_item;
        private int res_id;
        private int f_count;
        private String s_ab;

        public String getRes_type() {
            return res_type;
        }

        public void setRes_type(String res_type) {
            this.res_type = res_type;
        }

        public String getPlay_url() {
            return play_url;
        }

        public void setPlay_url(String play_url) {
            this.play_url = play_url;
        }

        public String getRes_display_type() {
            return res_display_type;
        }

        public void setRes_display_type(String res_display_type) {
            this.res_display_type = res_display_type;
        }

        public String getRes_cover_url() {
            return res_cover_url;
        }

        public void setRes_cover_url(String res_cover_url) {
            this.res_cover_url = res_cover_url;
        }

        public String getGcid() {
            return gcid;
        }

        public void setGcid(String gcid) {
            this.gcid = gcid;
        }

        public int getRes_subcategories() {
            return res_subcategories;
        }

        public void setRes_subcategories(int res_subcategories) {
            this.res_subcategories = res_subcategories;
        }

        public int getPoster_width() {
            return poster_width;
        }

        public void setPoster_width(int poster_width) {
            this.poster_width = poster_width;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPlay_count() {
            return play_count;
        }

        public void setPlay_count(String play_count) {
            this.play_count = play_count;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPoster_height() {
            return poster_height;
        }

        public void setPoster_height(int poster_height) {
            this.poster_height = poster_height;
        }

        public String getAb_type() {
            return ab_type;
        }

        public void setAb_type(String ab_type) {
            this.ab_type = ab_type;
        }

        public String getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(String display_type) {
            this.display_type = display_type;
        }

        public String getJump_url() {
            return jump_url;
        }

        public void setJump_url(String jump_url) {
            this.jump_url = jump_url;
        }

        public String getRes_title() {
            return res_title;
        }

        public void setRes_title(String res_title) {
            this.res_title = res_title;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getCover_item() {
            return cover_item;
        }

        public void setCover_item(String cover_item) {
            this.cover_item = cover_item;
        }

        public int getRes_id() {
            return res_id;
        }

        public void setRes_id(int res_id) {
            this.res_id = res_id;
        }

        public int getF_count() {
            return f_count;
        }

        public void setF_count(int f_count) {
            this.f_count = f_count;
        }

        public String getS_ab() {
            return s_ab;
        }

        public void setS_ab(String s_ab) {
            this.s_ab = s_ab;
        }
    }
}
