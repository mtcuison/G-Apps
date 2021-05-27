package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.GcardItem;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_Gcard extends RecyclerView.Adapter<Adapter_Gcard.GCardItemViewHolder> {

    private List<GcardItem> gcardItemList;

    private onGCardItemClickListener onGCardItemClickListener;

    public Adapter_Gcard(List<GcardItem> gcardItemList){
        this.gcardItemList = gcardItemList;
    }

    public void setOnGCardItemClickListener(Adapter_Gcard.onGCardItemClickListener onGCardItemClickListener) {
        this.onGCardItemClickListener = onGCardItemClickListener;
    }

    @NonNull
    @Override
    public GCardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View gcardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gcard, parent, false);
        return new GCardItemViewHolder(gcardView, onGCardItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GCardItemViewHolder holder, int position) {
        holder.gcardItem = gcardItemList.get(position);
        GcardItem gcardItem = gcardItemList.get(position);

        holder.lblGcardNumber.setText(gcardItem.getGCardNumber());
        holder.lblGcardname.setText(gcardItem.getGCardName());
        holder.lblGCardPoints.setText(gcardItem.getGCardPoints());
    }

    @Override
    public int getItemCount() {
        return gcardItemList.size();
    }

    static class GCardItemViewHolder extends RecyclerView.ViewHolder{

        GcardItem gcardItem;

        private TextView lblGcardNumber;
        private TextView lblGcardname;
        private TextView lblGCardPoints;

        GCardItemViewHolder(@NonNull View itemView, final onGCardItemClickListener listener) {
            super(itemView);

            lblGcardNumber = itemView.findViewById(R.id.lbl_gcard_list_gcardNumber);
            lblGcardname = itemView.findViewById(R.id.lbl_gcard_list_gcardName);
            lblGCardPoints = itemView.findViewById(R.id.lbl_gcard_list_gcardPoints);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onClick(gcardItem.getGCardNumber());
                    }
                }
            });
        }
    }

    public interface onGCardItemClickListener{
        void onClick(String GCardNumber);
    }
}
