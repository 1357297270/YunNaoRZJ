package com.dayu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dayu.MainActivity;
import com.dayu.R;
import com.dayu.adapter.ClassRoom_Adapter;
import com.dayu.api.Content;
import com.dayu.bean.Classroom_Bean;
import com.dayu.utils.OkhttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11.
 */

public class LIst_TimeFragment extends Fragment implements View.OnClickListener {
    private String urlPath;
    private View view;
    private RecyclerView mLeftRecycle;
    public String path = "http://192.168.1.106/yunnao/home/api/getClassCategory";
    /**
     * 返回首页
     */
    private Button mBackClass;
    private List<Classroom_Bean.ContentBean.CategoryBean> list;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        private ClassRoom_Adapter classRoom_adapter;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //左边的数据请求
            list = (List<Classroom_Bean.ContentBean.CategoryBean>) msg.obj;
            classRoom_adapter = new ClassRoom_Adapter(list, getActivity());

            mLeftRecycle.setAdapter(classRoom_adapter);
            mLeftRecycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            //添加自定义分割线
            DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
            divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
            mLeftRecycle.addItemDecoration(divider);
          classRoom_adapter.setOnItemClickListener(new ClassRoom_Adapter.OnItemClickListener() {
                @Override
                public void onClick(int position,String id) {
                    Intent intent = new Intent(getActivity(), Grid_TimeFragment.class);
                   // intent.putExtra("",id);
                    startActivity(intent);

                    Toast.makeText(getActivity(), id+"", Toast.LENGTH_SHORT).show();

                }
            });
        }
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_ment, container, false);
        urlPath = Content.URL_PATH;
        initView(view);


        return view;
    }

    private void initView(View view) {
        mLeftRecycle = (RecyclerView) view.findViewById(R.id.left_recycle);
        mBackClass = (Button) view.findViewById(R.id.back_class);
        mBackClass.setOnClickListener(this);
        initDataL();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_class:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }

    private void initDataL() {
        //调用okhttp工具类
        OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {

            private List<Classroom_Bean.ContentBean.CategoryBean> category;

            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                Classroom_Bean classroom_bean = gson.fromJson(string, Classroom_Bean.class);
                category = classroom_bean.getContent().getCategory();
                Message message = new Message();
                message.obj = category;
                handler.sendMessage(message);

            }
        });
    }
}
