package org.rmj.g3appdriver.lib.Notifications;

import android.content.Context;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_CustomerService;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_Events;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_MPOrderStatus;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_MPQuestions;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_MPReview;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_Panalo;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_Promotions;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_Regular;
import org.rmj.g3appdriver.lib.Notifications.Obj.NMM_TableUpdate;

public class NMM {
    private static final String TAG = NMM.class.getSimpleName();

    private Context mContext;

    public NMM(Context mContext) {
        this.mContext = mContext;
    }

    public iNotification getInstance(RemoteMessage foVal){
        String lsSysMon = new RemoteMessageParser(foVal).getValueOf("msgmon");
        switch (lsSysMon){
            case "00000":
                return new NMM_Regular(mContext);
            case "00001":
                return new NMM_TableUpdate(mContext);
            case "00002":
                return new NMM_MPOrderStatus(mContext);
            case "00003":
                return new NMM_Promotions(mContext);
            case "00004":
                return new NMM_Events(mContext);
            case "00005":
                return new NMM_MPQuestions(mContext);
            case "00006":
                return new NMM_MPReview(mContext);
            case "00007":
                return new NMM_CustomerService(mContext);
            case "00008":
                return new NMM_Panalo(mContext);
            default:
                return null;
        }
    }
}
