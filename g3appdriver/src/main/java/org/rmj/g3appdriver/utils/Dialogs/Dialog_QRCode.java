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

public class Dialog_QRCode {

    private AlertDialog poDialogx;
    private final Context poContext;

    public Dialog_QRCode(Context foContext) {
        this.poContext = foContext;
    }

    public void initDialog(String foTitlexx, Bitmap foQrImage, QrCodeCallback foCallBck){
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_qr_code,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lblTitlex = view.findViewById(R.id.lbl_title);
        ImageView poQrImage= view.findViewById(R.id.img_qrCode);
        Button button = view.findViewById(R.id.button);

        lblTitlex.setText(Objects.requireNonNull(foTitlexx));
        poQrImage.setImageBitmap(Objects.requireNonNull(foQrImage));

        poQrImage.setOnClickListener(v -> foCallBck.onRefresh(poDialogx));
        button.setOnClickListener(v -> poDialogx.dismiss());
    }


    public void show(){
        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialogx.show();
    }

    public interface QrCodeCallback {
        void onRefresh(AlertDialog foDialogx);
    }

}
