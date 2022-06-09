package org.rmj.guanzongroup.marketplace.Model;

public class HomeImageSliderModel {

    private final String psDescrpt;
    private final String psImgeUrl;

    public HomeImageSliderModel(String fsDescrpt, String fsImgeUrl) {
        this.psDescrpt = (fsDescrpt == null) ? "" : fsDescrpt;
        this.psImgeUrl = (fsImgeUrl == null) ? "" : fsImgeUrl;
    }

    public String getDescription() {
        return psDescrpt;
    }

    public String getImageUrl() {
        return psImgeUrl;
    }
}
