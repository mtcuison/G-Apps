package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class VMAccount extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final REmployee poUser;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final RGCardTransactionLedger poLedger;
    private final RMCSerialRegistration poMC;
    private final SessionManager poSession;
    private final AppConfigPreference appConfig;
    public static final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<List<Fragment>> psFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> psMenu = new MutableLiveData<>();
    private final MutableLiveData<String[]> psTitles = new MutableLiveData<>();
    private Application instance;
    public VMAccount(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poUser = new REmployee(application);
        this.poClient = new RClientInfo(application);
        this.poSession = new SessionManager(application);
        this.poGCard = new RGcardApp(application);
        this.poLedger = new RGCardTransactionLedger(application);
        this.poMC = new RMCSerialRegistration(application);
        this.appConfig = new AppConfigPreference(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
//    public LiveData<EGcardApp> getGCardInfo(){
//        return poGCard.getGCardInfo();
//    }
    public void userLogout(){
        poSession.setLogin(false);
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
        poLedger.deleteGCardTrans();
        poMC.deleteMC();
        poSession.initUserLogout();
    }
}
