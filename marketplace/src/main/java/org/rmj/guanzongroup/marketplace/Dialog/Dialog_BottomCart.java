package org.rmj.guanzongroup.marketplace.Dialog;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.marketplace.R;


public class Dialog_BottomCart extends BottomSheetDialogFragment {


    private String itemSubTotal;
    private String itemOtherFee;
    private double itemShippingFee;
    private double itemGrandTotal;

    private View view;
    private MaterialButton btnCancel,btnConfirm;

//    private CustomToast toast;

    private int Quantity = 1;

    public void setItemSubTotal(String itemSubTotal) {
        this.itemSubTotal = itemSubTotal;
    }

    public void setItemOtherFee(String itemOtherFee) {
        this.itemOtherFee = itemOtherFee;
    }

    public void setItemShippingFee(double itemShippingFee) {
        this.itemShippingFee = itemShippingFee;
    }

    public void setItemGrandTotal(double itemGrandTotal) {
        this.itemGrandTotal = itemGrandTotal;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_bottom_cart, container, false);
        setupWidgets();

//        toast = new CustomToast(getActivity());
        return view;
    }

    private void setupWidgets(){
        ImageButton btnClose = view.findViewById(R.id.btn_bottom_sheet_close);
        TextView lblSubtotal = view.findViewById(R.id.lbl_dialog_bottom_sub_total);
        TextView lblShippingFee= view.findViewById(R.id.lbl_dialog_bottom_shipping_fee);
        TextView lblOtherFee= view.findViewById(R.id.lbl_dialog_bottom_other_fee);
        TextView lblGrandTotal= view.findViewById(R.id.lbl_dialog_bottom_total);
        btnCancel = view.findViewById(R.id.btn_bottom_sheet_cancel);
        btnConfirm = view.findViewById(R.id.btn_bottom_sheet_confirm);

        lblSubtotal.setText(itemSubTotal);
        lblShippingFee.setText(String.valueOf(itemShippingFee));
        lblOtherFee.setText(String.valueOf(itemShippingFee));
        lblGrandTotal.setText(String.valueOf(itemGrandTotal));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

//
    }
    public void showDialog(){
        showDialog();
    }
//
//    private double getTotPoints(){
//        return Integer.parseInt(txtQuantity.getText().toString()) * itemPntsx;
//    }
//
//    private int getQuantity(){
//        if(Quantity>5){
//            Quantity = 5;
//            return 5;
//        } else if(Quantity == 0){
//            Quantity = 1;
//            return 1;
//        }
//        return Quantity;
//    }
}
