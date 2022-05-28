package org.rmj.guanzongroup.useraccount.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.databinding.AdapterShippingAddressBinding;

import java.util.ArrayList;

public class Adapter_ShippingAddress extends RecyclerView.Adapter<Adapter_ShippingAddress.ItemViewHolder> {

    private AdapterShippingAddressBinding mBinding;

    public Adapter_ShippingAddress() {

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = AdapterShippingAddressBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ItemViewHolder(mBinding.getRoot(), mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(new Sample());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public AdapterShippingAddressBinding mBinding;

        public ItemViewHolder(@NonNull View itemView, AdapterShippingAddressBinding mBinding) {
            super(itemView);
            this.mBinding = mBinding;
        }

        public void bind(Sample foSample) {
            // Set data here
        }

    }

    public interface OnSettingsMenuSelection {
        void onClick(int position);
    }

    private class Sample {
        public String sample;
    }

}
