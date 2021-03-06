package org.rmj.guanzongroup.marketplace.ViewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMHome extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final RGcardApp poGCard;
    private final RGcardApp poGcardxx;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private iGCardSystem poSystem;

    public interface OnViewGCardQrCode{
        void OnView(Bitmap foVal);
    }

    public VMHome(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poGcardxx = new RGcardApp(application);
        this.poProduct = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
        this.poGCard = new RGcardApp(application);
        this.poOrder = new ROrder(application);
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }

    public LiveData<EGcardApp> getActiveGcard() {
        return poGcardxx.hasNoGcard();
    }

    public LiveData<EGcardApp> GetActiveGCard(){
        return poGCard.getGCardInfo();
    }

    public LiveData<List<EProducts>> getProductList(int fnIndex) {
        return poProduct.GetProductList(fnIndex);
    }

    public LiveData<Integer> GetCartItemCount(){
        return poOrder.GetCartItemCount();
    }

    public void ViewGCardQrCode(OnViewGCardQrCode callback){
        new CreateGCardQrCodeTask(callback).execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class CreateGCardQrCodeTask extends AsyncTask<String, Void, Bitmap>{
        private final OnViewGCardQrCode callback;

        public CreateGCardQrCodeTask(OnViewGCardQrCode callback) {
            this.callback = callback;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return poSystem.GenerateGCardQrCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap s) {
//            callback.OnView(s);
            super.onPostExecute(s);
            callback.OnView(s);
        }
    }
}