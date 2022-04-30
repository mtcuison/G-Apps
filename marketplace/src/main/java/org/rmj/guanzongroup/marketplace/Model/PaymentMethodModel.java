package org.rmj.guanzongroup.marketplace.Model;

public class PaymentMethodModel {


    private String itemPaymentName;
    private String itemPaymentNo;
    private String itemPaymentCateg;

    public PaymentMethodModel(){}

    public String getItemPaymentName() {
        return itemPaymentName;
    }

    public void setItemPaymentName(String itemPaymentName) {
        this.itemPaymentName = itemPaymentName;
    }

    public String getItemPaymentNo() {
        return itemPaymentNo;
    }

    public void setItemPaymentNo(String itemPaymentNo) {
        this.itemPaymentNo = itemPaymentNo;
    }

    public String getItemPaymentCateg() {
        return itemPaymentCateg;
    }

    public void setItemPaymentCateg(String itemPaymentCateg) {
        this.itemPaymentCateg = itemPaymentCateg;
    }
}
