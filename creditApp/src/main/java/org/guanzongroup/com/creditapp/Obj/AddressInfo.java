package org.guanzongroup.com.creditapp.Obj;

import org.json.JSONObject;

public class AddressInfo {

    private final JSONObject params = new JSONObject();

    private String sHouseNo = "";
    private String sAddress = "";
    private String sBrgyIDx = "";
    private String sTownIDx = "";
    private String sProvIDx = "";
    private String sBrgyNme = "";
    private String sTownNme = "";
    private String sProvNme = "";


    private String message;

    public AddressInfo() {
        try {
            params.put("sHouseNo", sHouseNo);
            params.put("sAddress", sAddress);
            params.put("sBrgyIDx", sBrgyIDx);
            params.put("sTownIDx", sTownIDx);
            params.put("sProvIDx", sProvIDx);
            params.put("sBrgyNme", sBrgyNme);
            params.put("sTownNme", sTownNme);
            params.put("sProvNme", sProvNme);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        return message;
    }

    public String getHouseNo() {
        return sHouseNo;
    }

    public void setHouseNo(String sHouseNo) {
        this.sHouseNo = sHouseNo;
    }

    public String getAddress() {
        return sAddress;
    }

    public void setAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getTownID() {
        return sTownIDx;
    }

    public void setTownID(String sTownIDx) {
        this.sTownIDx = sTownIDx;
    }

    public String getBarangayID() {
        return sBrgyIDx;
    }

    public void setBarangayID(String sBrgyIDx) {
        this.sBrgyIDx = sBrgyIDx;
    }

    public String getProvinceID() {
        return sProvIDx;
    }

    public void setProvinceID(String sProvIDx) {
        this.sProvIDx = sProvIDx;
    }

    public String getBarangayName() {
        return sBrgyNme;
    }

    public void setBarangayName(String sTownNme) {
        this.sBrgyNme = sTownNme;
    }

    public String getTownName() {
        return sTownNme;
    }

    public void setTownName(String sTownNme) {
        this.sTownNme = sTownNme;
    }

    public String getProvinceName() {
        return sProvNme;
    }

    public void setProvinceName(String sProvNme) {
        this.sProvNme = sProvNme;
    }

    public boolean isDataValid() {
        if (sBrgyIDx.trim().isEmpty()) {
            message = "Unset barangay id detected.";
            return false;
        }
        if (sTownIDx.trim().isEmpty()) {
            message = "Unset town id detected.";
            return false;
        }
        if (sProvIDx.trim().isEmpty()) {
            message = "Unset province id detected.";
            return false;
        } else {
            return true;
        }
    }

    public JSONObject getData() {
        try {
            params.put("sHouseNo", sHouseNo);
            params.put("sAddress", sAddress);
            params.put("sBrgyIDx", sBrgyIDx);
            params.put("sTownIDx", sTownIDx);
            params.put("sProvIDx", sProvIDx);
            params.put("sBrgyNme", sBrgyNme);
            params.put("sTownNme", sTownNme);
            params.put("sProvNme", sProvNme);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

}
