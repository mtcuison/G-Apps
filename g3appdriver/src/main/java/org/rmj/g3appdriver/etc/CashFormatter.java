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

}
