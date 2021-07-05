package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Dialog_ContactUs {
    private AlertDialog poDialogx;
    private final Context context;
    private String lsDate = "";
    private TextView lblAddress;
    private ImageButton btnCloseDialog;
    private MaterialButton btnSmartContact;
    private MaterialButton btnGlobeContact;
    private MaterialButton btnEmailContact;
    private MaterialButton btnFacebook;


    public Dialog_ContactUs(Context context){
        this.context = context;
    }

    public void initDialog(){
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_dashboard_contact_us, null, false);
        loBuilder.setCancelable(false)
                .setView(view);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        lblAddress = view.findViewById(R.id.lbl_dialog_contact_us_main_address);
        btnCloseDialog = view.findViewById(R.id.btn_dialog_contact_us_exit);
        btnSmartContact = view.findViewById(R.id.btn_dialog_contact_us_smart);
        btnGlobeContact = view.findViewById(R.id.btn_dialog_contact_us_globe);
        btnEmailContact = view.findViewById(R.id.btn_dialog_contact_us_email);
        btnFacebook = view.findViewById(R.id.btn_dialog_contact_us_facebook);

        btnCloseDialog.setOnClickListener(view1 -> poDialogx.dismiss());
        setupContactButtons();
    }

    public void show(){
        initDialog();
        if(!poDialogx.isShowing()){
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.show();
        }
    }
    private void setupContactButtons(){
        lblAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Guanzon+Honda/@16.0406903,120.3363357,17z/data=!3m1!4b1!4m5!3m4!1s0x33915d55d27113e7:0x1bfce58632af3f9b!8m2!3d16.0406852!4d120.3385244"));
                ((MainActivity)context).startActivityForResult(locationIntent, 0003);
            }
        });

        btnSmartContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0998-9545-477", null));
                if (context instanceof Activity) {
                    ((MainActivity) context).startActivityForResult(contantIntent, 002);
                }
            }
        });

        btnGlobeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", " 0917-1545-477", null));
                if (context instanceof Activity) {
                    ((MainActivity) context).startActivityForResult(contantIntent, 002);
                }
            }
        });
        btnGlobeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", " 0917-1545-477", null));
                if (context instanceof Activity) {
                    ((MainActivity) context).startActivityForResult(contantIntent, 002);
                }
            }
        });

        btnEmailContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "customercare@guanzongroup.com.ph", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Service");
                if(context instanceof Activity) {
                    ((MainActivity) context).startActivityForResult(Intent.createChooser(emailIntent, "Send Email..."), 0001);
                }
            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/guanzongroup/"));
                ((MainActivity)context).startActivityForResult(fbIntent, 0003);
            }
        });
    }

}
