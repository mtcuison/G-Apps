package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AppUserMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.PointsManager;
import org.rmj.guanzongroup.guanzonapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dialog_GCardCodex extends CodeGenerator {
    private static final String TAG = Dialog_GCardCodex.class.getSimpleName();

    private Context mContext;
    private View view;

    private GcardAppMaster gcardAppMaster;
    private PointsManager pointsManager;
    private AppUserMaster appUserMaster;
    private SharedPref sharedPref;
    private Telephony telephony;
    private Date date;
    private DateFormat dateFormat;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private ImageView imgGCardCodex;
    private TextView lblGcardCodex;
    private MaterialButton btnClose;
    private String BATCH_NOX;
    private String CARD = "CARD";
    private String DEVICE_IMEI = "";
    private String GCARD_NUMBER = "";
    private String USER_ID = "";
    private String MOBILE_NO = "";
    private String DATE_TIME = "";
    private double GCARD_POINTS = 0;
    private String BUILD_MODEL = "";
    private String TRANSNOX = "";

    public Dialog_GCardCodex(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.pointsManager = new PointsManager(mContext);
        this.appUserMaster = new AppUserMaster(mContext);
        this.sharedPref = new SharedPref(mContext);
        this.telephony = new Telephony(mContext);
        this.date = new Date();
        this.dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    }

    public void showDialog(){
        createDialog();
        setupGCardQrCode();
        dialog.show();
    }

    public void showDialog(String BatchNox){
        createDialog();
        setupOrderQrCode(BatchNox);
        dialog.show();
    }

    private void createDialog(){
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_gcard_codex, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        imgGCardCodex = view.findViewById(R.id.img_dialog_gcard_codex_QRCode);
        lblGcardCodex = view.findViewById(R.id.lbl_dialog_gcardCodex);
        btnClose = view.findViewById(R.id.btn_dialog_gcard_codex_close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void setValues(){
        DEVICE_IMEI = telephony.getDeviceID();
        GCARD_NUMBER = gcardAppMaster.getCardNumber();
        USER_ID = appUserMaster.getUserID();
        MOBILE_NO = sharedPref.getMobileNo();
        DATE_TIME = dateFormat.format(date);
        GCARD_POINTS = pointsManager.getRemainingGCardPoints();
        BUILD_MODEL = Build.MODEL;
    }

    private void setupGCardQrCode(){
        try{
            setValues();
            imgGCardCodex.setImageBitmap(generateGCardCodex(
                    CARD,
                    DEVICE_IMEI,
                    GCARD_NUMBER,
                    USER_ID,
                    MOBILE_NO,
                    DATE_TIME,
                    GCARD_POINTS,
                    BUILD_MODEL,
                    TRANSNOX));
            Log.e(TAG, "QrCode Values = " + CARD +" "+ DEVICE_IMEI +" "+ GCARD_NUMBER +" "+ USER_ID +" "+ MOBILE_NO +" "+ DATE_TIME +" "+ GCARD_POINTS +" "+ BUILD_MODEL);
            lblGcardCodex.setText("Scan QR Code above to access your GCard details and earn points.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupOrderQrCode(String BATCH_NOX){
        try {
            setValues();
            imgGCardCodex.setImageBitmap(generateQrCode("PREORDER",
                    DEVICE_IMEI,
                    GCARD_NUMBER,
                    USER_ID,
                    MOBILE_NO,
                    DATE_TIME,
                    GCARD_POINTS,
                    BUILD_MODEL,
                    BATCH_NOX));
            lblGcardCodex.setText("Scan QR Code above to claim your order on selected branch.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
