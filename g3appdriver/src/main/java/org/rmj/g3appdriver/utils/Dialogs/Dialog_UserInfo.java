package org.rmj.g3appdriver.utils.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.rmj.g3appdriver.R;

import java.util.Objects;

public class Dialog_UserInfo {

    private AlertDialog poDialogx;
    private final Context poContext;
    private static boolean isShown = false;

    public Dialog_UserInfo(Context foContext) {
        this.poContext = foContext;
    }

    public void initDialog(){
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_user_info,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lblClientN = view.findViewById(R.id.lbl_client_name);
        TextView lblGcardNo = view.findViewById(R.id.lbl_gcard_no);
        TextView lblGcardPt = view.findViewById(R.id.lbl_points);
        ImageView poQrImage= view.findViewById(R.id.img_qrCode);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {
            isShown = false;
            poDialogx.dismiss();
        });
    }


    public void show(){
        if(!isShown) {
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
            poDialogx.show();
            isShown = true;
        }
    }

}
