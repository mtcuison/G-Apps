package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Account;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AppUserMaster;
import org.rmj.guanzongroup.guanzonapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dialog_UserDetail {

    private Context mContext;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;


    private MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    private BarcodeEncoder barcodeEncoder = new BarcodeEncoder();

    private AppUserMaster userMaster;


    public Dialog_UserDetail(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.userMaster = new AppUserMaster(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_dashboard_user_detail, null, false);

        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        TextView lblUserName = view.findViewById(R.id.lbl_dialog_user_account_userName);
        TextView lblUserMail = view.findViewById(R.id.lbl_dialog_user_account_email);
        TextView lblUserDate = view.findViewById(R.id.lbl_dialog_user_account_memberDate);
        TextView lblBuildVsn = view.findViewById(R.id.lbl_dialog_user_account_buildVersion);

        MaterialButton btnSettings = view.findViewById(R.id.btn_dialog_user_account_settings);
        MaterialButton btnClose = view.findViewById(R.id.btn_dialog_user_account_close);

        ImageView imgUserCodex = view.findViewById(R.id.img_dialog_user_account_codex);

        lblUserName.setText(userMaster.getUserName());
        lblUserMail.setText(userMaster.getUserEmail());
        lblUserDate.setText(Date_Readable_Format(userMaster.getUserRegistrationDate()));
        lblBuildVsn.setText("Build Version " + BuildConfig.VERSION_NAME + " - " + BuildConfig.VERSION_CODE + "Vc.");
        imgUserCodex.setImageBitmap(createBitmapCodex());

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                mContext.startActivity(new Intent(mContext, Activity_Account.class));
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private JSONObject createUserInfo(){
        JSONObject params = new JSONObject();
        try{
            params.put("sUserIDxx", userMaster.getUserID());
            params.put("sUserName", userMaster.getUserName());
            params.put("sEmailAdd", userMaster.getUserEmail());
            params.put("sMobileNo", userMaster.getUserMobileNo());
            params.put("dLoginxxx", userMaster.getDateLogin());
            params.put("dDateMmbr", userMaster.getUserRegistrationDate());
            params.put("sDevcImei", new Telephony(mContext).getDeviceID());
            return params;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap createBitmapCodex(){
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(new CodeGenerator().generateSecureNo(createUserInfo().toString()), BarcodeFormat.QR_CODE, 900, 900);
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
