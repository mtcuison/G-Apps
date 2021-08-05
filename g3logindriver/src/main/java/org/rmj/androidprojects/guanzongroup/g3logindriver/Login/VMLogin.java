/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.authLibrary
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */
package org.rmj.androidprojects.guanzongroup.g3logindriver.Login;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class VMLogin extends AndroidViewModel {
    public static final String TAG =  VMLogin.class.getSimpleName();
    private final Application application;
    private final RClientInfo poClient;
    private final WebApi webApi;
    private final HttpHeaders headers;
    private final ConnectionUtil conn;
    private final SessionManager session;
    private final AppConfigPreference poConfig;
    private final Telephony poTlphony;
    private MutableLiveData<Integer> psMobile = new MutableLiveData<>();
    private MutableLiveData<String> mobileNo = new MutableLiveData<>();
    public VMLogin(@NonNull Application application) {
        super(application);
        this.application =application;
        poClient = new RClientInfo(application);
        webApi = new WebApi(application);
        headers = HttpHeaders.getInstance(application);
        conn = new ConnectionUtil(application);
        session = new SessionManager(application);
        poConfig = AppConfigPreference.getInstance(application);
        poTlphony = new Telephony(application);
        mobileNo.setValue(poTlphony.getMobilNumbers());
    }

//    @SuppressLint("NewApi")
//    public String getMobileNo(){
//        return poTlphony.getMobilNumbers();
//    }
    @SuppressLint("NewApi")
    public LiveData<String> getMobileNo(){
        return mobileNo;
    }

    public LiveData<Integer> hasMobileNo(){
        psMobile.setValue(View.GONE);
        if(poConfig.getMobileNo().equalsIgnoreCase("") || poConfig.getMobileNo().isEmpty()) {
            psMobile.setValue(View.VISIBLE);
            return psMobile;
        }
        return psMobile;
    }


    public void Login(final UserAuthInfo authInfo, LoginCallback callback){
        authInfo.setMobileValidity(poConfig.getMobileNo().isEmpty());
        if(authInfo.isAuthInfoValid()) {
            if(poConfig.getMobileNo().isEmpty()) {
                poConfig.setTemp_mobileno(authInfo.getMobileNo());
            }
            JSONObject params = new JSONObject();
            try {
                params.put("user", Objects.requireNonNull(authInfo.getEmail()));
                params.put("pswd", Objects.requireNonNull(authInfo.getPassword()));
                params.put("nmbr", Objects.requireNonNull(authInfo.getMobileNo()));
            }catch (Exception e){
                e.printStackTrace();
            }

            if(conn.isDeviceConnected()) {
                new LoginTask(application, webApi, headers, session, poClient,callback).execute(params);
            } else {
                callback.OnFailedLoginResult("Unable to connect. Please check your internet connection.");
            }
        } else {
            callback.OnFailedLoginResult(authInfo.getMessage());
        }
    }

    private static class LoginTask extends AsyncTask<JSONObject, Void, String>{
        private final WebApi webApi;
        private final HttpHeaders headers;
        private final LoginCallback callback;
        private final RClientInfo poClient;
        private final SessionManager sessionManager;
        private final AppConfigPreference poConfig;

        public LoginTask(Application application, WebApi webApi, HttpHeaders headers, SessionManager sessionManager, RClientInfo poClient, LoginCallback callback){
            this.webApi = webApi;
            this.headers = headers;
            this.poClient = poClient;
            this.callback = callback;
            this.sessionManager = sessionManager;
            this.poConfig = AppConfigPreference.getInstance(application);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.OnAuthenticationLoad("Guanzon App", "Authenticating to guanzon app. Please wait...");
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(final JSONObject... authInfo) {
            String response = "";
            try {
                response = WebClient.httpsPostJSon(webApi.URL_CLIENT_LOGIN, authInfo[0].toString(), headers.getHeaders());
                Log.e(TAG, response);

            } catch (IOException e) {
                e.printStackTrace();
                response = AppConstants.LOCAL_EXCEPTION_ERROR(e.getMessage() + "\n Please check your internet.");
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loResponse = new JSONObject(s);
                Log.e("JSONFormat", loResponse.toString());
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    saveAuthInfo(loResponse);
                    callback.OnSuccessLoginResult();
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsMessage = loError.getString("message");
                    callback.OnFailedLoginResult(lsMessage);
                    Log.e(TAG, s);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            this.cancel(false);
        }

        void saveAuthInfo(JSONObject jsonInfo) throws JSONException{
            EClientInfo clientInfo = new EClientInfo();
            clientInfo.setUserIDxx(jsonInfo.getString("sUserIDxx"));
            clientInfo.setEmailAdd(jsonInfo.getString("sEmailAdd"));
            clientInfo.setMobileNo(jsonInfo.getString("sMobileNo"));
            clientInfo.setUserName(jsonInfo.getString("sUserName"));
            clientInfo.setDateMmbr(jsonInfo.getString("dCreatedx"));
            clientInfo.setLoginxxx(AppConstants.DATE_MODIFIED);
            poClient.insertLogin(clientInfo);
            sessionManager.setUserID(jsonInfo.getString("sUserIDxx"));
            poConfig.setTemp_mobileno(jsonInfo.getString("sMobileNo"));
            Log.e(TAG, clientInfo.toString());
        }
    }
}