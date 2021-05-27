package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Transactions;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_Transactions extends RecyclerView.Adapter<Adapter_Transactions.TransactionsViewHolder> {

    private List<Transactions> transactionsList;

    public Adapter_Transactions(List<Transactions> transactionsList){
        this.transactionsList = transactionsList;
    }

    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_transactions, parent, false);
        return new TransactionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder holder, int position) {
        holder.lblReferNox.setText(transactionsList.get(position).getReferNox());
        holder.lblPointsxx.setText(transactionsList.get(position).getPointsxx());
        holder.lblDateTime.setText(transactionsList.get(position).getDateTime());
        holder.lblTranType.setText(transactionsList.get(position).getTransact());
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    static class TransactionsViewHolder extends RecyclerView.ViewHolder{

        private TextView lblReferNox;
        private TextView lblDateTime;
        private TextView lblPointsxx;
        private TextView lblTranType;

        TransactionsViewHolder(@NonNull View itemView) {
            super(itemView);

            lblReferNox = itemView.findViewById(R.id.lbl_list_item_transactions_refernox);
            lblDateTime = itemView.findViewById(R.id.lbl_list_item_transactions_datetime);
            lblPointsxx = itemView.findViewById(R.id.lbl_list_item_transactions_points);
            lblTranType = itemView.findViewById(R.id.lbl_list_item_transactions_entryType);
        }
    }
}
