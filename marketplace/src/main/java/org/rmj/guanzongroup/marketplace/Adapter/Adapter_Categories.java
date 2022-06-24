package org.rmj.guanzongroup.marketplace.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.marketplace.R;

import java.util.List;


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
        try {
            String item = list.get(position);
            Picasso.get().load(item)
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

        public ConstraintLayout lnCategry;
        public ImageView imgCategx;
        public TextView txtCategx;

        public ViewHolderItem(@NonNull View itemView, OnItemClick foCallBck) {
            super(itemView);
            lnCategry = itemView.findViewById(R.id.lnCategory);
            imgCategx = itemView.findViewById(R.id.img_category);
            txtCategx = itemView.findViewById(R.id.txt_category);

            lnCategry.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    foCallBck.onClick(position);
                }
            });

        }

    }

    public interface OnItemClick {
        void onClick(int position);
    }

}
