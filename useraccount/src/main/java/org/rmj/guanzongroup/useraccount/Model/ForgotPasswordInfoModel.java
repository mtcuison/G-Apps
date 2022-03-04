package org.rmj.guanzongroup.useraccount.Model;

import org.rmj.guanzongroup.useraccount.Etc.LogType;

public class ForgotPasswordInfoModel {
    private final LogType poLogType;
    private String sEmailAdd = "";
    private String sMobileNo = "";
    private String sMessagex = "";

    public ForgotPasswordInfoModel(LogType foLogType) {
        this.poLogType = foLogType;
    }

    public String getMessage() {
        return sMessagex;
    }

    public String getEmailAdd() {
        return sEmailAdd;
    }

    public void setEmailAdd(String sEmailAdd) {
        this.sEmailAdd = sEmailAdd;
    }

    public String getMobileNo() {
        return sMobileNo;
    }

    public void setMobileNo(String sMobileNo) {
        this.sMobileNo = sMobileNo;
    }

    public boolean isDataNotEmpty() {
        if(poLogType == LogType.EMAIL) {
            return isEmailNotEmpty();
        } else if(poLogType == LogType.MOBILE) {
            return isMobileNoClear();
        } else {
            sMessagex = "Log type provided is null";
            return false;
        }
    }

    private boolean isEmailNotEmpty() {
        if(sEmailAdd.isEmpty()) {
            sMessagex = "Please enter your email";
            return false;
        }
        return true;
    }

    private boolean isMobileNoClear() {
        if(sMobileNo.isEmpty()){
            sMessagex = "Please enter mobile number";
            return false;
        } else if(!sMobileNo.substring(0, 2).equalsIgnoreCase("09")){
            sMessagex = "Mobile number must start with '09'";
            return false;
        } else if(sMobileNo.length() != 11){
            sMessagex = "Mobile number must be 11 characters";
            return false;
        }
        return true;
    }

}
