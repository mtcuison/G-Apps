package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMRedeemables;

import java.util.List;

public class Fragment_Redeemables extends Fragment {

    private VMGCardSystem mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_redeemables, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.REDEMPTION);
        mViewModel.downloadRedeemables(new VMGCardSystem.GcardTransactionCallback() {
            @Override
            public void onLoad() {

            }

            @Override
            public void onSuccess(String fsMessage) {

            }

            @Override
            public void onFailed(String fsMessage) {

            }

            @Override
            public void onQrGenerate(Bitmap foBitmap) {

            }
        });
        mViewModel.GetRedeemablesList().observe(getViewLifecycleOwner(), new Observer<List<ERedeemablesInfo>>() {
            @Override
            public void onChanged(List<ERedeemablesInfo> eRedeemablesInfos) {
                Log.d("COUNT", String.valueOf(eRedeemablesInfos.size()));
            }
        });
        initRedeemables();
    }

    private void initViews(View v) {

    }

    private void initRedeemables() {

    }

}