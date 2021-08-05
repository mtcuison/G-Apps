package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RPromo;

import java.util.ArrayList;
import java.util.List;

public class VMTransactions extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RPromo poPromo;
    private final RGCardTransactionLedger poTransaction;
    private final RGcardApp gcard;
    private LiveData<List<EPromo>> ePromo;
    private List<EPromo> promoList = new ArrayList<>();
    public VMTransactions(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poPromo = new RPromo(application);
        this.poTransaction = new RGCardTransactionLedger(application);
        this.gcard = new RGcardApp(application);
        this.ePromo = poPromo.getAllPromo();

    }
    public LiveData<List<EGCardTransactionLedger>> getRedemptionTransactionsList(){
        return poTransaction.getRedemptionTransactionsList(gcard.getCardNox());
    }

    public LiveData<List<EGCardTransactionLedger>> getPointsEntryTransactionsList(){
        return poTransaction.getPointsEntryTransactionsList(gcard.getCardNox());
    }

    public LiveData<List<EGCardTransactionLedger>> getAllTransactionsList(){
        return poTransaction.getAllTransactionsList(gcard.getCardNox());
    }
}
