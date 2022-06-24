package org.rmj.guanzongroup.notifications.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.g3appdriver.dev.Database.Entities.EEvents;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.guanzongroup.notifications.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Adapter_EventsPromos extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<EPromo> poPromos;
    private List<EEvents> poEvents;
    private final String args;
    private final Adapter_EventsPromos.OnEventPromoClickListener poListener;
    private Context mContext;
    public interface OnEventPromoClickListener {
        void OnClick(String url, String args);
    }

    public Adapter_EventsPromos(Context context,Adapter_EventsPromos.OnEventPromoClickListener listener, List<EPromo> foPromos, String arg) {
        this.poPromos = foPromos;
        this.poListener = listener;
        this.args = arg;
        this.mContext = context;
    }

    public Adapter_EventsPromos(Context context,List<EEvents> foEvents, Adapter_EventsPromos.OnEventPromoClickListener listener, String arg) {
        this.poEvents = foEvents;
        this.poListener = listener;
        this.args = arg;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_promo_item, parent, false);
        return new Adapter_EventsPromos.ViewHolderItem(mContext,viewItem1, poListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(args.equalsIgnoreCase("1")){
            EPromo loSelect = poPromos.get(position);
            PromosView(holder, loSelect);

        }else{
            EEvents loSelect = poEvents.get(position);
            EventsView(holder, loSelect);
        }
        ((ViewHolderItem) holder).strArgs = args;
    }
    void PromosView(RecyclerView.ViewHolder holder, EPromo foPromo){


        ((Adapter_EventsPromos.ViewHolderItem) holder).lblCaption.setText(foPromo.getCaptionx());
        ((Adapter_EventsPromos.ViewHolderItem) holder).lblDuration.setText("Promo runs until " + getDate(foPromo.getDateThru()));
        ((Adapter_EventsPromos.ViewHolderItem) holder).setImage(foPromo.getImageUrl());

//        Log.e("Promo Image Url : ", foPromo.getImageUrl());
//        Log.e("Promo Url : ", foPromo.getPromoUrl());
        ((Adapter_EventsPromos.ViewHolderItem) holder).url_link = foPromo.getPromoUrl();
//        ((Adapter_EventsPromos.ViewHolderItem) holder).lblCaption.setText(foPromo.getCaptionx());
//
//        ((Adapter_EventsPromos.ViewHolderItem) holder).setImage(foPromo.getPromoUrl());
    }
    void EventsView(RecyclerView.ViewHolder holder, EEvents foEvents){
        ((Adapter_EventsPromos.ViewHolderItem) holder).url_link = foEvents.getEventURL();
        ((Adapter_EventsPromos.ViewHolderItem) holder).lblCaption.setText(foEvents.getEventTle());
        ((Adapter_EventsPromos.ViewHolderItem) holder).lblDuration.setText("Promo runs until " + getDate(foEvents.getEvntThru()));
        ((Adapter_EventsPromos.ViewHolderItem) holder).setImage(foEvents.getImageURL());
    }
    @Override
    public int getItemCount() {
        if(args.equalsIgnoreCase("1")){
            return poPromos.size();
        }else{
            return poEvents.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        public String url_link = "";
        public String strArgs = "";
//        public TextView lblCaption;
//        public ImageView imgPromoEvents;

        public Context context;
        TextView lblCaption;
        TextView lblDuration;
        ImageView imgPromo;
        LinearLayout promoContent;
        public ViewHolderItem(Context mcontext,@NonNull View itemView, Adapter_EventsPromos.OnEventPromoClickListener listener) {
            super(itemView);
//            this.lblCaption = itemView.findViewById(R.id.lblPromoEvents);
//            this.imgPromoEvents = itemView.findViewById(R.id.imgPromoEvents);
            context = mcontext;
            lblCaption = itemView.findViewById(R.id.lbl_list_item_promo_caption);
            lblDuration = itemView.findViewById(R.id.lbl_list_item_promo_duration);
            imgPromo = itemView.findViewById(R.id.img_list_item_promo_image);
            promoContent = itemView.findViewById(R.id.linear_list_item_promos_content);
            itemView.setOnClickListener(view -> listener.OnClick(url_link, strArgs));
        }

        public void setImage(String image){
            Picasso.get().load(image).placeholder(R.drawable.progress_animation)
                    .error(R.drawable.sample_image).into(imgPromo);
//            Glide
//                .with(context)
//                .load(image)
////                .centerCrop()
//                .placeholder(R.drawable.progress_animation)
//                .error(R.drawable.try_later)
//                .into(imgPromo);

        }

    }
    String getDate(String val){
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String formattedDate = null;
        try {
            formattedDate = formatter.format(fromUser.parse(val));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}