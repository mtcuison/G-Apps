package org.rmj.guanzongroup.marketplace.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_TextInput;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.FragmentPaymentInfoBinding;

public class Fragment_PaymentInfo extends Fragment {

    private VMPayOrder mViewModel;
    private FragmentPaymentInfoBinding binding;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

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
        poDialogx = new Dialog_SingleButton(requireActivity());
        displayPaymentInfo();
        binding.btnConfrm.setOnClickListener(v -> {
            if(isMethodSelected()) { payOrder(); }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void displayPaymentInfo() {
        mViewModel.getPaymentMethod().observe(getViewLifecycleOwner(), payMeth -> binding.txtPayTyp.setText(payMeth.toString()));
        binding.txtAccNme.setText("Guanzon Group of Companies");
        binding.txtMobile.setText("09123456789");
    }

    private void payOrder() {
        final Dialog_TextInput loDialog = new Dialog_TextInput(requireActivity());
        loDialog.initDialog("Reference Number", new Dialog_TextInput.OnDialogConfirmation() {
            @Override
            public void onConfirm(String fsInputx, AlertDialog dialog) {
                if(!fsInputx.isEmpty()) {
                    String lsRefNoxx = fsInputx;
                    dialog.dismiss();
                    mViewModel.payOrder(mViewModel.getTransactionNumber(),
                            mViewModel.getPaymentMethod().getValue(),
                            lsRefNoxx, new OnTransactionsCallback() {
                                @Override
                                public void onLoading() {
                                    poLoading = new Dialog_Loading(requireActivity());
                                    poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                                    poLoading.show();
                                }

                                @Override
                                public void onSuccess(String fsMessage) {
                                    poLoading.dismiss();
                                    poDialogx.setButtonText("Okay");
                                    poDialogx.initDialog("Pay Order", fsMessage, dialog1 -> {
                                        dialog1.dismiss();
                                        requireActivity().finish();
                                    });
                                    poDialogx.show();
                                }

                                @Override
                                public void onFailed(String fsMessage) {
                                    poLoading.dismiss();
                                    poDialogx.setButtonText("Okay");
                                    poDialogx.initDialog("Pay Order", fsMessage, dialog1 -> dialog1.dismiss());
                                    poDialogx.show();
                                }
                            });
                } else {
                    dialog.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order",
                            "Please enter payment reference number.", dialog1 -> {
                                dialog1.dismiss();
                            });
                    poDialogx.show();
                }
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        loDialog.show();
    }

    private boolean isMethodSelected() {
        if(mViewModel.getPaymentMethod().getValue() == null) {
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