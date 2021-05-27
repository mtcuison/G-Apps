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

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
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
                    new ChangePasswordTask().execute();
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

    class ChangePasswordTask extends AsyncTask<Integer, Integer, String>{

        Dialog_Loading loading = new Dialog_Loading(mContext);
        String result;
        String Message;

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            loading.setMessage("Please wait...");
            loading.showDialog();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            if(new ConnectionUtil(mContext).isDeviceConnected()){
                new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_CHANGE_PASSWORD(), new HttpRequestUtil.onServerResponseListener() {
                    @Override
                    public HashMap setHeaders() {
                        return (HashMap) new RequestHeaders(mContext).getHeaders();
                    }

                    @Override
                    public JSONObject setData() {
                        JSONObject jsonObject = new JSONObject();
                        try{
                            jsonObject.put("oldpassword", txtOldPass.getText().toString());
                            jsonObject.put("newpassword", txtNewPass.getText().toString());
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        return jsonObject;
                    }

                    @Override
                    public void onResponse(JSONObject jsonResponse) {
                        result = "success";
                    }

                    @Override
                    public void onErrorResponse(String message) {
                        result = "error";
                        Message = message;
                    }
                });
            } else {
                result = "error";
                Message = "No internet connection.";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismissDialog();
            if(s.equalsIgnoreCase("success")){
                customToast.setType(CustomToast.CustomToastType.INFORMATION);
                customToast.setMessage("Password reset successfully.");
                customToast.show();
                dialog.dismiss();
            } else {
                customToast.setType(CustomToast.CustomToastType.WARNING);
                customToast.setMessage(Message);
                customToast.show();
            }
            this.cancel(true);
        }
    }
}
