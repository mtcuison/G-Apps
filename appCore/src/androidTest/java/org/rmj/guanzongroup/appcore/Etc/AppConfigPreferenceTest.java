package org.rmj.guanzongroup.appcore.Etc;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;

public class AppConfigPreferenceTest {

    private Context mContext;
    private AppConfigPreference poConfig;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poConfig = new AppConfigPreference(mContext);
    }

    @Test
    public void setAppToken() {
        poConfig.setAppToken("sample");
        assertEquals("sample", poConfig.getAppToken());
    }
}