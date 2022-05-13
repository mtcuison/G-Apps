package org.rmj.g3appdriver.etc;

public class oLoadStat {
    private boolean cTrmCndtn = false;
    private boolean cPrmnGrnt = false;
    private boolean cIsLoginx = false;
    private boolean cCmpltAcc = false;

    public oLoadStat(boolean cTrmCndtn, boolean cPrmnGrnt, boolean cIsLoginx, boolean cCmpltAcc) {
        this.cTrmCndtn = cTrmCndtn;
        this.cPrmnGrnt = cPrmnGrnt;
        this.cIsLoginx = cIsLoginx;
        this.cCmpltAcc = cCmpltAcc;
    }

    public boolean hasAggreedTermsAndConditions() {
        return cTrmCndtn;
    }

    public void setAggreedTermsAndConditions(boolean cTrmCndtn) {
        this.cTrmCndtn = cTrmCndtn;
    }

    public void setPermissionGranted(boolean val) {
        this.cPrmnGrnt = val;
    }

    public void setLoginStat(boolean val) {
        this.cIsLoginx = val;
    }

    public void setCompleteAccount(boolean val) {
        this.cCmpltAcc = val;
    }

    public boolean getPermissionGranted() {
        return cPrmnGrnt;
    }

    public boolean iscIsLoginx() {
        return cIsLoginx;
    }

    public boolean iscCmpltAcc() {
        return cCmpltAcc;
    }
}
