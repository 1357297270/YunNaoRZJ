package com.dayu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.dayu.MainActivity;
import com.dayu.R;
import com.dayu.bean.Classroom_Bean;
import com.dayu.bean.ExtendL_Bean;
import com.dayu.recycler.Adapter;
import com.dayu.recycler.Levelone;
import com.dayu.recycler.Levelzero;
import com.dayu.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */

public class ExtendL_Fragment extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView mExtendLeftRecycle;
    private Button mExtendBack;
    private String path="http://192.168.1.133/yunnao/home/api/getExtendCategory";

   ArrayList<MultiItemEntity> res;
   List<Levelzero> lv0 = new ArrayList<>();
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        private List<ExtendL_Bean.ContentBean> content;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            content = (List<ExtendL_Bean.ContentBean>) msg.obj;

        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.extend_left_ment, container, false);
        initView(view);
        //initDataL();
      addData();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
       mExtendLeftRecycle.setAdapter(new Adapter(res));
        mExtendLeftRecycle.setLayoutManager(manager);
        return view;
    }
   private void addData() {
        res = new ArrayList<>();
        lv0.clear();
        lv0.add(new Levelzero("视点移动训练"));
        lv0.add(new Levelzero("视幅扩展训练"));
        lv0.add(new Levelzero("瞬间感知能力"));
        for(int i = 0;i<4;i++){
            Levelone lv1 = new Levelone("横向”之“字形运动");
            lv0.get(0).addSubItem(lv1);
        }
        for(int i = 0;i<2;i++){
            Levelone lv1 = new Levelone("请跟我走");
            lv0.get(1).addSubItem(lv1);
        }
        for(int i = 0;i<6;i++){
            Levelone lv1 = new Levelone("数字训练");
            lv0.get(2).addSubItem(lv1);
        }
        for (int j = 0; j < lv0.size(); j++) {
            res.add(lv0.get(j));
        }
        return ;
    }

    private void initDataL() {
        //调用okhttp工具类
        OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {

            private List<Classroom_Bean.ContentBean.CategoryBean> category;

            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                ExtendL_Bean extendL_bean = gson.fromJson(string, ExtendL_Bean.class);
                List<ExtendL_Bean.ContentBean> content = extendL_bean.getContent();
                Message message = new Message();
                message.obj = content;
                handler.sendMessage(message);

            }
        });
    }
    private void initView(View view) {
        mExtendLeftRecycle = (RecyclerView) view.findViewById(R.id.extend_left_recycle);
        mExtendBack = (Button) view.findViewById(R.id.extend_back);
        mExtendBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.extend_back:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }
}
