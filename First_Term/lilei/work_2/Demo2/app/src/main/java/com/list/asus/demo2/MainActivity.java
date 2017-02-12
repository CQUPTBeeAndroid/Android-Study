package com.list.asus.demo2;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity  {

    private List<Fruit> fruitList = new ArrayList<>();

    private SwipeRefreshLayout swipeRefresh;

    private int lastVisibleItem;

    final private FruitAdapter adapter = new FruitAdapter(fruitList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();  //通过新建一个类进行初始化
        //适配器
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //点击事件监听
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name",fruitList.get(position).getName());
                startActivity(intent);
            }
        }) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        //下拉刷新
        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary)); //不懂为什么设置颜色会出错
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(true);
                refreshFruits(fruitList);
            }
        });

        //上拉加载
//        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener()  {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//            }
//        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int position = manager.findLastVisibleItemPosition() ;
                if(fruitList.size() == 120){
                    Toast.makeText(getApplicationContext(), "已经到达最底部",
                            Toast.LENGTH_SHORT).show();
                    //Log.d("rag","222222222222222222222222222222222222222");
                }else  if(position == fruitList.size()-1 ){
                    Add();
                    //Log.d("tag","111111111111111111111111111111111111111    " + position);
                }
            }
        });
        }

    //初始化的方法
    private void initFruits(){
            Fruit apple = new Fruit("apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("mango",R.drawable.mango_pic);
            fruitList.add(mango);
    }

    //更新的方法
    private void refreshFruits( List<Fruit> fruitList){
//        new Thread(new Runnable(){    // 更新模拟1：更新标志悬停2秒
//            @Override
//            public void run(){
//                try{
//                    Thread.sleep(2000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        initFruits();
//                        adapter.notifyDataSetChanged();
//                        swipeRefresh.setRefreshing(false);
//                    }
//                });
//            }
//        }).start();

        //模拟方法2  将名字更改
        Fruit changedFruit; //修改过后fruit
        String fruitName2;
        for(int i=0;i<fruitList.size();i++) {
            String fruitName = fruitList.get(i).getName();
            switch (fruitName){
                case "apple":
                case "banana":
                case "orange":
                case "watermelon":
                case "pear":
                case "grape":
                case "pineapple":
                case "strawberry":
                case "cherry":
                case "mango":
                    fruitName2 = change(fruitName,1);
                    changedFruit = new Fruit(fruitName2,fruitList.get(i).getImageId());
                    fruitList.set(i,changedFruit);
                    adapter.notifyDataSetChanged();
                    swipeRefresh.setRefreshing(false);
                    break;
                case "apple1":
                case "banana1":
                case "orange1":
                case "watermelon1":
                case "pear1":
                case "grape1":
                case "pineapple1":
                case "strawberry1":
                case "cherry1":
                case "mango1":
                    fruitName2 = change(fruitName,2);
                    changedFruit = new Fruit(fruitName2,fruitList.get(i).getImageId());
                    fruitList.set(i,changedFruit);
                    adapter.notifyDataSetChanged();
                    swipeRefresh.setRefreshing(false);
                    break;
            }
        }
    }
    //将水果名称改变的方法,opt->1时将1加到字符串后，opt->2时，将字符串后的1移除
    private String change(String str,int opt){
        if(opt == 1){
            return str+"1";
        }else {
            return str.substring(0,str.length()-1);
        }
    }

    //上拉加载
    private void Add(){
       Fruit[] fruits = {new Fruit("apple", R.drawable.apple_pic), new Fruit("banana", R.drawable.banana_pic),
                new Fruit("orange", R.drawable.orange_pic), new Fruit("watermelon", R.drawable.watermelon_pic),
                new Fruit("pear", R.drawable.pear_pic), new Fruit("grape", R.drawable.grape_pic),
                new Fruit("pineapple", R.drawable.pineapple_pic), new Fruit("strawberry", R.drawable.strawberry_pic),
                new Fruit("cherry", R.drawable.cherry_pic), new Fruit("mango", R.drawable.mango_pic)};

        //随机选择两个，并加入
                Random random=new Random();
                int index=random.nextInt(fruits.length);
                fruitList.add(fruits[index]);
                adapter.notifyDataSetChanged();
//                swipeRefresh.setRefreshing(false);
    }

}


