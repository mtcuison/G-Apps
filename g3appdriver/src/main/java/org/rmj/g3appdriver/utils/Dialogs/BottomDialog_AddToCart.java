package org.rmj.g3appdriver.utils.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.R;

public class BottomDialog_AddToCart extends BottomSheetDialogFragment {

    private final String psListIdx;
    private final String psItemNme;
    private final String psItemPrc;


    public BottomDialog_AddToCart(String fsListIdx, String fsItemNme, String fsItemPrc) {
        this.psListIdx = fsListIdx;
        this.psItemNme = fsItemNme;
        this.psItemPrc = fsItemPrc;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottomsheet_add_to_cart,
                container, false);


        TextView txtItemNm = v.findViewById(R.id.txt_product_name);
        TextView txtPricex = v.findViewById(R.id.txt_product_price);
        ImageButton btnAddQty = v.findViewById(R.id.btn_add);
        ImageButton btnMinusQ = v.findViewById(R.id.btn_minus);
        TextInputEditText txtItmQty = v.findViewById(R.id.tie_quantity);
        MaterialButton btnAddCrt = v.findViewById(R.id.btnAddToCart);

        txtItmQty.setEnabled(false);
        txtItemNm.setText(psItemNme);
        txtPricex.setText(psItemPrc);

        btnAddQty.setOnClickListener(ve -> {
            txtItmQty.setText(String.valueOf(Integer.parseInt(txtItmQty.getText().toString()) + 1));
        });

        btnMinusQ.setOnClickListener(ve -> {
            txtItmQty.setText(String.valueOf(Integer.parseInt(txtItmQty.getText().toString()) - 1));
        });

        btnAddCrt.setOnClickListener(ve -> dismiss());

        return v;
    }
}