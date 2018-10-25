package com.dayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayu.R;
import com.dayu.bean.Classroom_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */

public class ClassRoom_Adapter extends RecyclerView.Adapter<ClassRoom_Adapter.ViewHolder> {
    List<Classroom_Bean.ContentBean.CategoryBean> list;
    Context context;

    public ClassRoom_Adapter(List<Classroom_Bean.ContentBean.CategoryBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.classroom_item_left, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.time.setText(list.get(position).getName());
        final String id = list.get(position).getId();


        if (mOnItemClickListener != null) {
            holder.time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position,id);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private OnItemClickListener mOnItemClickListener;//声明接口

    public interface OnItemClickListener {
        void onClick(int position,String id);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
        }
    }
}
