package com.dayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dayu.R;
import com.dayu.bean.Classroom_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/10.
 */
//右边是展示
public class ClassRoom_Adapter_R extends RecyclerView.Adapter<ClassRoom_Adapter_R.ViewHolder> {
    List<Classroom_Bean.ContentBean.BooksBean> list;
    Context context;
    private final static int NORMAL = 1;
    private final static int IMAGES = 2;
    public ClassRoom_Adapter_R(List<Classroom_Bean.ContentBean.BooksBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View inflate = View.inflate(context, R.layout.classroom_item_rigth, null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
     final String id = list.get(position).getId();

        //加载图片
        Glide
                .with(context)
                .load("http://192.168.1.133" + list.get(position).getImg_url())
                .into(holder.my_image_view);


        if (mOnItemClickListener1 != null) {
            holder.my_image_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener1.onClick(position,id);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private OnItemClickListener1 mOnItemClickListener1;//声明接口

    public interface OnItemClickListener1 {
        void onClick(int position,String id);
    }

    public void setOnItemClickListener1(OnItemClickListener1 onItemClickListener) {
        this.mOnItemClickListener1 = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView my_image_view;



        public ViewHolder(View itemView) {
            super(itemView);
            my_image_view = itemView.findViewById(R.id.my_image_view);



        }
    }
}
