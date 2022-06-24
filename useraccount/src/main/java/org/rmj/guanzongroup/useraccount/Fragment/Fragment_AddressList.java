package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ShippingAddress;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_ShippingAddress;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.FragmentAddressListBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment_AddressList extends Fragment {

    private VMShippingAddress mViewModel;
    private FragmentAddressListBinding mBinding;
    private Adapter_ShippingAddress poAdapter;

    public Fragment_AddressList() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMShippingAddress.class);
        mBinding = FragmentAddressListBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        mBinding.btnAddShp.setOnClickListener(v -> Activity_ShippingAddress.getInstance().setFragment(1));
        setAddressAdapter();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void setAddressAdapter() {
        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            try {
                List<EClientInfo> loClientx = new ArrayList<>();
                loClientx.add(eClientInfo);
                poAdapter = new Adapter_ShippingAddress(loClientx);
                mBinding.recyclerVw.setLayoutManager(new LinearLayoutManager(requireActivity()));
                mBinding.recyclerVw.setHasFixedSize(true);
                mBinding.recyclerVw.setAdapter(poAdapter);
                poAdapter.notifyDataSetChanged();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }
}