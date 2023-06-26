package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;


public class Adapter_OrderList extends RecyclerView.Adapter<Adapter_OrderList.ViewHolderItem> {

//    private final List<DItemCart.oMarketplaceCartItem> poItemsxx;

//    public Adapter_OrderList(List<DItemCart.oMarketplaceCartItem> foItemsxx){
//        this.poItemsxx = foItemsxx;
//    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_order_list, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
//        try {
//            DItemCart.oMarketplaceCartItem loItemxxx = poItemsxx.get(position);
//            holder.txtProdNm.setText(loItemxxx.xModelNme);
//            holder.txtPricex.setText(CashFormatter.parse(loItemxxx.nUnitPrce));
//            holder.txtItemQt.setText("Qty: " + loItemxxx.nQuantity);
//            holder.setImage(loItemxxx.sImagesxx);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
//        return poItemsxx.size();
        return 0;
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

        public void setImage(String image){
            try {
                JSONArray laJson = new JSONArray(image);
                String lsImgVal = laJson.getJSONObject(0).getString("sImageURL");
                Picasso.get().load(lsImgVal).placeholder(R.drawable.ic_no_image_available)
                        .error(R.drawable.ic_no_image_available).into(imgProdct);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
