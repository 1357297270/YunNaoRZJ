package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11.
 */

public class Read_Bean {

    /**
     * response : 1
     * content : [{"id":"4","img_url":"/yunnao/Public/attached/2018/10/11/5bbea93421282.jpg"},{"id":"3","img_url":"/yunnao/Public/attached/2018/10/11/5bbeb0b7561e6.jpg"}]
     */

    private int response;
    private List<ContentBean> content;

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * id : 4
         * img_url : /yunnao/Public/attached/2018/10/11/5bbea93421282.jpg
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
