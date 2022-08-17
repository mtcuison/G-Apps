package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.guanzongroup.marketplace.R;

public class Adapter_ProductQueries extends RecyclerView.Adapter<Adapter_ProductQueries.ViewHolderItem> {

    private final JSONArray loJsonArr;
    private final boolean isOverview;

    public Adapter_ProductQueries(JSONArray foJson, boolean isOverview){
        this.loJsonArr = foJson;
        this.isOverview = isOverview;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product_queries, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            JSONObject loJson = loJsonArr.getJSONObject(position);
            holder.txtClient.setText(loJson.getString("sUserName"));
            holder.txtDatexx.setText(loJson.getString("dCreatedx"));
            holder.txtQueryx.setText(loJson.getString("sQuestion"));
            holder.txtRespnd.setText(loJson.getString("sReplyxxx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if(isOverview) {
            return (loJsonArr.length() < 1) ? loJsonArr.length() : 1;
        } else{
            return loJsonArr.length();
        }
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView txtClient, txtDatexx, txtQueryx, txtRespnd;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            txtClient = itemView.findViewById(R.id.txt_client_name);
            txtDatexx = itemView.findViewById(R.id.txt_date_asked);
            txtQueryx = itemView.findViewById(R.id.txt_query);
            txtRespnd = itemView.findViewById(R.id.txt_response);

        }

    }

}
