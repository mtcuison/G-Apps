package org.rmj.androidprojects.guanzongroup.g3logindriver.Dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.rmj.androidprojects.guanzongroup.g3logindriver.R;
import org.rmj.g3appdriver.etc.SharedPref;

public class Dialog_AccountActivation {

    private Context mContext;
    private View mView;

    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private SharedPref sharedPref;
    private Toast toast;

    private EditText txtPIN;
    private Button btnActivate;
    private TextView txtDialogMessage;
    private String MobileNo = "";
    private String ActivationURL;
    private JSONObject loginParameters;

    public Dialog_AccountActivation(Context context, String Number){
        this.mContext = context;
        this.MobileNo = Number;
        this.builder = new AlertDialog.Builder(mContext);
        this.sharedPref = new SharedPref(mContext);
    }

    public void showDialog(String ActivationURL){
        this.ActivationURL = ActivationURL;
        createDialog();
        alertDialog.show();
    }

    @SuppressLint("InflateParams")
    private void createDialog(){
        mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_account_verification_code, null, false);
        builder.setCancelable(false)
                .setView(mView);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        txtDialogMessage = mView.findViewById(R.id.lbl_dialog_activation_msg);
        btnActivate = mView.findViewById(R.id.btn_dialogActivate);
        txtPIN = mView.findViewById(R.id.txt_dialog_confirm_PIN);

        txtDialogMessage.setText(mContext.getResources().getString(R.string.dialog_msg_account_confirm1)+ " " + MobileNo + " " + mContext.getResources().getString(R.string.dialog_msg_account_confirm2));

    }

}
