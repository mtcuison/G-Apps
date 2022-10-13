package org.rmj.g3appdriver.lib.Account.Obj;

public class UserIdentification {

    private final String sIDNamexx;
    private final String sIDCodexx;
    private final String cWithBack;
    private final String cWithExpr;

    public UserIdentification(String sIDNamexx, String sIDCodexx, String cWithBack, String cWithExpr) {
        this.sIDNamexx = sIDNamexx;
        this.sIDCodexx = sIDCodexx;
        this.cWithBack = cWithBack;
        this.cWithExpr = cWithExpr;
    }

    public String getIDName() {
        return sIDNamexx;
    }

    public String getIDCode() {
        return sIDCodexx;
    }

    public String hasExpiry() {
        return cWithExpr;
    }

    public String hasBack(){
        return cWithBack;
    }
}
