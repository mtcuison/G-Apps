package org.guanzongroup.com.creditapp.Obj;

import org.json.JSONObject;

public class PersonalInfo {

    private final JSONObject params = new JSONObject();

    private String sLastName = "";
    private String sFrstName = "";
    private String sMiddName = "";
    private String sSuffixxx = "";
    private String sMaidenNm = "";
    private String cGenderxx = "";
    private String cCvilStat = "";

    private String message;

    public PersonalInfo() {
        try{
            params.put("sLastName", sLastName);
            params.put("sFrstName", sFrstName);
            params.put("sMiddName", sMiddName);
            params.put("sSuffixxx", sSuffixxx);
            params.put("sMaidenNm", sMaidenNm);
            params.put("cGenderxx", cGenderxx);
            params.put("cCvilStat", cCvilStat);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getFirstName() {
        return sFrstName;
    }

    public void setFirstName(String sFrstName) {
        this.sFrstName = sFrstName;
    }

    public String getMiddleName() {
        return sMiddName;
    }

    public void setMiddleName(String sMiddName) {
        this.sMiddName = sMiddName;
    }

    public String getSuffix() {
        return sSuffixxx;
    }

    public void setSuffix(String sSuffixxx) {
        this.sSuffixxx = sSuffixxx;
    }

    public String getMotherMaidenName() {
        return sMaidenNm;
    }

    public void setMotherMaidenName(String sMaidenNm) {
        this.sMaidenNm = sMaidenNm;
    }

    public String getGender() {
        return cGenderxx;
    }

    public void setGender(String cGenderxx) {
        this.cGenderxx = cGenderxx;
    }

    public String getCivilStatus() {
        return cCvilStat;
    }

    public void setCivilStatus(String cCvilStat) {
        this.cCvilStat = cCvilStat;
    }

    public boolean isDataValid(){
        if(sLastName.trim().isEmpty()){
            message = "Unset last name detected.";
            return false;
        }else if(sFrstName.trim().isEmpty()){
            message = "Unset first name detected.";
            return false;
        }else if(sMiddName.trim().isEmpty()){
            message = "Unset middle name detected.";
            return false;
        }else if(cGenderxx.trim().isEmpty()){
            message = "Unset gender detected.";
            return false;
        }else if(cCvilStat.trim().isEmpty()){
            message = "Unset civil status detected.";
            return false;
        } else {
            return true;
        }
    }

    public JSONObject getData(){
        try{
            params.put("sLastName", sLastName);
            params.put("sFrstName", sFrstName);
            params.put("sMiddName", sMiddName);
            params.put("sSuffixxx", sSuffixxx);
            params.put("sMaidenNm", sMaidenNm);
            params.put("cGenderxx", cGenderxx);
            params.put("cCvilStat", cCvilStat);
        } catch (Exception e){
            e.printStackTrace();
        }
        return params;
    }
}
