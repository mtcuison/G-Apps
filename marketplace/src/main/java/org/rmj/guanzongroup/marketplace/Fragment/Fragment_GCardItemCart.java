package org.rmj.guanzongroup.marketplace.Fragment;

import static org.rmj.guanzongroup.marketplace.Fragment.Fragment_MPItemCart.currencyFormat;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_Redeemables;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ItemCart;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Dialog.Dialog_BranchSelection;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMGCardItemCart;
import org.rmj.guanzongroup.marketplace.ViewModel.VMMPItemCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Fragment_GCardItemCart extends Fragment {
    String TAG = Fragment_GCardItemCart.class.getSimpleName();
    private VMGCardSystem mViewModel;
//    private VMGCardItemCart mVModel;
    private RecyclerView recyclerView;
    private LinearLayout noItem, lnGCardFooter;
    private MaterialButton btnCheckOut,btnShopNow;
    private TextView lblGrandTotal;
    private Adapter_ItemCart adapter;
    private List<ItemCartModel> itemList;
    private List<DRedeemItemInfo.GCardCartItem> gcardItem;
    public static Fragment_GCardItemCart newInstance() {
        return new Fragment_GCardItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gcard_item_cart, container, false);
        mViewModel = new ViewModelProvider(this).get(VMGCardSystem.class);
        initWidgets(v);
        mViewModel.GetCartItems().observe(requireActivity(), itemCart ->{
            try {
                if (itemCart.size() > 0){
                    gcardItem = new ArrayList<>();
                    gcardItem = itemCart;
                    noItem.setVisibility(View.GONE);
                    lnGCardFooter.setVisibility(View.VISIBLE);
                    adapter = new Adapter_ItemCart(itemCart, new Adapter_ItemCart.OnCartAction() {
                        @Override
                        public void onClickAction(String val) {

                        }
                    });
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                    adapter.notifyDataSetChanged();
                    double subtotal = 0;
                    for (int x = 0; x < itemCart.size(); x++){
                        subtotal += Double.parseDouble(itemCart.get(x).nPointsxx.replaceAll(",","")) * Double.parseDouble(itemCart.get(x).nItemQtyx);
                    }
                    lblGrandTotal.setText(currencyFormat(subtotal)  + " point/s");
                }else {
                    noItem.setVisibility(View.VISIBLE);
                    lnGCardFooter.setVisibility(View.GONE);
                }
            }catch (NullPointerException e){
                Log.e(TAG,"NullPointerException " + e.getMessage());
            }catch (Exception e){
                Log.e(TAG,"Exception " + e.getMessage());
            }
        });

        btnShopNow.setOnClickListener(view ->{
            Intent intent = new Intent(requireActivity(), Activity_ItemCart.class);
            intent.putExtra("args","2");
            startActivity(intent);
        });
        btnCheckOut.setOnClickListener(view->{
            mViewModel.GetMCBranchesForRedemption(new VMGCardSystem.GetBranchCallback() {
                @Override
                public void onSuccess(List<EBranchInfo> branchInfos) {
                    Log.e(TAG, String.valueOf(branchInfos.size()));
                    Dialog_BranchSelection branchSelection = new Dialog_BranchSelection(requireActivity());
                    branchSelection.createDialog(branchInfos, new Dialog_BranchSelection.onConfirmBranch() {
                        @Override
                        public void onConfirm(EBranchInfo branchInfo) {
                            mViewModel.PlaceOrder(gcardItem.get(0), new VMGCardSystem.GcardTransactionCallback() {
                                @Override
                                public void onLoad() {

                                }

                                @Override
                                public void onSuccess(String fsMessage) {

                                }

                                @Override
                                public void onFailed(String fsMessage) {

                                }

                                @Override
                                public void onQrGenerate(Bitmap foBitmap) {

                                }
                            });
                        }
                    });
                    branchSelection.cancelable(false);
                    branchSelection.showDialog();
                }
            });
        });
        return v;
    }

    private void initWidgets(View view){
        recyclerView = view.findViewById(R.id.recyclerView_GCardCart);
        noItem = view.findViewById(R.id.layoutGCardNoItem);
        lnGCardFooter = view.findViewById(R.id.lnGCardFooter);
        lblGrandTotal = view.findViewById(R.id.lblGCardGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnGCardCheckOut);
        btnShopNow = view.findViewById(R.id.btnGCarShopNow);
    }

    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}