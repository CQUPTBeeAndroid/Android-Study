package com.example.wanjian.recyclerview;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();
    private SwipeRefreshLayout swipeRefresh;
    private FruitAdapter adapter =new FruitAdapter(fruitList);
    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem;
    private RecyclerView recyclerView;

    private Fruit[] fruits = {new Fruit("Apple", R.drawable.apple_pic), new Fruit("Banana", R.drawable.banana_pic),
            new Fruit("Orange", R.drawable.orange_pic), new Fruit("Watermelon", R.drawable.watermelon_pic),
            new Fruit("Pear", R.drawable.pear_pic), new Fruit("Grape", R.drawable.grape_pic),
            new Fruit("Pineapple", R.drawable.pineapple_pic), new Fruit("Strawberry", R.drawable.strawberry_pic),
            new Fruit("Cherry", R.drawable.cherry_pic), new Fruit("Mango", R.drawable.mango_pic)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        //下拉刷新功能
        swipeRefresh =(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                refreshFruits();
            }
        });
    }




    private void refreshFruits(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

        }).start();
    }

    private void initFruits(){
        fruitList.clear();
        for (int i=0;i<10;i++){
            Random random=new Random();
            int index=random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }

    }



    //上拉加载功能



}





