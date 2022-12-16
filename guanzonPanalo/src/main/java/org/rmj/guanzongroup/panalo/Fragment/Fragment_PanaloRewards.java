package org.rmj.guanzongroup.panalo.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.panalo.R;
import org.rmj.guanzongroup.panalo.ViewModel.VMPanaloRewards;

public class Fragment_PanaloRewards extends Fragment {

    private VMPanaloRewards mViewModel;

    public static Fragment_PanaloRewards newInstance() {
        return new Fragment_PanaloRewards();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMPanaloRewards.class);
        View view = inflater.inflate(R.layout.fragment_panalo_rewards, container, false);


        return view;
    }
}