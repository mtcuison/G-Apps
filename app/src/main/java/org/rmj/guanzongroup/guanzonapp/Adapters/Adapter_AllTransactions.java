package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_AllTransactions extends RecyclerView.Adapter<Adapter_AllTransactions.TransactionsViewHolder> {

    private List<EGCardTransactionLedger> all_transactionsList;
    public Adapter_AllTransactions(List<EGCardTransactionLedger> all_transactionsList){
        this.all_transactionsList = all_transactionsList;
    }

    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_all_transactions, parent, false);
        return new TransactionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder holder, int position) {
        holder.lblReferNox.setText(all_transactionsList.get(position).getReferNox());
        holder.lblTranType.setText(all_transactionsList.get(position).getTranType());
        holder.lblPointsxx.setText(String.valueOf(all_transactionsList.get(position).getPointsxx()));
        holder.lblDateTime.setText(all_transactionsList.get(position).getTransact());
    }

    @Override
    public int getItemCount() {
        return all_transactionsList.size();
    }

    static class TransactionsViewHolder extends RecyclerView.ViewHolder{

        TextView lblReferNox;
        TextView lblTranType;
        TextView lblPointsxx;
        TextView lblDateTime;

        TransactionsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblReferNox = itemView.findViewById(R.id.lbl_all_transaction_referno_list);
            lblTranType = itemView.findViewById(R.id.lbl_all_transaction_trantype_list);
            lblPointsxx = itemView.findViewById(R.id.lbl_all_transaction_points_list);
            lblDateTime = itemView.findViewById(R.id.lbl_all_transaction_dateTime_list);
        }
    }
}
