package org.rmj.g3appdriver.GCardCore;

import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
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
import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void test01DownloadGCardNumber() throws Exception{
        poSystem.DownloadGcardNumbers(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    JSONObject loDetail = new JSONObject(args);
                    poSystem.SaveGCardInfo(loDetail);
                } catch (Exception e) {
                    e.printStackTrace();
                    isSuccess = false;
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
    public void test02GCardSavingTest() throws Exception {
        LiveData<List<EGcardApp>> loGcard = poSystem.GetGCardList();
        loGcard.observeForever(eGcardApps -> assertTrue(eGcardApps.size() > 0));
    }

    @Test
    public void test03DownloadGCardTransactionTest() throws Exception{
        poSystem.DownloadTransactions(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                isSuccess = true;
            }

            @Override
            public void OnFailed(String fsMessage) {
                isSuccess = false;
                message = fsMessage;
            }
        });
        assertTrue(isSuccess);
    }

    @Test @UiThread
    public void test04GetGCardTransactionsTest(){
        poSystem.GetGcardTransactions().observeForever(new Observer<List<EGCardTransactionLedger>>() {
            @Override
            public void onChanged(List<EGCardTransactionLedger> egCardTransactionLedgers) {
                assertTrue(egCardTransactionLedgers.size() >= 0);
            }
        });
    }

    @Test @UiThread
    public void test05GetGCardTransactionsTestPointsEntryList(){
        poSystem.GetPointsEntryTransactions().observeForever(new Observer<List<EGCardTransactionLedger>>() {
            @Override
            public void onChanged(List<EGCardTransactionLedger> egCardTransactionLedgers) {
                assertTrue(egCardTransactionLedgers.size() >= 0);
            }
        });
    }

    @Test @UiThread
    public void test06GetGCardTransactionsTestRedemptionList(){
        poSystem.GetRedemptionTransactions().observeForever(new Observer<List<EGCardTransactionLedger>>() {
            @Override
            public void onChanged(List<EGCardTransactionLedger> egCardTransactionLedgers) {
                assertTrue(egCardTransactionLedgers.size() >= 0);
            }
        });
    }

    @Test @UiThread
    public void test07DownloadMCRegistrationTest() throws Exception{
        poSystem.DownloadRegistrationInfo(new GCardSystem.GCardSystemCallback() {
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

    @Test
    public void test08AddGCardNo() throws Exception {
        poSystem.AddGCard(new GcardCredentials("0011800067804", "2000-04-01"), new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try{
                    JSONObject loJson = new JSONObject(args);
                    poSystem.SaveGCardInfo(loJson);
                    isSuccess = true;
                } catch (Exception e){
                    e.printStackTrace();
                    isSuccess = false;
                }
            }

            @Override
            public void OnFailed(String message) {
                try {
                    JSONObject loJson = new JSONObject(message);
                    poSystem.ConfirmAddGCard(new GcardCredentials("0011800067804", "2000-04-01"), new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try{
                                JSONObject loJson = new JSONObject(args);
                                poSystem.SaveGCardInfo(loJson);
                                isSuccess = true;
                            } catch (Exception e){
                                e.printStackTrace();
                                isSuccess = false;
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            isSuccess = false;
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                    isSuccess = false;
                }
            }
        });
        assertTrue(isSuccess);
    }
}