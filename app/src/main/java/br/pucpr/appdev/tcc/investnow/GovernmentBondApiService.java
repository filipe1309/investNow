package br.pucpr.appdev.tcc.investnow;

import br.pucpr.appdev.tcc.investnow.model.GovernmentBondResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GovernmentBondApiService {
    @GET("titulos-tesouro-direto")
    Call<GovernmentBondResponse> getGovernmentBonds();
}
