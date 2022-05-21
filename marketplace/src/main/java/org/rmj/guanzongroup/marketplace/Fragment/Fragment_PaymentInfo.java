package org.rmj.guanzongroup.marketplace.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.FragmentPaymentInfoBinding;

public class Fragment_PaymentInfo extends Fragment {

    private VMPayOrder mViewModel;
    private FragmentPaymentInfoBinding binding;

    public Fragment_PaymentInfo() { }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaymentInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPayOrder.class);

        binding.btnConfrm.setOnClickListener(v -> {});
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}