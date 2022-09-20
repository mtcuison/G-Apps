package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_OrderedItems extends RecyclerView.Adapter<Adapter_OrderedItems.OrderItemsViewHolder>{

    private final List<DOrderDetail.OrderedItemsInfo> poList;
    private final OnOrderedItemClickListener mListener;
    private final OnItemReviewListener mlistener1;
    private boolean cFrReview = false;

    public interface OnOrderedItemClickListener{
        void OnClick(String args);
    }

    public interface OnItemReviewListener{
        void OnClick(String args);
    }

    public Adapter_OrderedItems(List<DOrderDetail.OrderedItemsInfo> poList, OnOrderedItemClickListener listener, OnItemReviewListener listener1) {
        this.mListener = listener;
        this.mlistener1 = listener1;
        this.poList = poList;
    }

    public void setForReview(boolean fbVal){
        this.cFrReview = fbVal;
    }

    @NonNull
    @Override
    public OrderItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View loView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ordered_items, parent, false);
        return new OrderItemsViewHolder(loView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemsViewHolder holder, int position) {
        DOrderDetail.OrderedItemsInfo loMaster = poList.get(position);
        holder.lblBrandNm.setText(loMaster.xModelNme);
        holder.lblItmPrce.setText(CashFormatter.parse(loMaster.nUnitPrce));
        holder.lblItmQtyx.setText("Quantity: "+loMaster.nQuantity);
        holder.setImage(loMaster.sImagesxx);
        holder.itemView.setOnClickListener(v -> mListener.OnClick(loMaster.sStockIDx));
        holder.btnReview.setOnClickListener(v -> {
            mlistener1.OnClick(loMaster.sListIDxx);
        });

        if(cFrReview){
            holder.btnReview.setVisibility(View.VISIBLE);
        }
        if(loMaster.cReviewed.equalsIgnoreCase("1")){
            holder.lblReviewd.setVisibility(View.VISIBLE);
            holder.btnReview.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return poList.size();
    }

    public static class OrderItemsViewHolder extends RecyclerView.ViewHolder {

        public TextView lblBrandNm,
                lblItmDisc,
                lblItmPrce,
                lblItmQtyx,
                lblReviewd;
        public ImageView imageView;

        public MaterialButton btnReview;

        public OrderItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblBrandNm = itemView.findViewById(R.id.lbl_brandName);
            lblItmDisc = itemView.findViewById(R.id.lbl_itemDiscount);
            lblItmPrce = itemView.findViewById(R.id.lbl_itemPrice);
            lblItmQtyx = itemView.findViewById(R.id.lbl_itemQuantity);
            lblReviewd = itemView.findViewById(R.id.lbl_reviewed);
            btnReview = itemView.findViewById(R.id.btn_review);
            imageView = itemView.findViewById(R.id.img_item);
        }


        public void setImage(String image){
            try {
                JSONArray laJson = new JSONArray(image);
                String lsImgVal = laJson.getJSONObject(0).getString("sImageURL");
                Picasso.get().load(lsImgVal).placeholder(R.drawable.ic_no_image_available)
                        .error(R.drawable.ic_no_image_available).into(imageView);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
