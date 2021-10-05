package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.google.android.material.button.MaterialButton;

import org.json.JSONObject;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.HashMap;

public class Dialog_ChangePassword {

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    CustomToast customToast;

    private EditText txtOldPass;
    private EditText txtNewPass;
    private EditText txtCfmPass;

    public Dialog_ChangePassword(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.customToast = new CustomToast(mContext);
    }

    public interface onChangePasswordListener{
        void onChangePassword(AlertDialog dialog, String oldPass, String newPass);
    }
    public void showDialog(){
        dialog.show();
    }

    public void createDialog(onChangePasswordListener listener){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_change_password, null, false);

        builder.setCancelable(false)
                .setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        txtOldPass = view.findViewById(R.id.txt_dialog_oldPassword);
        txtNewPass = view.findViewById(R.id.txt_dialog_newPassword);
        txtCfmPass = view.findViewById(R.id.txt_dialog_confirmPassword);

        MaterialButton btnChangePass = view.findViewById(R.id.btn_dialog_changePassword);
        MaterialButton btnClose = view.findViewById(R.id.btn_dialog_changePassword_Close);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDataValid()) {
                    listener.onChangePassword(dialog, txtOldPass.getText().toString(), txtNewPass.getText().toString());

                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private boolean isDataValid(){
        customToast.setType(CustomToast.CustomToastType.WARNING);
        if(txtOldPass.getText().toString().isEmpty()){
            customToast.setMessage("Please enter old password");
            customToast.show();
            return false;
        }
        if(txtNewPass.getText().toString().isEmpty()){
            customToast.setMessage("Please enter new password");
            customToast.show();
            return false;
        }
        if(txtCfmPass.getText().toString().isEmpty()){
            customToast.setMessage("Please confirm new password");
            customToast.show();
            return false;
        }
        if(!txtNewPass.getText().toString().equalsIgnoreCase(txtCfmPass.getText().toString())){
            customToast.setMessage("New password does not match");
            customToast.show();
            return false;
        }
        if(txtNewPass.getText().toString().length() < 8){
            customToast.setMessage("Please enter atleast 8 characters password");
            customToast.show();
            return false;
        }
        if(txtNewPass.getText().toString().length() > 15){
            customToast.setMessage("Password is too long. Must be less than 15 characters");
            customToast.show();
            return false;
        }
        return true;
    }


}
