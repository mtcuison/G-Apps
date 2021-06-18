package org.rmj.guanzongroup.guanzonapp.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.LoadService;
import org.rmj.guanzongroup.guanzonapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Activity_Service extends AppCompatActivity {

    private LoadService loadService;

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
        new LoadServiceTask().execute();
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

    private void setupServiceInfo(){
        imgBrand.setImageResource(getMcBrandLogo(loadService.getBrandName()));
        lblMcModel.setText(loadService.getModelName());
        lblMajorSrvc.setText(loadService.getMajorServiceInfo());
        lblMinorSrvc.setText(loadService.getMinorServiceInfo());
        lblDateNxtSrvc.setText(Date_Readable_Format(loadService.getNextReminders()));
    }

    private int getMcBrandLogo(String BrandName){
        switch (BrandName.toLowerCase().trim()){
            case "honda":
                return R.drawable.ic_honda;
            case "suzuki":
                return R.drawable.ic_suzuki;
            case "yamaha":
                return R.drawable.ic_yamaha;
            case "kawasaki":
                return R.drawable.ic_kawasaki;
            case "kymco":
                return R.drawable.ic_kymco;
        }
        return 0;
    }

    private void setupWidgets(){
        Toolbar toolbar = findViewById(R.id.toolbar_service);
        toolbar.setTitle("Motorcycle Service");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadService = new LoadService(Activity_Service.this);

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

    @SuppressLint("StaticFieldLeak")
    class LoadServiceTask extends AsyncTask<Integer, Integer, String>{

        String result;

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            loading.setMessage("Checking Motorcycle Service Info.");
            loading.showDialog();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            loadService.RequestServiceInfo(new LoadService.OnRequestServiceListener() {
                @Override
                public void onSuccess() {
                    result = "success";
                }

                @Override
                public void onFailed(String message) {
                    result = "error";
                }
            });
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismissDialog();
            setupServiceInfo();
            this.cancel(true);
        }
    }

}
