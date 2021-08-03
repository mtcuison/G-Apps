package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class VMAccount extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RBranchInfo poBranch;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final SessionManager poSession;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    public VMAccount(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranch = new RBranchInfo(application);
        this.poClient = new RClientInfo(application);
        this.poGCard = new RGcardApp(application);
        this.poSession = new SessionManager(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
//    public LiveData<EGcardApp> getGCardInfo(){
//        return poGCard.getGCardInfo();
//    }
    public void userLogout(){
        poSession.initUserLogout();
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
    }
}