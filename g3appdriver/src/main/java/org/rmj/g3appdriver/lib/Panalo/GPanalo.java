package org.rmj.g3appdriver.lib.Panalo;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DPanalo;
import org.rmj.g3appdriver.dev.Database.Entities.EPanaloReward;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.ArrayList;
import java.util.List;

public class GPanalo {
    private static final String TAG = GPanalo.class.getSimpleName();

    private final Context mContext;

    private final DPanalo poDao;

    private final ServerAPIs poApis;
    private final GuanzonAppConfig poConfig;
    private final HttpHeaders poHeaders;

    private String message;

    public GPanalo(Context context) {
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).panaloDao();
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poApis = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public String getMessage() {
        return message;
    }

    public LiveData<EPanaloReward> GetPanaloNotice(){
        return poDao.GetPanaloRewardNotice();
    }

    public JSONObject GetRewardDetail(String args){
        try{
            JSONObject params = new JSONObject();
            params.put("sReferNox", args);

            String lsResponse = WebClient.httpsPostJSon(
                    poApis.getSendResponseAPI(),
                    params.toString(),
                    poHeaders.getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (!lsResult.equalsIgnoreCase("success")) {
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            return loResponse;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public boolean ClaimReward(String args){
        try{
            JSONObject params = new JSONObject();
            params.put("sReferNox", args);

            String lsResponse = WebClient.httpsPostJSon(
                    poApis.getSendResponseAPI(),
                    params.toString(),
                    poHeaders.getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (!lsResult.equalsIgnoreCase("success")) {
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return false;
            }

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public List<JSONObject> GetRewards(String args){
        try{

            JSONObject params = new JSONObject();
            params.put("sReferNox", args);

            String lsResponse = WebClient.httpsPostJSon(
                    poApis.getSendResponseAPI(),
                    params.toString(),
                    poHeaders.getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (!lsResult.equalsIgnoreCase("success")) {
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            JSONArray laJson = loResponse.getJSONArray("payload");

            List<JSONObject> loRewards = new ArrayList<>();
            for(int x = 0; x < laJson.length(); x++){
                loRewards.add(laJson.getJSONObject(x));
            }

            return loRewards;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public Bitmap RedeemReward(String args){
        try{

            return null;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }
}
