package org.rmj.g3appdriver.lib.Notifications.Obj;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;
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
import org.rmj.g3appdriver.lib.Notifications.NOTIFICATION_STATUS;
import org.rmj.g3appdriver.lib.Notifications.iNotification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NMM_Panalo implements iNotification {
    private static final String TAG = NMM_Panalo.class.getSimpleName();

    private final Context instance;

    private final DNotifications poDao;
    private final HttpHeaders poHeaders;

    private String message;

    public NMM_Panalo(Context context) {
        this.instance = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(instance).NotificationDao();
        this.poHeaders = new HttpHeaders(instance);
    }

    @Override
    public boolean ImportNotifications() {
        return false;
    }

    @Override
    public String Save(RemoteMessage foVal) {
        try{
            RemoteMessageParser loParser = new RemoteMessageParser(foVal);
            String lsMesgIDx = loParser.getValueOf("transno");
            String lsUserIDx = poDao.GetUserID();
            String lsRecpntx = loParser.getValueOf("rcptid");

            if(poDao.CheckNotificationIfExist(lsMesgIDx) >= 1){
                String lsStatus = loParser.getValueOf("status");
                poDao.updateNotificationStatusFromOtherDevice(lsMesgIDx, lsStatus);
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

            if(!lsUserIDx.equalsIgnoreCase(lsRecpntx)){
                message = "User is not the recipient of notification";
                return null;
            }

            return lsMesgIDx;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    @Override
    public ENotificationMaster SendResponse(String mesgID, NOTIFICATION_STATUS status) {
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(instance).getTestCase());

            String lsTranStat = "";

            switch (status){
                case OPEN:
                    lsTranStat = "0";
                    break;
                case DELIVERED:
                    lsTranStat = "1";
                    break;
                case RECEIVED:
                    lsTranStat = "2";
                    break;
                case READ:
                    lsTranStat = "3";
                    break;
                case DELETED:
                    lsTranStat = "4";
                    break;
            }

            JSONObject params = new JSONObject();
            params.put("transno", mesgID);
            params.put("status", lsTranStat);
            params.put("stamp", new AppConstants().DATE_MODIFIED);
            params.put("infox", "");

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getSendResponseAPI(),
                    params.toString(),
                    poHeaders.getHeaders());
            if(lsResponse == null){
                message = "Server no response while sending response.";
                return null;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (!lsResult.equalsIgnoreCase("success")) {
                JSONObject loError = loResponse.getJSONObject("error");
                message = loError.getString("message");
                return null;
            }

            poDao.UpdateSentResponseStatus(mesgID, lsTranStat, new AppConstants().DATE_MODIFIED);
            return poDao.CheckIfMasterExist(mesgID);
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    @Override
    public LiveData<ENotificationMaster> GetNotificationMasterDetail(String fsVal) {
        return null;
    }

    @Override
    public LiveData<List<ENotificationMaster>> GetNotificationList() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
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
}
