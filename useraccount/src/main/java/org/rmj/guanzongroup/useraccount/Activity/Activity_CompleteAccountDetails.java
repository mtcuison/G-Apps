package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.etc.InputFieldController;
import org.rmj.guanzongroup.useraccount.Model.CompleteAccountDetailsInfo;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_CompleteAccountDetails extends AppCompatActivity {

    private VMAccountDetails mViewModel;
    private CompleteAccountDetailsInfo poDataMdl;
    private Toolbar toolbar;
    private TextInputEditText txtLastNm, txtFirstN, txtMidNme, txtSuffix, txtBdatex, txtTaxNox,
            txtHouseN, txtStreet;
    private AutoCompleteTextView txtBplace, txtGender, txtCivilS, txtCtizen, txtTownCt, txtBarngy;
    private MaterialButton btnSaveDt;

    private List<DAddress.oTownObj> poTownCty = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_account_details);
        initObjects();
        initViews();
        setUpToolbar();
        setInputOptions();
        btnSaveDt.setOnClickListener(v -> saveAccountDetails());
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

    private void initObjects() {
        mViewModel = new ViewModelProvider(Activity_CompleteAccountDetails.this)
                .get(VMAccountDetails.class);
        poDataMdl = new CompleteAccountDetailsInfo();
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
        btnSaveDt = findViewById(R.id.btnSave);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Complete Details");
    }

    private void saveAccountDetails() {
        poDataMdl.setLastName(Objects.requireNonNull(txtLastNm.getText().toString().trim()));
        poDataMdl.setFirstName(Objects.requireNonNull(txtFirstN.getText().toString().trim()));
        poDataMdl.setMiddName(Objects.requireNonNull(txtMidNme.getText().toString().trim()));
        poDataMdl.setSuffixName(Objects.requireNonNull(txtSuffix.getText().toString().trim()));
        poDataMdl.setBirthDate(Objects.requireNonNull(txtBdatex.getText().toString().trim()));
        poDataMdl.setTaxIdNumber(Objects.requireNonNull(txtTaxNox.getText().toString().trim()));
        poDataMdl.setHouseNumber(Objects.requireNonNull(txtHouseN.getText().toString().trim()));
        poDataMdl.setAddress(Objects.requireNonNull(txtStreet.getText().toString().trim()));
        if(poDataMdl.isDataValid()) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            CompleteAccountDetailsInfo lo = poDataMdl;
        } else {
            Toast.makeText(this, poDataMdl.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setInputOptions() {
        /** Date Auto Formatter */
        txtBdatex.addTextChangedListener(new InputFieldController.OnDateSetListener(txtBdatex));

        /** AutoCompleteTextviews */

        // Setup auto complete town/city fields.
        mViewModel.getTownCityList().observe(Activity_CompleteAccountDetails.this, townObj ->{
            try {
                ArrayList<String> lsTownCts = mViewModel.getTownCityForInput(townObj);
                txtBplace.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this, lsTownCts
                        )
                );
                txtTownCt.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this, lsTownCts
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mViewModel.getCountryList().observe(Activity_CompleteAccountDetails.this, countries -> {
            try {
                ArrayList<String> lsCountry = mViewModel.getCountryForInput(countries);
                txtCtizen.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this,
                                lsCountry
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /** Dropdowns */

        // Setup gender field.
        txtGender.setAdapter(
                InputFieldController.getAutoCompleteData(
                        Activity_CompleteAccountDetails.this,
                        mViewModel.getGenderList()
                )
        );

        // Setup Civil status field.
        txtCivilS.setAdapter(
                InputFieldController.getAutoCompleteData(
                    Activity_CompleteAccountDetails.this,
                    mViewModel.getCivilStatusList()
                )
        );


        /** Set OnItemClickListeners on Auto Complete Input Fields */
        txtBplace.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getTownCityList().observe(this, townCties -> {
                try {
                    for(int x = 0; x < townCties.size(); x++) {
                        String lsTownCty = "";
                        lsTownCty = townCties.get(x).sTownNm + ", " + townCties.get(x).sProvNm;
                        if(lsTownCty.equalsIgnoreCase(txtBplace.getText().toString().trim())) {
                            poDataMdl.setBirthPlace(townCties.get(x).sTownID);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtTownCt.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getTownCityList().observe(this, townObjs -> {
                try {
                    for (int x = 0; x < townObjs.size(); x++) {
                        String lsTownCt = townObjs.get(x).sTownNm + ", " + townObjs.get(x).sProvNm;
                        if (txtTownCt.getText().toString().equalsIgnoreCase(lsTownCt)) {
                            poDataMdl.setTownCity(townObjs.get(x).sTownID);
                            mViewModel.getBarangayList(townObjs.get(x).sTownID).observe(this, brgys -> {
                                txtBarngy.setAdapter(
                                        InputFieldController.getAutoCompleteData(
                                                Activity_CompleteAccountDetails.this,
                                                mViewModel.getBarangayForInput(brgys)
                                        )
                                );

                                txtBarngy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        for(int x = 0; x < brgys.size(); x++){
                                            if(brgys.get(x).getBrgyName().equalsIgnoreCase(txtBarngy.getText().toString().trim())){
                                                poDataMdl.setBarangay(brgys.get(x).getBrgyIDxx());
                                                break;
                                            }
                                        }
                                    }
                                });
                            });
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtCtizen.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getCountryList().observe(this, countries -> {
                try {
                    for(int x = 0; x < countries.size(); x++) {
                        if(countries.get(x).getNational() != null && !countries.get(x).getNational().isEmpty()) {
                            if(countries.get(x).getNational().equalsIgnoreCase(txtCtizen.getText().toString().trim())) {
                                poDataMdl.setCitizenship(countries.get(x).getCntryCde());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtGender.setOnItemClickListener((adapterView, view, i, l) -> poDataMdl.setGender(String.valueOf(i)));
        txtCivilS.setOnItemClickListener((adapterView, view, i, l) -> poDataMdl.setCivilStat(String.valueOf(i)));
    }

}