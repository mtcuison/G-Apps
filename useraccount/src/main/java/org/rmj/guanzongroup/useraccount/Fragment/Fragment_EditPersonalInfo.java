package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.etc.InputFieldController;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;
import org.rmj.guanzongroup.useraccount.databinding.FragmentEditPersonalInfoBinding;

import java.util.ArrayList;

public class Fragment_EditPersonalInfo extends Fragment {

    private FragmentEditPersonalInfoBinding mBinding;
    private VMAccountDetails mViewModel;
    private Dialog_SingleButton poDialog;
    private Dialog_Loading poLoading;
    private EClientInfo poClientx;
    private String psErrMesg = "";

    public Fragment_EditPersonalInfo() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding =  FragmentEditPersonalInfoBinding.inflate(inflater, container, false);
        poClientx = new EClientInfo();
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountDetails.class);
        poDialog = new Dialog_SingleButton(requireActivity());
        initSelector();
        setDefaultValues();

        mBinding.btnUpdate.setOnClickListener(v -> updatePersonalInfo());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
        poClientx = null;
    }

    private void initSelector() {
        mBinding.txtGender.setAdapter(
                InputFieldController.getAutoCompleteData(
                        requireActivity(), mViewModel.getGenderList()
                ));

        mBinding.txtCivilS.setAdapter(
                InputFieldController.getAutoCompleteData(
                        requireActivity(), mViewModel.getCivilStatusList()
                ));

        mViewModel.getCountryList().observe(getViewLifecycleOwner(), countries -> {
            try {
                ArrayList<String> lsCountry = mViewModel.getCountryForInput(countries);
                mBinding.txtCtizen.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                requireActivity(),
                                lsCountry
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mBinding.txtCtizen.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getCountryList().observe(requireActivity(), countries -> {
                try {
                    for(int x = 0; x < countries.size(); x++) {
                        if(countries.get(x).getNational() != null && !countries.get(x).getNational().isEmpty()) {
                            if(countries.get(x).getNational().equalsIgnoreCase(mBinding.txtCtizen.getText().toString().trim())) {
                                poClientx.setCitizenx(countries.get(x).getCntryCde());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        mBinding.txtGender.setOnItemClickListener((adapterView, view, i, l)
                -> poClientx.setGenderCd(String.valueOf(i)));
        mBinding.txtCivilS.setOnItemClickListener((adapterView, view, i, l)
                -> poClientx.setCvilStat(String.valueOf(i)));
    }

    private void setDefaultValues() {
        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            try {
                mBinding.txtGender.setListSelection(Integer.parseInt(eClientInfo.getGenderCd()));
                mBinding.txtGender.setHint(mViewModel.getGenderList()
                        .get(Integer.parseInt(eClientInfo.getGenderCd())));
                mBinding.txtCivilS.setListSelection(Integer.parseInt(eClientInfo.getCvilStat()));
                mBinding.txtCivilS.setHint(mViewModel.getCivilStatusList()
                        .get(Integer.parseInt(eClientInfo.getCvilStat())));
                mViewModel.getCountryList().observe(getViewLifecycleOwner(), eCountryInfos -> {
                    try {
                         for(int x = 0; x < eCountryInfos.size(); x++) {
                             if(eClientInfo.getCitizenx().equalsIgnoreCase(eCountryInfos.get(x).getCntryCde())) {
                                 mBinding.txtCtizen.setText(eCountryInfos.get(x).getNational());
                                 break;
                             } else {
                                 continue;
                             }
                         }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                mBinding.txtTaxIdN.setText(eClientInfo.getTaxIDNox());

                poClientx.setGenderCd(eClientInfo.getGenderCd());
                poClientx.setCvilStat(eClientInfo.getCvilStat());
                poClientx.setCitizenx(eClientInfo.getCitizenx());
                poClientx.setTaxIDNox(eClientInfo.getTaxIDNox());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void updatePersonalInfo() {
        poClientx.setTaxIDNox(mBinding.txtTaxIdN.getText().toString().trim());
        if(isFormClear()) {
            mViewModel.updateAccountInfo(poClientx, new VMAccountDetails.OnTransactionCallBack() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(requireActivity());
                    poLoading.initDialog("Account Details",
                            "Updating personal information. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialog.setButtonText("Okay");
                    poDialog.initDialog("Account Details", fsMessage, () -> {
                        poDialog.dismiss();
                        requireActivity().finish();
                    });
                    poDialog.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialog.setButtonText("Okay");
                    poDialog.initDialog("Account Details", fsMessage, () -> poDialog.dismiss());
                    poDialog.show();
                }
            });
        } else {
            poDialog.setButtonText("Okay");
            poDialog.initDialog("Account Details", psErrMesg, () -> poDialog.dismiss());
            poDialog.show();
        }
    }

    private boolean isFormClear() {
        if(poClientx.getGenderCd().isEmpty()) {
            psErrMesg = "Please select gender.";
            return false;
        } else if (poClientx.getCvilStat().isEmpty()) {
            psErrMesg = "Please select civil status.";
            return false;
        } else if (poClientx.getCitizenx().isEmpty()) {
            psErrMesg = "Please enter citizenship.";
            return false;
        } else {
            return true;
        }
    }


}