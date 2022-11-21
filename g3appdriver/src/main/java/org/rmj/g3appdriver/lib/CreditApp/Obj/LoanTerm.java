package org.rmj.g3appdriver.lib.CreditApp.Obj;

public class LoanTerm {

    private String sLoanTerm;
    private String nMonAmort;
    private String nInterest;
    private String nDiscount;

    public LoanTerm(String sLoanTerm, String nMonAmort, String nInterest, String nDiscount) {
        this.sLoanTerm = sLoanTerm;
        this.nMonAmort = nMonAmort;
        this.nInterest = nInterest;
        this.nDiscount = nDiscount;
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

    public String getnInterest() {
        return nInterest;
    }

    public void setnInterest(String nInterest) {
        this.nInterest = nInterest;
    }

    public String getnDiscount() {
        return nDiscount;
    }

    public void setnDiscount(String nDiscount) {
        this.nDiscount = nDiscount;
    }
}
