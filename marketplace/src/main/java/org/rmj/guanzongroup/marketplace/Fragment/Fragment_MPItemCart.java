package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Activity.Activity_PlaceOrder;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMMPItemCart;

import java.text.DecimalFormat;
import java.util.List;

public class Fragment_MPItemCart extends Fragment {

    private VMMPItemCart mViewModel;

    private RecyclerView recyclerView, rvSuggest;
    private LinearLayout noItem, lnMPFooter;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private MaterialButton btnCheckOut, btnShopNow;
    private TextView lblGrandTotal;
    private Adapter_ItemCart adapter;
    public static Fragment_MPItemCart newInstance() {
        return new Fragment_MPItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMMPItemCart.class);
        View v = inflater.inflate(R.layout.fragment_mp_item_cart, container, false);
        initWidgets(v);
        try {
            LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
            mViewModel.GetCartItemsList().observe(getViewLifecycleOwner(), items -> {
                try {
                    List<ItemCartModel> itemCart = mViewModel.ParseDataForAdapter(items);
                    if (itemCart.size() > 0){
                        noItem.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        lnMPFooter.setVisibility(View.VISIBLE);
                        adapter = new Adapter_ItemCart(itemCart, new Adapter_ItemCart.OnCartAction() {
                            @Override
                            public void onItemSelect(String fsListIdx) {
                                mViewModel.forCheckOut(fsListIdx);
                            }

                            @Override
                            public void onItemDeselect(String fsListIdx) {
                                mViewModel.removeForCheckOut(fsListIdx);
                            }

                            @Override
                            public void onItemDelete(String fsListIDx) {
                                mViewModel.RemoveItemOnCart(fsListIDx, new OnTransactionsCallback() {
                                    @Override
                                    public void onLoading() {
                                        poLoading.initDialog("Item Cart", "Processing. Please wait.");
                                        poLoading.show();
                                    }

                                    @Override
                                    public void onSuccess(String fsMessage) {
                                        poLoading.dismiss();
                                    }

                                    @Override
                                    public void onFailed(String fsMessage) {
                                        poLoading.dismiss();
                                        poDialogx.setButtonText("Okay");
                                        poDialogx.initDialog("Item Cart", fsMessage, Dialog::dismiss);
                                        poDialogx.show();
                                    }
                                });
                            }

                            @Override
                            public void onQuantityClick(String fsListIdx, int fnItemQty) {
                                mViewModel.addUpdateCart(fsListIdx, fnItemQty, true,new OnTransactionsCallback() {
                                    @Override
                                    public void onLoading() {
                                        poLoading.initDialog("Item Cart", "Processing. Please wait.");
                                        poLoading.show();
                                    }

                                    @Override
                                    public void onSuccess(String fsMessage) {
                                        poLoading.dismiss();
                                    }

                                    @Override
                                    public void onFailed(String fsMessage) {
                                        poLoading.dismiss();
                                        poDialogx.setButtonText("Okay");
                                        poDialogx.initDialog("Item Cart", fsMessage, Dialog::dismiss);
                                        poDialogx.show();
                                    }
                                });
                            }
                        });
                        Log.e("itemCart = ", String.valueOf(itemCart.size()));
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else {
                        noItem.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        lnMPFooter.setVisibility(View.GONE);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            });

            mViewModel.GetGrandTotal().observe(getViewLifecycleOwner(), subtotal -> {
                try{
                    lblGrandTotal.setText("₱ " + currencyFormat(subtotal));
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        }catch (NullPointerException e){
            Log.e("",e.getMessage());
        }

        // Show items below cart
        showSuggestions();

        btnCheckOut.setOnClickListener(view ->{
            mViewModel.checkCartItemsForCheckOut(new OnTransactionsCallback() {
                @Override
                public void onLoading() {
                    poLoading.initDialog("Item Cart", "Processing. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    Intent loIntent = new Intent(requireActivity(), Activity_PlaceOrder.class);
                    loIntent.putExtra("cBuyNowxx", false);
                    startActivity(loIntent);
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Item Cart", fsMessage, Dialog::dismiss);
                    poDialogx.show();
                }
            });
        });

        btnShopNow.setOnClickListener(v1 -> {
            Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
            intent.putExtra("args", "dashboard");
            requireActivity().sendBroadcast(intent);
            poLoading.dismiss();
            requireActivity().finish();
        });
        return v;
    }
    private void initWidgets(View view){
        poLoading = new Dialog_Loading(requireActivity());
        poDialogx = new Dialog_SingleButton(requireActivity());
        recyclerView = view.findViewById(R.id.recyclerView_MPCart);
        rvSuggest = view.findViewById(R.id.rvSuggest);
        noItem = view.findViewById(R.id.layoutMPNoItem);
        lnMPFooter = view.findViewById(R.id.lnMPFooter);
        lblGrandTotal = view.findViewById(R.id.lblMPGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnMPCheckOut);
        btnShopNow = view.findViewById(R.id.btnMPShopNow);

    }

    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }

    private void showSuggestions() {
        rvSuggest.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.VERTICAL, false));
        rvSuggest.setHasFixedSize(true);
        mViewModel.getProductList(0).observe(getViewLifecycleOwner(), products -> {
            try {
                if(products.size() > 0) {
                    Adapter_ProductList poAdapter = new Adapter_ProductList(products, listingId -> {
                        Intent loIntent = new Intent(requireActivity(), Activity_ProductOverview.class);
                        loIntent.putExtra("sListingId", listingId);
                        startActivity(loIntent);
                    });
                    poAdapter.notifyDataSetChanged();
                    rvSuggest.setAdapter(poAdapter);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

}