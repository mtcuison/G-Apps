package org.rmj.guanzongroup.notifications.Adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.etc.DateTimeFormatter;
import org.rmj.guanzongroup.notifications.R;

import java.util.List;

public class Adapter_Notifications extends RecyclerView.Adapter<Adapter_Notifications.NotificationHolder> {

    private final List<DNotifications.ClientNotificationInfo> poNotif;
    private final OnNotificationsListener poCallBck;

    public Adapter_Notifications(List<DNotifications.ClientNotificationInfo> foGcard, OnNotificationsListener foCallBck) {
        this.poNotif = foGcard;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_notifications, parent, false);
        return new NotificationHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        DNotifications.ClientNotificationInfo notif = poNotif.get(position);
        holder.lsMessageID = notif.MesgIDxx;
        holder.lsMesgType = notif.MsgTypex;
        holder.lsCreated = notif.CreatrID;
        holder.lsDataSent = notif.DataInfo;
        holder.lbl_ntfTitle.setText(notif.MsgTitle);
        holder.lbl_ntfDateTime.setText(DateTimeFormatter.ParseDateForList(notif.Received));
        holder.lbl_ntfMessage.setText(notif.Messagex);

        switch (notif.MsgTypex){
            case "0000":
            case "00005":
                holder.imgType.setImageResource(R.drawable.ic_baseline_inquiry_24);
                break;
            case "00006":
                holder.imgType.setImageResource(R.drawable.ic_baseline_rate_24);
                break;
        }

        if(notif.MesgStat.equalsIgnoreCase("2")){
            holder.imgNotif.setVisibility(View.VISIBLE);
            holder.lbl_ntfTitle.setTypeface(Typeface.DEFAULT_BOLD);
            holder.lbl_ntfDateTime.setTypeface(Typeface.DEFAULT_BOLD);
            holder.lbl_ntfMessage.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            holder.lbl_ntfTitle.setTypeface(Typeface.DEFAULT);
            holder.lbl_ntfDateTime.setTypeface(Typeface.DEFAULT);
            holder.lbl_ntfMessage.setTypeface(Typeface.DEFAULT);
            holder.imgNotif.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poCallBck.OnClick(notif.MesgIDxx, notif.CreatrID, notif.MsgTypex, notif.DataInfo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return poNotif.size();
    }

    public static class NotificationHolder extends RecyclerView.ViewHolder{

        private String lsMessageID, lsMesgType, lsCreated, lsDataSent;
        private final TextView lbl_ntfTitle;
        private final TextView lbl_ntfDateTime;
        private final TextView lbl_ntfMessage;
        private final ImageView imgNotif, imgType;

        public NotificationHolder(@NonNull View itemView, OnNotificationsListener foCallBck) {
            super(itemView);
            lbl_ntfTitle = itemView.findViewById(R.id.lbl_ntfTitle);
            lbl_ntfDateTime = itemView.findViewById(R.id.lbl_ntfDateTime);
            lbl_ntfMessage = itemView.findViewById(R.id.lbl_ntfMessage);
            imgNotif = itemView.findViewById(R.id.img_notif);
            imgType = itemView.findViewById(R.id.img_ntfType);

//            itemView.setOnClickListener(v -> foCallBck.OnClick(lsMessageID, lsCreated, lsMesgType, lsDataSent));
        }

    }

    public interface OnNotificationsListener {
        void OnClick(String fsMesgIDxx,
                     String fsCreated,
                     String fsMesgType,
                     String fsDataSent);
    }
}
