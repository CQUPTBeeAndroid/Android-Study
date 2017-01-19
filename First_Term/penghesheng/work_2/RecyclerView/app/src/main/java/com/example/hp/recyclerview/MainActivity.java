package com.example.hp.recyclerview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contacts> mContactsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ContactsAdapter mAdapter;
    LinearLayoutManager layoutManerger;
    private int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContacts(); //实例化数据
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ContactsAdapter(mContactsList);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        layoutManerger = new LinearLayoutManager(this);  //纵向布局

        recyclerView.setLayoutManager(layoutManerger);  //设置布局的方式
        recyclerView.setAdapter(mAdapter);  //适配器配置
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));  //分割线
        //下拉刷新
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);  //设置刷新图标的颜色
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initContacts1();  //把要刷新的实例化
                        mAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false); //刷新结束
                        Toast.makeText(MainActivity.this, "更新了三条数据...", Toast.LENGTH_SHORT).show();
                    }
                },1000);
            }
        });
        //上拉加载，设置滑动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == recyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mAdapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initContacts2();  //把要加载的实例化
                            mAdapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "更新了2条数据...", Toast.LENGTH_SHORT).show();
                        }
                    },1000);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManerger.findLastVisibleItemPosition(); //找到最后一个的位置
            }
        });
        //设置监听
        mAdapter.setOnItemClickListener(new ContactsAdapter.OnItemClickListener1() {
            @Override
            public void onItemClick(View view, int position, String str) {
                Toast.makeText(MainActivity.this, "click" + str, Toast.LENGTH_SHORT).show();
                FirstActivity.actionStart(MainActivity.this, str, position);
            }
        });
    }

    private void initContacts2() {
        Contacts contacts1 = new Contacts("上拉分享家1", R.drawable.hugh);
        mContactsList.add(contacts1);

        Contacts contacts2 = new Contacts("上拉分享家2", R.drawable.hugh);
        mContactsList.add(contacts2);
    }

    private void initContacts1() {
        Contacts contacts1 = new Contacts("下拉分享家1", R.drawable.hugh);
        mContactsList.add(contacts1);

        Contacts contacts2 = new Contacts("下拉分享家2", R.drawable.hugh);
        mContactsList.add(contacts2);

        Contacts contacts3 = new Contacts("下拉分享家3", R.drawable.contacts);
        mContactsList.add(contacts3);
    }

    private void initContacts() {
        Contacts contacts1 = new Contacts("分享家1", R.drawable.hugh);
        mContactsList.add(contacts1);

        Contacts contacts2 = new Contacts("分享家2", R.drawable.hugh);
        mContactsList.add(contacts2);

        Contacts contacts3 = new Contacts("分享家3", R.drawable.contacts);
        mContactsList.add(contacts3);

        Contacts contacts4 = new Contacts("分享家4", R.drawable.contacts);
        mContactsList.add(contacts4);

        Contacts contacts5 = new Contacts("分享家5", R.drawable.contacts);
        mContactsList.add(contacts5);

        Contacts contacts6 = new Contacts("分享家6", R.drawable.contacts);
        mContactsList.add(contacts6);

        Contacts contacts7 = new Contacts("分享家7", R.drawable.contacts);
        mContactsList.add(contacts7);

        Contacts contacts8 = new Contacts("分享家8", R.drawable.contacts);
        mContactsList.add(contacts8);

        Contacts contacts9 = new Contacts("分享家9", R.drawable.contacts);
        mContactsList.add(contacts9);

        Contacts contacts10 = new Contacts("分享家", R.drawable.contacts);
        mContactsList.add(contacts10);

        Contacts contacts11 = new Contacts("分享家11", R.drawable.contacts);
        mContactsList.add(contacts11);

        Contacts contacts12 = new Contacts("分享家12", R.drawable.contacts);
        mContactsList.add(contacts12);

        Contacts contacts13 = new Contacts("分享家13", R.drawable.contacts);
        mContactsList.add(contacts13);

        Contacts contacts14 = new Contacts("分享家14", R.drawable.contacts);
        mContactsList.add(contacts14);

        Contacts contacts15 = new Contacts("分享家15", R.drawable.contacts);
        mContactsList.add(contacts15);

        Contacts contacts16 = new Contacts("分享家16", R.drawable.contacts);
        mContactsList.add(contacts16);
    }
}
