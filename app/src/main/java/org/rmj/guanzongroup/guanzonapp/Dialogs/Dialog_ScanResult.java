package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_ScanResult {
    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private ImageView imgResult;

    private boolean success = false;
    private String result = "";
    private String resultMessage = "";
    private String resultPIN = "";

    public Dialog_ScanResult(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setResultPIN(String resultPIN) {
        this.resultPIN = resultPIN;
    }

    public void showDialog(){
        createDialog();
        dialog.show();
        Drawable drawable = mContext.getResources().getDrawable(getImageResult());
        if(drawable instanceof AnimatedVectorDrawableCompat){
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) drawable;
            imgResult.setImageDrawable(avd);
            avd.start();

            avd.clearAnimationCallbacks();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (drawable instanceof AnimatedVectorDrawable) {
                AnimatedVectorDrawable avd1 = (AnimatedVectorDrawable) drawable;
                imgResult.setImageDrawable(avd1);
                avd1.start();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    avd1.clearAnimationCallbacks();
                }
            }
        }
    }

    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_scan_qrcode_result, null, false);
        builder.setCancelable(true)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        MaterialButton btnOkay = view.findViewById(R.id.btn_dialog_scan_qrcode_okay);
        imgResult = view.findViewById(R.id.img_dialog_scan_qrcode_result);
        TextView lblResult = view.findViewById(R.id.lbl_dialog_scan_qrcode_result);
        TextView lblResultMessage = view.findViewById(R.id.lbl_dialog_scan_qrcode_message);
        TextView lblPIN = view.findViewById(R.id.lbl_dialog_scan_qrcode_PIN);
        LinearLayout PIN = view.findViewById(R.id.linear_pin);

        lblResult.setText(result);
        lblResultMessage.setText(resultMessage);
        lblPIN.setText(resultPIN);
        PIN.setVisibility(getPinVisibility());

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private int getImageResult(){
        if(success){
            result = "Success";
            return R.drawable.anim_ic_dialog_success;
        }
        result = "Failed";
        return R.drawable.anim_ic_dialog_failed;
    }

    private int getPinVisibility(){
        if(success){
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }
}
