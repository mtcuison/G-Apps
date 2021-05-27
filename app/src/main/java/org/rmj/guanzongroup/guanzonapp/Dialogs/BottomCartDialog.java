package org.rmj.guanzongroup.guanzonapp.Dialogs;

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

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_Redeemables;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.CartManager;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.PointsManager;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

public class BottomCartDialog extends BottomSheetDialogFragment {

    private String itemIDxxx;
    private String itemNamex;
    private double itemPntsx;

    private View view;
    private TextView lblItemTotPoints;
    private EditText txtQuantity;
    private MaterialButton btnAddToCart;

    private CustomToast toast;

    private int Quantity = 1;

    public void setItemIDxxx(String itemIDxxx) { this.itemIDxxx = itemIDxxx; }

    public void setItemNamex(String itemNamex) { this.itemNamex = itemNamex; }

    public void setItemPntsx(double itemPntsx) { this.itemPntsx = itemPntsx; }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_dialog_addtocart_box, container, false);
        setupWidgets();
        toast = new CustomToast(getActivity());
        return view;
    }

    private void setupWidgets(){
        ImageButton btnClose = view.findViewById(R.id.btn_bottom_sheet_close);
        TextView lblItemName = view.findViewById(R.id.lbl_bottom_sheet_ItemName);
        TextView lblItemPoints = view.findViewById(R.id.lbl_bottom_sheet_itemPrice);
        txtQuantity = view.findViewById(R.id.txt_bottom_sheet_itemQuantity);
        lblItemTotPoints = view.findViewById(R.id.lbl_bottom_sheet_itemTotal_price);
        TextView lblGcardPoints = view.findViewById(R.id.lbl_bottom_sheet_available_points);
        ImageButton btnAdd = view.findViewById(R.id.btn_bottom_sheet_add);
        ImageButton btnDeduct = view.findViewById(R.id.btn_bottom_sheet_deduct);
        btnAddToCart = view.findViewById(R.id.btn_bottom_sheet_addToCart);

        lblItemName.setText(itemNamex);
        lblItemPoints.setText(String.valueOf(itemPntsx));
        lblItemTotPoints.setText(String.valueOf(getTotPoints()));
        lblGcardPoints.setText(String.valueOf(new PointsManager(getActivity()).getRemainingGCardPoints()));

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

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new CartManager(getActivity()).add(itemIDxxx, Quantity, Double.parseDouble(lblItemTotPoints.getText().toString()),
                new CartManager.onAddToCartListener() {
                    @Override
                    public void onAddToCartSuccess() {
                        dismiss();
                        toast.setType(CustomToast.CustomToastType.ADDED_TO_CART);
                        toast.setMessage("Item added on cart.");
                        toast.show();
                        new Activity_Redeemables().getInstance().setBadgeView();
                        new Activity_DashBoard().getInstance().invalidateOptionsMenu();
                        new Fragment_DashBoard().getInstance().refreshUI();
                    }

                    @Override
                    public void onAddToCartFailed(String errorMessage) {
                        toast.setType(CustomToast.CustomToastType.WARNING);
                        toast.setMessage(errorMessage);
                        toast.show();
                        dismiss();
                    }
                });
            }
        });
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
