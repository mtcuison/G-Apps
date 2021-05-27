package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AssetDownload;

import java.util.HashMap;

public class ImportPromotions implements GapImportInstance {
    private static final String TAG = ImportPromotions.class.getSimpleName();

    private RequestHeaders headers;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(final Context context, onImportResultListener listener) {
        this.headers = new RequestHeaders(context);
        ConnectionUtil connectionUtil = new ConnectionUtil(context);
        this.onImportResultListener = listener;

        if(connectionUtil.isDeviceConnected()){
            new HttpRequestUtil().sendRequest(new WebApi(context).URL_IMPORT_PROMOLINK(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    Log.e(TAG, "Headers for importing promotion links.");
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() { return new JSONObject(); }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    if(new AssetDownload(context).savePromos(jsonResponse)) {
                        onImportResultListener.onSuccessImport();
                    } else {
                        onImportResultListener.onErrorResult();
                    }
                }

                @Override
                public void onErrorResponse(String message) {
                    Log.e(TAG, "Unable to import promotion links. " + message);
                    onImportResultListener.onErrorResult();
                }
            });
        } else {
            Log.e(TAG, "Unable to import promotion links. No internet connection.");
            onImportResultListener.onErrorResult();
        }
    }
}
