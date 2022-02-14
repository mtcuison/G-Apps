package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.guanzongroup.appcore.Account.AccountAuthentication;

public class VMAccountAuthentication extends AndroidViewModel {
    private static final String TAG = VMAccountAuthentication.class.getSimpleName();
    private final AccountAuthentication poActAuth;

    public VMAccountAuthentication(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized");
        this.poActAuth = new AccountAuthentication(application);
    }

    public void LoginAccount(AccountAuthentication.LoginCredentials foCrednts,
                             AccountAuthentication.OnLoginCallback foCallbck) throws Exception {
        poActAuth.LoginAccount(foCrednts, foCallbck);
    }

    public void RegisterAccount(AccountAuthentication.AccountCredentials foCrednts,
                                AccountAuthentication.OnCreateAccountCallback foCallbck)
                                throws Exception {
        poActAuth.RegisterAccount(foCrednts, foCallbck);
    }

    public void RetrievePassword(String fsEmailxx,
                                 AccountAuthentication.OnRetrievePasswordCallback foCallbck)
                                 throws Exception {
        poActAuth.RetrievePassword(fsEmailxx, foCallbck);
    }

}
