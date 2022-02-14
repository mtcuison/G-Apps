/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.guanzongroup.appcore.ServerRequest;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import org.rmj.guanzongroup.appcore.Account.AccountInfo;
import org.rmj.guanzongroup.appcore.Etc.AppConfigPreference;
import org.rmj.guanzongroup.appcore.Etc.SecUtil;
import org.rmj.guanzongroup.appcore.Etc.SessionManager;
import org.rmj.guanzongroup.appcore.Etc.Telephony;
import org.rmj.guanzongroup.appcore.Utils.SQLUtil;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HttpHeaders {

    private final Telephony poTlphony;
    private final AppConfigPreference poConfigx;
    private final AccountInfo poAccount;

    public HttpHeaders(Context context){
        this.poTlphony = new Telephony(context);
        this.poConfigx = new AppConfigPreference(context);
        this.poAccount = new AccountInfo(context);
    }

    private Map<String, String> initHttpHeaders() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Calendar calendar = Calendar.getInstance();

        //TODO: Change Values on user testing and production
        String lsUserIDx = poAccount.getUserID();
        String lsClientx = poAccount.getClientID();
        String lsLogNoxx = "";
//        String lsTokenxx = poConfigx.getAppToken();
        String lsTokenxx = "c6mOUp7sSzimo_IGMqD-1Y:APA91bG_xsUb2n6S4AlKXjI4uKuQpWBdx7wec9HuYlRiHaRLcuBNCZHPL20sxwsjQ_LPozaanRgl100RMj2pYwo_uj-M3r3xqu1b9t6ozMaNslZEQVIslEblgH-I5IU4oQjwYRJPammH";
//        String lsProduct = poConfigx.ProducID();
        String lsProduct = "GuanzonApp";
        String lsDevcIDx = poTlphony.getDeviceID();
        String lsDateTme = SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss");
        String lsDevcMdl = Build.MODEL;
//        String lsMobileN = poConfigx.getMobileNo();
        String lsMobileN = "09270359402";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", lsProduct);
        headers.put("g-api-client", lsClientx);
        headers.put("g-api-imei", lsDevcIDx);
        headers.put("g-api-model", lsDevcMdl);
        headers.put("g-api-mobile", lsMobileN);
        headers.put("g-api-token", lsTokenxx);
        headers.put("g-api-user", lsUserIDx);
        headers.put("g-api-key", lsDateTme);
        String hash_toLower = SecUtil.md5Hex(headers.get("g-api-imei") + headers.get("g-api-key"));
        hash_toLower = hash_toLower.toLowerCase();
        headers.put("g-api-hash", hash_toLower);
        headers.put("g-api-log", lsLogNoxx);
        return headers;
    }

    public HashMap<String, String> getHeaders(){
        return (HashMap<String, String>) initHttpHeaders();
    }
}
