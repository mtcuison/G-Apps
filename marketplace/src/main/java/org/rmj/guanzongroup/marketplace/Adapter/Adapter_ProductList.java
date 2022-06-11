package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_ProductList extends RecyclerView.Adapter<Adapter_ProductList.ViewHolderItem> {

    private final List<EProducts> poProdcts;
    private final OnItemClick poCallBck;

    public Adapter_ProductList(List<EProducts> foProdcts, OnItemClick foCallBck){
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
            EProducts loProduct = poProdcts.get(position);
            holder.sListIdxx = loProduct.getListngID();
            holder.txtProdNm.setText(loProduct.getModelNme());
            holder.txtPricex.setText(CashFormatter.parse(loProduct.getUnitPrce()));
            holder.txtSoldxx.setText(loProduct.getSoldQtyx() + " Sold");
            // TODO: Set product image url ~> Picasso.get().load(stringUrl).into(holder.imgProdct);
            // TODO: Display promo banner if there is any (8:1 aspect ratio)
//            boolean isThereAPromoForThisItem = true;
//            if(isThereAPromoForThisItem) {
//                holder.imgPromox.setVisibility(View.VISIBLE);
//                Picasso.get().load(stringUrl).into(holder.imgPromox);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poProdcts.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public String sListIdxx = "";
        public ImageView imgProdct, imgPromox;
        public TextView txtProdNm, txtPricex, txtSoldxx;

        public ViewHolderItem(@NonNull View itemView, OnItemClick foCallBck) {
            super(itemView);
            imgProdct = itemView.findViewById(R.id.img_product);
            imgPromox = itemView.findViewById(R.id.imgPromox);
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

        public void setImage(String image){
            Picasso.get().load(image).placeholder(R.drawable.ic_no_image_available)
                    .error(R.drawable.ic_no_image_available).into(imgProdct);
        }

    }

    public interface OnItemClick {
        void onClick(String fsListIdx);
    }

    private String ParseImageUrlFromJSOn(String fsVal){
        try{
            JSONObject loJson = new JSONObject(fsVal);
            return loJson.getString("sImageURL");
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}