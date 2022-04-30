package org.rmj.guanzongroup.marketplace.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

public class Adapter_ProductList extends RecyclerView.Adapter<Adapter_ProductList.ViewHolderItem> {

    private final JSONArray poProdcts;
    private final OnItemClick poCallBck;

    public Adapter_ProductList(JSONArray foProdcts, OnItemClick foCallBck){
        this.poProdcts = foProdcts;
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
        try {
            JSONObject loJson = poProdcts.getJSONObject(position);
            holder.sListIdxx = loJson.getString("sListngID");
            holder.txtProdNm.setText(loJson.getString("xModelNme"));
            holder.txtPricex.setText(CashFormatter.parse(loJson.getString("nUnitPrce")));
            holder.txtSoldxx.setText(loJson.getString("nSoldQtyx") + " Sold");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poProdcts.length();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public String sListIdxx = "";
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
                    foCallBck.onClick(sListIdxx);
                }
            });
        }

    }

    public interface OnItemClick {
        void onClick(String fsListIdx);
    }

}