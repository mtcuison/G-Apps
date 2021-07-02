package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Branch;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_NewsEvents;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_BranchDetailView;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMBranches;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMNewsFeed;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMPromotions;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Branches extends Fragment {

    private static final String TAG = Fragment_Branches.class.getSimpleName();
    private VMBranches mViewModel;
    private ViewPager viewPager;
    private View view;
    private TabLayout tabLayout;
    private EditText txtBranchSearch;
    private ImageButton btnCancelSearch;
    private RecyclerView recyclerView;

    private ActivityFragmentAdapter adapter;

    private Adapter_Branch bAdapter;
    private int[] tabIcons = {
            R.drawable.ic_tab_motorcycle,
            R.drawable.ic_tab_mobitek};

    private int[] tabIconsToggled = {
            R.drawable.ic_tab_motorcycle_toggled,
            R.drawable.ic_tab_mobitek_toggled};

    public static Fragment_Branches newInstance() {
        return new Fragment_Branches();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =  inflater.inflate(R.layout.fragment_dashboard_tab_branches, container, false);
         mViewModel = ViewModelProviders.of(this).get(VMBranches.class);
         setupWidgets(view);
         mViewModel.getAllBranchs().observe(getViewLifecycleOwner(), brnList->{
             bAdapter = new Adapter_Branch(getActivity(), brnList, true);
             LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
             layoutManager.setOrientation(RecyclerView.VERTICAL);
             recyclerView.setLayoutManager(layoutManager);
             recyclerView.setAdapter(bAdapter);
             bAdapter.setOnBranchClickListener(new Adapter_Branch.onBranchClickListener() {
                 @SuppressLint("NewApi")
                 @Override
                 public void onClick(int position, String BranchName, String Address, String Mobile, String PhoneNo, String Email) {
                     Dialog_BranchDetailView dialog = new Dialog_BranchDetailView(getActivity(), getBranchCode(BranchName));
                     dialog.setBranchName(BranchName);
                     dialog.setBranchAdds(Address);
                     dialog.setBranchMobl(Mobile);
                     dialog.setBranchCntc(PhoneNo);
                     dialog.setBranchMail(Email);
                     dialog.showDialog();
                 }
             });
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
                         v.clearFocus();
                         InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                         imm.hideSoftInputFromWindow(txtBranchSearch.getWindowToken(), 0);

                     }
                 }

             });

             btnCancelSearch.setOnClickListener(new View.OnClickListener() {
                 @SuppressLint("NewApi")
                 @Override
                 public void onClick(View v) {
                     txtBranchSearch.setText(null);
                     txtBranchSearch.clearFocus();
                     InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                     imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                     txtBranchSearch .setSelected(false);
                     txtBranchSearch .setFocusable(false);
                     txtBranchSearch .setFocusableInTouchMode(true);
                 }
             });

             txtBranchSearch.addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                     bAdapter.getBranchFilter().filter(s.toString());
                     bAdapter.notifyDataSetChanged();
                 }

                 @Override
                 public void afterTextChanged(Editable s) {

                 }
             });
         });
        return view;
    }
    private int getBranchCode(String BranchName){
        if(!BranchName.contains("Mobitek")){
            return 1;
        }
        return 0;
    }
    public void setupWidgets(View view){
        tabLayout = view.findViewById(R.id.tabLayout_branches_fragment_indicator);
        viewPager = view.findViewById(R.id.viewpager_fragment_branches);
        txtBranchSearch = view.findViewById(R.id.txt_fragment_branch_textSearch);
        recyclerView = view.findViewById(R.id.recycler_view_fragment_branches);
        btnCancelSearch = view.findViewById(R.id.btn_fragment_branch_cancel_search);

        adapter = new ActivityFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new Motorcycle_Branches());
        adapter.addFragment(new Mobitek_Branches());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIconsToggled[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
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

}
