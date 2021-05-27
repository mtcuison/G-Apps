package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class RedeemableItems {
    private String itemIDxxx;
    private String itemNamex;
    private String itemPntsx;
    private String cNotified;
    private byte[] itemImage;

    public RedeemableItems(String itemIDxxx,
                           String itemNamex,
                           String itemPntsx,
                           byte[] itemImage,
                           String cNotified){
        this.itemIDxxx = itemIDxxx;
        this.itemNamex = itemNamex;
        this.itemPntsx = itemPntsx;
        this.cNotified = cNotified;
        this.itemImage = itemImage;
    }

    public String getItemIDxxx() {
        return itemIDxxx;
    }

    public String getItemNamex() {
        return itemNamex;
    }

    public String getItemPntsx() {
        return itemPntsx;
    }

    public byte[] getItemImage() {
        return itemImage;
    }

    public boolean isNotified() {
        return cNotified.equalsIgnoreCase("1");
    }
}
