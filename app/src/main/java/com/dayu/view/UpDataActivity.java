package com.dayu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dayu.MainActivity;
import com.dayu.R;

public class UpDataActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 开始下载
     */
    private Button mStart;
    /**
     * 清除缓存
     */
    private Button mClear;
    /**
     * 返回首页
     */
    private Button mBack;

    //更新课件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_data);
        initView();
    }

    private void initView() {
        mStart = (Button) findViewById(R.id.start);
        mStart.setOnClickListener(this);
        mClear = (Button) findViewById(R.id.clear);
        mClear.setOnClickListener(this);
        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                break;
            case R.id.clear:
                break;
            case R.id.back:
                //返回到首页
                Intent intent = new Intent(UpDataActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
