package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;
import org.rmj.guanzongroup.panalo.R;

public class DialogRaffleEntryQrCode {

    private final Context mContext;

    private final AlertDialog.Builder poBuilders;
    private AlertDialog poDialog;

    public DialogRaffleEntryQrCode(Context mContext) {
        this.mContext = mContext;
        this.poBuilders = new AlertDialog.Builder(mContext);
    }

    public void initDialog(String Transact, String ReferNo){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_raffle_entry_qr_code, null, false);
        poBuilders.setView(view).setCancelable(false);
        poDialog = poBuilders.create();

        TextView lblTransact = view.findViewById(R.id.lbl_dialogHeader2);
        ImageView imgQrCode = view.findViewById(R.id.img_QRCode);
        MaterialButton btnRefresh = view.findViewById(R.id.btn_dialogRefresh);
        MaterialButton btnClose = view.findViewById(R.id.btn_dialogClose);

        lblTransact.setText(Transact);
        imgQrCode.setImageBitmap(GetQRCodeBitmap(Transact, ReferNo));

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgQrCode.setImageBitmap(GetQRCodeBitmap(Transact, ReferNo));
            }
        });

        btnClose.setOnClickListener(v -> poDialog.dismiss());

        poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialog.show();
    }

    private Bitmap GetQRCodeBitmap(String Transact, String ReferNo){
        try{
            String lsUserID = new AccountInfo(mContext).getUserID();
            String lsDateTm = AppConstants.GetCurrentDateTime();
            return CodeGenerator.CreateRaffleEntryQrCode(Transact, ReferNo, lsUserID, lsDateTm);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
