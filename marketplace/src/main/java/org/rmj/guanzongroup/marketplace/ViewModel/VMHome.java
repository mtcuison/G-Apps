package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;

public class VMHome extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;

    public VMHome(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poAddress = new RAddressMobile(application);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }

    public void importAddress() {
        new ImportAddressTask(poAddress).execute();
    }

    private static class ImportAddressTask extends AsyncTask<Void, Void, String> {

        private final RAddressMobile poAddress;

        private ImportAddressTask(RAddressMobile foAddress) {
            this.poAddress = foAddress;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                poAddress.ImportBarangayList();
                poAddress.ImportCountryList();
                poAddress.ImportProvinceList();
                poAddress.ImportTownList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}