package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_Loading {

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private String message;

    private ImageView imgProgressLogo;
    private TextView lblMessage;

    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;

    public Dialog_Loading(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showDialog(){
        createDialog();
        dialog.show();
    }

    public void dismissDialog(){
        if(avdc!=null){
            avdc.clearAnimationCallbacks();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(avd != null) {
                    avd.clearAnimationCallbacks();
                }
            }
        }
        dialog.dismiss();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createDialog() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_data_loading, null, false);
        builder.setCancelable(false)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        imgProgressLogo = view.findViewById(R.id.img_dialog_progress_logo);
        lblMessage = view.findViewById(R.id.lbl_dialog_progress_message);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = mContext.getDrawable(R.drawable.anim_progress_dialog_logo);
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avdc = (AnimatedVectorDrawableCompat) drawable;
                imgProgressLogo.setImageDrawable(avdc);
                AnimatedVectorDrawableCompat.registerAnimationCallback(drawable, new Animatable2Compat.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        avdc.start();
                    }
                });
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (drawable instanceof AnimatedVectorDrawable) {
                    avd = (AnimatedVectorDrawable) drawable;
                    imgProgressLogo.setImageDrawable(avd);
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        avd.registerAnimationCallback(new Animatable2.AnimationCallback() {
                            @Override
                            public void onAnimationEnd(Drawable drawable) {
                                avd.start();
                            }
                        });
                    }
                    avd.start();
                }
            }
        }
    }
}
