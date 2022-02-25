package org.rmj.g3appdriver.lib.Account;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

public class AccountAuthentication {
    private static final String TAG = AccountAuthentication.class.getSimpleName();

    private final Context mContext;
    private final GuanzonAppConfig poConfig;
    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;

    public AccountAuthentication(Context context) {
        this.mContext = context;
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public interface OnLoginCallback{
        void OnSuccessLogin(String message);
        void OnFailedLogin(String message);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void LoginAccount(LoginCredentials credentials, OnLoginCallback callback) throws Exception{
        if (!credentials.isDataValid()) {
            callback.OnFailedLogin(credentials.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(poApi.getSIGN_IN(), credentials.getJSONParameters(), poHeaders.getHeaders());
            if (lsResponse == null) {
                callback.OnFailedLogin("Unable to login account. Server no response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (lsResult.equalsIgnoreCase("success")) {
                    initAccount(loResponse);
                    callback.OnSuccessLogin("Login success.");
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsMessage = loError.getString("message");
                    callback.OnFailedLogin(lsMessage);
                }
            }
        }
    }

    public void initAccount(JSONObject foAccount) throws Exception{
        AccountInfo loInfo = new AccountInfo(mContext);
        loInfo.setUserID(foAccount.getString("sUserIDxx"));
        loInfo.setFullName(foAccount.getString("sUserName"));
        loInfo.setEmailAdd(foAccount.getString("sEmailAdd"));
//        loInfo.setClientId(foAccount.getString("sClientID"));
//        loInfo.setLastname(foAccount.getString("sLastName"));
//        loInfo.setFirstName(foAccount.getString("sFrstName"));
//        loInfo.setMiddlename(foAccount.getString("sMiddName"));
//        loInfo.setSuffix(foAccount.getString("sSuffixNm"));
//        loInfo.setGender(foAccount.getString("sGenderCd"));
//        loInfo.setCivilStatus(foAccount.getString("sCvilStat"));
//        loInfo.setCitizenship(foAccount.getString("sCitizenx"));
//        loInfo.setBirthdate(foAccount.getString("sBirthDte"));
//        loInfo.setBirthplace(foAccount.getString("sBirthPlc"));
//        loInfo.setTaxId(foAccount.getString("sTaxIdxxx"));
//        loInfo.setMobileNo(foAccount.getString("sMobileNo"));
//        loInfo.setHouseNo(foAccount.getString("sHouseNox"));
//        loInfo.setAddress(foAccount.getString("sAddressx"));
//        loInfo.setBarangay(foAccount.getString("sBrgyName"));
//        loInfo.setTownName(foAccount.getString("sTownName"));
//        loInfo.setProvince(foAccount.getString("sProvName"));
        loInfo.setLoginStatus(true);
    }

    public static class LoginCredentials{
        private String sUserName = "";
        private String sPassword = "";
        private String sMobileNo = "";

        private String message;

        public LoginCredentials(String username, String password, String mobileno){
            this.sUserName = username;
            this.sPassword = password;
            this.sMobileNo = mobileno;
        }

        public String getMessage() {
            return message;
        }

        public boolean isDataValid(){
            if(sUserName.isEmpty()){
                message = "Please enter email";
                return false;
            } else if(sPassword.isEmpty()){
                message = "Please enter password";
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

        public String getJSONParameters() throws Exception{
            JSONObject params = new JSONObject();
            params.put("user", sUserName);
            params.put("pswd", sPassword);
            params.put("nmbr", sMobileNo);
            return params.toString();
        }
    }

    public interface OnCreateAccountCallback{
        void OnSuccessRegister(String message);
        void OnFailedRegister(String message);
    }

    public static class AccountCredentials{
        private String sLastName = "";
        private String sFrstName = "";
        private String sMiddName = "";
        private String sSuffixxx = "";
        private String sEmailAdd = "";
        private String sPassword = "";
        private String sPasswrd2 = "";
        private String sMobileNo = "";

        private String message;

        public AccountCredentials() {
        }

        public String getMessage() {
            return message;
        }

        public String getsLastName() {
            return sLastName;
        }

        public void setLastName(String sLastName) {
            this.sLastName = sLastName;
        }

        public String getsFrstName() {
            return sFrstName;
        }

        public void setFrstName(String sFrstName) {
            this.sFrstName = sFrstName;
        }

        public String getsMiddName() {
            return sMiddName;
        }

        public void setMiddName(String sMiddName) {
            this.sMiddName = sMiddName;
        }

        public String getsSuffixxx() {
            return sSuffixxx;
        }

        public void setsSuffixxx(String sSuffixxx) {
            this.sSuffixxx = sSuffixxx;
        }

        public String getsEmailAdd() {
            return sEmailAdd;
        }

        public void setEmailAdd(String sEmailAdd) {
            this.sEmailAdd = sEmailAdd;
        }

        public String getsPassword() {
            return sPassword;
        }

        public void setPassword(String sPassword) {
            this.sPassword = sPassword;
        }

        public String getsMobileNo() {
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

        public boolean isDataValid(){
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
            } else if(sPassword.isEmpty()){
                message = "Please enter password";
                return false;
            } else if(!sPassword.equalsIgnoreCase(sPasswrd2)){
                message = "Passwords does not match";
                return false;
            } else if(sPassword.length() < 6){
                message = "Password is too short";
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

        public String getParameters() throws Exception{
            JSONObject params = new JSONObject();
            params.put("name", getFullName());
            params.put("mail", sEmailAdd);
            params.put("pswd", sPassword);
            params.put("mobile", sMobileNo);
            return params.toString();
        }

        private String getFullName(){
            return sLastName + ", " + sFrstName + " " + sMiddName;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void RegisterAccount(AccountCredentials credentials, OnCreateAccountCallback callback) throws Exception{
        if(!credentials.isDataValid()){
            callback.OnFailedRegister(credentials.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(poApi.getREGISTRATION(), credentials.getParameters(), poHeaders.getHeaders());
            if(lsResponse == null){
                callback.OnFailedRegister("Server no response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.OnSuccessRegister("Please check your email for account verification.");
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsMessage = loError.getString("message");
                    callback.OnFailedRegister(lsMessage);
                }
            }
        }
    }

    public interface OnRetrievePasswordCallback{
        void OnSuccessRetrieve(String message);
        void OnFailedRetrieve(String message);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void RetrievePassword(String email, OnRetrievePasswordCallback callback) throws Exception{
        if(email.isEmpty()){
            callback.OnFailedRetrieve("Please enter email.");
        } else {
            JSONObject params = new JSONObject();
            params.put("email", email);

            String lsResponse = WebClient.httpsPostJSon(poApi.getRETRIEVE_PASSWORD(), params.toString(), poHeaders.getHeaders());
            if(lsResponse == null){
                callback.OnFailedRetrieve("Server no response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.OnSuccessRetrieve("Please check your email for your password info.");
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsMessage = loError.getString("message");
                    callback.OnFailedRetrieve(lsMessage);
                }
            }
        }
    }
}
