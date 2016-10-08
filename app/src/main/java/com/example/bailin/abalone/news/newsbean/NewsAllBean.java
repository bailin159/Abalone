package com.example.bailin.abalone.news.newsbean;

import java.util.List;

/**
 * 新闻页面的头条数据类
 * Created by CPC_272 on 16/9/13.
 */
public class NewsAllBean {


    /**
     * postid : PHOT2324D000100A
     * hasCover : false
     * hasHead : 1
     * replyCount : 14854
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_C0S4VDABbjzhanglimengupdateDoc
     * title : 合肥居民遭遇“黑枪” 阳台玻璃被击穿
     * order : 1
     * priority : 345
     * lmodify : 2016-09-13 18:16:30
     * boardid : photoview_bbs
     * ads : [{"docid":"C0ROH2CH05169QC9","title":"一言不合就收费?教你必杀技留着\"防身\"","tag":"doc","imgsrc":"http://cms-bucket.nosdn.127.net/3fae6880f7274d048c2fa2531d3ce95520160913191440.jpeg","subtitle":"","url":"C0ROH2CH05169QC9"},{"docid":"C0S5B6E805169QC9","title":"别人家的网红食堂，轻松甩你几条街","tag":"doc","imgsrc":"http://cms-bucket.nosdn.127.net/c2c5263ab93646bb84ee5ea6008183e720160913183636.jpeg","subtitle":"","url":"C0S5B6E805169QC9"},{"title":"住建部否认海绵城市试点失败 称在推进","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/37631833862e4fa88ae82dca867aa53220160913160915.jpeg","subtitle":"","url":"00AP0001|2197605"},{"title":"青岛一村过中秋现场发500万现金","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/ea97d6ecf03f4c3680dc40dd606e427920160913120917.jpeg","subtitle":"","url":"00AP0001|2197560"},{"title":"快播涉黄被判罚1千万 王欣等4人获刑","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/b9e303b979974822a6effc0a4790086320160913112644.jpeg","subtitle":"","url":"00AP0001|2197534"}]
     * photosetID : 00AP0001|2197645
     * template : normal1
     * votecount : 14024
     * skipID : 00AP0001|2197645
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/ee7f8ef6471146308666fe40a5dce1ed20160913181418.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/c63b993f0a5e4c4786897bf0a312f09120160913181419.jpeg"}]
     * source : 网易原创
     * ename : androidnews
     * imgsrc : http://cms-bucket.nosdn.127.net/7cfd7f2a3e7f47e0944891b67d1493e220160913181416.jpeg
     * tname : 头条
     * ptime : 2016-09-13 18:13:28
     */

    private List<T1348647909107Bean> T1348647909107;

    public List<T1348647909107Bean> getT1348647909107() {
        return T1348647909107;
    }

    public void setT1348647909107(List<T1348647909107Bean> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    public static class T1348647909107Bean {
        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String imgsrc;
        private String tname;
        private String ptime;
        /**
         * docid : C0ROH2CH05169QC9
         * title : 一言不合就收费?教你必杀技留着"防身"
         * tag : doc
         * imgsrc : http://cms-bucket.nosdn.127.net/3fae6880f7274d048c2fa2531d3ce95520160913191440.jpeg
         * subtitle :
         * url : C0ROH2CH05169QC9
         */

        private List<AdsBean> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/ee7f8ef6471146308666fe40a5dce1ed20160913181418.jpeg
         */

        private List<ImgextraBean> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsBean {
            private String docid;
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public String getDocid() {
                return docid;
            }

            public void setDocid(String docid) {
                this.docid = docid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
