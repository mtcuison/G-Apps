package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.useraccount.Activity.Activity_SignUp;
import org.rmj.guanzongroup.useraccount.R;

public class Fragment_SignUpInfo extends Fragment {

    private MaterialButton btnNext;

    public Fragment_SignUpInfo() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_info, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void initViews(View v) {
        btnNext = v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> Activity_SignUp.getInstance().moveToPageNumber(1));
    }

}