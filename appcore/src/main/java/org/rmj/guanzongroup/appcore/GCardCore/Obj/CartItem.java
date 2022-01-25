package org.rmj.guanzongroup.appcore.GCardCore.Obj;

public class CartItem {
    private String sTransNox = "";
    private String sPromoIDx = "";
    private int nItemQtyx = 0;
    private double nPointsxx = 0;

    public CartItem(String sTransNox, String sPromoIDx, int nItemQtyx, double nPointsxx) {
        this.sTransNox = sTransNox;
        this.sPromoIDx = sPromoIDx;
        this.nItemQtyx = nItemQtyx;
        this.nPointsxx = nPointsxx;
    }

    public String getTransNox() {
        return sTransNox;
    }

    public String getPromoIDx() {
        return sPromoIDx;
    }

    public int getItemQtyx() {
        return nItemQtyx;
    }

    public double getnPointsxx() {
        return nPointsxx;
    }

    public double getTotalItemPoints(){
        return nItemQtyx * nPointsxx;
    }
}
