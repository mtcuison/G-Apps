package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.digitalgcard.Model.GcardInfo;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_GcardList extends RecyclerView.Adapter<Adapter_GcardList.GcardHolder> {

    private final List<EGcardApp> poGcard;
    private final OnGcardActivation poCallBck;

    public Adapter_GcardList(List<EGcardApp> foGcard, OnGcardActivation foCallBck) {
        this.poGcard = foGcard;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public GcardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_gcard_list, parent, false);
        return new GcardHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull GcardHolder holder, int position) {
        EGcardApp loGcard = poGcard.get(position);
        holder.txtUserNm.setText(loGcard.getNmOnCard());
        holder.txtCardNo.setText(loGcard.getCardNmbr());
        holder.txtPoints.setText(String.valueOf(loGcard.getAvlPoint()));
    }

    @Override
    public int getItemCount() {
        return poGcard.size();
    }

    public static class GcardHolder extends RecyclerView.ViewHolder{

        public TextView txtUserNm;
        public TextView txtCardNo;
        public TextView txtPoints;
        public TextView lblStActv;

        public GcardHolder(@NonNull View itemView, OnGcardActivation foCallBck) {
            super(itemView);
            txtUserNm = itemView.findViewById(R.id.lbl_gcard_user);
            txtCardNo = itemView.findViewById(R.id.lbl_card_number);
            txtPoints = itemView.findViewById(R.id.lbl_gcard_points);
            lblStActv = itemView.findViewById(R.id.lbl_set_active);

            lblStActv.setOnClickListener(v -> {
                foCallBck.onActivate(txtCardNo.getText().toString().trim());
            });
        }

    }

    public interface OnGcardActivation {
        void onActivate(String fsCardNox);
    }

}
