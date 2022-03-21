package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.rmj.guanzongroup.guanzonapp.Adapter.Adapter_AccountDetails;
import org.rmj.guanzongroup.guanzonapp.Adapter.Adapter_AccountSettings;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMAccountDetails;

import java.util.Objects;

public class Activity_AccountDetails extends AppCompatActivity {
    private static final String TAG = Activity_AccountDetails.class.getSimpleName();
    private VMAccountDetails mViewModel;
    private Adapter_AccountDetails poAdapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        mViewModel = new ViewModelProvider(Activity_AccountDetails.this)
                .get(VMAccountDetails.class);

        initViews();
        setUpToolbar();
        setAdapter();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    // Initialize this first before anything else.
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Activity_AccountDetails.this));
        recyclerView.setHasFixedSize(true);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
       setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Account Details");
    }

    private void setAdapter() {
        mViewModel.getAccountDetailsList().observe(Activity_AccountDetails.this, details -> {
            poAdapter = new Adapter_AccountDetails(details);
            Log.e(TAG, String.valueOf(poAdapter.getItemCount()));
            recyclerView.setAdapter(poAdapter);
            poAdapter.notifyDataSetChanged();
        });
    }

}