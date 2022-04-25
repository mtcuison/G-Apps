package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.useraccount.Activity.Activity_AccountDetails;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_AccountDetails;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.Objects;

public class Fragment_AccountDetailsList extends Fragment {

    private VMAccountDetails mViewModel;
    private Adapter_AccountDetails poAdapter;
    private RecyclerView recyclerView;

    public Fragment_AccountDetailsList() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_account_details_list, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountDetails.class);
        setAdapter();
    }

    // Initialize this first before anything else.
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setHasFixedSize(true);
    }

    private void setAdapter() {
        mViewModel.getAccountDetailsList().observe(getViewLifecycleOwner(), details -> {
            poAdapter = new Adapter_AccountDetails(details, (label) -> {
                    if (label.equals("Personal Information")) {
                        Activity_AccountDetails.getInstance().moveToPageNumber(1);
                    }
                    else if (label.equals("Present Address")) {
                        Activity_AccountDetails.getInstance().moveToPageNumber(2);
                    }
                    else if (label.equals("Account Information")) {
                        Activity_AccountDetails.getInstance().moveToPageNumber(3);
                    }
            });
            recyclerView.setAdapter(poAdapter);
            poAdapter.notifyDataSetChanged();
        });
    }

}