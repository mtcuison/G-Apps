package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.digitalgcard.Model.AdvertisementInfo;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.List;

public class Adapter_Advertisement extends RecyclerView.Adapter<Adapter_Advertisement.AdViewHolder> {

        private final List<AdvertisementInfo> poPromoAd;
        private final int pnLimitxx;
        private final OnAdvertisementClick poCallBck;

        public Adapter_Advertisement(List<AdvertisementInfo> foPromoAd, int fnLimitxx, OnAdvertisementClick foCallBck) {
                this.poPromoAd = foPromoAd;
                this.pnLimitxx = fnLimitxx;
                this.poCallBck = foCallBck;
        }

        @NonNull
        @Override
        public AdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_advertisement, parent, false);
                return new AdViewHolder(view, poCallBck);
        }

        @Override
        public void onBindViewHolder(@NonNull AdViewHolder holder, int position) {
                try {
                        AdvertisementInfo loPromoAd = poPromoAd.get(position);
                        holder.lsPromoId = loPromoAd.getPromoId();
                        Picasso.get().load(loPromoAd.getImageUrl()).into(holder.imgPromoAd);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        @Override
        public int getItemCount() {
                return 2;
        }

        public static class AdViewHolder extends RecyclerView.ViewHolder{

                public String lsPromoId;
                public ImageView imgPromoAd;

                public AdViewHolder(@NonNull View itemView, OnAdvertisementClick foCallBck) {
                        super(itemView);
                        imgPromoAd = itemView.findViewById(R.id.imgAdvertisement);
                }

        }

        public interface OnAdvertisementClick {
                void onClick(String fsPromoId);
        }

}
