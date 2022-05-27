package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.marketplace.Activity.Activity_Purchases;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderHistory;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMOrders;

public class Fragment_Orders extends Fragment {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    private VMOrders mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMOrders.class);
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        mViewModel.ImportOrdersTask();
        tabLayout = view.findViewById(R.id.tab_layout_orders);
        recyclerView = view.findViewById(R.id.recyclerview_Orders);
        LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);

        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("To Pay"));
        tabLayout.addTab(tabLayout.newTab().setText("Processing"));
        tabLayout.addTab(tabLayout.newTab().setText("To Ship"));
        tabLayout.addTab(tabLayout.newTab().setText("Delivered"));
        tabLayout.addTab(tabLayout.newTab().setText("Canceled"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() > 0) {
                    int lnPosition = tab.getPosition() - 1;
                    mViewModel.setOrderStatusFilter(String.valueOf(lnPosition));
                } else {
                    mViewModel.setOrderStatusFilter("");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewModel.GetOrderStatusFilter().observe(getViewLifecycleOwner(), s -> {
            try{
                if(s.isEmpty()){
                    mViewModel.GetOrderHistoryList().observe(getViewLifecycleOwner(), eOrderMasters -> {
                        Adapter_OrderHistory loAdapter = new Adapter_OrderHistory(eOrderMasters, args -> {
                            Intent loIntent = new Intent(requireActivity(), Activity_Purchases.class);
                            loIntent.putExtra("sOrderIDx", args);
                            startActivity(loIntent);
                        });
                        recyclerView.setAdapter(loAdapter);
                    });
                } else {
                    mViewModel.GetOrderHistoryList(s).observe(getViewLifecycleOwner(), eOrderMasters -> {
                        Adapter_OrderHistory loAdapter = new Adapter_OrderHistory(eOrderMasters, args -> {
                            Intent loIntent = new Intent(requireActivity(), Activity_Purchases.class);
                            loIntent.putExtra("sOrderIDx", args);
                            startActivity(loIntent);
                        });
                        recyclerView.setAdapter(loAdapter);
                    });
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        return view;
    }
}