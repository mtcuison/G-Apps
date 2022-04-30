package org.rmj.guanzongroup.marketplace.Model;

public class ShippingAddressModel {


    private String itemShippingName;
    private String itemSippingMobileNo;
    private String itemShippingAddress;

    public ShippingAddressModel(){}

    public String getItemShippingName() {
        return itemShippingName;
    }

    public void setItemShippingName(String itemShippingName) {
        this.itemShippingName = itemShippingName;
    }

    public String getItemSippingMobileNo() {
        return itemSippingMobileNo;
    }

    public void setItemSippingMobileNo(String itemSippingMobileNo) {
        this.itemSippingMobileNo = itemSippingMobileNo;
    }

    public String getItemShippingAddress() {
        return itemShippingAddress;
    }

    public void setItemShippingAddress(String itemShippingAddress) {
        this.itemShippingAddress = itemShippingAddress;
    }
}
