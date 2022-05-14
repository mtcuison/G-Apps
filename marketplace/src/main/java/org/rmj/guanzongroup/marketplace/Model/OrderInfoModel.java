package org.rmj.guanzongroup.marketplace.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderInfoModel {

    private final String psListIdx;
    private final int pnItemQty;

    public OrderInfoModel(String fsListIdx, int fnItemQty) {
        this.psListIdx = fsListIdx;
        this.pnItemQty = fnItemQty;
    }

    public JSONObject getJsonObj() {
        JSONObject loJson = new JSONObject();
        try {
            loJson.put("sListingId", psListIdx);
            loJson.put("nQuantityx", pnItemQty);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loJson;
    }

}
