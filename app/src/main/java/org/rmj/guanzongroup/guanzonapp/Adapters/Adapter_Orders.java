package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Orders;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.OrderItems;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.TransactionOrder;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GCardOrders;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.CancelOrder;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.List;

public class Adapter_Orders extends RecyclerView.Adapter<Adapter_Orders.OrderViewHolder> {

    private Context mContext;
    private List<TransactionOrder> transactionOrderList;
    private List<OrderItems> orderItemsList;
    private CustomToast customToast;
    private OnOrderQrCodeClickListener onOrderQrCodeClickListener;

    public Adapter_Orders(Context context, List<TransactionOrder> transactionOrderList){
        this.mContext = context;
        this.transactionOrderList = transactionOrderList;
    }

    public void setOnOrderQrCodeClickListener(OnOrderQrCodeClickListener listener){
        this.onOrderQrCodeClickListener = listener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_orders, parent, false);
        return new OrderViewHolder(view, onOrderQrCodeClickListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        orderItemsList = new GCardOrders(mContext).getOrderItems(transactionOrderList.get(position).getTransno());
        holder.transactionOrder = transactionOrderList.get(position);
        holder.orderItems = orderItemsList.get(position);
        holder.lblTransNo.setText(transactionOrderList.get(position).getTransno());
        holder.lblOrderDate.setText(transactionOrderList.get(position).getdOrderx());
        holder.lblPickupBranch.setText(transactionOrderList.get(position).getBranchx());
        holder.lblBranchAdd.setText(transactionOrderList.get(position).getAddress());
        holder.lblTotPoints.setText(transactionOrderList.get(position).getTotAmnt());
        holder.btnCancel.setIcon(mContext.getDrawable(R.drawable.ic_toast_icon_warning));
        holder.recyclerView.setAdapter(new Adapter_OrderItems(orderItemsList));
        holder.recyclerView.setLayoutManager(getLayoutManager());

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCancellationDialog(transactionOrderList.get(position).getTransno());
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionOrderList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder{

        TransactionOrder transactionOrder;
        OrderItems orderItems;
        RecyclerView recyclerView;
        TextView lblTransNo;
        TextView lblOrderDate;
        TextView lblPickupBranch;
        TextView lblBranchAdd;
        TextView lblTotPoints;
        MaterialButton btnCancel;

        OrderViewHolder(@NonNull View itemView, final OnOrderQrCodeClickListener listener) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_view_list_transaction_order);
            lblTransNo = itemView.findViewById(R.id.lbl_list_transaction_order_transno);
            lblOrderDate = itemView.findViewById(R.id.lbl_list_transaction_order_date);
            lblPickupBranch = itemView.findViewById(R.id.lbl_list_transaction_pickup_branch);
            lblBranchAdd = itemView.findViewById(R.id.lbl_list_transaction_branch_address);
            lblTotPoints = itemView.findViewById(R.id.lbl_list_transaction_order_totPoints);
            btnCancel = itemView.findViewById(R.id.btn_lis_transaction_cancel_order);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!= null){
                        if(getAdapterPosition() != RecyclerView.NO_POSITION){
                            listener.OnClick(transactionOrder.getTransno());
                        }
                    }
                }
            });
        }
    }

    private LinearLayoutManager getLayoutManager(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        return layoutManager;
    }

    private void setCancellationDialog(final String ReferNox){
        MessageBox messageBox = new MessageBox(mContext);
        messageBox.setPositiveButton("No", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
            }
        });

        messageBox.setNegativeButton("Yes", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
                orderCancellationMethod(ReferNox);
            }
        });

        messageBox.setMessageType(MessageBox.MessageType.WARNING);
        messageBox.setDialogMessage("Note: You only have 24 hours to cancel an order. Are you sure you want to cancel this order?");
        messageBox.showDialog();
    }

    private void orderCancellationMethod(String ReferNox){
        customToast = new CustomToast(mContext);
        new CancelOrder().sendCancelOrderRequest(mContext, ReferNox, new CancelOrder.onCancelOrderRequestListener() {
            @Override
            public void onCancellationSuccessResult() {
                customToast.setType(CustomToast.CustomToastType.INFORMATION);
                customToast.setMessage("Order cancelled");
                customToast.show();
                new Activity_Orders().getInstance().refreshList();
            }

            @Override
            public void onCancellationFailedResult(String errorMessage) {
                customToast.setType(CustomToast.CustomToastType.WARNING);
                customToast.setMessage(errorMessage);
                customToast.show();
            }
        });
    }

    public interface OnOrderQrCodeClickListener{
        void OnClick(String BatchNox);
    }
}
