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

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_EventReminder {
    private static final String TAG = Dialog_EventReminder.class.getSimpleName();

    private Context mContext;
    private View view;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private Bitmap thumbnail;
    private String WebUrl;

    private ImageView imgEvent;
    private MaterialButton btnView;
    private MaterialButton btnClose;

    public Dialog_EventReminder(Context context, Bitmap thumbnail, String webUrl){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.thumbnail = thumbnail;
        this.WebUrl = webUrl;
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_event_reminder, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.SlideAnimation;
        imgEvent = view.findViewById(R.id.img_dialog_eventThumbnail);
        btnView = view.findViewById(R.id.btn_dialog_eventRead);
        btnClose = view.findViewById(R.id.btn_dialog_eventClose);

        imgEvent.setImageBitmap(thumbnail);

        imgEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {dialog.dismiss();
                Intent intent = new Intent(mContext, Activity_AppBrowser.class);
                intent.putExtra("url_link", WebUrl);
                mContext.startActivity(intent);
                new Activity_DashBoard().getInstance().setDialogShow(true);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(mContext, Activity_AppBrowser.class);
                intent.putExtra("url_link", WebUrl);
                mContext.startActivity(intent);
                new Activity_DashBoard().getInstance().setDialogShow(true);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Activity_DashBoard().getInstance().setDialogShow(true);
                dialog.dismiss();
            }
        });
    }
}
