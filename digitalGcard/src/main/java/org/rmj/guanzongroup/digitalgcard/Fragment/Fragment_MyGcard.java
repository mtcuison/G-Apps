package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_ManageGcard;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

public class Fragment_MyGcard extends Fragment {

    private VMGCardSystem mViewModel;
    private ConstraintLayout vAddGcard, vMyGcardx;
    private TextView txtManage;

    public static Fragment_MyGcard newInstance() {
        return new Fragment_MyGcard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_gcard, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.GCARD);
        mViewModel.hasActiveGcard().observe(requireActivity(), eGcardApp -> {
            try {
                if("".equalsIgnoreCase(eGcardApp.getCardNmbr())) {
                    vAddGcard.setVisibility(View.VISIBLE);
                    vMyGcardx.setVisibility(View.GONE);
                } else {
                    vAddGcard.setVisibility(View.GONE);
                    vMyGcardx.setVisibility(View.VISIBLE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        txtManage.setOnClickListener(v -> {
            Intent loIntent = new Intent(requireActivity(), Activity_ManageGcard.class);
            startActivity(loIntent);
        });

    }

    private void initViews(View v) {
        vAddGcard = v.findViewById(R.id.layout_add_gcard);
        vMyGcardx = v.findViewById(R.id.layout_my_gcard);
        txtManage = v.findViewById(R.id.lblManageGcard);
    }

}