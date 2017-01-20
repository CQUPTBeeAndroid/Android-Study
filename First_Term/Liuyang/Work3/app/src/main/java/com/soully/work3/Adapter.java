package com.soully.work3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Soully on 2017/1/19.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<DataOne> mDataOneList;
    private OnRecycleViewListener onRecycleViewListener;
    View oneView;
    /*
  将数据源传进来
   */
    public Adapter(List<DataOne> dataOneList){
        this.mDataOneList = dataOneList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pageView_one;
        public ViewHolder(View itemView) {
            /*
            itemView子项的最外层布局
             */
            super(itemView);
            oneView = itemView;
            pageView_one = (TextView) itemView.findViewById(R.id.pageOne_text);
        }
    }
    /**
     创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pageview_one,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final DataOne dataOne = mDataOneList.get(position);
        holder.pageView_one.setText(dataOne.getPageOne_text());
        if(onRecycleViewListener != null){//如果设置了回调，则设置监听事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();//和position值一样
                    onRecycleViewListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    /**
     *一共有多少子项
     */
    @Override
    public int getItemCount() {
        return mDataOneList.size();
    }
    public interface OnRecycleViewListener{
        void onItemClick(View view, int position);
    }
    public void setOnRecycleViewListener(OnRecycleViewListener mOnItemClickListener){
        this.onRecycleViewListener = mOnItemClickListener;
    }

}
