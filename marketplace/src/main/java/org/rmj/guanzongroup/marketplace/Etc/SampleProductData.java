package org.rmj.guanzongroup.marketplace.Etc;

import org.json.JSONException;
import org.json.JSONObject;

public class SampleProductData {
    static String lsJson = "{\"result\":\"success\",\"detail\":[{\"sListngID\":\"C00122000001\",\"sBriefDsc\":\"Openline W\\/ Warranty\",\"sDescript\":\"[{\\\"sDescript\\\":\\\"F11 adopts a 48MP+5MP dual rear camera.\\\",\\\"bEmphasis\\\":false},{\\\"sDescript\\\":\\\"Screen ratio of 90.70% is calculated by the projected area of screen display versus the projected area of touch plane.\\\",\\\"bEmphasis\\\":false},{\\\"sDescript\\\":\\\"F11 utilizes a typical battery value of 4020mAh.\\\",\\\"bEmphasis\\\":false}]\",\"xBarCodex\":\"OPPOCPH1911PURPLE\",\"xDescript\":\"Openline W\\/ Warranty\",\"xBrandNme\":\"Oppo\",\"xModelNme\":\"Oppo F11 (6+64GB)\",\"xColorNme\":\"Fluorite Purple\",\"xCategrNm\":\"Mobile Phone\",\"nTotalQty\":\"0\",\"nQtyOnHnd\":\"0\",\"nResvOrdr\":\"0\",\"nSoldQtyx\":\"0\",\"nUnitPrce\":\"12990.00\",\"dListStrt\":null,\"dListEndx\":null,\"cTranStat\":\"0\"},{\"sListngID\":\"C00122000002\",\"sBriefDsc\":\"Galaxy S8(G950X) BLACK - LDU\",\"sDescript\":\"[{\\\"sDescript\\\":\\\"GSM \\\\\\/ 4G LTE Capable\\\",\\\"bEmphasis\\\":false},{\\\"sDescript\\\":\\\"f\\\\\\/1.7 12MP Rear + 8MP Front Camera.\\\",\\\"bEmphasis\\\":false},{\\\"sDescript\\\":\\\"64GB Storage Capacity and 4GB of RAM.\\\",\\\"bEmphasis\\\":false},{\\\"sDescript\\\":\\\"5.8\\\\\\\" AMOLED Infinity Display.\\\",\\\"bEmphasis\\\":false}]\",\"xBarCodex\":\"SM-G950XBLACK\",\"xDescript\":\"Galaxy S8(G950X) BLACK - LDU\",\"xBrandNme\":\"Samsung\",\"xModelNme\":\"Galaxy S8\",\"xColorNme\":\"Black\",\"xCategrNm\":\"Mobile Phone\",\"nTotalQty\":\"0\",\"nQtyOnHnd\":\"0\",\"nResvOrdr\":\"0\",\"nSoldQtyx\":\"0\",\"nUnitPrce\":\"37990.00\",\"dListStrt\":null,\"dListEndx\":null,\"cTranStat\":\"0\"}]}";

    public static JSONObject getJson() {
        try {
            JSONObject poJson = new JSONObject(lsJson);
            return poJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
