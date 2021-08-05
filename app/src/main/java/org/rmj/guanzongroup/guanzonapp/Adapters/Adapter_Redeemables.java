package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.guanzonapp.Dialogs.BottomCartDialog;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_Redeemables extends RecyclerView.Adapter<Adapter_Redeemables.RedeemableItemView> {

    private Context mContext;
    private EGcardApp poGcardxx;
    private List<ERedeemablesInfo> poRedeems;
    private OnItemClickListener mListener;

    public Adapter_Redeemables(Context context, EGcardApp foGcard, List<ERedeemablesInfo> foRedeems, OnItemClickListener mListener){
        this.mContext = context;
        this.poGcardxx = foGcard;
        this.poRedeems = foRedeems;
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public RedeemableItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View redeemableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_redeemables, parent, false);
        return new RedeemableItemView(redeemableView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemableItemView holder, final int position) {
        ERedeemablesInfo loRedeem = poRedeems.get(position);

        holder.redeemableItems = poRedeems.get(position);
        holder.lblRedeemableName.setText(loRedeem.getPromoDsc());
        holder.lblRedeemablePoints.setText(String.valueOf(loRedeem.getPointsxx()));
        holder.imgRedeemableView.setImageBitmap(generateItemImage(loRedeem.getImageUrl().getBytes()));

        holder.btnAddToCart.setOnClickListener(v -> {
            BottomCartDialog bottomSheet = new BottomCartDialog(
                    poGcardxx.getGCardNox(),
                    poGcardxx.getAvlPoint(),
                    loRedeem.getTransNox(),
                    loRedeem.getPromoDsc(),
                    loRedeem.getPointsxx()
            );

            bottomSheet.show(((AppCompatActivity)mContext).getSupportFragmentManager(), "Add to Cart");
        });
    }

    @Override
    public int getItemCount() {
        return poRedeems.size();
    }

    static class RedeemableItemView extends RecyclerView.ViewHolder{

        ERedeemablesInfo redeemableItems;

        TextView lblRedeemableName;
        TextView lblRedeemablePoints;
        ImageButton btnAddToCart;
        ImageView imgNotified;
        ImageView imgRedeemableView;
        CardView itemContent;

        RedeemableItemView(@NonNull View itemView, final OnItemClickListener mListener) {
            super(itemView);

            lblRedeemableName = itemView.findViewById(R.id.lbl_list_item_redeemable_name);
            lblRedeemablePoints = itemView.findViewById(R.id.lbl_list_item_redeemable_points);
            btnAddToCart = itemView.findViewById(R.id.btn_list_item_add_to_cart);
            imgNotified = itemView.findViewById(R.id.img_list_item_new_indicator);
            imgRedeemableView = itemView.findViewById(R.id.img_list_item_redeemable_image);
            itemContent = itemView.findViewById(R.id.cardview_list_item_content);

            itemView.setOnClickListener(v -> {
                if(mListener!=null){
                    int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        mListener.onClick(redeemableItems.getPromoCde(),
                                redeemableItems.getPromoDsc(),
                                String.valueOf(redeemableItems.getPointsxx()),
                                redeemableItems.getImageUrl().getBytes());
                    }
                }
            });

        }
    }

    private Bitmap generateItemImage(byte[] ImageBlob){
        Bitmap image;
        /*if(ImageBlob!=null) {
            byte[] decoded = Base64.decode(ImageBlob, Base64.NO_WRAP);
            image = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
        } else {*/
        image = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_redeemables);
        //}
        return image;
    }

    public interface OnItemClickListener{
        void onClick(String TransNo, String Redeemable, String Points, byte[] image_data);
    }

//    private int getBadgeVisibility(boolean isNotified){
//        if(isNotified){
//            return View.GONE;
//        }
//        return View.VISIBLE;
//    }

}
