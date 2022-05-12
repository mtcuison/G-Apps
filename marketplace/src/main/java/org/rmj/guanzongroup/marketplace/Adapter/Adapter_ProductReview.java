package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.marketplace.R;


public class Adapter_ProductReview extends RecyclerView.Adapter<Adapter_ProductReview.ViewHolderItem> {

    private final int pnLimitxx;

    public Adapter_ProductReview(int limit){
        this.pnLimitxx = limit;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_review, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            if(position < pnLimitxx) {
                holder.txtClient.setText("");
                holder.txtDatexx.setText("");
                holder.txtReview.setText("");
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

        public TextView txtClient, txtDatexx, txtReview;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);

            txtClient = itemView.findViewById(R.id.txt_client_name);
            txtDatexx = itemView.findViewById(R.id.txt_date_review);
            txtReview = itemView.findViewById(R.id.txt_review);
        }

    }

}
