package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.PasswordStrength;
import org.rmj.g3appdriver.lib.Account.AccountInfo;

import java.util.ArrayList;

public class RClientInfo {
    private static final String TAG = "RAppEventInfo";

    private final Context mContext;
    private final DClientInfo poDao;

    private JSONObject poJson;
    private String message;

    private String[] GENDER = {"Male", "Female", "LGBTQ"};
    private String[] CIVIL_STATUS = {
            "Single",
            "Married",
            "Separated",
            "Widowed",
            "Single-Parent",
            "Single-Parent W/ Live-in Partner"};

    public RClientInfo(Context context){
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(context).EClientDao();
    }

    public JSONObject getData() {
        return poJson;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getGenderList() {
        ArrayList<String> loGender = new ArrayList<>();
        for(int x = 0; x < GENDER.length; x++) {
            loGender.add(GENDER[x]);
        }
        return loGender;
    }

    public ArrayList<String> getCivilStatusList() {
        ArrayList<String> loCivilSt = new ArrayList<>();
        for(int x = 0; x < CIVIL_STATUS.length; x++) {
            loCivilSt.add(CIVIL_STATUS[x]);
        }
        return loCivilSt;
    }

    public void insert(EClientInfo foInfo){
        poDao.insert(foInfo);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poDao.getClientInfo();
    }

    public EClientInfo GetClientInfo(){
        return poDao.GetClientInfo();
    }

    public String getClientId() {
        return poDao.getClientId();
    }

    public boolean ImportAccountInfo(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportAccountInfoAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    EClientInfo loDetail = poDao.GetUserInfo();
                    loDetail.setClientID(loResponse.getString("sClientID"));
                    loDetail.setLastName(loResponse.getString("sLastName"));
                    loDetail.setFrstName(loResponse.getString("sFrstName"));
                    loDetail.setMiddName(loResponse.getString("sMiddName"));
                    loDetail.setSuffixNm(loResponse.getString("sSuffixNm"));
                    loDetail.setGenderCd(loResponse.getString("cGenderCd"));
                    loDetail.setCvilStat(loResponse.getString("cCvilStat"));
                    loDetail.setBirthDte(loResponse.getString("dBirthDte"));
                    loDetail.setBirthPlc(loResponse.getString("sBirthPlc"));
                    loDetail.setHouseNo1(loResponse.getString("sHouseNo1"));
                    loDetail.setAddress1(loResponse.getString("sAddress1"));
                    loDetail.setBrgyIDx1(loResponse.getString("sBrgyIDx1"));
                    loDetail.setTownIDx1(loResponse.getString("sTownIDx1"));
                    loDetail.setHouseNo2(loResponse.getString("sHouseNo2"));
                    loDetail.setAddress2(loResponse.getString("sAddress2"));
                    loDetail.setBrgyIDx2(loResponse.getString("sBrgyIDx2"));
                    loDetail.setTownIDx2(loResponse.getString("sTownIDx2"));
                    loDetail.setImagePth(loResponse.getString("sImagePth"));
                    loDetail.setImgeDate(loResponse.getString("dImgeDate"));
                    loDetail.setImgeStat(loResponse.getString("cImgeStat"));
                    loDetail.setRecdStat(1);
                    poDao.update(loDetail);
                    AccountInfo loAcc = new AccountInfo(mContext);
                    loAcc.setClientID(loResponse.getString("sClientID"));
                    loAcc.setLastname(loResponse.getString("sLastName"));
                    loAcc.setFirstName(loResponse.getString("sFrstName"));
                    loAcc.setMiddlename(loResponse.getString("sMiddName"));
                    loAcc.setSuffix(loResponse.getString("sSuffixNm"));
                    loAcc.setGender(loResponse.getString("cGenderCd"));
                    loAcc.setCivilStatus(loResponse.getString("cCvilStat"));
                    loAcc.setBirthdate(loResponse.getString("dBirthDte"));
                    loAcc.setBirthplace(loResponse.getString("sBirthPlc"));
                    loAcc.setHouseNo(loResponse.getString("sHouseNo1"));
                    loAcc.setAddress(loResponse.getString("sAddress1"));
                    loAcc.setTownName(loResponse.getString("sTownIDx1"));
                    loAcc.setBarangay(loResponse.getString("sBrgyIDx1"));

                    String lsClient = loAcc.getClientID();
                    String lsLastNm = loAcc.getLastName();
                    String lsFrstNm = loAcc.getFirstName();
                    String lsBirthD = loAcc.getBirthdate();
                    String lsBirthP = loAcc.getBirthplace();
                    if(lsClient.isEmpty() ){
                        if(lsLastNm.isEmpty() && lsFrstNm.isEmpty() &&
                                lsBirthD.isEmpty() && lsBirthP.isEmpty()) {
                            loAcc.setVerifiedStatus(0);
                        } else {
                            loAcc.setVerifiedStatus(2);
                        }
                    } else {
                        loAcc.setVerifiedStatus(1);
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

    public boolean CompleteClientInfo(EClientInfo foClient){
        try {
            JSONObject param = new JSONObject();
            param.put("sUserIDxx", foClient.getUserIDxx());
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("sLastName", foClient.getLastName());
            param.put("sFrstName", foClient.getFrstName());
            param.put("sMiddName", foClient.getMiddName());
            param.put("sMaidenNm", foClient.getMaidenNm());
            param.put("sSuffixNm", foClient.getSuffixNm());
            param.put("cGenderCd", foClient.getGenderCd());
            param.put("cCvilStat", foClient.getCvilStat());
            param.put("sCitizenx", foClient.getCitizenx());
            param.put("dBirthDte", foClient.getBirthDte());
            param.put("sBirthPlc", foClient.getBirthPlc());
            param.put("sHouseNo1", foClient.getHouseNo1());
            param.put("sAddress1", foClient.getAddress1());
            param.put("sBrgyIDx1", foClient.getBrgyIDx1());
            param.put("sTownIDx1", foClient.getTownIDx1());
            param.put("sHouseNo2", foClient.getHouseNo2());
            param.put("sAddress2", foClient.getAddress2());
            param.put("sBrgyIDx2", foClient.getBrgyIDx2());
            param.put("sTownIDx2", foClient.getTownIDx2());

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getCreateNewClientAPI();
            String lsResponse = WebClient.httpsPostJSon(
                    lsAddress,
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
//                    foClient.setClientID(loResponse.getString("employno"));
//                    poDao.update(foClient);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean UpdateAccountInfo(EClientInfo foValue){
        try{
            JSONObject param = new JSONObject();
            param.put("cGenderCd", foValue.getGenderCd());
            param.put("cCvilStat", foValue.getCvilStat());
            param.put("sCitizenx", foValue.getCitizenx());
            param.put("sTaxIDNox", foValue.getTaxIDNox());

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getUpdateAccountInfo(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean UpdateMobileNo(String fsArgs){
        try{
            JSONObject param = new JSONObject();
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("sMobileNo", fsArgs);

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getMobileUpdateAPI(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ChangePassword(String fsOld, String fsNew, String fsNw1){
        try{
            if("Weak".equalsIgnoreCase(PasswordStrength.getPasswordStrength(fsNew))){
                message = "Password is too weak.";
                return false;
            } else if(fsNw1.equalsIgnoreCase(fsNew)){
                message = "Password does not match";
                return false;
            }
            JSONObject param = new JSONObject();
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("oldpswd", fsOld);
            param.put("newpswd", fsNew);

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getEmailUpdateAPI(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean UpdateEmailAddress(String fsArgs){
        try{
            JSONObject param = new JSONObject();
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("sEmailAdd", fsArgs);

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getEmailUpdateAPI(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean UpdateAddress(EClientInfo foVal){
        try{
            JSONObject param = new JSONObject();
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("sHouseNo1", foVal.getHouseNo1());
            param.put("sAddress1", foVal.getAddress1());
            param.put("sBrgyIDx1", foVal.getBrgyIDx1());
            param.put("sTownIDx1", foVal.getTownIDx1());
            param.put("sHouseNo2", foVal.getHouseNo2());
            param.put("sAddress2", foVal.getAddress2());
            param.put("sBrgyIDx2", foVal.getBrgyIDx2());
            param.put("sTownIDx2", foVal.getTownIDx2());

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getAddressUpdateAPI(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean RetrieveShipAndBillAddress(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getRetrieveProfilePictureAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean GetClientProfilePicture(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getRetrieveProfilePictureAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean GetEmails(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportEmailsAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean GetMobileNos(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportMobileNoAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean GetClientVerifiedID(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getRetrieveVerifiedIDAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poJson = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean LogoutUserSession(){
        try{
            poDao.LogoutAccount();
            poDao.LogoutGcard();
            poDao.LogoutItemCart();
            poDao.LogoutMasterPurchase();
            poDao.LogoutDetailPurchase();
            poDao.LogoutGcardLedger();
            poDao.LogoutRedeemItem();
            poDao.LogoutServiceInfo();
            poDao.LogoutMCSerial();
            new AccountInfo(mContext).setLoginStatus(false);

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<DClientInfo.ClientBSAddress> getClientBSAddress(){
        return poDao.getClientBSAddress();
    }

    public LiveData<DClientInfo.oAddressUpdate> GetBillingAddressInfoForUpdate(){
        return poDao.GetBillingAddressInfoForUpdate();
    }
    public LiveData<DClientInfo.oAddressUpdate> GetShippingAddressInfoForUpdate(){
        return poDao.GetShippingAddressInfoForUpdate();
    }
}
