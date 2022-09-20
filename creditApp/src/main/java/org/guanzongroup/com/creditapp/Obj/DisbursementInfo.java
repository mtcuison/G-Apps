package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class DisbursementInfo {
    private static final String TAG = DisbursementInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private BankInfo bankInfo = new BankInfo();

    private String message;

    public DisbursementInfo() {

    }

    public String getMessage() {
        return message;
    }

    public BankInfo bankInfo() {
        return bankInfo;
    }

    public boolean isDataValid() throws JSONException {
        if(!bankInfo.isDataValid()){
            message = bankInfo.getMessage();
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("disbursement_info");
        bankInfo.setData(params.toString());
    }

    public JSONObject getData() throws JSONException{
        params.put("bank_account", bankInfo.getData());
        Log.d(TAG, params.toString());
        return params;
    }

    public static class BankInfo{

        private JSONObject params = new JSONObject();

        private String message;

        public BankInfo() {

        }

        public String getMessage() {
            return message;
        }

        public String getAccountType() throws JSONException {
            if(params.has("sAcctType")) {
                return params.getString("sAcctType");
            }
            return "";
        }

        public void setAccountType(String sAcctType) throws JSONException{
            params.put("sAcctType", sAcctType);
        }

        public String getBankName() throws JSONException {
            if(params.has("sBankName")) {
                return params.getString("sBankName");
            }
            return "";
        }

        public void setBankName(String sFBAcctxx) throws JSONException{
            params.put("sBankName", sFBAcctxx);
        }

        public boolean isDataValid() throws JSONException {
            if(params.getString("sAcctType").trim().isEmpty() &&
                    params.getString("sAcctType").trim().isEmpty()){
                message = "Please select account type.";
                return false;
            } else if(params.getString("sBankName").trim().isEmpty() &&
                    params.getString("sBankName").trim().isEmpty()){
                message = "Please enter bank name.";
                return false;
            } else {
                return true;
            }
        }

        public void setData(String fsVal) throws JSONException{
            JSONObject loJson = new JSONObject(fsVal);
            params = loJson.getJSONObject("bank_account");
        }

        public JSONObject getData(){
            Log.d(TAG, params.toString());
            return params;
        }
    }
}
