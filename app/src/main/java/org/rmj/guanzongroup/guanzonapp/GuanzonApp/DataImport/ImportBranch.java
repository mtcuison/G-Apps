package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AssetDownload;

import java.util.HashMap;

public class ImportBranch implements GapImportInstance{
    private static final String TAG = ImportBranch.class.getSimpleName();

    private Context mContext;
    private RequestHeaders headers;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(final Context context, onImportResultListener listener) {
        this.mContext = context;
        this.headers = new RequestHeaders(mContext);
        ConnectionUtil connectionUtil = new ConnectionUtil(mContext);
        this.onImportResultListener = listener;

        if(connectionUtil.isDeviceConnected()) {
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_BRANCH(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    Log.e(TAG, "Import branch headers: " + headers.getHeaders());
                    return (HashMap) headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    return new JSONObject();
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    if(new AssetDownload(context).saveBranches(jsonResponse)) {
                        Log.e(TAG, "Successfully imported motorcycle and mobitek branches.");
                        onImportResultListener.onSuccessImport();
                    } else {
                        onImportResultListener.onErrorResult();
                    }
                }

                @Override
                public void onErrorResponse(String message) {
                    Log.e(TAG, "Unable to import branches. " + message);
                    onImportResultListener.onErrorResult();
                }
            });
        } else {
            Log.e(TAG, "Unable to import motorcycle and mobitek branches. No internect connection.");
            onImportResultListener.onErrorResult();
        }
    }
}
