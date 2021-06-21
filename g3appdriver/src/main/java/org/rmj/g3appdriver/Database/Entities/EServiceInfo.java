package org.rmj.g3appdriver.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tbl_service")
public class EServiceInfo {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sGCardNox")
    protected String GCardNox;

    @ColumnInfo(name = "sSerialID")
    protected String SerialID;

    @ColumnInfo(name = "sEngineNo")
    protected String EngineNo;

    @ColumnInfo(name = "sFrameNox")
    protected String FrameNox;

    @ColumnInfo(name = "sBrandNme")
    protected String BrandNme;

    @ColumnInfo(name = "sModelNme")
    protected String ModelNme;

    @ColumnInfo(name = "cFSEPStat")
    protected char FSEPStat;

    @ColumnInfo(name = "dPurchase")
    protected String Purchase;

    @ColumnInfo(name = "nYellowxx")
    protected int Yellowxx;

    @ColumnInfo(name = "nWhitexxx")
    protected int Whitexxx;

    @ColumnInfo(name = "nYlwCtrxx")
    protected int YlwCtrxx;

    @ColumnInfo(name = "nWhtCtrxx")
    protected int WhtCtrxx;

    @ColumnInfo(name = "dLastSrvc")
    protected String LastSrvc;

    @ColumnInfo(name = "nMIlAgexx")
    protected int MIlAgexx;

    @ColumnInfo(name = "dNxtRmnds")
    protected String  NxtRmnds;

    public EServiceInfo() {
    }

    @NonNull
    public String getGCardNox() {
        return GCardNox;
    }

    public void setGCardNox(@NonNull String GCardNox) {
        this.GCardNox = GCardNox;
    }

    public String getSerialID() {
        return SerialID;
    }

    public void setSerialID(String serialID) {
        SerialID = serialID;
    }

    public String getEngineNo() {
        return EngineNo;
    }

    public void setEngineNo(String engineNo) {
        EngineNo = engineNo;
    }

    public String getFrameNox() {
        return FrameNox;
    }

    public void setFrameNox(String frameNox) {
        FrameNox = frameNox;
    }

    public String getBrandNme() {
        return BrandNme;
    }

    public void setBrandNme(String brandNme) {
        BrandNme = brandNme;
    }

    public String getModelNme() {
        return ModelNme;
    }

    public void setModelNme(String modelNme) {
        ModelNme = modelNme;
    }

    public char getFSEPStat() {
        return FSEPStat;
    }

    public void setFSEPStat(char FSEPStat) {
        this.FSEPStat = FSEPStat;
    }

    public String getPurchase() {
        return Purchase;
    }

    public void setPurchase(String purchase) {
        Purchase = purchase;
    }

    public int getYellowxx() {
        return Yellowxx;
    }

    public void setYellowxx(int yellowxx) {
        Yellowxx = yellowxx;
    }

    public int getWhitexxx() {
        return Whitexxx;
    }

    public void setWhitexxx(int whitexxx) {
        Whitexxx = whitexxx;
    }

    public int getYlwCtrxx() {
        return YlwCtrxx;
    }

    public void setYlwCtrxx(int ylwCtrxx) {
        YlwCtrxx = ylwCtrxx;
    }

    public int getWhtCtrxx() {
        return WhtCtrxx;
    }

    public void setWhtCtrxx(int whtCtrxx) {
        WhtCtrxx = whtCtrxx;
    }

    public String getLastSrvc() {
        return LastSrvc;
    }

    public void setLastSrvc(String lastSrvc) {
        LastSrvc = lastSrvc;
    }

    public int getMIlAgexx() {
        return MIlAgexx;
    }

    public void setMIlAgexx(int MIlAgexx) {
        this.MIlAgexx = MIlAgexx;
    }

    public String getNxtRmnds() {
        return NxtRmnds;
    }

    public void setNxtRmnds(String nxtRmnds) {
        NxtRmnds = nxtRmnds;
    }
}
