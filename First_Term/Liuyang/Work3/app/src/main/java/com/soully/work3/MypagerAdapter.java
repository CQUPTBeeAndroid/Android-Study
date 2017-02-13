package com.soully.work3;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Soully on 2017/1/18.
 */

public class MypagerAdapter extends PagerAdapter {
    private List<View> pageList;
    public MypagerAdapter(List<View> pageList){
        this.pageList = pageList;
    }
    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 获取指定位置的控件，页面的事件都可以在这里写
        View view = pageList.get(position);
        // / 将指定位置的View加入到ViewGroup
        container.addView(view);
        // 将View作为key返回
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // / 将当前位置的View移除
        container.removeView(pageList.get(position));
    }
}
