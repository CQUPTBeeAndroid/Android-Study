package com.soully.work4.Gson;

/**
 * Created by Soully on 2017/2/9.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeWeather5 {

    @SerializedName("basic")
    @Expose
    private Basic basic;
    @SerializedName("daily_forecast")
    @Expose
    private List<DailyForecast> dailyForecast = null;
    @SerializedName("status")
    @Expose
    private String status;

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public List<DailyForecast> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(List<DailyForecast> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
