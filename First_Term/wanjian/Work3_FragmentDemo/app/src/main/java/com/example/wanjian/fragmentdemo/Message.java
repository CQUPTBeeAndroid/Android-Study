package com.example.wanjian.fragmentdemo;

/**
 * Created by wanjian on 2017/2/9.
 */

public class Message {

    private String name;
    private int imageId;

    public Message(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
