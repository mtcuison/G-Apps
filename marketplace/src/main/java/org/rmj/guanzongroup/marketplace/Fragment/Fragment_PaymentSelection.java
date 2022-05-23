package org.rmj.guanzongroup.marketplace.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Activity.Activity_PayOrder;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.FragmentPaymentSelectBinding;

public class Fragment_PaymentSelection extends Fragment {

    private VMPayOrder mViewModel;
    private FragmentPaymentSelectBinding binding;
    private Dialog_SingleButton poDialogx;

    public Fragment_PaymentSelection() { }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaymentSelectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPayOrder.class);
        poDialogx = new Dialog_SingleButton(requireActivity());
        selectPayment();
        binding.btnSelect.setOnClickListener(v -> {
            if(isMethodSelected()) {
                Activity_PayOrder.getInstance().moveToPageNumber(1);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void selectPayment() {
        binding.crdGcashx.setOnClickListener(v -> {
            binding.rdGcashxx.setChecked(true);
            binding.rdPayMaya.setChecked(false);
            binding.rdCashOnD.setChecked(false);
            mViewModel.setPaymentMethod(PaymentMethod.GCash);
        });
        binding.crdPayMya.setOnClickListener(v -> {
            binding.rdGcashxx.setChecked(false);
            binding.rdPayMaya.setChecked(true);
            binding.rdCashOnD.setChecked(false);
            mViewModel.setPaymentMethod(PaymentMethod.PayMaya);
        });
        binding.crdCashOD.setOnClickListener(v -> {
            binding.rdGcashxx.setChecked(false);
            binding.rdPayMaya.setChecked(false);
            binding.rdCashOnD.setChecked(true);
            mViewModel.setPaymentMethod(PaymentMethod.CashOnDelivery);
        });
    }

    private boolean isMethodSelected() {
        if(mViewModel.getPaymentMethod() == null) {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Pay Order",
                    "Please select payment method for your order.", dialog -> {
                        dialog.dismiss();
                    });
            poDialogx.show();
            return false;
        }
        return true;
    }

}