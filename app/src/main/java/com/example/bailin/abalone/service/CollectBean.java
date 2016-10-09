package com.example.bailin.abalone.service;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 白霖 on 16/10/8.
 */
@Entity
public class CollectBean {
    @Id(autoincrement = true)
    private Long id;
    private String play_url;
    private String publisher_name;
    private String res_title;
    private String play_count;
    private String duration;
    @Generated(hash = 67820415)
    public CollectBean(Long id, String play_url, String publisher_name,
            String res_title, String play_count, String duration) {
        this.id = id;
        this.play_url = play_url;
        this.publisher_name = publisher_name;
        this.res_title = res_title;
        this.play_count = play_count;
        this.duration = duration;
    }
    @Generated(hash = 420494524)
    public CollectBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPlay_url() {
        return this.play_url;
    }
    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }
    public String getPublisher_name() {
        return this.publisher_name;
    }
    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
    public String getRes_title() {
        return this.res_title;
    }
    public void setRes_title(String res_title) {
        this.res_title = res_title;
    }
    public String getPlay_count() {
        return this.play_count;
    }
    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }
    public String getDuration() {
        return this.duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
