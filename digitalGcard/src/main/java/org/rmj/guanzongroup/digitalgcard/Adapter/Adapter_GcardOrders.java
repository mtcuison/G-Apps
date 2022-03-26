package org.rmj.guanzongroup.digitalgcard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.List;

public class Adapter_GcardOrders extends RecyclerView.Adapter<Adapter_GcardOrders.OrderHolder> {

    private final List<EGcardApp> poGcard;
    private final OnGcardActivation poCallBck;

    public Adapter_GcardOrders(List<EGcardApp> foGcard, OnGcardActivation foCallBck) {
        this.poGcard = foGcard;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_gcard_orders, parent, false);
        return new OrderHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        EGcardApp loGcard = poGcard.get(position);
        holder.txtUserNm.setText(loGcard.getNmOnCard());
        holder.txtCardNo.setText(loGcard.getCardNmbr());
        holder.txtPoints.setText(loGcard.getTotPoint());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{

        public TextView txtUserNm;
        public TextView txtCardNo;
        public TextView txtPoints;
        public TextView lblStActv;

        public OrderHolder(@NonNull View itemView, OnGcardActivation foCallBck) {
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
