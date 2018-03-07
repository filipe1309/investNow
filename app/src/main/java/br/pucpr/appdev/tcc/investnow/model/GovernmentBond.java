package br.pucpr.appdev.tcc.investnow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GovernmentBond {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("rateReturn")
    @Expose
    private Double rateReturn;
    @SerializedName("minimumValue")
    @Expose
    private Double minimumValue;
    @SerializedName("unitPrice")
    @Expose
    private Double unitPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Double getRateReturn() {
        return rateReturn;
    }

    public void setRateReturn(Double rateReturn) {
        this.rateReturn = rateReturn;
    }

    public Double getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(Double minimumValue) {
        this.minimumValue = minimumValue;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
