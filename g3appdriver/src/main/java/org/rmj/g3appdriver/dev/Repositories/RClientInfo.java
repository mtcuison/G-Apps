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
                    loDetail.setBrgyIDx1(loResponse.getString("sAddress1"));
                    loDetail.setTownIDx1(loResponse.getString("sTownIDx1"));
                    loDetail.setHouseNo2(loResponse.getString("sHouseNo2"));
                    loDetail.setAddress2(loResponse.getString("sAddress2"));
                    loDetail.setBrgyIDx2(loResponse.getString("sAddress2"));
                    loDetail.setTownIDx2(loResponse.getString("sTownIDx2"));
                    loDetail.setImagePth(loResponse.getString("sImagePth"));
                    loDetail.setImgeDate(loResponse.getString("dImgeDate"));
                    loDetail.setImgeStat(loResponse.getString("cImgeStat"));
                    loDetail.setRecdStat(1);
                    poDao.update(loDetail);
//                    AccountInfo loAcc = new AccountInfo(mContext);
//                    loAcc.setClientID(loResponse.getString("sClientID"));
//                    loAcc.setLastname(loResponse.getString("sLastName"));
//                    loAcc.setFirstName(loResponse.getString("sFrstName"));
//                    loAcc.setMiddlename(loResponse.getString("sMiddName"));
//                    loAcc.setSuffix(loResponse.getString("sSuffixNm"));
//                    loAcc.setGender(loResponse.getString("cGenderCd"));
//                    loAcc.setCivilStatus(loResponse.getString("cCvilStat"));
//                    loAcc.setCitizenship(loResponse.getString("sCitizenx"));
//                    loAcc.setBirthdate(loResponse.getString("dBirthDte"));
//                    loAcc.setBirthplace(loResponse.getString("sBirthPlc"));
//                    loAcc.setHouseNo(loResponse.getString("sHouseNox"));
//                    loAcc.setAddress(loResponse.getString("sAddressx"));
//                    loAcc.setTownName(loResponse.getString("sTownIDxx"));
//                    loAcc.setBarangay(loResponse.getString("sBrgyIDxx"));
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
                    foClient.setClientID(loResponse.getString("employno"));
                    poDao.update(foClient);
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

    public boolean UpdateShippingAddress(AddressUpdate foVal){
        try{
            JSONObject param = new JSONObject();
            param.put("dTransact", new AppConstants().DATE_MODIFIED);
            param.put("sHouseNo1", foVal.getHouseNo());
            param.put("sAddress1", foVal.getAddress());
            param.put("sBrgyIDx1", foVal.getBrgyID());
            param.put("sTownIDx1", foVal.getTownID());
            param.put("sHouseNo2", foVal.getHouseNo1());
            param.put("sAddress2", foVal.getAddress1());
            param.put("sBrgyIDx2", foVal.getBrgyID1());
            param.put("sTownIDx2", foVal.getTownID1());

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

    public boolean GetVerifiedEmails(){
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

    public static class AddressUpdate{
        private String houseNo, Address, brgyID, townID, houseNo1, Address1, brgyID1, townID1;

        private final boolean isSameAdd;

        public AddressUpdate(boolean fbVal) {
            this.isSameAdd = fbVal;
        }

        public String getHouseNo() {
            return houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String getBrgyID() {
            return brgyID;
        }

        public void setBrgyID(String brgyID) {
            this.brgyID = brgyID;
        }

        public String getTownID() {
            return townID;
        }

        public void setTownID(String townID) {
            this.townID = townID;
        }

        public String getHouseNo1() {
            if(isSameAdd)
                return houseNo;
            else
                return houseNo1;
        }

        public void setHouseNo1(String houseNo1) {
            this.houseNo1 = houseNo1;
        }

        public String getAddress1() {
            if(isSameAdd)
                return Address;
            else
                return Address1;
        }

        public void setAddress1(String address1) {
            Address1 = address1;
        }

        public String getBrgyID1() {
            if(isSameAdd)
                return brgyID;
            else
                return brgyID1;
        }

        public void setBrgyID1(String brgyID1) {
            this.brgyID1 = brgyID1;
        }

        public String getTownID1() {
            if(isSameAdd)
                return townID;
            else
                return townID1;
        }

        public void setTownID1(String townID1) {
            this.townID1 = townID1;
        }
    }
}
