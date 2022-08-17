package org.guanzongroup.com.creditapp.Obj;

import org.json.JSONObject;

public class MeansInfo {

    private final JSONObject params = new JSONObject();

    private String cSourceCD = "";
    private String sPosition = "";
    private String sIndustry = "";
    private String sCompName = "";
    private String nSalaryxx = "";

    private String message;

    public MeansInfo() {
        try{
            params.put("cSourceCD", cSourceCD);
            params.put("sPosition", sPosition);
            params.put("sIndustry", sIndustry);
            params.put("sCompName", sCompName);
            params.put("nSalaryxx", nSalaryxx);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getSourceCD() {
        return cSourceCD;
    }

    public void setSourceCD(String cSourceCD) {
        this.cSourceCD = cSourceCD;
    }

    public String getPosition() {
        return sPosition;
    }

    public void setPosition(String sPosition) {
        this.sPosition = sPosition;
    }

    public String getIndustry() {
        return sIndustry;
    }

    public void setIndustry(String sIndustry) {
        this.sIndustry = sIndustry;
    }

    public String getCompanyName() {
        return sCompName;
    }

    public void setCompanyName(String sCompName) {
        this.sCompName = sCompName;
    }

    public String getSalary() {
        return nSalaryxx;
    }

    public void setSalary(String nSalaryxx) {
        this.nSalaryxx = nSalaryxx;
    }

    public boolean isDataValid(){
        if(cSourceCD.trim().isEmpty()){
            message = "Please provide source of income.";
            return false;
        } else if(sPosition.trim().isEmpty()){
            message = "Please enter position.";
            return false;
        } else if(sIndustry.trim().isEmpty()){
            message = "Please enter business industry.";
            return false;
        } else if(sCompName.trim().isEmpty()){
            message = "Please enter company name.";
            return false;
        } else if(nSalaryxx.trim().isEmpty()){
            message = "Please enter estimated salary.";
            return false;
        } else {
            return true;
        }
    }

    public JSONObject getData(){
        try{
            params.put("cSourceCD", cSourceCD);
            params.put("sPosition", sPosition);
            params.put("sIndustry", sIndustry);
            params.put("sCompName", sCompName);
            params.put("nSalaryxx", nSalaryxx);
        } catch (Exception e){
            e.printStackTrace();
        }
        return params;
    }
}
