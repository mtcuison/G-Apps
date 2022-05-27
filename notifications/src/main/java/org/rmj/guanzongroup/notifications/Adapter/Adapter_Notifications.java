package org.rmj.guanzongroup.notifications.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.etc.DateTimeFormatter;
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
        holder.lsMessageID = notif.MesgIDxx;
        holder.lsMesgType = notif.MsgTypex;
        holder.lbl_ntfTitle.setText(notif.MsgTitle);
        holder.lbl_ntfDateTime.setText(DateTimeFormatter.ParseDateForList(notif.Received));
        holder.lbl_ntfMessage.setText(notif.Messagex);
    }

    @Override
    public int getItemCount() {
        return poNotif.size();
    }

    public static class NotifocationHolder extends RecyclerView.ViewHolder{

        private String lsMessageID, lsMesgType;
        private final TextView lbl_ntfTitle;
        private final TextView lbl_ntfDateTime;
        private final TextView lbl_ntfMessage;
        public NotifocationHolder(@NonNull View itemView, OnNotificationsListener foCallBck) {
            super(itemView);
            lbl_ntfTitle = itemView.findViewById(R.id.lbl_ntfTitle);
            lbl_ntfDateTime = itemView.findViewById(R.id.lbl_ntfDateTime);
            lbl_ntfMessage = itemView.findViewById(R.id.lbl_ntfMessage);

            itemView.setOnClickListener(v -> foCallBck.OnClick(lsMessageID, lsMesgType));
        }

    }

    public interface OnNotificationsListener {
        void OnClick(String fsMesgIDxx, String fsMesgType);
    }
}
