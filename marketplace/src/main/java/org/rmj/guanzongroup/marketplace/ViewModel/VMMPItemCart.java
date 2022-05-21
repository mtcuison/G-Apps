package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;

import java.util.ArrayList;
import java.util.List;

public class VMMPItemCart extends AndroidViewModel {
    private static final String TAG = VMMPItemCart.class.getSimpleName();

    private final MutableLiveData<List<ItemCartModel>> poItemCart = new MutableLiveData<>();
    private final RClientInfo poClientx;
    private final RGcardApp poGCard;
    private final ROrder poOrder;

    public VMMPItemCart(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poGCard = new RGcardApp(application);
        this.poOrder = new ROrder(application);
//        generateData();
    }



    public LiveData<List<DItemCart.oMarketplaceCartItem>> GetCartItemsList(){
        return poOrder.GetItemCartList();
    }

    public LiveData<List<ItemCartModel>> getMarketPlaceItemCart(){
        return poItemCart;
    }

//    private void generateData() {
//        ArrayList<ItemCartModel> itemList = new ArrayList<>();
//        ItemCartModel model3 = new ItemCartModel();
//        model3.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2022/03/samsung-galaxy-s22-plus-1.jpg");
//        model3.setItemName("Galaxy S22+ (8+256GB)");
//        model3.setItemPrice("60,990.00");
//        model3.setItemQty("1");
//        itemList.add(model3);
//        ItemCartModel model = new ItemCartModel();
//        model.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2021/05/realme-8-1-510x510.jpg");
//        model.setItemName("Realme 8 (8GB+128GB) Realme 8 (8GB+128GB)");
//        model.setItemPrice("13,133.00");
//        model.setItemQty("1");
//        itemList.add(model);
//        ItemCartModel model2 = new ItemCartModel();
//        model2.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2021/09/oppo-reno6-5g-1-510x510.jpg");
//        model2.setItemName("Reno 6 5G (8GB+128GB)");
//        model2.setItemPrice("24,526.00");
//        model2.setItemQty("1");
//        itemList.add(model2);
//        ItemCartModel model1 = new ItemCartModel();
//        model1.setItemImage("https://www.guanzongroup.com.ph/wp-content/uploads/2022/02/realme-c25y-1-510x510.jpg");
//        model1.setItemName("Realme C25Y (4+128GB)");
//        model1.setItemPrice("8,677.00");
//        model1.setItemQty("1");
//        itemList.add(model1);
//        poItemCart.setValue(itemList);
//    }

    public List<ItemCartModel> ParseDataForAdapter(List<DItemCart.oMarketplaceCartItem> foVal) {
        ArrayList<ItemCartModel> list = new ArrayList<>();
        for(int x = 0; x < foVal.size(); x++){
            ItemCartModel loDetail = new ItemCartModel();
            loDetail.setMarket(true);
            loDetail.setListingId(foVal.get(x).sListIDxx);
            loDetail.setItemName(foVal.get(x).xModelNme);
            loDetail.setItemPrice(foVal.get(x).nUnitPrce);
            loDetail.setItemQty(foVal.get(x).nQuantity);
            list.add(loDetail);
        }
        return list;
    }

    public void forCheckOut(String fsListIdx) {
        new ForCheckoutTask(poOrder).execute(fsListIdx);
    }

    public void removeForCheckOut(String fsListIdx) {
        new RemoveForCheckoutTask(poOrder).execute(fsListIdx);
    }

    private static class ForCheckoutTask extends AsyncTask<String, Void, Void> {

        private final ROrder loItmCart;

        private ForCheckoutTask(ROrder foItmCart) {
            this.loItmCart = foItmCart;
        }

        @Override
        protected Void doInBackground(String... strings) {
            String lsListIdx = strings[0];
            loItmCart.ForCheckOut(lsListIdx);
            return null;
        }
    }

    private static class RemoveForCheckoutTask extends AsyncTask<String, Void, Void> {

        private final ROrder loItmCart;

        private RemoveForCheckoutTask(ROrder foItmCart) {
            this.loItmCart = foItmCart;
        }

        @Override
        protected Void doInBackground(String... strings) {
            String lsListIdx = strings[0];
            loItmCart.RemoveForCheckOut(lsListIdx);
            return null;
        }
    }

}