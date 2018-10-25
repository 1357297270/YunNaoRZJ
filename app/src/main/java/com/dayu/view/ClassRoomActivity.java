package com.dayu.view;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dayu.R;
import com.dayu.fragment.Grid_TimeFragment;
import com.dayu.fragment.LIst_TimeFragment;
import com.dayu.utils.NetStateUtil;


//课堂训练
public class ClassRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_room);

        requestNetData();

    }

    private void requestNetData() {
        if (NetStateUtil.isConn(this)) {
            initData();

        } else {
            Toast.makeText(this, "现在没有网络，请稍后重试！", Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {
        //加载时间的列表数据
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.list_fragment, new LIst_TimeFragment());
        fragmentTransaction.commit();
        //加载书架上的图片数据
        FragmentManager supportFragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.grid_fragment, new Grid_TimeFragment());
        fragmentTransaction1.commit();
        //Intent intent = getIntent();
       //Bundle bundle = intent.getExtras();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
