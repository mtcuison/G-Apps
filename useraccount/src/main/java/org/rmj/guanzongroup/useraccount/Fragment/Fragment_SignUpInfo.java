package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Activity.Activity_SignUp;
import org.rmj.guanzongroup.useraccount.Model.SignUpInfoModel;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Fragment_SignUpInfo extends Fragment {

    private VMAccountAuthentication mViewModel;
    private SignUpInfoModel poSignUpM;
    private TextInputEditText tieLastNm, tieFrstNm, tieMiddNm, tieSuffix, tieEmailx, tieMobile;
    private MaterialButton btnNext;

    public Fragment_SignUpInfo() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_info, container, false);
        initViews(view);

        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountAuthentication.class);
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnNext.setOnClickListener(v -> toNextPage());

        return view;
    }

    private void initViews(View v) {
        tieEmailx = v.findViewById(R.id.tie_email);
        tieMobile = v.findViewById(R.id.tie_mobile);
        btnNext = v.findViewById(R.id.btnNext);
    }

    private void toNextPage() {

    }

}