package com.example.hp.wechat.Demo;

/**
 * Created by HP on 2017/2/11.
 */

public class Contacts {
    private String name;
    private  int imageID;

    public Contacts(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }
}
