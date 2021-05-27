package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
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

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.R;

import java.io.File;

public class Dialog_ShareApp {

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    public Dialog_ShareApp(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_share_guanzon_app, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        MaterialButton btnShareApk = view.findViewById(R.id.btn_dialog_share_apk);
        MaterialButton btnShareLink = view.findViewById(R.id.btn_dialog_share_link);
        ImageButton btnClose = view.findViewById(R.id.btn_dialog_share_close);

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

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void ShareAppLink(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mContext.getString(R.string.Share_Applink_Extra_Message) + "\n"
                +"\n"
                +"\n" + "https://play.google.com/store/apps/details?id=org.rmj.guanzongroup.guanzonapp&hl=en");
        ((Activity_DashBoard)mContext).startActivityForResult(shareIntent, 0006);
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
        ((Activity_DashBoard)mContext).startActivityForResult(Intent.createChooser(intent, "Share Guanzon App using..."), 0005);
    }
}
