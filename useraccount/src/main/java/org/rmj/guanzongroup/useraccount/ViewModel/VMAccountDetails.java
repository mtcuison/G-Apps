package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.guanzongroup.useraccount.Model.AccountDetailsInfo;

import java.util.ArrayList;
import java.util.List;

public class VMAccountDetails extends AndroidViewModel {
    private static final String TAG = VMAccountDetails.class.getSimpleName();
    private final MutableLiveData<List<AccountDetailsInfo>> poAcctInf = new MutableLiveData<>();

    public VMAccountDetails(@NonNull Application application) {
        super(application);
        setAccountDetailsList();
    }

    private void setAccountDetailsList() {
        List<AccountDetailsInfo> loAcctInf = new ArrayList<>();
        loAcctInf.add(new AccountDetailsInfo(true, "Personal Information", "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Full Name", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Gender", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Date", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Place", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Citizen", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Civil Status", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Tax ID", ""));

        loAcctInf.add(new AccountDetailsInfo(true, "Account Information", "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Email Address", ""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Mobile Number", ""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Password", ""));

        loAcctInf.add(new AccountDetailsInfo(true, "Present Address", "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Address", ""));

        poAcctInf.setValue(loAcctInf);
    }

    public LiveData<List<AccountDetailsInfo>> getAccountDetailsList() {
        return poAcctInf;
    }


}
