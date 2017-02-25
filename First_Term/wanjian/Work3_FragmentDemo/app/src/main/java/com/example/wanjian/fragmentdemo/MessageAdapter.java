package com.example.wanjian.fragmentdemo;

/**
 * Created by wanjian on 2017/2/9.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter <MessageAdapter.ViewHolder>{

    private List<Message> mMessageList;



    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView messageImage;
        TextView messageText;

        public ViewHolder(View view) {
            super(view);
            messageImage=(ImageView)view.findViewById(R.id.message_image);
            messageText=(TextView)view.findViewById(R.id.message_text);
        }
    }

    public MessageAdapter(List<Message>message){
        mMessageList=message;
    }


    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.message,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        Message message = mMessageList.get(position);
        holder.messageImage.setImageResource(message.getImageId());
        holder.messageText.setText(message.getName());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

}

