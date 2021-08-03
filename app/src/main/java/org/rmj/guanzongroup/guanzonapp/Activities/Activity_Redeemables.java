package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMRedeemables;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMTransactions;

public class Activity_Redeemables extends AppCompatActivity {

    private static final String TAG = Activity_Redeemables.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static Activity_Redeemables instance;
    public boolean isOpen = false;

    private RecyclerView recyclerView;
    private TextView orderItems;
    private LinearLayout layout;
    private VMRedeemables mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeemables);
        mViewModel = ViewModelProviders.of(Activity_Redeemables.this).get(VMRedeemables.class);
        setupWidgets();

    }

    private void setupWidgets(){
        Toolbar toolbar = findViewById(R.id.toolbar_redeemables);
        toolbar.setTitle("Redeemables");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout = findViewById(R.id.linear_emptyList);

        recyclerView = findViewById(R.id.recycler_view_redeemables);
    }

}
