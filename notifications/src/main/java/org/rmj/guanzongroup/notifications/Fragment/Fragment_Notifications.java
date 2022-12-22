package org.rmj.guanzongroup.notifications.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.notifications.Activity.Activity_ViewNotification;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Notifications extends Fragment {

    private VMNotifications mViewModel;

    private TabLayout tabLayout;
    private TextView noNotif;
    private ViewPager viewPager;
    private Adapter_Notifications adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMNotifications.class);
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        initViews(view);

        return view;
    }

    private void initViews(View v) {
        tabLayout = v.findViewById(R.id.tab_layout);
        noNotif = v.findViewById(R.id.lbl_no_notifications);
        viewPager = v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private static class FragmentAdapter extends FragmentStatePagerAdapter{

        private final List<Fragment> loList = new ArrayList<>();
        private final List<String> loTitle = new ArrayList<>();

        public FragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
            loList.add(new Fragment_MessageList());
            loList.add(new Fragment_Notification());
            loList.add(new Fragment_Panalo());
            loTitle.add("Notifications");
            loTitle.add("Messages");
            loTitle.add("Panalo");
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return loList.get(position);
        }

        @Override
        public int getCount() {
            return loList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return loTitle.get(position);
        }
    }
}