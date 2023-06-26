package org.rmj.guanzongroup.useraccount.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.useraccount.R;

import java.util.List;

public class Adapter_ShippingAddress extends RecyclerView.Adapter<Adapter_ShippingAddress.ItemViewHolder> {

    private final List<Address> poClientx;
    private final OnChangeAddressListener mListener;

    public interface OnChangeAddressListener{
        void OnChangeAddress(int position);
    }

    public Adapter_ShippingAddress(List<Address> foClientx, OnChangeAddressListener listener) {
        this.poClientx = foClientx;
        this.mListener = listener;
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
            Address loClientx = poClientx.get(position);
//            holder.txtAddress.setText();
            String lsAddress = "";
            if(!loClientx.getHouseNo().trim().isEmpty()){
                lsAddress = lsAddress + loClientx.lsHouseNo + ", ";
            }
            if(!loClientx.getAddress().trim().isEmpty()){
                lsAddress = lsAddress + loClientx.getAddress() + ", ";
            }
            lsAddress = lsAddress + loClientx.getBarangay() + ", " + loClientx.getTownName();
            holder.txtBrgyNmx.setText(lsAddress);
            if(loClientx.lcShippx){
                holder.txtHouseNo.setText("Shipping Address");
            } else {
                holder.txtHouseNo.setText("Billing Address");
            }
            holder.txtChange.setOnClickListener(v -> mListener.OnChangeAddress(position));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poClientx.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView txtHouseNo;
        public TextView txtAddress;
        public TextView txtBrgyNmx;
        public TextView txtChange;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHouseNo = itemView.findViewById(R.id.txtClient);
            txtAddress = itemView.findViewById(R.id.txtMobile);
            txtBrgyNmx = itemView.findViewById(R.id.txtAddrss);
            txtChange = itemView.findViewById(R.id.lblChange);
        }

    }

    public interface OnSettingsMenuSelection {
        void onClick(int position);
    }


    public static class Address{
        private final boolean lcShippx;
        private final String lsHouseNo,
                        lsAddress,
                        lsBrgyNmx,
                        lsTownNmx;

        public Address(boolean fbArgs, String lsHouseNo, String lsAddress, String lsBrgyNmx, String lsTownNmx) {
            this.lcShippx = fbArgs;
            this.lsHouseNo = lsHouseNo;
            this.lsAddress = lsAddress;
            this.lsBrgyNmx = lsBrgyNmx;
            this.lsTownNmx = lsTownNmx;
        }

        public String getHouseNo() {
            return lsHouseNo;
        }

        public String getAddress() {
            return lsAddress;
        }

        public String getBarangay() {
            return lsBrgyNmx;
        }

        public String getTownName() {
            return lsTownNmx;
        }
    }
}
