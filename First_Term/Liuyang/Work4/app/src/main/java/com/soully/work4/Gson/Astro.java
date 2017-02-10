package com.soully.work4.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astro {

    @SerializedName("mr")
    @Expose
    private String mr;
    @SerializedName("ms")
    @Expose
    private String ms;
    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("ss")
    @Expose
    private String ss;

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

}