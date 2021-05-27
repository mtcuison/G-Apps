package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.rmj.g3appdriver.dev.AppData;

public class TokenStorage {
    private static final String TAG = TokenStorage.class.getSimpleName();
    private AppData db;
    public TokenStorage(Context context) {
        this.db = AppData.getInstance(context);
    }

    public void saveToken(String token){
        db.getWritableDb().execSQL("INSERT INTO App_Token_Info (sAppToken) VALUES (?)", new Object[]{token});
        Log.e(TAG, "Guanzon App token has been save.");
    }
}
