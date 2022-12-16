package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.panalo.R;

public class DialogPanaloNoReward implements iDialog {
    private static final String TAG = DialogPanaloNoReward.class.getSimpleName();

    private final Context mContext;

    private ImageView img_NoRewardLogo;
    private MaterialButton btn_Close;
    private TextView txt_NoRewardYet, txt_GPHeader;

    private final AlertDialog.Builder poBuilder;
    private AlertDialog poDialog;

    public DialogPanaloNoReward(Context mContext) {
        this.mContext = mContext;
        this.poBuilder = new AlertDialog.Builder(mContext);
    }

    @Override
    public void initDialog(Object foVal, PanaloDialogClickListener listener) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_panalo_no_reward, null, false);
        poBuilder.setView(view).setCancelable(false);
        poDialog = poBuilder.create();

        txt_GPHeader = view.findViewById(R.id.lbl_dialogTitle);
        txt_NoRewardYet = view.findViewById(R.id.lbl_NoRewardYet);

        img_NoRewardLogo = view.findViewById(R.id.img_no_reward_logo);

        btn_Close = view.findViewById(R.id.btn_dialogClose);

        btn_Close.setOnClickListener(v -> listener.OnClose(poDialog));
    }

    @Override
    public void show() {
        poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialog.show();
    }
}
