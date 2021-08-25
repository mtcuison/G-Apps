package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.Model.PromoEventsModel;
import org.rmj.guanzongroup.guanzonapp.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.rmj.g3appdriver.etc.AppConstants.MainFolder;

public class Adapter_Promotions extends RecyclerView.Adapter<Adapter_Promotions.PromotionViewHolder> {

    private static final String TAG = Adapter_Promotions.class.getSimpleName();
    private Context mContext;
    private List<PromoEventsModel> promotionsList;

    private onPromotionClickListener onPromotionClickListener;
    private onFacebookShareClickListener onFacebookShareClickListener;
    private onShareLinkClickListener onShareLinkClickListener;
    private ConnectionUtil conn;

    File imgPromoEvents;
    public Adapter_Promotions(Context context, List<PromoEventsModel> promotionsList){
        this.mContext = context;
        this.promotionsList = promotionsList;
        this.conn = new ConnectionUtil(context);
    }

    public void setOnPromotionClickListener(onPromotionClickListener listener){
        this.onPromotionClickListener = listener;
    }

    public void setOnFacebookShareClickListener(onFacebookShareClickListener listener){
        this.onFacebookShareClickListener = listener;
    }

    public void setOnShareLinkClickListener(onShareLinkClickListener listener){
        this.onShareLinkClickListener = listener;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View promoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_promos, parent, false);
        return new PromotionViewHolder(promoView, onPromotionClickListener, onFacebookShareClickListener, onShareLinkClickListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder holder, int position) {
        holder.promotions = promotionsList.get(position);

        PromoEventsModel promotions = promotionsList.get(position);

        holder.lblCaption.setText(promotions.getTitle());
        holder.lblDuration.setText(getPromoDate(promotions));

        Log.e(TAG, "img path = " + promotions.getImgPath());
        if (conn.isDeviceConnected()){
            if (promotions.getImgPath() == null){
                try {
                    holder.imgPromo.setImageBitmap(getImageThumbnail(promotions.getTransNox(), promotions.getDirectoryFolder()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                holder.imgRedeemableView(promotions.getImgUrl());
            }
        }else {
            try {
                holder.imgPromo.setImageBitmap(getImageThumbnail(promotions.getTransNox(), promotions.getDirectoryFolder()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        if (promotions.getImgUrl() == null || promotions.getImgUrl().isEmpty()){
//            holder.imgPromo.setImageBitmap(getImageThumbnail(promotions.getImgUrl()));
//        }else {
//            holder.imgRedeemableView(promotions.getImgUrl());
//        }
    }

    @Override
    public int getItemCount() {
        return promotionsList.size();
    }

    static class PromotionViewHolder extends RecyclerView.ViewHolder{

        PromoEventsModel promotions;

        TextView lblCaption;
        TextView lblDuration;
        ImageView imgPromo;
        ImageButton btnShare;
        ImageButton btnSocial;
        LinearLayout promoContent;

        PromotionViewHolder(@NonNull View itemView, final onPromotionClickListener listener,
                            final onFacebookShareClickListener listener1,
                            final onShareLinkClickListener listener2) {
            super(itemView);

            lblCaption = itemView.findViewById(R.id.lbl_list_item_promo_caption);
            lblDuration = itemView.findViewById(R.id.lbl_list_item_promo_duration);
            imgPromo = itemView.findViewById(R.id.img_list_item_promo_image);
            btnShare = itemView.findViewById(R.id.btn_list_promotions_share);
            btnSocial = itemView.findViewById(R.id.btn_list_promotions_social);
            promoContent = itemView.findViewById(R.id.linear_list_item_promos_content);
            btnSocial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        listener1.onClick(promotions.getUrl(), promotions.getTitle());
                    } else {
                        Log.e("Adapter OnButtonClik", "You might not initialize a method or listener for this button");
                    }
                }
            });

            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        listener2.onClick(promotions.getUrl());
                    } else {
                        Log.e("Adapter OnButtonClik", "You might not initialize a method or listener for this button");
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onClick(position, promotions.getUrl());
                        }
                    }
                }
            });
        }
        public void imgRedeemableView(String imageUrl) {
            Picasso.get().load(imageUrl).placeholder(R.drawable.no_img_available)
                    .error(R.drawable.no_img_available).into(imgPromo);
        }
    }

    public interface onPromotionClickListener{
        void onClick(int position, String promo_link);
    }

    public interface onFacebookShareClickListener{
        void onClick(String PromoLink, String Caption);
    }

    public interface onShareLinkClickListener{
        void onClick(String PromoLink);
    }

    private String getPromoDate(PromoEventsModel promos){
        if(promos.getDateThru().equalsIgnoreCase("")){
            return "";
        }
        return "Promo runs until " + promos.getDateThru();
    }

    private Bitmap getImageThumbnail(String TransNox,String DirectoryFolder) throws NullPointerException,IOException {
        String fileName = TransNox + ".png";
        File imgFile = createImageFile(fileName, DirectoryFolder);
        Bitmap bitmap = null;
        if (!TransNox.isEmpty() || imgFile.exists()){
          bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            bitmap = MediaStore.Images.Media.getBitmap(
//                    mContext.getContentResolver(), Uri.fromFile(new File(imgFile.getAbsolutePath())));
            return bitmap;

        } else{
            return BitmapFactory.decodeResource(mContext.getResources(), R.drawable.shop_online_now);
        }
    }
    public File createImageFile(String FileName, String DirectoryFolder) throws IOException {

        imgPromoEvents = new File(
                generateMainStorageDir(DirectoryFolder),
                FileName);
        return imgPromoEvents;
    }
    public File generateMainStorageDir(String DirectoryFolder) {
        String root = mContext.getExternalFilesDir(null).getAbsolutePath();
        File sd = new File(root  + "/" + MainFolder + "/" + DirectoryFolder +"/");
        if (!sd.exists()) {
            sd.mkdirs();
        }
        return sd;
//        return sd;
    }
}
