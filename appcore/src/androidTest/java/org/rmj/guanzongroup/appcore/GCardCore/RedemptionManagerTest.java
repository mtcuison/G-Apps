package org.rmj.guanzongroup.appcore.GCardCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;

import java.util.List;

public class RedemptionManagerTest {

    private Context mContext;
    private iGCardSystem poSystem;

    private boolean isSuccess = false;
    private String message = "";

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.REDEEMPTION);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isPointsValid() {

    }

    @Test
    public void downloadRedeemablesTest() throws Exception {
        poSystem.DownloadRedeemables(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                isSuccess = true;
            }

            @Override
            public void OnFailed(String message) {
                isSuccess = false;
            }
        });
        assertTrue(isSuccess);
    }

    @Test @UiThread
    public void RedeemablesSavingTest() throws Exception{
        poSystem.GetRedeemablesList().observeForever(new Observer<List<ERedeemablesInfo>>() {
            @Override
            public void onChanged(List<ERedeemablesInfo> eRedeemablesInfos) {
                assertEquals(0, eRedeemablesInfos.size());
            }
        });
    }

    @Test
    public void AddToCartTest() throws Exception{
        poSystem.AddToCart(new CartItem("", "", 1, 50.00), new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {

            }

            @Override
            public void OnFailed(String message) {

            }
        });
    }

    @Test
    public void AddToCartTestUpdateExistingItemOnCart() throws Exception{
        poSystem.AddToCart(new CartItem("", "", 1, 50.00), new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {

            }

            @Override
            public void OnFailed(String message) {

            }
        });
    }
}