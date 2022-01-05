package org.rmj.guanzongroup.appcore.GCardCore;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemRedemptionManagerTest {

    private Context mContext;
    public ItemRedemptionManager poItem;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poItem = new ItemRedemptionManager(mContext);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isPointsValid() {

    }
}