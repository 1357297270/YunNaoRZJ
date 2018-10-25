package com.dayu.bean;

/**
 * Created by Administrator on 2018/10/11.
 */
//详情页面
public class Details_Bean {

    /**
     * response : 1
     * content : {"word_num":"34","content":"http://pf70k08pi.bkt.clouddn.com/class_books2018-10-11_5bbea8a936e26.txt"}
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
         * word_num : 34
         * content : http://pf70k08pi.bkt.clouddn.com/class_books2018-10-11_5bbea8a936e26.txt
         */

        private String word_num;
        private String content;

        public String getWord_num() {
            return word_num;
        }

        public void setWord_num(String word_num) {
            this.word_num = word_num;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
