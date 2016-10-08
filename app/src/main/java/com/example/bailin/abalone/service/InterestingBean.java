package com.example.bailin.abalone.service;

import java.util.List;

/**
 * Created by 白霖 on 16/9/27.
 */
public class InterestingBean {



    private String category;
    private String block;


    private List<InfoListBean> infoList;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public List<InfoListBean> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<InfoListBean> infoList) {
        this.infoList = infoList;
    }

    public static class InfoListBean {
        private String id;
        private String title;
        private String sub_category;
        private String pic;
        private String width;
        private String height;
        private String url;
        private String detailUrl;
        private String detailUrlIphone;
        private String detailUrlIpad;
        private String content;
        private String updateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_category() {
            return sub_category;
        }

        public void setSub_category(String sub_category) {
            this.sub_category = sub_category;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getDetailUrlIphone() {
            return detailUrlIphone;
        }

        public void setDetailUrlIphone(String detailUrlIphone) {
            this.detailUrlIphone = detailUrlIphone;
        }

        public String getDetailUrlIpad() {
            return detailUrlIpad;
        }

        public void setDetailUrlIpad(String detailUrlIpad) {
            this.detailUrlIpad = detailUrlIpad;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
