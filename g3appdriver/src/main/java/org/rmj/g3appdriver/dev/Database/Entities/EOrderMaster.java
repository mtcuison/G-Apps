package org.rmj.g3appdriver.dev.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MarketPlace_Order_Master")
public class EOrderMaster {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sTransNox")
    private String TransNox;
    @ColumnInfo(name = "sBranchCd")
    private String BranchCd;
    @ColumnInfo(name = "dTransact")
    private String Transact;
    @ColumnInfo(name = "dExpected")
    private String Expected;
    @ColumnInfo(name = "sClientID")
    private String ClientID;
    @ColumnInfo(name = "sAppUsrID")
    private String AppUsrID;
    @ColumnInfo(name = "sReferNox")
    private String ReferNox;
    @ColumnInfo(name = "sRemarksx")
    private String Remarksx;
    @ColumnInfo(name = "nTranTotl")
    private Double TranTotl = 0.00;
    @ColumnInfo(name = "nVATRatex")
    private Double VATRatex = 0.00;
    @ColumnInfo(name = "nDiscount")
    private Double Discount = 0.00;
    @ColumnInfo(name = "nAddDiscx")
    private Double AddDiscx = 0.00;
    @ColumnInfo(name = "nFreightx")
    private Double Freightx = 0.00;
    @ColumnInfo(name = "nProcPaym")
    private Double ProcPaym = 0.00;
    @ColumnInfo(name = "nAmtPaidx")
    private Double AmtPaidx = 0.00;
    @ColumnInfo(name = "dDueDatex")
    private String DueDatex;
    @ColumnInfo(name = "sTermCode")
    private String TermCode;
    @ColumnInfo(name = "sSourceNo")
    private String SourceNo;
    @ColumnInfo(name = "sSourceCd")
    private String SourceCd;
    @ColumnInfo(name = "cTranStat")
    private String TranStat;
    @ColumnInfo(name = "cPaymType")
    private String PaymType;
    @ColumnInfo(name = "dModified")
    private String Modified;
    @ColumnInfo(name = "dTimeStmp")
    private String TimeStmp;

    public EOrderMaster() {
    }

    @NonNull
    public String getTransNox() {
        return TransNox;
    }

    public void setTransNox(@NonNull String transNox) {
        TransNox = transNox;
    }

    public String getBranchCd() {
        return BranchCd;
    }

    public void setBranchCd(String branchCd) {
        BranchCd = branchCd;
    }

    public String getTransact() {
        return Transact;
    }

    public void setTransact(String transact) {
        Transact = transact;
    }

    public String getExpected() {
        return Expected;
    }

    public void setExpected(String expected) {
        Expected = expected;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getReferNox() {
        return ReferNox;
    }

    public void setReferNox(String referNox) {
        ReferNox = referNox;
    }

    public String getRemarksx() {
        return Remarksx;
    }

    public void setRemarksx(String remarksx) {
        Remarksx = remarksx;
    }

    public double getTranTotl() {
        return TranTotl;
    }

    public void setTranTotl(double tranTotl) {
        TranTotl = tranTotl;
    }

    public double getVATRatex() {
        return VATRatex;
    }

    public void setVATRatex(double VATRatex) {
        this.VATRatex = VATRatex;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public double getAddDiscx() {
        return AddDiscx;
    }

    public void setAddDiscx(double addDiscx) {
        AddDiscx = addDiscx;
    }

    public double getFreightx() {
        return Freightx;
    }

    public void setFreightx(double freightx) {
        Freightx = freightx;
    }

    public double getAmtPaidx() {
        return AmtPaidx;
    }

    public void setAmtPaidx(double amtPaidx) {
        AmtPaidx = amtPaidx;
    }

    public String getDueDatex() {
        return DueDatex;
    }

    public void setDueDatex(String dueDatex) {
        DueDatex = dueDatex;
    }

    public String getTermCode() {
        return TermCode;
    }

    public void setTermCode(String termCode) {
        TermCode = termCode;
    }

    public String getSourceNo() {
        return SourceNo;
    }

    public void setSourceNo(String sourceNo) {
        SourceNo = sourceNo;
    }

    public String getSourceCd() {
        return SourceCd;
    }

    public void setSourceCd(String sourceCd) {
        SourceCd = sourceCd;
    }

    public String getTranStat() {
        return TranStat;
    }

    public void setTranStat(String tranStat) {
        TranStat = tranStat;
    }

    public String getModified() {
        return Modified;
    }

    public void setModified(String modified) {
        Modified = modified;
    }

    public String getTimeStmp() {
        return TimeStmp;
    }

    public void setTimeStmp(String timeStmp) {
        TimeStmp = timeStmp;
    }

    public String getAppUsrID() {
        return AppUsrID;
    }

    public void setAppUsrID(String appUsrID) {
        AppUsrID = appUsrID;
    }

    public double getProcPaym() {
        return ProcPaym;
    }

    public void setProcPaym(double procPaym) {
        ProcPaym = procPaym;
    }

    public String getPaymType() {
        return PaymType;
    }

    public void setPaymType(String paymType) {
        PaymType = paymType;
    }
}
