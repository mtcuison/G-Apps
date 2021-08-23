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
import org.rmj.guanzongroup.guanzonapp.Model.PromoEventsModel;

import java.util.ArrayList;
import java.util.List;

public class VMPromotions extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RPromo poPromo;
    private final REvents poEvents;
    private LiveData<List<EPromo>> ePromo;
    private LiveData<List<EEvents>> eEvents;
    private List<PromoEventsModel> promoEventsModels;
    private MutableLiveData<List<PromoEventsModel>> fsPromoEvents = new MutableLiveData();
    public VMPromotions(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poPromo = new RPromo(application);
        this.poEvents = new REvents(application);
        this.ePromo = poPromo.getAllPromo();
        this.eEvents = poEvents.getAllEvents();
        this.promoEventsModels = new ArrayList<>();
        
    }
    public void setPromos(List<EPromo> promoList){
        PromoEventsModel eventsModels = new PromoEventsModel();
        eventsModels.setTransNox("");
        eventsModels.setBranchNm("");
        eventsModels.setDateFrom("");
        eventsModels.setDateThru("");
        eventsModels.setTitle("See more promos at Official Guanzon Group");
        eventsModels.setAddress("");
        eventsModels.setUrl("https://www.guanzongroup.com.ph/category/promos/");
        eventsModels.setImgUrl("");
        eventsModels.setNotified("");
        eventsModels.setModified("");
        eventsModels.setImgByte("");
        eventsModels.setDirectoryFolder("");
        promoEventsModels.add(0,eventsModels);

        if (promoList.size()> 0) {
            for (int i = 0; i < promoList.size(); i++) {
                PromoEventsModel eventsModel = new PromoEventsModel();
                eventsModel.setTransNox(promoList.get(i).getTransNox());
                eventsModel.setBranchNm("");
                eventsModel.setDateFrom(promoList.get(i).getDateFrom());
                eventsModel.setDateThru(promoList.get(i).getDateThru());
                eventsModel.setTitle(promoList.get(i).getCaptionx());
                eventsModel.setAddress("");
                eventsModel.setUrl(promoList.get(i).getPromoUrl());
                eventsModel.setImgUrl(promoList.get(i).getImageUrl());
                eventsModel.setNotified(promoList.get(i).getNotified());
                eventsModel.setModified("");
                eventsModel.setImgByte("");
                eventsModel.setDivision(String.valueOf(promoList.get(i).getDivision()));
                eventsModel.setDirectoryFolder(promoList.get(i).getDirectoryFolder());
                eventsModel.setImgPath(promoList.get(i).getImagePath());
//                    eventsModel.setDirectoryFolder(ePromos.get(i).getDirectoryFolder());
                promoEventsModels.add(eventsModel);
            }
        }
        fsPromoEvents.setValue(promoEventsModels);
    }
    public void setEvents(List<EEvents> eventList){
        if (eventList.size()> 0){
            for(int i = 0; i < eventList.size(); i++){
                PromoEventsModel eventsModel = new PromoEventsModel();
                eventsModel.setTransNox(eventList.get(i).getTransNox());
                eventsModel.setBranchNm(eventList.get(i).getBranchNm());
                eventsModel.setDateFrom(eventList.get(i).getEvntFrom());
                eventsModel.setDateThru(eventList.get(i).getEvntThru());
                eventsModel.setTitle(eventList.get(i).getEventTle());
                eventsModel.setAddress(eventList.get(i).getAddressx());
                eventsModel.setUrl(eventList.get(i).getEventURL());
                eventsModel.setImgUrl(eventList.get(i).getImageURL());
                eventsModel.setNotified(eventList.get(i).getNotified());
                eventsModel.setModified(eventList.get(i).getModified());
                eventsModel.setDirectoryFolder(eventList.get(i).getDirectoryFolder());
                eventsModel.setImgPath(eventList.get(i).getImagePath());
                promoEventsModels.add(eventsModel);
            }
        }
        fsPromoEvents.setValue(promoEventsModels);
    }
    public LiveData<List<PromoEventsModel>> getAllPromoEvents(){
        return fsPromoEvents;
    }

    public LiveData<List<EPromo>> getAllPromo(){
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
