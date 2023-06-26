package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.digitalgcard.R;

import java.util.List;

public class Adapter_GCardLedger extends RecyclerView.Adapter<Adapter_GCardLedger.LedgerViewHolder> {

//    private final List<EGCardTransactionLedger> poList;
//
//    public Adapter_GCardLedger(List<EGCardTransactionLedger> poList) {
//        this.poList = poList;
//    }

    @NonNull
    @Override
    public LedgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gcard_ledger, parent, false);
        return new LedgerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LedgerViewHolder holder, int position) {
//        EGCardTransactionLedger loLedger = poList.get(position);
//        holder.lblReferNox.setText(loLedger.getReferNox());
//        holder.lblTranType.setText(loLedger.getSourceDs());
//        holder.lblPointsxx.setText(String.valueOf(loLedger.getPointsxx()));
//        holder.lblDateTime.setText(loLedger.getTransact());
//        holder.lblDescript.setText(loLedger.getTranType());
    }

    @Override
    public int getItemCount() {
//        return poList.size();
        return 0;
    }

    static class LedgerViewHolder extends RecyclerView.ViewHolder{

        TextView lblReferNox;
        TextView lblTranType;
        TextView lblPointsxx;
        TextView lblDateTime;
        TextView lblDescript;

        public LedgerViewHolder(@NonNull View itemView) {
            super(itemView);

            lblReferNox = itemView.findViewById(R.id.lbl_ledger_transno);
            lblTranType = itemView.findViewById(R.id.lbl_ledger_trantype);
            lblPointsxx = itemView.findViewById(R.id.lbl_ledger_points);
            lblDateTime = itemView.findViewById(R.id.lbl_ledger_datetime);
            lblDescript = itemView.findViewById(R.id.lbl_ledger_desc);
        }
    }
}
