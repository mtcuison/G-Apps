package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.etc.ConnectionUtil;

public class VMHome extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final ConnectionUtil poConnect;
    private final RGcardApp poGCard;

    public VMHome(@NonNull Application application) {
        super(application);
        this.poConnect = new ConnectionUtil(application);
        this.poClientx = new RClientInfo(application);
        this.poAddress = new RAddressMobile(application);
        this.poGCard = new RGcardApp(application);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }

    public LiveData<EGcardApp> GetActiveGCard(){
        return poGCard.getGCardInfo();
    }

    public void importAddress() {
        new ImportAddressTask(poConnect, poAddress).execute();
    }

    private static class ImportAddressTask extends AsyncTask<Void, Void, String> {
        private final ConnectionUtil poConnect;
        private final RAddressMobile poAddress;

        private ImportAddressTask(ConnectionUtil foConnect, RAddressMobile foAddress) {
            this.poConnect = foConnect;
            this.poAddress = foAddress;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                if(poConnect.isDeviceConnected()) {
                    poAddress.ImportBarangayList();
                    poAddress.ImportCountryList();
                    poAddress.ImportProvinceList();
                    poAddress.ImportTownList();
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}