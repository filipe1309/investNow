package br.pucpr.appdev.tcc.investnow.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.appdev.tcc.investnow.IndicatorApiService;
import br.pucpr.appdev.tcc.investnow.MainCard;
import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.adapter.IndicatorsAdapter;
import br.pucpr.appdev.tcc.investnow.adapter.MainAdapter;
import br.pucpr.appdev.tcc.investnow.model.GovernmentBond;
import br.pucpr.appdev.tcc.investnow.model.Indicator;
import br.pucpr.appdev.tcc.investnow.model.IndicatorResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView mListView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_lis);
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

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        Log.d(TAG, "Clicou: " + menuItem.getItemId());
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case R.id.nav_indicators:
                                intent = new Intent(MainActivity.this, IndicatorsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_gov_bonds:
                                intent = new Intent(MainActivity.this, GovernmentBondsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_learn:
                                intent = new Intent(MainActivity.this, LearnActivity.class);
                                startActivity(intent);
                                break;
                        }

                        return true;
                    }
                });



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Indicadores", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, IndicatorsActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton learn = (FloatingActionButton) findViewById(R.id.fab_learn);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });*/

        mListView = (ListView) findViewById(R.id.listView);

        ArrayList<MainCard> list = new ArrayList<>();

        list.add(new MainCard("https://tcc-pucpr-nodejs-server-filipe1309.c9users.io/images/indicadores.png", "Indicadores"));
        list.add(new MainCard("https://tcc-pucpr-nodejs-server-filipe1309.c9users.io/images/titulos.jpg", "Títulos"));
        list.add(new MainCard("https://tcc-pucpr-nodejs-server-filipe1309.c9users.io/images/aprenda.jpg", "Aprenda"));

        MainAdapter adapter = new MainAdapter(this, R.layout.activity_main, list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, IndicatorsActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, GovernmentBondsActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity.this, LearnActivity.class);
                        startActivity(intent3);
                }
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
