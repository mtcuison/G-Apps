package org.rmj.guanzongroup.appcore.GCardCore;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.annotation.UiThread;
import androidx.test.core.app.ApplicationProvider;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SystemExtrasTest {

    private Context mContext;
    private iGCardSystem poSystem;
    private boolean isSuccess = false;
    private JSONObject loJson;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void downloadBranchesList() throws Exception{
        poSystem.DownloadBranchesList(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    isSuccess = true;
                    loJson = new JSONObject(args);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void OnFailed(String message) {
                isSuccess = false;
            }
        });
        assertTrue(isSuccess);
        assertNotNull(loJson);
    }

    @Test
    public void saveBranchesList() throws Exception{
        poSystem.SaveBranchesList(loJson);
    }

    @Test @UiThread
    public void getMobileBranchList() {
        poSystem.GetMobileBranchList().observeForever(eBranchInfos -> assertEquals(1, eBranchInfos.size()));
    }

    @Test @UiThread
    public void getMotorcycleBranchList() {
        poSystem.GetMotorcycleBranchList().observeForever(eBranchInfos -> assertEquals(1, eBranchInfos.size()));
    }

    @Test
    public void downloadPromotions() throws Exception{
        poSystem.DownloadPromotions(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    isSuccess = true;
                    loJson = new JSONObject(args);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void OnFailed(String message) {
                isSuccess = false;
            }
        });
        assertTrue(isSuccess);
        assertNotNull(loJson);
    }

    @Test
    public void savePromotions() throws Exception{
        poSystem.SavePromotions(loJson);
    }

    @Test @UiThread
    public void getPromotions() {
        poSystem.GetPromotions().observeForever(ePromos -> assertEquals(1, ePromos.size()));
    }

    @Test
    public void downloadNewsEvents() throws Exception{
        poSystem.DownloadNewsEvents(new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                try {
                    isSuccess = true;
                    loJson = new JSONObject(args);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void OnFailed(String message) {
                isSuccess = false;
            }
        });
        assertTrue(isSuccess);
        assertNotNull(loJson);
    }

    @Test
    public void saveNewsEvents() throws Exception{
        poSystem.SaveNewsEvents(loJson);
    }

    @Test @UiThread
    public void getNewsEvents() {
        poSystem.GetNewsEvents().observeForever(eEvents -> assertEquals(1, eEvents.size()));
    }
}