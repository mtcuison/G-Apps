package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.marketplace.Adapter.ActivityFragmentAdapter;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMItemCart;

public class Fragment_ItemCart extends Fragment {

    private VMItemCart mViewModel;
    private ViewPager viewPager;
    private View view;
    private TabLayout tabLayout;
    private EditText txtBranchSearch;
    private ImageButton btnCancelSearch;
    private ActivityFragmentAdapter adapter;


    public static Fragment_ItemCart newInstance() {
        return new Fragment_ItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_cart, container, false);
        initWidgets(v);
        setupTabLayoutListener();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMItemCart.class);
        mViewModel.GetActiveGCard().observe(requireActivity(), new Observer<EGcardApp>() {
            @Override
            public void onChanged(EGcardApp eGcardApp) {
                try {
                    adapter.addFragment(new Fragment_MPItemCart());
                    adapter.addTitle("MarketPlace");
                    if (eGcardApp != null) {
                        adapter.addFragment(new Fragment_GCardItemCart());
                        adapter.addTitle("GCard");
                    }
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                    adapter.notifyDataSetChanged();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
    private void initWidgets(View view){
        tabLayout = view.findViewById(R.id.tabLayout_item_cart_fragment_indicator);
        viewPager = view.findViewById(R.id.viewpager_fragment_item_cart);
        adapter = new ActivityFragmentAdapter(getChildFragmentManager());
    }

    private void setupTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tabLayout.getTabAt(tab.getPosition()).setIcon(tabToggledIcons[tab.getPosition()]);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}