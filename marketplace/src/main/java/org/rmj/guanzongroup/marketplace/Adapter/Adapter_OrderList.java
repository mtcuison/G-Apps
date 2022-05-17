package org.rmj.guanzongroup.marketplace.Adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;


public class Adapter_OrderList extends RecyclerView.Adapter<Adapter_OrderList.ViewHolderItem> {

    private final List<OrderListAdapterModel> poItemsxx;

    public Adapter_OrderList(List<OrderListAdapterModel> foItemsxx){
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
            OrderListAdapterModel loItemxxx = poItemsxx.get(position);
//            holder.imgProdct.setImageBitmap();
            holder.txtProdNm.setText(loItemxxx.fsProdNme);
            holder.txtPricex.setText(loItemxxx.fsPricexx);
            holder.txtItemQt.setText("Qty: " + loItemxxx.fnItemQty);
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

    public static class OrderListAdapterModel {
        public String fsListIdx;
        public Bitmap foImagexx;
        public String fsProdNme;
        public String fsPricexx;
        public int fnItemQty;

        public OrderListAdapterModel(String fsListIdx, Bitmap foImagexx, String fsProdNme,
                String fsPricexx, int fnItemQty) {
            this.fsListIdx = fsListIdx;
            this.foImagexx = foImagexx;
            this.fsProdNme = fsProdNme;
            this.fsPricexx = fsPricexx;
            this.fnItemQty =fnItemQty;
        }
    }

}
