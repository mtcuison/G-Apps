package org.rmj.guanzongroup.marketplace.Etc;

import org.json.JSONArray;
import org.rmj.guanzongroup.marketplace.Model.OrderInfoModel;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<OrderInfoModel> orders = new ArrayList<>();

    public void putOrder(OrderInfoModel order) {
        orders.add(order);
    }

    public String getParsedString() {
        JSONArray loArray = new JSONArray();
        for(int x = 0; x < orders.size(); x++) {
            loArray.put(orders.get(x).getJsonObj());
        }
        return loArray.toString();
    }

}
