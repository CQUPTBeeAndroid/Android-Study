package com.example.wanjian.fragmentdemo;


import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    //实例化四个Fragment
    MessageFragment messageFragment=new MessageFragment();
    ContactsFragment contactsFragment=new ContactsFragment();
    NewsFragment newsFragment=new NewsFragment();
    SettingFragment settingFragment=new SettingFragment();
    //四个页面布局
    private View messageLayout;
    private View contactsLayout;
    private View newsLayout;
    private View settingLayout;
    //在Tab布局上显示图标的控件
    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;
    private ImageView settingImage;
    //在tab上显示标题的控件
    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;
    private TextView settingText;

    private FragmentManager fragmentManager;
    private ViewPager viewPager;

    private ImageView line_tab;   //tab选项卡的下划线
    private int moveOne=0;       //下划线移动一个选项卡

    private boolean isScrolling =false; //手指是否在滑动
    private boolean isBackScrolling=false; //手指离开后的回弹
    private long startTime=0;
    private long currentTime=0;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewpager的实现
        List<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(messageFragment);
        fragmentList.add(contactsFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(settingFragment);

        MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager=(ViewPager)findViewById(R.id.id_viewpager);
        viewPager.setAdapter(myFragmentAdapter);

        //初始化布局元素
        initViews();
        initLineImage();  //重新设定Line的宽度
        fragmentManager=getSupportFragmentManager();
        //第一次启动时选择第0个Tab
        setTabSelection(0);
    }



    private void initLineImage() {
        //获取屏幕的宽度
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW=dm.widthPixels;
        //重新设置下划线的宽度
        ViewGroup.LayoutParams lp=line_tab.getLayoutParams();
        lp.width=screenW/4;
        line_tab.setLayoutParams(lp);
        //滑动一个页面的距离
        moveOne=lp.width;
    }

    //给每个控件获取实例并设置点击事件
    private void initViews() {

        messageLayout=findViewById(R.id.message_layout);
        contactsLayout=findViewById(R.id.contacts_layout);
        newsLayout= findViewById( R.id.news_layout);
        settingLayout=findViewById(R.id.setting_layout);

        messageImage=(ImageView)findViewById(R.id.message_image);
        contactsImage=(ImageView)findViewById(R.id.contacts_image);
        newsImage=(ImageView)findViewById(R.id.news_image);
        settingImage=(ImageView)findViewById(R.id.setting_image);

        messageText=(TextView)findViewById(R.id.message_text);
        contactsText=(TextView)findViewById(R.id.contacts_text);
        newsText=(TextView)findViewById(R.id.news_text);
        settingText=(TextView)findViewById(R.id.setting_text);

        line_tab=(ImageView)findViewById(R.id.line_tab);

        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

        viewPager.setOnPageChangeListener(this);      //给viewpager设置监听事件

    }


    //点击下面标题栏的点击响应事件
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.message_layout:
                viewPager.setCurrentItem(0);
                break;
            case R.id.contacts_layout:
                viewPager.setCurrentItem(1);
                break;
            case R.id.news_layout:
                viewPager.setCurrentItem(2);
                break;
            case R.id.setting_layout:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    //setTabSelection方法
    private void setTabSelection(int index) {
        //选中tab之前要清除之前的选中状态
        clearSelection();
        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (index){
            case 0:
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if (messageFragment==null){
                    messageFragment=new MessageFragment();
                    transaction.add(R.id.id_viewpager,messageFragment);
                }else{
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if (contactsFragment==null){
                    contactsFragment=new ContactsFragment();
                    transaction.add(R.id.id_viewpager,contactsFragment);
                }else {
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment==null){
                    newsFragment=new NewsFragment();
                    transaction.add(R.id.id_viewpager,newsFragment);
                }else {
                    transaction.show(newsFragment);
                }
                break;
            case 3:
                default:
                    settingImage.setImageResource(R.drawable.setting_selected);
                    settingText.setTextColor(Color.WHITE);
                    if (settingFragment==null){
                        settingFragment=new SettingFragment();
                        transaction.add(R.id.id_viewpager,settingFragment);
                    }else {
                        transaction.show(settingFragment);
                    }
                    break;
        }
        transaction.commit();
    }

    //clearSelection方法
    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }

    //hideFragment方法
    private void hideFragment(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }


    //下划线跟随手指的滑动而移动
    private void movePositionX(int toPosition,float positionOffsetPixels) {
        float curTranslationX=line_tab.getTranslationX();
        float toPositionX=moveOne*toPosition+positionOffsetPixels;
        ObjectAnimator animator=ObjectAnimator.ofFloat(line_tab,"translationX",curTranslationX,toPositionX);
        animator.setDuration(50);
        animator.start();
    }
    //下划线滑动到新的选项卡中
    private void movePositionX(int toPosition) {
        movePositionX(toPosition,0);
    }



    //viewpager的setOmPageChangeListener中的三个方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        currentTime=System.currentTimeMillis();
        if(isScrolling&&(currentTime-startTime>200)){
            movePositionX(position,moveOne*positionOffset);
            startTime=currentTime;
        }
        if (isBackScrolling){
            movePositionX(position);
        }
    }
    //ViewPager跳转到新页面时(即滑动时)触发该方法，position表示新页面的位置
    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                setTabSelection(0);
                break;
            case 1:
                setTabSelection(1);
                break;
            case 2:
                setTabSelection(2);
                break;
            case 3:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }
    //当页面的滑动状态改变时该方法会被触发，
    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case 1:
                isScrolling=true;
                isBackScrolling=false;
                break;
            case 2:
                isScrolling=false;
                isBackScrolling=true;
                break;
            default:
                isScrolling=false;
                isBackScrolling=false;
                 break;

        }

    }
}




