package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.digitalgcard.Model.GcardInfo;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_GcardList extends RecyclerView.Adapter<Adapter_GcardList.GcardHolder> {

    private final List<GcardInfo> poGcard;

    public Adapter_GcardList(List<GcardInfo> foGcard) {
        this.poGcard = foGcard;
    }

    @NonNull
    @Override
    public GcardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_gcard_list, parent, false);
        return new GcardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GcardHolder holder, int position) {
        GcardInfo loGcard = poGcard.get(position);
        holder.lblGcardNo.setText(loGcard.getGcardNumber());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class GcardHolder extends RecyclerView.ViewHolder{

        public TextView lblGcardNo;

        public GcardHolder(@NonNull View itemView) {
            super(itemView);
                lblGcardNo = itemView.findViewById(R.id.lblMenuTitle);
        }
    }

    public interface OnSettingsMenuSelection {
        void onClick(int position);
    }

}
