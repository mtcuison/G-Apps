package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.guanzongroup.useraccount.Fragment.Fragment_AddressCreate;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_AddressList;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.ActivityShippingAddressBinding;

import java.util.Objects;

public class Activity_ShippingAddress extends AppCompatActivity {

    private static Activity_ShippingAddress instance;
    private VMShippingAddress mViewModel;
    private ActivityShippingAddressBinding mBinding;
    private static int pnPageNox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = Activity_ShippingAddress.this;
        mViewModel = new ViewModelProvider(Activity_ShippingAddress.this)
                .get(VMShippingAddress.class);
        mBinding = ActivityShippingAddressBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUpToolbar();
        setFragment(0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            closeRedirection();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        closeRedirection();
    }

    public static Activity_ShippingAddress getInstance() {
        return instance;
    }

    public void setFragment(int fnPageNox) {
        FragmentTransaction mFragHold = getSupportFragmentManager().beginTransaction();
        switch (fnPageNox) {
            case 1:
                mFragHold.replace(mBinding.container.getId(), new Fragment_AddressCreate());
                mFragHold.commit();
                break;
            default:
                mFragHold.replace(mBinding.container.getId(), new Fragment_AddressList());
                mFragHold.commit();
                break;
        }
        pnPageNox = fnPageNox;
    }

    private void setUpToolbar() {
        setSupportActionBar(mBinding.appToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shipping Address");
    }

    private void closeRedirection() {
        if(pnPageNox == 1) {
            setFragment(0);
        } else {
            finish();
        }
    }
}