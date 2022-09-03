package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class OtherInfo {
    private static final String TAG = OtherInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private String message;

    public OtherInfo() {
        try{
            params.put("sOthrIncm", "");
            params.put("nOthrIncm", "");
            params.put("sBankName", "");
            params.put("sAcctType", "");
            params.put("sFBAcctxx", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getOtherIncome() throws JSONException {
        if(params.has("sOthrIncm")) {
            return params.getString("sOthrIncm");
        }
        return "";
    }

    public void setOtherIncome(String sOthrIncm) throws JSONException {
        params.put("sOthrIncm", sOthrIncm);
    }

    public String getEstimatedIncome() throws JSONException {
        if(params.has("nOthrIncm")) {
            return params.getString("nOthrIncm");
        }
        return "";
    }

    public void setEstimatedIncome(String nOthrIncm) throws JSONException{
        params.put("nOthrIncm", nOthrIncm);
    }

    public String getBankName() throws JSONException {
        if(params.has("sBankName")) {
            return params.getString("sBankName");
        }
        return "";
    }

    public void setBankName(String sBankName) throws JSONException{
        params.put("sBankName", sBankName);
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

    public String getFacebookAccount() throws JSONException {
        if(params.has("sFBAcctxx")) {
            return params.getString("sFBAcctxx");
        }
        return "";
    }

    public void setFacebookAccount(String sFBAcctxx) throws JSONException{
        params.put("sFBAcctxx", sFBAcctxx);
    }

    public boolean isDataValid() throws JSONException {
        if(params.getString("sOthrIncm").trim().isEmpty() &&
                params.getString("nOthrIncm").trim().isEmpty()){
            message = "Please enter estimated income.";
            return false;
        } else if(params.getString("sBankName").trim().isEmpty() &&
                params.getString("sAcctType").trim().isEmpty()){
            message = "Please enter account type.";
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("other_info");
    }

    public JSONObject getData(){
        Log.d(TAG, params.toString());
        return params;
    }
}
