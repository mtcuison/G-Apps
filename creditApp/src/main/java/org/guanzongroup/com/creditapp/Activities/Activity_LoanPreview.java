package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanPreview;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanProductList;

public class Activity_LoanPreview extends AppCompatActivity {
    private static final String TAG = Activity_LoanPreview.class.getSimpleName();

    private VMLoanPreview mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_LoanPreview.this).get(VMLoanPreview.class);
        setContentView(R.layout.activity_loan_preview);

        mViewModel.InitIntentData(getIntent());

        mViewModel.getCreditAppData().observe(Activity_LoanPreview.this, mpCreditApp -> {
            try{
                Log.d(TAG, "Data passed: " + mpCreditApp.getData());
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}