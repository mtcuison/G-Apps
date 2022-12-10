package org.rmj.guanzongroup.notifications.Adapter;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;

import org.rmj.guanzongroup.marketplace.Adapter.ActivityFragmentAdapter;
import org.rmj.guanzongroup.notifications.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Fragment extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentlist = new ArrayList<>();

    private List<String> mTitle = new ArrayList<>();

    public Adapter_Fragment(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentlist.size();
    }

    @Override
    public String getPageTitle(int position) {
        return mTitle.get(position);
    }

    public void addFragment(Fragment fragment) {
        this.mFragmentlist.add(fragment);
    }

    public void clear() {
        this.mFragmentlist.clear();
        this.mTitle.clear();
    }

    public void addTitle(String title) {
        this.mTitle.add(title);
    }
}

