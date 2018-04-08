package br.pucpr.appdev.tcc.investnow.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
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
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_bonds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.menu_hb);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home:
                                intent = new Intent(GovernmentBondsActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_indicators:
                                intent = new Intent(GovernmentBondsActivity.this, IndicatorsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_learn:
                                intent = new Intent(GovernmentBondsActivity.this, LearnActivity.class);
                                startActivity(intent);
                                break;
                        }

                        return true;
                    }
                });

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rc_government_bonds);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0 ||dy<0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
