package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Adapter.Adapter_Redeemables;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMRedeemables;

import java.util.List;

public class Fragment_Redeemables extends Fragment {

    private VMGCardSystem mViewModel;
    private RecyclerView rvRedeemables;
    private TextView lbl_no_redeemables;
    private Adapter_Redeemables adapter;
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
                if(eRedeemablesInfos.size()>0){
                    lbl_no_redeemables.setVisibility(View.GONE);
                }else{
                    lbl_no_redeemables.setVisibility(View.VISIBLE);
                }
                adapter = new Adapter_Redeemables(requireActivity(),eRedeemablesInfos, new Adapter_Redeemables.OnItemClick() {
                    @Override
                    public void onClick(String sPromoCode) {

                    }

                    @Override
                    public void addToCart() {

                    }
                });
                rvRedeemables.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        initRedeemables();
    }

    private void initViews(View v) {
        rvRedeemables = v.findViewById(R.id.rvRedeemables);
        lbl_no_redeemables = v.findViewById(R.id.lbl_no_redeemables);
        rvRedeemables.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.VERTICAL, false));
        rvRedeemables.setHasFixedSize(true);
    }

    private void initRedeemables() {

    }

}