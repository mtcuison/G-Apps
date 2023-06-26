package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMApplicantInfo;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanPreview;
import org.json.JSONException;
import org.rmj.g3appdriver.etc.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class Activity_ApplicantInfo extends AppCompatActivity {
    private static final String TAG = Activity_ApplicantInfo.class.getSimpleName();

    private static Activity_ApplicantInfo instance;
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

//    private MpCreditApp poApp;

    public static Activity_ApplicantInfo getInstance(){
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        mViewModel = new ViewModelProvider(Activity_ApplicantInfo.this).get(VMApplicantInfo.class);
        setContentView(R.layout.activity_applicant_info);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
//        setSupportActionBar(toolbar);
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

        txtGender.setOnItemClickListener((adapterView, view, i, l) -> {
//            try {
//                poApp.clientInfo().setGender(String.valueOf(i));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        });

        txtCvlStt.setOnItemClickListener((adapterView, view, i, l) -> {
//            try{
//                poApp.clientInfo().setCivilStatus(String.valueOf(i));
//            } catch (Exception e){
//                e.printStackTrace();
//            }
        });

//        mViewModel.InitializeApplicantInfo(new VMApplicantInfo.OnInitializeInfo() {
//            @Override
//            public void OnLoad(String title, String message) {
//
//            }
//
//            @Override
//            public void OnSuccess(MpCreditApp args) {
//                try {
//                    poApp = args;
//                    txtLastNm.setText(args.clientInfo().getLastName());
//                    txtFrstNm.setText(args.clientInfo().getFirstName());
//                    txtMiddNm.setText(args.clientInfo().getMiddleName());
//                    txtSuffix.setText(args.clientInfo().getSuffix());
//                    txtFbAcct.setText(args.clientInfo().getFacebook());
//                    txtHouseN.setText(args.clientInfo().addressInfo().getHouseNo());
//                    txtLotNox.setText(args.clientInfo().addressInfo().getAddress1());
//                    txtStreet.setText(args.clientInfo().addressInfo().getAddress2());
//                    int lnGender = Integer.parseInt(args.clientInfo().getGender());
//                    txtGender.setText(GENDER[lnGender]);
//                    int lnCvilSt = Integer.parseInt(args.clientInfo().getCivilStatus());
//                    txtCvlStt.setText(CIVIL_STATUS[lnCvilSt]);
//                    txtTown.setText(args.clientInfo().addressInfo().getTown());
//                    txtBrgy.setText(args.clientInfo().addressInfo().getBrgy());
//
//                    txtGender.setAdapter(new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, GENDER));
//
//                    txtCvlStt.setAdapter(new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, CIVIL_STATUS));
//
//
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void OnFailed(String message) {
//
//            }
//        });

//        mViewModel.GetTownList().observe(Activity_ApplicantInfo.this, townList -> {
//            try {
//                ArrayList<String> strings = new ArrayList<>();
//                for(int x = 0; x < townList.size(); x++){
//                    String lsTown = townList.get(x).sTownNm + ", " + townList.get(x).sProvNm;
//                    strings.add(lsTown);
//                }
//
//                ArrayAdapter<String> loAdapter = new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, strings.toArray(new String[0]));
//
//                txtTown.setAdapter(loAdapter);
//
//                txtTown.setOnItemClickListener((adapterView, view, i, l) -> {
//                    for(int x = 0; x < townList.size(); x++){
//                        if(txtTown.getText().toString().equalsIgnoreCase(strings.get(x))) {
//                            try {
//                                poApp.clientInfo().addressInfo().setTownID(townList.get(x).sTownID);
//                                mViewModel.setTownID(townList.get(x).sTownID);
//                                break;
//                            } catch (Exception e){
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });

//        mViewModel.GetTownID().observe(Activity_ApplicantInfo.this, townID -> {
//            mViewModel.GetBarangayList(townID).observe(Activity_ApplicantInfo.this, brgyList -> {
//                try{
//                    ArrayList<String> strings = new ArrayList<>();
//                    for(int x = 0; x < brgyList.size(); x++){
//                        String lsTown = brgyList.get(x).getBrgyName();
//                        strings.add(lsTown);
//                    }
//
//                    ArrayAdapter<String> loAdapter = new ArrayAdapter<>(Activity_ApplicantInfo.this, android.R.layout.simple_spinner_dropdown_item, strings.toArray(new String[0]));
//
//                    txtBrgy.setAdapter(loAdapter);
//
//                    txtBrgy.setOnItemClickListener((adapterView, view, i, l) -> {
//                        for(int x = 0; x < brgyList.size(); x++){
//                            if(txtBrgy.getText().toString().equalsIgnoreCase(strings.get(x))) {
//                                try {
//                                    poApp.clientInfo().addressInfo().setBarangayID(brgyList.get(x).getBrgyIDxx());
//                                    break;
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    });
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            });
//        });

//        btnNext.setOnClickListener(view -> {
//            try {
//                poApp.clientInfo().setLastName(txtLastNm.getText().toString().trim());
//                poApp.clientInfo().setFirstName(txtFrstNm.getText().toString().trim());
//                poApp.clientInfo().setMiddleName(txtMiddNm.getText().toString().trim());
//                poApp.clientInfo().setSuffix(txtSuffix.getText().toString().trim());
//                poApp.clientInfo().setFacebook(txtFbAcct.getText().toString().trim());
//                poApp.clientInfo().addressInfo().setHouseNo(txtHouseN.getText().toString().trim());
//                poApp.clientInfo().addressInfo().setAddress1(txtLotNox.getText().toString().trim());
//                poApp.clientInfo().addressInfo().setAddress2(txtStreet.getText().toString().trim());
//
//                Intent loIntent = new Intent(Activity_ApplicantInfo.this, Activity_LoanPreview.class);
//                loIntent.putExtra("sListngID", mViewModel.getModel().getLsListngID());
//                loIntent.putExtra("sUnitAppl", mViewModel.getModel().getLsUnitAppl());
//                loIntent.putExtra("sModelIDx", mViewModel.getModel().getLsModelIDx());
//                loIntent.putExtra("sLoanTerm", mViewModel.getModel().getLsInstallx());
//                loIntent.putExtra("sDownPaym", mViewModel.getModel().getLsDownPaym());
//                loIntent.putExtra("nMonAmort", mViewModel.getModel().getLsAmortztn());
//                loIntent.putExtra("nDiscount", mViewModel.getModel().getLsDiscount());
//                loIntent.putExtra("nMiscExps", mViewModel.getModel().getLsMiscExps());
//                loIntent.putExtra("sDetlInfo", poApp.getData());
//                startActivity(loIntent);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}