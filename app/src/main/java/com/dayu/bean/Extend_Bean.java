package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
//参数设置
public class Extend_Bean {
//接口:http://192.168.1.106/yunnao/home/api/getExtendSetting
    /**
     * response : 1
     * content : [{"id":"1","name":"1/1秒 （慢读）","type":"1"}]
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
         * name : 1/1秒 （慢读）
         * type : 1
         */

        private String id;
        private String name;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
