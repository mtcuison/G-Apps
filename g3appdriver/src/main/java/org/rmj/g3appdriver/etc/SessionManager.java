/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 6/2/21 3:37 PM
 * project file last modified : 4/24/21 3:19 PM
 */

package org.rmj.g3appdriver.etc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    //LOG CAT TAG
    private static final String TAG = SessionManager.class.getSimpleName();

    //SHARED PREFERENCES
    private final SharedPreferences pref;

    private final Editor editor;

    //shared preference  file name
    private static final String PREF_NAME = "AndroidGhostRider";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    private static final String KEY_IS_FIRST_LAUNCHED = "isFirstLaunch";

    private static final String KEY_USER_ID = "sUserIDxx";
    private static final String KEY_EMAIL_ADD = "sEmailAdd";
    private static final String KEY_MOBILE_NO = "sMobileNo";
    private static final String KEY_USER_NAME = "sUserName";
    private static final String KEY_DATE_CREATED = "dCreatedx";
    private static final String KEY_DATE_LOGIN = "dLoginxxx";

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        //Shared pref mode
        int PRIVATE_MODE = 0;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void initUserSession(String UserID, String Email, String MobileNo, String UserName, String DateCreated, String DateLogin){
        editor.putString(KEY_USER_ID, UserID);
        if(editor.commit()){
            Log.e(TAG, "User ID for this session has been set.");
        }

        editor.putString(KEY_EMAIL_ADD, Email);
        if(editor.commit()){
            Log.e(TAG, "Client ID for this session has been set.");
        }

        editor.putString(KEY_MOBILE_NO, MobileNo);
        if(editor.commit()){
            Log.e(TAG, "Log number for this session has been set.");
        }

        editor.putString(KEY_USER_NAME, UserName);
        if(editor.commit()){
            Log.e(TAG, "User name for this session has been set.");
        }

        editor.putString(KEY_DATE_CREATED, DateCreated);
        if(editor.commit()){
            Log.e(TAG, "Account date created for this session has been set.");
        }

        editor.putString(KEY_DATE_LOGIN, DateLogin);
        if(editor.commit()){
            Log.e(TAG, "Date login for this session has been set.");
        }

        editor.putBoolean(KEY_IS_LOGGEDIN, true);
        if(editor.commit()){
            Log.d(TAG, "User login session has been initialized.");
        }
    }

    public void initUserLogout(){
        editor.putString(KEY_USER_ID, "");
        if(editor.commit()){
            Log.e(TAG, "User ID for this session has been clear.");
        }

        editor.putBoolean(KEY_IS_LOGGEDIN, false);
        if(editor.commit()){
            Log.d(TAG, "User login session has been clear.");
        }
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setIsFirstLaunched(boolean isFirstLaunched){
        editor.putBoolean(KEY_IS_FIRST_LAUNCHED, isFirstLaunched);

        editor.commit();

        Log.e(TAG, "Is app first launched.");
    }

    public boolean isFirstLaunch(){
        return pref.getBoolean(KEY_IS_FIRST_LAUNCHED, true);
    }

    public String getUserID() {
        return pref.getString(KEY_USER_ID, "");
    }

    public String getEmailAdd() {
        return pref.getString(KEY_EMAIL_ADD, "");
    }

    public String getMobileNo() {
        return pref.getString(KEY_MOBILE_NO, "");
    }

    public String getUserName() {
        return pref.getString(KEY_USER_NAME, "");
    }

    public String getDateCreated() {
        return pref.getString(KEY_DATE_CREATED, "");
    }

    public String getDateLogin() {
        return pref.getString(KEY_DATE_LOGIN, "");
    }
}

