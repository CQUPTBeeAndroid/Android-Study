package com.soully.work4.Gson;

/**
 * Created by Soully on 2017/2/9.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Update {

    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("utc")
    @Expose
    private String utc;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

}
