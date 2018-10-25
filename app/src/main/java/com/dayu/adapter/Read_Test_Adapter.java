package com.dayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayu.R;
import com.dayu.bean.Read_page_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class Read_Test_Adapter extends RecyclerView.Adapter<Read_Test_Adapter.ViewHolder> {
    List<Read_page_Bean.ContentBean.TiBean> list;
    Context context;

    public Read_Test_Adapter(List<Read_page_Bean.ContentBean.TiBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.read_test_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title_test.setText(list.get(position).getBid()+"."+list.get(position).getQuestion()+"\t\n\n"+"A."+list.get(position).getA()+"\t\n\n"+"B."+list.get(position).getB()+"\t\n\n"+"C."+list.get(position).getC()+"\t\n\n"+"D."+list.get(position).getD()+"\t\n\n"+"正确答案："+list.get(position).getRight());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

  class ViewHolder extends RecyclerView.ViewHolder {

      private final TextView title_test;

      public ViewHolder(View itemView) {
          super(itemView);
          title_test = itemView.findViewById(R.id.title_test);
      }
  }
}
