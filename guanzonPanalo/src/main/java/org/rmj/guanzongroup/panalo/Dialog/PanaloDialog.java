package org.rmj.guanzongroup.panalo.Dialog;

import android.content.Context;
import android.util.Log;
import android.view.View;

public class PanaloDialog {
    private static final String TAG = PanaloDialog.class.getSimpleName();

    private final Context mContext;

    public PanaloDialog(Context context) {
        this.mContext = context;
    }

    public iDialog InitDialog(String TranStat){
        switch (TranStat){
            case "0":
                return new DialogPanaloNoReward(mContext);
            case "1":
                return new DialogPanaloWin(mContext);
            case "2":
                return new DialogPanaloClaim(mContext);
            default:
                return new DialogPanaloRedeem(mContext);
        }
    }
}
