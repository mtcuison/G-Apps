package org.rmj.guanzongroup.marketplace.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import org.rmj.guanzongroup.marketplace.Model.HomeImageSliderModel;
import org.rmj.guanzongroup.marketplace.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_HomeImageSlider extends SliderViewAdapter<Adapter_HomeImageSlider.SliderAdapterVH> {

    private Context context;
    private List<HomeImageSliderModel> oSlideLst = new ArrayList<>();

    public Adapter_HomeImageSlider(Context context, List<HomeImageSliderModel> oSlideLst) {
        this.context = context;
        this.oSlideLst = oSlideLst;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_image_slider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        HomeImageSliderModel loSlide = oSlideLst.get(position);

        viewHolder.textViewDescription.setText(loSlide.getDescription());
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(loSlide.getImageUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        return oSlideLst.size();
    }

    public void renewItems(List<HomeImageSliderModel> sliderItems) {
        this.oSlideLst = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.oSlideLst.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(HomeImageSliderModel sliderItem) {
        this.oSlideLst.add(sliderItem);
        notifyDataSetChanged();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
