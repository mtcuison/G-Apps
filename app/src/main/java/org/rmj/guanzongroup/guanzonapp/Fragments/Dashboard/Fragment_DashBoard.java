package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.g3appdriver.etc.GAppMessageBox;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Orders;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_QrCodeScanner;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Redeemables;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Service;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Transactions;
import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_GCardCodex;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ScanResult;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMQrCodeScanner;

import static android.app.Activity.RESULT_OK;
import static org.rmj.g3appdriver.etc.AppConstants.ACCOUNT_REQUEST_CODE;
import static org.rmj.g3appdriver.etc.AppConstants.INTENT_QR_CODE;
import static org.rmj.g3appdriver.etc.AppConstants.LOGIN_ACTIVITY_REQUEST_CODE;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.tabBadge;

/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment_DashBoard extends Fragment implements VMQrCodeScanner.onScannerResultListener{

    private static final String TAG = Fragment_DashBoard.class.getSimpleName();
    private View view;

    private ImageView guanzonLogo_Animated;
    private TextView Username;
    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;
    private Drawable drawable;

    private TextView lblAvailablePoints;
    private TextView lblActiveGcardNmbr;
    private TextView lblOrderBadge;

    private VMDashboard mViewModel;
    private VMQrCodeScanner mViewModelScanner;
    private GAppMessageBox poMessage;

    private int total;
    private int promo;
    private int event;
    private Dialog_ScanResult scanResult;
    public static Fragment_DashBoard newInstance() {
        return new Fragment_DashBoard();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_dashboard_tab_main, container, false);
        mViewModel = ViewModelProviders.of(this).get(VMDashboard.class);
        mViewModelScanner = ViewModelProviders.of(this).get(VMQrCodeScanner.class);
        scanResult = new Dialog_ScanResult(getActivity());
        poMessage = new GAppMessageBox(getActivity());
        setupWidgets();
        setupAnimation();

        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            try {

                Username.setText(eClientInfo.getUserName());
                Username.setShadowLayer(10, 1, 1, Color.BLACK);

            }catch (NullPointerException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.getGCardInfo().observe(getViewLifecycleOwner(), gCardApp -> {

            try {  mViewModel.getOrdersList(gCardApp.getCardNmbr()).observe(getViewLifecycleOwner(), orderList ->{
                if (orderList != null && orderList.size() > 0){
                    lblOrderBadge.setVisibility(View.VISIBLE);
                    lblOrderBadge.setText(String.valueOf(orderList.size()));
                }else{
                    lblOrderBadge.setVisibility(View.GONE);
                }
            });
                lblActiveGcardNmbr.setText(gCardApp.getCardNmbr());
                lblAvailablePoints.setText(gCardApp.getAvlPoint());

            }catch (NullPointerException e){
                Log.e(TAG, e.getMessage());
            }
        });
//        mViewModel.getUnreadNotificationCount().observe(MainActivity.this, unread_count->{
//            tabBadge.setNumber(unread_count);
//            tabBadge.setVisible(unread_count > 0);
//        });
        mViewModel.getPromoCount().observe(getViewLifecycleOwner(), promo_count->{
            promo = promo_count;
        });
        mViewModel.getEventsCount().observe(getViewLifecycleOwner(), event_count->{
            event = event_count;
            total = event + promo;
            Log.e("Total", "Total = " + total);
        });

        return view;
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

        guanzonLogo_Animated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.hasNoCard().observe(getViewLifecycleOwner(), egcard->{
                    if (egcard != null){
                        new Dialog_GCardCodex(getActivity(),egcard).showDialog();
                    }
                });
//
//                if(!new GcardAppMaster(getActivity()).hasNoGcard()){
//                    new Dialog_GCardCodex(getActivity()).showDialog();
//                }
            }
        });
        btnLogout.setOnClickListener(v->{
            poMessage.initDialog();
            poMessage.setMessage("Are you sure you want to logout?");
            poMessage.setNegativeButton("Cancel", (view, dialog) -> dialog.dismiss());
            poMessage.setPositiveButton("Okay", (view, dialog) -> {
                mViewModel.userLogout();
                dialog.dismiss();
                getActivity().recreate();
            });
            poMessage.show();
        });
        btnHistory.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), Activity_Transactions.class));});
        btnRedeemables.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), Activity_Redeemables.class));});
        btnScan.setOnClickListener(v->{
            getActivity().startActivityForResult(new Intent(getActivity(), Activity_QrCodeScanner.class), INTENT_QR_CODE);});
        btnOrders.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), Activity_Orders.class));});
        btnService.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), Activity_Service.class));});
    }

    public void shoResult(String message, String result, String pin, boolean isSuccess){
        scanResult.setResult(result);
        scanResult.setResultPIN(pin);
        scanResult.setResultMessage(message);
        scanResult.setSuccess(isSuccess);
        scanResult.showDialog();
    }

    @Override
    public void onSuccessResult(String Pin) {
        shoResult("Transaction Finish Successfully.", "SUCCESS", Pin, true);
    }

    @Override
    public void onFailedResult(String errorMessage) {
        shoResult(errorMessage, "FAILED", "", false);
    }


}
