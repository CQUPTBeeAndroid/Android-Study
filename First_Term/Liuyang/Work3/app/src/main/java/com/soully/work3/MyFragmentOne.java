package com.soully.work3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by Soully on 2017/1/18.
 */

public class MyFragmentOne extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<DataOne> dataOneList = new ArrayList<>();
    DataOne dataOne;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.page1, null);
        for (int i = 0; i < 10; i++) {
            dataOne = new DataOne("大家好,初始我是 " + i);
            dataOneList.add(dataOne);

        }
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.pageOne_swipe);
        swipeRefreshLayout.setOnRefreshListener(this);//注册点击监听事件
        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.colorPrimary,
                R.color.colorPrimaryDark);//设置进度条的颜色
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_page1);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST));//加分割线
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        adapter = new Adapter(dataOneList);//将数据传入Adapter中去
        recyclerView.setAdapter(adapter);//数据源和RecyclerView的绑定
        adapter.setOnRecycleViewListener(new Adapter.OnRecycleViewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "点击成功 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putString("data", dataOneList.get(position).getPageOne_text());
                intent.putExtras(b);
                intent.setClass(view.getContext(), Second.class);
                startActivity(intent);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem = -1;
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if ( newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 5; i++) {
                                dataOne = new DataOne(" 上拉姓名：" + i);
                                dataOneList.add(dataOne);
                            }
                            swipeRefreshLayout.setRefreshing(false);
                            adapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            }

        });
        return view;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    dataOne = new DataOne(" 下拉名字：" + i);
                    dataOneList.add(0, dataOne);
                }
                swipeRefreshLayout.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        }, 500);
    }
}