package org.rmj.guanzongroup.gconnect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.rmj.guanzongroup.ganado.Activities.Activity_ProductSelection;
import org.rmj.guanzongroup.gconnect.R;
import java.util.HashMap;

public class Adapter_MCProductImageSlider extends RecyclerView.Adapter<Adapter_MCProductImageSlider.SliderAdapterVH>{
    private Context context;
    private HashMap<Integer, String> oSlideLst;

    public Adapter_MCProductImageSlider(Context context, HashMap<Integer, String> oSlideLst){
        this.context = context;
        this.oSlideLst = oSlideLst;
    }

    @NonNull
    @Override
    public SliderAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_productslider, parent, false);
        return new Adapter_MCProductImageSlider.SliderAdapterVH(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull SliderAdapterVH holder, int position) {
        holder.imageViewBackground.setImageResource((Integer) oSlideLst.keySet().toArray()[position]);
        holder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sBrand = "";
                String sBrandId = oSlideLst.get(oSlideLst.keySet().toArray()[position]);

                Integer logo = (Integer) oSlideLst.keySet().toArray()[position];
                switch (logo) {
                    case R.drawable.apple_logo:
                        sBrand = "HONDA";
                        break;
                    case R.drawable.huawei_logo:
                        sBrand = "SUZUKI";
                        break;
                    case R.drawable.honor_logo:
                        sBrand = "KAWASAKI";
                        break;
                    case R.drawable.oppo_logo:
                        sBrand = "YAMAHA";
                        break;
                }

                Intent intent = new Intent(context, Activity_ProductSelection.class);
                intent.putExtra("lsBrandID", sBrandId);
                intent.putExtra("lsBrandNm", sBrand);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return oSlideLst.size();
    }

    public static class SliderAdapterVH extends RecyclerView.ViewHolder{
        public ImageView imageViewBackground;
        public SliderAdapterVH(@NonNull View itemView) {
            super(itemView);

            this.imageViewBackground = itemView.findViewById(org.rmj.g3appdriver.R.id.iv_auto_image_slider);
        }
    }
}
