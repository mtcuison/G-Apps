package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Branch;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_BranchDetailView;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMBranches;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Branches extends Fragment {
    private VMBranches mViewModel;
    private ViewPager viewPager;
    private View view;
    private TabLayout tabLayout;
    private EditText txtBranchSearch;
    private ImageButton btnCancelSearch;
    private RecyclerView recyclerView;

    private Adapter_Branch adapter;

    private int[] tabIcons = {
            R.drawable.ic_tab_motorcycle,
            R.drawable.ic_tab_mobitek};

    private int[] tabIconsToggled = {
            R.drawable.ic_tab_motorcycle_toggled,
            R.drawable.ic_tab_mobitek_toggled};

    public Fragment_Branches() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =  inflater.inflate(R.layout.fragment_dashboard_tab_branches, container, false);

        mViewModel = ViewModelProviders.of(this).get(VMBranches.class);
        setupWidgets();
        setupTabLayoutListener();
        setupBranchList();
        return view;
    }

    private void setupWidgets(){
        tabLayout = view.findViewById(R.id.tabLayout_branches_fragment_indicator);
        viewPager = view.findViewById(R.id.viewpager_fragment_branches);
        txtBranchSearch = view.findViewById(R.id.txt_fragment_branch_textSearch);
        recyclerView = view.findViewById(R.id.recycler_view_fragment_branches);
        btnCancelSearch = view.findViewById(R.id.btn_fragment_branch_cancel_search);

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new Motorcycle_Branches());
        adapter.addFragment(new Mobitek_Branches());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIconsToggled[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

        txtBranchSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(txtBranchSearch.hasFocus()){
                    recyclerView.setVisibility(View.VISIBLE);
                    btnCancelSearch.setVisibility(View.VISIBLE);
                    tabLayout.setVisibility(View.GONE);
                    viewPager.setVisibility(View.GONE);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    btnCancelSearch.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                }
            }
        });

        btnCancelSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBranchSearch.clearFocus();
            }
        });

        txtBranchSearch.addTextChangedListener(new BranchSearch());
    }

    private void setupTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsToggled[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class BranchSearch implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            adapter.getBranchFilter().filter(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private void setupBranchList(){
        mViewModel.getAllBranchs().observe(getViewLifecycleOwner(), brnList -> {
            adapter = new Adapter_Branch(getActivity(), brnList, true);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            adapter.setOnBranchClickListener(new Adapter_Branch.onBranchClickListener() {
                @Override
                public void onClick(int position, String BranchName, String Address, String Mobile, String PhoneNo, String Email) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Dialog_BranchDetailView dialog = new Dialog_BranchDetailView(getActivity(), getBranchCode(BranchName));
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

    }

    private int getBranchCode(String BranchName){
        if(!BranchName.contains("Mobitek")){
            return 1;
        }
        return 0;
    }
}
