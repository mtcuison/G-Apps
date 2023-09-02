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

    public List<PanaloRewards> GetRewards(String args){
        try{
            JSONObject params = new JSONObject();
            params.put("transtat", args);

            String lsResponse = WebClient.httpsPostJSon(
                    poApis.getUserPanaloRewardsAPI(),
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

            List<PanaloRewards> loRewards = new ArrayList<>();
            for(int x = 0; x < laJson.length(); x++){
                JSONObject joReward = laJson.getJSONObject(x);
                PanaloRewards loReward = new PanaloRewards();
                loReward.setPanaloQC(joReward.getString("sPanaloQC"));
                loReward.setTransact(joReward.getString("dTransact"));
                loReward.setUserIDxx(joReward.getString("sUserIDxx"));
                loReward.setPanaloCD(joReward.getString("sPanaloCD"));
                loReward.setPanaloDs(joReward.getString("sPanaloDs"));
                loReward.setAcctNmbr(joReward.getString("sAcctNmbr"));
                loReward.setAmountxx(joReward.getDouble("nAmountxx"));
                loReward.setDeviceID(joReward.getString("sDeviceID"));
                loReward.setExpiryDt(joReward.getString("dExpiryDt"));
                loReward.setItemCode(joReward.getString("sItemCode"));
                loReward.setItemDesc(joReward.getString("sItemDesc"));
                loReward.setItemQtyx(joReward.getInt("nItemQtyx"));
                loReward.setRedeemxx(joReward.getInt("nRedeemxx"));
                loReward.setTranStat(joReward.getString("cTranStat"));
                loReward.setTimeStmp(joReward.getString("dTimeStmp"));
                loReward.setRedeemDt(joReward.getString("dRedeemxx"));
                loReward.setBranchNm(joReward.getString("sBranchNm"));
                loReward.setSourceNm(joReward.getString("sSourceNm"));
                loRewards.add(loReward);
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
