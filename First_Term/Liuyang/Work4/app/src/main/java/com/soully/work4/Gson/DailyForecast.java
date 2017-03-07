package com.soully.work4.Gson;

/**
 * Created by Soully on 2017/2/9.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyForecast {

    @SerializedName("astro")
    @Expose
    private Astro astro;
    @SerializedName("cond")
    @Expose
    private Cond cond;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("hum")
    @Expose
    private String hum;
    @SerializedName("pcpn")
    @Expose
    private String pcpn;
    @SerializedName("pop")
    @Expose
    private String pop;
    @SerializedName("pres")
    @Expose
    private String pres;
    @SerializedName("tmp")
    @Expose
    private Tmp tmp;
    @SerializedName("uv")
    @Expose
    private String uv;
    @SerializedName("vis")
    @Expose
    private String vis;
    @SerializedName("wind")
    @Expose
    private Wind wind;

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public Cond getCond() {
        return cond;
    }

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public Tmp getTmp() {
        return tmp;
    }

    public void setTmp(Tmp tmp) {
        this.tmp = tmp;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

}
