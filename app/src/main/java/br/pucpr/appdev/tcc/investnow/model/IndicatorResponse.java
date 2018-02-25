package br.pucpr.appdev.tcc.investnow.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IndicatorResponse {
    @SerializedName("results")
    private List<Indicator> results;

    public List<Indicator> getResults() {
        return results;
    }

    public void setResults(List<Indicator> results) {
        this.results = results;
    }
}
