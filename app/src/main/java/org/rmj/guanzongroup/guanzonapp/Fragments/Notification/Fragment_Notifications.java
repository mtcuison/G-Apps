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
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.App_Notifications;
import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Notifications extends Fragment {
    private static Fragment_Notifications instance;
    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private App_Notifications appNotifications;
    private BadgeDrawable badgeDrawable;
    private BadgeDrawable badgeDrawable1;
    private BadgeDrawable badgeDrawable2;

    /*private int[] notification_tab = {
            R.drawable.ic_tab_event,
            R.drawable.ic_tab_promo,
            R.drawable.ic_notifications_tab_bell};

    private int[] notification_tab_toggled = {
            R.drawable.ic_tab_event_toggled,
            R.drawable.ic_tab_promo_toggled,
            R.drawable.ic_notifications_tab_bell_toggled};

    private String[] tab_Title = {
            "Events",
            "Promos",
            "Messages"};*/

    private int[] notification_tab = {
            R.drawable.ic_tab_promo,
            R.drawable.ic_notifications_tab_bell};

    private int[] notification_tab_toggled = {
            R.drawable.ic_tab_promo_toggled,
            R.drawable.ic_notifications_tab_bell_toggled};

    private String[] tab_Title = {
            "Promos",
            "Messages"};

    public Fragment_Notifications() {
        // Required empty public constructor
    }

    public static Fragment_Notifications getInstance(){
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        instance = this;
        view = inflater.inflate(R.layout.fragment_dashboard_tab_notifications, container, false);
        appNotifications = new App_Notifications(getActivity());
        setupWidgets();
        return view;
    }

    private void setupWidgets(){
        viewPager = view.findViewById(R.id.viewpager_notification_fragment_view);
        tabLayout = view.findViewById(R.id.tabLayout_notification_fragment_indicator);

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getChildFragmentManager());
        //adapter.addFragment(new Fragment_Events());
        adapter.addFragment(new Fragment_Promotions());
        adapter.addFragment(new Fragment_NotificationList());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        /*tabLayout.getTabAt(0).setIcon(notification_tab_toggled[0]);
        badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(getVisibility(appNotifications.getEventCount()));
        badgeDrawable.setNumber(appNotifications.getEventCount());*/
        tabLayout.getTabAt(0).setIcon(notification_tab_toggled[0]);
        badgeDrawable1 = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable1.setVisible(getVisibility(appNotifications.getPromoCount()));
        badgeDrawable1.setNumber(appNotifications.getPromoCount());
        tabLayout.getTabAt(1).setIcon(notification_tab[1]);
        badgeDrawable2 = tabLayout.getTabAt(1).getOrCreateBadge();
        badgeDrawable2.setVisible(getVisibility(appNotifications.getMessageCount()));
        badgeDrawable2.setNumber(appNotifications.getMessageCount());

        //tabLayout.getTabAt(2).setIcon(notification_tab[2]);
        setupTablayoutListener();
    }

    private void setupTablayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(notification_tab_toggled[tab.getPosition()]);
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
    }

    public void refreshBadges(){
        badgeDrawable.clearNumber();
        badgeDrawable1.clearNumber();
        badgeDrawable.setVisible(getVisibility(appNotifications.getEventCount()));
        badgeDrawable1.setVisible(getVisibility(appNotifications.getPromoCount()));
        badgeDrawable2.setVisible(getVisibility(appNotifications.getMessageCount()));
        badgeDrawable.setNumber(appNotifications.getEventCount());
        badgeDrawable1.setNumber(appNotifications.getPromoCount());
        badgeDrawable2.setNumber(appNotifications.getMessageCount());
        new Fragment_NotificationList().getInstance().refreshView();
    }

    private boolean getVisibility(int count){
        return count > 0;
    }
}
