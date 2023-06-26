package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.digitalgcard.Dialogs.BottomCartDialog;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.List;

public class Adapter_Redeemables extends RecyclerView.Adapter<Adapter_Redeemables.ViewHolderItem> {

//    private final List<ERedeemablesInfo> poRedeems;
//    private final OnItemClick poCallBck;
//    private final Context mContext;
//    public Adapter_Redeemables(Context context,List<ERedeemablesInfo> foProdcts, OnItemClick foCallBck){
//        this.poRedeems = foProdcts;
//        this.poCallBck = foCallBck;
//        this.mContext = context;
//    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.redeemables_item, parent, false);
//        return new ViewHolderItem(viewItem, poCallBck);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
//        try {
//            ERedeemablesInfo loProduct = poRedeems.get(position);
//            holder.sPromoCode = loProduct.getPromoCde();
//            holder.lblProdNm.setText(loProduct.getPromoDsc());
//            holder.lblPricex.setText(String.valueOf(loProduct.getPointsxx()));
//            holder.setImage(loProduct.getImageUrl());
//            holder.btnAddToCart.setOnClickListener(view -> {
//                BottomCartDialog bottomSheet = new BottomCartDialog();
//                bottomSheet.setCancelable(false);
//                bottomSheet.setItemTransNox(loProduct.getTransNox());
//                bottomSheet.setItemPromCode(loProduct.getPromoCde());
//                bottomSheet.setItemNamex(loProduct.getPromoDsc());
//                bottomSheet.setItemPntsx(loProduct.getPointsxx());
//                bottomSheet.show(((AppCompatActivity)mContext).getSupportFragmentManager(), "Redeemable Bottom Sheet");
//
//            });
////            holder.lblSoldxx.setText(loProduct.getSoldQtyx() + " Sold");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
//        return poRedeems.size();
        return 0;
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public String sPromoCode = "";
        public ImageView imgProdct;
        public TextView lblProdNm, lblPricex, lblSoldxx;
        public ImageButton btnAddToCart;
        public ViewHolderItem(@NonNull View itemView, OnItemClick foCallBck) {
            super(itemView);
            imgProdct = itemView.findViewById(R.id.img_product);
            lblProdNm = itemView.findViewById(R.id.lbl_product_name);
            lblPricex = itemView.findViewById(R.id.lbl_product_price);
            btnAddToCart = itemView.findViewById(R.id.btn_list_item_add_to_cart);
//            lblSoldxx = itemView.findViewById(R.id.lbl_product_sold_count);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    foCallBck.onClick(sPromoCode);
                }
            });
        }

        public void setImage(String image){
            Picasso.get().load(image).placeholder(R.drawable.progress_animation)
                    .error(R.drawable.ic_no_image_available).into(imgProdct);
//            Glide
//                .with(context)
//                .load(image)
////                .centerCrop()
//                .placeholder(R.drawable.progress_animation)
//                .error(R.drawable.try_later)
//                .into(imgPromo);

        }

    }

    public interface OnItemClick {
        void onClick(String fsListIdx);
        void addToCart();
    }

}