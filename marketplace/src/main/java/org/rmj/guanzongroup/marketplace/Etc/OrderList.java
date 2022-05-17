package org.rmj.guanzongroup.marketplace.Etc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.guanzongroup.marketplace.Model.OrderInfoModel;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<OrderInfoModel> orders = new ArrayList<>();
    private final boolean fromCart;

    public OrderList(boolean fromCart) {
        this.fromCart = fromCart;
    }

    public void putOrder(OrderInfoModel order) {
        orders.add(order);
    }

    public String getParsedString() {
        JSONObject loJson = new JSONObject();
        JSONArray loArray = new JSONArray();

        try {
            for (int x = 0; x < orders.size(); x++) {
                loArray.put(orders.get(x).getJsonObj());
            }
            loJson.put("fromCart", fromCart);
            loJson.put("orders", loArray);
        } catch(JSONException e) {
            e.printStackTrace();
        }

        return loJson.toString();
    }

}
