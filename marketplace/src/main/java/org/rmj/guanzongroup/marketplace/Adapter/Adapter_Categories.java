package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.marketplace.R;

import java.util.List;
import java.util.Locale;


public class Adapter_Categories extends RecyclerView.Adapter<Adapter_Categories.ViewHolderItem> {

    private final List<String> list;
    private final OnItemClick poCallBck;

    public Adapter_Categories(List<String> list, OnItemClick foCallBck){
        this.list = list;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_categories, parent, false);
        return new ViewHolderItem(viewItem, poCallBck);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        String item = list.get(position);
        holder.psItem = item;
        try {
            Picasso.get().load(getImageUrl(item))
                    .error(org.rmj.guanzongroup.digitalgcard.R.drawable.ic_no_image_available).into(holder.imgCategx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        public String psItem;
        public ConstraintLayout lnCategry;
        public ImageView imgCategx;
        public TextView txtCategx, txtNamexx;

        public ViewHolderItem(@NonNull View itemView, OnItemClick foCallBck) {
            super(itemView);
            lnCategry = itemView.findViewById(R.id.lnCategory);
            imgCategx = itemView.findViewById(R.id.img_category);
            txtCategx = itemView.findViewById(R.id.txt_category);

            lnCategry.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    foCallBck.onClick(psItem);
                }
            });

        }

    }

    private String getImageUrl(String fsVal){
        switch (fsVal.toLowerCase(Locale.ROOT)){
            case "samsung":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/samsung_logo.png";
            case "vivo":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/vivo_logo.png";
            case "huawei":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/huawei_logo.png";
            case "apple":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/apple_logo.png";
            case "oppo":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/oppo_logo.png";
            case "xiaomi":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/xiaomi_logo.png";
            case "techno":
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/tecno_logo.png";
            default:
                return "https://restgk.guanzongroup.com.ph/images/mp/uploads/brand_logos/realme_logo.png";
        }
    }

    public interface OnItemClick {
        void onClick(String args);
    }
}
