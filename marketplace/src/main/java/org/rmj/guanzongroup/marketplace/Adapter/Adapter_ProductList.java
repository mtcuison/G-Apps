package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.marketplace.R;

public class Adapter_ProductList extends RecyclerView.Adapter<Adapter_ProductList.ViewHolderItem> {

    private final OnItemClick poCallBck;

    public Adapter_ProductList(OnItemClick foCallBck){
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_list, parent, false);
        return new ViewHolderItem(viewItem, poCallBck);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public ImageView imgProdct;
        public TextView txtProdNm, txtPricex, txtSoldxx;

        public ViewHolderItem(@NonNull View itemView, OnItemClick foCallBck) {
            super(itemView);
            imgProdct = itemView.findViewById(R.id.img_product);
            txtProdNm = itemView.findViewById(R.id.txt_product_name);
            txtPricex = itemView.findViewById(R.id.txt_product_price);
            txtSoldxx = itemView.findViewById(R.id.txt_product_sold_count);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    foCallBck.onClick(position);
                }
            });
        }

    }

    public interface OnItemClick {
        void onClick(int position);
    }

}