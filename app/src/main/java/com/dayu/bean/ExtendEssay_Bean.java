package com.dayu.bean;

/**
 * Created by Administrator on 2018/10/24.
 */
//获取短文资源
public class ExtendEssay_Bean {
//接口：http://192.168.1.106/yunnao/home/api/getExtendEssay
    /**
     * response : 1
     * content : {"id":"1","essay_url":"http://pf70k08pi.bkt.clouddn.com/extend_essay2018-09-20_5ba3574593057.docx"}
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
        /**
         * id : 1
         * essay_url : http://pf70k08pi.bkt.clouddn.com/extend_essay2018-09-20_5ba3574593057.docx
         */

        private String id;
        private String essay_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEssay_url() {
            return essay_url;
        }

        public void setEssay_url(String essay_url) {
            this.essay_url = essay_url;
        }
    }
}
