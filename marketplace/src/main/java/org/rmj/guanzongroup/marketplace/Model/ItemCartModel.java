package org.rmj.guanzongroup.marketplace.Model;

public class ItemCartModel {

    private String itemImage;
    private String itemName;
    private String itemPrice;
    private String itemQty;
    private boolean isMarket;
    public ItemCartModel(){}
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemQty() {
        return itemQty;
    }
    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }
    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }


    public boolean isMarket() {
        return isMarket;
    }

    public void setMarket(boolean market) {
        isMarket = market;
    }

}
