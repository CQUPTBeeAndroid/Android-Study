package com.soully.work4;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.soully.work4.Http.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends FragmentActivity {
    private ViewPager myViewPager;//要使用的Viewpager
    private ProgressDialog progressDialog;
    private boolean network = false;
    String city;
    String cityTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
         city = preferences.getString("city"," ");
        cityTwo = preferences.getString("cityTwo"," ");
        /*
        检测有没有city的数据，若没有网络有问题，且本地没有数据弹出窗口
         */
        if(city.equals(" ")){
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("网络连接有误，请检查网络");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            isExit.setCanceledOnTouchOutside(false);
            // 显示对话框
            isExit.show();
        }
        initView();
        /*
        如果没网络，使用的是本地的缓存数据，提示网络错误
         */
        network = isNetworkAvailable(this);
        if (!network){
        showProgressDialog();
        }
    }
    protected void initView() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mTabLayout.addTab(mTabLayout.newTab().setText(city));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText(cityTwo));
        mTabLayout.setupWithViewPager(myViewPager);
        MyFragmentOne myFragmentOne = new MyFragmentOne();
        MyFragmentTwo myFragmentTwo = new MyFragmentTwo();
//        List<Fragment> fragmentList = new ArrayList<Fragment>();

        MyFragmentAdapter viewPagerAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(myFragmentOne, city);//添加Fragment
        viewPagerAdapter.addFragment(myFragmentTwo, cityTwo);
        myViewPager.setAdapter(viewPagerAdapter);//设置适配器

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();

        }

        return false;

    }
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    int sdk_Version = android.os.Build.VERSION.SDK_INT;
                    if (sdk_Version >= 8) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        System.exit(0);
                    } else if (sdk_Version < 8) {
                        ActivityManager activityMgr = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        activityMgr.restartPackage(getPackageName());
                    }
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
    private void showProgressDialog(){
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("网络连接出错，数据刷新未成功。");
            progressDialog.setCanceledOnTouchOutside(true);
        }
        progressDialog.show();
    }
/*
检测网络是否可用
 */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
