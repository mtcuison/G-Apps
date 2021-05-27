package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class OrderItems {
    private String itemName;
    private String itemQtyx;
    private String itemPnts;

    public OrderItems(String itemName,
                      String itemQtyx,
                      String itemPnts){
        this.itemName = itemName;
        this.itemQtyx = itemQtyx;
        this.itemPnts = itemPnts;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemQtyx() {
        return itemQtyx;
    }

    public String getItemPnts() {
        return itemPnts;
    }
}
