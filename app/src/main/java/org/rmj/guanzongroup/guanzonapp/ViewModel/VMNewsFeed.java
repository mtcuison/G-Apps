package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class VMNewsFeed extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final REvents poEvent;
    private final SessionManager sessionManager;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    public VMNewsFeed(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poEvent = new REvents(application);
        this.sessionManager = new SessionManager(application);
    }
    public LiveData<List<EEvents>> getAllEvents(){
        return poEvent.getAllEvents();
    }
    public void setLogin(boolean val){
        sessionManager.setLogin(val);
    }
}
