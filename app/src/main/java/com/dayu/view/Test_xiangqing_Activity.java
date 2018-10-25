package com.dayu.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dayu.R;
import com.dayu.adapter.Read_Test_Adapter;
import com.dayu.api.Content;
import com.dayu.bean.Read_page_Bean;
import com.dayu.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.util.List;

public class Test_xiangqing_Activity extends AppCompatActivity implements View.OnClickListener {
    private String urlPath="http://192.168.1.106/yunnao/home/api/";
    private String path = urlPath+"getReadTi?id=3";
    /**
     * 退出
     */
    private Button mButTuichu;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        private List<Read_page_Bean.ContentBean.TiBean> list;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            list = (List<Read_page_Bean.ContentBean.TiBean>) msg.obj;

            Read_Test_Adapter read_test_adapter = new Read_Test_Adapter(list, Test_xiangqing_Activity.this);
            mRecycleReadtest.setAdapter(read_test_adapter);
            mRecycleReadtest.setLayoutManager(new LinearLayoutManager(Test_xiangqing_Activity.this, LinearLayoutManager.VERTICAL, false));

        }
    };
    private RecyclerView mRecycleReadtest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_xiangqing_);
        urlPath = Content.URL_PATH;
        initView();
        initData();
    }

    private void initView() {
        mButTuichu = (Button) findViewById(R.id.but_tuichu);
        mButTuichu.setOnClickListener(this);
        mRecycleReadtest = (RecyclerView) findViewById(R.id.recycle_readtest);
    }

    private void initData() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {
            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                Read_page_Bean read_page_bean = gson.fromJson(string, Read_page_Bean.class);
                List<Read_page_Bean.ContentBean.TiBean> list = read_page_bean.getContent().getTi();
                Message message = new Message();
                message.obj = list;
                handler.sendMessage(message);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_tuichu:
                Intent intent = new Intent(Test_xiangqing_Activity.this, ReadStart_Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
