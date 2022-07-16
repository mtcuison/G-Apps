package org.rmj.guanzongroup.marketplace.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Activity.Activity_PayOrder;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.FragmentPaymentSelectBinding;

public class Fragment_PaymentSelection extends Fragment {

    private VMPayOrder mViewModel;
    private FragmentPaymentSelectBinding binding;
    private Dialog_SingleButton poDialogx;

    private PaymentMethod poPayMeth;

    public Fragment_PaymentSelection() { }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPayOrder.class);
        binding = FragmentPaymentSelectBinding.inflate(inflater, container, false);
        poDialogx = new Dialog_SingleButton(requireActivity());

        binding.btnSelect.setOnClickListener(v -> {
            if(isMethodSelected()) {
                mViewModel.setPaymentMethod(poPayMeth);
                Activity_PayOrder.getInstance().moveToPageNumber(1);
            }
        });
        binding.crdGcashx.setOnClickListener(v -> {
            binding.rdGcashxx.setChecked(true);
        });
        binding.crdPayMya.setOnClickListener(v -> {
            binding.rdPayMaya.setChecked(true);
        });
        binding.crdCashOD.setOnClickListener(v -> {
            binding.rdCashOnD.setChecked(true);
        });
        binding.rdGcashxx.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(true);
                binding.rdPayMaya.setChecked(false);
                binding.rdCashOnD.setChecked(false);
                poPayMeth = PaymentMethod.GCash;
            }
        });
        binding.rdPayMaya.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(false);
                binding.rdPayMaya.setChecked(true);
                binding.rdCashOnD.setChecked(false);
                poPayMeth = PaymentMethod.PayMaya;
            }
        });
        binding.rdCashOnD.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(false);
                binding.rdPayMaya.setChecked(false);
                binding.rdCashOnD.setChecked(true);
                poPayMeth = PaymentMethod.CashOnDelivery;
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean isMethodSelected() {
        if(poPayMeth == null) {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Pay Order",
                    "Please select payment method for your order.", () -> poDialogx.dismiss());
            poDialogx.show();
            return false;
        }
        return true;
    }

}