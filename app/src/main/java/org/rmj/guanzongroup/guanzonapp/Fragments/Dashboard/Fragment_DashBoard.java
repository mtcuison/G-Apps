package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Orders;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_QrCodeScanner;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Redeemables;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Service;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Transactions;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_GCardCodex;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_PointsInfo;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ScanResult;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AppUserMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.App_Notifications;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.TransactionPoints;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.UserLogout;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.ScanResultHandler.ScanResult;
import org.rmj.guanzongroup.guanzonapp.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment_DashBoard extends Fragment {
    @SuppressLint("StaticFieldLeak")
    private static Fragment_DashBoard instance;
    private GcardAppMaster gcardAppMaster;
    private TransactionPoints transactionPoints;
    private App_Notifications appNotifications;

    private View view;

    private ImageView guanzonLogo_Animated;
    private TextView Username;
    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;
    private Drawable drawable;

    private TextView lblAvailablePoints;
    private TextView lblActiveGcardNmbr;
    private TextView lblOrderBadge;

    public Fragment_DashBoard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        instance = this;
        view = inflater.inflate(R.layout.fragment_dashboard_tab_main, container, false);

        setupJavaClassess();
        setupWidgets();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupAnimation();
        }

        return view;
    }

    private void setupJavaClassess(){
        gcardAppMaster = new GcardAppMaster(getActivity());
        transactionPoints = new TransactionPoints(getActivity());
        appNotifications = new App_Notifications(getActivity());
    }

    @SuppressLint("RestrictedApi")
    private void setupWidgets(){
        RelativeLayout btnHistory = view.findViewById(R.id.btn_dashboard_history);
        RelativeLayout btnRedeemables = view.findViewById(R.id.btn_dashboard_redeemables);
        RelativeLayout btnScan = view.findViewById(R.id.btn_dashboard_scan);
        RelativeLayout btnOrders = view.findViewById(R.id.btn_dashboard_orders);
        lblOrderBadge = view.findViewById(R.id.lbl_dashboard_orderBadge);
        LinearLayout btnPointsInfo = view.findViewById(R.id.btn_dashboard_PointsInfo);
        FrameLayout btnService = view.findViewById(R.id.btn_dashboard_service);
        RelativeLayout btnLogout = view.findViewById(R.id.btn_dashboard_logout);

        lblAvailablePoints = view.findViewById(R.id.lbl_dashboard_gcard_available_points);
        lblActiveGcardNmbr = view.findViewById(R.id.lbl_dashboard_active_gcard_number);
        Username = view.findViewById(R.id.lbl_dashboard_userfullname);
        guanzonLogo_Animated = view.findViewById(R.id.img_dashboard_guanzon_logo);
        Username.setText(new AppUserMaster(getActivity()).getUserName());

        btnPointsInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Dialog_PointsInfo(getActivity()).showDialog();
            }
        });

        guanzonLogo_Animated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!new GcardAppMaster(getActivity()).hasNoGcard()){
                    new Dialog_GCardCodex(getActivity()).showDialog();
                }
            }
        });

        lblAvailablePoints.setText(String.valueOf(transactionPoints.getRemainingGCardPoints()));
        lblActiveGcardNmbr.setText(gcardAppMaster.getCardNumber());

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_Transactions.class));
            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_QrCodeScanner.class));
            }
        });

        btnRedeemables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_Redeemables.class));
            }
        });

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_Orders.class));
            }
        });
        setupOrderBadge();

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_Service.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewLogoutMessage();
            }
        });
    }

    public static Fragment_DashBoard getInstance(){
        return instance;
    }

    public void refreshUI(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                lblActiveGcardNmbr.setText(gcardAppMaster.getCardNumber());
                lblAvailablePoints.setText(String.valueOf(transactionPoints.getRemainingGCardPoints()));
                setupOrderBadge();
            }
        });
    }

    public void showScanResult(final String result){
        new ScanResultTast(result).execute();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupAnimation(){
        drawable = getActivity().getDrawable(R.drawable.anim_ic_guanzon_logo);

        if(drawable instanceof AnimatedVectorDrawableCompat){
            avdc = (AnimatedVectorDrawableCompat)drawable;
            guanzonLogo_Animated.setImageDrawable(avdc);
            avdc.start();
            avdc.clearAnimationCallbacks();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (drawable instanceof AnimatedVectorDrawable) {
                    avd = (AnimatedVectorDrawable) drawable;
                    guanzonLogo_Animated.setImageDrawable(avd);
                    avd.start();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        avd.clearAnimationCallbacks();
                    }
                }
            }
        }
    }

    private void ViewLogoutMessage(){
            MessageBox messageBox = new MessageBox(getActivity());
            messageBox.setDialogMessage("Are you sure you want to logout?");
            messageBox.setMessageType(MessageBox.MessageType.WARNING);
            messageBox.setPositiveButton("Okay", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    new SessionManager(getActivity()).setLogin(false);
                    Intent intent = new Intent(getActivity(), Activity_DashBoard.class);
                    getActivity().finish();
                    startActivity(intent);
                    new UserLogout(getActivity()).logoutUser();
                    dialog.dismiss();
                }
            });

            messageBox.setNegativeButton("Cancel", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    dialog.dismiss();
                }
            });
            messageBox.showDialog();
    }

    @SuppressLint("StaticFieldLeak")
    class ScanResultTast extends AsyncTask<Integer, Integer, String>{

        CodeGenerator codeGenerator = new CodeGenerator();
        final Dialog_ScanResult scanResult = new Dialog_ScanResult(getActivity());
        String message;
        String result;
        String pin;
        boolean isSuccess;

        ScanResultTast(String result){
            codeGenerator.setEncryptedQrCode(result);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            new ScanResult(getActivity(), codeGenerator).setupAction(new ScanResult.onScannerResultListener() {
                @Override
                public void onSuccessResult(String Pin) {
                    result = "SUCCESS";
                    pin = Pin;
                    message = "Transaction Finish Successfully.";
                    isSuccess = true;
                }

                @Override
                public void onFailedResult(String errorMessage) {
                    result = "FAILED";
                    message = errorMessage;
                }
            });
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            scanResult.setResult(result);
            scanResult.setResultPIN(pin);
            scanResult.setResultMessage(message);
            scanResult.setSuccess(isSuccess);
            scanResult.showDialog();
            super.onPostExecute(s);
            this.cancel(true);
        }
    }

    private int getOrderBadgeVisibility(){
        if(appNotifications.getOrdersCount() > 0){
            return View.VISIBLE;
        }
        return View.GONE;
    }

    private void setupOrderBadge(){
        lblOrderBadge.setVisibility(getOrderBadgeVisibility());
        lblOrderBadge.setText(String.valueOf(appNotifications.getOrdersCount()));
    }
}
