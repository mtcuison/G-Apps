package org.rmj.g3appdriver.GCardCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
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