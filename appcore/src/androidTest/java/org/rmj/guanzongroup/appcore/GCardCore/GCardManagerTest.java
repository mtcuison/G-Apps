package org.rmj.guanzongroup.appcore.GCardCore;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class GCardManagerTest {

    private Context mContext;
    private GCardSystem poGcard;
    private iGCardSystem poSystem;

    private boolean isSuccess = false;
    private String message = "";

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poGcard = new GCardSystem(mContext);
        poSystem = poGcard.getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void downloadGCardNumber() throws Exception{
        poSystem.DownloadGcardNumbers(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    JSONObject loDetail = new JSONObject(args);
                    poSystem.SaveGCardInfo(loDetail);
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
    public void GCardSavingTest() throws Exception {
        LiveData<List<EGcardApp>> loGcard = poSystem.GetGCardList();
        loGcard.observeForever(new Observer<List<EGcardApp>>() {
            @Override
            public void onChanged(List<EGcardApp> eGcardApps) {
                assertEquals(0, eGcardApps.size());
            }
        });
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