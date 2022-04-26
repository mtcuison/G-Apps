package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.etc.OnDateSetListener;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.Objects;

public class Activity_CompleteAccountDetails extends AppCompatActivity {

    private VMAccountDetails mViewModel;
    private Toolbar toolbar;
    private TextInputEditText txtLastNm, txtFirstN, txtMidNme, txtSuffix, txtBdatex, txtGender,
            txtCivilS, txtTaxNox, txtHouseN, txtStreet;
    private AutoCompleteTextView txtBplace, txtCtizen, txtTownCt, txtBarngy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_account_details);
        mViewModel = new ViewModelProvider(Activity_CompleteAccountDetails.this)
                .get(VMAccountDetails.class);
        initViews();
        setUpToolbar();
        setInputOptions();

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
        txtLastNm = findViewById(R.id.tie_lastname);
        txtFirstN = findViewById(R.id.tie_firstname);
        txtMidNme = findViewById(R.id.tie_middname);
        txtSuffix = findViewById(R.id.tie_suffix);
        txtBdatex = findViewById(R.id.tie_bdate);
        txtBplace = findViewById(R.id.tie_bplace);
        txtGender = findViewById(R.id.tie_gender);
        txtCivilS = findViewById(R.id.tie_civil_stat);
        txtCtizen = findViewById(R.id.tie_citizen);
        txtTaxNox = findViewById(R.id.tie_taxId);
        txtHouseN = findViewById(R.id.tie_houseNo);
        txtStreet = findViewById(R.id.tie_street);
        txtTownCt = findViewById(R.id.tie_towncity);
        txtBarngy = findViewById(R.id.tie_barangay);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Complete Details");
    }

    private void setInputOptions() {
        txtBdatex.addTextChangedListener(new OnDateSetListener(txtBdatex));
    }

}