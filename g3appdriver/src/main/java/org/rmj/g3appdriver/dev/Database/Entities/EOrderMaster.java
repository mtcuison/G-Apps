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
    private String TranTotl;
    @ColumnInfo(name = "nVATRatex")
    private String VATRatex;
    @ColumnInfo(name = "nDiscount")
    private String Discount;
    @ColumnInfo(name = "nAddDiscx")
    private String AddDiscx;
    @ColumnInfo(name = "nFreightx")
    private String Freightx;
    @ColumnInfo(name = "nProcPaym")
    private String ProcPaym;
    @ColumnInfo(name = "nAmtPaidx")
    private String AmtPaidx;
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

    public String getTranTotl() {
        return TranTotl;
    }

    public void setTranTotl(String tranTotl) {
        TranTotl = tranTotl;
    }

    public String getVATRatex() {
        return VATRatex;
    }

    public void setVATRatex(String VATRatex) {
        this.VATRatex = VATRatex;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getAddDiscx() {
        return AddDiscx;
    }

    public void setAddDiscx(String addDiscx) {
        AddDiscx = addDiscx;
    }

    public String getFreightx() {
        return Freightx;
    }

    public void setFreightx(String freightx) {
        Freightx = freightx;
    }

    public String getAmtPaidx() {
        return AmtPaidx;
    }

    public void setAmtPaidx(String amtPaidx) {
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

    public String getProcPaym() {
        return ProcPaym;
    }

    public void setProcPaym(String procPaym) {
        ProcPaym = procPaym;
    }

    public String getPaymType() {
        return PaymType;
    }

    public void setPaymType(String paymType) {
        PaymType = paymType;
    }
}
