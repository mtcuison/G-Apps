package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.List;

public class Fragment_GcardLedger extends Fragment {

    private VMGCardSystem mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gcard_ledger, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.GCARD);
        initViews(view);
        mViewModel.GetGcardTransactions().observe(getViewLifecycleOwner(), new Observer<List<EGCardTransactionLedger>>() {
            @Override
            public void onChanged(List<EGCardTransactionLedger> ledgers) {
                try{

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    private void initViews(View v) {

    }

}