package org.guanzongroup.com.creditapp.Obj;

import org.json.JSONObject;

public class OtherInfo {

    private final JSONObject params = new JSONObject();

    private String sOthrIncm = "";
    private String nOthrIncm = "";
    private String sBankName = "";
    private String sAcctType = "";
    private String sFBAcctxx = "";

    private String message;

    public OtherInfo() {
        try {
            params.put("cSourceCD", sOthrIncm);
            params.put("sPosition", nOthrIncm);
            params.put("sIndustry", sBankName);
            params.put("sCompName", sAcctType);
            params.put("nSalaryxx", sFBAcctxx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getOtherIncome() {
        return sOthrIncm;
    }

    public void setOtherIncome(String sOthrIncm) {
        this.sOthrIncm = sOthrIncm;
    }

    public String getEstimatedIncome() {
        return nOthrIncm;
    }

    public void setEstimatedIncome(String nOthrIncm) {
        this.nOthrIncm = nOthrIncm;
    }

    public String getBankName() {
        return sBankName;
    }

    public void setBankName(String sBankName) {
        this.sBankName = sBankName;
    }

    public String getAccountType() {
        return sAcctType;
    }

    public void setAccountType(String sAcctType) {
        this.sAcctType = sAcctType;
    }

    public String getFacebookAccount() {
        return sFBAcctxx;
    }

    public void setFacebookAccount(String sFBAcctxx) {
        this.sFBAcctxx = sFBAcctxx;
    }

    public boolean isDataValid() {
        if (sOthrIncm.trim().isEmpty() && nOthrIncm.trim().isEmpty()) {
            message = "Please enter estimated income.";
            return false;
        } else if (sBankName.trim().isEmpty() && sAcctType.trim().isEmpty()) {
            message = "Please enter account type.";
            return false;
        } else {
            return true;
        }
    }

    public JSONObject getData() {
        try {
            params.put("cSourceCD", sOthrIncm);
            params.put("sPosition", nOthrIncm);
            params.put("sIndustry", sBankName);
            params.put("sCompName", sAcctType);
            params.put("nSalaryxx", sFBAcctxx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
}
