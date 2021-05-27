package org.rmj.guanzongroup.guanzonapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_AllTransactions;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_PointsEarn;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_Redemption;
import org.rmj.guanzongroup.guanzonapp.R;


public class Activity_Transactions extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;

    private String[] TabTitles = {
            "All Transactions",
            "Points Earn",
            "Redemption"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        setupWidgets();
        setupTablayoutListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void setupWidgets(){
        toolbar = findViewById(R.id.toolbar_transactions);
        toolbar.setTitle("All Transactions");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tablayout_transactions);
        ViewPager viewPager = findViewById(R.id.viewpager_transactions);

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_AllTransactions());
        adapter.addFragment(new Fragment_PointsEarn());
        adapter.addFragment(new Fragment_Redemption());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_transaction_tab_all);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_transaction_tab_card);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_transaction_tab_redeem);
    }

    private void setupTablayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(TabTitles[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
