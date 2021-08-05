package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMAddToCart;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Nonnull;

public class BottomCartDialog extends BottomSheetDialogFragment {
    private static final String TAG = BottomCartDialog.class.getSimpleName();
    private VMAddToCart mViewModel;
    private final String psGcardNo, psGcardPt, psItemIdx, psItemNme;
    private final double pnItemPts;
    private CustomToast toast;
    private TextView lblItemTotPoints;
    private EditText txtQuantity;
    private MaterialButton btnAddToCart;
    private int pnItemCnt = 1;

    @Nonnull
    public BottomCartDialog(String fsGcardNo, String fsGcardPt, String fsItemId, String fsItemNme, double fnItemPts) {
        Log.e(TAG, "Initialized.");
        this.psGcardNo = fsGcardNo;
        this.psGcardPt = fsGcardPt;
        this.psItemIdx = fsItemId;
        this.psItemNme = fsItemNme;
        this.pnItemPts = fnItemPts;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog_addtocart_box, container, false);
        setupWidgets(view);
        toast = new CustomToast(getActivity());
        return view;
    }

    private void setupWidgets(View view){
        mViewModel = ViewModelProviders.of(getActivity()).get(VMAddToCart.class);
        ImageButton btnClose = view.findViewById(R.id.btn_bottom_sheet_close);
        TextView lblItemName = view.findViewById(R.id.lbl_bottom_sheet_ItemName);
        TextView lblItemPoints = view.findViewById(R.id.lbl_bottom_sheet_itemPrice);
        txtQuantity = view.findViewById(R.id.txt_bottom_sheet_itemQuantity);
        lblItemTotPoints = view.findViewById(R.id.lbl_bottom_sheet_itemTotal_price);
        TextView lblGcardPoints = view.findViewById(R.id.lbl_bottom_sheet_available_points);
        ImageButton btnAdd = view.findViewById(R.id.btn_bottom_sheet_add);
        ImageButton btnDeduct = view.findViewById(R.id.btn_bottom_sheet_deduct);
        btnAddToCart = view.findViewById(R.id.btn_bottom_sheet_addToCart);

        lblItemName.setText(psItemNme);
        lblItemPoints.setText(String.valueOf(pnItemPts));
        lblItemTotPoints.setText(String.valueOf(getTotalPoints()));
        lblGcardPoints.setText(psGcardPt);

        btnClose.setOnClickListener(v -> dismiss());

        btnAdd.setOnClickListener(v -> {
            pnItemCnt += 1;
            txtQuantity.setText(String.valueOf(getQuantity()));
            lblItemTotPoints.setText(String.valueOf(getTotalPoints()));
        });

        btnDeduct.setOnClickListener(v -> {
            pnItemCnt -= 1;
            txtQuantity.setText(String.valueOf(getQuantity()));
            lblItemTotPoints.setText(String.valueOf(getTotalPoints()));
        });

        btnAddToCart.setOnClickListener(v -> {
            try {
                ERedeemItemInfo loItem = new ERedeemItemInfo();
                EGcardApp loGcard = new EGcardApp();
                loItem.setTransNox(new CodeGenerator().generateTransNox());
                loItem.setGCardNox(psGcardNo);
                loItem.setPromoIDx(psItemIdx);
                loItem.setItemQtyx(pnItemCnt);
                loItem.setPointsxx(getTotalPoints());
                loItem.setOrderedx(getCurrentDate());
                loItem.setTranStat("0");
                loItem.setPlcOrder("0");
                loGcard.setAvlPoint(String.valueOf(Double.parseDouble(psGcardPt) - getTotalPoints()));
                mViewModel.insert(loItem);
                mViewModel.updateGcardPoints(loGcard);

                dismiss();
                toast.setType(CustomToast.CustomToastType.ADDED_TO_CART);
                toast.setMessage("Item added on cart.");
                toast.show();
            } catch (Exception e) {
                e.printStackTrace();
                dismiss();
                toast.setType(CustomToast.CustomToastType.WARNING);
                toast.setMessage(e.getMessage());
                toast.show();
            }
        });

    }

    private double getTotalPoints(){
        return getQuantity() * pnItemPts;
    }

    private int getQuantity(){
        if(pnItemCnt>5){
            pnItemCnt = 5;
            return 5;
        } else if(pnItemCnt == 0){
            pnItemCnt = 1;
            return 1;
        }
        return pnItemCnt;
    }

    private String getCurrentDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        return date.format(Calendar.getInstance().getTime());
    }

    private boolean isGPointSufficient() {
        if(!psGcardPt.equalsIgnoreCase("") && psGcardPt != null) {
            double lnGcardPt = Double.parseDouble(psGcardPt);
            if(lnGcardPt >= getTotalPoints()) {
                return true;
            }
            return false;
        }
        return false;
    }

}
