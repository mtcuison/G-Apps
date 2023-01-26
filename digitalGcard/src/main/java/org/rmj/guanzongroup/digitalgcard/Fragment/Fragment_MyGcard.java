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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_UserInfo;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_AddGcard;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_ManageGcard;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.Objects;

public class Fragment_MyGcard extends Fragment {

    private VMGCardSystem mViewModel;
    private View view;
    private ImageView imgGcard;
    private ConstraintLayout vAddGcard, vMyGcardx;
    private TextView txtManage, txtUserNm, txtCardNo, txtPoints;
    private MaterialButton btnAddCrd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        view = inflater.inflate(R.layout.fragment_my_gcard, container, false);
        initViews();
        mViewModel.setmContext(GCardSystem.CoreFunctions.GCARD);
        initMyGcard();

        return view;
    }

    private void initViews() {
        vAddGcard = view.findViewById(R.id.layout_add_gcard);
        vMyGcardx = view.findViewById(R.id.layout_my_gcard);
        imgGcard = view.findViewById(R.id.imageView3);
        txtManage = view.findViewById(R.id.lblManageGcard);
        txtUserNm = view.findViewById(R.id.lbl_gcard_user);
        txtCardNo = view.findViewById(R.id.lbl_card_number);
        txtPoints = view.findViewById(R.id.lbl_gcard_points);
        btnAddCrd = view.findViewById(R.id.btnAddGcard);
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

                    view.findViewById(R.id.cvGcard).setOnClickListener(v -> {
                        mViewModel.ViewGCardQrCode(bitmap -> {
                            try{
                                final Dialog_UserInfo loDialog = new Dialog_UserInfo(requireActivity());
                                loDialog.initDialog(eGcardApp, bitmap);
                                loDialog.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
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