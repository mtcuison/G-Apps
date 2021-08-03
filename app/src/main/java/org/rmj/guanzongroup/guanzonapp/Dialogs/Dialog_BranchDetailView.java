package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;
//import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

public class Dialog_BranchDetailView {

    private Context mContext;
//    private CustomToast customToast;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private ImageView imgBranchLogo;
    private MaterialButton btnEmail;
    private MaterialButton btnMobile;

    private int branch;

    private String BranchName = "";
    private String BranchAdds = "";
    private String BranchMobl = "";
    private String BranchCntc = "";
    private String BranchMail = "";

    private AnimatedVectorDrawableCompat avd;
    private AnimatedVectorDrawable avd1;

    public Dialog_BranchDetailView(Context context, int Branch){
        this.mContext = context;
        this.branch = Branch;
        this.builder = new AlertDialog.Builder(mContext);
//        this.customToast = new CustomToast(mContext);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showDialog(){
        createDialog();
        dialog.show();
        animateBranchLogo();
    }

    private void createDialog(){
        @SuppressLint("InflateParams") View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_branch_detail, null, false);
        builder.setCancelable(true)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.SlideAnimation;

        imgBranchLogo = view.findViewById(R.id.img_dialog_branch_detail_logo);
        ImageButton btnClose = view.findViewById(R.id.btn_dialog_branch_close);
        TextView lblBranchName = view.findViewById(R.id.lbl_dialog_branch_name);
        TextView lblBranchAddress = view.findViewById(R.id.lbl_dialog_branch_address);
        btnMobile = view.findViewById(R.id.btn_dialog_branch_mobile_contact);
        MaterialButton btnTellphone = view.findViewById(R.id.btn_dialog_branch_telephone_contact);
        btnEmail = view.findViewById(R.id.btn_dialog_branch_email_address);

        lblBranchName.setText(BranchName);
        lblBranchAddress.setText(BranchAdds);
        btnMobile.setText(BranchMobl);
        btnTellphone.setText(BranchCntc);
        btnEmail.setText(BranchMail);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        lblBranchAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        btnMobile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!btnMobile.getText().toString().isEmpty()) {
//                    Intent contantIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", btnMobile.getText().toString(), null));
//                    if(mContext instanceof Activity) {
//                        ((Activity_DashBoard) mContext).startActivityForResult(contantIntent, 002);
//                    }
//                } else {
//                    customToast.setType(CustomToast.CustomToastType.WARNING);
//                    customToast.setMessage("Unable to contact branch. No Mobile No.");
//                    customToast.show();
//                }
//            }
//        });

        btnTellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        btnEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!btnEmail.getText().toString().isEmpty()) {
//                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", btnEmail.getText().toString(), null));
//                    if(mContext instanceof Activity) {
//                        (ge).startActivityForResult(Intent.createChooser(emailIntent, "Send Email..."), 0001);
//                    }
//                } else {
////                    customToast.setType(CustomToast.CustomToastType.WARNING);
////                    customToast.setMessage("No branch email has been provided.");
////                    customToast.show();
//                }
//            }
//        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void animateBranchLogo(){
        Drawable drawable = mContext.getDrawable(getBranchLogo());
        if(drawable instanceof AnimatedVectorDrawableCompat){
            avd = (AnimatedVectorDrawableCompat)drawable;
            imgBranchLogo.setImageDrawable(avd);
            avd.start();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (drawable instanceof AnimatedVectorDrawable) {
                avd1 = (AnimatedVectorDrawable) drawable;
                imgBranchLogo.setImageDrawable(avd1);
                avd1.start();
            }
        }
    }

    private int getBranchLogo(){
        if(branch == 1){
            return R.drawable.anim_ic_dialog_branch_motor;
        }
        return R.drawable.anim_ic_dialog_branch_mobitek;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public void setBranchAdds(String branchAdds) {
        BranchAdds = branchAdds;
    }

    public void setBranchMobl(String branchMobl) {
        BranchMobl = branchMobl;
    }

    public void setBranchCntc(String branchCntc) {
        BranchCntc = branchCntc;
    }

    public void setBranchMail(String branchMail) {
        BranchMail = branchMail;
    }
}
