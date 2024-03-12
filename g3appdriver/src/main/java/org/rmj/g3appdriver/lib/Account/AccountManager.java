package org.rmj.g3appdriver.lib.Account;

import android.content.Context;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;

public class AccountManager {
    private static final String TAG = AccountManager.class.getSimpleName();
    private final HttpHeaders poHeaders;
    private Context mContext;
    private final GuanzonAppConfig poConfig;
    private final ServerAPIs poAPI;
    public AccountManager(Context mContext) {
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poAPI = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
        this.mContext = mContext;
    }

    public void AddClient(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception{
        if(!gcardInfo.isDataValid()){
            callback.OnFailed(gcardInfo.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(poAPI.getAddNewGCardAPI(), gcardInfo.getJSONParameters(), poHeaders.getHeaders());
            if(lsResponse == null){
                callback.OnFailed("No server response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.OnSuccess(lsResponse);
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsCode = loError.getString("code");
                    if(lsCode.equalsIgnoreCase("CNF")){
                        callback.OnFailed(loError.toString());
                    } else {
                        String lsMessage = loError.getString("message");
                        callback.OnFailed(lsMessage);
                    }
                }
            }
        }
    }


}
