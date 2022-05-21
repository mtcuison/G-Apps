package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_ItemCart extends RecyclerView.Adapter<Adapter_ItemCart.OrderHolder> {

    private final List<ItemCartModel> poCart;
    private final OnCartAction poCallBck;

    public Adapter_ItemCart(List<ItemCartModel> foCart, OnCartAction foCallBck) {
        this.poCart = foCart;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_cart, parent, false);
        return new OrderHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        ItemCartModel loCart = poCart.get(position);
        holder.lsListIdx = loCart.getListingId();
        holder.lblItemName.setText(loCart.getItemName());
        holder.lblItemPrice.setText("₱ " + loCart.getItemPrice());
        holder.lblItemQty.setText(loCart.getItemQty());
        if(!loCart.isMarket()){
            holder.setImage(loCart.getItemImage());
        }
    }

    @Override
    public int getItemCount() {
        return poCart.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{
        public String lsListIdx = "";
        public CheckBox checkBox;
        public TextView lblItemName;
        public TextView lblItemPrice;
        public TextView lblItemQty;
        public ImageView imgItem;

        public OrderHolder(@NonNull View itemView, OnCartAction foCallBck) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            lblItemName = itemView.findViewById(R.id.lblProdNme);
            lblItemPrice = itemView.findViewById(R.id.lblProdPrice);
            lblItemQty = itemView.findViewById(R.id.lblQty);
            imgItem = itemView.findViewById(R.id.imgProduct);


            checkBox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
                if(isChecked) {
                    foCallBck.onItemSelect(lsListIdx);
                } else {
                    foCallBck.onItemDeselect(lsListIdx);
                }
            }));

        }

        public void setImage(String image){
            Picasso.get().load(image).placeholder(R.drawable.ic_no_image_available)
                    .error(R.drawable.ic_no_image_available).into(imgItem);
        }

    }

    public interface OnCartAction {
        void onItemSelect(String fsListIdx);
        void onItemDeselect(String fsListIdx);
    }

}
