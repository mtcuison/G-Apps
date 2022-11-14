package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMApplicantInfo;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanPreview;
import org.json.JSONException;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;

public class Activity_ApplicantInfo extends AppCompatActivity {
    private static final String TAG = Activity_ApplicantInfo.class.getSimpleName();

    private VMApplicantInfo mViewModel;

    private Toolbar toolbar;
    private TextInputEditText txtLastNm,
                                txtFrstNm,
                                txtMiddNm,
                                txtSuffix,
                                txtFbAcct,
                                txtHouseN,
                                txtLotNox,
                                txtStreet;

    private AutoCompleteTextView txtGender,
                                    txtCvlStt,
                                    txtTown,
                                    txtBrgy;

    private MaterialButton btnNext;

    private String[] GENDER = {"Male", "Female", "LGBTQ"};
    private String[] CIVIL_STATUS = {
            "Single",
            "Married",
            "Separated",
            "Widowed",
            "Single-Parent",
            "Single-Parent W/ Live-in Partner"};

    private MpCreditApp poApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ApplicantInfo.this).get(VMApplicantInfo.class);
        setContentView(R.layout.activity_applicant_info);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLastNm = findViewById(R.id.tieLastName);
        txtFrstNm = findViewById(R.id.tieFrstName);
        txtMiddNm = findViewById(R.id.tieMiddName);
        txtSuffix = findViewById(R.id.tieSuffix);
        txtFbAcct = findViewById(R.id.tieFacebook);
        txtHouseN = findViewById(R.id.tieHouseNo);
        txtLotNox = findViewById(R.id.tieLotNo);
        txtStreet = findViewById(R.id.tieStreet);
        txtGender = findViewById(R.id.tieGender);
        txtCvlStt = findViewById(R.id.tieCvilStat);
        txtTown = findViewById(R.id.tieTown);
        txtBrgy = findViewById(R.id.tieBrgy);
        btnNext = findViewById(R.id.btnNext);

        mViewModel.InitIntentData(getIntent());

        txtGender.setAdapter(new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, GENDER));

        txtCvlStt.setAdapter(new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, CIVIL_STATUS));

        txtGender.setOnItemClickListener((adapterView, view, i, l) -> {
            try {
                poApp.clientInfo().setGender(String.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        txtCvlStt.setOnItemClickListener((adapterView, view, i, l) -> {
            try{
                poApp.clientInfo().setCivilStatus(String.valueOf(i));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.InitializeApplicantInfo(new VMApplicantInfo.OnInitializeInfo() {
            @Override
            public void OnLoad(String title, String message) {

            }

            @Override
            public void OnSuccess(MpCreditApp args) {
                try {
                    poApp = args;
                    txtLastNm.setText(args.clientInfo().getLastName());
                    txtFrstNm.setText(args.clientInfo().getFirstName());
                    txtMiddNm.setText(args.clientInfo().getMiddleName());
                    txtSuffix.setText(args.clientInfo().getSuffix());
                    txtFbAcct.setText(args.clientInfo().getFacebook());
                    txtHouseN.setText(args.clientInfo().addressInfo().getHouseNo());
                    txtLotNox.setText(args.clientInfo().addressInfo().getAddress1());
                    txtStreet.setText(args.clientInfo().addressInfo().getAddress2());
                    int lnGender = Integer.parseInt(args.clientInfo().getGender());
                    txtGender.setText(GENDER[lnGender]);
                    int lnCvilSt = Integer.parseInt(args.clientInfo().getCivilStatus());
                    txtCvlStt.setText(CIVIL_STATUS[lnCvilSt]);
                    txtTown.setText(args.clientInfo().addressInfo().getTown());
                    txtBrgy.setText(args.clientInfo().addressInfo().getBrgy());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void OnFailed(String message) {

            }
        });

        btnNext.setOnClickListener(view -> {
            try {
                Intent loIntent = new Intent(Activity_ApplicantInfo.this, Activity_LoanPreview.class);
                loIntent.putExtra("sDetlInfo", poApp.getData());
                startActivity(loIntent);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}