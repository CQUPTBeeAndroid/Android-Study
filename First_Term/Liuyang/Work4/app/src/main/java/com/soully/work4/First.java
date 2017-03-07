package com.soully.work4;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.soully.work4.Gson.HeWeather5;
import com.soully.work4.Http.HttpUtil;

import org.json.JSONArray;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Soully on 2017/2/9.
 */

public class First extends Activity{
    JSONArray date = new JSONArray();
    JSONArray max = new JSONArray();
    JSONArray txt_d = new JSONArray();
    JSONArray min = new JSONArray();
    String city;
    String current_wendu;
    String current_tianqi;
    int one=0;
    int two=0;
    JSONArray dateTwo = new JSONArray();
    JSONArray maxTwo = new JSONArray();
    JSONArray txt_dTwo = new JSONArray();
    JSONArray minTwo = new JSONArray();
    String cityTwo;
    String current_wenduTwo;
    String current_tianqiTwo;
    String pic = "http://api.getlove.cn/api/img";
    //String pic = "http://cn.bing.com/az/hprichbg/rb/LophophorusImpejanus_ZH-CN10675050048_1920x1080.jpg";//背景图片

//Data data =new Data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        initData();
        Timer timer = new Timer();
        TimerTask tast = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(First.this, MainActivity.class);
                startActivity(intent);
            }
        };
        timer.schedule(tast, 5000);
    }
    private void initData(){
        HttpUtil.sendOkHttpRequest("https://free-api.heweather.com/v5/forecast?city=重庆&key=dade51f03a8449c98624c8a6d4a99d39",
                new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("123book", "网络连接成功");
                String htmlStr = response.body().string();//成功！！
                newsGson(htmlStr);//传入newsJSON
            }
        });
    }
    protected void newsGson(String jsonDate){
        Gson gson = new Gson();
        com.soully.work4.Gson.Gson gson1 = gson.fromJson(jsonDate, com.soully.work4.Gson.Gson.class);
        Log.d("XXXX",jsonDate);
        city =gson1.getHeWeather5().get(0).getBasic().getCity();
        Log.d("XXXX",city);
        current_wendu = gson1.getHeWeather5().get(0).getDailyForecast().get(0).getTmp().getMax();
        current_tianqi = gson1.getHeWeather5().get(0).getDailyForecast().get(0).getCond().getTxtD();

        for(int i=0;i < gson1.getHeWeather5().get(0).getDailyForecast().size();i++,one++){
            date.put(gson1.getHeWeather5().get(0).getDailyForecast().get(i).getDate());
           txt_d.put(gson1.getHeWeather5().get(0).getDailyForecast().get(i).getCond().getTxtD());
            max.put(gson1.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMax());
           min.put(gson1.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMin());
            Log.d("XXXXX",date.toString());
        }
        SharedPreferences.Editor editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("city",city);
        editor.putInt("item",one);
        editor.putString("wendu",current_wendu);
        editor.putString("tianqi",current_tianqi);
        editor.putString("date",date.toString());
        editor.putString("txt_d",txt_d.toString());
        editor.putString("max",max.toString());
        editor.putString("min",min.toString());
        editor.apply();
        getxian();
    }
    private void getxian(){
        HttpUtil.sendOkHttpRequest("https://free-api.heweather.com/v5/forecast?city=西安&key=dade51f03a8449c98624c8a6d4a99d39",
                new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("123book", "网络连接成功");
                        String htmlStr = response.body().string();//成功！！
                        newsXiGson(htmlStr);//传入newsJSON
                    }
                });
    }
    protected void newsXiGson(String jsonDate){
        Gson gson = new Gson();
        com.soully.work4.Gson.Gson gson2 = gson.fromJson(jsonDate, com.soully.work4.Gson.Gson.class);
        cityTwo =gson2.getHeWeather5().get(0).getBasic().getCity();
        current_wenduTwo = gson2.getHeWeather5().get(0).getDailyForecast().get(0).getTmp().getMax();
        current_tianqiTwo = gson2.getHeWeather5().get(0).getDailyForecast().get(0).getCond().getTxtD();

        for(int i=0;i < gson2.getHeWeather5().get(0).getDailyForecast().size();i++,two++){
            dateTwo.put(gson2.getHeWeather5().get(0).getDailyForecast().get(i).getDate());
            txt_dTwo.put(gson2.getHeWeather5().get(0).getDailyForecast().get(i).getCond().getTxtD());
            maxTwo.put(gson2.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMax());
            minTwo.put(gson2.getHeWeather5().get(0).getDailyForecast().get(i).getTmp().getMin());
            Log.d("YYYYY",dateTwo.toString());
        }
        SharedPreferences.Editor editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("cityTwo",cityTwo);
        editor.putInt("itemTwo", two);
        editor.putString("wenduTwo",current_wenduTwo);
        editor.putString("tianqiTwo",current_tianqiTwo);
        editor.putString("dateTwo",dateTwo.toString());
        editor.putString("txt_dTwo",txt_dTwo.toString());
        editor.putString("maxTwo",maxTwo.toString());
        editor.putString("minTwo",minTwo.toString());
//        loadPic();
        editor.putString("pic",pic);
        Log.d("ttttt",pic);
        editor.apply();
    }
//    private void loadPic(){
//        HttpUtil.sendOkHttpRequest("http://api.getlove.cn/api/img", new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                pic = response.body().string();
//            }
//        });
//    }
}
