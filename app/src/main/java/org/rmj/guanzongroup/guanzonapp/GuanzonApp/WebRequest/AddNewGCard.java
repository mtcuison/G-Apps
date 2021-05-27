package org.rmj.guanzongroup.guanzonapp.GuanzonApp.WebRequest;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AppUserMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.etc.GCard_Constants;

import java.util.HashMap;

public class AddNewGCard extends CodeGenerator implements GapRequestInstance {
    private static final String TAG = AddNewGCard.class.getSimpleName();

    private Context mContext;
    private ConnectionUtil connectionUtill;
    private RequestHeaders headers;
    private onSendRequestResultListener onSendRequestResultListener;
    private AppData db;
    private AppUserMaster appUserMaster;
    private GcardAppMaster gcardAppMaster;
    private String UserID = "";

    private String GCardNumber = "";
    private String UserBirthDate = "";
    private String EntryType = "";
    private String ConfirmGcard = "0";

    public void setGCardNumber(String GCardNumber) {
        this.GCardNumber = GCardNumber;
    }

    public void setUserBirthDate(String userBirthDate) {
        UserBirthDate = userBirthDate;
    }

    public void setEntryType(String entryType) {
        EntryType = entryType;
    }

    public void setConfirmGcard(String status){
        this.ConfirmGcard = status;
    }

    @Override
    public void sendRequest(Context context, onSendRequestResultListener listener) {
        this.mContext = context;
        this.connectionUtill = new ConnectionUtil(mContext);
        this.headers = new RequestHeaders(mContext);
        this.onSendRequestResultListener = listener;
        this.db = AppData.getInstance(mContext);
        this.appUserMaster = new AppUserMaster(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.UserID = appUserMaster.getUserID();

        if(connectionUtill.isDeviceConnected()){
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_ADD_NEW_GCARD(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    return createParameter();
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    saveGCardToLocal(jsonResponse);
                    checkUserGcardForActive();
                    onSendRequestResultListener.onSuccessResult();
                }

                @Override
                public void onErrorResponse(String message) {
                    onSendRequestResultListener.onErrorResult(message);
                }
            });
        } else {
            onSendRequestResultListener.onErrorResult("No internet connection");
        }
    }

    private JSONObject createParameter(){
        try{
            JSONObject params = new JSONObject();
            switch (EntryType){
                case GCard_Constants.MANUAL_ENTRY:
                    params.put("secureno", generateSecureNo(GCardNumber));
                case GCard_Constants.QRCode_ENTRY:
                    params.put("secureno", generateSecureNo(GCardNumber));
                    params.put("bday", UserBirthDate);
                    params.put("newdevce", ConfirmGcard);
            }
            return params;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveGCardToLocal(JSONObject jsonDetail) {
        try {
            String UserIDxx = UserID;
            String GCardNox = jsonDetail.getString("sGCardNox");
            String GCardNbr = jsonDetail.getString("sCardNmbr");
            String NmOnCard = jsonDetail.getString("sNmOnCard");
            String DateMmbr = jsonDetail.getString("dMemberxx");
            String CardType = jsonDetail.getString("cCardType");
            String TotPoint = jsonDetail.getString("nTotPoint");
            String AvlPoint = jsonDetail.getString("nAvlPoint");
            db.getWritableDb().beginTransaction();
            db.getWritableDb().execSQL("INSERT INTO GCard_App_Master" +
                    "(sUserIDxx, " +
                    "sGCardNox, " +
                    "sCardNmbr, " +
                    "sNmOnCard, " +
                    "dMemberxx, " +
                    "cCardType, " +
                    "sTotPoint, " +
                    "sAvlPoint, " +
                    "cActvStat, " +
                    "cTranStat, " +
                    "cNotified) " +
                    "VALUES" +
                    "('" + UserIDxx + "', " +
                    "'" + GCardNox + "', " +
                    "'" + GCardNbr + "', " +
                    "'" + NmOnCard + "', " +
                    "'" + DateMmbr + "', " +
                    "'" + CardType + "', " +
                    "'" + TotPoint + "', " +
                    "'" + AvlPoint + "', " +
                    "'0', " +
                    "'0', " +
                    "'0')");
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
            Log.e(TAG, "New Gcard number has been added to your account.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void checkUserGcardForActive(){
        if(gcardAppMaster.hasNoGcard()){
            gcardAppMaster.setAsOneActiveGCard();
        }
    }
}

