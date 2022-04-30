package org.rmj.guanzongroup.marketplace.Fragment;

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
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.marketplace.Activity_PlaceOrder;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMItemCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Fragment_ItemCart extends Fragment {

    private VMItemCart mViewModel;
    private RecyclerView recyclerView;
    private MaterialButton btnCheckOut;
    private TextView lblGrandTotal;
    private Adapter_ItemCart adapter;
    private List<ItemCartModel> itemList;
    public static Fragment_ItemCart newInstance() {
        return new Fragment_ItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_cart, container, false);
        initWidgets(v);
        setData();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMItemCart.class);
//        mViewModel.getData().observe(getViewLifecycleOwner(), itemCart ->{
//
//        });
        btnCheckOut.setOnClickListener(v ->{
           startActivity(new Intent(getActivity(), Activity_PlaceOrder.class));

        });


    }
    private void initWidgets(View view){
        recyclerView = view.findViewById(R.id.recyclerView_Cart);
        lblGrandTotal = view.findViewById(R.id.lblGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnCheckOut);
    }
    private void setData(){
        itemList = new ArrayList<>();

        ItemCartModel model3 = new ItemCartModel();
        model3.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2022/03/samsung-galaxy-s22-plus-1.jpg");
        model3.setItemName("Galaxy S22+ (8+256GB)");
        model3.setItemPrice("60,990.00");
        model3.setItemQty("1");
        itemList.add(model3);
        ItemCartModel model = new ItemCartModel();
        model.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2021/05/realme-8-1-510x510.jpg");
        model.setItemName("Realme 8 (8GB+128GB) Realme 8 (8GB+128GB)");
        model.setItemPrice("13,133.00");
        model.setItemQty("1");
        itemList.add(model);
        ItemCartModel model2 = new ItemCartModel();
        model2.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2021/09/oppo-reno6-5g-1-510x510.jpg");
        model2.setItemName("Reno 6 5G (8GB+128GB)");
        model2.setItemPrice("24,526.00");
        model2.setItemQty("1");
        itemList.add(model2);
        ItemCartModel model1 = new ItemCartModel();
        model1.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2022/02/realme-c25y-1-510x510.jpg");
        model1.setItemName("Realme C25Y (4+128GB)");
        model1.setItemPrice("8,677.00");
        model1.setItemQty("1");
        itemList.add(model1);

        adapter = new Adapter_ItemCart(itemList, new Adapter_ItemCart.OnCartAction() {
            @Override
            public void onClickAction(String val) {

            }
        });
        Log.e("itemCart = ", String.valueOf(itemList.size()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter.notifyDataSetChanged();
        double subtotal = 0;
        for (int x = 0; x < itemList.size(); x++){
            subtotal += Double.parseDouble(itemList.get(x).getItemPrice().replaceAll(",",""));
        }
        lblGrandTotal.setText("₱ " + currencyFormat(subtotal));

    }
    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}