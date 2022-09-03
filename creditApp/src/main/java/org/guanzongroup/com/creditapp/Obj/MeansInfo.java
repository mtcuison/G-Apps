package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MeansInfo {
    private static final String TAG = MeansInfo.class.getSimpleName();

    private JSONObject params = new JSONObject();

    private String message;

    public MeansInfo() {
        try{
            params.put("cSourceCD", "");
            params.put("sPosition", "");
            params.put("sIndustry", "");
            params.put("sCompName", "");
            params.put("nSalaryxx", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getSourceCD() throws JSONException{
        if(params.has("cSourceCD")) {
            return params.getString("cSourceCD");
        }
        return "";
    }

    public void setSourceCD(String cSourceCD) throws JSONException{
        params.put("cSourceCD", cSourceCD);
    }

    public String getPosition() throws JSONException{
        if(params.has("sPosition")) {
            return params.getString("sPosition");
        }
        return "";
    }

    public void setPosition(String sPosition) throws JSONException{
        params.put("sPosition", sPosition);
    }

    public String getIndustry() throws JSONException{
        if(params.has("sIndustry")) {
            return params.getString("sIndustry");
        }
        return "";
    }

    public void setIndustry(String sIndustry) throws JSONException{
        params.put("sIndustry", sIndustry);
    }

    public String getCompanyName() throws JSONException{
        if(params.has("sCompName")) {
            return params.getString("sCompName");
        }
        return "";
    }

    public void setCompanyName(String sCompName) throws JSONException{
        params.put("sCompName", sCompName);
    }

    public String getSalary() throws JSONException{
        if(params.has("nSalaryxx")) {
            return params.getString("nSalaryxx");
        }
        return "";
    }

    public void setSalary(String nSalaryxx) throws JSONException{
        params.put("nSalaryxx", nSalaryxx);
    }

    public boolean isDataValid() throws JSONException{
        if(params.getString("cSourceCD").trim().isEmpty()){
            message = "Please provide source of income.";
            return false;
        } else if(params.getString("sPosition").trim().isEmpty()){
            message = "Please enter position.";
            return false;
        } else if(params.getString("sIndustry").trim().isEmpty()){
            message = "Please enter business industry.";
            return false;
        } else if(params.getString("sCompName").trim().isEmpty()){
            message = "Please enter company name.";
            return false;
        } else if(params.getString("nSalaryxx").trim().isEmpty()){
            message = "Please enter estimated salary.";
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException{
        JSONObject loJson = new JSONObject(fsVal);
        params = loJson.getJSONObject("means_info");
    }

    public JSONObject getData(){
        Log.d(TAG, params.toString());
        return params;
    }
}
