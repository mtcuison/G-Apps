package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;

import android.annotation.SuppressLint;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;

/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment_DashBoard extends Fragment {

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

        setupWidgets();
        setupAnimation();

        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            Username.setText(eClientInfo.getUserName());
            Username.setShadowLayer(2, 1, 1, Color.WHITE);

        });

        mViewModel.getGCardInfo().observe(getViewLifecycleOwner(), gCardApp -> {

            try {
                lblActiveGcardNmbr.setText(gCardApp.getCardNmbr());
                lblAvailablePoints.setText(gCardApp.getAvlPoint());
            }catch (NullPointerException e){
                Log.e(TAG, e.getMessage());
            }
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

//        guanzonLogo_Animated.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!new GcardAppMaster(getActivity()).hasNoGcard()){
//                    new Dialog_GCardCodex(getActivity()).showDialog();
//                }
//            }
//        });

    }


}
