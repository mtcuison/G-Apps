package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_OrderHistory extends RecyclerView.Adapter<Adapter_OrderHistory.ViewHolderItem> {

    private final List<DOrderMaster.OrderHistory> poMaster;
    private final OnOrderHistoryClickListener mListener;

    public interface OnOrderHistoryClickListener{
        void OnClick(String args);
    }

    public Adapter_OrderHistory(List<DOrderMaster.OrderHistory> poMaster, OnOrderHistoryClickListener listener) {
        this.poMaster = poMaster;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View loView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_order_history, parent, false);
        return new ViewHolderItem(loView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItem holder, int position) {
        DOrderMaster.OrderHistory loMaster = poMaster.get(position);
        holder.lblOrderNo.setText(loMaster.sTransNox);
        holder.lblOrderSt.setText(GetOrderStatus(loMaster.cTranStat));
        holder.lblOrderTl.setText(CashFormatter.parse(loMaster.nTranTotl));
        holder.lblBrandNm.setText(loMaster.xBrandNme);
        holder.lblItemDsc.setText(loMaster.sBriefDsc);
        holder.lblItmDisc.setText(GetDiscount(loMaster.nDiscount));
        holder.lblItmPrce.setText(CashFormatter.parse(loMaster.nUnitPrce));
        holder.lblItmQtyx.setText(loMaster.nQuantity);
        holder.itemView.setOnClickListener(v -> mListener.OnClick(loMaster.sTransNox));
    }

    @Override
    public int getItemCount() {
        return poMaster.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView lblOrderNo,
                lblOrderSt,
                lblOrderTl,
                lblBrandNm,
                lblItemDsc,
                lblItmDisc,
                lblItmPrce,
                lblItmQtyx;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            lblOrderNo = itemView.findViewById(R.id.lbl_orderNo);
            lblOrderSt = itemView.findViewById(R.id.lbl_orderStatus);
            lblOrderTl = itemView.findViewById(R.id.lbl_orderTotal);
            lblBrandNm = itemView.findViewById(R.id.lbl_brandName);
            lblItemDsc = itemView.findViewById(R.id.lbl_itemDescription);
            lblItmDisc = itemView.findViewById(R.id.lbl_itemDiscount);
            lblItmPrce = itemView.findViewById(R.id.lbl_itemPrice);
            lblItmQtyx = itemView.findViewById(R.id.lbl_itemQuantity);
        }
    }

    private String GetOrderStatus(String fsVal){
        switch (fsVal){
            case "0":
                return "Processing";
            case "1":
                return "Verified";
            case "2":
                return "To Ship";
            case "3":
                return "Cancelled";
            default:
                return "Delivered";
        }
    }

    private String GetDiscount(String fsVal){
        if(fsVal.equalsIgnoreCase("0.00"))
            return "";
        else
            return fsVal;
    }
}
