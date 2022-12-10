package org.rmj.g3appdriver.dev.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Guanzon_Panalo")
public class EGuanzonPanalo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sPanaloQC")
    private String sPanaloQC;
    @ColumnInfo(name = "dTransact")
    private String dTransact;
    @ColumnInfo(name = "sUserIDxx")
    private String sUserIDxx;
    @ColumnInfo(name = "sPanaloCD")
    private String sPanaloCD;
    @ColumnInfo(name = "sPanaloDs")
    private String sPanaloDs;
    @ColumnInfo(name = "sAcctNmbr")
    private String sAcctNmbr;
    @ColumnInfo(name = "nAmountxx")
    private Double nAmountxx = 0.0;
    @ColumnInfo(name = "sItemCode")
    private String sItemCode;
    @ColumnInfo(name = "sItemDesc")
    private String sItemDesc;
    @ColumnInfo(name = "nItemQtyx")
    private Integer nItemQtyx = 0;
    @ColumnInfo(name = "nRedeemxx")
    private Double nRedeemxx = 0.0;
    @ColumnInfo(name = "dExpiryDt")
    private String dExpiryDt;
    @ColumnInfo(name = "sBranchNm")
    private String sBranchNm;
    @ColumnInfo(name = "dRedeemxx")
    private String dRedeemxx;
    @ColumnInfo(name = "cTranStat")
    private String cTranStat;

    public EGuanzonPanalo() {
    }

    @NonNull
    public String getsPanaloQC() {
        return sPanaloQC;
    }

    public void setsPanaloQC(@NonNull String sPanaloQC) {
        this.sPanaloQC = sPanaloQC;
    }

    public String getdTransact() {
        return dTransact;
    }

    public void setdTransact(String dTransact) {
        this.dTransact = dTransact;
    }

    public String getsUserIDxx() {
        return sUserIDxx;
    }

    public void setsUserIDxx(String sUserIDxx) {
        this.sUserIDxx = sUserIDxx;
    }

    public String getsPanaloCD() {
        return sPanaloCD;
    }

    public void setsPanaloCD(String sPanaloCD) {
        this.sPanaloCD = sPanaloCD;
    }

    public String getsPanaloDs() {
        return sPanaloDs;
    }

    public void setsPanaloDs(String sPanaloDs) {
        this.sPanaloDs = sPanaloDs;
    }

    public String getsAcctNmbr() {
        return sAcctNmbr;
    }

    public void setsAcctNmbr(String sAcctNmbr) {
        this.sAcctNmbr = sAcctNmbr;
    }

    public Double getnAmountxx() {
        return nAmountxx;
    }

    public void setnAmountxx(Double nAmountxx) {
        this.nAmountxx = nAmountxx;
    }

    public String getsItemCode() {
        return sItemCode;
    }

    public void setsItemCode(String sItemCode) {
        this.sItemCode = sItemCode;
    }

    public String getsItemDesc() {
        return sItemDesc;
    }

    public void setsItemDesc(String sItemDesc) {
        this.sItemDesc = sItemDesc;
    }

    public Integer getnItemQtyx() {
        return nItemQtyx;
    }

    public void setnItemQtyx(Integer nItemQtyx) {
        this.nItemQtyx = nItemQtyx;
    }

    public Double getnRedeemxx() {
        return nRedeemxx;
    }

    public void setnRedeemxx(Double nRedeemxx) {
        this.nRedeemxx = nRedeemxx;
    }

    public String getdExpiryDt() {
        return dExpiryDt;
    }

    public void setdExpiryDt(String dExpiryDt) {
        this.dExpiryDt = dExpiryDt;
    }

    public String getsBranchNm() {
        return sBranchNm;
    }

    public void setsBranchNm(String sBranchNm) {
        this.sBranchNm = sBranchNm;
    }

    public String getdRedeemxx() {
        return dRedeemxx;
    }

    public void setdRedeemxx(String dRedeemxx) {
        this.dRedeemxx = dRedeemxx;
    }

    public String getcTranStat() {
        return cTranStat;
    }

    public void setcTranStat(String cTranStat) {
        this.cTranStat = cTranStat;
    }
}
