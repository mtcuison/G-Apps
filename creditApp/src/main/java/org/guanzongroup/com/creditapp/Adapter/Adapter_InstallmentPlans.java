package org.guanzongroup.com.creditapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;

import java.util.List;

public class Adapter_InstallmentPlans extends RecyclerView.Adapter<Adapter_InstallmentPlans.PlanViewHolder> {

    private final List<LoanTerm> poPlans;
    private final OnItemClick mListener;

    public interface OnItemClick {
        void onClick(String fsListIdx);
    }

    public Adapter_InstallmentPlans(List<LoanTerm> poPlans, OnItemClick mListener) {
        this.poPlans = poPlans;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_loan_term, parent, false);
        return new PlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
        try{
            LoanTerm loDetail = poPlans.get(position);

            holder.lblPlanx.setText(loDetail.getnDiscount());
            holder.lblDownP.setText(loDetail.getnDiscount());
            holder.lblAmort.setText(loDetail.getnDiscount());

            String lsValue = loDetail.getnDiscount();

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(lsValue);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poPlans.size();
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public TextView lblPlanx, lblDownP, lblAmort;

        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            lblPlanx = itemView.findViewById(R.id.lbl_installmentPlan);
            lblDownP = itemView.findViewById(R.id.lbl_downpayment);
            lblAmort = itemView.findViewById(R.id.lbl_amortization);
        }
    }
}
