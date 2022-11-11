package org.rmj.g3appdriver.lib.CreditApp.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class PersonalInfo {
    private static final String TAG = PersonalInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private final AddressInfo poAddxx = new AddressInfo();

    private String message;

    public PersonalInfo() {
        try{
            params.put("sLastName", "");
            params.put("sFrstName", "");
            params.put("sMiddName", "");
            params.put("sSuffixxx", "");
            params.put("cCvilStat", "");
            params.put("cGenderxx", "");
            params.put("sMaidenNm", "");
            params.put("sFBAcctxx", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getClientName() throws Exception{
        String lsClient = "";
        if(params.has("sLastName")){
            lsClient = params.getString("sLastName");
        }

        if(params.has("sFrstName")){
            lsClient = lsClient + ", " + params.getString("sFrstName");
        }

        if(params.has("sMiddName")){
            lsClient = lsClient + " " + params.getString("sMiddName");
        }

        if(params.has("sSuffixxx")) {
            lsClient = lsClient + " " + params.getString("sSuffixxx");
        }

        return lsClient;
    }

    public String getLastName() throws JSONException {
        if(params.has("sLastName")) {
            return params.getString("sLastName");
        }
        return "";
    }

    public void setLastName(String sLastName) throws JSONException {
        params.put("sLastName", sLastName);
    }

    public String getFirstName() throws JSONException {
        if(params.has("sFrstName")) {
            return params.getString("sFrstName");
        }
        return "";
    }

    public void setFirstName(String sFrstName) throws JSONException {
        params.put("sFrstName", sFrstName);
    }

    public String getMiddleName() throws JSONException {
        if(params.has("sMiddName")) {
            return params.getString("sMiddName");
        }
        return "";
    }

    public void setMiddleName(String sMiddName) throws JSONException {
        params.put("sMiddName", sMiddName);
    }

    public String getSuffix() throws JSONException {
        if(params.has("sSuffixxx")) {
            return params.getString("sSuffixxx");
        }
        return "";
    }

    public void setSuffix(String sSuffixxx) throws JSONException {
        params.put("sSuffixxx", sSuffixxx);
    }

    public String getMotherMaidenName() throws JSONException {
        if(params.has("sMaidenNm")) {
            return params.getString("sMaidenNm");
        }
        return "";
    }

    public void setMotherMaidenName(String sMaidenNm) throws JSONException {
        params.put("sMaidenNm", sMaidenNm);
    }

    public String getGender() throws JSONException {
        if(params.has("cGenderxx")) {
            return params.getString("cGenderxx");
        }
        return "";
    }

    public void setGender(String cGenderxx) throws JSONException {
        params.put("cGenderxx", cGenderxx);
    }

    public String getCivilStatus() throws JSONException {
        if(params.has("cCvilStat")) {
            return params.getString("cCvilStat");
        }
        return "";
    }

    public void setCivilStatus(String cCvilStat) throws JSONException {
        params.put("cCvilStat", cCvilStat);
    }

    public boolean isDataValid() throws JSONException {
        if(params.getString("sLastName").trim().isEmpty()){
            message = "Unset last name detected.";
            return false;
        }else if(params.getString("sFrstName").trim().isEmpty()){
            message = "Unset first name detected.";
            return false;
        }else if(params.getString("sMiddName").trim().isEmpty()){
            message = "Unset middle name detected.";
            return false;
        }else if(params.getString("cGenderxx").trim().isEmpty()){
            message = "Unset gender detected.";
            return false;
        }else if(params.getString("cCvilStat").trim().isEmpty()){
            message = "Unset civil status detected.";
            return false;
        } else {
            return true;
        }
    }

    public AddressInfo addressInfo() {
        return poAddxx;
    }

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("personal_info");
        poAddxx.setData(params.toString());
    }

    public JSONObject getData() throws JSONException{
        params.put("address", poAddxx.getData());
        Log.d(TAG, params.toString());
        return params;
    }


    public static class AddressInfo {

        private JSONObject params = new JSONObject();

        private String message;

        public AddressInfo() {
            try{
                params.put("sLandMark", "");
                params.put("sHouseNox", "");
                params.put("sAddress1", "");
                params.put("sAddress2", "");
                params.put("sBrgyIDxx", "");
                params.put("sTownIDxx", "");
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public String getMessage() {
            return message;
        }

        public String getLandMark() throws JSONException {
            if(params.has("sLandMark")) {
                return params.getString("sLandMark");
            }
            return "";
        }

        public void setLandMark(String sHouseNo) throws JSONException {
            params.put("sLandMark", sHouseNo);
        }

        public String getHouseNo() throws JSONException {
            if(params.has("sHouseNox")) {
                return params.getString("sHouseNox");
            }
            return "";
        }

        public void setHouseNo(String sHouseNo) throws JSONException {
            params.put("sHouseNox", sHouseNo);
        }

        public String getAddress1() throws JSONException {
            if(params.has("sAddress1")) {
                return params.getString("sAddress1");
            }
            return "";
        }

        public void setAddress1(String sAddress) throws JSONException {
            params.put("sAddress1", sAddress);
        }

        public void setAddress2(String sAddress) throws JSONException {
            params.put("sAddress2", sAddress);
        }

        public String getAddress2() throws JSONException {
            if(params.has("sAddress2")) {
                return params.getString("sAddress2");
            }
            return "";
        }

        public String getTownID() throws JSONException {
            if(params.has("sTownIDxx")) {
                return params.getString("sTownIDxx");
            }
            return "";
        }

        public String getBarangayID() throws JSONException {
            if(params.has("sBrgyIDxx")) {
                return params.getString("sBrgyIDxx");
            }
            return "";
        }

        public void setBarangayID(String sBrgyIDx) throws JSONException {
            params.put("sBrgyIDxx", sBrgyIDx);
        }

        public void setTownID(String sTownIDx) throws JSONException {
            params.put("sTownIDxx", sTownIDx);
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
            params = loJson.getJSONObject("address");
        }

        public JSONObject getData() {
            Log.d(TAG, params.toString());
            return params;
        }
    }
}
