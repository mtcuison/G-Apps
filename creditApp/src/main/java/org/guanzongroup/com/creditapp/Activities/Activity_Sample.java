package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanProductList;

public class Activity_Sample extends AppCompatActivity {
    private static final String TAG = Activity_Sample.class.getSimpleName();

    private VMLoanProductList mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_Sample.this).get(VMLoanProductList.class);
        setContentView(R.layout.activity_sample);

        mViewModel.initData(getIntent());

        mViewModel.getCreditAppData().observe(Activity_Sample.this, mpCreditApp -> {
            try{
                Log.d(TAG, "Data passed: " + mpCreditApp.getData());
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}