package com.dayu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class Read_page_Bean {

    /**
     * response : 1
     * content : {"book":{"id":"4","word_num":"5455","content":"http://pf70k08pi.bkt.clouddn.com/read_books2018-10-11_5bbea8c0306e3.txt"},"ti":[{"id":"10","bid":"4","question":"问题四","a":"1个","b":"2个","c":"3个","d":"4个","right":"d","createtime":"1537330287"},{"id":"9","bid":"4","question":"问题三","a":"1个","b":"2个","c":"3个","d":"4个","right":"c","createtime":"1537330270"}]}
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
         * book : {"id":"4","word_num":"5455","content":"http://pf70k08pi.bkt.clouddn.com/read_books2018-10-11_5bbea8c0306e3.txt"}
         * ti : [{"id":"10","bid":"4","question":"问题四","a":"1个","b":"2个","c":"3个","d":"4个","right":"d","createtime":"1537330287"},{"id":"9","bid":"4","question":"问题三","a":"1个","b":"2个","c":"3个","d":"4个","right":"c","createtime":"1537330270"}]
         */

        private BookBean book;
        private List<TiBean> ti;

        public BookBean getBook() {
            return book;
        }

        public void setBook(BookBean book) {
            this.book = book;
        }

        public List<TiBean> getTi() {
            return ti;
        }

        public void setTi(List<TiBean> ti) {
            this.ti = ti;
        }

        public static class BookBean {
            /**
             * id : 4
             * word_num : 5455
             * content : http://pf70k08pi.bkt.clouddn.com/read_books2018-10-11_5bbea8c0306e3.txt
             */

            private String id;
            private String word_num;
            private String content;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

        public static class TiBean {
            /**
             * id : 10
             * bid : 4
             * question : 问题四
             * a : 1个
             * b : 2个
             * c : 3个
             * d : 4个
             * right : d
             * createtime : 1537330287
             */

            private String id;
            private String bid;
            private String question;
            private String a;
            private String b;
            private String c;
            private String d;
            private String right;
            private String createtime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }

            public String getB() {
                return b;
            }

            public void setB(String b) {
                this.b = b;
            }

            public String getC() {
                return c;
            }

            public void setC(String c) {
                this.c = c;
            }

            public String getD() {
                return d;
            }

            public void setD(String d) {
                this.d = d;
            }

            public String getRight() {
                return right;
            }

            public void setRight(String right) {
                this.right = right;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }
        }
    }
}
