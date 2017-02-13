package com.example.hp.wechat;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.wechat.Fragment.Fragment1;
import com.example.hp.wechat.Fragment.Fragment2;
import com.example.hp.wechat.Fragment.Fragment3;
import com.example.hp.wechat.Fragment.Fragment4;
import com.example.hp.wechat.Fragment.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements
        ViewPager.OnPageChangeListener, View.OnClickListener{

    private ViewPager mViewPager;  //要使用的ViewPager
    private TextView tab1, tab2, tab3, tab4;  //三个选项卡
    private ImageView line_tab;  //tab选项卡的下划线
    private int moveOne = 0;  //下划线移动一个选项卡
    private boolean isScrolling = false;  //手指是否在滑动
    private boolean isBackScrlling = false;  //手指离开后的回弹
    private long startTime = 0;
    private long currentTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVIew();
        initLineImage();
    }
    //重新设定line的宽度
    private void initLineImage() {
        //获取屏幕的宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        //重新设置下划线的宽度
        ViewGroup.LayoutParams lp = line_tab.getLayoutParams();
        lp.width = screenW / 4;
        line_tab.setLayoutParams(lp);

        moveOne = lp.width;  //滑动一个页面的距离
    }

    private void initVIew() {
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        //ViewPager中包含的页面为Fragment，用法与前面的普通适配器一样
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(
                getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(myFragmentAdapter);

        tab1 = (TextView) findViewById(R.id.messages);
        tab2 = (TextView) findViewById(R.id.contacts);
        tab3 = (TextView) findViewById(R.id.news);
        tab4 = (TextView) findViewById(R.id.settings);
        mViewPager.setCurrentItem(0);
        tab1.setTextColor(Color.RED);
        tab2.setTextColor(Color.BLACK);
        tab3.setTextColor(Color.BLACK);
        tab4.setTextColor(Color.BLACK);

        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(this);

        line_tab = (ImageView) findViewById(R.id.line_tab);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case 1:
                isScrolling = true;
                isBackScrlling = false;
                break;
            case 2:
                isScrolling = false;
                isBackScrlling = true;
                break;
            case 3:
                isScrolling = false;
                isBackScrlling = false;
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        currentTime = System.currentTimeMillis();
        if (isScrolling && (currentTime - startTime > 200)) {
            movePositionX(position, moveOne * positionOffset);
            startTime = currentTime;
        }
        if (isBackScrlling) {
            movePositionX(position);
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tab1.setTextColor(Color.RED);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.BLACK);
                movePositionX(0);
                break;
            case 1:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.BLUE);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.BLACK);
                movePositionX(1);
                break;
            case 2:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.GREEN);
                tab4.setTextColor(Color.BLACK);
                movePositionX(2);
                break;
            case 3:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.WHITE);
                movePositionX(3);
                break;
            default:
                break;
        }
    }
    //下划线跟随手指的滑动而移动
    private void movePositionX(int toPosition, float positionOffsetPixels) {
        float curTranslatioinX = line_tab.getTranslationX();
        float toPositionX = moveOne * toPosition + positionOffsetPixels;
        ObjectAnimator animator = ObjectAnimator.ofFloat(line_tab,
                "translationX", curTranslatioinX, toPositionX);
        animator.setDuration(100);  //动画延迟--下划线延迟
        animator.start();
    }
    //下划线滑动到新的选项卡中
    private void movePositionX(int toPosition) {
        movePositionX(toPosition, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.messages:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.contacts:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.news:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.settings:
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

}
