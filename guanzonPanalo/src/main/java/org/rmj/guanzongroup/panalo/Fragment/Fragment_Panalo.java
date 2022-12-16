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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.SliderView;

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

    private CardView cvRebate, cvToken;
    private RecyclerView rcRebate, rcToken;

    public static Fragment_Panalo newInstance() {
        return new Fragment_Panalo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMPanalo.class);
        View view = inflater.inflate(R.layout.fragment_panalo, container, false);

        cvRebate = view.findViewById(R.id.cv_rebate);
        cvToken = view.findViewById(R.id.cv_token);

        rcRebate = view.findViewById(R.id.recyclerView_rebates);
        rcToken = view.findViewById(R.id.recyclerView_token);

        LinearLayoutManager loManager;

        loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        rcRebate.setLayoutManager(loManager);

        loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        rcToken.setLayoutManager(loManager);

        List<PanaloRewards> loRewards;

        loRewards = new ArrayList<>();
        PanaloRewards loReward;
        loReward = new PanaloRewards();
        loReward.setsRewardTp("Monthly Payment Rebate");
        loReward.setsRewardNm("Php. 100.00");
        loReward.setsAmountxx(100.00);
        loReward.setsReferNox("MX01220001");
        loReward.setsQuantity(3);
        loReward.setsValidFrm("2023-01-01");
        loReward.setsValidThr("2023-03-30");
        loRewards.add(loReward);

        loReward = new PanaloRewards();
        loReward.setsRewardTp("Monthly Payment Rebate");
        loReward.setsRewardNm("Php. 50.00");
        loReward.setsAmountxx(50.00);
        loReward.setsReferNox("MX01220002");
        loReward.setsQuantity(3);
        loReward.setsValidFrm("2023-01-01");
        loReward.setsValidThr("2023-03-30");
        loRewards.add(loReward);

        rcRebate.setAdapter(new AdapterPanaloRewards(loRewards, args -> {
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

        loRewards = new ArrayList<>();
        loReward = new PanaloRewards();
        loReward.setsRewardTp("Guanzon Token");
        loReward.setsRewardNm("Guanzon Connect Shirt");
        loReward.setsAmountxx(0.0);
        loReward.setsReferNox("MX01220003");
        loReward.setsQuantity(1);
        loReward.setsValidFrm("2023-01-01");
        loReward.setsValidThr("2023-01-37");
        loRewards.add(loReward);

        rcToken.setAdapter(new AdapterPanaloRewards(loRewards, args -> {
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
        return view;
    }
}