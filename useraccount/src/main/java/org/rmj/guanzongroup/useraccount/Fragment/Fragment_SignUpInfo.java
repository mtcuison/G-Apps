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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountAuthentication.class);
        try {
            poSignUpM = mViewModel.getSignUpModel();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnNext.setOnClickListener(v -> toNextPage());
    }

    private void initViews(View v) {
        tieLastNm = v.findViewById(R.id.tie_lastname);
        tieFrstNm = v.findViewById(R.id.tie_firstname);
        tieMiddNm = v.findViewById(R.id.tie_middname);
        tieSuffix = v.findViewById(R.id.tie_suffix);
        tieEmailx = v.findViewById(R.id.tie_email);
        tieMobile = v.findViewById(R.id.tie_mobile);
        btnNext = v.findViewById(R.id.btnNext);
    }

    private void toNextPage() {
        String lsLastNme = Objects.requireNonNull(tieLastNm.getText().toString().trim());
        String lsFrstNme = Objects.requireNonNull(tieFrstNm.getText().toString().trim());
        String lsMiddNme = Objects.requireNonNull(tieMiddNm.getText().toString().trim());
        String lsSuffixN = Objects.requireNonNull(tieSuffix.getText().toString().trim());
        String lsEmailAd = Objects.requireNonNull(tieEmailx.getText().toString().trim());
        String lsMobileN = Objects.requireNonNull(tieMobile.getText().toString().trim());

        poSignUpM.setLastName(lsLastNme);
        poSignUpM.setFrstName(lsFrstNme);
        poSignUpM.setMiddName("".equalsIgnoreCase(lsMiddNme) ? "-" : lsMiddNme);
        poSignUpM.setSuffixNm(lsSuffixN);
        poSignUpM.setEmailAdd(lsEmailAd);
        poSignUpM.setMobileNo(lsMobileN);

        if(poSignUpM.isFirstPageClear()) {
            Activity_SignUp.getInstance().moveToPageNumber(1);
        } else {
            Toast.makeText(getActivity(), poSignUpM.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}