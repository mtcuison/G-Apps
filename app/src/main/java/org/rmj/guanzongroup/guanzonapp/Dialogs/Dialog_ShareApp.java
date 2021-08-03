package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.R;

import java.io.File;

public class Dialog_ShareApp {
    private AlertDialog poDialogx;
    private final Context mContext;
    private String lsDate = "";
    private TextView lblAddress;
    private ImageButton btnCloseDialog;
    private MaterialButton btnShareApk;
    private MaterialButton btnShareLink;
    private MaterialButton btnEmailContact;
    private MaterialButton btnFacebook;


    public Dialog_ShareApp(Context context){
        this.mContext = context;
    }

    public void initDialog(){
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_share_guanzon_app, null, false);
        loBuilder.setCancelable(false)
                .setView(view);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
        btnShareApk = view.findViewById(R.id.btn_dialog_share_apk);
        btnShareLink = view.findViewById(R.id.btn_dialog_share_link);
        btnCloseDialog = view.findViewById(R.id.btn_dialog_share_close);

        btnShareApk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareGuanzonAppApk();
            }
        });

        btnShareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareAppLink();
            }
        });

        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poDialogx.dismiss();
            }
        });
    }

    public void show(){
        initDialog();
        if(!poDialogx.isShowing()){
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.show();
        }
    }
    private void ShareAppLink(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mContext.getString(R.string.Share_Applink_Extra_Message) + "\n"
                +"\n"
                +"\n" + "https://play.google.com/store/apps/details?id=org.rmj.guanzongroup.guanzonapp&hl=en");
        ((MainActivity)mContext).startActivityForResult(shareIntent, 0006);
    }

    private void ShareGuanzonAppApk(){
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }

        ApplicationInfo appInfo = mContext.getApplicationInfo();
        String ApkPath = appInfo.sourceDir;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("applciation/vnd.android.package-archive");

        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(ApkPath)));
        ((MainActivity)mContext).startActivityForResult(Intent.createChooser(intent, "Share Guanzon App using..."), 0005);
    }

}
