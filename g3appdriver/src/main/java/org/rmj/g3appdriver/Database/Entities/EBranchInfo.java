package org.rmj.g3appdriver.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_branch")
public class EBranchInfo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sBranchCd")
    private String BranchCd;

    @ColumnInfo(name = "sBranchNm")
    private String BranchNm;

    @ColumnInfo(name = "sDescript")
    private String Descript;

    @ColumnInfo(name = "sAddressx")
    private String Addressx;

    @ColumnInfo(name = "sContactx")
    private String Contactx;

    @ColumnInfo(name = "sTelNumbr")
    private String TelNumbr;

    @ColumnInfo(name = "sEmailAdd")
    private String EmailAdd;

    public EBranchInfo() {
    }

    @NonNull
    public String getBranchCd() {
        return BranchCd;
    }

    public void setBranchCd(@NonNull String branchCd) {
        BranchCd = branchCd;
    }

    public String getBranchNm() {
        return BranchNm;
    }

    public void setBranchNm(String branchNm) {
        BranchNm = branchNm;
    }

    public String getDescript() {
        return Descript;
    }

    public void setDescript(String descript) {
        Descript = descript;
    }

    public String getAddressx() {
        return Addressx;
    }

    public void setAddressx(String addressx) {
        Addressx = addressx;
    }

    public String getContactx() {
        return Contactx;
    }

    public void setContactx(String contactx) {
        Contactx = contactx;
    }

    public String getTelNumbr() {
        return TelNumbr;
    }

    public void setTelNumbr(String telNumbr) {
        TelNumbr = telNumbr;
    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

}
