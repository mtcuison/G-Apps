package org.rmj.guanzongroup.useraccount.Model;

public class ShippingInfoModel {

    private String sClientId = "";
    private String sMobileNo = "";
    private String sHouseNox = "";
    private String sAddressx = "";
    private String sTownCtId = "";
    private String sBrngayId = "";

    private String message = "";

    public ShippingInfoModel(String sClientId) {
        this.sClientId = sClientId;
    }

    public void setMobileN(String sMobileNo)
    {
        this.sMobileNo = sMobileNo;
    }

    public void setHouseNo(String sHouseNox) {
        this.sHouseNox = sHouseNox;
    }

    public void setAddress(String sAddressx) {
        this.sAddressx = sAddressx;
    }

    public void setTownCty(String sTownCtId) {
        this.sTownCtId = sTownCtId;
    }

    public void setBarngay(String sBrngayId) {
        this.sBrngayId = sBrngayId;
    }

    public String getClientId() {
        return sClientId;
    }

    public String getMobileN() {
        return sMobileNo;
    }

    public String getHouseNo() {
        return sHouseNox;
    }

    public String getAddress() {
        return sAddressx;
    }

    public String getTownCty() {
        return sTownCtId;
    }

    public String getBarngay() {
        return sBrngayId;
    }

    public String getErrorMessage() {
        return message;
    }

    public boolean isAddressComplete() {
        if("".equalsIgnoreCase(sMobileNo)){
            message = "Please enter mobile number.";
            return false;
        }else if(sMobileNo.length() != 11 || sMobileNo.length() < 2){
            message = "Mobile number must be 11 characters.";
            return false;
        } else if(!sMobileNo.substring(0, 2).equalsIgnoreCase("09")){
            message = "Mobile number must start with '09'.";
            return false;
        }  else if("".equalsIgnoreCase(sHouseNox)) {
            message = "Please enter House or Building number.";
            return false;
        } else if ("".equalsIgnoreCase(sAddressx)) {
            message = "Please enter Street Address.";
            return false;
        } else if ("".equalsIgnoreCase(sTownCtId)) {
            message = "Please enter Town or City.";
            return false;
        } else if ("".equalsIgnoreCase(sBrngayId)) {
            message = "Please enter Barangay.";
            return false;
        }
         else {
             return true;
        }
    }

}
