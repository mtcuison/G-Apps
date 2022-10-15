package org.rmj.g3appdriver.lib.Account;

import android.app.Application;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.WebFileServer;
import org.rmj.g3appdriver.lib.Account.Obj.PhotoDetail;
import org.rmj.g3appdriver.lib.Account.Obj.UserIdentification;

import java.util.ArrayList;
import java.util.List;

public class AccountVerification {
    private static final String TAG = AccountVerification.class.getSimpleName();

    private final Application mContext;

    private final RClientInfo poClient;
    private final GuanzonAppConfig poConfig;
    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;

    private String message;

    public AccountVerification(Application context) {
        this.mContext = context;
        this.poClient = new RClientInfo(mContext);
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public String getMessage() {
        return message;
    }

    public String GetMobileNo(){
        return poClient.GetClientInfo().getMobileNo();
    }

    public String SendOTP(String fsVal){
        try{
            if(fsVal.trim().isEmpty()){
                message = "Please enter mobile no.";
                return null;
            }

            JSONObject params = new JSONObject();
            params.put("sMobileNo", fsVal);

            String lsAddress = "";
            String lsResponse = WebClient.httpsPostJSon(
                    lsAddress,
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response.";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            String lsOtp = loResponse.getString("OTP");
            return lsOtp;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public List<UserIdentification> ImportIDCode(){
        try {
            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getImportValidIdCodeAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());

            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            JSONArray laJson = loResponse.getJSONArray("detail");
            List<UserIdentification> idCode = new ArrayList<>();
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loDetail = laJson.getJSONObject(x);

                UserIdentification loID = new UserIdentification(
                        loDetail.getString("sIDNamexx"),
                        loDetail.getString("sIDCodexx"),
                        loDetail.getString("cWithBack"),
                        loDetail.getString("cWithExpr"));

                idCode.add(loID);
            }
            return idCode;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public boolean SubmitIDVerification(String args, String args1){
        try{
            EClientInfo loUser = poClient.GetClientInfo();

            if(loUser == null){
                message = "Unable to retrieve client detail. Please re-login your account.";
                return false;
            }

            PhotoDetail loPhoto = new PhotoDetail();
            loPhoto.setCaptured(new AppConstants().DATE_MODIFIED);
            loPhoto.setFileCode(AppConstants.DOC_FILE_VALID_ID);
            loPhoto.setSourceCD(AppConstants.SOURCE_CODE);
            loPhoto.setDtlSrcNo(loUser.getUserIDxx());
            loPhoto.setSourceNo(loUser.getUserIDxx());
            loPhoto.setFileLoct(args);
            loPhoto.setImageNme(args1);

            String lsProdct = new GuanzonAppConfig(mContext).getProductID();
            String lsClient = loUser.getClientID();
            String lsUserID = loUser.getUserIDxx();

            String lsClntTk = WebFileServer.RequestClientToken(lsProdct, lsClient, lsUserID);
            if(new GuanzonAppConfig(mContext).getTestCase()){
                return true;
            } else if(lsClntTk == null){
                message = "Unable to generate client. Please try again later.";
                return false;
            } else if(lsClntTk.isEmpty()){
                message = "Unable to generate client. Please try again later.";
                return false;
            }

            String lsAccess = WebFileServer.RequestAccessToken(lsClntTk);
            if(lsAccess == null){
                message = "Unable to generate access token. Please try again later.";
                return false;
            } else if(lsAccess.isEmpty()){
                message = "Unable to generate access token. Please try again later.";
                return false;
            }

            org.json.simple.JSONObject loResponse = WebFileServer.UploadFile(
                    loPhoto.getFileLoct(),
                    lsAccess,
                    loPhoto.getFileCode(),
                    loPhoto.getDtlSrcNo(),
                    loPhoto.getImageNme(),
                    loPhoto.getDtlSrcNo(),
                    loPhoto.getSourceCD(),
                    loPhoto.getSourceNo(),
                    "");

            if (loResponse == null) {
                message = "Upload failed. Server no response.";
                return false;
            }

            String lsResult = (String) loResponse.get("result");

            if (lsResult.equalsIgnoreCase("error")) {
                JSONObject loError = new JSONObject((String) loResponse.get("error"));
                message = loError.getString("message");
                Log.e(TAG, loError.toString());
                return false;
            }

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SubmitSelfieVerification(String fsDtrn,
                                            String fsName,
                                            String fsHash,
                                            String fsPath,
                                            String fsDate){
        try{
            JSONObject params = new JSONObject();
            params.put("dTransact", fsDtrn);
            params.put("sImageNme", fsName);
            params.put("sMD5Hashx", fsHash);
            params.put("sImagePth", fsPath);
            params.put("dImgeDate", fsDate);

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getSubmitSelfieVerificationAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
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

    public boolean SubmitIDVerification(JSONObject foVal){
        try{
            JSONObject params = new JSONObject();
            params.put("dTransact", new AppConstants().DATE_MODIFIED);
            params.put("sIDCodex1", foVal.getString("sIDName1x"));
            params.put("sIDNoxxx1", foVal.getString("sIDNmbr1x"));
            params.put("sIDFrntx1", foVal.getString("sIDFrnt1x"));
            params.put("sIDBackx1", foVal.getString("sIDBack1x"));
            params.put("dIDExpry1", foVal.getString("dExpiry1x"));
            params.put("sIDCodex2", foVal.getString("sIDName2x"));
            params.put("sIDNoxxx2", foVal.getString("sIDNmbr2x"));
            params.put("sIDFrntx2", foVal.getString("sIDFrnt2x"));
            params.put("sIDBackx2", foVal.getString("sIDBack2x"));
            params.put("dIDExpry2", foVal.getString("dExpiry2x"));

            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getSubmitIdVerificationAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());

            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
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

    //TODO: create new api for saving means info and use this method to test the api and this class at the same time...
    public boolean SubmitMeansInfo(String fsVal){
        try{
            JSONObject params = new JSONObject();
            params.put("sMeansInf", fsVal);

            String lsResponse = WebClient.httpsPostJSon(
                    "",
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null) {
                message = "Server no response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
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

    //TODO: create new api for saving other info and use this method to test the api and this class at the same time...
    public boolean SubmitOtherInfo(String fsVal){
        try{
            JSONObject params = new JSONObject();
            params.put("sMeansInf", fsVal);

            String lsResponse = WebClient.httpsPostJSon(
                    "",
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null) {
                message = "Server no response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
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
}
