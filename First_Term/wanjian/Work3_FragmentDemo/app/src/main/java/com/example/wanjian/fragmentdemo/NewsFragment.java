package com.example.wanjian.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wanjian on 2017/1/27.
 */

public class NewsFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View newsLayout=inflater.inflate(R.layout.news_layout,container,false);
        return newsLayout;
    }
}
