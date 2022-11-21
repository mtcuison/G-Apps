package org.rmj.guanzongroup.marketplace.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_TextInput;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.FragmentPaymentInfoBinding;

import java.util.Locale;

public class Fragment_PaymentInfo extends Fragment {

    private VMPayOrder mViewModel;
    private FragmentPaymentInfoBinding binding;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

    private String psPayment;

    public Fragment_PaymentInfo() { }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPayOrder.class);
        binding = FragmentPaymentInfoBinding.inflate(inflater, container, false);
        poDialogx = new Dialog_SingleButton(requireActivity());
        displayPaymentInfo();
        binding.btnConfrm.setOnClickListener(v -> {
            if(psPayment.equalsIgnoreCase("CashOnDelivery")) {
                Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                intent.putExtra("args", "purchase");
                requireActivity().sendBroadcast(intent);
                requireActivity().finish();
            } else if(isMethodSelected()) {
                payOrder();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void displayPaymentInfo() {
        mViewModel.getPaymentMethod().observe(getViewLifecycleOwner(), payMeth -> {
            binding.txtPayTyp.setText(payMeth.toString());
            psPayment = payMeth.toString();
            if(!psPayment.equalsIgnoreCase(PaymentMethod.CashOnDelivery.toString())){
                double lnOrderAmnt = requireActivity().getIntent().getDoubleExtra("nSubTotal", 0.0);
                double lnShippFeex = requireActivity().getIntent().getDoubleExtra("nShipFeex", 0.0);
                double lnTotal = lnOrderAmnt + lnShippFeex;
                binding.lblCodAmount.setText(CashFormatter.parse(String.valueOf(lnTotal)));
                binding.lblPayAmount.setText("To complete your purchase please deposit ₱" + lnTotal + " to " + payMeth + " account shown below.");
                binding.cardviewPaymentInfo.setVisibility(View.VISIBLE);
                binding.linearCod.setVisibility(View.GONE);
                mViewModel.CheckPaymentMethods(new OnTransactionsCallback() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(requireActivity());
                    poLoading.initDialog("Pay Order", "Retrieving payment options. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    try {
                        JSONObject loJson = new JSONObject(fsMessage);
                        JSONArray laJson = loJson.getJSONArray("detail");
                        for(int x = 0; x < laJson.length(); x++){
                            JSONObject loDetail = laJson.getJSONObject(x);
                            String lsBankCde = loDetail.getString("sBankCode");
                            if(lsBankCde.toLowerCase(Locale.ROOT).equalsIgnoreCase(psPayment)) {
                                binding.txtAccNme.setText(loDetail.getString("sActNamex"));
                                binding.txtMobile.setText(loDetail.getString("sActNumbr"));
                                break;
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                    poDialogx.show();
                }
            });
            } else if(psPayment.equalsIgnoreCase(PaymentMethod.CashOnDelivery.toString())){
                binding.lblSendThru.setVisibility(View.GONE);
                mViewModel.payOrder(mViewModel.getTransactionNumber(), mViewModel.getPaymentMethod().getValue(),
                    "", new OnTransactionsCallback() {
                        @Override
                        public void onLoading() {
                            poLoading = new Dialog_Loading(requireActivity());
                            poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                            poLoading.show();
                        }

                        @Override
                        public void onSuccess(String fsMessage) {
                            poLoading.dismiss();
                            binding.cardviewPaymentInfo.setVisibility(View.GONE);
                            binding.linearCod.setVisibility(View.VISIBLE);
                            binding.btnConfrm.setText("Continue Shopping");
                            if(requireActivity().getIntent().hasExtra("nSubTotal")){
                                double lnOrderAmnt = requireActivity().getIntent().getDoubleExtra("nSubTotal", 0.0);
                                binding.lblOrderAmount.setText(CashFormatter.parse(String.valueOf(lnOrderAmnt)));
                            }

                            if(requireActivity().getIntent().hasExtra("nShipFeex")){
                                double lnOrderAmnt = requireActivity().getIntent().getDoubleExtra("nSubTotal", 0.0);
                                double lnShippFeex = requireActivity().getIntent().getDoubleExtra("nShipFeex", 0.0);
                                double lnTotal = lnOrderAmnt + lnShippFeex;
                                binding.lblCodAmount.setText(CashFormatter.parse(String.valueOf(lnTotal)));
                            }
                        }

                        @Override
                        public void onFailed(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                            poDialogx.show();
                        }
                    });
            }
        });
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
                                    poDialogx.initDialog("Pay Order", fsMessage, () -> {
                                        poDialogx.dismiss();
                                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                                        intent.putExtra("args", "purchase");
                                        requireActivity().sendBroadcast(intent);
                                        requireActivity().finish();
                                    });
                                    poDialogx.show();
                                }

                                @Override
                                public void onFailed(String fsMessage) {
                                    poLoading.dismiss();
                                    poDialogx.setButtonText("Okay");
                                    poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                                    poDialogx.show();
                                }
                            });
                } else {
                    dialog.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order",
                            "Please enter payment reference number.", () -> poDialogx.dismiss());
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
                    "Please select payment method for your order.", () -> poDialogx.dismiss());
            poDialogx.show();
            return false;
        }
        return true;
    }

}