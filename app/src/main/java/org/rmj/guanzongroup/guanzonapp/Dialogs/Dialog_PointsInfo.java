package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.TransactionPoints;
import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_PointsInfo {
    private static final String TAG = Dialog_PointsInfo.class.getSimpleName();

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private GcardAppMaster gcardAppMaster;
    private TransactionPoints transactionPoints;

    public Dialog_PointsInfo(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.transactionPoints = new TransactionPoints(mContext);
        createDialog();
    }

    @SuppressLint("SetTextI18n")
    private void createDialog(){
        @SuppressLint("InflateParams") View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_points_info, null, false);
        builder.setCancelable(true)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        TextView lblTotPoints = view.findViewById(R.id.lbl_dialog_totPoints);
        TextView lblAvlPoints = view.findViewById(R.id.lbl_dialog_avlPoints);
        MaterialButton btnOkay = view.findViewById(R.id.btn_dialog_points_okay);

        lblTotPoints.setText("Total Points : " + gcardAppMaster.getCardTotPts());
        lblAvlPoints.setText("Available Points : " + transactionPoints.getRemainingGCardPoints());

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void showDialog(){
        dialog.show();
    }
}
