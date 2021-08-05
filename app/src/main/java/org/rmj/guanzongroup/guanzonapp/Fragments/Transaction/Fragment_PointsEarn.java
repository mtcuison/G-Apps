package org.rmj.guanzongroup.guanzonapp.Fragments.Transaction;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Transactions;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMTransactions;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_PointsEarn extends Fragment {

    private View view;

    private VMTransactions mViewModel;

    public Fragment_PointsEarn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_points_earn, container, false);
        mViewModel = ViewModelProviders.of(this).get(VMTransactions.class);
        setupWidgets();
        return view;
    }

    private void setupWidgets(){
        LinearLayout layout = view.findViewById(R.id.linear_emptyList);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_fragment_points_entry);
        mViewModel.getPointsEntryTransactionsList().observe(getViewLifecycleOwner(), list->{
            Adapter_Transactions adapter = new Adapter_Transactions(list);
            if(adapter.getItemCount() > 0) {
                layout.setVisibility(View.GONE);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
            } else {
                layout.setVisibility(View.VISIBLE);
            }
        });
    }
}
