package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.FragmentAddressCreateBinding;

public class Fragment_AddressCreate extends Fragment {

    private VMShippingAddress mViewModel;
    private FragmentAddressCreateBinding mBinding;

    public Fragment_AddressCreate() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentAddressCreateBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMShippingAddress.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

}