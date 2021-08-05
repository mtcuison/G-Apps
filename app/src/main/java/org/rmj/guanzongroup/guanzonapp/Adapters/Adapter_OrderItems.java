package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_OrderItems extends RecyclerView.Adapter<Adapter_OrderItems.OrderItemViewHolder> {

    private List<DRedeemablesInfo.OrderItems> orderItemsList;

    Adapter_OrderItems(List<DRedeemablesInfo.OrderItems> orderItemsList){
        this.orderItemsList = orderItemsList;
    }

    @NonNull
    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaction_order_item, parent, false);
        return new OrderItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemViewHolder holder, int position) {
        DRedeemablesInfo.OrderItems orderItems = orderItemsList.get(position);
        holder.lblItemName.setText(orderItems.itemName);
        holder.lblItemQuantity.setText(orderItems.itemQtyx);
        holder.lblItemPoints.setText(orderItems.itemPnts);
    }

    @Override
    public int getItemCount() {
        return orderItemsList.size();
    }

    static class OrderItemViewHolder extends RecyclerView.ViewHolder{

        TextView lblItemName;
        TextView lblItemQuantity;
        TextView lblItemPoints;

        OrderItemViewHolder(@NonNull View itemView) {
            super(itemView);

            lblItemName = itemView.findViewById(R.id.lbl_list_item_ItemName);
            lblItemQuantity = itemView.findViewById(R.id.lbl_list_order_item_Quantity);
            lblItemPoints = itemView.findViewById(R.id.lbl_list_order_item_Points);
        }
    }
}
