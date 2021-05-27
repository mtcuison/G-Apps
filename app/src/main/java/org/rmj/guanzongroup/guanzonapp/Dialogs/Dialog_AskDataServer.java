package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_SplashScreen;
import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_AskDataServer {
    private static final String TAG = Dialog_AskDataServer.class.getSimpleName();

    private Context mContext;
    private SharedPref sharedPref;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    public Dialog_AskDataServer(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.sharedPref = new SharedPref(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    @SuppressLint("InflateParams")
    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_dataserver, null, false);
        builder.setView(view)
                .setCancelable(false);

        final EditText txtAddress = view.findViewById(R.id.txt_dialog_hostAddress);
        Button btnOkay = view.findViewById(R.id.btn_dialog_server_okay);

        txtAddress.setText("192.168.");
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = "http://"+txtAddress.getText().toString()+"/";
                sharedPref.setAppServer(address);
                sharedPref.setIsLocalHostChange(false);
                dialog.dismiss();
                new Activity_SplashScreen().getInstance().recreate();
            }
        });

        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
