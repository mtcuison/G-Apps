package org.rmj.g3appdriver.etc;

import java.text.DecimalFormat;

public class ItemCartModel {


    private boolean isMarket;
    private String itemImage;
    private String itemName;
    private String itemPrice;
    private String itemQty;
    public ItemCartModel(){}
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemPrice() {
        String formatted;
        if(isMarket){
            formatted = "₱ " + currencyFormat(Double.parseDouble(itemPrice));
        }else{

            formatted = currencyFormat(Double.parseDouble(itemPrice)) + " point/s";
        }
        return formatted;
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

    public void setIsMarket(boolean market) {
        this.isMarket = market;
    }

    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}
