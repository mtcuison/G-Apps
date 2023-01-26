/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.CreditEvaluator
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.guanzongroup.digitalgcard.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.guanzongroup.digitalgcard.R;


public class Dialog_GCardCodex {
    private static final String TAG = Dialog_GCardCodex.class.getSimpleName();

    private AlertDialog poDialogx;
    private final Context context;
    private TextInputLayout tilAddApp;
    private ImageView imgQRCode;
    private TextView lblGCardNo;
    private MaterialButton btnClose;

    public Dialog_GCardCodex(Context context) {
        this.context = context;
    }

    public void initDialog(OnDialogButtonClickListener listener){
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_gcard_codex, null, false);
        loBuilder.setCancelable(false)
                .setView(view);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        imgQRCode = view.findViewById(R.id.img_dialog_gcard_codex_QRCode);
        lblGCardNo = view.findViewById(R.id.lbl_dialog_gcardCodex);

        btnClose = view.findViewById(R.id.btn_dialog_gcard_codex_close);

        btnClose.setOnClickListener(view12 -> listener.OnCancel(poDialogx));
    }

    public void show(){
        if(!poDialogx.isShowing()){
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
            poDialogx.show();
        }
    }

    public interface OnDialogButtonClickListener{
        void OnDownloadClick(Dialog Dialog, String args);
        void OnCancel(Dialog Dialog);
    }
}
