package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_ContactUs {

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private TextView lblAddress;
    private ImageButton btnCloseDialog;
    private MaterialButton btnSmartContact;
    private MaterialButton btnGlobeContact;
    private MaterialButton btnEmailContact;

    public Dialog_ContactUs(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        @SuppressLint("InflateParams") View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_dashboard_contact_us, null, false);
        builder.setCancelable(true)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        lblAddress = view.findViewById(R.id.lbl_dialog_contact_us_main_address);
        btnCloseDialog = view.findViewById(R.id.btn_dialog_contact_us_exit);
        btnSmartContact = view.findViewById(R.id.btn_dialog_contact_us_smart);
        btnGlobeContact = view.findViewById(R.id.btn_dialog_contact_us_globe);
        btnEmailContact = view.findViewById(R.id.btn_dialog_contact_us_email);

        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
//        setupContactButtons();
    }

//    private void setupContactButtons(){
//        lblAddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Guanzon+Honda/@16.0406903,120.3363357,17z/data=!3m1!4b1!4m5!3m4!1s0x33915d55d27113e7:0x1bfce58632af3f9b!8m2!3d16.0406852!4d120.3385244"));
//                ((Activity_DashBoard)mContext).startActivityForResult(locationIntent, 0003);
//            }
//        });
//
//        btnSmartContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0998-9545-477", null));
//                if (mContext instanceof Activity) {
//                    ((Activity_DashBoard) mContext).startActivityForResult(contantIntent, 002);
//                }
//            }
//        });
//
//        btnGlobeContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", " 0917-1545-477", null));
//                if (mContext instanceof Activity) {
//                    ((Activity_DashBoard) mContext).startActivityForResult(contantIntent, 002);
//                }
//            }
//        });
//
//        btnEmailContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "customercare@guanzongroup.com.ph", null));
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Service");
//                if(mContext instanceof Activity) {
//                    ((Activity_DashBoard) mContext).startActivityForResult(Intent.createChooser(emailIntent, "Send Email..."), 0001);
//                }
//            }
//        });
//    }
}
