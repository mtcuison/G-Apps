/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.dev.Repositories;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;
import org.rmj.appdriver.base.GConnection;
import org.rmj.apprdiver.util.MiscUtil;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Database.DbConnection;
import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;
import org.rmj.g3appdriver.dev.Database.Entities.ENotificationRecipient;
import org.rmj.g3appdriver.dev.Database.Entities.ENotificationUser;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.RemoteMessageParser;

import java.util.List;

public class RNotificationInfo {
    private static final String TAG = RNotificationInfo.class.getSimpleName();
    private final Context mContext;
    private final DNotifications poDao;

    private String message = "";
    private String lsMesgIDx = "";

    public RNotificationInfo(Context context){
        this.mContext = context;
        GGC_GuanzonAppDB GGCGriderDB = GGC_GuanzonAppDB.getInstance(mContext);
        poDao = GGCGriderDB.NotificationDao();
    }

    public boolean SaveNotification(RemoteMessage foVal){
        try{
            RemoteMessageParser loParser = new RemoteMessageParser(foVal);
            lsMesgIDx = loParser.getValueOf("transno");
            if(poDao.CheckNotificationIfExist(lsMesgIDx) > 0){
                Log.e(TAG, "Message already exist.");

            } else {

            }
            return false;
        } catch (Exception e){
            e.getMessage();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SendResponse(String lsMessageID){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());

            JSONObject params = new JSONObject();
            params.put("transno", lsMessageID);
            params.put("status", "2");
            params.put("stamp", new AppConstants().DATE_MODIFIED);
            params.put("infox", "");

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getSendResponseAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {

                }
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }
}
