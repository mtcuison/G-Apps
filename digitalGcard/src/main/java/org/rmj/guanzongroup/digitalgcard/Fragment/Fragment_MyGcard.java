package org.rmj.guanzongroup.digitalgcard.Fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_UserInfo;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_AddGcard;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_ManageGcard;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.Objects;

public class Fragment_MyGcard extends Fragment{

    private VMGCardSystem mViewModel;
    private View view;
    private ImageView imgGcard;
    private ConstraintLayout vAddGcard, vMyGcardx;
    private TextView txtManage, txtUserNm, txtCardNo, txtPoints;
    private MaterialButton btnAddCrd;
    private ImageButton btn_refresh;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        view = inflater.inflate(R.layout.fragment_my_gcard, container, false);
        initViews();

        poDialog = new Dialog_SingleButton(requireActivity());
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
        btn_refresh = view.findViewById(R.id.btn_refresh);
    }
    private void initGCardInfo(){
        mViewModel.downloadGcardNumbers(new VMGCardSystem.GcardTransactionCallback() {
            @Override
            public void onLoad() {
                poLoading = new Dialog_Loading(requireActivity());
                poLoading.initDialog("GCard Information", "Please wait for a while.");
                poLoading.show();
            }
            @Override
            public void onSuccess(String fsMessage) {
                poLoading.dismiss();
                initMyGcard();
            }
            @Override
            public void onFailed(String fsMessage) {
                poLoading.dismiss();

                poDialog.setButtonText("Dismiss");
                poDialog.initDialog("GCard Information Error", fsMessage, () -> poDialog.dismiss());
                poDialog.show();
            }
            @Override
            public void onQrGenerate(Bitmap foBitmap) {

            }
        });
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
        if(foGcardxx.getNmOnCard() == null || foGcardxx.getNmOnCard().equalsIgnoreCase("null")) {
            txtUserNm.setText("");
        } else {
            txtUserNm.setText(Objects.requireNonNull(foGcardxx.getNmOnCard()));
        }

        txtCardNo.setText(Objects.requireNonNull(foGcardxx.getCardNmbr()));
        txtPoints.setText(Objects.requireNonNull(foGcardxx.getAvlPoint()));

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGCardInfo();
            }
        });
    }
}