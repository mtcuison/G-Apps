package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMOrderStatus;

import java.util.List;

public class Fragment_OrderStatus extends Fragment {

    private VMOrderStatus mViewModel;

    public static Fragment_OrderStatus newInstance() {
        return new Fragment_OrderStatus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMOrderStatus.class);
        View loView = inflater.inflate(R.layout.fragment_order_status, container, false);
        String lsOrderIDxx = "";
        if(getArguments() != null){
            lsOrderIDxx = getArguments().getString("sOrderIDx");
        }
//        mViewModel.GetMasterOrderInfo(lsOrderIDxx).observe(getViewLifecycleOwner(), eOrderMaster -> {
//            try{
//                mViewModel.GetOrderDetailInfo(eOrderMaster.getTransNox()).observe(getViewLifecycleOwner(), eOrderDetails -> {
//
//                });
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });

        return loView;
    }
}