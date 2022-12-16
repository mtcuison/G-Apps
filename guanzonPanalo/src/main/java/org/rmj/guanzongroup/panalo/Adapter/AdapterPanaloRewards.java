package org.rmj.guanzongroup.panalo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.lib.Panalo.PanaloRewards;
import org.rmj.guanzongroup.panalo.R;

import java.util.List;

public class AdapterPanaloRewards extends RecyclerView.Adapter<AdapterPanaloRewards.RewardsViewHolder> {

    private final List<PanaloRewards> poRewards;
    private final OnUseReward mListener;

    public interface OnUseReward{
        void OnUse(PanaloRewards args);
    }

    public AdapterPanaloRewards(List<PanaloRewards> poRewards, OnUseReward listener) {
        this.poRewards = poRewards;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_g_panalo_reward, parent, false);
        return new RewardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardsViewHolder holder, int position) {
        try{
            PanaloRewards loReward = poRewards.get(position);
            holder.lblType.setText(loReward.getsRewardTp());
            holder.lblName.setText(loReward.getsRewardNm());
            holder.lblQtyx.setText("Qty: " + loReward.getsQuantity());
            holder.lblVldt.setText("Validity: " + loReward.getsValidFrm() + " - " + loReward.getsValidThr());

            holder.btnRedeem.setOnClickListener(v -> mListener.OnUse(loReward));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poRewards.size();
    }

    public static class RewardsViewHolder extends RecyclerView.ViewHolder{

        public TextView lblType,
                lblName,
                lblQtyx,
                lblVldt;
        public MaterialButton btnRedeem;

        public RewardsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblType = itemView.findViewById(R.id.lblRewardType);
            lblName = itemView.findViewById(R.id.lblRewardName);
            lblQtyx = itemView.findViewById(R.id.lbl_Quantity);
            lblVldt = itemView.findViewById(R.id.lblvalidityDates);
            btnRedeem = itemView.findViewById(R.id.btn_dialogClaim);
        }
    }
}
