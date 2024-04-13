package org.rmj.guanzongroup.gconnect.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_MyGcard;
import org.rmj.guanzongroup.gconnect.R;
import org.rmj.guanzongroup.gconnect.ViewModel.VMDashboard;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_MPItemCart;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_Promotion;
import org.rmj.guanzongroup.panalo.Fragment.Fragment_Panalo;

public class Fragment_Dashboard extends Fragment {
    private static final String TAG = Fragment_Dashboard.class.getSimpleName();

    private VMDashboard mViewModel;

    private View view;
    private BottomNavigationView botNav;
    private ViewPager viewPager;

    public static Fragment_Dashboard newInstance() {
        return new Fragment_Dashboard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMDashboard.class);

        initViews();
        setupPages();

        botNav.setBackground(null);
        botNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                viewPager.setCurrentItem(0);
                Log.d(TAG, "Home Selected.");
            } else if(item.getItemId() == R.id.nav_MpItemCart){
                viewPager.setCurrentItem(3);
                Log.d(TAG, "Promotions Selected.");
            } else if(item.getItemId() == R.id.nav_promos){
                viewPager.setCurrentItem(1);
                Log.d(TAG, "Guanzon Panalo Selected.");
            } else if(item.getItemId() == R.id.nav_MyGcard) {
                viewPager.setCurrentItem(4);
                Log.d(TAG, "My G-Card Selected.");
            } else if(item.getItemId() == R.id.nav_Panalo) {
                viewPager.setCurrentItem(2);
                Log.d(TAG, "Guanzon Panalo Selected.");
            }
            return true;
        });

        mViewModel.getClientInfo().observe(getViewLifecycleOwner(), eClientInfo -> {
            try{
                Menu nav_Menu = botNav.getMenu();
                if(eClientInfo != null){

                    //Pre release of Guanzon Connect Marketplace Project requires this field to be commented
                    // in order to hide the preview of marketplace items
//                    nav_Menu.findItem(R.id.nav_item_cart).setVisible(true);
//                    nav_Menu.findItem(R.id.nav_applyLoan).setVisible(true);
                    nav_Menu.findItem(R.id.nav_Panalo).setVisible(true);
                    nav_Menu.findItem(R.id.nav_MpItemCart).setVisible(true);
                    nav_Menu.findItem(R.id.nav_MyGcard).setVisible(true);
                } else {
                    nav_Menu.findItem(R.id.nav_Panalo).setVisible(false);
                    nav_Menu.findItem(R.id.nav_MpItemCart).setVisible(false);
                    nav_Menu.findItem(R.id.nav_MyGcard).setVisible(false);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        return view;
    }
    private void initViews() {
        viewPager = view.findViewById(R.id.viewpager);
        botNav = view.findViewById(R.id.bottom_navigation);
    }
    private void setupPages(){
        Fragment[] loFragments = new Fragment[]{
                new Fragment_Home(),
                new Fragment_Promotion(),
                new Fragment_Panalo(),
                new Fragment_MPItemCart(),
                new Fragment_MyGcard()};
        FragmentAdapter loAdapter = new FragmentAdapter(getChildFragmentManager(), loFragments);
        viewPager.setAdapter(loAdapter);
    }
}