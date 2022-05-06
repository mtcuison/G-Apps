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

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_AddGcard;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_ManageGcard;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.Objects;

public class Fragment_MyGcard extends Fragment {

    private VMGCardSystem mViewModel;
    private ConstraintLayout vAddGcard, vMyGcardx;
    private TextView txtManage, txtUserNm, txtCardNo, txtPoints;
    private MaterialButton btnAddCrd;

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

        initMyGcard();
    }

    private void initViews(View v) {
        vAddGcard = v.findViewById(R.id.layout_add_gcard);
        vMyGcardx = v.findViewById(R.id.layout_my_gcard);
        txtManage = v.findViewById(R.id.lblManageGcard);
        txtUserNm = v.findViewById(R.id.lbl_gcard_user);
        txtCardNo = v.findViewById(R.id.lbl_card_number);
        txtPoints = v.findViewById(R.id.lbl_gcard_points);
        btnAddCrd = v.findViewById(R.id.btnAddGcard);
    }

    private void initMyGcard() {
        mViewModel.getActiveGcard().observe(getViewLifecycleOwner(), eGcardApp -> {
            try {
                if(eGcardApp == null) {
                    vAddGcard.setVisibility(View.VISIBLE);
                    vMyGcardx.setVisibility(View.GONE);
                    btnAddCrd.setOnClickListener(v -> {
                        Intent loIntent = new Intent(requireActivity(), Activity_AddGcard.class);
                        startActivity(loIntent);
                    });
                } else {
                    vAddGcard.setVisibility(View.GONE);
                    vMyGcardx.setVisibility(View.VISIBLE);
                    displayGcardInfo(eGcardApp);
                    txtManage.setOnClickListener(v -> {
                        Intent loIntent = new Intent(requireActivity(), Activity_ManageGcard.class);
                        startActivity(loIntent);
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void displayGcardInfo(EGcardApp foGcardxx) {
        txtUserNm.setText(Objects.requireNonNull(foGcardxx.getNmOnCard()));
        txtCardNo.setText(Objects.requireNonNull(foGcardxx.getCardNmbr()));
        txtPoints.setText(Objects.requireNonNull(foGcardxx.getAvlPoint()));
    }

}