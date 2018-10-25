package com.dayu.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dayu.MainActivity;
import com.dayu.R;
import com.dayu.adapter.Read_Adapter;
import com.dayu.bean.Read_Bean;
import com.dayu.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.util.List;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    private String urlPath="http://192.168.1.106/yunnao/home/api/";
    private RecyclerView mReadRecycle;
    private String path = urlPath+"getReadBooks";
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final List<Read_Bean.ContentBean> list = (List<Read_Bean.ContentBean>) msg.obj;
            Read_Adapter read_adapter = new Read_Adapter(list, ReadActivity.this);
            mReadRecycle.setAdapter(read_adapter);
            mReadRecycle.setLayoutManager(new GridLayoutManager(ReadActivity.this, 4));
         read_adapter.setOnItemClickListener2(new Read_Adapter.OnItemClickListener2() {
             @Override
             public void onClick(int position, String id) {

                 Intent intent = new Intent(ReadActivity.this, ReadStart_Activity.class);
               intent.putExtra("sid",id);
                 startActivity(intent);
                 finish();
             }
         });
        }
    };
    /**
     * 返回首页
     */
    private Button mReadBack;


    //阅读测评
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        initView();
        initData();
    }

    private void initData() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {

            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                Read_Bean read_bean = gson.fromJson(string, Read_Bean.class);
                List<Read_Bean.ContentBean> content = read_bean.getContent();
                Message message = new Message();
                message.obj = content;
                handler.sendMessage(message);
            }
        });
    }

    private void initView() {
        mReadRecycle = (RecyclerView) findViewById(R.id.read_recycle);
        mReadBack = (Button) findViewById(R.id.read_back);
        mReadBack.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.read_back:
                //返回到首页
                Intent intent = new Intent(ReadActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
