package org.rmj.g3appdriver.GCardCore;

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
    public void test01() {

    }

    @Test
    public void testNullPointerMethods() throws Exception{

    }
}