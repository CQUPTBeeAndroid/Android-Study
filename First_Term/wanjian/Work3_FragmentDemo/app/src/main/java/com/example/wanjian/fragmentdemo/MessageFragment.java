package com.example.wanjian.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;

/**
 * Created by wanjian on 2017/1/27.
 */

public class MessageFragment extends Fragment {


    private List<Message> messageList=new ArrayList<>();
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.message_layout,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter adapter=new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);

        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        return view;
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            Message apple = new Message("Apple", R.drawable.apple_pic);
            messageList.add(apple);
            Message banana = new Message("Banana", R.drawable.banana_pic);
            messageList.add(banana);
            Message orange = new Message("Orange", R.drawable.orange_pic);
            messageList.add(orange);
            Message watermelon = new Message("Watermelon", R.drawable.watermelon_pic);
            messageList.add(watermelon);
            Message pear = new Message("Pear", R.drawable.pear_pic);
            messageList.add(pear);
            Message grape = new Message("Grape", R.drawable.grape_pic);
            messageList.add(grape);
            Message pineapple = new Message("Pineapple", R.drawable.pineapple_pic);
            messageList.add(pineapple);
            Message strawberry = new Message("Strawberry", R.drawable.strawberry_pic);
            messageList.add(strawberry);
            Message cherry = new Message("Cherry", R.drawable.cherry_pic);
            messageList.add(cherry);
            Message mango = new Message("Mango", R.drawable.mango_pic);
            messageList.add(mango);
        }

    }

}






