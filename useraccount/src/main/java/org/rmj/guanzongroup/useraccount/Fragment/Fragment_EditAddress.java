package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;

public class Fragment_EditAddress extends Fragment {

    private VMShippingAddress mViewModel;

    public Fragment_EditAddress() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMShippingAddress.class);
        View view =  inflater.inflate(R.layout.fragment_edit_address, container, false);
        initViews(view);
        return view;
    }

    // Initialize this first before anything else.
    private void initViews(View view) {

    }

}