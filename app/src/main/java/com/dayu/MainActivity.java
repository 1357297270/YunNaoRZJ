package com.dayu;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dayu.view.ClassRoomActivity;
import com.dayu.view.Details_Activity;
import com.dayu.view.ExtendActivity;
import com.dayu.view.ReadActivity;
import com.dayu.view.UpDataActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 更新课件
     */
    private Button mUpdata;
    /**
     * 课堂训练
     */
    private Button mClassroom;
    /**
     * 阅读测评
     */
    private Button mRead;
    /**
     * 视幅扩展训练
     */
    private Button mExtend;
    /**
     * 安全退出
     */
    private Button mQuit;
    private long lastTime=0; //记录上次点击的时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mUpdata = (Button) findViewById(R.id.updata);
        mUpdata.setOnClickListener(this);
        mClassroom = (Button) findViewById(R.id.classroom);
        mClassroom.setOnClickListener(this);
        mRead = (Button) findViewById(R.id.read);
        mRead.setOnClickListener(this);
        mExtend = (Button) findViewById(R.id.extend);
        mExtend.setOnClickListener(this);
        mQuit = (Button) findViewById(R.id.quit);
        mQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //更新课件
            case R.id.updata:
                Intent intent = new Intent(MainActivity.this, UpDataActivity.class);
                startActivity(intent);
                finish();
                break;
            //课堂训练
            case R.id.classroom:
                Intent intent1 = new Intent(MainActivity.this, ClassRoomActivity.class);
                startActivity(intent1);
                finish();
                break;
            //阅读测评
            case R.id.read:
                Intent intent2 = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(intent2);
                finish();
                break;
            //视幅扩展训练
            case R.id.extend:
                Intent intent3 = new Intent(MainActivity.this, ExtendActivity.class);
                startActivity(intent3);
                finish();
                break;
            //安全退出
            case R.id.quit:
                //System.exit(0);
                finish();
                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    /*@Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-lastTime)>2000){
            Toast.makeText(MainActivity.this, "在按一次退出程序", Toast.LENGTH_SHORT).show();
            lastTime=System.currentTimeMillis();
            }else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
