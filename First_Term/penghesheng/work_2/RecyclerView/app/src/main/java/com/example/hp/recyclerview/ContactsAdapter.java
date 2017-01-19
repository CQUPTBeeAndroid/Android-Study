package com.example.hp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP on 2017/1/19.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contacts> mContactsList;


    //ItemClick的回调接口
    public interface OnItemClickListener1 {
        void onItemClick(View view, int position, String str);
    }
    private OnItemClickListener1 mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener1 onItemClickListener1) {
        this.mOnItemClickListener = onItemClickListener1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView mImageView;
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.circle_img);
            mTextView = (TextView) itemView.findViewById(R.id.contacts_name);
        }
    }

    public ContactsAdapter(List<Contacts> contactsList) {
        mContactsList = contactsList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Contacts contacts = mContactsList.get(position);
        holder.mImageView.setImageResource(contacts.getImageID());
        holder.mTextView.setText(contacts.getName());

        //如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position  = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, contacts.getImageID(), contacts.getName());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }
}
