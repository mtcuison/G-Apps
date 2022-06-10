package org.rmj.guanzongroup.marketplace.Model;

public class HomeImageSliderModel {

    private final String psImgeUrl;

    public HomeImageSliderModel( String fsImgeUrl) {
        this.psImgeUrl = (fsImgeUrl == null) ? "" : fsImgeUrl;
    }

    public String getImageUrl() {
        return psImgeUrl;
    }
}
