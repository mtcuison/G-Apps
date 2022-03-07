package org.rmj.g3appdriver.utils.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.rmj.g3appdriver.R;

import java.util.Objects;

public class Dialog_DoubleButton {
    private static final String TAG = Dialog_DoubleButton.class.getSimpleName();

    private AlertDialog poDialogx;
    private final Context poContext;
    private String psPositiv = "";
    private String psNegativ = "";

    public Dialog_DoubleButton(Context foContext) {
        this.poContext = foContext;
    }

    public void initDialog(String foTitlexx, String foMessage, OnDialogConfirmation foCallBck){
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_double_button,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lblTitlex = view.findViewById(R.id.lbl_title);
        TextView lblMesgxx = view.findViewById(R.id.lbl_message);
        Button btnPositive = view.findViewById(R.id.btn_positive);
        Button btnNegative = view.findViewById(R.id.btn_negative);

        lblTitlex.setText(Objects.requireNonNull(foTitlexx));
        lblMesgxx.setText(Objects.requireNonNull(foMessage));
        btnPositive.setText(psPositiv);
        btnNegative.setText(psNegativ);

        btnPositive.setOnClickListener(v -> foCallBck.onConfirm(poDialogx));
        btnNegative.setOnClickListener(v -> foCallBck.onCancel(poDialogx));
    }


    /** Sets positive and negative button text display */
    public void setButtonText(String fsPositiv, String fsNegativ) {
        this.psPositiv = Objects.requireNonNull(fsPositiv);
        this.psNegativ = Objects.requireNonNull(fsNegativ);
    }

    public void show(){
        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialogx.show();
    }

    public interface OnDialogConfirmation {
        void onConfirm(AlertDialog dialog);
        void onCancel(AlertDialog dialog);
    }

}
