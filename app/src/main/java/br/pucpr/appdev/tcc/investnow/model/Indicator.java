package br.pucpr.appdev.tcc.investnow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Indicator {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rate_value")
    @Expose
    private Object rateValue;
    @SerializedName("rate_obs")
    @Expose
    private String rateObs;
    @SerializedName("rate_date-formatted")
    @Expose
    private String rateDateFormatted;
    @SerializedName("daily_value")
    @Expose
    private Object dailyValue;
    @SerializedName("daily_obs")
    @Expose
    private String dailyObs;
    @SerializedName("daily_date-formatted")
    @Expose
    private String dailyDateFormatted;
    @SerializedName("date-update-formatted")
    @Expose
    private String dateUpdateFormatted;
    @SerializedName("date-update")
    @Expose
    private Double dateUpdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getRateValue() {
        return rateValue;
    }

    public void setRateValue(Object rateValue) {
        this.rateValue = rateValue;
    }

    public String getRateObs() {
        return rateObs;
    }

    public void setRateObs(String rateObs) {
        this.rateObs = rateObs;
    }

    public String getRateDateFormatted() {
        return rateDateFormatted;
    }

    public void setRateDateFormatted(String rateDateFormatted) {
        this.rateDateFormatted = rateDateFormatted;
    }

    public Object getDailyValue() {
        return dailyValue;
    }

    public void setDailyValue(Object dailyValue) {
        this.dailyValue = dailyValue;
    }

    public String getDailyObs() {
        return dailyObs;
    }

    public void setDailyObs(String dailyObs) {
        this.dailyObs = dailyObs;
    }

    public String getDailyDateFormatted() {
        return dailyDateFormatted;
    }

    public void setDailyDateFormatted(String dailyDateFormatted) {
        this.dailyDateFormatted = dailyDateFormatted;
    }

    public String getDateUpdateFormatted() {
        return dateUpdateFormatted;
    }

    public void setDateUpdateFormatted(String dateUpdateFormatted) {
        this.dateUpdateFormatted = dateUpdateFormatted;
    }

    public Double getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Double dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
