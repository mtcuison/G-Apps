package org.rmj.g3appdriver.etc;

import android.content.Context;
import android.content.SharedPreferences;

public class GuanzonAppConfig {
    private static final String TAG = GuanzonAppConfig.class.getSimpleName();

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    private static final String ACCOUNT_CREDENTIALS = "GApp_Config";

    private static final String TEST_CASE = "cTestStat";

    public GuanzonAppConfig(Context context){
        pref = context.getSharedPreferences(ACCOUNT_CREDENTIALS, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    /**
     *
     * @param val set if All Class that will access
     *            API will be using Local Server for Testing
     *            or Live Data for Production.
     *            True = Local Testing
     *            False = Live Data
     *            Default value: False
     */
    public void setTestCase(boolean val){
        editor.putBoolean(TEST_CASE, val);
        editor.commit();
    }

    public boolean getTestCase(){
        return pref.getBoolean(TEST_CASE, false);
    }
}
