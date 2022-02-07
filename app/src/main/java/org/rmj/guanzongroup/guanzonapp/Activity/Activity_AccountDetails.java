package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMAccountDetails;

import java.util.Objects;

public class Activity_AccountDetails extends AppCompatActivity {

    private VMAccountDetails mViewModel;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        mViewModel = new ViewModelProvider(Activity_AccountDetails.this)
                .get(VMAccountDetails.class);

        initViews();
        setUpToolbar();

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
//        recyclerView = findViewById(org.rmj.guanzongroup.digitalgcard.R.id.card_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(Activity_ManageGcard.this));
//        recyclerView.setHasFixedSize(true);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
       setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Account Details");
    }



}