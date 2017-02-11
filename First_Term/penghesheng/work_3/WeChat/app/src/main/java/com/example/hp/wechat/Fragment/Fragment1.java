package com.example.hp.wechat.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.wechat.Demo.Contacts;
import com.example.hp.wechat.FragmentSecondActivty.Frag1_SecondActivity;
import com.example.hp.wechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017/2/11.
 */

public class Fragment1 extends Fragment {

    private List<Contacts> msgsList = new ArrayList<>();
    private RecyclerView msgsRecyclerView;
    private MessagesAdapter mMessagesAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private int lastVisibleItem;
    LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page1, container, false);
        initMsgs(15);  //初始化数据
        msgsRecyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        mMessagesAdapter = new MessagesAdapter(msgsList);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mLayoutManager = new LinearLayoutManager(getActivity());

        msgsRecyclerView.setAdapter(mMessagesAdapter);
        msgsRecyclerView.setLayoutManager(mLayoutManager);
        msgsRecyclerView.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL));
        //下拉刷新
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);  //设置刷新图标的颜色
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initMsgs(3);  //把要刷新的实例化
                        mMessagesAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false); //刷新结束
                        Toast.makeText(getActivity(),
                                "更新了三条数据...", Toast.LENGTH_SHORT).show();
                    }
                },500);
            }
        });
        //上拉加载，设置滑动监听
        msgsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == recyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == mMessagesAdapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initMsgs(2);  //把要加载的实例化
                            mMessagesAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(),
                                    "更新了2条数据...", Toast.LENGTH_SHORT).show();
                        }
                    },500);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition(); //找到最后一个的位置
            }
        });
        return view;
    }
    //初始化数据
    private void initMsgs(int n) {
        for (int i = 1; i <= n; i++) {
            if (n == 2) {
                Contacts contacts = new Contacts(i + "上拉 消息", R.drawable.hugh);
                msgsList.add(contacts);
            }else if (n == 3) {
                Contacts contacts = new Contacts("下拉 消息" + i, R.drawable.hugh);
                msgsList.add(contacts);
            }else{
                Contacts contacts = new Contacts("消息" + i, R.drawable.contacts);
                msgsList.add(contacts);
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

        private List<Contacts> MsgsList;

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;
            ImageView mImageView;

            public ViewHolder(View view) {
                super(view);
                mImageView = (ImageView) view.findViewById(R.id.circle_img);
                newsTitleText = (TextView) view.findViewById(R.id.contacts_name);
            }
        }
        public MessagesAdapter(List<Contacts> mMsgsList) {
            MsgsList = mMsgsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.messages, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Contacts news = MsgsList.get(holder.getAdapterPosition());
                    Toast.makeText(getActivity(), "click" , Toast.LENGTH_SHORT).show();
                    Frag1_SecondActivity.actionStart(getActivity());
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Contacts msgs = MsgsList.get(position);
            holder.mImageView.setImageResource(msgs.getImageID());
            holder.newsTitleText.setText(msgs.getName());
        }

        @Override
        public int getItemCount() {
            return MsgsList.size();
        }
    }
}
