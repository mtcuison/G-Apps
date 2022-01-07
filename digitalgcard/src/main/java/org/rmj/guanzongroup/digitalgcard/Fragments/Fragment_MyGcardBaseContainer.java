package org.rmj.guanzongroup.digitalgcard.Fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMMyGcardBaseContainer;

public class Fragment_MyGcardBaseContainer extends Fragment {

    private VMMyGcardBaseContainer mViewModel;


    public static Fragment_MyGcardBaseContainer newInstance() {
        return new Fragment_MyGcardBaseContainer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_gcard_base_container, container, false);
        setViewPager(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMMyGcardBaseContainer.class);

        // TODO: Use the ViewModel
    }

    private void setViewPager(View view) {
        ViewPager loViewPgr = view.findViewById(R.id.vp_gcard);
        loViewPgr.setAdapter(new FragmentAdapter(getFragmentManager(), getGcardFragment()));
    }

    private Fragment getGcardFragment(){
        int lnFragArg = (int) getArguments().get("gcardInstance");
        switch (lnFragArg) {
            case 1:
                return new Fragment_MyGcard();
            case 2:
                return new Fragment_Redeemables();
            case 3:
                return new Fragment_GcardOrders();
            case 4:
                return new Fragment_GcardLedger();
            default:
                return null;
        }
    }

    private static class FragmentAdapter extends FragmentStatePagerAdapter {
        private final Fragment fragment;

        public FragmentAdapter(@NonNull FragmentManager fm, Fragment fragment) {
            super(fm);
            this.fragment = fragment;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }

}