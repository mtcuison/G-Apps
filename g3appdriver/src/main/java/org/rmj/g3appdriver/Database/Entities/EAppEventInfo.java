package org.rmj.g3appdriver.Database.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "App_Event_Info")
public class EAppEventInfo {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sTransNox")
    protected String TransNox;

    @ColumnInfo(name = "sBranchNm")
    protected String BranchNm;

    @ColumnInfo(name = "dEvntFrom")
    protected String EvntFrom;

    @ColumnInfo(name = "dEvntThru")
    protected String EvntThru;

    @ColumnInfo(name = "sEventTle")
    protected String EventTle;

    @ColumnInfo(name = "sAddressx")
    protected String Addressx;

    @ColumnInfo(name = "sEventURL")
    protected String EventURL;

    @ColumnInfo(name = "sImageURL")
    protected String ImageURL;

    public EAppEventInfo(){}

    @NonNull
    public String getTransNox() {
        return TransNox;
    }

    public void setTransNox(@NonNull String transNox) {
        TransNox = transNox;
    }

    public String getBranchNm() {
        return BranchNm;
    }

    public void setBranchNm(String branchNm) {
        BranchNm = branchNm;
    }

    public String getEvntFrom() {
        return EvntFrom;
    }

    public void setEvntFrom(String evntFrom) {
        EvntFrom = evntFrom;
    }

    public String getEvntThru() {
        return EvntThru;
    }

    public void setEvntThru(String evntThru) {
        EvntThru = evntThru;
    }

    public String getEventTle() {
        return EventTle;
    }

    public void setEventTle(String eventTle) {
        EventTle = eventTle;
    }

    public String getAddressx() {
        return Addressx;
    }

    public void setAddressx(String addressx) {
        Addressx = addressx;
    }

    public String getEventURL() {
        return EventURL;
    }

    public void setEventURL(String eventURL) {
        EventURL = eventURL;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
