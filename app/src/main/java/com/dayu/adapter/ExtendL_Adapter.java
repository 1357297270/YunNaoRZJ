package com.dayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayu.R;
import com.dayu.bean.ExtendL_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class ExtendL_Adapter extends RecyclerView.Adapter<ExtendL_Adapter.ViewHolder> {
    List<ExtendL_Bean.ContentBean> list;
    Context context;

    public ExtendL_Adapter(List<ExtendL_Bean.ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.extendl_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.title_extend.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder {

       private final TextView title_extend;

       public ViewHolder(View itemView) {
           super(itemView);
           title_extend = itemView.findViewById(R.id.title_extend);
       }
   }
}
