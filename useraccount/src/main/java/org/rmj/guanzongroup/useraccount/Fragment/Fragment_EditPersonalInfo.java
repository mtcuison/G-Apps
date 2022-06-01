package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.etc.InputFieldController;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;
import org.rmj.guanzongroup.useraccount.databinding.FragmentEditPersonalInfoBinding;

import java.util.ArrayList;

public class Fragment_EditPersonalInfo extends Fragment {

    private FragmentEditPersonalInfoBinding mBinding;
    private VMAccountDetails mViewModel;

    public Fragment_EditPersonalInfo() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding =  FragmentEditPersonalInfoBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountDetails.class);
        initSelector();
        setDefaultValues();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
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

        mBinding.txtGender.setOnItemClickListener((adapterView, view, i, l) -> {});
    }

    private void setDefaultValues() {
        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            try {
                mBinding.txtGender.setText(mViewModel.getGenderList()
                        .get(Integer.parseInt(eClientInfo.getGenderCd())));
                mBinding.txtCivilS.setText(mViewModel.getCivilStatusList()
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}