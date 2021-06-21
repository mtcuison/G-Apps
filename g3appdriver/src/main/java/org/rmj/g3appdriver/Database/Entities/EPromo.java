package org.rmj.g3appdriver.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_promo_link")
public class EPromo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sTransNox")
    protected String TransNox;

    @ColumnInfo(name = "dTransact")
    protected String Transact;

    @ColumnInfo(name = "sImageUrl")
    protected String ImageUrl;

    @ColumnInfo(name = "sImgeByte")
    protected String ImgeByte;

    @ColumnInfo(name = "sPromoUrl")
    protected String PromoUrl;

    @ColumnInfo(name = "sCaptionx")
    protected String Captionx;

    @ColumnInfo(name = "dDateFrom")
    protected String DateFrom;

    @ColumnInfo(name = "dDateThru")
    protected String DateThru;

    @ColumnInfo(name = "cNotified")
    protected String Notified;

    @ColumnInfo(name = "cDivision")
    protected int Division;
    
    public EPromo() {
    }

    @NonNull
    public String getTransNox() {
        return TransNox;
    }

    public void setTransNox(@NonNull String transNox) {
        TransNox = transNox;
    }

    public String getTransact() {
        return Transact;
    }

    public void setTransact(String transact) {
        Transact = transact;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImgeByte() {
        return ImgeByte;
    }

    public void setImgeByte(String imgeByte) {
        ImgeByte = imgeByte;
    }

    public String getPromoUrl() {
        return PromoUrl;
    }

    public void setPromoUrl(String promoUrl) {
        PromoUrl = promoUrl;
    }

    public String getCaptionx() {
        return Captionx;
    }

    public void setCaptionx(String captionx) {
        Captionx = captionx;
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

    public int getDivision() {
        return Division;
    }

    public void setDivision(int division) {
        Division = division;
    }

}
