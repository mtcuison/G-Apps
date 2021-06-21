package org.rmj.g3appdriver.etc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import org.rmj.g3appdriver.dev.AppData;

public class SessionManager {
    //LOG CAT TAG
    private static String TAG = SessionManager.class.getSimpleName();

    //SHARED PREFERENCES
    private SharedPreferences pref;

    private Editor editor;

    private Context _context;

    //shared preference  file name
    private static final String PREF_NAME = "GuanzonApps";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    private static final String KEY_IS_FIRST_LAUNCHED = "isFirstLaunch";


    private static final String KEY_CLIENT_ID = "sClientID";

    private static final String KEY_LOG_NUMBER = "sLogNoxxx";

    private static final String KEY_BRANCH_CODE = "sBranchCd";

    private static final String KEY_USER_ID = "sUserIDxx";

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        this._context = context;
        //Shared pref mode
        int PRIVATE_MODE = 0;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     *
     * @param isLoggedIn set user login status
     */
    public void setLogin(boolean isLoggedIn){
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.commit();
        if(isLoggedIn){
            Log.d(TAG, "User Login.");
        } else {
            AppData db = AppData.getInstance(_context);
            db.LogoutUser();
            Log.d(TAG, "User Logout");
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

    public String getUserID(){
        return pref.getString(KEY_USER_ID, "");
    }

    public String getClientId(){
        return pref.getString(KEY_CLIENT_ID, "");
    }

    public String getLogNumber(){
        return pref.getString(KEY_LOG_NUMBER, "");
    }
    public void initUserSession(String UserID, String Client, String LogNo){
        editor.putString(KEY_USER_ID, UserID);
        if(editor.commit()){
            Log.e(TAG, "User ID for this session has been set.");
        }

        editor.putString(KEY_CLIENT_ID, Client);
        if(editor.commit()){
            Log.e(TAG, "Client ID for this session has been set.");
        }

        editor.putString(KEY_LOG_NUMBER, LogNo);
        if(editor.commit()){
            Log.e(TAG, "Log number for this session has been set.");
        }

        editor.putBoolean(KEY_IS_LOGGEDIN, true);
        if(editor.commit()){
            Log.d(TAG, "User login session has been initialized.");
        }
    }
}

