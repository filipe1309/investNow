package br.pucpr.appdev.tcc.investnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GovernmentBondResponse {
    @SerializedName("results")
    private List<GovernmentBond> results;

    public List<GovernmentBond> getResults() {
        return results;
    }

    public void setResults(List<GovernmentBond> results) {
        this.results = results;
    }
}
