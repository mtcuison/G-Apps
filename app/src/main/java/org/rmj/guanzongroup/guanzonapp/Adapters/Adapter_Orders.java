package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.app.AlertDialog;
import android.app.Application;
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

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
import org.rmj.g3appdriver.etc.GAppMessageBox;
import org.rmj.g3appdriver.etc.GToast;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Orders;
import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_Orders extends RecyclerView.Adapter<Adapter_Orders.OrderViewHolder> {

    private Context mContext;
    private List<DRedeemablesInfo.TransactionOrder> transactionOrderList;
    private List<DRedeemablesInfo.OrderItems> orderItemsList;
    private GAppMessageBox loMessage;
    private RRedeemablesInfo poRedeem;
    private OnOrderQrCodeClickListener onOrderQrCodeClickListener;

    private final RGcardApp gcard;
    public Adapter_Orders(Context context, List<DRedeemablesInfo.TransactionOrder> transactionOrderList){
        this.mContext = context;
        this.transactionOrderList = transactionOrderList;
        this.loMessage = new GAppMessageBox(context);
        this.poRedeem = new RRedeemablesInfo((Application) context.getApplicationContext());
        this.gcard = new RGcardApp((Application) context.getApplicationContext());
    }

    public void setOnOrderQrCodeClickListener(OnOrderQrCodeClickListener listener){
        this.onOrderQrCodeClickListener = listener;
    }
    public interface onCancelOrderRequestListener{
        void onCancellationSuccessResult();
        void onCancellationFailedResult(String errorMessage);
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
//        orderItemsList = new GCardOrders(mContext).getOrderItems(transactionOrderList.get(position).getTransno());
        orderItemsList = poRedeem.getOrderItems(transactionOrderList.get(position).TransNox, gcard.getCardNox()).getValue();
        holder.transactionOrder = transactionOrderList.get(position);
        holder.orderItems = orderItemsList.get(position);
        holder.lblTransNo.setText(transactionOrderList.get(position).TransNox);
        holder.lblOrderDate.setText(transactionOrderList.get(position).dOrderx);
        holder.lblPickupBranch.setText(transactionOrderList.get(position).Branchx);
        holder.lblBranchAdd.setText(transactionOrderList.get(position).Address);
        holder.lblTotPoints.setText(transactionOrderList.get(position).TotAmnt);
        holder.btnCancel.setIcon(mContext.getDrawable(R.drawable.ic_toast_icon_warning));
        holder.recyclerView.setAdapter(new Adapter_OrderItems(orderItemsList));
        holder.recyclerView.setLayoutManager(getLayoutManager());

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCancellationDialog(transactionOrderList.get(position).TransNox);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionOrderList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder{

        DRedeemablesInfo.TransactionOrder transactionOrder;
        DRedeemablesInfo.OrderItems orderItems;
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
                            listener.OnClick(transactionOrder.TransNox);
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
//        new CancelOrder().sendCancelOrderRequest(mContext, ReferNox, onCancelOrderRequestListener() {
//            @Override
//            public void onCancellationSuccessResult() {
//                GToast.CreateMessage(mContext, "Order cancelled!", GToast.INFORMATION).show();
//                new Activity_Orders().getInstance().refreshList();
//            }
//
//            @Override
//            public void onCancellationFailedResult(String errorMessage) {
//                loMessage.initDialog();
//                loMessage.setPositiveButton("Ok", (view, dialog) -> {
//                    dialog.dismiss();
//                });
//                loMessage.setTitle("GuanzonApp");
//                loMessage.setMessage(errorMessage);
//                loMessage.show();
//            }
//        });
    }

    public interface OnOrderQrCodeClickListener{
        void OnClick(String BatchNox);
    }
}
