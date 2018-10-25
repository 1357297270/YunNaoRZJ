package com.dayu.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dayu.R;
import com.dayu.fragment.ExtendL_Fragment;
import com.dayu.fragment.ExtendR_Fragment;

public class ExtendActivity extends AppCompatActivity {
//视幅扩展训练
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend);
        initData();
    }
    private void initData() {
        //训练模式
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.list_left_fragment, new ExtendL_Fragment());
        fragmentTransaction.commit();
        //视图模块
        FragmentManager supportFragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.list_rigth_fragment, new ExtendR_Fragment());
        fragmentTransaction1.commit();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
