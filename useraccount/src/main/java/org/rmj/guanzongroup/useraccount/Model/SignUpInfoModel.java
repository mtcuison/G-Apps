package org.rmj.guanzongroup.useraccount.Model;

public class SignUpInfoModel {

    private String sUserName = "";
    private String sEmailAdd = "";
    private String sMobileNo = "";
    private String sPassword = "";
    private String sPasswrd2 = "";

    private String message = "";

    public SignUpInfoModel() { }

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return sUserName;
    }

    public void setUserName(String sUserName) {
        this.sUserName = sUserName;
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

    public String getPassword() {
        return sPassword;
    }

    public void setPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public void setPasswrd2(String sPasswrd2) {
        this.sPasswrd2 = sPasswrd2;
    }

    public boolean isFormClear() {
        if(sUserName.isEmpty()){
            message = "Please enter username";
            return false;
        } else if(sEmailAdd.isEmpty()){
            message = "Please enter email";
            return false;
        } else if(sMobileNo.isEmpty()){
            message = "Please enter mobile number";
            return false;
        } else if(!sMobileNo.substring(0, 2).equalsIgnoreCase("09")){
            message = "Mobile number must start with '09'";
            return false;
        } else if(sMobileNo.length() != 11){
            message = "Mobile number must be 11 characters";
            return false;
        } if(sPassword.isEmpty()) {
            message = "Please enter password";
            return false;
        } else if(sPasswrd2.isEmpty()) {
            message = "Please re-type password";
            return false;
        } else if(!sPassword.equals(sPasswrd2)){
            message = "Passwords does not match";
            return false;
        } else if(sPassword.length() < 6){
            message = "Password is too short";
            return false;
        } else {
            return true;
        }
    }



}
