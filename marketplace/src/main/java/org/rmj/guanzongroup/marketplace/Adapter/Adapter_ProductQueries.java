package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.marketplace.R;

public class Adapter_ProductQueries extends RecyclerView.Adapter<Adapter_ProductQueries.ViewHolderItem> {

    private final int pnLimitxx;

    public Adapter_ProductQueries(int limit){
        this.pnLimitxx = limit;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product_queries, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            if(position < pnLimitxx || pnLimitxx == 0) {
                holder.txtClient.setText("");
                holder.txtDatexx.setText("");
                holder.txtQueryx.setText("");
                holder.txtRespnd.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView txtClient, txtDatexx, txtQueryx, txtRespnd;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            txtClient = itemView.findViewById(R.id.txt_client_name);
            txtDatexx = itemView.findViewById(R.id.txt_date_asked);
            txtQueryx = itemView.findViewById(R.id.txt_query);
            txtRespnd = itemView.findViewById(R.id.txt_response);

        }

    }

}
