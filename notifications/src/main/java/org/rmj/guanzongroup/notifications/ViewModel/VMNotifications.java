package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMNotifications extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final RGcardApp poGCard;
    private final RGcardApp poGcardxx;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private final RNotificationInfo poNotif;
    private iGCardSystem poSystem;
    public VMNotifications(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poGcardxx = new RGcardApp(application);
        this.poProduct = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
        this.poGCard = new RGcardApp(application);
        this.poOrder = new ROrder(application);
        this.poNotif = new RNotificationInfo(application);
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    public LiveData<List<DNotifications.ClientNotificationInfo>> GetClientNotificationList(){
        return poNotif.GetClientNotificationList();
    }
}
