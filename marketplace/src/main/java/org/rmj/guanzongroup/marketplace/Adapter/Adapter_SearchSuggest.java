package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.marketplace.databinding.AdapterSearchSuggestBinding;


public class Adapter_SearchSuggest extends RecyclerView.Adapter<Adapter_SearchSuggest.ItemViewHolder> {

    private AdapterSearchSuggestBinding mBinding;

    public Adapter_SearchSuggest(){

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = AdapterSearchSuggestBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ItemViewHolder(mBinding.getRoot(), mBinding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        try {
            holder.bind(new Sample());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        public AdapterSearchSuggestBinding mBinding;

        public ItemViewHolder(@NonNull View itemView, AdapterSearchSuggestBinding mBinding) {
            super(itemView);
            this.mBinding = mBinding;
        }

        public void bind(Sample foSample) {
            mBinding.txtSugges.setText(foSample.sample);
        }

    }


    private class Sample {
        public String sample;
    }



}
