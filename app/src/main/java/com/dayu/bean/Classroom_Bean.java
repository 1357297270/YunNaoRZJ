package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
//课堂训练相关接口
public class Classroom_Bean {

    /**
     * response : 1
     * content : {"category":[{"id":"4","name":"1000字以下/分钟","createtime":"1537156240"},{"id":"5","name":"1000-2000/分钟","createtime":"1537156249"},{"id":"6","name":"2000-3000/分钟","createtime":"1537156259"},{"id":"7","name":"3000-4000/分钟","createtime":"1537156284"},{"id":"8","name":"4000-5000/分钟","createtime":"1537156303"},{"id":"9","name":"5000-6500/分钟","createtime":"1537156349"},{"id":"10","name":"6500-8000/分钟","createtime":"1537156365"},{"id":"11","name":"8000-9500/分钟","createtime":"1537156392"},{"id":"12","name":"9500-11000/分钟","createtime":"1537156407"},{"id":"13","name":"11000-12500/分钟","createtime":"1537156445"},{"id":"14","name":"12500-14000/分钟","createtime":"1537156465"}],"books":[{"id":"10","img_url":"/yunnao/Public/attached/2018/10/10/5bbd945278c1f.png"},{"id":"11","img_url":"/yunnao/Public/attached/2018/10/10/5bbd945f6b986.png"},{"id":"12","img_url":"/yunnao/Public/attached/2018/10/10/5bbd946a3ffef.png"}]}
     */

    private int response;
    private ContentBean content;

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private List<CategoryBean> category;
        private List<BooksBean> books;

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<BooksBean> getBooks() {
            return books;
        }

        public void setBooks(List<BooksBean> books) {
            this.books = books;
        }

        public static class CategoryBean {
            /**
             * id : 4
             * name : 1000字以下/分钟
             * createtime : 1537156240
             */

            private String id;
            private String name;
            private String createtime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }
        }

        public static class BooksBean {
            /**
             * id : 10
             * img_url : /yunnao/Public/attached/2018/10/10/5bbd945278c1f.png
             */

            private String id;
            private String img_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
