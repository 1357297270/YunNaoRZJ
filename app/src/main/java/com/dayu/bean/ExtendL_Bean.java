package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class ExtendL_Bean {

    /**
     * response : 1
     * content : [{"id":"1","name":"视点移动训练","pid":"0"},{"id":"2","name":"横向\u201c之\u201d字形运动","pid":"1"},{"id":"4","name":"视幅扩展训练","pid":"0"},{"id":"5","name":"请跟我走","pid":"4"}]
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
         * name : 视点移动训练
         * pid : 0
         */

        private String id;
        private String name;
        private String pid;

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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }
    }
}
