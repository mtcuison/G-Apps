package org.rmj.g3appdriver.lib.CreditApp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;

import java.util.ArrayList;
import java.util.List;

public class CreditApplication {
    private final String TAG = CreditApplication.class.getSimpleName();

    private final Context mContext;

    private final GuanzonAppConfig poConfig;
    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;

    private String message;

    public CreditApplication(Context mContext) {
        this.mContext = mContext;
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public String getMessage() {
        return message;
    }

    public List<LoanTerm> GetLoanTerms(String args){
        try{
            JSONObject params = new JSONObject();
            params.put("sModelID", args);

            //TODO: Create new API for retrieving installment term details for the selected item on marketplace...
            String lsResponse = WebClient.httpsPostJSon(
                    "",
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

            JSONArray jaDetail = loResponse.getJSONArray("detail");
            List<LoanTerm> loTerms = new ArrayList<>();

            for(int x = 0; x < jaDetail.length(); x++){
                LoanTerm loanTerm = new LoanTerm("", "", "", "");
                loTerms.add(loanTerm);
            }

            return loTerms;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    //TODO: Download Means Info
    public String GetAccountVerificationInfo(){
        try{
            String lsResponse = WebClient.httpsPostJSon(
                    "",
                    new JSONObject().toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            return loResponse.getString("payload");
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    //TODO: Submit Credit Online Application
    public boolean SubmitApplication(String fsVal){
        try{
            JSONObject params = new JSONObject();
            params.put("", fsVal);

            String lsResponse = WebClient.httpsPostJSon(
                    "",
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response";
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
