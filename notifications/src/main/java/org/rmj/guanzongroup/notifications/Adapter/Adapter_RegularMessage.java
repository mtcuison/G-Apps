package org.rmj.guanzongroup.notifications.Adapter;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.guanzongroup.notifications.R;

import java.util.List;

public class Adapter_RegularMessage extends RecyclerView.Adapter<Adapter_RegularMessage.RegularMessageViewHolder> {
    private static final String TAG = Adapter_RegularMessage.class.getSimpleName();

    private final List<DNotifications.RegularMessage> poList;
    private OnActionClickListener mListener;

    public interface OnActionClickListener{
        void OnProductCheck(String module, String args);
    }

    public Adapter_RegularMessage(List<DNotifications.RegularMessage> poList) {
        this.poList = poList;
    }

    public void setOnActionClickListener(OnActionClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RegularMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_regular_message, parent, false);
        return new RegularMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegularMessageViewHolder holder, int position) {
        try {
            DNotifications.RegularMessage loMssg = poList.get(position);
            holder.lblRcvMsg.setText(loMssg.sMessagex);
            holder.lblDteRcv.setText(loMssg.dReceived);
            holder.lnRcve.setVisibility(View.VISIBLE);

            if(loMssg.cMesgStat.equalsIgnoreCase("2")){
                holder.lblRcvMsg.setTypeface(Typeface.DEFAULT_BOLD);
            }

            Log.d(TAG, loMssg.sDataSndx);
            if (mListener != null) {
                JSONObject loJson = new JSONObject(loMssg.sDataSndx);
                String lsModule = loJson.getString("module");
                switch (lsModule){
                    case "00005":
                        holder.btnAction.setVisibility(View.VISIBLE);
                        holder.btnAction.setText("Get Fully Verified");
                        holder.btnAction.setOnClickListener(v -> mListener.OnProductCheck(lsModule ,loMssg.sDataSndx));
                        break;
                    case "00003":
                        holder.btnAction.setVisibility(View.VISIBLE);
                        holder.btnAction.setText("Check Order");
                        String lsOrderID = loJson.getJSONObject("data").getString("sTransNox");
                        holder.btnAction.setOnClickListener(v -> mListener.OnProductCheck(lsModule, lsOrderID));
                        break;
                }
            }
//        holder.lblSntMsg.setText(loMssg.sMessagex);
//        holder.cvSent.setVisibility(View.VISIBLE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return poList.size();
    }

    public static class RegularMessageViewHolder extends RecyclerView.ViewHolder{

        public TextView lblRcvMsg,
                        lblDteRcv,
                        lblSntMsg;

        public CardView cvSent;
        public LinearLayout lnRcve;
        public MaterialButton btnAction;

        public RegularMessageViewHolder(@NonNull View itemView) {
            super(itemView);

            lblRcvMsg = itemView.findViewById(R.id.lbl_messageRcv);
            lblDteRcv = itemView.findViewById(R.id.lbl_dateTime);
            lblSntMsg = itemView.findViewById(R.id.lbl_messageSnt);
            cvSent = itemView.findViewById(R.id.cv_messageSnt);
            lnRcve = itemView.findViewById(R.id.linear_messageRcv);
            btnAction = itemView.findViewById(R.id.btnAction);
        }
    }
}
