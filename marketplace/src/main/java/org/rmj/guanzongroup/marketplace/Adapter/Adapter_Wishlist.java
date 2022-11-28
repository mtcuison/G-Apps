package org.rmj.guanzongroup.marketplace.Adapter;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.marketplace.Model.WishListModel;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_Wishlist extends RecyclerView.Adapter<Adapter_Wishlist.OrderHolder> {

    private final List<WishListModel> poWish;
    private final OnCartAction poCallBck;

    public Adapter_Wishlist(List<WishListModel> foCart, OnCartAction foCallBck) {
        this.poWish = foCart;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_wishlist, parent, false);
        return new OrderHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        WishListModel loWist = poWish.get(position);
        holder.lsItemIdx = "1010";
        holder.lblItemName.setText(loWist.getWishName());
        holder.lblItemPrice.setText("₱ " + loWist.getWishPrice());
        holder.lblItemPercent.setText(" - " + loWist.getWishPercent() + "%");
        holder.lblItemPriceDrop.setPaintFlags(holder.lblItemPriceDrop.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.lblItemPriceDrop.setText("₱ " + loWist.getWishPriceDrop());
        holder.setImage(loWist.getWishImage());
    }

    @Override
    public int getItemCount() {
        return poWish.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{

        public String lsItemIdx;
        public TextView lblItemName;
        public TextView lblItemPrice;
        public TextView lblItemPriceDrop;
        public TextView lblItemPercent;
        public ImageView imgItem;
        public ImageButton imgRemove, imgAddCart;

        public OrderHolder(@NonNull View itemView, OnCartAction foCallBck) {
            super(itemView);
            lblItemName = itemView.findViewById(R.id.lblWishProdNme);
            lblItemPrice = itemView.findViewById(R.id.lblWishProdPrice);
            lblItemPriceDrop = itemView.findViewById(R.id.lblWishProdPrice1);
            lblItemPercent = itemView.findViewById(R.id.lblWishPercent);
            imgItem = itemView.findViewById(R.id.imgWishProduct);
            imgRemove = itemView.findViewById(R.id.removeItem);
            imgAddCart = itemView.findViewById(R.id.addToCart);

            imgAddCart.setOnClickListener(v -> {
                foCallBck.onAddToCart(lsItemIdx, lblItemName.getText().toString(), lblItemPrice.getText().toString());
            });

            imgRemove.setOnClickListener(v -> {
                foCallBck.onRemoveToCart(lsItemIdx);
            });

//            lblStActv.setOnClickListener(v -> {
//                foCallBck.onActivate(txtCardNo.getText().toString().trim());
//            });
        }
        public void setImage(String image){
            Picasso.get().load(image).placeholder(R.drawable.ic_no_image_available)
                    .error(R.drawable.ic_no_image_available).into(imgItem);
        }

    }

    public interface OnCartAction {
        void onAddToCart(String fsListIdx, String fsItemNme, String fsItemPrc);
        void onRemoveToCart(String fsListIdx);
    }

}
