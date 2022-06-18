package org.rmj.guanzongroup.useraccount.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.guanzongroup.useraccount.Activity.Activity_AccountDetails;
import org.rmj.guanzongroup.useraccount.Activity.Activity_CompleteAccountDetails;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ShippingAddress;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_AccountSettings;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountSettings;
import org.rmj.guanzongroup.useraccount.R;
import java.util.ArrayList;

public class Fragment_AccountSettings extends Fragment {

    private VMAccountSettings mViewModel;
    private AccountInfo poAccount;
    private Adapter_AccountSettings poAdapter;
    private RecyclerView recyclerView;

    public static Fragment_AccountSettings newInstance() {
        return new Fragment_AccountSettings();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account_settings, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountSettings.class);
        poAccount = new AccountInfo(requireActivity());
        // TODO: Use the ViewModel
        setUpViews(v);
        setSettingsAdapter(v);
        return v;
    }

    private void setUpViews(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    private void setSettingsAdapter(View view) {
        poAdapter = new Adapter_AccountSettings(getMenuList(), position -> {
            switch(position) {
                case 0:
                    if(!poAccount.getLoginStatus())  {
                        Intent loIntent = new Intent(requireActivity(), Activity_Login.class);
                        startActivity(loIntent);
                    } else {
                        if(new AccountInfo(requireActivity()).getClientID().isEmpty()) {
                            Intent loIntent = new Intent(requireActivity(), Activity_CompleteAccountDetails.class);
                            startActivity(loIntent);
                        } else {
                            Intent loIntent = new Intent(requireActivity(), Activity_AccountDetails.class);
                            startActivity(loIntent);
                        }
                    }
                    break;
                case 2:
                    Intent loIntent = new Intent(requireActivity(), Activity_ShippingAddress.class);
                    startActivity(loIntent);
                    break;
                case 3:
                    Bundle loBundle = new Bundle();
                    loBundle.putInt("gcardInstance", 1);
                    Navigation.findNavController(view).navigate(R.id.action_nav_account_settings_to_nav_my_gcard, loBundle);
                    break;
            }
        });
        recyclerView.setAdapter(poAdapter);
        poAdapter.notifyDataSetChanged();
    }

    private ArrayList<String[]> getMenuList() {
        ArrayList<String[]> loMenuLst = new ArrayList<>();
        for(int i = 0; i < AppConstants.ACCOUNT_SETTINGS_MENU.length; i++) {
            loMenuLst.add(AppConstants.ACCOUNT_SETTINGS_MENU[i]);
        }
        return loMenuLst;
    }

}