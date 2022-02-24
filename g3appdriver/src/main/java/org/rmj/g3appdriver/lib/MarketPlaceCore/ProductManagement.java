package org.rmj.g3appdriver.lib.MarketPlaceCore;

import android.content.Context;

public class ProductManagement {
    private static final String TAG = ProductManagement.class.getSimpleName();

    private final Context mContext;

    public interface OnDownloadCallback{
        void OnSuccess(String args);
        void OnFailed(String message);
    }

    public ProductManagement(Context context) {
        this.mContext = context;
    }

    public void DownloadItemInfo(OnDownloadCallback callback) throws Exception{

    }


}
