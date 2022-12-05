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

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RNotificationInfo {
    private static final String TAG = RNotificationInfo.class.getSimpleName();
    private final Context mContext;
    private final DNotifications poDao;

    private String message = "";
    private String psMesgIDx = "";

    public RNotificationInfo(Context context){
        this.mContext = context;
        GGC_GuanzonAppDB GGCGriderDB = GGC_GuanzonAppDB.getInstance(mContext);
        poDao = GGCGriderDB.NotificationDao();
    }

    public String getMessage(){
        return message;
    }

    public String getMessageID(){
        return psMesgIDx;
    }

    public boolean ImportClientNotifications(int fnVal){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportNotificationsAPI();

            JSONObject params = new JSONObject();
            params.put("nLimitxxx", fnVal);
            String lsResponse = WebClient.httpsPostJSon(lsAddress, params.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    JSONArray laMaster = loResponse.getJSONArray("master");
                    JSONArray laRecpnt = loResponse.getJSONArray("recipient");
                    for(int x = 0; x < laMaster.length(); x++){
                        JSONObject loDetail = laMaster.getJSONObject(x);
                        if(poDao.CheckIfMasterExist(loDetail.getString("sTransNox")) == null){
                            ENotificationMaster loMaster = new ENotificationMaster();
                            loMaster.setTransNox(CreateUniqueID());
                            loMaster.setMesgIDxx(loDetail.getString("sTransNox"));
                            loMaster.setParentxx(loDetail.getString("sParentxx"));
                            loMaster.setCreatedx(loDetail.getString("dCreatedx"));
                            loMaster.setAppSrcex(loDetail.getString("sAppSrcex"));
                            loMaster.setCreatrID(loDetail.getString("sCreatedx"));
                            loMaster.setCreatrNm(loDetail.getString("sUserName"));
                            loMaster.setDataSndx(loDetail.getString("sDataSndx"));
                            loMaster.setMsgTitle(loDetail.getString("sMsgTitle"));
                            loMaster.setMessagex(loDetail.getString("sMessagex"));
                            loMaster.setMsgTypex(loDetail.getString("sMsgTypex"));
                            poDao.insert(loMaster);
                        }

                        if(poDao.CheckIfUserExist(loDetail.getString("sCreatedx")) == null){
                            ENotificationUser loUser = new ENotificationUser();
                            loUser.setUserIDxx(loDetail.getString("sCreatedx"));
                            loUser.setUserName(loDetail.getString("sUserName"));
                            poDao.insert(loUser);
                        }
                    }

                    for(int x = 0; x < laRecpnt.length(); x++){
                        JSONObject loDetail = laRecpnt.getJSONObject(x);
                        if(poDao.CheckIfRecipientExist(loDetail.getString("sTransNox")) == null){
                            ENotificationRecipient loRecpnt = new ENotificationRecipient();
                            loRecpnt.setTransNox(loDetail.getString("sTransNox"));
                            loRecpnt.setAppRcptx(loDetail.getString("sAppRcptx"));
                            loRecpnt.setRecpntID(loDetail.getString("sRecpntxx"));
                            loRecpnt.setRecpntNm(loDetail.getString("sRecptNme"));
                            loRecpnt.setSentxxxx(loDetail.getString("dSentxxxx"));
                            loRecpnt.setMesgStat(loDetail.getString("cMesgStat"));
                            loRecpnt.setReceived(loDetail.getString("dReceived"));
                            loRecpnt.setTimeStmp(loDetail.getString("dTimeStmp"));
                            poDao.insert(loRecpnt);
                        } else {
                            ENotificationRecipient loRecpnt = poDao.CheckIfRecipientExist(loDetail.getString("sTransNox"));
                            Date ldDate1 = SQLUtil.toDate(loRecpnt.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                            Date ldDate2 = SQLUtil.toDate(loDetail.getString("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                            if (!ldDate1.equals(ldDate2)) {

                            }
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SaveNotification(RemoteMessage foVal){
        try{
            RemoteMessageParser loParser = new RemoteMessageParser(foVal);
            psMesgIDx = loParser.getValueOf("transno");
            if(poDao.CheckNotificationIfExist(psMesgIDx) >= 1){
                String lsStatus = loParser.getValueOf("status");
                poDao.updateNotificationStatusFromOtherDevice(psMesgIDx, lsStatus);
            } else {
                ENotificationMaster loMaster = new ENotificationMaster();
                loMaster.setTransNox(CreateUniqueID());
                loMaster.setMesgIDxx(loParser.getValueOf("transno"));
                loMaster.setParentxx(loParser.getValueOf("parent"));
                loMaster.setCreatedx(loParser.getValueOf("stamp"));
                loMaster.setAppSrcex(loParser.getValueOf("appsrce"));
                loMaster.setCreatrID(loParser.getValueOf("srceid"));
                loMaster.setCreatrNm(loParser.getValueOf("srcenm"));
                loMaster.setDataSndx(loParser.getValueOf("infox"));
                loMaster.setMsgTitle(loParser.getDataValueOf("title"));
                loMaster.setMessagex(loParser.getDataValueOf("message"));
                loMaster.setMsgTypex(loParser.getValueOf("msgmon"));

                ENotificationRecipient loRecpnt = new ENotificationRecipient();
                loRecpnt.setTransNox(loParser.getValueOf("transno"));
                loRecpnt.setAppRcptx(loParser.getValueOf("apprcpt"));
                loRecpnt.setRecpntID(loParser.getValueOf("rcptid"));
                loRecpnt.setRecpntNm(loParser.getValueOf("rcptnm"));
                loRecpnt.setMesgStat(loParser.getValueOf("status"));
                loRecpnt.setReceived(new AppConstants().DATE_MODIFIED);
                loRecpnt.setTimeStmp(new AppConstants().DATE_MODIFIED);

                ENotificationUser loUser = new ENotificationUser();
                loUser.setUserIDxx(loParser.getValueOf("srceid"));
                loUser.setUserName(loParser.getValueOf("srcenm"));

                poDao.insert(loMaster);
                poDao.insert(loRecpnt);
                if(poDao.CheckIfUserExist(loParser.getValueOf("srceid")) == null){
                    poDao.insert(loUser);
                }
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SendReceiveResponse(String lsMessageID){
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
                    poDao.updateRecipientReceivedStatus(lsMessageID ,new AppConstants().DATE_MODIFIED);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SendReadResponse(String lsMessageID){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());

            JSONObject params = new JSONObject();
            params.put("transno", lsMessageID);
            params.put("status", "3");
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
                    poDao.updateReadReceivedStatus(lsMessageID ,new AppConstants().DATE_MODIFIED);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ParseMessageInfo(RemoteMessage foVal){
        try{
            RemoteMessageParser loParser = new RemoteMessageParser(foVal);
            psMesgIDx = loParser.getValueOf("transno");
            String lsValue = loParser.getValueOf("infox");

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<Integer> GetUnreadMessagesCount(){
        return poDao.getUnreadMessagesCount();
    }

    public LiveData<List<DNotifications.ClientNotificationInfo>> GetClientNotificationList(){
        return poDao.getClientNotificationList();
    }

    public LiveData<List<DNotifications.RegularMessage>> GetRegularMessagesSystemNotif(){
        return poDao.GetRegularMessagesSystemNotif();
    }

    public LiveData<DNotifications.ClientNotificationInfo> GetNotificationInfo(String fsMesgID){
        return poDao.GetNotificationInfo(fsMesgID);
    }

    private String CreateUniqueID(){
        String lsUniqIDx = "";
        try{
            String lsBranchCd = "MX01";
            String lsCrrYear = new SimpleDateFormat("yy", Locale.getDefault()).format(new Date());
            StringBuilder loBuilder = new StringBuilder(lsBranchCd);
            loBuilder.append(lsCrrYear);

            int lnLocalID = poDao.GetNotificationCountForID() + 1;
            String lsPadNumx = String.format("%05d", lnLocalID);
            loBuilder.append(lsPadNumx);
            lsUniqIDx = loBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return lsUniqIDx;
    }

    private void SaveRecipient(ENotificationRecipient foVal){
        try{

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
