package org.rmj.guanzongroup.digitalgcard.Dialogs;

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
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMRedeemables;

public class BottomCartDialog extends BottomSheetDialogFragment {

//    private VMRedeemables mViewModel;
    private VMGCardSystem mViewModel;
    private String itemIDxxx;
    private String itemNamex;
    private double itemPntsx;

    private View view;
    private TextView lblItemTotPoints;
    private TextView lblItemName, lblGcardPoints,lblItemPoints;
    private ImageButton btnClose, btnAdd, btnDeduct;
    private EditText txtQuantity;
    private MaterialButton btnAddToCart;


    private int Quantity = 1;

    public void setItemIDxxx(String itemIDxxx) { this.itemIDxxx = itemIDxxx; }

    public void setItemNamex(String itemNamex) { this.itemNamex = itemNamex; }

    public void setItemPntsx(double itemPntsx) { this.itemPntsx = itemPntsx; }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_dialog_addtocart_box, container, false);
        setupWidgets(view);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.REDEMPTION);
        mViewModel.getActiveGcard().observe(requireActivity(), gcard ->{
            lblGcardPoints.setText(String.valueOf(gcard.getAvlPoint()));
        });
//        mViewModel.getRemainingActiveCardPoints().observe(requireActivity(),val ->{
//            lblGcardPoints.setText(String.valueOf(val));
//        });
        lblItemName.setText(itemNamex);
        lblItemPoints.setText(String.valueOf(itemPntsx));
        lblItemTotPoints.setText(String.valueOf(getTotPoints()));
//        lblGcardPoints.setText(String.valueOf(new PointsManager(getActivity()).getRemainingGCardPoints()));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Quantity += 1;
                        txtQuantity.setText(String.valueOf(getQuantity()));
                        lblItemTotPoints.setText(String.valueOf(getTotPoints()));
                    }
                });
            }
        });

        btnDeduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Quantity -= 1;
                        txtQuantity.setText(String.valueOf(getQuantity()));
                        lblItemTotPoints.setText(String.valueOf(getTotPoints()));
                    }
                });
            }
        });

//        btnAddToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            new CartManager(getActivity()).add(itemIDxxx, Quantity, Double.parseDouble(lblItemTotPoints.getText().toString()),
//                new CartManager.onAddToCartListener() {
//                    @Override
//                    public void onAddToCartSuccess() {
//                        dismiss();
//                        toast.setType(CustomToast.CustomToastType.ADDED_TO_CART);
//                        toast.setMessage("Item added on cart.");
//                        toast.show();
//                        new Activity_Redeemables().getInstance().setBadgeView();
//                        new Activity_DashBoard().getInstance().invalidateOptionsMenu();
//                        new Fragment_DashBoard().getInstance().refreshUI();
//                    }
//
//                    @Override
//                    public void onAddToCartFailed(String errorMessage) {
//                        toast.setType(CustomToast.CustomToastType.WARNING);
//                        toast.setMessage(errorMessage);
//                        toast.show();
//                        dismiss();
//                    }
//                });
//            }
//        });
    }

    private void setupWidgets(View v){
        btnClose = v.findViewById(R.id.btn_bottom_sheet_close);
        lblItemName = v.findViewById(R.id.lbl_bottom_sheet_ItemName);
        lblItemPoints = v.findViewById(R.id.lbl_bottom_sheet_itemPrice);
        txtQuantity = v.findViewById(R.id.txt_bottom_sheet_itemQuantity);
        lblItemTotPoints = v.findViewById(R.id.lbl_bottom_sheet_itemTotal_price);
        lblGcardPoints = v.findViewById(R.id.lbl_bottom_sheet_available_points);
        btnAdd = v.findViewById(R.id.btn_bottom_sheet_add);
        btnDeduct = v.findViewById(R.id.btn_bottom_sheet_deduct);
        btnAddToCart = v.findViewById(R.id.btn_bottom_sheet_addToCart);

    }

    private double getTotPoints(){
        return Integer.parseInt(txtQuantity.getText().toString()) * itemPntsx;
    }

    private int getQuantity(){
        if(Quantity>5){
            Quantity = 5;
            return 5;
        } else if(Quantity == 0){
            Quantity = 1;
            return 1;
        }
        return Quantity;
    }
}
