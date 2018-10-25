package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
//
//获取图片资源
// 接口：http://192.168.1.106/yunnao/home/api/getExtendImg
public class ExtendImg_Bean {
    /**
     * response : 1
     * content : [{"id":"1","img_url":"/yunnao/Public/attached/2018/09/20/5ba34eec1109d.gif"}]
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
         * id : 1
         * img_url : /yunnao/Public/attached/2018/09/20/5ba34eec1109d.gif
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
