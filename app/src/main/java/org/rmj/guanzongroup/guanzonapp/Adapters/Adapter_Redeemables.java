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

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.RedeemableItems;
import org.rmj.guanzongroup.guanzonapp.Dialogs.BottomCartDialog;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_Redeemables extends RecyclerView.Adapter<Adapter_Redeemables.RedeemableItemView> {

    private Context mContext;

    private List<RedeemableItems> redeemableItemsList;
    private onRedeemableItemClickListener onRedeemableItemClickListener;
    private onAddtoCartButtonClickListener onAddtoCartButtonClickListener;

    public Adapter_Redeemables(Context context,
                               List<RedeemableItems> redeemableItemsList){
        this.mContext = context;
        this.redeemableItemsList = redeemableItemsList;
    }

    public void setOnRedeemableItemClickListener(onRedeemableItemClickListener listener){
        this.onRedeemableItemClickListener = listener;
    }

    public void setOnAddtoCartButtonClickListener(Adapter_Redeemables.onAddtoCartButtonClickListener onAddtoCartButtonClickListener) {
        this.onAddtoCartButtonClickListener = onAddtoCartButtonClickListener;
    }

    @NonNull
    @Override
    public RedeemableItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View redeemableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_redeemables, parent, false);
        return new RedeemableItemView(redeemableView, onRedeemableItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemableItemView holder, final int position) {
        holder.redeemableItems = redeemableItemsList.get(position);

        RedeemableItems redeemableItems = redeemableItemsList.get(position);
        holder.lblRedeemableName.setText(redeemableItems.getItemNamex());
        holder.lblRedeemablePoints.setText(redeemableItems.getItemPntsx());
        holder.imgRedeemableView.setImageBitmap(generateItemImage(redeemableItems.getItemImage()));

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomCartDialog bottomSheet = new BottomCartDialog();
                bottomSheet.setItemIDxxx(redeemableItemsList.get(position).getItemIDxxx());
                bottomSheet.setItemNamex(redeemableItemsList.get(position).getItemNamex());
                bottomSheet.setItemPntsx(Double.parseDouble(redeemableItemsList.get(position).getItemPntsx()));
                bottomSheet.show(((AppCompatActivity)mContext).getSupportFragmentManager(), "Redeemable Bottom Sheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return redeemableItemsList.size();
    }

    static class RedeemableItemView extends RecyclerView.ViewHolder{

        RedeemableItems redeemableItems;

        TextView lblRedeemableName;
        TextView lblRedeemablePoints;
        ImageButton btnAddToCart;
        ImageView imgNotified;
        ImageView imgRedeemableView;
        CardView itemContent;

        RedeemableItemView(@NonNull View itemView, final onRedeemableItemClickListener listener) {
            super(itemView);

            lblRedeemableName = itemView.findViewById(R.id.lbl_list_item_redeemable_name);
            lblRedeemablePoints = itemView.findViewById(R.id.lbl_list_item_redeemable_points);
            btnAddToCart = itemView.findViewById(R.id.btn_list_item_add_to_cart);
            imgNotified = itemView.findViewById(R.id.img_list_item_new_indicator);
            imgRedeemableView = itemView.findViewById(R.id.img_list_item_redeemable_image);
            itemContent = itemView.findViewById(R.id.cardview_list_item_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onClick(redeemableItems.getItemIDxxx(),
                                            redeemableItems.getItemNamex(),
                                            redeemableItems.getItemPntsx(),
                                            redeemableItems.getItemImage());
                        }
                    }
                }
            });
        }
    }

    public interface onRedeemableItemClickListener{
        void onClick(String TransNo, String Redeemable, String Points, byte[] image_data);
    }

    public interface onAddtoCartButtonClickListener{
        void onClick(String ItemID, String ItemName, String ItemPoints, byte[] ItemImage);
    }

    private int getBadgeVisibility(boolean isNotified){
        if(isNotified){
            return View.GONE;
        }
        return View.VISIBLE;
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
}
