package org.rmj.guanzongroup.useraccount.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.databinding.AdapterShippingAddressBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter_ShippingAddress extends RecyclerView.Adapter<Adapter_ShippingAddress.ItemViewHolder> {

    private final List<EClientInfo> poClientx;

    public Adapter_ShippingAddress(List<EClientInfo> foClientx) {
        this.poClientx = foClientx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_shipping_address, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            EClientInfo loClientx = poClientx.get(position);
            String lsClientN = loClientx.getFrstName() + " " + loClientx.getMiddName().charAt(0) +
                    ". " + loClientx.getLastName();
            String lsAddress = loClientx.getHouseNox() + " " + loClientx.getAddressx() +
                    ", " + loClientx.getTownIDxx();
            holder.txtClient.setText(lsClientN);
            holder.txtMobile.setText(loClientx.getMobileNo());
            holder.txtAddrss.setText(lsAddress);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poClientx.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView txtClient;
        public TextView txtMobile;
        public TextView txtAddrss;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClient = itemView.findViewById(R.id.txtClient);
            txtMobile = itemView.findViewById(R.id.txtMobile);
            txtAddrss = itemView.findViewById(R.id.txtAddrss);
        }

    }

    public interface OnSettingsMenuSelection {
        void onClick(int position);
    }


}
