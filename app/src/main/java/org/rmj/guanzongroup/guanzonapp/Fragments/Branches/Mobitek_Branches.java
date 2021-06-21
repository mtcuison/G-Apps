package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Branch;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Branches;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_BranchDetailView;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.LocalDataBranches;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMBranches;

import java.util.ArrayList;
import java.util.List;

public class Mobitek_Branches extends Fragment {

    private VMBranches mViewModel;
    private View view;
    private Dialog_BranchDetailView dialog;
    Adapter_Branch adapter;
    public Mobitek_Branches(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_branch_mobitek, container, false);

        mViewModel = ViewModelProviders.of(this).get(VMBranches.class);
        setupWidgets();

        return view;
    }

    private void setupWidgets(){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_fragment_branch_mobitek);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(getBranchAdapter());
        recyclerView.setLayoutManager(layoutManager);
    }

    private Adapter_Branch getBranchAdapter(){
//        List<Branches> branchesList = new ArrayList<>();
//        ArrayList<ArrayList<String>> arr_Branches = new LocalDataBranches(getActivity()).getMobileBranches();
//        if(arr_Branches.get(0).size()>0){
//            for(int x = 0; x < arr_Branches.get(0).size(); x++){
//                Branches branches = new Branches(arr_Branches.get(1).get(x),
//                        arr_Branches.get(3).get(x),
//                        arr_Branches.get(2).get(x),
//                        arr_Branches.get(0).get(x),
//                        arr_Branches.get(4).get(x),
//                        arr_Branches.get(5).get(x),
//                        arr_Branches.get(6).get(x));
//                branchesList.add(branches);
//            }
//        }

        mViewModel.getMobileBranches().observe(getViewLifecycleOwner(), brnList ->{
            adapter = new Adapter_Branch(getActivity(), brnList, false);
            adapter.setOnBranchClickListener(new Adapter_Branch.onBranchClickListener() {
                @Override
                public void onClick(int position, String BranchName, String Address, String Mobile, String PhoneNo, String Email) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        dialog = new Dialog_BranchDetailView(getActivity(), 0);
                        dialog.setBranchName(BranchName);
                        dialog.setBranchAdds(Address);
                        dialog.setBranchMobl(Mobile);
                        dialog.setBranchCntc(PhoneNo);
                        dialog.setBranchMail(Email);
                        dialog.showDialog();
                    }
                }
            });
        });
        return adapter;
    }
}
