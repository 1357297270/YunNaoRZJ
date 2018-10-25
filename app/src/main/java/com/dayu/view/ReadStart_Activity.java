package com.dayu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dayu.R;
import com.dayu.bean.Read_page_Bean;
import com.dayu.page.PageWidget;
import com.dayu.page.PageWidgetAdapter;
import com.dayu.utils.OkhttpUtils;
import com.google.gson.Gson;

public class ReadStart_Activity extends AppCompatActivity implements View.OnClickListener {
    private String urlPath="http://192.168.1.106/yunnao/home/api/";
    /**
     * 开始
     */
    private Button mReadStartBut;
    /**
     * 00:00:00
     */
    private Button mReadTimeBut;
    /**
     * 退出
     */
    private Button mReadTuichuBut;

    private TextView mTextTitle;
    private String path = urlPath+"getReadTi?id=4";
    /**
     * 结束
     */
    private Button mReadStopBut;
    private Read_page_Bean.ContentBean.BookBean book;
    private String content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_start_);
        Intent intent1 = getIntent();
        String sid = intent1.getStringExtra("sid");
        Toast.makeText(this, sid+"", Toast.LENGTH_SHORT).show();
        PageWidget page = (PageWidget) findViewById(R.id.main_pageWidget);
        BaseAdapter adapter = new PageWidgetAdapter(this);
        page.setAdapter(adapter);


        initView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void initData() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {
            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                Read_page_Bean read_page_bean = gson.fromJson(string, Read_page_Bean.class);
                book = read_page_bean.getContent().getBook();
                content = book.getContent();
               // initDetails();
                //mTextTitle.setText(content);
            }
        });
    }

    private void initDetails() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(content, new OkhttpUtils.fun1() {
            @Override
            public void onres(String string) {

                mTextTitle.setText(string);


            }
        });
    }

    private void initView() {
        mReadStartBut = (Button) findViewById(R.id.read_start_but);
        mReadStartBut.setOnClickListener(this);
        mReadTimeBut = (Button) findViewById(R.id.read_time_but);
        mReadTimeBut.setOnClickListener(this);
        mReadTuichuBut = (Button) findViewById(R.id.read_tuichu_but);
        mReadTuichuBut.setOnClickListener(this);
      //  mTextTitle = (TextView) findViewById(R.id.text_title);
        mReadStopBut = (Button) findViewById(R.id.read_stop_but);
        mReadStopBut.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //开始
            case R.id.read_start_but:
                //initData();
                break;
            //结束
            case R.id.read_stop_but:
                Intent intent = new Intent(ReadStart_Activity.this, Test_xiangqing_Activity.class);
                startActivity(intent);
                finish();
                break;
            //计时器
            case R.id.read_time_but:
                break;
            //退出
            case R.id.read_tuichu_but:
                Intent intent1 = new Intent(ReadStart_Activity.this, ReadActivity.class);
                startActivity(intent1);
                finish();
                break;

        }
    }
}
