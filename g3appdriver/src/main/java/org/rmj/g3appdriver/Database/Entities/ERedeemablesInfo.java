package org.rmj.g3appdriver.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_redeemables")
public class ERedeemablesInfo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sTransNox")
    protected String TransNox;

    @ColumnInfo(name = "sPromoCde")
    protected String PromoCde;

    @ColumnInfo(name = "sPromoDsc")
    protected String PromoDsc;

    @ColumnInfo(name = "nPointsxx")
    protected double Pointsxx;

    @ColumnInfo(name = "sImageUrl")
    protected String ImageUrl;

    @ColumnInfo(name = "cPreOrder")
    protected String PreOrder;

    @ColumnInfo(name = "dDateFrom")
    protected String DateFrom;

    @ColumnInfo(name = "dDateThru")
    protected String DateThru;

    @ColumnInfo(name = "cNotified")
    protected String Notified;

    public ERedeemablesInfo(){

    }

    @NonNull
    public String getTransNox() {
        return TransNox;
    }

    public void setTransNox(@NonNull String transNox) {
        TransNox = transNox;
    }

    public String getPromoCde() {
        return PromoCde;
    }

    public void setPromoCde(String promoCde) {
        PromoCde = promoCde;
    }

    public String getPromoDsc() {
        return PromoDsc;
    }

    public void setPromoDsc(String promoDsc) {
        PromoDsc = promoDsc;
    }

    public double getPointsxx() {
        return Pointsxx;
    }

    public void setPointsxx(double pointsxx) {
        Pointsxx = pointsxx;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getPreOrder() {
        return PreOrder;
    }

    public void setPreOrder(String preOrder) {
        PreOrder = preOrder;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    public String getDateThru() {
        return DateThru;
    }

    public void setDateThru(String dateThru) {
        DateThru = dateThru;
    }

    public String getNotified() {
        return Notified;
    }

    public void setNotified(String notified) {
        Notified = notified;
    }
}
