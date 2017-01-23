package com.example.admin.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("apple",R.drawable.ic_launcher);
            fruitList.add(apple);
            Fruit android=new Fruit("android",R.drawable.ic_launcher);
            fruitList.add(android);
            Fruit pear=new Fruit("pear",R.drawable.ic_launcher);
            fruitList.add(pear);
            Fruit qq=new Fruit("qq",R.drawable.ic_launcher);
            fruitList.add(qq);
            Fruit tao=new Fruit("tao",R.drawable.ic_launcher);
            fruitList.add(tao);
        }
    }
}
