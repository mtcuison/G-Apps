package org.rmj.guanzongroup.appcore.GCardCore;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GCardSystemTest {

    private Context mContext;
    private iGCardSystem poSystem;

    private boolean isSuccess = false;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {

    }

    @Test
    public void testNullPointerMethods() throws Exception{
        try {
            poSystem.DownloadTransactions(new GCardSystem.GCardSystemCallback() {
                @Override
                public void OnSuccess(String args) {

                }

                @Override
                public void OnFailed(String message) {

                }
            });
            isSuccess = false;
        } catch (Exception e){
            e.printStackTrace();
            isSuccess = true;
        }
        assertTrue(isSuccess);
    }
}