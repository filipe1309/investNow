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
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.pucpr.appdev.tcc.investnow.R;
import br.pucpr.appdev.tcc.investnow.adapter.LearnParentAdapter;
import br.pucpr.appdev.tcc.investnow.model.LearnChild;
import br.pucpr.appdev.tcc.investnow.model.LearnParent;

public class LearnActivity extends AppCompatActivity {

    private static final String TAG = "Learn";
    public RecyclerView mRecyclerView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
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
                                intent = new Intent(LearnActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_indicators:
                                intent = new Intent(LearnActivity.this, IndicatorsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_gov_bonds:
                                intent = new Intent(LearnActivity.this, GovernmentBondsActivity.class);
                                startActivity(intent);
                                break;
                        }

                        return true;
                    }
                });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Firebase
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("faq");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<LearnParent> learns = new ArrayList<LearnParent>();
                //Arrays.asList(opt1, opt2);

                for (DataSnapshot faqSnapshot: dataSnapshot.getChildren()) {
                    String questionKey = faqSnapshot.child("question").getKey();
                    String questionValue = faqSnapshot.child("question").getValue(String.class);
                    String answerKey = faqSnapshot.child("answer").getKey();
                    String answerValue = faqSnapshot.child("answer").getValue(String.class);
                    Log.d("Learn", "QuestionValue key: " + questionKey + ", value: " + questionValue);
                    Log.d("Learn", "Answer key: " + answerKey + ", value: " + answerValue);

                    LearnChild text1 = new LearnChild("--", Html.fromHtml(answerValue).toString());
                    LearnParent opt1 = new LearnParent(questionValue, Arrays.asList(text1));
                    learns.add(opt1);
                }

                mRecyclerView = (RecyclerView) findViewById(R.id.rc_learn);
                LearnParentAdapter adapter = new LearnParentAdapter(LearnActivity.this, learns);
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(LearnActivity.this));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
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
