package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_PersonalInfo extends AppCompatActivity {

    private AutoCompleteTextView txt_cCivilStat, txt_cGenderCd, txt_sTownIDxx, txt_sBrgyIDxx;
    private TextInputEditText txt_sLastName, txt_sFrstName, txt_sSuffixNm, txt_sMiddName, txt_sMaidenNm,
            txt_sFBAcctxx, txt_sLandmark, txt_sHouseNox, txt_sAddress1, txt_sAddress2;
    private Toolbar toolbar;
    private MaterialButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        initViews();
        arrayList();
        setUpToolbar();
    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {


//            try {
//
//
//                JSONObject params = new JSONObject();
//                params.put("sDownPayment", (Objects.requireNonNull(txt_sLastName.getText()).toString()));

            Intent loIntent = new Intent(Activity_PersonalInfo.this, Activity_MeansInfo.class);

//                loIntent.putExtra("params", params.toString());
//
            startActivity(loIntent);
            this.finish();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        });
    }

    private void arrayList() {

        ArrayList<String> cStatus = new ArrayList<>();
        cStatus.add("Single");
        cStatus.add("Married");
        cStatus.add("Separated");
        cStatus.add("Widowed");
        cStatus.add("Single parent");
        cStatus.add("Single parent with Live in");

        ArrayAdapter<String> cStatusAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, cStatus
        );
        txt_cCivilStat.setAdapter(cStatusAdapter);

        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("LGBTQ++");

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, gender
        );
        txt_cGenderCd.setAdapter(genderAdapter);
    }

    private void initViews() {

        txt_sLastName = findViewById(R.id.tie_LastName);
        txt_sFrstName = findViewById(R.id.tie_firstname);
        txt_sSuffixNm = findViewById(R.id.tie_suffix);
        txt_sMiddName = findViewById(R.id.tie_middname);
        txt_cCivilStat = findViewById(R.id.tie_civil_stat);
        txt_cGenderCd = findViewById(R.id.tie_gender);
        txt_sMaidenNm = findViewById(R.id.tie_MaidenName);
        txt_sFBAcctxx = findViewById(R.id.tie_FbAcc);

        txt_sLandmark = findViewById(R.id.tie_Landmark);
        txt_sHouseNox = findViewById(R.id.tie_houseNo);
        txt_sAddress1 = findViewById(R.id.tie_PLSitio);
        txt_sAddress2 = findViewById(R.id.tie_street);
        txt_sTownIDxx = findViewById(R.id.tie_towncity);
        txt_sBrgyIDxx = findViewById(R.id.tie_barangay);

        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnNext);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Personal Info");
    }
}