package com.soully.work2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import java.util.*;



/**
 * Created by Soully on 2017/1/16.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder>{
    private List<DataDemo> mDataList;
    private OnRecycleViewListener onRecycleViewListener;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_name;
        View DemoView;
        TextView textView_zhiye;
        TextView textView_shanchang;
        TextView textView_see;
         RatingBar ratingBar;
        public ViewHolder(View itemView){
            /*
            itemView子项的最外层布局
             */
            super(itemView);
            DemoView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.profile_image);
            textView_name = (TextView) itemView.findViewById(R.id.textView_name);
            textView_shanchang = (TextView) itemView.findViewById(R.id.textView_shanchang);
            textView_see = (TextView) itemView.findViewById(R.id.text_see);
            textView_zhiye = (TextView) itemView.findViewById(R.id.textView_Zhiye);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
    /*
    将数据源传进来
     */
 public DemoAdapter (List<DataDemo> dataDemoList){
     this.mDataList = dataDemoList;
 }
    /*
    创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    /*
    对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(final ViewHolder mholder, final int position) {
        final DataDemo dataDemo = mDataList.get(position);
        mholder.imageView.setImageResource(dataDemo.getImage());
        mholder.textView_name.setText(dataDemo.getText());
        mholder.textView_see.setText(dataDemo.getText_see());
        mholder.textView_shanchang.setText(dataDemo.getText_shanchang());
        mholder.textView_zhiye.setText(dataDemo.getText_zhiye());
        mholder.ratingBar.setRating(dataDemo.getRatingBar());
        if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
            mholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = mholder.getLayoutPosition();//和position值一样
                    onRecycleViewListener.onItemClick(mholder.itemView,pos);
                }
            });
        }
    }
    /*
    告诉RecyclerView总共有多少个子项
     */
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    public interface OnRecycleViewListener{
        void onItemClick(View view, int position);
    }
    public void setOnRecycleViewListener(OnRecycleViewListener mOnItemClickListener){
        this.onRecycleViewListener = mOnItemClickListener;
    }


}
