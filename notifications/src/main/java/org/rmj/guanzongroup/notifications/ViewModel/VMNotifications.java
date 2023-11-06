package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMNotifications extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private final RNotificationInfo poNotif;
    private iGCardSystem poSystem;
    public VMNotifications(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poProduct = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
        this.poOrder = new ROrder(application);
        this.poNotif = new RNotificationInfo(application);
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    public LiveData<List<DNotifications.ClientNotificationInfo>> GetClientNotificationList(){
        return poNotif.GetClientNotificationList();
    }

    public LiveData<List<DNotifications.ClientNotificationInfo>> GetRegularMessagesSystemNotifs(){
        return poNotif.GetRegularMessagesSystemNotifs();
    }
    public LiveData<List<DNotifications.RegularMessage>> GetRegularMessagesSystemNotif(){
        return poNotif.GetRegularMessagesSystemNotif();
    }
//    public LiveData<List<DNotifications.RegularMessage>> GetPanaloRegularMessagesSystemNotif(){
//        return poNotif.GetPanaloRegularMessagesSystemNotif();
//    }
    public LiveData<List<DNotifications.ClientNotificationInfo>> GetPanaloRegularMessagesSystemNotif(){
        return poNotif.GetPanaloRegularMessagesSystemNotif();
    }
    public LiveData<List<DNotifications.UserNotificationInfo>> getPanaloNotifications(){
        return poNotif.getPanaloNotifications();
    }

    public LiveData<Integer> getUnreadNotificationsCount(){
        return poNotif.getUnreadNotificationsCount();
    }
    public LiveData<Integer> getUnreadNotificationsCounts(){
        return poNotif.getUnreadNotificationsCounts();
    }
    public LiveData<Integer> getUnreadPromotionsNotifications(){
        return poNotif.getUnreadPromotionsNotifications();
    }
    public LiveData<Integer> getUnreadMessagesPanaloCount(){
        return poNotif.getUnreadMessagesPanaloCount();
    }


}
