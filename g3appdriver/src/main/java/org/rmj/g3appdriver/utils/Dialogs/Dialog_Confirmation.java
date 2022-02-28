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

import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.R;

import java.util.Objects;

public class Dialog_Confirmation {
    private static final String TAG = Dialog_Confirmation.class.getSimpleName();

    private AlertDialog poDialogx;
    private final Context poContext;

    public Dialog_Confirmation(Context foContext) {
        this.poContext = foContext;
    }

    public void iniDialog(String foTitlexx, String foMessage, OnDialogConfirmation foCallBck){
        Log.e(TAG, "Initialized.");
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_confirmation ,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lblTitlex = view.findViewById(R.id.lbl_title);
        TextView lblMesgxx = view.findViewById(R.id.lbl_message);
        Button btnConfirm = view.findViewById(R.id.btn_confirm);
        Button btnCancel = view.findViewById(R.id.btn_cancel);

        lblTitlex.setText(Objects.requireNonNull(foTitlexx));
        lblMesgxx.setText(Objects.requireNonNull(foMessage));

        btnConfirm.setOnClickListener(v -> foCallBck.onConfirm(poDialogx));
        btnCancel.setOnClickListener(v -> foCallBck.onCancel(poDialogx));
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
