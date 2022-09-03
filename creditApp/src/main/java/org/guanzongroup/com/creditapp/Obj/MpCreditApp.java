package org.guanzongroup.com.creditapp.Obj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MpCreditApp {
    private static final String TAG = MpCreditApp.class.getSimpleName();

    private JSONObject params = new JSONObject(); //parent

    private final PersonalInfo poClient = new PersonalInfo();
    private final AddressInfo poAddxx = new AddressInfo();
    private final MeansInfo poMeans = new MeansInfo();
    private final OtherInfo poOther = new OtherInfo();

    private String message;

    public MpCreditApp() {

    }

    public void setUnitType(String fsVal) throws JSONException {
        params.put("cUnitType", fsVal);
    }

    public void setModel(String fsVal) throws JSONException {
        params.put("sModelIDx", fsVal);
    }

    public void setDiscount(String fsVal) throws JSONException {
        params.put("nDiscount", fsVal);
    }

    public void setDownpayment(String fsVal) throws JSONException {
        params.put("nDwnpymnt", fsVal);
    }

    public void setAmortization(String fsVal) throws JSONException {
        params.put("nAmortztn", fsVal);
    }

    public void setInstallmentTerm(String fsVal) throws JSONException {
        params.put("sInstlTrm", fsVal);
    }

    public void setMiscellaneousExpense(String fsVal) throws JSONException {
        params.put("sMiscExpn", fsVal);
    }

    public PersonalInfo clientInfo() {
        return poClient;
    }

    public AddressInfo addressInfo() {
        return poAddxx;
    }

    public MeansInfo meansInfo(){
        return poMeans;
    }

    public OtherInfo otherInfo(){
        return poOther;
    }

    public boolean isDataValid() throws JSONException{
        if(params.has("nDwnpymnt") &&
                params.getString("nDwnpymnt").trim().isEmpty()){
            message = "Unset downpayment detected.";
            return false;
        } else if(params.has("nAmortztn") &&
                params.getString("nAmortztn").trim().isEmpty()){
            message = "Unset amortization detected.";
            return false;
        } else if(params.has("nUnitPrce") &&
                params.getString("nUnitPrce").trim().isEmpty()){
            message = "Unset unit price detected.";
            return false;
        } else if(params.has("sMiscExpn") &&
                params.getString("sMiscExpn").trim().isEmpty()){
            message = "Unset miscellaneous expense detected.";
            return false;
        } else if(params.has("cUnitType") &&
                params.getString("cUnitType").trim().isEmpty()){
            message = "Please select unit type.";
            return false;
        } else if(params.has("sModelIDx") &&
                params.getString("sModelIDx").trim().isEmpty()){
            message = "Please select model.";
            return false;
        } else if(params.has("sInstlTrm") &&
                params.getString("sInstlTrm").trim().isEmpty()){
            message = "Please select installment term.";
            return false;
        } else if(!poClient.isDataValid()) {
            message = poClient.getMessage();
            return false;
        } else if(poAddxx.isDataValid()){
            message = poAddxx.getMessage();
            return false;
        } else if(!meansInfo().isDataValid()){
            message = meansInfo().getMessage();
            return false;
        } else if(!otherInfo().isDataValid()){
            message = otherInfo().getMessage();
            return false;
        } else {
            return true;
        }
    }

    public void setData(String fsVal) throws JSONException{
        params = new JSONObject(fsVal);
        poClient.setData(fsVal);
        poAddxx.setData(fsVal);
        poMeans.setData(fsVal);
        poOther.setData(fsVal);
        Log.d(TAG, params.toString());
    }

    public String getData() throws JSONException {
        params.put("personal_info", poClient.getData());
        params.put("address_info", poAddxx.getData());
        params.put("means_info", poMeans.getData());
        params.put("other_info", poOther.getData());
        Log.d(TAG, params.toString());
        return params.toString();
    }
}
