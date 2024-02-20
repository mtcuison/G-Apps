package org.rmj.g3appdriver.lib.Account.Obj;

import org.json.JSONObject;
import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;

public class ClientCredentials {
    private String sClientID = "";
    private String sBirthDte = "";
    private String sConfirmx = "0";

    private String message = "";

    CodeGenerator poCode;

    public ClientCredentials(String sClientID, String sBirthDte) {
        this.sClientID = sClientID;
    }

    public void setsConfirmx(String sConfirmx) {
        this.sConfirmx = sConfirmx;
    }

    public String getMessage() {
        return message;
    }

    public boolean isDataValid(){
        if (sClientID.isEmpty()){
            message = "Please enter gcard number.";
            return false;
        } else if(sBirthDte.isEmpty()){
            message = "Please enter your birth date.";
            return false;
        } else {
            return true;
        }
    }

    public String getJSONParameters() throws Exception{
        JSONObject params = new JSONObject();
        params.put("secureno", poCode.generateSecureNo(sClientID));
        params.put("bday", sBirthDte);
        params.put("newdevce", sConfirmx);
        return params.toString();
    }
}
