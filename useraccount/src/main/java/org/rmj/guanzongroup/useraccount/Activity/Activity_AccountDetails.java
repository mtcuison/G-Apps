package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_AccountDetails;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.Objects;
import org.rmj.guanzongroup.useraccount.R;


public class Activity_AccountDetails extends AppCompatActivity {
    private static final String TAG = Activity_AccountDetails.class.getSimpleName();
    private VMAccountDetails mViewModel;
    private Adapter_AccountDetails poAdapter;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        mViewModel = new ViewModelProvider(Activity_AccountDetails.this)
                .get(VMAccountDetails.class);
        initViews();
        setUpToolbar();
        importAccountInfo();
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
        poDialogx = new Dialog_SingleButton(Activity_AccountDetails.this);
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
        try {
            mViewModel.getClientInfo().observe(this, eClientInfo -> {
                try {
                    mViewModel.getBirthplace(eClientInfo.getBirthPlc()).observe(this, bPlace -> {
                        try {
                            mViewModel.getFullAddress(eClientInfo.getBrgyIDxx()).observe(this, address -> {
                                try {
                                    String lsFulAdrs = eClientInfo.getHouseNox() + ", "
                                            + eClientInfo.getAddressx() + ", " + address;
                                    mViewModel.setAccountDetailsList(eClientInfo, lsFulAdrs, bPlace);
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            });
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            });
            mViewModel.getAccountDetailsList().observe(Activity_AccountDetails.this, details -> {
                poAdapter = new Adapter_AccountDetails(details, (label) -> {
                    Intent loIntent = new Intent(Activity_AccountDetails.this, Activity_EditAccountDetails.class);
                    if (label.equals("Personal Information")) {
                        loIntent.putExtra("index", 0);
                    } else if (label.equals("Present Address")) {
                        loIntent.putExtra("index", 1);
                    } else if (label.equals("Account Information")) {
                        loIntent.putExtra("index", 2);
                    }
                    startActivity(loIntent);
                });
                recyclerView.setAdapter(poAdapter);
                poAdapter.notifyDataSetChanged();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void importAccountInfo() {
        try {
            mViewModel.importAccountInfo(new VMAccountDetails.OnTransactionCallBack() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(Activity_AccountDetails.this);
                    poLoading.initDialog("Account Details", "Importing Account Data. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", fsMessage, dialog -> {
                        dialog.dismiss();
                        finish();
                    });
                    poDialogx.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}