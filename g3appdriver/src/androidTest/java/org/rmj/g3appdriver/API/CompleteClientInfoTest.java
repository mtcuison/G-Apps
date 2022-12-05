package org.rmj.g3appdriver.API;

import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class CompleteClientInfoTest {
    private static final String TAG = CompleteClientInfoTest.class.getSimpleName();
    private Context mContext;

    private RClientInfo poClient;

    private static boolean isSuccess = false;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        new GuanzonAppConfig(mContext).setTestCase(true);
        poClient = new RClientInfo(mContext);
    }

    @Test
    public void test01CompleteAccountAPI() throws Exception{
        EClientInfo loClient = new EClientInfo();
        loClient.setUserIDxx("GAP0190554");
        loClient.setLastName("Garcia");
        loClient.setFrstName("Michael");
        loClient.setMiddName("Permison");
        loClient.setSuffixNm("");
        loClient.setMaidenNm("Teresita Malanum Permison");
        loClient.setGenderCd("0");
        loClient.setCvilStat("0");
        loClient.setCitizenx("1");
        loClient.setBirthDte("1996-11-26");
        loClient.setBirthPlc("0346");
        loClient.setHouseNo1("231");
        loClient.setAddress1("Sitio Tawi Tawi");
        loClient.setBrgyIDx1("1100170");
        loClient.setTownIDx1("0346");
        loClient.setHouseNo2("231");
        loClient.setAddress2("Sitio Tawi Tawi");
        loClient.setBrgyIDx2("1100170");
        loClient.setTownIDx2("0346");
        isSuccess = poClient.CompleteClientInfo(loClient);
        if(!isSuccess){
            Log.e(TAG, poClient.getMessage());
        }
        assertTrue(isSuccess);
    }
}
