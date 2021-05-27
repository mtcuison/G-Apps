package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

public class CartItem {
    private String ItemIDxx;
    private String ItemName;
    private String ItemPnts;
    private String Quantity;
    private byte[] ItemImgx;

    public CartItem(String itemIDxx,
                    String itemName,
                    String itemPnts,
                    String quantity,
                    byte[] itemImgx){
        this.ItemIDxx = itemIDxx;
        this.ItemName = itemName;
        this.ItemPnts = itemPnts;
        this.Quantity = quantity;
        this.ItemImgx = itemImgx;
    }

    public String getItemPnts() {
        return ItemPnts;
    }

    public byte[] getItemImgx() {
        return ItemImgx;
    }

    public String getItemIDxx() {
        return ItemIDxx;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getTotPntsx() {
        int total = Integer.parseInt(Quantity) * Integer.parseInt(ItemPnts);
        return String.valueOf(total);
    }
}
