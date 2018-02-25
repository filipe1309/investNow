package br.pucpr.appdev.tcc.investnow;

import br.pucpr.appdev.tcc.investnow.model.IndicatorResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IndicatorApiService {
    @GET("indicadores")
    Call<IndicatorResponse> getIndicators();
}
