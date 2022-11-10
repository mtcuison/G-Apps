package org.rmj.g3appdriver.lib.CreditApp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;
import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;

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
            params.put("paymform", "1");
            params.put("modelid", args);

            //TODO: Create new API for retrieving installment term details for the selected item on marketplace...
//            String lsResponse = "{\"result\":\"success\",\"payload\":{\"master\":{\"sModelIDx\":\"C00119005\",\"sModelNme\":\"Galaxy S10+\",\"sModelCde\":\"G975F\\/DS\",\"nRebatesx\":0,\"nEndMrtgg\":0,\"nOthersxx\":0},\"detail\":[{\"nMinDownx\":16317,\"nMiscChrg\":1920,\"nMonAmort\":900},{\"nMinDownx\":16317,\"nMiscChrg\":1920,\"nMonAmort\":700},{\"nMinDownx\":16317,\"nMiscChrg\":1920,\"nMonAmort\":450},{\"nMinDownx\":16317,\"nMiscChrg\":1920,\"nMonAmort\":300}]}}";
            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getDownloadPriceListAPI(),
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

            JSONObject loPayload = loResponse.getJSONObject("payload");
            JSONObject joMaster = loPayload.getJSONObject("master");

            JSONArray jaDetail = loPayload.getJSONArray("detail");
            List<LoanTerm> loTerms = new ArrayList<>();

            for(int x = 0; x < jaDetail.length(); x++){
                JSONObject loJson = jaDetail.getJSONObject(x);
                if(!loJson.getString("nMonAmort").equalsIgnoreCase("0")) {
                    String lsTerm;
                    switch (x){
                        case 0:
                            lsTerm = "3 Months";
                            break;
                        case 1:
                            lsTerm = "6 Months";
                            break;
                        case 2:
                            lsTerm = "9 Months";
                            break;
                        case 3:
                            lsTerm = "12 Months";
                            break;
                        default:
                            lsTerm = "24 Months";
                            break;
                    }
                    LoanTerm loanTerm = new LoanTerm(
                            lsTerm,
                            loJson.getString("nMonAmort"),
                            loJson.getString("nMinDownx"),
                            loJson.getString("nMiscChrg"));
                    loTerms.add(loanTerm);
                }
            }

            return loTerms;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public String GetOtherApplicationInfo(){
        try{
            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getOtherApplicationInfo(),
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

    public boolean SubmitApplication(String fsVal){
        try{
            MpCreditApp loApp = new MpCreditApp();
            loApp.setData(fsVal);
            JSONObject params = new JSONObject(fsVal);
            params.put("sBranchCd", "M001");
            params.put("dAppliedx", new AppConstants().DATE_MODIFIED);
            params.put("sClientNm", loApp.clientInfo().getClientName());
            params.put("cUnitAppl", loApp.getUnitType());
            params.put("nDownPaym", loApp.getDownpayment());
            params.put("dCreatedx", new AppConstants().DATE_MODIFIED);

            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getSubmitLoanApplication(),
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
