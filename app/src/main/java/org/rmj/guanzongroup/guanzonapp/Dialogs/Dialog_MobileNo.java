package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_MobileNo {

    private final Context mContext;

    private final AlertDialog.Builder builder;
    private AlertDialog dialog;


    public Dialog_MobileNo(Context mContext) {
        this.mContext = mContext;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public interface OnMobileNoConfirmListener{
        void OnConfirm(AlertDialog dialog,String MobileNo);
    }
    public void initDialog(final OnMobileNoConfirmListener listener){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_mobile_no_entry, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        final EditText txtMobile = view.findViewById(R.id.txt_dialog_mobile_no);
        MaterialButton btnConfirm = view.findViewById(R.id.btn_dialog_confirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lsMobile = txtMobile.getText().toString();
                if(lsMobile.trim().isEmpty()){
                    Toast.makeText(mContext, "Please enter mobile no.", Toast.LENGTH_LONG).show();
                } else if(!lsMobile.substring(0, 2).equalsIgnoreCase("09")){
                    Toast.makeText(mContext, "Invalid mobile no.", Toast.LENGTH_LONG).show();
                } else if(lsMobile.length() != 11){
                    Toast.makeText(mContext, "Invalid mobile no.", Toast.LENGTH_LONG).show();
                } else {
                    listener.OnConfirm(dialog,txtMobile.getText().toString());
                }
            }
        });
    }

    public void show(){
        dialog.show();
    }
}
