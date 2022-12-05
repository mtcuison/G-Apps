package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.panalo.R;

public class DialogPanaloClaim implements iDialog {
    private static final String TAG = DialogPanaloClaim.class.getSimpleName();

    //TODO: This dialog will be use for claiming the reward

    private final Context mContext;

    private final AlertDialog.Builder poBuilder;
    private AlertDialog poDialog;

    private TextView txt_MnthRebate, txt_AmountRebate, txt_Validitydate, txt_GPHeader, txt_GPHeader2;
    private MaterialButton btn_Claim;


    public DialogPanaloClaim(Context mContext) {
        this.mContext = mContext;
        this.poBuilder = new AlertDialog.Builder(mContext);
    }


    @Override
    public void initDialog(Object foVal) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_panalo_claim, null, false);
        poBuilder.setView(view).setCancelable(false);
        poDialog = poBuilder.create();


        txt_GPHeader = view.findViewById(R.id.lbl_dialogTitle);
        txt_GPHeader2 = view.findViewById(R.id.lbl_dialogHeader2);

        txt_MnthRebate = view.findViewById(R.id.lbl_MonthlyRebates);
        txt_AmountRebate = view.findViewById(R.id.lbl_rebatesAmount);
        txt_Validitydate = view.findViewById(R.id.lbl_validityDates);

        btn_Claim = view.findViewById(R.id.btn_dialogClaim);

    }

    @Override
    public void show() {
        poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialog.show();

    }
}
