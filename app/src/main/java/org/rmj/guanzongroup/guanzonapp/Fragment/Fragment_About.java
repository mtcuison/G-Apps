package org.rmj.guanzongroup.guanzonapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.guanzonapp.Activity.Activity_TermsAndConditions;
import org.rmj.guanzongroup.guanzonapp.databinding.FragmentAboutBinding;

public class Fragment_About extends Fragment {

    private FragmentAboutBinding mBinding;

    public Fragment_About() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentAboutBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent loIntent = new Intent(requireActivity(), Activity_TermsAndConditions.class);
        mBinding.lnkTermsC.setOnClickListener(v -> {
            loIntent.putExtra("cTermsDsp", 0);
            startActivity(loIntent);
        });
        mBinding.lnkPrivcy.setOnClickListener(v -> {
            loIntent.putExtra("cTermsDsp", 1);
            startActivity(loIntent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

}