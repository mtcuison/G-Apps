package org.rmj.guanzongroup.panalo.Fragment;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderView;

import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;
import org.rmj.g3appdriver.lib.Panalo.PanaloRewards;
import org.rmj.guanzongroup.panalo.Adapter.AdapterPanaloRewards;
import org.rmj.guanzongroup.panalo.Dialog.DialogPanaloRedeem;
import org.rmj.guanzongroup.panalo.Dialog.PanaloDialogClickListener;
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

    private TabLayout tabLayout;
    private CardView cvRebate;
    private RecyclerView rcRewards;

    private VMPanalo.OnImportPanaloRewards poListener;

    public static Fragment_Panalo newInstance() {
        return new Fragment_Panalo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMPanalo.class);
        View view = inflater.inflate(R.layout.fragment_panalo, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Rewards Earn"));
        tabLayout.addTab(tabLayout.newTab().setText("Redeemed"));
        cvRebate = view.findViewById(R.id.cv_rebate);
        rcRewards = view.findViewById(R.id.recyclerView_rebates);
        LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        rcRewards.setLayoutManager(loManager);

        poListener = new VMPanalo.OnImportPanaloRewards() {
            @Override
            public void OnImport() {
                view.findViewById(R.id.cv_rebate).setVisibility(View.GONE);
                view.findViewById(R.id.lbl_NoRewardYet).setVisibility(View.GONE);
                view.findViewById(R.id.linear_loading).setVisibility(View.VISIBLE);
            }

            @Override
            public void OnSuccess(List<PanaloRewards> rewards) {
                view.findViewById(R.id.cv_rebate).setVisibility(View.VISIBLE);
                view.findViewById(R.id.linear_loading).setVisibility(View.GONE);
                if(rewards.size() > 0){
                    view.findViewById(R.id.lbl_NoRewardYet).setVisibility(View.GONE);
                } else {
                    view.findViewById(R.id.lbl_NoRewardYet).setVisibility(View.VISIBLE);
                }

                rcRewards.setAdapter(new AdapterPanaloRewards(rewards, args -> {
                    DialogPanaloRedeem loRedeem = new DialogPanaloRedeem(requireActivity());
                    loRedeem.initDialog(args, new PanaloDialogClickListener() {
                        @Override
                        public void OnClose(AlertDialog dialog) {
                            dialog.dismiss();
                        }

                        @Override
                        public void OnClaim() {

                        }
                    });
                    loRedeem.show();
                }));
            }

            @Override
            public void OnFailed(String message) {
                view.findViewById(R.id.cv_rebate).setVisibility(View.GONE);
                view.findViewById(R.id.linear_loading).setVisibility(View.GONE);
                view.findViewById(R.id.lbl_NoRewardYet).setVisibility(View.VISIBLE);
            }
        };

        ImportForRewardsForClaiming();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        ImportForRewardsForClaiming();
                        break;
                    default:
                        ImportRedeemRewards();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void ImportForRewardsForClaiming(){
        Log.d(TAG, "Importing rewards for claiming");
        mViewModel.ImportPanaloRewards("0", poListener);
    }

    private void ImportRedeemRewards(){
        Log.d(TAG, "Importing redeemed rewards");
        mViewModel.ImportPanaloRewards("1", poListener);
    }
}