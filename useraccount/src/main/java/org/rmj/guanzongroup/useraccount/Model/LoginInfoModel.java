package org.rmj.guanzongroup.useraccount.Model;

import org.rmj.guanzongroup.useraccount.Etc.LogType;

public class LoginInfoModel {
    private final LogType poLogType;
    private String sLogUserx = "";
    private String sPassword = "";
    private String sMessagex = "";

    public LoginInfoModel(LogType foLogType, String fsLogUser, String fsPasswrd) {
        this.poLogType = foLogType;
        this.sLogUserx = fsLogUser;
        this.sPassword = fsPasswrd;
    }

    public LogType getLogType() {
        return poLogType;
    }

    public String getLogUser() {
        return sLogUserx;
    }

    public String getPassword() {
        return sPassword;
    }

    public String getMessage() {
        return sMessagex;
    }

    public boolean isDataNotEmpty() {
        if(poLogType == LogType.EMAIL) {
            return isEmailNotEmpty() && isPasswordNotEmpty();
        } else if(poLogType == LogType.MOBILE) {
            return isMobileNoClear() && isPasswordNotEmpty();
        } else {
            sMessagex = "Log type provided is null";
            return false;
        }
    }

    private boolean isEmailNotEmpty() {
        if(sLogUserx.isEmpty()) {
            sMessagex = "Please enter your email";
            return false;
        }
        return true;
    }

    private boolean isMobileNoClear() {
        if(sLogUserx.isEmpty()){
            sMessagex = "Please enter mobile number";
            return false;
        } else if(!sLogUserx.substring(0, 2).equalsIgnoreCase("09")){
            sMessagex = "Mobile number must start with '09'";
            return false;
        } else if(sLogUserx.length() != 11){
            sMessagex = "Mobile number must be 11 characters";
            return false;
        }
        return true;
    }

    private boolean isPasswordNotEmpty() {
        if(sPassword.isEmpty()) {
            sMessagex = "Please enter your password";
            return false;
        }
         return true;
    }

}
