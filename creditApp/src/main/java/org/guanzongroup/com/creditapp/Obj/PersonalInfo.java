package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class PersonalInfo {
    private static final String TAG = PersonalInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private String message;

    public PersonalInfo() {
        try{
            params.put("sLastName", "");
            params.put("sFrstName", "");
            params.put("sMiddName", "");
            params.put("sSuffixxx", "");
            params.put("sMaidenNm", "");
            params.put("cGenderxx", "");
            params.put("cCvilStat", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
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

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("personal_info");
    }

    public JSONObject getData(){
        Log.d(TAG, params.toString());
        return params;
    }
}
