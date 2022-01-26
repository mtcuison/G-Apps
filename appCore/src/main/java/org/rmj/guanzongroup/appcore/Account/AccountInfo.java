package org.rmj.guanzongroup.appcore.Account;

import android.content.Context;
import android.content.SharedPreferences;

import org.rmj.guanzongroup.appcore.GCardCore.CodeGenerator;

public class AccountInfo {
    private static final String TAG = AccountInfo.class.getSimpleName();

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    private static final String ACCOUNT_CREDENTIALS = "G_App_Account_Credentials";
    private static final String FULLNAME = "sFullName";
    private static final String GENDER = "sGenderxx";
    private static final String BIRTHDATE = "sBirthDte";
    private static final String BIRTHPLACE = "sBirthPlc";
    private static final String CITIZENSHIP = "sCitizenx";
    private static final String TAXID= "sTaxIdxxx";
    private static final String EMAILADD = "sEmailAdd";
    private static final String MOBILENO = "sMobileNo";
    private static final String PASSWORD = "sPassword";
    private static final String ADDRESS = "sAddressx";

    public AccountInfo(Context context) {
        pref = context.getSharedPreferences(ACCOUNT_CREDENTIALS, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setFullName(String fullName){
        editor.putString(FULLNAME, fullName);
        editor.commit();
    }

    public void setGender(String gender){
        editor.putString(GENDER, gender);
        editor.commit();
    }

    public void setBirthdate(String birthdate){
        editor.putString(BIRTHDATE, birthdate);
        editor.commit();
    }

    public void setBirthplace(String birthplace){
        editor.putString(BIRTHPLACE, birthplace);
        editor.commit();
    }

    public void setTaxId(String taxId){
        editor.putString(TAXID, taxId);
        editor.commit();
    }

    public void setEmailAdd(String emailAdd){
        editor.putString(EMAILADD, emailAdd);
        editor.commit();
    }

    public void setCitizenship(String citizenship){
        editor.putString(CITIZENSHIP, citizenship);
        editor.commit();
    }

    public void setMobileNo(String mobileNo){
        editor.putString(MOBILENO, mobileNo);
        editor.commit();
    }

    public void setPassword(String password){
        editor.putString(PASSWORD, new CodeGenerator().encryptPassword(password));
        editor.commit();
    }

    public void setAddress(String address){
        editor.putString(ADDRESS, address);
        editor.commit();
    }

    public String getFullName() {
        return pref.getString(FULLNAME, "");
    }

    public String getGender() {
        return pref.getString(GENDER, "");
    }

    public String getBirthdate() {
        return pref.getString(BIRTHDATE, "");
    }

    public String getBirthplace() {
        return pref.getString(BIRTHPLACE, "");
    }

    public String getCitizenship() {
        return pref.getString(CITIZENSHIP, "");
    }

    public String getTaxId() {
        return pref.getString(TAXID, "");
    }

    public String getEmailAdd() {
        return pref.getString(EMAILADD, "");
    }

    public String getMobileNo() {
        return pref.getString(MOBILENO, "");
    }

    public String getPassword() {
        return new CodeGenerator().decryptPassword(pref.getString(PASSWORD, ""));
    }

    public String getAddress() {
         return pref.getString(ADDRESS, "");
    }
}
