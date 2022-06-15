package org.rmj.guanzongroup.marketplace.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.guanzongroup.marketplace.R;


public class Adapter_ProductReview extends RecyclerView.Adapter<Adapter_ProductReview.ViewHolderItem> {

    private final JSONArray loArray;
    private final boolean isOverview;

    public Adapter_ProductReview(JSONArray loArray, boolean isOverview){
        this.loArray = loArray;
        this.isOverview = isOverview;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_review, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            JSONObject loJson = loArray.getJSONObject(position);
            holder.psEntryNo = loJson.getString("nEntryNox");
            holder.poRatings.setRating(Integer.parseInt(loJson.getString("nRatingxx")));
            holder.txtClient.setText(loJson.getString("sUserName"));
            holder.txtDatexx.setText(loJson.getString("dCreatedx"));
            holder.txtReview.setText(loJson.getString("sRemarksx"));
            holder.txtReplyx.setText(loJson.getString("sReplyxxx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if(isOverview) {
            return (loArray.length() < 4) ? loArray.length() : 4;
        } else{
            return loArray.length();
        }
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public String psEntryNo= "";
        public RatingBar poRatings;
        public TextView txtClient, txtDatexx, txtReview, txtReplyx;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            poRatings = itemView.findViewById(R.id.ratings);
            txtClient = itemView.findViewById(R.id.txt_client_name);
            txtDatexx = itemView.findViewById(R.id.txt_date_review);
            txtReview = itemView.findViewById(R.id.txt_review);
            txtReplyx = itemView.findViewById(R.id.txt_response);
        }

    }

}
