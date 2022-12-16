package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.panalo.R;

public class DialogPanaloRewards implements iDialog {
    private static final String TAG = DialogPanaloRewards.class.getSimpleName();


    private final Context mContext;
    private final AlertDialog.Builder poBuilder;
    private AlertDialog poDialog;


    private MaterialButton btn_Close;
    private RecyclerView rv_RewardClaimed;
    private TextView txt_TermsAndCondition, txt_GPHeader, txt_GPHeader2;

    public DialogPanaloRewards(Context mContext) {
        this.mContext = mContext;
        this.poBuilder = new AlertDialog.Builder(mContext);

    }

    @Override
    public void initDialog(Object foVal, PanaloDialogClickListener listener) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_panalo_rewards, null, false);
        poBuilder.setView(view).setCancelable(false);
        poDialog = poBuilder.create();

        txt_GPHeader = view.findViewById(R.id.lbl_dialogTitle);
        txt_GPHeader2 = view.findViewById(R.id.lbl_dialogHeader2);

        rv_RewardClaimed = view.findViewById(R.id.rclyView_rewardsClaimed);
        txt_TermsAndCondition = view.findViewById(R.id.txt_Terms_and_Policy);

        btn_Close = view.findViewById(R.id.btn_dialogClose);

        btn_Close.setOnClickListener(v -> listener.OnClose(poDialog));
    }

    @Override
    public void show() {

    }
}
