package br.pucpr.appdev.tcc.investnow.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import br.pucpr.appdev.tcc.investnow.GovernmentBondApiService;
import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.adapter.GovernmentBondsAdapter;
import br.pucpr.appdev.tcc.investnow.model.GovernmentBond;
import br.pucpr.appdev.tcc.investnow.model.GovernmentBondResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GovernmentBondsActivity extends AppCompatActivity {
    private static final String TAG = GovernmentBondsActivity.class.getSimpleName();

    public static final String BASE_URL = "https://tcc-pucpr-nodejs-server-filipe1309.c9users.io/";

    private static Retrofit retrofit = null;

    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_bonds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                /*Snackbar.make(view, "Indicadores", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(GovernmentBondsActivity.this, MainActivity.class);
                startActivity(intent);*/
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_government_bonds);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectAndGetApiData();
    }
    // This method create an instance of Retrofit
    // set the base url
    public void connectAndGetApiData(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        GovernmentBondApiService governmentBondApiService= retrofit.create(GovernmentBondApiService.class);

        Call<GovernmentBondResponse> call = governmentBondApiService.getGovernmentBonds();

        call.enqueue(new Callback<GovernmentBondResponse>() {
            @Override
            public void onResponse(Call<GovernmentBondResponse> call, Response<GovernmentBondResponse> response) {
                List<GovernmentBond> movies = response.body().getResults();
                recyclerView.setAdapter(new GovernmentBondsAdapter(movies, R.layout.list_item_government_bonds, getApplicationContext()));
            }

            @Override

            public void onFailure(Call<GovernmentBondResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }
}
