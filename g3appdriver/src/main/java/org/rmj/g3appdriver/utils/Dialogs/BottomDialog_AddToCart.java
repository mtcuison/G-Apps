package org.rmj.g3appdriver.utils.Dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.R;

public class BottomDialog_AddToCart extends BottomSheetDialogFragment {

    private final String psItemNme, psItemPrc, psAvlQty;
    private OnAddToCart poCallBck;

    public BottomDialog_AddToCart(String fsItemNme, String fsAvlQty,String fsItemPrc) {
        this.psItemNme = fsItemNme;
        this.psItemPrc = fsItemPrc;
        this.psAvlQty = fsAvlQty;
    }

    public void setDialogCallback(OnAddToCart foCallBck){
        poCallBck = foCallBck;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.bottomsheet_add_to_cart, container, false);

        TextView txtItemNm = v.findViewById(R.id.txt_product_name);
        TextView txtAvlQTy = v.findViewById(R.id.txt_avlQty);
        TextView txtPricex = v.findViewById(R.id.txt_product_price);
        ImageButton btnAddQty = v.findViewById(R.id.btn_add);
        ImageButton btnMinusQ = v.findViewById(R.id.btn_minus);
        TextInputEditText txtItmQty = v.findViewById(R.id.tie_quantity);
        MaterialButton btnAddCrt = v.findViewById(R.id.btnAddToCart);

        txtItmQty.setEnabled(false);
        txtItemNm.setText(psItemNme);
        txtAvlQTy.setText("Available Quantity: " + psAvlQty);
        txtPricex.setText(psItemPrc);

        btnAddQty.setOnClickListener(ve -> {
            txtItmQty.setText(String.valueOf(Integer.parseInt(txtItmQty.getText().toString()) + 1));
        });

        btnMinusQ.setOnClickListener(ve -> {
            if(Integer.parseInt(txtItmQty.getText().toString()) > 1) {
                txtItmQty.setText(String.valueOf(Integer.parseInt(txtItmQty.getText().toString()) - 1));
            }
        });

        btnAddCrt.setOnClickListener(ve -> {
            dismiss();
            poCallBck.onClick(Integer.parseInt(txtItmQty.getText().toString()));
        });

        return v;
    }

    public interface OnAddToCart {
        void onClick(int fnItemQty);
        void onDismiss();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        poCallBck.onDismiss();
    }
}