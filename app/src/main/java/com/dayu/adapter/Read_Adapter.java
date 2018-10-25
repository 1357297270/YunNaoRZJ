package com.dayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dayu.R;
import com.dayu.bean.Read_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11.
 */

public class Read_Adapter extends RecyclerView.Adapter<Read_Adapter.ViewHolder> {
    List<Read_Bean.ContentBean> list;
    Context context;

    public Read_Adapter(List<Read_Bean.ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.read_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide
                .with(context)
                .load("http://192.168.1.133" + list.get(position).getImg_url())
                .into(holder.image_view);
       final String id = list.get(position).getId();
        if (mOnItemClickListener2 != null) {
            holder.image_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener2.onClick(position,id);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private OnItemClickListener2 mOnItemClickListener2;//声明接口

    public interface OnItemClickListener2 {
        void onClick(int position,String id);
    }

    public void setOnItemClickListener2(OnItemClickListener2 onItemClickListener) {
        this.mOnItemClickListener2 = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image_view;

        public ViewHolder(View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
        }
    }
}
