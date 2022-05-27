package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.guanzongroup.useraccount.Fragment.Fragment_AddressList;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.ActivityShippingAddressBinding;

import java.util.Objects;

public class Activity_ShippingAddress extends AppCompatActivity {

    private VMShippingAddress mViewModel;
    private ActivityShippingAddressBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ShippingAddress.this)
                .get(VMShippingAddress.class);
        mBinding = ActivityShippingAddressBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUpToolbar();
        setFragment();
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

    private void setUpToolbar() {
        setSupportActionBar(mBinding.appToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shipping Address");
    }

    private void setFragment() {
        FragmentTransaction mFragHold = getSupportFragmentManager().beginTransaction();
        mFragHold.replace(mBinding.container.getId(), new Fragment_AddressList());
        mFragHold.commit();
    }

}