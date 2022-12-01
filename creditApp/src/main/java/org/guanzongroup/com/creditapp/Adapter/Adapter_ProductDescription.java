package org.guanzongroup.com.creditapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Adapter_ProductDescription extends RecyclerView.Adapter<Adapter_ProductDescription.ViewHolderItem> {

    private final JSONArray poItmDesc;

    public Adapter_ProductDescription(JSONArray foItmDesc){
        this.poItmDesc = foItmDesc;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_description, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        try {
            JSONObject loJson = poItmDesc.getJSONObject(position);
            holder.txtDescrp.setText(Objects.requireNonNull(loJson.getString("sDescript")));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poItmDesc.length();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView txtDescrp;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            this.txtDescrp = itemView.findViewById(R.id.txt_description);
        }

    }

}
