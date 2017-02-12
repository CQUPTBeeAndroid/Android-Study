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

        initContacts(15); //实例化数据
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ContactsAdapter(mContactsList);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        layoutManerger = new LinearLayoutManager(this);  //纵向布局
        /**
         * 横向布局
         *LinearLayoutManager layoutManager = new LinearLayoutManager(this);
         *layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
         */
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);  //瀑布流布局

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
                        initContacts(3);  //把要刷新的实例化
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
                            initContacts(2);  //把要加载的实例化
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

    private void initContacts(int n) {
        for (int i = 1; i <= n; i++) {
            if (n == 2) {
                Contacts contacts = new Contacts(i + "上拉 分享家", R.drawable.hugh);
                mContactsList.add(contacts);
            }else if (n == 3) {
                Contacts contacts = new Contacts("下拉 分享家" + i, R.drawable.hugh);
                mContactsList.add(contacts);
            }else{
                Contacts contacts = new Contacts("分享家" + i, R.drawable.hugh);
                mContactsList.add(contacts);
            }
        }
    }
}
