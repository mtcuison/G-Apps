package org.rmj.g3appdriver.lib.Account.Obj;

import android.content.Context;

import org.rmj.g3appdriver.lib.GCardCore.GCardManager;
import org.rmj.g3appdriver.lib.GCardCore.RedemptionManager;
import org.rmj.g3appdriver.lib.GCardCore.SystemExtras;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

public class ClientSystem {
    private static final String TAG = ClientSystem.class.getSimpleName();

    private Context mContext;

    public interface ClientInfoSystemCallback{
        void OnSuccess(String args);
        void OnFailed(String message);
    }



    public enum CoreFunctions{
        GCARD,
        REDEMPTION,
        EXTRAS
    }

    public ClientSystem(Context context) {
        this.mContext = context;
    }

    public iGCardSystem getInstance(CoreFunctions core){
        if(core == CoreFunctions.GCARD){
            return new GCardManager(mContext);
        } else if(core == CoreFunctions.REDEMPTION){
            return new RedemptionManager(mContext);
        } else {
            return new SystemExtras(mContext);
        }
    }
}
