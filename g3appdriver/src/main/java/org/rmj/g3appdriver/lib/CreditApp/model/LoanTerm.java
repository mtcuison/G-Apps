package org.rmj.g3appdriver.lib.CreditApp.model;

public class LoanTerm {

    private String sLoanTerm;
    private String nMonAmort;
    private String nDownPaym;
    private String nMiscChrg;

    public LoanTerm(String sLoanTerm, String nMonAmort, String nDownPaym, String nMiscChrg) {
        this.sLoanTerm = sLoanTerm;
        this.nMonAmort = nMonAmort;
        this.nDownPaym = nDownPaym;
        this.nMiscChrg = nMiscChrg;
    }

    public String getsLoanTerm() {
        return sLoanTerm;
    }

    public void setsLoanTerm(String sLoanTerm) {
        this.sLoanTerm = sLoanTerm;
    }

    public String getnMonAmort() {
        return nMonAmort;
    }

    public void setnMonAmort(String nMonAmort) {
        this.nMonAmort = nMonAmort;
    }

    public String getnDownPaym() {
        return nDownPaym;
    }

    public void setnDownPaym(String nDownPaym) {
        this.nDownPaym = nDownPaym;
    }

    public String getnMiscChrg() {
        return nMiscChrg;
    }

    public void setnMiscChrg(String nMiscChrg) {
        this.nMiscChrg = nMiscChrg;
    }
}
