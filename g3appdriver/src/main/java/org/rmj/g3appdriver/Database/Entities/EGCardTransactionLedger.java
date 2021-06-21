package org.rmj.g3appdriver.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "G_Card_Transaction_Ledger")
public class EGCardTransactionLedger {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sReferNox")
    protected String ReferNox;

    @ColumnInfo(name = "sGCardNox")
    protected String GCardNox;

    @ColumnInfo(name = "nEntryNox")
    protected int EntryNox;

    @ColumnInfo(name = "dTransact")
    protected String Transact;

    @ColumnInfo(name = "sSourceDs")
    protected String SourceDs;


    @ColumnInfo(name = "sTranType")
    protected String TranType;

    @ColumnInfo(name = "sTranDesc")
    protected String TranDesc;

    @ColumnInfo(name = "sSourceNo")
    protected String SourceNo;

    @ColumnInfo(name = "nPointsxx")
    protected double Pointsxx;

    @ColumnInfo(name = "cQRCodexx")
    protected String QRCodexx;

    @ColumnInfo(name = "cReceived")
    protected String Received;

    public EGCardTransactionLedger() {
    }

    @NonNull
    public String getReferNox() {
        return ReferNox;
    }

    public void setReferNox(@NonNull String referNox) {
        ReferNox = referNox;
    }

    public String getGCardNox() {
        return GCardNox;
    }

    public void setGCardNox(String GCardNox) {
        this.GCardNox = GCardNox;
    }

    public int getEntryNox() {
        return EntryNox;
    }

    public void setEntryNox(int entryNox) {
        EntryNox = entryNox;
    }

    public String getTransact() {
        return Transact;
    }

    public void setTransact(String transact) {
        Transact = transact;
    }

    public String getSourceDs() {
        return SourceDs;
    }

    public void setSourceDs(String sourceDs) {
        SourceDs = sourceDs;
    }

    public String getTranType() {
        return TranType;
    }

    public void setTranType(String tranType) {
        TranType = tranType;
    }

    public String getTranDesc() {
        return TranDesc;
    }

    public void setTranDesc(String tranDesc) {
        TranDesc = tranDesc;
    }

    public String getSourceNo() {
        return SourceNo;
    }

    public void setSourceNo(String sourceNo) {
        SourceNo = sourceNo;
    }

    public double getPointsxx() {
        return Pointsxx;
    }

    public void setPointsxx(double pointsxx) {
        Pointsxx = pointsxx;
    }

    public String getQRCodexx() {
        return QRCodexx;
    }

    public void setQRCodexx(String QRCodexx) {
        this.QRCodexx = QRCodexx;
    }

    public String getReceived() {
        return Received;
    }

    public void setReceived(String received) {
        Received = received;
    }

}
