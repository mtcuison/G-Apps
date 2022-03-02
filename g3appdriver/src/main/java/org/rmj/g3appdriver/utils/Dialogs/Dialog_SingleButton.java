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

public class Dialog_SingleButton {
    private static final String TAG = Dialog_DoubleButton.class.getSimpleName();

    private AlertDialog poDialogx;
    private final Context poContext;
    private String psBtnText = "";

    public Dialog_SingleButton(Context foContext) {
        this.poContext = foContext;
    }

    public void initDialog(String foTitlexx, String foMessage, OnButtonClick foCallBck){
        Log.e(TAG, "Initialized.");
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_single_button,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lblTitlex = view.findViewById(R.id.lbl_title);
        TextView lblMesgxx = view.findViewById(R.id.lbl_message);
        Button button = view.findViewById(R.id.button);

        lblTitlex.setText(Objects.requireNonNull(foTitlexx));
        lblMesgxx.setText(Objects.requireNonNull(foMessage));
        button.setText(psBtnText);

        button.setOnClickListener(v -> foCallBck.onClick(poDialogx));
    }


    /** Sets positive and negative button text display */
    public void setButtonText(String fsBtnText) {
        this.psBtnText = Objects.requireNonNull(fsBtnText);
    }

    public void show(){
        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialogx.show();
    }

    public interface OnButtonClick {
        void onClick(AlertDialog dialog);
    }

}
