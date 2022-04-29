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
                    loDetail.setCitizenx(loResponse.getString("sCitizenx"));
                    loDetail.setBirthDte(loResponse.getString("dBirthDte"));
                    loDetail.setBirthPlc(loResponse.getString("sBirthPlc"));
                    loDetail.setHouseNox(loResponse.getString("sHouseNox"));
                    loDetail.setAddressx(loResponse.getString("sAddressx"));
                    loDetail.setTownIDxx(loResponse.getString("sTownIDxx"));
                    loDetail.setBrgyIDxx(loResponse.getString("sBrgyIDxx"));
                    loDetail.setTaxIDNox(loResponse.getString("sTaxIDNox"));
                    loDetail.setMobileNo(loResponse.getString("sMobileNo"));
                    loDetail.setEmailAdd(loResponse.getString("sEmailAdd"));
                    loDetail.setRecdStat("1");
                    poDao.update(loDetail);
                    AccountInfo loAcc = new AccountInfo(mContext);
                    loAcc.setClientID(loResponse.getString("sClientID"));
                    loAcc.setLastname(loResponse.getString("sLastName"));
                    loAcc.setFirstName(loResponse.getString("sFrstName"));
                    loAcc.setMiddlename(loResponse.getString("sMiddName"));
                    loAcc.setSuffix(loResponse.getString("sSuffixNm"));
                    loAcc.setGender(loResponse.getString("cGenderCd"));
                    loAcc.setCivilStatus(loResponse.getString("cCvilStat"));
                    loAcc.setCitizenship(loResponse.getString("sCitizenx"));
                    loAcc.setBirthdate(loResponse.getString("dBirthDte"));
                    loAcc.setBirthplace(loResponse.getString("sBirthPlc"));
                    loAcc.setHouseNo(loResponse.getString("sHouseNox"));
                    loAcc.setAddress(loResponse.getString("sAddressx"));
                    loAcc.setTownName(loResponse.getString("sTownIDxx"));
                    loAcc.setBarangay(loResponse.getString("sBrgyIDxx"));
                    loAcc.setTaxId(loResponse.getString("sTaxIDNox"));
                    loAcc.setMobileNo(loResponse.getString("sMobileNo"));
                    loAcc.setEmailAdd(loResponse.getString("sEmailAdd"));
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
            param.put("sLastName", foClient.getLastName());
            param.put("sFrstName", foClient.getFrstName());
            param.put("sMiddName", foClient.getMiddName());
            param.put("sSuffixNm", foClient.getSuffixNm());
            param.put("cGenderCd", foClient.getGenderCd());
            param.put("cCvilStat", foClient.getCvilStat());
            param.put("sCitizenx", foClient.getCitizenx());
            param.put("dBirthDte", foClient.getBirthDte());
            param.put("sBirthPlc", foClient.getBirthPlc());
            param.put("sHouseNox", foClient.getHouseNox());
            param.put("sAddressx", foClient.getAddressx());
            param.put("sTownIDxx", foClient.getTownIDxx());
            param.put("sBrgyIDxx", foClient.getBrgyIDxx());
            param.put("sTaxIDNox", foClient.getTaxIDNox());

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

    public boolean UpdateAccountInfo(String fsGender, String fsCvilSt, String fsCitizn, String fsTinNox){
        try{
            JSONObject param = new JSONObject();
            param.put("cGenderCd", fsGender);
            param.put("cCvilStat", fsCvilSt);
            param.put("sCitizenx", fsCitizn);
            param.put("sTaxIDNox", fsTinNox);

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
}
