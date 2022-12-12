package org.rmj.guanzongroup.panalo.Fragment;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.rmj.g3appdriver.dev.Database.Entities.EPanaloReward;
import org.rmj.g3appdriver.lib.Promotions.Adapter_ImageSlider;
import org.rmj.g3appdriver.lib.Promotions.model.HomeImageSliderModel;
import org.rmj.guanzongroup.panalo.Dialog.PanaloDialog;
import org.rmj.guanzongroup.panalo.Dialog.PanaloDialogClickListener;
import org.rmj.guanzongroup.panalo.Dialog.iDialog;
import org.rmj.guanzongroup.panalo.R;
import org.rmj.guanzongroup.panalo.ViewModel.VMPanalo;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Panalo extends Fragment {
    private static final String TAG = Fragment_Panalo.class.getSimpleName();

    private VMPanalo mViewModel;

    private SliderView poSliderx;
    private CardView cvPanalo;
    private CardView cvGanado;

    public static Fragment_Panalo newInstance() {
        return new Fragment_Panalo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMPanalo.class);
        View view = inflater.inflate(R.layout.fragment_panalo, container, false);
        initViews(view);
        setSliderImages();
        setupPanaloBanner();
        return view;
    }

    private void initViews(View v){
        poSliderx = v.findViewById(R.id.imgSlider);
        poSliderx.setIndicatorAnimation(IndicatorAnimationType.WORM);
        poSliderx.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        poSliderx.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        poSliderx.setIndicatorSelectedColor(Color.WHITE);
        poSliderx.setIndicatorUnselectedColor(Color.GRAY);
        poSliderx.setScrollTimeInSec(5);
        poSliderx.startAutoCycle();

        cvPanalo = v.findViewById(R.id.cv_panaloBanner);
        cvGanado = v.findViewById(R.id.cv_ganadoBanner);
    }

    private void setSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        mViewModel.getPromotions().observe(getViewLifecycleOwner(), ePromos -> {
            try {
                for (int x = 0; x < ePromos.size(); x++) {
                    loSliders.add(new HomeImageSliderModel(ePromos.get(x).getImageSld()));
                }

                Adapter_ImageSlider adapter = new Adapter_ImageSlider(loSliders, args -> {
                    try{
                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                        intent.putExtra("url_link", ePromos.get(args).getPromoUrl());
                        intent.putExtra("browser_args", "1");
                        intent.putExtra("args", "promo");
                        requireActivity().sendBroadcast(intent);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
                poSliderx.setSliderAdapter(adapter);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void setupPanaloBanner(){
        mViewModel.GetPanaloNotice().observe(getViewLifecycleOwner(), ePanaloReward -> {
            try{
                View.OnClickListener listener;
                iDialog loDialog;
                if(ePanaloReward == null){
                    loDialog = new PanaloDialog(requireActivity()).InitDialog("0");
                    listener = v -> {
                        loDialog.initDialog(null, new PanaloDialogClickListener() {
                            @Override
                            public void OnClose(AlertDialog dialog) {
                                dialog.dismiss();
                            }

                            @Override
                            public void OnClaim() {

                            }

                            @Override
                            public void OnClickRedeem(String args) {

                            }
                        });
                        loDialog.show();
                    };
                } else {
                    switch (ePanaloReward.getTranStat()) {
                        case "0":
                            loDialog = new PanaloDialog(requireActivity()).InitDialog(ePanaloReward.getTranStat());
                            listener = v -> {
                                loDialog.initDialog(null, new PanaloDialogClickListener() {
                                    @Override
                                    public void OnClose(AlertDialog dialog) {
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void OnClaim() {

                                    }

                                    @Override
                                    public void OnClickRedeem(String args) {

                                    }
                                });
                                loDialog.show();
                            };
                            Log.d(TAG, "No rewards yet!");
                            break;
                        case "1":
                            loDialog = new PanaloDialog(requireActivity()).InitDialog(ePanaloReward.getTranStat());
                            listener = v -> {
                                loDialog.initDialog(null, new PanaloDialogClickListener() {
                                    @Override
                                    public void OnClose(AlertDialog dialog) {
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void OnClaim() {

                                    }

                                    @Override
                                    public void OnClickRedeem(String args) {

                                    }
                                });
                                loDialog.show();
                            };
                            Log.d(TAG, "Rewards receive");
                            break;
                        case "2":
                            loDialog = new PanaloDialog(requireActivity()).InitDialog(ePanaloReward.getTranStat());
                            listener = v -> {
                                loDialog.initDialog(null, new PanaloDialogClickListener() {
                                    @Override
                                    public void OnClose(AlertDialog dialog) {
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void OnClaim() {

                                    }

                                    @Override
                                    public void OnClickRedeem(String args) {

                                    }
                                });
                                loDialog.show();
                            };
                            Log.d(TAG, "Rewards are ready to claim");
                            break;
                        default:
                            loDialog = new PanaloDialog(requireActivity()).InitDialog(ePanaloReward.getTranStat());
                            listener = v -> {
                                loDialog.initDialog(null, new PanaloDialogClickListener() {
                                    @Override
                                    public void OnClose(AlertDialog dialog) {
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void OnClaim() {

                                    }

                                    @Override
                                    public void OnClickRedeem(String args) {

                                    }
                                });
                                loDialog.show();
                            };
                            Log.d(TAG, "Rewards redeemed");
                            break;
                    }
                }
                cvPanalo.setOnClickListener(listener);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}