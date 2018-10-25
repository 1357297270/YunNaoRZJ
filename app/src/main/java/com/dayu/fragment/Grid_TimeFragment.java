package com.dayu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dayu.R;
import com.dayu.adapter.ClassRoom_Adapter_R;
import com.dayu.bean.Classroom_Bean;
import com.dayu.utils.OkhttpUtils;
import com.dayu.view.Details_Activity;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11.
 */
//课堂训练右边的书架
public class Grid_TimeFragment extends Fragment {
    public String path = "http://192.168.1.106/yunnao/home/api/getClassCategory";
    private List<Classroom_Bean.ContentBean.BooksBean> books;
    private RecyclerView mRightRecycle;
   @SuppressLint("HandlerLeak")
   private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            books = (List<Classroom_Bean.ContentBean.BooksBean>) msg.obj;
            //创建适配器
            ClassRoom_Adapter_R classRoom_adapter_r = new ClassRoom_Adapter_R(books, getActivity());
            //recycleview展示数据
            mRightRecycle.setAdapter(classRoom_adapter_r);

            mRightRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 4));
            //接口回调的子条目点击事件
            classRoom_adapter_r.setOnItemClickListener1(new ClassRoom_Adapter_R.OnItemClickListener1() {
                @Override
                public void onClick(int position,String id) {
                    Intent intent = new Intent(getActivity(), Details_Activity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });

        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_ment, container, false);
        Intent intent = getActivity().getIntent();
        String idss = intent.getStringExtra("id");
        Toast.makeText(getActivity(), idss+"书架", Toast.LENGTH_SHORT).show();
        //获取控件
     mRightRecycle = (RecyclerView) view.findViewById(R.id.right_recycle);
       initDataR();
        return view;
    }
    private void initDataR() {
        //调用okhttp工具类

        final OkhttpUtils getshu = OkhttpUtils.getshu();
        //接口、方法
        getshu.say(path, new OkhttpUtils.fun1() {
            @Override
            public void onres(String string) {
                //解析
                Gson gson = new Gson();

                Classroom_Bean classroom_bean = gson.fromJson(string, Classroom_Bean.class);
                List<Classroom_Bean.ContentBean.BooksBean> books = classroom_bean.getContent().getBooks();
                Message message = new Message();
                message.obj = books;
                handler.sendMessage(message);

            }
        });

    }


}
