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
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class UpdateClientAddressTest {
    private static final String TAG = UpdateClientAddressTest.class.getSimpleName();
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
    public void test01UpdateClientAddressAPI() throws Exception{
//        RClientInfo.AddressUpdate loAddress = new RClientInfo.AddressUpdate(true);
//        loAddress.setHouseNo("231");
//        loAddress.setAddress("Sitio Tawi Tawi");
//        loAddress.setBrgyID("1100170");
//        loAddress.setTownID("0346");
//        isSuccess = poClient.UpdateAddress(loAddress);
//        if(!isSuccess){
//            Log.e(TAG, poClient.getMessage());
//        }
//        assertTrue(isSuccess);
    }
}
