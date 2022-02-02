package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.digitalgcard.Adapter.Adapter_GcardList;
import org.rmj.guanzongroup.digitalgcard.Model.GcardInfo;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_ManageGcard extends AppCompatActivity {

    private Adapter_GcardList poAdapter;
    private MaterialButton btnAddGcard;
    private Toolbar toolbar;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_gcard);

        initViews();
        setUpToolbar();
        setGcardAdapter();

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

    private void setGcardAdapter() {
        List<GcardInfo> loGcards = new ArrayList<>();
        GcardInfo loGcard = new GcardInfo("1","2","Juan Dela Cruz", 100);
        loGcards.add(loGcard);
        poAdapter = new Adapter_GcardList(loGcards);
        recyclerView.setAdapter(poAdapter);
        poAdapter.notifyDataSetChanged();
    }

}