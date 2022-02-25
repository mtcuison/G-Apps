package org.rmj.guanzongroup.useraccount.Model;

public class SignUpInfoModel {

    private String sLastName = "";
    private String sFrstName = "";
    private String sMiddName = "";
    private String sSuffixNm = "";
    private String sEmailAdd = "";
    private String sMobileNo = "";
    private String sPassword = "";
    private String sPasswrd2 = "";

    private String message = "";

    public SignUpInfoModel() { }

    public String getMessage() {
        return message;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getFrstName() {
        return sFrstName;
    }

    public void setFrstName(String sFrstName) {
        this.sFrstName = sFrstName;
    }

    public String getMiddName() {
        return sMiddName;
    }

    public void setMiddName(String sMiddName) {
        this.sMiddName = sMiddName;
    }

    public String getSuffixNm() {
        return sSuffixNm;
    }

    public void setSuffixNm(String sSuffixNm) {
        this.sSuffixNm = sSuffixNm;
    }

    public String getEmailAdd() {
        return sEmailAdd;
    }

    public void setEmailAdd(String sEmailAdd) {
        this.sEmailAdd = sEmailAdd;
    }

    public String getPassword() {
        return sPassword;
    }

    public void setPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getMobileNo() {
        return sMobileNo;
    }

    public void setMobileNo(String sMobileNo) {
        this.sMobileNo = sMobileNo;
    }

    public String getsPasswrd2() {
        return sPasswrd2;
    }

    public void setPasswrd2(String sPasswrd2) {
        this.sPasswrd2 = sPasswrd2;
    }

    public boolean isFirstPageClear() {
        if(sLastName.isEmpty()){
            message = "Please enter last name";
            return false;
        } else if(sFrstName.isEmpty()){
            message = "Please enter first name";
            return false;
        } else if(sMiddName.isEmpty()){
            message = "Please enter middle name";
            return false;
        } else if(sEmailAdd.isEmpty()){
            message = "Please enter email";
            return false;
        } else if(sMobileNo.isEmpty()){
            message = "Please enter mobile no";
            return false;
        } else if(!sMobileNo.substring(0, 2).equalsIgnoreCase("09")){
            message = "Mobile number must start with '09'";
            return false;
        } else if(sMobileNo.length() != 11){
            message = "Mobile number must be 11 characters";
            return false;
        } else {
            return true;
        }
    }

    public boolean isSecondPageClear() {
        if(sPassword.isEmpty()) {
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
