package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class Events {
    private String TramsNoxxx;
    private String BranchName;
    private String EventTitle;
    private String EventStart;
    private String EventEnded;
    private String EventVenue;
    private String EventURLxx;
    private String Thumbnailx;

    public Events(String tramsNoxxx,
                  String branchName,
                  String eventTitle,
                  String eventStart,
                  String eventEnded,
                  String eventVenue,
                  String eventURLxx,
                  String thumbnailx){
        this.TramsNoxxx = tramsNoxxx;
        this.BranchName = branchName;
        this.EventTitle = eventTitle;
        this.EventStart = eventStart;
        this.EventEnded = eventEnded;
        this.EventVenue = eventVenue;
        this.EventURLxx = eventURLxx;
        this.Thumbnailx = thumbnailx;
    }

    public String getTramsNoxxx() {
        return TramsNoxxx;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public String getEventStart() {
        return EventStart;
    }

    public String getEventEnded() {
        return EventEnded;
    }

    public String getEventVenue() {
        return EventVenue;
    }

    public String getEventURLxx() {
        return EventURLxx;
    }

    public String getThumbnailx() {
        return Thumbnailx;
    }
}
