package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.etc.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class VMPromotions extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RPromo poPromo;
    private final REvents poEvents;
    private LiveData<List<EPromo>> ePromo;
    private LiveData<List<EEvents>> eEvents;
    private List<EPromo> promoList = new ArrayList<>();
    private List<EEvents> eventList = new ArrayList<>();
    public VMPromotions(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poPromo = new RPromo(application);
        this.poEvents = new REvents(application);
        this.ePromo = poPromo.getAllPromo();
        this.eEvents = poEvents.getAllEvents();
        this.eventList = eEvents.getValue();

    }
    public LiveData<List<EPromo>> getAllPromo(){
        promoList = ePromo.getValue();
        return ePromo;
    }
    public LiveData<List<EEvents>> getAllEvents(){
        return eEvents;
    }
    public void updatEvents(String TransNox){
        try{
            boolean isTransNoxExist = false;
            String tansNo = "";
            for (int i = 0; i < eEvents.getValue().size(); i++){
                if(eEvents.getValue().get(i).getTransNox().equalsIgnoreCase(TransNox)) {
                    tansNo = eEvents.getValue().get(i).getTransNox();
                    isTransNoxExist = true;
                }
            }
            if (isTransNoxExist){
                poEvents.updateReadEvent(AppConstants.CURRENT_DATE, tansNo);
            }else{
                poPromo.updateReadPromo(AppConstants.CURRENT_DATE, tansNo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
