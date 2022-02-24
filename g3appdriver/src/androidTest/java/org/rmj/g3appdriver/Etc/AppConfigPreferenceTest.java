package org.rmj.g3appdriver.Etc;

import static junit.framework.TestCase.assertEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.rmj.g3appdriver.etc.AppConfigPreference;

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