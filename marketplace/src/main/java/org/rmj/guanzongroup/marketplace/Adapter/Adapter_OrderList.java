package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;


public class Adapter_OrderList extends RecyclerView.Adapter<Adapter_OrderList.ViewHolderItem> {

    private final List<DItemCart.oMarketplaceCartItem> poItemsxx;


    public Adapter_OrderList(List<DItemCart.oMarketplaceCartItem> foItemsxx){
        this.poItemsxx = foItemsxx;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_list, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            DItemCart.oMarketplaceCartItem loItemxxx = poItemsxx.get(position);
//            holder.imgProdct.setImageBitmap();
            holder.txtProdNm.setText(loItemxxx.xModelNme);
            holder.txtPricex.setText(CashFormatter.parse(loItemxxx.nUnitPrce));
            holder.txtItemQt.setText("Qty: " + loItemxxx.nQuantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poItemsxx.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public ImageView imgProdct;
        public TextView txtProdNm, txtPricex, txtItemQt;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            imgProdct = itemView.findViewById(R.id.img_product);
            txtProdNm = itemView.findViewById(R.id.txt_product_name);
            txtPricex = itemView.findViewById(R.id.txt_product_price);
            txtItemQt = itemView.findViewById(R.id.txt_item_quantity);
        }

    }

}
