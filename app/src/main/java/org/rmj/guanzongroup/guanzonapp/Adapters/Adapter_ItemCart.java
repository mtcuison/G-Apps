package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.CartItem;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_ItemCart extends RecyclerView.Adapter<Adapter_ItemCart.CartItemViewHolder> {

    private Context mContext;
    private List<CartItem> cartItemList;
    private onDataSetChangeListener onDataSetChangeListener;

    public Adapter_ItemCart(Context context, List<CartItem> cartItemList){
        this.mContext = context;
        this.cartItemList = cartItemList;
    }

    public void setOnDataSetChangeListener(Adapter_ItemCart.onDataSetChangeListener onDataSetChangeListener) {
        this.onDataSetChangeListener = onDataSetChangeListener;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cart_item, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, final int position) {
        holder.cartItem = cartItemList.get(position);
        CartItem cartItem = cartItemList.get(position);
        holder.lblItemName.setText(cartItem.getItemName());
        holder.lblItemPoints.setText(cartItem.getItemPnts());
        holder.lblItemQuantity.setText(cartItem.getQuantity());
        holder.lblItemTotPoints.setText(cartItem.getTotPntsx());
        holder.imgItemImage.setImageBitmap(generateItemImage(cartItem.getItemImgx()));

        holder.btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDataSetChangeListener.onItemDeleteClickListener(cartItemList.get(position).getItemIDxx());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    static class CartItemViewHolder extends RecyclerView.ViewHolder{

        CartItem cartItem;

        TextView lblItemName;
        TextView lblItemPoints;
        TextView lblItemQuantity;
        TextView lblItemTotPoints;
        MaterialButton btnDeleteItem;
        ImageView imgItemImage;

        CartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            lblItemName = itemView.findViewById(R.id.lbl_cart_list_itemName);
            lblItemPoints = itemView.findViewById(R.id.lbl_cart_list_itemPoints);
            lblItemQuantity = itemView.findViewById(R.id.lbl_cart_list_itemQuantity);
            lblItemTotPoints = itemView.findViewById(R.id.lbl_cart_list_itemTotPoints);
            btnDeleteItem = itemView.findViewById(R.id.btn_cart_deleteItem);
            imgItemImage = itemView.findViewById(R.id.img_cart_itemImage);
        }
    }

    private Bitmap generateItemImage(byte[] ImageBlob){
        Bitmap image = null;
        if(ImageBlob!=null) {
            byte[] decoded = Base64.decode(ImageBlob, Base64.NO_WRAP);
            image = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
        } else {
            image = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.sample);
        }
        return image;
    }

    public interface onDataSetChangeListener{
        void onItemDeleteClickListener(String PromoID);
    }
}
