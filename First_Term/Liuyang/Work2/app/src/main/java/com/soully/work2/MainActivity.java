package com.soully.work2;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private List<DataDemo> dataDemoList = new ArrayList<>();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView recyclerView;
    private Handler mHandler = new Handler();
    private DemoAdapter adapter;
    int lastVisibleItem ;
    private  LinearLayoutManager linearLayoutManager;
    DataDemo data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();//初始化数据
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_one);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.Swipe);
        mSwipeRefreshLayout.setOnRefreshListener(this);//添加点击监听事件
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色

        linearLayoutManager = new LinearLayoutManager(this);//指定布局样式
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));//加分割线
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        adapter = new DemoAdapter(dataDemoList);//将数据传入Adapter中去
        recyclerView.setAdapter(adapter);//数据源和RecyclerView的绑定
        adapter.setOnRecycleViewListener(new DemoAdapter.OnRecycleViewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putString("content", dataDemoList.get(position).getText());
                intent.putExtras(b);
                intent.setClass(MainActivity.this,Second.class);
                startActivity(intent);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
                if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1==adapter.getItemCount()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0 ; i < 5 ; i ++) {
                                data = new DataDemo(R.mipmap.ic_launcher, "上拉 姓名：" + i,i+"人见过","职业 "+i,"擅长领域 "+i,5);
                                dataDemoList.add(data);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    },1000);
                }
            }

        });
    }
    private void initData(){
        for (int i = 0 ; i < 7 ; i ++){
            data = new DataDemo(R.mipmap.ic_launcher, "初始 姓名：" + i,i+"人见过","职业 "+i,"擅长领域 "+i,3);
            dataDemoList.add(data);
        }
    }
    @Override
    public void onRefresh() {
        /*
        正在刷新,加item
         */
        mHandler.postDelayed(mRefresh, 1000);
    }
    private Runnable mRefresh = new Runnable() {

        @Override
        public void run() {
            /*
            刷新完成
             */
            mSwipeRefreshLayout.setRefreshing(false);
            for (int i = 0 ; i < 5 ; i ++){
                data = new DataDemo(R.mipmap.ic_launcher, "下拉 姓名：" + i,i+"人见过","职业 "+i,"擅长领域 "+i,4);
                dataDemoList.add(0,data);//从最顶部加入数据
            }
            /*
            不需要再次建立adapter只需要将上次的数据更新就可以
             */
            adapter.notifyDataSetChanged();

        }
    };

}
