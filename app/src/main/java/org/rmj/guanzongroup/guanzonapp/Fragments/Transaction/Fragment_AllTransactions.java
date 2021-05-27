package org.rmj.guanzongroup.guanzonapp.Fragments.Transaction;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_AllTransactions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.TransactionList;
import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_AllTransactions extends Fragment {

    private View view;

    public Fragment_AllTransactions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_transactions, container, false);
        setupWidgets();
        return view;
    }

    private void setupWidgets(){
        LinearLayout layout = view.findViewById(R.id.linear_emptyList);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_fragment_transaction_all);
        Adapter_AllTransactions adapter_allTransactions = new Adapter_AllTransactions(new TransactionList(getActivity()).getAllTransactionsList());
        if(adapter_allTransactions.getItemCount() > 0) {
            layout.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter_allTransactions);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }
}
