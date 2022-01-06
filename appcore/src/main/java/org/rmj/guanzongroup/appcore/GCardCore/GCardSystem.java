package org.rmj.guanzongroup.appcore.GCardCore;

import android.content.Context;

public class GCardSystem {
    private static final String TAG = GCardSystem.class.getSimpleName();

    private Context mContext;

    public interface OnValidateCallback{
        void OnValidate(boolean isValid, String message);
    }

    public interface GCardSystemCallback{
        void OnSuccess(String args);
        void OnFailed(String message);
    }

    public enum CoreFunctions{
        GCARD,
        REDEEMPTION
    }

    private final GCardManager poGcard;
    private final RedemptionManager poRedeem;

    public GCardSystem(Context context) {
        this.mContext = context;
        this.poGcard = new GCardManager(mContext);
        this.poRedeem = new RedemptionManager(mContext);
    }

    public iGCardSystem getInstance(CoreFunctions core){
        if(core == CoreFunctions.GCARD){
            return new GCardManager(mContext);
        } else {
            return new RedemptionManager(mContext);
        }
    }
}
