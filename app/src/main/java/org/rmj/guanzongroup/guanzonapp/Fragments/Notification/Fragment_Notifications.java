package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.g3msg_notifylib.Fragments.Fragment_NotificationList;
import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Notifications extends Fragment {
    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private int[] notification_tab = {
            R.drawable.ic_tab_promo_toggled,
            R.drawable.ic_notifications_tab_bell_toggled};
    private String[] tab_Title = {
            "Promos",
            "Messages"};
    public static Fragment_Notifications getInstance(){
        return new Fragment_Notifications();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_tab_notifications, container, false);
        setupWidgets();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(notification_tab[tab.getPosition()]);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tab_Title[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(notification_tab[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
    private void setupWidgets(){
        viewPager = view.findViewById(R.id.viewpager_notification_fragment_view);
        tabLayout = view.findViewById(R.id.tabLayout_notification_fragment_indicator);

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new Fragment_Promotions());
        adapter.addFragment(new Fragment_NotificationList());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(notification_tab[0]);
        tabLayout.getTabAt(1).setIcon(notification_tab[1]);
    }

}
