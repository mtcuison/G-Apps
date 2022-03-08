package org.rmj.g3appdriver.GCardCore;

import android.content.Context;

import static org.junit.Assert.assertTrue;

import androidx.annotation.UiThread;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class RedeemablesTransactionTest {


    private Context mContext;
    private iGCardSystem poSystem;

    private boolean isSuccess = false;

    List<ERedeemItemInfo> poCartItem = new ArrayList<>();

    private static JSONObject poJson;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.REDEEMPTION);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test @UiThread
    public void test01AddToCart() throws Exception{
        poSystem.GetRedeemablesList().observeForever(new Observer<List<ERedeemablesInfo>>() {
            @Override
            public void onChanged(List<ERedeemablesInfo> eRedeemablesInfos) {
                ERedeemablesInfo loItem = eRedeemablesInfos.get(2);
                CartItem loCart = new CartItem(loItem.getTransNox(),
                        loItem.getPromoCde(),
                        1,
                        loItem.getPointsxx());

                poSystem.AddToCart(loCart, new GCardSystem.GCardSystemCallback() {
                    @Override
                    public void OnSuccess(String args) {
                        isSuccess = true;
                    }

                    @Override
                    public void OnFailed(String message) {
                        isSuccess = false;
                    }
                });
            }
        });
        assertTrue(isSuccess);
    }

    @Test @UiThread
    public void test02PlaceOrder() throws Exception{
        poSystem.GetCartItems().observeForever(new Observer<List<ERedeemItemInfo>>() {
            @Override
            public void onChanged(List<ERedeemItemInfo> eRedeemItemInfos) {
                poCartItem = eRedeemItemInfos;
            }
        });

        poSystem.PlaceOrder(poCartItem, "M001", new GCardSystem.GCardSystemCallback() {
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
}
