package org.rmj.guanzongroup.guanzonapp.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_ManageGcard;
import org.rmj.guanzongroup.guanzonapp.Adapter.Adapter_BranchList;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMBranchDetails;

import java.util.List;

public class Fragment_FindUs extends Fragment {

    private VMBranchDetails mViewModel;
    private Adapter_BranchList poAdapter;
    private TabLayout tabLayout;
    private ImageView imgHeader;
    private RecyclerView recyclerView;

    private Adapter_BranchList.OnBranchClickListener mListener;
    private List<EBranchInfo> poMcBranch;
    private List<EBranchInfo> poMpBranch;

    public Fragment_FindUs() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_us, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMBranchDetails.class);
        mViewModel.DownloadBranches();
        mViewModel.getMotorBranches().observe(getViewLifecycleOwner(), motorBranches -> {
            poMcBranch = motorBranches;
            poAdapter = new Adapter_BranchList(motorBranches, mListener);
            recyclerView.setAdapter(poAdapter);
            poAdapter.notifyDataSetChanged();
        });
        mViewModel.getMobileBranches().observe(getViewLifecycleOwner(), mobileBranches -> poMpBranch = mobileBranches);
        setTabLayout();
    }

    private void initViews(View v) {
        tabLayout = v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Motorcycle"));
        tabLayout.addTab(tabLayout.newTab().setText("Mobile Phones"));
        recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setHasFixedSize(true);
        imgHeader = v.findViewById(R.id.img_header);
        mListener = new Adapter_BranchList.OnBranchClickListener() {
            @Override
            public void OnClick(String args) {
                Toast.makeText(requireActivity(), args, Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        initMCBranches();
                        recyclerView.setAdapter(poAdapter);
                        break;
                    case 1:
                        initMPBranches();
                        recyclerView.setAdapter(poAdapter);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initMCBranches() {
        try {
            poAdapter = new Adapter_BranchList(poMcBranch, mListener);
            poAdapter.notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initMPBranches() {
        try {
            poAdapter = new Adapter_BranchList(poMpBranch, mListener);
            poAdapter.notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setHeaderImage(Bitmap poImage) {
        /** set image here **/
        imgHeader.setImageBitmap(poImage);
    }
}