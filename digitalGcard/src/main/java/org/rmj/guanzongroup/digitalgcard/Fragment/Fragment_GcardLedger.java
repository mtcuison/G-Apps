package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Adapter.Adapter_GCardLedger;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.List;

public class Fragment_GcardLedger extends Fragment {

    private VMGCardSystem mViewModel;

    private RecyclerView recyclerView;
    private TextView lblNoItem;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gcard_ledger, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        mViewModel.setmContext(GCardSystem.CoreFunctions.GCARD);
        initViews(view);
        mViewModel.GetGcardTransactions().observe(getViewLifecycleOwner(), ledgers -> {
            try{
                if(ledgers.size() > 0) {
                    Adapter_GCardLedger loAdapter = new Adapter_GCardLedger(ledgers);
                    LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
                    loManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(loManager);
                    recyclerView.setAdapter(loAdapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    lblNoItem.setVisibility(View.GONE);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    lblNoItem.setVisibility(View.VISIBLE);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        return view;
    }

    private void initViews(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
        lblNoItem = v.findViewById(R.id.lbl_no_ledger);
    }
}