package org.rmj.guanzongroup.digitalgcard.Model;

public class GcardInfo {

    private String psGcardNo;
    private String psCardNox;
    private String psCardNme;
    private double pnCardPts;

    private String psErrorMs ="";

    public GcardInfo(String fsGcardNo, String fsCardNox, String fsCardNme, double fnCardPts) {
        this.psGcardNo = fsGcardNo;
        this.psCardNox = fsCardNox;
        this.psCardNme = fsCardNme;
        this.pnCardPts = fnCardPts;
    }

    public String getGcardNumber() {
        return psGcardNo;
    }

    public String getCardNumber() {
        return psCardNox;
    }

    public String getCardName() {
        return psCardNme;
    }

    public double getCardPoints() {
        return pnCardPts;
    }

    public boolean isDataValid() {
        return isGcardNumberValid()
                || isCardNumberValid()
                || isCardNameValid();
    }

    public boolean isGcardNumberValid() {
        if(psGcardNo == null || "".equalsIgnoreCase(psGcardNo)) {
            return false;
        }
        return true;
    }

    public boolean isCardNumberValid() {
        if(psCardNox == null || "".equalsIgnoreCase(psCardNox)) {
            return false;
        }
        return true;
    }

    public boolean isCardNameValid() {
        if(psCardNme == null || "".equalsIgnoreCase(psCardNme)) {
            return false;
        }
        return true;
    }

}
