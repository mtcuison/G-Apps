package org.rmj.guanzongroup.useraccount.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.guanzongroup.useraccount.Model.SignUpInfoModel;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Fragment_SignUpPassword extends Fragment {

    private VMAccountAuthentication mViewModel;
//    private Dialog_Loading poLoading;
//    private Dialog_SingleButton poDialogx;
    private SignUpInfoModel poSignUpM;
    private TextView lblTerms;
    private TextInputEditText tiePasswd, tieRetype;
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
        mViewModel = new ViewModelProvider(requireActivity()).get(VMAccountAuthentication.class);
        try {
//            poSignUpM = mViewModel.getSignUpModel();
        } catch (Exception e)  {
            e.printStackTrace();
        }

        btnSignUp.setOnClickListener(v -> registerAccount());
    }

    private void initViews(View v) {
//        poDialogx = new Dialog_SingleButton(requireActivity());
        tiePasswd = v.findViewById(R.id.tie_password);
        tieRetype = v.findViewById(R.id.tie_retype);
        lblTerms = v.findViewById(R.id.tvTerms);
        btnSignUp = v.findViewById(R.id.btnSignUp);
        btnBack = v.findViewById(R.id.btnBack);

        lblTerms.setOnClickListener(view -> { });
//        btnBack.setOnClickListener(view -> Activity_SignUp.getInstance().moveToPageNumber(0));
    }

    private void registerAccount() {
        String lsPasswrd = Objects.requireNonNull(tiePasswd.getText().toString());
        String lsRetypeP = Objects.requireNonNull(tieRetype.getText().toString());

        poSignUpM.setPassword(lsPasswrd);
        poSignUpM.setPasswrd2(lsRetypeP);

//        if(poSignUpM.isSecondPageClear()) {
//
//            AccountAuthentication.AccountCredentials loCrednts = new AccountAuthentication.AccountCredentials();
////            loCrednts.setLastName(poSignUpM.getLastName());
////            loCrednts.setFrstName(poSignUpM.getFrstName());
////            loCrednts.setMiddName(poSignUpM.getMiddName());
//            loCrednts.setEmailAdd(poSignUpM.getEmailAdd());
//            loCrednts.setMobileNo(poSignUpM.getMobileNo());
//            loCrednts.setPassword(poSignUpM.getPassword());
////            loCrednts.setPasswrd2(poSignUpM.getsPasswrd2());
//
//            try {
//                mViewModel.RegisterAccount(loCrednts, new VMAccountAuthentication.AuthTransactionCallback() {
//                    @Override
//                    public void onLoad() {
//                        poLoading = new Dialog_Loading(requireActivity());
//                        poLoading.initDialog("Signing Up", "Please wait for a while.");
//                        poLoading.show();
//                    }
//
//                    @Override
//                    public void onSuccess(String fsMessage) {
//                        poLoading.dismiss();
//                        poDialogx.setButtonText("Okay");
//                        poDialogx.initDialog("Sign Up", fsMessage, dialog -> {
//                            dialog.dismiss();
//                            requireActivity().finish();
//                        });
//                        poDialogx.show();
//                    }
//
//                    @Override
//                    public void onFailed(String fsMessage) {
//                        poLoading.dismiss();
//                        poDialogx.setButtonText("Okay");
//                        poDialogx.initDialog("Sign Up Failed", fsMessage, dialog -> dialog.dismiss());
//                        poDialogx.show();
//                    }
//
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            poDialogx.setButtonText("Okay");
//            poDialogx.initDialog("Sign Up", poSignUpM.getMessage(), dialog -> dialog.dismiss());
//            poDialogx.show();
//        }

    }

}