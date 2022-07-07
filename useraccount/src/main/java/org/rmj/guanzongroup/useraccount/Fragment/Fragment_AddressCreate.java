package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.InputFieldController;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ShippingAddress;
import org.rmj.guanzongroup.useraccount.Model.ShippingInfoModel;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.FragmentAddressCreateBinding;

import java.util.ArrayList;

public class Fragment_AddressCreate extends Fragment {

    private VMShippingAddress mViewModel;
    private FragmentAddressCreateBinding mBinding;
    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoading;
    private ShippingInfoModel infoModel;

    public Fragment_AddressCreate() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMShippingAddress.class);
        mBinding = FragmentAddressCreateBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        poDialogx = new Dialog_SingleButton(requireActivity());
        poLoading = new Dialog_Loading(requireActivity());
        infoModel = new ShippingInfoModel(new AccountInfo(requireActivity()).getClientID());
        initInputSelectors();
        mBinding.btnAddShp.setOnClickListener(v -> addShipping());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void initInputSelectors() {
//        mBinding.spnSrcCde.setAdapter(new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_dropdown_item, AppConstants.REQUEST_CODE));
        mViewModel.getTownCityList().observe(requireActivity(), townObj ->{
            try {
                ArrayList<String> lsTownCts = mViewModel.getTownCityForInput(townObj);
                mBinding.txtTownCt.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                requireActivity(), lsTownCts
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mBinding.txtTownCt.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getTownCityList().observe(requireActivity(), townObjs -> {
                try {
                    for (int x = 0; x < townObjs.size(); x++) {
                        String lsTownCt = townObjs.get(x).sTownNm + ", " + townObjs.get(x).sProvNm;
                        if (mBinding.txtTownCt.getText().toString().equalsIgnoreCase(lsTownCt)) {
                            infoModel.setTownCty(townObjs.get(x).sTownID);
                            mViewModel.getBarangayList(townObjs.get(x).sTownID)
                                    .observe(requireActivity(), brgys -> {
                                mBinding.txtBrgyxx.setAdapter(
                                        InputFieldController.getAutoCompleteData(
                                                requireActivity(),
                                                mViewModel.getBarangayForInput(brgys)
                                        )
                                );

                                mBinding.txtBrgyxx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView,
                                                            View view, int i, long l) {
                                        for(int x = 0; x < brgys.size(); x++){
                                            if(brgys.get(x).getBrgyName().
                                                    equalsIgnoreCase(mBinding.txtBrgyxx.getText()
                                                            .toString().trim())){
                                                infoModel.setBarngay(brgys.get(x).getBrgyIDxx());
                                                break;
                                            }
                                        }
                                    }
                                });
                            });
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

    }

    private void addShipping() {
        infoModel.setMobileN(mBinding.txtMobile.getText().toString().trim());
        infoModel.setHouseNo(mBinding.txtHouseN.getText().toString().trim());
        infoModel.setAddress(mBinding.txtStreet.getText().toString().trim());
        if(infoModel.isAddressComplete()) {
            mViewModel.addShippingAddress(infoModel, new VMShippingAddress.OnTransactionCallBack() {
                @Override
                public void onLoading() {
                    poLoading.initDialog("Shipping Address", "Adding shipping address. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Shipping Address", fsMessage, d -> {
                        d.dismiss();
                        Activity_ShippingAddress.getInstance().setFragment(0);
                    });
                    poDialogx.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Shipping Address", fsMessage, d -> d.dismiss());
                    poDialogx.show();
                }
            });
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Shipping Address", infoModel.getErrorMessage(), d -> d.dismiss());
            poDialogx.show();
        }
    }

}