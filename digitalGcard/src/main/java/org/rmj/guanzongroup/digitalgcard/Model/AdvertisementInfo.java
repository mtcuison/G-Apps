package org.rmj.guanzongroup.digitalgcard.Model;

public class AdvertisementInfo {

    private String sPromoIdx = "";
    private String sImageUrl = "";

    public AdvertisementInfo() { }

    public String getPromoId() {
        return (sPromoIdx != null) ? sPromoIdx : "";
    }

    public void setPromoId(String sPromoIdx) {
        this.sPromoIdx = sPromoIdx;
    }

    public String getImageUrl() {
        return (sImageUrl != null) ? sImageUrl : "";
    }

    public void setImageUrl(String sImageUrl) {
        this.sImageUrl = sImageUrl;
    }

}
