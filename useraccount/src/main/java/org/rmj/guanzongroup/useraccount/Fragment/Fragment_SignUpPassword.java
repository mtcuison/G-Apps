package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.useraccount.Activity.Activity_SignUp;
import org.rmj.guanzongroup.useraccount.R;

public class Fragment_SignUpPassword extends Fragment {

    private TextView lblTerms;
    private MaterialButton btnSignUp, btnBack;
    public Fragment_SignUpPassword() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_password, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initViews(View v) {
        lblTerms = v.findViewById(R.id.tvTerms);
        btnSignUp = v.findViewById(R.id.btnSignUp);
        btnBack = v.findViewById(R.id.btnBack);

        lblTerms.setOnClickListener(view -> { });
        btnBack.setOnClickListener(view -> Activity_SignUp.getInstance().moveToPageNumber(0));
    }

}