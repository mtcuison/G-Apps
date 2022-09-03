package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class AddressInfo {
    private static final String TAG = AddressInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private String message;

    public AddressInfo() {
        try{
            params.put("sHouseNo", "");
            params.put("sAddress", "");
            params.put("sBrgyIDx", "");
            params.put("sTownIDx", "");
            params.put("sProvIDx", "");
            params.put("sBrgyNme", "");
            params.put("sTownNme", "");
            params.put("sProvNme", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getHouseNo() throws JSONException {
        if(params.has("sHouseNo")) {
            return params.getString("sHouseNo");
        }
        return "";
    }

    public void setHouseNo(String sHouseNo) throws JSONException {
        params.put("sHouseNo", sHouseNo);
    }

    public String getAddress() throws JSONException {
        if(params.has("sAddress")) {
            return params.getString("sAddress");
        }
        return "";
    }

    public void setAddress(String sAddress) throws JSONException {
        params.put("sAddress", sAddress);
    }

    public String getTownID() throws JSONException {
        if(params.has("sTownIDx")) {
            return params.getString("sTownIDx");
        }
        return "";
    }

    public String getBarangayID() throws JSONException {
        if(params.has("sBrgyIDx")) {
            return params.getString("sBrgyIDx");
        }
        return "";
    }

    public void setBarangayID(String sBrgyIDx) throws JSONException {
        params.put("sBrgyIDx", sBrgyIDx);
    }

    public void setTownID(String sTownIDx) throws JSONException {
        params.put("sTownIDx", sTownIDx);
    }

    public String getProvinceID() throws JSONException {
        if(params.has("sProvIDx")) {
            return params.getString("sProvIDx");
        }
        return "";
    }

    public void setProvinceID(String sProvIDx) throws JSONException {
        params.put("sProvIDx", sProvIDx);
    }

    public String getBarangayName() throws JSONException {
        if(params.has("sBrgyNme")) {
            return params.getString("sBrgyNme");
        }
        return "";
    }

    public void setBarangayName(String sTownNme) throws JSONException {
        params.put("sTownNme", sTownNme);
    }

    public String getTownName() throws JSONException {
        if(params.has("sTownNme")) {
            return params.getString("sTownNme");
        }
        return "";
    }

    public void setTownName(String sTownNme) throws JSONException {
        params.put("sTownNme", sTownNme);
    }

    public String getProvinceName() throws JSONException {
        if(params.has("sProvNme")) {
            return params.getString("sProvNme");
        }
        return "";
    }

    public void setProvinceName(String sProvNme) throws JSONException {
        params.put("sProvNme", sProvNme);
    }

    public boolean isDataValid() throws JSONException{
        if(params.getString("sBrgyIDx").trim().isEmpty()){
            message = "Unset barangay id detected.";
            return false;
        }
        if(params.getString("sTownIDx").trim().isEmpty()){
            message = "Unset town id detected.";
            return false;
        }
        if(params.getString("sProvIDx").trim().isEmpty()){
            message = "Unset province id detected.";
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("address_info");
    }

    public JSONObject getData() {
        Log.d(TAG, params.toString());
        return params;
    }
}
