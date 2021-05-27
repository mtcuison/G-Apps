package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class GcardItem {
    private String GCardNumber;
    private String GCardName;
    private String GCardPoints;
    private String cNotified;

    public GcardItem(String gcardNumber,
                     String gcardName,
                     String gcardPoints,
                     String cNotified){
        this.GCardName = gcardName;
        this.GCardNumber = gcardNumber;
        this.GCardPoints = gcardPoints;
        this.cNotified = cNotified;
    }

    public String getGCardNumber() {
        return GCardNumber;
    }

    public String getGCardName() {
        return GCardName;
    }

    public String getGCardPoints() {
        return GCardPoints;
    }

    public boolean isNewGCard() {
        return cNotified.equalsIgnoreCase("0");
    }
}
