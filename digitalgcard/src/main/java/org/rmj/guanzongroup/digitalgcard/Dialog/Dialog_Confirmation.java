package org.rmj.guanzongroup.digitalgcard.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.rmj.guanzongroup.digitalgcard.R;

public class Dialog_Confirmation {

    private AlertDialog poDialogx;
    private final Context context;

    public Dialog_Confirmation(Context context) {
        this.context = context;
    }

    public void initDialog(OnClientSelectListener listener){
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null, false);
        loBuilder.setCancelable(false)
                .setView(view);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        Button btnConfrm = view.findViewById(R.id.btn_confirm);


        btnConfrm.setOnClickListener(v -> {
            poDialogx.dismiss();
            Toast.makeText(context, "Confirmed", Toast.LENGTH_SHORT).show();
        });

    }

    public void show(){
        if(!poDialogx.isShowing()){
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
            poDialogx.show();
        }
    }

    public interface OnClientSelectListener{
        void OnConfirm(AlertDialog dialog);
        void OnCancel(AlertDialog dialog);
    }

}
