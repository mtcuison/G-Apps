package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Branch;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMBranches;

public class Motorcycle_Branches  extends Fragment {

    private View view;

    private VMBranches mViewModel;
    private Adapter_Branch adapter;
    private RecyclerView recyclerView;
    public static Motorcycle_Branches  newInstance() {
        return new Motorcycle_Branches ();
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_branch_motorcycle, container, false);
        mViewModel = ViewModelProviders.of(this).get(VMBranches.class);
        setupWidgets();
        mViewModel.getMotorBranches().observe(getViewLifecycleOwner(), brnList->{
            adapter = new Adapter_Branch(getActivity(), brnList, false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        });
        return view;
    }
    private void setupWidgets(){
        recyclerView = view.findViewById(R.id.recycler_view_fragment_branch_motorcycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}
