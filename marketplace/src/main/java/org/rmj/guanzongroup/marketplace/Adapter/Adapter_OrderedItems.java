package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_OrderedItems extends RecyclerView.Adapter<Adapter_OrderedItems.OrderItemsViewHolder>{

    private final List<DOrderDetail.OrderedItemsInfo> poList;

    public Adapter_OrderedItems(List<DOrderDetail.OrderedItemsInfo> poList) {
        this.poList = poList;
    }

    @NonNull
    @Override
    public OrderItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View loView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ordered_items, parent, false);
        return new OrderItemsViewHolder(loView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemsViewHolder holder, int position) {
        DOrderDetail.OrderedItemsInfo loMaster = poList.get(position);
        holder.lblBrandNm.setText(loMaster.xModelNme);
        holder.lblItmPrce.setText(CashFormatter.parse(loMaster.nUnitPrce));
        holder.lblItmQtyx.setText(loMaster.nQuantity);
    }

    @Override
    public int getItemCount() {
        return poList.size();
    }

    public static class OrderItemsViewHolder extends RecyclerView.ViewHolder {

        public TextView lblBrandNm,
                lblItmDisc,
                lblItmPrce,
                lblItmQtyx;

        public OrderItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblBrandNm = itemView.findViewById(R.id.lbl_brandName);
            lblItmDisc = itemView.findViewById(R.id.lbl_itemDiscount);
            lblItmPrce = itemView.findViewById(R.id.lbl_itemPrice);
            lblItmQtyx = itemView.findViewById(R.id.lbl_itemQuantity);
        }
    }
}
