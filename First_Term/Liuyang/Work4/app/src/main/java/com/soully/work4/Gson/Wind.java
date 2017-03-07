package com.soully.work4.Gson;

/**
 * Created by Soully on 2017/2/9.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("deg")
    @Expose
    private String deg;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("sc")
    @Expose
    private String sc;
    @SerializedName("spd")
    @Expose
    private String spd;

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

}
