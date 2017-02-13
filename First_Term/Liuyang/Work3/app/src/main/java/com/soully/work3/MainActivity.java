package com.soully.work3;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager myViewPager;//要使用的ViewPager
    private TextView textView_0,textView_1,textView_2,textView_3;//4个选项
    private ImageView line_tab;//下划线
    private int moveOne = 0;//下划线移动距离
    private boolean isScrolling = false;//手是否在移动
    private boolean isBackScrolling = false;//手指离开后的回弹
    private long startTime = 0;//方法开始的时间
    private long currentTime = 0; //方法执行结束的时间
    private Toolbar toolbar;
  /*
   点击ToolBar上的按钮跳转到相应的fragment页面中去
  /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.second:
                myViewPager.setCurrentItem(1);
                break;
            case R.id.thrid:
                myViewPager.setCurrentItem(2);
                break;
            case R.id.four:
                myViewPager.setCurrentItem(3);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.toolbar_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        initView();
        initLineImage();

    }
    /** * 重新设定line的宽度 */
    private void initLineImage() {
        /** * 获取屏幕的宽度 */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        /** * 重新设置下划线的宽度 */
        ViewGroup.LayoutParams lp = line_tab.getLayoutParams();
        lp.width = screenW/4;
        line_tab.setLayoutParams(lp);
        moveOne = lp.width; // 滑动一个页面的距离
    }
    private void initView(){
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);

        MyFragmentOne myFragmentOne = new MyFragmentOne();
        MyFragmentTwo myFragmentTwo = new MyFragmentTwo();
        MyFragmentThree myFragmentThree = new MyFragmentThree();
        MyFragmentFour myFragmentFour = new MyFragmentFour();

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(myFragmentOne);
        fragmentList.add(myFragmentTwo);
        fragmentList.add(myFragmentThree);
        fragmentList.add(myFragmentFour);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);
        textView_0 = (TextView) findViewById(R.id.tab_0);
        textView_1 = (TextView) findViewById(R.id.tab_1);
        textView_2 = (TextView) findViewById(R.id.tab_2);
        textView_3 = (TextView) findViewById(R.id.tab_3);

        myViewPager.setCurrentItem(0);//设置当前选中的页面。

        textView_0.setTextColor(Color.RED);
        textView_1.setTextColor(Color.BLACK);
        textView_2.setTextColor(Color.BLACK);
        textView_3.setTextColor(Color.BLACK);

        textView_0.setOnClickListener(this);
        textView_1.setOnClickListener(this);
        textView_2.setOnClickListener(this);
        textView_3.setOnClickListener(this);

        myViewPager.setOnPageChangeListener(this);
        line_tab = (ImageView) findViewById(R.id.line_tab);
    }

    @Override
    public void onClick(View view) {
        /*
        点击tab，选中当前tab所对应的fragment
         */
        switch (view.getId()){
            case R.id.tab_0:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.tab_1:
                myViewPager.setCurrentItem(1);
                break;
            case R.id.tab_2:
                myViewPager.setCurrentItem(2);
                break;
            case R.id.tab_3:
                myViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
          /*
        每隔了这个时间间隔才让动画执行一次
         */
        currentTime = System.currentTimeMillis();//这个方法执行的时间
        //isScrolling代表的是手指正在滑动
        if (isScrolling && (currentTime - startTime > 100)) {
            movePositionX(position, moveOne * positionOffset);
            startTime = currentTime; }
        if (isBackScrolling) {
            movePositionX(position); }
    }

    /**
     这个方法的功能就是让下划线滑动到新的页面。我们把他加入到onPageSelected方法中
     */
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            /*
            选择每个tab时，tab颜色对应变化。
             */
            case 0:
                textView_0.setTextColor(Color.RED);
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                movePositionX(0);
                break;
            case 1:
                textView_0.setTextColor(Color.BLACK);
                textView_1.setTextColor(Color.BLUE);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.BLACK);
                movePositionX(1);
                break;
            case 2:
                textView_0.setTextColor(Color.BLACK);
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.GREEN);
                textView_3.setTextColor(Color.BLACK);
                movePositionX(2);
                break;
            case 3:
                textView_0.setTextColor(Color.BLACK);
                textView_1.setTextColor(Color.BLACK);
                textView_2.setTextColor(Color.BLACK);
                textView_3.setTextColor(Color.YELLOW);

            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case 1:
                isScrolling = true;
                isBackScrolling = false;
                break;
            case 2:
                isScrolling = false;
                isBackScrolling = true;
                break;
            default:
                isScrolling = false;
                isBackScrolling = false;
                break;
        }
    }
    /*
    下划线跟随手指的滑动而移动
     */
    private void movePositionX(int toPosition,float positionOffsetPixels){
        float curTranslationX = line_tab.getTranslationX();
        float toPositionX = moveOne * toPosition + positionOffsetPixels;
        ObjectAnimator animator = ObjectAnimator.ofFloat(line_tab, "translationX", curTranslationX, toPositionX);
        animator.setDuration(500);
        animator.start();
    }
    /*
    下划线滑动到新的选项卡中
     */
    private void movePositionX(int toPosition) {
        // TODO Auto-generated method stub
        movePositionX(toPosition, 0);
    }
}
