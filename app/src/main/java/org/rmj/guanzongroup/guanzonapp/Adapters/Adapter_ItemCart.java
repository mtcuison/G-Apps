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
import com.squareup.picasso.Picasso;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_ItemCart extends RecyclerView.Adapter<Adapter_ItemCart.CartItemViewHolder> {

    private Context mContext;
    private List<DRedeemItemInfo.CartItemsDetail> poItems;
    private OnItemChangeListener mListener;

    public Adapter_ItemCart(Context context, List<DRedeemItemInfo.CartItemsDetail> foCartItm, OnItemChangeListener mListener){
        this.mContext = context;
        this.poItems = foCartItm;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cart_item, parent, false);
        return new CartItemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, final int position) {
        DRedeemItemInfo.CartItemsDetail loItem = poItems.get(position);
        holder.lblItemName.setText(loItem.sPromoDsc);
        holder.lblItemPoints.setText(String.valueOf(loItem.origPoints));
        holder.lblItemQuantity.setText(String.valueOf(loItem.nItemQtyx));
        holder.lblItemTotPoints.setText(String.valueOf(loItem.nPointsxx));
        holder.imgItemImage.setImageBitmap(generateItemImage(loItem.sImageUrl.getBytes()));
        holder.imgRedeemableView(loItem.sImageUrl);
        holder.btnDeleteItem.setOnClickListener(v -> mListener.onItemRemove(loItem.sGCardNox, loItem.sAvlPoint, loItem.sPromoIDx, loItem.nPointsxx));
    }

    @Override
    public int getItemCount() {
        return poItems.size();
    }

    static class CartItemViewHolder extends RecyclerView.ViewHolder{

        TextView lblItemName;
        TextView lblItemPoints;
        TextView lblItemQuantity;
        TextView lblItemTotPoints;
        MaterialButton btnDeleteItem;
        ImageView imgItemImage;

        CartItemViewHolder(@NonNull View itemView, OnItemChangeListener mListener) {
            super(itemView);
            lblItemName = itemView.findViewById(R.id.lbl_cart_list_itemName);
            lblItemPoints = itemView.findViewById(R.id.lbl_cart_list_itemPoints);
            lblItemQuantity = itemView.findViewById(R.id.lbl_cart_list_itemQuantity);
            lblItemTotPoints = itemView.findViewById(R.id.lbl_cart_list_itemTotPoints);
            btnDeleteItem = itemView.findViewById(R.id.btn_cart_deleteItem);
            imgItemImage = itemView.findViewById(R.id.img_cart_itemImage);
        }

        public void imgRedeemableView(String imageUrl) {
            Picasso.get().load(imageUrl).placeholder(R.drawable.no_img_available)
                    .error(R.drawable.no_img_available).into(imgItemImage);
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

    public interface OnItemChangeListener{
        void onItemRemove(String fsGcardNo, String fsGcardPt, String fsPromoId, double fnRefundx);
    }
}
