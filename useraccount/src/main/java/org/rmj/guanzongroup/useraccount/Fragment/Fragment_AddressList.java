package org.rmj.guanzongroup.useraccount.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.guanzongroup.useraccount.Activity.Activity_AddressUpdate;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ShippingAddress;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_ShippingAddress;
import org.rmj.guanzongroup.useraccount.ViewModel.VMShippingAddress;
import org.rmj.guanzongroup.useraccount.databinding.FragmentAddressListBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment_AddressList extends Fragment {

    private VMShippingAddress mViewModel;
    private FragmentAddressListBinding mBinding;
    private Adapter_ShippingAddress poAdapter;

    public Fragment_AddressList() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMShippingAddress.class);
        mBinding = FragmentAddressListBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        mBinding.btnAddShp.setOnClickListener(v -> Activity_ShippingAddress.getInstance().setFragment(1));
        setAddressAdapter();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void setAddressAdapter() {
        mViewModel.getClientBSAddress().observe(getViewLifecycleOwner(), clientBSAddress -> {
            try {
                List<Adapter_ShippingAddress.Address> loClientx = new ArrayList<>();
                String sHouseNo1 = clientBSAddress.sHouseNo1;
                String sAddress1 = clientBSAddress.sAddress1;
                String sBrgyNme1 = clientBSAddress.sBrgyNme1;
                String sTownNme1 = clientBSAddress.sTownNme1;
                String sProvNme1 = clientBSAddress.sProvNme1;
                String sHouseNo2 = clientBSAddress.sHouseNo2;
                String sAddress2 = clientBSAddress.sAddress2;
                String sBrgyNme2 = clientBSAddress.sBrgyNme2;
                String sTownNme2 = clientBSAddress.sTownNme2;
                String sProvNme2 = clientBSAddress.sProvNme2;
                loClientx.add(new Adapter_ShippingAddress.Address(false,
                        sHouseNo1,
                        sAddress1,
                        sBrgyNme1,
                        sTownNme1 + ", " + sProvNme1));
                loClientx.add(new Adapter_ShippingAddress.Address(true,
                        sHouseNo2,
                        sAddress2,
                        sBrgyNme2,
                        sTownNme2 + ", " + sProvNme2));

                poAdapter = new Adapter_ShippingAddress(loClientx, position -> {
                    Intent loIntent = new Intent(requireActivity(), Activity_AddressUpdate.class);
                    if(position == 0) {
                        loIntent.putExtra("sAddUpdte", "billing");
                    } else {
                        loIntent.putExtra("sAddUpdte", "shipping");
                    }
                    startActivity(loIntent);
                });
                mBinding.recyclerVw.setLayoutManager(new LinearLayoutManager(requireActivity()));
                mBinding.recyclerVw.setHasFixedSize(true);
                mBinding.recyclerVw.setAdapter(poAdapter);
                poAdapter.notifyDataSetChanged();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }
}