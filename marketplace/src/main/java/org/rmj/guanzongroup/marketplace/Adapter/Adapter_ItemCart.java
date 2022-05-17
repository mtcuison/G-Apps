package org.rmj.guanzongroup.marketplace.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_ItemCart extends RecyclerView.Adapter<Adapter_ItemCart.OrderHolder> {
    private String TAG = Adapter_ItemCart.class.getSimpleName();
    private final List<DRedeemItemInfo.GCardCartItem> poCart;
    private final OnCartAction poCallBck;

    public Adapter_ItemCart(List<DRedeemItemInfo.GCardCartItem> foCart, OnCartAction foCallBck) {
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
        DRedeemItemInfo.GCardCartItem loCart = poCart.get(position);
        holder.lblItemName.setText(loCart.sPromoDsc);
        holder.lblItemPrice.setText(loCart.nPointsxx + " point/s");
        holder.lblItemQty.setText(loCart.nItemQtyx);
        holder.setImage(loCart.sImageUrl);
    }

    @Override
    public int getItemCount() {
        return poCart.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{

        public TextView lblItemName;
        public TextView lblItemPrice;
        public TextView lblItemQty;
        public ImageView imgItem;

        public OrderHolder(@NonNull View itemView, OnCartAction foCallBck) {
            super(itemView);
            lblItemName = itemView.findViewById(R.id.lblProdNme);
            lblItemPrice = itemView.findViewById(R.id.lblProdPrice);
            lblItemQty = itemView.findViewById(R.id.lblQty);
            imgItem = itemView.findViewById(R.id.imgProduct);


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
        void onClickAction(String val);
    }

}
