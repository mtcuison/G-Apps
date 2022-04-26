package org.rmj.g3appdriver.dev.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Client_Info_Master")
public class EClientInfo {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sUserIDxx")
    private String UserIDxx;
    @ColumnInfo(name = "sClientID")
    private String ClientID;
    @ColumnInfo(name = "sEmailAdd")
    private String EmailAdd;
    @ColumnInfo(name = "sLastName")
    private String LastName;
    @ColumnInfo(name = "sFrstName")
    private String FrstName;
    @ColumnInfo(name = "sMiddName")
    private String MiddName;
    @ColumnInfo(name = "sSuffixNm")
    private String SuffixNm;
    @ColumnInfo(name = "cGenderCd")
    private String GenderCd;
    @ColumnInfo(name = "cCvilStat")
    private String CvilStat;
    @ColumnInfo(name = "sCitizenx")
    private String Citizenx;
    @ColumnInfo(name = "dBirthDte")
    private String BirthDte;
    @ColumnInfo(name = "sBirthPlc")
    private String BirthPlc;
    @ColumnInfo(name = "sHouseNox")
    private String HouseNox;
    @ColumnInfo(name = "sAddressx")
    private String Addressx;
    @ColumnInfo(name = "sTownIDxx")
    private String TownIDxx;
    @ColumnInfo(name = "sBrgyIDxx")
    private String BrgyIDxx;
    @ColumnInfo(name = "sTaxIDNox")
    private String TaxIDNox;
    @ColumnInfo(name = "cRecdStat")
    private String RecdStat;
    @ColumnInfo(name = "sMobileNo")
    private String MobileNo;
    @ColumnInfo(name = "dLoginxxx")
    private String Loginxxx;
    @ColumnInfo(name = "dDateMmbr")
    private String DateMmbr;

    public EClientInfo() {
    }

    @NonNull
    public String getUserIDxx() {
        return UserIDxx;
    }

    public void setUserIDxx(@NonNull String userIDxx) {
        UserIDxx = userIDxx;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFrstName() {
        return FrstName;
    }

    public void setFrstName(String frstName) {
        FrstName = frstName;
    }

    public String getMiddName() {
        return MiddName;
    }

    public void setMiddName(String middName) {
        MiddName = middName;
    }

    public String getSuffixNm() {
        return SuffixNm;
    }

    public void setSuffixNm(String suffixNm) {
        SuffixNm = suffixNm;
    }

    public String getGenderCd() {
        return GenderCd;
    }

    public void setGenderCd(String genderCd) {
        GenderCd = genderCd;
    }

    public String getCvilStat() {
        return CvilStat;
    }

    public void setCvilStat(String cvilStat) {
        CvilStat = cvilStat;
    }

    public String getBirthDte() {
        return BirthDte;
    }

    public void setBirthDte(String birthDte) {
        BirthDte = birthDte;
    }

    public String getBirthPlc() {
        return BirthPlc;
    }

    public void setBirthPlc(String birthPlc) {
        BirthPlc = birthPlc;
    }

    public String getHouseNox() {
        return HouseNox;
    }

    public void setHouseNox(String houseNox) {
        HouseNox = houseNox;
    }

    public String getAddressx() {
        return Addressx;
    }

    public void setAddressx(String addressx) {
        Addressx = addressx;
    }

    public String getTownIDxx() {
        return TownIDxx;
    }

    public void setTownIDxx(String townIDxx) {
        TownIDxx = townIDxx;
    }

    public String getBrgyIDxx() {
        return BrgyIDxx;
    }

    public void setBrgyIDxx(String brgyIDxx) {
        BrgyIDxx = brgyIDxx;
    }

    public String getTaxIDNox() {
        return TaxIDNox;
    }

    public void setTaxIDNox(String taxIDNox) {
        TaxIDNox = taxIDNox;
    }

    public String getRecdStat() {
        return RecdStat;
    }

    public void setRecdStat(String recdStat) {
        RecdStat = recdStat;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getLoginxxx() {
        return Loginxxx;
    }

    public void setLoginxxx(String loginxxx) {
        Loginxxx = loginxxx;
    }

    public String getDateMmbr() {
        return DateMmbr;
    }

    public void setDateMmbr(String dateMmbr) {
        DateMmbr = dateMmbr;
    }

    public String getCitizenx() {
        return Citizenx;
    }

    public void setCitizenx(String citizenx) {
        Citizenx = citizenx;
    }
}
