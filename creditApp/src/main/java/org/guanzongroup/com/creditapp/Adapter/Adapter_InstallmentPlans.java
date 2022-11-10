package org.guanzongroup.com.creditapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.guanzongroup.com.creditapp.R;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;

import java.util.List;

public class Adapter_InstallmentPlans extends RecyclerView.Adapter<Adapter_InstallmentPlans.PlanViewHolder> {

    private final List<LoanTerm> poPlans;
    private final OnItemClick mListener;

    public interface OnItemClick {
        void onClick(String fsListIdx, String lsDown, String lsAmort);
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

            holder.lblPlanx.setText(loDetail.getsLoanTerm());
            holder.lblAmort.setText("Monthly Payment: " + loDetail.getnMonAmort());

            String lsValue = loDetail.getsLoanTerm();

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(lsValue, loDetail.getnDownPaym(), loDetail.getnMonAmort());
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
        public TextView lblPlanx, lblAmort;

        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            lblPlanx = itemView.findViewById(R.id.lbl_installmentPlan);
            lblAmort = itemView.findViewById(R.id.lbl_amortization);
        }
    }
}
