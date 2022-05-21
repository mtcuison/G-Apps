package org.rmj.guanzongroup.notifications.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.guanzongroup.notifications.R;

import java.util.List;

public class Adapter_Notifications extends RecyclerView.Adapter<Adapter_Notifications.NotifocationHolder> {

    private final List<DNotifications.ClientNotificationInfo> poNotif;
    private final OnNotificationsListener poCallBck;

    public Adapter_Notifications(List<DNotifications.ClientNotificationInfo> foGcard, OnNotificationsListener foCallBck) {
        this.poNotif = foGcard;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public NotifocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_notifications, parent, false);
        return new NotifocationHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifocationHolder holder, int position) {
        DNotifications.ClientNotificationInfo notif = poNotif.get(position);
        holder.lbl_ntfTitle.setText(notif.MsgTitle);
        holder.lbl_ntfDateTime.setText(notif.Received);
        holder.lbl_ntfMessage.setText(notif.Messagex);

    }

    @Override
    public int getItemCount() {
        return poNotif.size();
    }

    public static class NotifocationHolder extends RecyclerView.ViewHolder{

        private TextView lbl_ntfTitle;
        private TextView lbl_ntfDateTime;
        private TextView lbl_ntfMessage;
        public NotifocationHolder(@NonNull View itemView, OnNotificationsListener foCallBck) {
            super(itemView);
            lbl_ntfTitle = itemView.findViewById(R.id.lbl_ntfTitle);
            lbl_ntfDateTime = itemView.findViewById(R.id.lbl_ntfDateTime);
            lbl_ntfMessage = itemView.findViewById(R.id.lbl_ntfMessage);

        }

    }

    public interface OnNotificationsListener {
        void onNotif(String fomessages);
    }

}
