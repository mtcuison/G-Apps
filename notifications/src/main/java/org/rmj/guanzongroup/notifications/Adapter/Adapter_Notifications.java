package org.rmj.guanzongroup.notifications.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.notifications.R;

import java.util.List;

public class Adapter_Notifications extends RecyclerView.Adapter<Adapter_Notifications.OrderHolder> {

    private final List<EGcardApp> poGcard;
    private final OnGcardActivation poCallBck;

    public Adapter_Notifications(List<EGcardApp> foGcard, OnGcardActivation foCallBck) {
        this.poGcard = foGcard;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_notifications, parent, false);
        return new OrderHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        EGcardApp loGcard = poGcard.get(position);


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{


        public OrderHolder(@NonNull View itemView, OnGcardActivation foCallBck) {
            super(itemView);

        }

    }

    public interface OnGcardActivation {
        void onActivate(String fsCardNox);
    }

}
