package org.rmj.g3appdriver.etc;

public class CashFormatter {

    public static String parse(String fsCashAmt) {
        try {
            String lsFormat = String.format("%,.2f", Double.parseDouble(fsCashAmt));
            return "₱" + lsFormat;
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static String parseDiscount(String args){
        try{
            double lnDiscount = Double.parseDouble(args);
            double lnTotal = lnDiscount * 100;
            return lnTotal + "%";
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}
