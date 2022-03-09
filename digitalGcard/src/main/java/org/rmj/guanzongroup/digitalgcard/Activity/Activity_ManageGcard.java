package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Adapter.Adapter_GcardList;
import org.rmj.guanzongroup.digitalgcard.Model.GcardInfo;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_ManageGcard extends AppCompatActivity {
    private VMGCardSystem mViewModel;
    private Adapter_GcardList poAdapter;
    private MaterialButton btnAddGcard;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private TextView txtUserNm, txtCardNo, txtPoints, lblOtherx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_gcard);
        mViewModel = new ViewModelProvider(Activity_ManageGcard.this).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.GCARD);

        initViews();
        setUpToolbar();
        displayGcard();

        btnAddGcard.setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_ManageGcard.this, Activity_AddGcard.class);
            startActivity(loIntent);
        });
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
        txtUserNm = findViewById(R.id.lbl_gcard_user);
        txtCardNo = findViewById(R.id.lbl_card_number);
        txtPoints = findViewById(R.id.lbl_gcard_points);
        lblOtherx = findViewById(R.id.lblOtherGcard);
        btnAddGcard = findViewById(R.id.btnAddGcard);
        toolbar = findViewById(R.id.toolbar_transaction);
        recyclerView = findViewById(R.id.card_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Activity_ManageGcard.this));
        recyclerView.setHasFixedSize(true);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Manage GCard");
    }

    private void displayGcard() {
        displayActiveGcard();
        displayInactiveGcard();
    }

    private void displayActiveGcard() {
        mViewModel.hasActiveGcard().observe(Activity_ManageGcard.this, eGcardApp -> {
            try {
                if(eGcardApp != null) {
                    txtUserNm.setText(Objects.requireNonNull(eGcardApp.getNmOnCard()));
                    txtCardNo.setText(Objects.requireNonNull(eGcardApp.getCardNmbr()));
                    txtPoints.setText(Objects.requireNonNull(eGcardApp.getTotPoint()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void displayInactiveGcard() {
        mViewModel.hasInactiveGCard().observe(Activity_ManageGcard.this, eGcardApps -> {
            try {
                if(eGcardApps.size() > 0) {
                    lblOtherx.setVisibility(View.VISIBLE);
                    poAdapter = new Adapter_GcardList(eGcardApps);
                    recyclerView.setAdapter(poAdapter);
                    poAdapter.notifyDataSetChanged();
                } else {
                    lblOtherx.setVisibility(View.GONE);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }

}