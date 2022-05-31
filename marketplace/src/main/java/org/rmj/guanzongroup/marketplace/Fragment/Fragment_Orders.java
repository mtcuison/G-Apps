package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.Observer;
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

import java.util.Objects;

public class Fragment_Orders extends Fragment {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    private VMOrders mViewModel;

    private Adapter_OrderHistory loAdapter;


    private final Adapter_OrderHistory.OnOrderHistoryClickListener loListener = (args, args1) -> {
        Intent loIntent = new Intent(requireActivity(), Activity_Purchases.class);
        loIntent.putExtra("sOrderIDx", args);
        startActivity(loIntent);
    };

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
                        loAdapter = new Adapter_OrderHistory(eOrderMasters, loListener);
                        recyclerView.setAdapter(loAdapter);
                    });
                } else {
                    mViewModel.GetOrderHistoryList(s).observe(getViewLifecycleOwner(), eOrderMasters -> {
                        loAdapter = new Adapter_OrderHistory(eOrderMasters, loListener);
                        recyclerView.setAdapter(loAdapter);
                    });
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetToPayOrdersCount().observe(getViewLifecycleOwner(), integer -> {
            try{
                if (integer > 0) {
                    Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(1)).getOrCreateBadge()).setNumber(integer);
                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(1)).removeBadge();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetProcessingOrdersCount().observe(getViewLifecycleOwner(), integer -> {
            try{
                if (integer > 0) {
                    Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(2)).getOrCreateBadge()).setNumber(integer);
                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(2)).removeBadge();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetToShipOrdersCount().observe(getViewLifecycleOwner(), integer -> {
            try{
                if (integer > 0) {
                    Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(3)).getOrCreateBadge()).setNumber(integer);
                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(3)).removeBadge();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetDeliveredOrdersCount().observe(getViewLifecycleOwner(), integer -> {
            try{
                if (integer > 0) {
                    Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(4)).getOrCreateBadge()).setNumber(integer);
                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(4)).removeBadge();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetCancelledOrdersCount().observe(getViewLifecycleOwner(), integer -> {
            try{
                if (integer > 0) {
                    Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(5)).getOrCreateBadge()).setNumber(integer);
                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(5)).removeBadge();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        return view;
    }
}