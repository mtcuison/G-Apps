/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.app
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;
import org.rmj.guanzongroup.guanzonapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DialogUserProfile {

    private ImageView imgProfile;
    private TextView lblUserName, lblUserMail, lblUserDate, lblBuildVsn;
    private final AlertDialog poDialog;
    private MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    private BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
    private MaterialButton btnSettings, btnClose;

    public DialogUserProfile(Context context, EClientInfo eClientInfo){
        AlertDialog.Builder poBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_dashboard_user_detail, null);
        poBuilder.setCancelable(false)
                .setView(view);
        poDialog = poBuilder.create();
        poDialog.setCancelable(false);
        lblUserName = view.findViewById(R.id.lbl_dialog_user_account_userName);
        lblUserMail = view.findViewById(R.id.lbl_dialog_user_account_email);
        lblUserDate = view.findViewById(R.id.lbl_dialog_user_account_memberDate);
        lblBuildVsn = view.findViewById(R.id.lbl_dialog_user_account_buildVersion);
        //lblDate = view.findViewById(R.id.dialog_lbl_date);

        ImageView imgUserCodex = view.findViewById(R.id.img_dialog_user_account_codex);

        lblUserName.setText(eClientInfo.getUserName());
        lblUserMail.setText(eClientInfo.getEmailAdd());
        lblUserDate.setText(Date_Readable_Format(eClientInfo.getDateMmbr()));
        lblBuildVsn.setText("Build Version " + BuildConfig.VERSION_NAME + " - " + BuildConfig.VERSION_CODE + "Vc.");
        imgUserCodex.setImageBitmap(createBitmapCodex(eClientInfo));
        btnSettings = view.findViewById(R.id.btn_dialog_user_account_settings);
        btnClose = view.findViewById(R.id.btn_dialog_user_account_close);
        btnClose.setOnClickListener(view1 -> poDialog.dismiss());
    }

    public void show(){
        if(!poDialog.isShowing()){
            poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
            poDialog.show();
        }
    }
    private Bitmap createBitmapCodex(EClientInfo eClientInfo){
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(new CodeGenerator().generateSecureNo(eClientInfo.toString()), BarcodeFormat.QR_CODE, 900, 900);
            return barcodeEncoder.createBitmap(bitMatrix);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String Date_Readable_Format(String dateReceive){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateReceive);
            return new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
