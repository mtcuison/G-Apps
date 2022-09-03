package org.rmj.g3appdriver.Etc;

import static junit.framework.TestCase.assertEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;

public class AppConfigPreferenceTest {

    private Context mContext;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
    }

    @Test
    public void setAppToken() {
    }
}