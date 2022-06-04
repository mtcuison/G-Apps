package org.rmj.guanzongroup.useraccount.Model;

public class ShippingInfoModel {

    private String sHouseNox = "";
    private String sAddressx = "";
    private String sTownCtId = "";
    private String sBrngayId = "";

    private String message = "";

    public ShippingInfoModel() { }

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
        if("".equalsIgnoreCase(sHouseNox)) {
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
