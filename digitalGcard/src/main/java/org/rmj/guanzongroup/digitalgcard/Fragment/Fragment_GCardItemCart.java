package org.rmj.guanzongroup.digitalgcard.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ItemCart;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Dialog.Dialog_BranchSelection;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;

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
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poMessage;
    public static Fragment_GCardItemCart newInstance() {
        return new Fragment_GCardItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gcard_item_cart, container, false);
        mViewModel = new ViewModelProvider(this).get(VMGCardSystem.class);
        initWidgets(v);
        mViewModel.GetCartItems().observe(getViewLifecycleOwner(), itemCart ->{
            try {
                if (itemCart.size() > 0){
                    List<ItemCartModel> items = ParseDataForAdapter(itemCart);
                    gcardItem = new ArrayList<>();
                    gcardItem = itemCart;
                    recyclerView.setVisibility(View.VISIBLE);
                    noItem.setVisibility(View.GONE);
                    lnGCardFooter.setVisibility(View.VISIBLE);
                    adapter = new Adapter_ItemCart(items, new Adapter_ItemCart.OnCartAction() {
                        @Override
                        public void onItemSelect(String fsListIdx) {

                        }

                        @Override
                        public void onItemDeselect(String fsListIdx) {

                        }

                        @Override
                        public void onItemDelete(String fsListIDx) {
                            mViewModel.DeleteCartItem(fsListIDx);
                        }

                        @Override
                        public void onQuantityClick(String fsListIdx, int fnItemQty) {
                            CartItem loCart = new CartItem(fsListIdx, fsListIdx, fnItemQty, 0);
                            mViewModel.UpdateCartItem(loCart);
                        }
                    });
                    LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter.notifyDataSetChanged();
                }else {
                    recyclerView.setVisibility(View.GONE);
                    noItem.setVisibility(View.VISIBLE);
                    lnGCardFooter.setVisibility(View.GONE);
                }
            }catch (NullPointerException e){
                Log.e(TAG,"NullPointerException " + e.getMessage());
            }catch (Exception e){
                Log.e(TAG,"Exception " + e.getMessage());
            }
        });

        mViewModel.GetGCardCartItemTotalPoints().observe(getViewLifecycleOwner(), aDouble -> {
            try{
                lblGrandTotal.setText(currencyFormat(aDouble)  + " point/s");
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        btnShopNow.setOnClickListener(view ->{
            Intent intent = new Intent(requireActivity(), Activity_ItemCart.class);
            intent.putExtra("args","2");
            startActivity(intent);
        });
        btnCheckOut.setOnClickListener(view->{
            mViewModel.GetMCBranchesForRedemption(branchInfos -> {
                Log.e(TAG, String.valueOf(branchInfos.size()));
                Dialog_BranchSelection branchSelection = new Dialog_BranchSelection(requireActivity());
                branchSelection.createDialog(branchInfos, (branchInfo, dialog) -> mViewModel.PlaceOrder(gcardItem,branchInfo.getBranchCd(), new VMGCardSystem.GcardTransactionCallback() {
                    @Override
                    public void onLoad() {
                        poLoading.initDialog("Place Order", "Sending order, please wait...");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        poLoading.dismiss();
                        showMessage("Place Order",fsMessage);
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        showMessage("Place Order",fsMessage);

                    }

                    @Override
                    public void onQrGenerate(Bitmap foBitmap) {

                    }
                }));
                branchSelection.cancelable(false);
                branchSelection.showDialog();
            });
        });
        return v;
    }
    public List<ItemCartModel> ParseDataForAdapter(List<DRedeemItemInfo.GCardCartItem> foVal) {
        ArrayList<ItemCartModel> list = new ArrayList<>();
        for(int x = 0; x < foVal.size(); x++){
            ItemCartModel loDetail = new ItemCartModel();
            loDetail.setMarket(false);
            loDetail.setListingId(foVal.get(x).sTransNox);
            loDetail.setItemName(foVal.get(x).sPromoDsc);
            loDetail.setItemPrice(foVal.get(x).nPointsxx);
            loDetail.setItemQty(foVal.get(x).nItemQtyx);
            loDetail.setItemImage(foVal.get(x).sImageUrl);
            list.add(loDetail);
        }
        return list;
    }
    private void initWidgets(View view){
        poLoading = new Dialog_Loading(requireActivity());
        poMessage = new Dialog_SingleButton(requireActivity());
        recyclerView = view.findViewById(R.id.recyclerView_GCardCart);
        noItem = view.findViewById(R.id.layoutGCardNoItem);
        lnGCardFooter = view.findViewById(R.id.lnGCardFooter);
        lblGrandTotal = view.findViewById(R.id.lblGCardGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnGCardCheckOut);
        btnShopNow = view.findViewById(R.id.btnGCarShopNow);
    }
    void showMessage(String title, String msg){
        poMessage.setButtonText("Okay");
        poMessage.initDialog(title, msg, () -> poMessage.dismiss());
        poMessage.show();
    }
    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}