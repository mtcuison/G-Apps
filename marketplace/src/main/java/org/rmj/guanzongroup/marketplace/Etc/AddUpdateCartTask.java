package org.rmj.guanzongroup.marketplace.Etc;

import android.content.Context;
import android.os.AsyncTask;

import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;

public class AddUpdateCartTask extends AsyncTask<String, Void, Boolean> {

    private final ConnectionUtil poConnect;
    private final ROrder poOrdersx;
    private final OnTransactionsCallback poCallBck;
    private final int pnItemQty;
    private final boolean QtyUpdate;
    private String psMessage = "";

    public AddUpdateCartTask(Context foContext, int fnItemQty, boolean QtyUpdate, OnTransactionsCallback foCallBck) {
        this.poConnect = new ConnectionUtil(foContext);
        this.poOrdersx = new ROrder(foContext);
        this.poCallBck = foCallBck;
        this.pnItemQty = fnItemQty;
        this.QtyUpdate = QtyUpdate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        poCallBck.onLoading();
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            String lsListIdx = strings[0];
            if(poConnect.isDeviceConnected()) {
                if(QtyUpdate){
                    if(poOrdersx.UpdateCartQuantity(lsListIdx, pnItemQty)) {
                        psMessage = "Item added successfully";
                        return true;
                    } else {
                        psMessage = poOrdersx.getMessage();
                        return false;
                    }
                } else {
                    if(poOrdersx.AddUpdateCart(lsListIdx, pnItemQty)) {
                        psMessage = "Item added successfully";
                        return true;
                    } else {
                        psMessage = poOrdersx.getMessage();
                        return false;
                    }
                }
            } else {
                psMessage = "Unable to connect.";
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            psMessage = e.getMessage();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean) {
            poCallBck.onSuccess(psMessage);
        } else {
            poCallBck.onFailed(psMessage);
        }
    }

}
