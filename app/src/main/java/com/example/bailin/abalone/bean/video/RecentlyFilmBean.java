package com.example.bailin.abalone.bean.video;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 刘士壬 on 16/9/14.
 */
public class RecentlyFilmBean {




    private String reason;


    private ResulttBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResulttBean getResult() {
        return result;
    }

    public void setResult(ResulttBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResulttBean {
        private String title;
        private String url;
        private String m_url;
        private String morelink;
        private String date;


        private List<DataiBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getM_url() {
            return m_url;
        }

        public void setM_url(String m_url) {
            this.m_url = m_url;
        }

        public String getMorelink() {
            return morelink;
        }

        public void setMorelink(String morelink) {
            this.morelink = morelink;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<DataiBean> getData() {
            return data;
        }

        public void setData(List<DataiBean> data) {
            this.data = data;
        }

        public static class DataiBean {
            private String name;
            private String link;
            /**
             * tvTitle : 鲨滩
             * iconaddress : http://p2.qhmsg.com/t01368d3d795b910693.jpg?size=300x400
             * iconlinkUrl : http://movie.mtime.com/222522/
             * m_iconlinkUrl : http://m.mtime.cn/#!/movie/222522/
             * subHead : 今日28家影院上映
             * grade : 7.3
             * gradeNum : /10.0(时光网)
             * playDate : {"showname":"上映日期","data":"2016年9月9日","data2":"2016-9-9"}
             * director : {"showname":"导演","data":{"1":{"name":"佐米·希尔拉","link":"http://people.mtime.com/898186/"},"m_1":{"link":"http://m.mtime.cn/#!/person/898186/"}}}
             * star : {"showname":"主演","data":{"1":{"name":"布蕾克·莱弗利","link":"http://people.mtime.com/913459/"},"2":{"name":"奥斯卡·贾恩那达","link":"http://people.mtime.com/917019/"},"3":{"name":"塞多纳·莱格","link":"http://people.mtime.com/2196795/"},"4":{"name":"布莱特·卡伦","link":"http://people.mtime.com/970555/"},"m_1":{"link":"http://m.mtime.cn/#!/person/913459/"},"m_2":{"link":"http://m.mtime.cn/#!/person/917019/"},"m_3":{"link":"http://m.mtime.cn/#!/person/2196795/"},"m_4":{"link":"http://m.mtime.cn/#!/person/970555/"}}}
             * type : {"showname":"类型","data":{"1":{"name":"惊悚","link":"http://movie.mtime.com/movie/search/section/?type=Thriller"},"2":{"name":"动作","link":"http://movie.mtime.com/movie/search/section/?type=Action"},"3":{"name":"剧情","link":"http://movie.mtime.com/movie/search/section/?type=Drama"}}}
             * story : {"showname":"剧情","data":{"storyBrief":"南希·亚当斯（布蕾克·莱弗利饰）在一个僻静的海滩冲浪时，发现有一条大白鲨正在附近游弋觅食..","storyMoreLink":"http://movie.mtime.com/222522/plots.html"}}
             * more : {"data":[{"name":"选座购票","link":"http://theater.mtime.com/China_Liaoning_Province_Dalian/movie/222522/"},{"name":"剧照/海报","link":"http://movie.mtime.com/222522/posters_and_images/"},{"name":"热门影评","link":"http://movie.mtime.com/222522/comment.html"},{"link":"http://m.mtime.cn/#!/movie/222522/posters_and_images/"},{"link":"http://m.mtime.cn/#!/movie/222522/comment/"},{"link":"http://m.mtime.cn/#!/theater/729/movie/222522/"}],"showname":"更多"}
             */

            private List<DataiteBean> data;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public List<DataiteBean> getData() {
                return data;
            }

            public void setData(List<DataiteBean> data) {
                this.data = data;
            }

            public static class DataiteBean {
                private String tvTitle;
                private String iconaddress;
                private String iconlinkUrl;
                private String m_iconlinkUrl;
                private String subHead;
                private String grade;
                private String gradeNum;
                /**
                 * showname : 上映日期
                 * data : 2016年9月9日
                 * data2 : 2016-9-9
                 */

                private PlayDateBean playDate;
                /**
                 * showname : 导演
                 * data : {"1":{"name":"佐米·希尔拉","link":"http://people.mtime.com/898186/"},"m_1":{"link":"http://m.mtime.cn/#!/person/898186/"}}
                 */

                private DirectorBean director;
                /**
                 * showname : 主演
                 * data : {"1":{"name":"布蕾克·莱弗利","link":"http://people.mtime.com/913459/"},"2":{"name":"奥斯卡·贾恩那达","link":"http://people.mtime.com/917019/"},"3":{"name":"塞多纳·莱格","link":"http://people.mtime.com/2196795/"},"4":{"name":"布莱特·卡伦","link":"http://people.mtime.com/970555/"},"m_1":{"link":"http://m.mtime.cn/#!/person/913459/"},"m_2":{"link":"http://m.mtime.cn/#!/person/917019/"},"m_3":{"link":"http://m.mtime.cn/#!/person/2196795/"},"m_4":{"link":"http://m.mtime.cn/#!/person/970555/"}}
                 */

                private StarBean star;
                /**
                 * showname : 类型
                 * data : {"1":{"name":"惊悚","link":"http://movie.mtime.com/movie/search/section/?type=Thriller"},"2":{"name":"动作","link":"http://movie.mtime.com/movie/search/section/?type=Action"},"3":{"name":"剧情","link":"http://movie.mtime.com/movie/search/section/?type=Drama"}}
                 */

                private TypeBean type;
                /**
                 * showname : 剧情
                 * data : {"storyBrief":"南希·亚当斯（布蕾克·莱弗利饰）在一个僻静的海滩冲浪时，发现有一条大白鲨正在附近游弋觅食..","storyMoreLink":"http://movie.mtime.com/222522/plots.html"}
                 */

                private StoryBean story;
                /**
                 * data : [{"name":"选座购票","link":"http://theater.mtime.com/China_Liaoning_Province_Dalian/movie/222522/"},{"name":"剧照/海报","link":"http://movie.mtime.com/222522/posters_and_images/"},{"name":"热门影评","link":"http://movie.mtime.com/222522/comment.html"},{"link":"http://m.mtime.cn/#!/movie/222522/posters_and_images/"},{"link":"http://m.mtime.cn/#!/movie/222522/comment/"},{"link":"http://m.mtime.cn/#!/theater/729/movie/222522/"}]
                 * showname : 更多
                 */

                private MoreBean more;

                public String getTvTitle() {
                    return tvTitle;
                }

                public void setTvTitle(String tvTitle) {
                    this.tvTitle = tvTitle;
                }

                public String getIconaddress() {
                    return iconaddress;
                }

                public void setIconaddress(String iconaddress) {
                    this.iconaddress = iconaddress;
                }

                public String getIconlinkUrl() {
                    return iconlinkUrl;
                }

                public void setIconlinkUrl(String iconlinkUrl) {
                    this.iconlinkUrl = iconlinkUrl;
                }

                public String getM_iconlinkUrl() {
                    return m_iconlinkUrl;
                }

                public void setM_iconlinkUrl(String m_iconlinkUrl) {
                    this.m_iconlinkUrl = m_iconlinkUrl;
                }

                public String getSubHead() {
                    return subHead;
                }

                public void setSubHead(String subHead) {
                    this.subHead = subHead;
                }

                public String getGrade() {
                    return grade;
                }

                public void setGrade(String grade) {
                    this.grade = grade;
                }

                public String getGradeNum() {
                    return gradeNum;
                }

                public void setGradeNum(String gradeNum) {
                    this.gradeNum = gradeNum;
                }

                public PlayDateBean getPlayDate() {
                    return playDate;
                }

                public void setPlayDate(PlayDateBean playDate) {
                    this.playDate = playDate;
                }

                public DirectorBean getDirector() {
                    return director;
                }

                public void setDirector(DirectorBean director) {
                    this.director = director;
                }

                public StarBean getStar() {
                    return star;
                }

                public void setStar(StarBean star) {
                    this.star = star;
                }

                public TypeBean getType() {
                    return type;
                }

                public void setType(TypeBean type) {
                    this.type = type;
                }

                public StoryBean getStory() {
                    return story;
                }

                public void setStory(StoryBean story) {
                    this.story = story;
                }

                public MoreBean getMore() {
                    return more;
                }

                public void setMore(MoreBean more) {
                    this.more = more;
                }

                public static class PlayDateBean {
                    private String showname;
                    private String data;
                    private String data2;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public String getData() {
                        return data;
                    }

                    public void setData(String data) {
                        this.data = data;
                    }

                    public String getData2() {
                        return data2;
                    }

                    public void setData2(String data2) {
                        this.data2 = data2;
                    }
                }

                public static class DirectorBean {
                    private String showname;
                    /**
                     * 1 : {"name":"佐米·希尔拉","link":"http://people.mtime.com/898186/"}
                     * m_1 : {"link":"http://m.mtime.cn/#!/person/898186/"}
                     */

                    private dataibean data;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public dataibean getData() {
                        return data;
                    }

                    public void setData(dataibean data) {
                        this.data = data;
                    }

                    public static class dataibean {
                        /**
                         * name : 佐米·希尔拉
                         * link : http://people.mtime.com/898186/
                         */

                        @SerializedName("1")
                        private Bean1 value1;
                        /**
                         * link : http://m.mtime.cn/#!/person/898186/
                         */

                        private M1Bean m_1;

                        public Bean1 getValue1() {
                            return value1;
                        }

                        public void setValue1(Bean1 value1) {
                            this.value1 = value1;
                        }

                        public M1Bean getM_1() {
                            return m_1;
                        }

                        public void setM_1(M1Bean m_1) {
                            this.m_1 = m_1;
                        }

                        public static class Bean1 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class M1Bean {
                            private String link;

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }
                    }
                }

                public static class StarBean {
                    private String showname;
                    /**
                     * 1 : {"name":"布蕾克·莱弗利","link":"http://people.mtime.com/913459/"}
                     * 2 : {"name":"奥斯卡·贾恩那达","link":"http://people.mtime.com/917019/"}
                     * 3 : {"name":"塞多纳·莱格","link":"http://people.mtime.com/2196795/"}
                     * 4 : {"name":"布莱特·卡伦","link":"http://people.mtime.com/970555/"}
                     * m_1 : {"link":"http://m.mtime.cn/#!/person/913459/"}
                     * m_2 : {"link":"http://m.mtime.cn/#!/person/917019/"}
                     * m_3 : {"link":"http://m.mtime.cn/#!/person/2196795/"}
                     * m_4 : {"link":"http://m.mtime.cn/#!/person/970555/"}
                     */

                    private DataqBean data;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public DataqBean getData() {
                        return data;
                    }

                    public void setData(DataqBean data) {
                        this.data = data;
                    }

                    public static class DataqBean {
                        /**
                         * name : 布蕾克·莱弗利
                         * link : http://people.mtime.com/913459/
                         */

                        @SerializedName("1")
                        private Bean1 value1;
                        /**
                         * name : 奥斯卡·贾恩那达
                         * link : http://people.mtime.com/917019/
                         */

                        @SerializedName("2")
                        private Bean2 value2;
                        /**
                         * name : 塞多纳·莱格
                         * link : http://people.mtime.com/2196795/
                         */

                        @SerializedName("3")
                        private Bean3 value3;
                        /**
                         * name : 布莱特·卡伦
                         * link : http://people.mtime.com/970555/
                         */

                        @SerializedName("4")
                        private Bean4 value4;
                        /**
                         * link : http://m.mtime.cn/#!/person/913459/
                         */

                        private M1Bean m_1;
                        /**
                         * link : http://m.mtime.cn/#!/person/917019/
                         */

                        private M2Bean m_2;
                        /**
                         * link : http://m.mtime.cn/#!/person/2196795/
                         */

                        private M3Bean m_3;
                        /**
                         * link : http://m.mtime.cn/#!/person/970555/
                         */

                        private M4Bean m_4;

                        public Bean1 getValue1() {
                            return value1;
                        }

                        public void setValue1(Bean1 value1) {
                            this.value1 = value1;
                        }

                        public Bean2 getValue2() {
                            return value2;
                        }

                        public void setValue2(Bean2 value2) {
                            this.value2 = value2;
                        }

                        public Bean3 getValue3() {
                            return value3;
                        }

                        public void setValue3(Bean3 value3) {
                            this.value3 = value3;
                        }

                        public Bean4 getValue4() {
                            return value4;
                        }

                        public void setValue4(Bean4 value4) {
                            this.value4 = value4;
                        }

                        public M1Bean getM_1() {
                            return m_1;
                        }

                        public void setM_1(M1Bean m_1) {
                            this.m_1 = m_1;
                        }

                        public M2Bean getM_2() {
                            return m_2;
                        }

                        public void setM_2(M2Bean m_2) {
                            this.m_2 = m_2;
                        }

                        public M3Bean getM_3() {
                            return m_3;
                        }

                        public void setM_3(M3Bean m_3) {
                            this.m_3 = m_3;
                        }

                        public M4Bean getM_4() {
                            return m_4;
                        }

                        public void setM_4(M4Bean m_4) {
                            this.m_4 = m_4;
                        }

                        public static class Bean1 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class Bean2 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class Bean3 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class Bean4 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class M1Bean {
                            private String link;

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class M2Bean {
                            private String link;

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class M3Bean {
                            private String link;

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class M4Bean {
                            private String link;

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }
                    }
                }

                public static class TypeBean {
                    private String showname;
                    /**
                     * 1 : {"name":"惊悚","link":"http://movie.mtime.com/movie/search/section/?type=Thriller"}
                     * 2 : {"name":"动作","link":"http://movie.mtime.com/movie/search/section/?type=Action"}
                     * 3 : {"name":"剧情","link":"http://movie.mtime.com/movie/search/section/?type=Drama"}
                     */

                    private DatawBean data;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public DatawBean getData() {
                        return data;
                    }

                    public void setData(DatawBean data) {
                        this.data = data;
                    }

                    public static class DatawBean {
                        /**
                         * name : 惊悚
                         * link : http://movie.mtime.com/movie/search/section/?type=Thriller
                         */

                        @SerializedName("1")
                        private Bean1 value1;
                        /**
                         * name : 动作
                         * link : http://movie.mtime.com/movie/search/section/?type=Action
                         */

                        @SerializedName("2")
                        private Bean2 value2;
                        /**
                         * name : 剧情
                         * link : http://movie.mtime.com/movie/search/section/?type=Drama
                         */

                        @SerializedName("3")
                        private Bean3 value3;

                        public Bean1 getValue1() {
                            return value1;
                        }

                        public void setValue1(Bean1 value1) {
                            this.value1 = value1;
                        }

                        public Bean2 getValue2() {
                            return value2;
                        }

                        public void setValue2(Bean2 value2) {
                            this.value2 = value2;
                        }

                        public Bean3 getValue3() {
                            return value3;
                        }

                        public void setValue3(Bean3 value3) {
                            this.value3 = value3;
                        }

                        public static class Bean1 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class Bean2 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }

                        public static class Bean3 {
                            private String name;
                            private String link;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }
                        }
                    }
                }

                public static class StoryBean {
                    private String showname;
                    /**
                     * storyBrief : 南希·亚当斯（布蕾克·莱弗利饰）在一个僻静的海滩冲浪时，发现有一条大白鲨正在附近游弋觅食..
                     * storyMoreLink : http://movie.mtime.com/222522/plots.html
                     */

                    private DataBean data;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public DataBean getData() {
                        return data;
                    }

                    public void setData(DataBean data) {
                        this.data = data;
                    }

                    public static class DataBean {
                        private String storyBrief;
                        private String storyMoreLink;

                        public String getStoryBrief() {
                            return storyBrief;
                        }

                        public void setStoryBrief(String storyBrief) {
                            this.storyBrief = storyBrief;
                        }

                        public String getStoryMoreLink() {
                            return storyMoreLink;
                        }

                        public void setStoryMoreLink(String storyMoreLink) {
                            this.storyMoreLink = storyMoreLink;
                        }
                    }
                }

                public static class MoreBean {
                    private String showname;
                    /**
                     * name : 选座购票
                     * link : http://theater.mtime.com/China_Liaoning_Province_Dalian/movie/222522/
                     */

                    private List<DatavBean> data;

                    public String getShowname() {
                        return showname;
                    }

                    public void setShowname(String showname) {
                        this.showname = showname;
                    }

                    public List<DatavBean> getData() {
                        return data;
                    }

                    public void setData(List<DatavBean> data) {
                        this.data = data;
                    }

                    public static class DatavBean {
                        private String name;
                        private String link;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getLink() {
                            return link;
                        }

                        public void setLink(String link) {
                            this.link = link;
                        }
                    }
                }
            }
        }
    }
}
