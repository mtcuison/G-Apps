package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.guanzongroup.marketplace.Activity.Activity_PlaceOrder;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMMPItemCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Fragment_MPItemCart extends Fragment {

    private VMMPItemCart mViewModel;

    private RecyclerView recyclerView;
    private LinearLayout noItem, lnMPFooter;
    private MaterialButton btnCheckOut;
    private TextView lblGrandTotal;
    private Adapter_ItemCart adapter;
    private List<ItemCartModel> itemList;
    public static Fragment_MPItemCart newInstance() {
        return new Fragment_MPItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mp_item_cart, container, false);
        mViewModel = new ViewModelProvider(this).get(VMMPItemCart.class);
        initWidgets(v);
        try {
            mViewModel.GetCartItemsList().observe(requireActivity(), new Observer<List<DItemCart.oMarketplaceCartItem>>() {
                @Override
                public void onChanged(List<DItemCart.oMarketplaceCartItem> items) {
                    try {
                        List<ItemCartModel> itemCart = mViewModel.ParseDataForAdapter(items);
                        if (itemCart.size() > 0){
                            noItem.setVisibility(View.GONE);
                            lnMPFooter.setVisibility(View.VISIBLE);
                            adapter = new Adapter_ItemCart(itemCart, new Adapter_ItemCart.OnCartAction() {
                                @Override
                                public void onClickAction(String val) {

                                }
                            });
                            Log.e("itemCart = ", String.valueOf(itemCart.size()));
                            LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
                            adapter.notifyDataSetChanged();
                            double subtotal = 0;
                            for (int x = 0; x < itemList.size(); x++){
                                subtotal += Double.parseDouble(itemList.get(x).getItemPrice().replaceAll(",",""));
                            }
                            lblGrandTotal.setText("₱ " + currencyFormat(subtotal));
                        }else {
                            noItem.setVisibility(View.VISIBLE);
                            lnMPFooter.setVisibility(View.GONE);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

            btnCheckOut.setOnClickListener(view ->{
                startActivity(new Intent(getActivity(), Activity_PlaceOrder.class));

            });
        }catch (NullPointerException e){
            Log.e("",e.getMessage());
        }
        return v;
    }

    private void initWidgets(View view){
        recyclerView = view.findViewById(R.id.recyclerView_MPCart);
        noItem = view.findViewById(R.id.layoutMPNoItem);
        lnMPFooter = view.findViewById(R.id.lnMPFooter);
        lblGrandTotal = view.findViewById(R.id.lblMPGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnMPCheckOut);
    }
    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}