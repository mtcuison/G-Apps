package org.rmj.g3appdriver.GCardCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
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
public class ImportRedeemablesTest {

    private Context mContext;
    private iGCardSystem poSystem;

    private boolean isSuccess = false;
    private String message = "";

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

    @Test
    public void test01DownloadRedeemables() throws Exception {
        poSystem.DownloadRedeemables(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    poJson = new JSONObject(args);
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
        assertTrue(isSuccess);
        assertNotNull(poJson);
    }

    @Test @UiThread
    public void test02RedeemablesSaving() throws Exception{
        poSystem.SaveRedeemables(poJson);
        poSystem.GetRedeemablesList().observeForever(new Observer<List<ERedeemablesInfo>>() {
            @Override
            public void onChanged(List<ERedeemablesInfo> eRedeemablesInfos) {
                try {
                    JSONArray laJson = poJson.getJSONArray("detail");
                    assertEquals(laJson.length(), eRedeemablesInfos.size());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}