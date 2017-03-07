package com.soully.work4;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Soully on 2017/1/18.
 */

public class MyFragmentTwo extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapterTwo adapter;
    private List<RecyclerDataTwo> dataList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private TextView city;
    private ImageView imageView;
    private TextView wendu;
    private TextView tianqi;
    String citydata;
    String current_wendu;
    String current_tianqi;
    int item;
    String pic;
    JSONArray jsonArraydate = null;
    JSONArray jsonArraymax = null;
    JSONArray jsonArraymin = null;
    JSONArray jsonArraytxt_d = null;
    String [] date = new String[100];
    String [] max = new String[100];
    String [] txt_d = new String[100];
    String [] min = new String [100];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page2,null);
        /*
        获取sharepreference中的数据
         */
        SharedPreferences sharedPreferences =this.getActivity().getSharedPreferences("data",MODE_PRIVATE);
        citydata =sharedPreferences.getString("cityTwo"," ");
        current_wendu = sharedPreferences.getString("wenduTwo"," ");
        current_tianqi = sharedPreferences.getString("tianqiTwo"," ");
        pic = sharedPreferences.getString("pic"," ");
        item = sharedPreferences.getInt("itemTwo",0);
        try {
            jsonArraydate = new JSONArray(sharedPreferences.getString("dateTwo", "[]"));
            jsonArraymax = new JSONArray(sharedPreferences.getString("maxTwo","[]"));
            jsonArraymin = new JSONArray(sharedPreferences.getString("minTwo","[]"));
            jsonArraytxt_d = new JSONArray(sharedPreferences.getString("txt_dTwo","[]"));
            for (int i = 0; i < jsonArraydate.length(); i++) {
                date[i] = jsonArraydate.getString(i);
                max[i] = jsonArraymax.getString(i);
                min[i] = jsonArraymin.getString(i);
                txt_d[i] = jsonArraytxt_d.getString(i);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < item; i++) {
            RecyclerDataTwo dataOne = new RecyclerDataTwo();
            dataOne.setDate(date[i]);
            dataOne.setMax(max[i]);
            dataOne.setMin(min[i]);
            dataOne.setTxt_d(txt_d[i]);
            dataList.add(dataOne);
        }
        /*
        初始化
         */

        city = (TextView) view.findViewById(R.id.cityTwo);
        wendu = (TextView) view.findViewById(R.id.current_wenduTwo);
        tianqi = (TextView) view.findViewById(R.id.current_qingtianTwo);
        imageView = (ImageView) view.findViewById(R.id.one_viewTwo);
        Glide.with(MyFragmentTwo.this).load(pic).into(imageView);
        city.setText(citydata);
        wendu.setText(current_wendu+"℃");
        tianqi.setText(current_tianqi);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTwo);
        linearLayoutManager = new LinearLayoutManager(view.getContext());//指定布局样式
        recyclerView.setLayoutManager(linearLayoutManager);//将布局加入到recyclerView中
        adapter = new RecyclerViewAdapterTwo(dataList);//将数据传入Adapter中去
        recyclerView.setAdapter(adapter);//数据源和RecyclerView的绑定
        return view;
    }
}
