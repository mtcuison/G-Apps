package org.rmj.guanzongroup.guanzonapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.Database.Repositories.RServiceInfo;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Activity_Service extends AppCompatActivity {

    private VMService mViewModel;
    private RServiceInfo poService;
    private TextView lblMcModel;
    private TextView lblMinorSrvc;
    private TextView lblMajorSrvc;
    private TextView lblDateNxtSrvc;
    private ImageView imgBrand;

    private Dialog_Loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        loading = new Dialog_Loading(Activity_Service.this);
        setupWidgets();
        setupServiceInfo();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupWidgets(){
        mViewModel = ViewModelProviders.of(Activity_Service.this).get(VMService.class);
        Toolbar toolbar = findViewById(R.id.toolbar_service);
        toolbar.setTitle("Motorcycle Service");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgBrand = findViewById(R.id.img_service_brandLogo);
        lblMcModel = findViewById(R.id.lbl_service_motorCycle_model);
        lblMajorSrvc = findViewById(R.id.lbl_service_majorService);
        lblMinorSrvc = findViewById(R.id.lbl_service_minorService);
        lblDateNxtSrvc = findViewById(R.id.lbl_service_nextService_date);
        MaterialButton btnScheduleNxt = findViewById(R.id.btn_service_schedule_nextDate);

        btnScheduleNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This feature is not yet available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupServiceInfo(){
        mViewModel.getActiveServiceInfo().observe(Activity_Service.this, foService -> {
            imgBrand.setImageResource(getMcBrandLogo(foService.getBrandNme()));
            lblMcModel.setText(foService.getModelNme());
            lblMajorSrvc.setText(String.valueOf(foService.getYellowxx()));
            lblMinorSrvc.setText(String.valueOf(foService.getWhitexxx()));
            lblDateNxtSrvc.setText(Date_Readable_Format(foService.getNxtRmnds()));
        });
    }

    @SuppressLint("SimpleDateFormat")
    private String Date_Readable_Format(String dateReceive){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateReceive);
            return new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    private int getMcBrandLogo(String BrandName){
        switch (BrandName.toLowerCase().trim()){
            case "honda":
                return R.drawable.ic_mc_honda;
            case "suzuki":
                return R.drawable.ic_mc_suzuki;
            case "yamaha":
                return R.drawable.ic_mc_yamaha;
            case "kawasaki":
                return R.drawable.ic_mc_kawasaki;
            case "kymco":
                return R.drawable.ic_mc_kymco;
        }
        return 0;
    }
}
