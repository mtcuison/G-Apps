package org.rmj.guanzongroup.appcore.Authentication;

import android.content.Context;

import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Etc.AppConstants;
import org.rmj.guanzongroup.appcore.Etc.SessionManager;
import org.rmj.guanzongroup.appcore.ServerRequest.HttpHeaders;
import org.rmj.guanzongroup.appcore.ServerRequest.WebClient;

public class AccountAuthentication {
    private static final String TAG = AccountAuthentication.class.getSimpleName();

    private static final String SIGN_IN = "https://restgk.guanzongroup.com.ph/security/signin.php";
    private static final String REGISTRATION = "https://restgk.guanzongroup.com.ph/security/signup.php";
    private static final String RETRIEVE_PASSWORD = "https://restgk.guanzongroup.com.ph/security/forgotpswd.php";

    private final Context mContext;
    private final HttpHeaders poHeaders;

    public AccountAuthentication(Context mContext) {
        this.mContext = mContext;
        this.poHeaders = new HttpHeaders(mContext);
    }

    public interface OnLoginCallback{
        void OnSuccessLogin(String message);
        void OnFailedLogin(String message);
    }

    public void LoginAccount(LoginCredentials credentials, OnLoginCallback callback) throws Exception{
        if (!credentials.isDataValid()) {
            callback.OnFailedLogin(credentials.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(SIGN_IN, credentials.getJSONParameters(), poHeaders.getHeaders());
            if (lsResponse == null) {
                callback.OnFailedLogin("Unable to login account. Server no response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (lsResult.equalsIgnoreCase("success")) {
                    SessionManager loSession = new SessionManager(mContext);
                    String lsUserIDx = loResponse.getString("sUserIDxx");
                    String lsEmailxx = loResponse.getString("sEmailAdd");
                    String lsMobilex = loResponse.getString("sMobileNo");
                    String lsUserNme = loResponse.getString("sUserName");
                    String lsCreated = loResponse.getString("dCreatedx");
                    String lsDateLog = AppConstants.DATE_MODIFIED;
                    loSession.initUserSession(lsUserIDx, lsEmailxx, lsMobilex, lsUserNme, lsCreated, lsDateLog);
                    callback.OnSuccessLogin("Login success.");
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsMessage = loError.getString("message");
                    callback.OnFailedLogin(lsMessage);
                }
            }
        }
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

    public void RegisterAccount(AccountCredentials credentials, OnCreateAccountCallback callback) throws Exception{
        if(!credentials.isDataValid()){
            callback.OnFailedRegister(credentials.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(REGISTRATION, credentials.getParameters(), poHeaders.getHeaders());
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

    public void RetrievePassword(String email, OnRetrievePasswordCallback callback) throws Exception{
        if(email.isEmpty()){
            callback.OnFailedRetrieve("Please enter email.");
        } else {
            JSONObject params = new JSONObject();
            params.put("email", email);

            String lsResponse = WebClient.httpsPostJSon(RETRIEVE_PASSWORD, params.toString(), poHeaders.getHeaders());
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
