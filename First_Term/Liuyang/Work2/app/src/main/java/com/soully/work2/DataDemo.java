package com.soully.work2;

import android.widget.RatingBar;

/**
 * Created by Soully on 2017/1/16.
 */

public class DataDemo {
    private int image;
    private String text;
    private String text_see;
    private String text_shanchang;
    private String text_zhiye;
    int ratingBar;
    public DataDemo(int imageId,String text,String text_see,String text_zhiye,String text_shanchang,int ratingBar){
        this.image = imageId;
        this.text = text;
        this.text_see = text_see;
        this.text_shanchang = text_shanchang;
        this.text_zhiye = text_zhiye;
        this.ratingBar = ratingBar;
    }

    public int getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(int ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getText_zhiye() {
        return text_zhiye;
    }

    public void setText_zhiye(String text_zhiye) {
        this.text_zhiye = text_zhiye;
    }

    public String getText_shanchang() {
        return text_shanchang;
    }

    public void setText_shanchang(String text_shanchang) {
        this.text_shanchang = text_shanchang;
    }

    public String getText_see() {
        return text_see;
    }

    public void setText_see(String text_see) {
        this.text_see = text_see;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
