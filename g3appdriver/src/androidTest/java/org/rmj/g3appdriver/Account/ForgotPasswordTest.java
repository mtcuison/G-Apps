package org.rmj.g3appdriver.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Account.AccountAuthentication;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class ForgotPasswordTest {


    private Context mContext;
    private AccountAuthentication poLogin;
    private AccountAuthentication.LoginCredentials poCredentials;
    private AccountAuthentication.AccountCredentials poAccount;
    private GuanzonAppConfig poConfig;

    private boolean isSucccess = false;
    private String message = "";

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poLogin = new AccountAuthentication(mContext);
        poConfig = new GuanzonAppConfig(mContext);
        poConfig.setTestCase(true);
    }

    @Test
    public void test01ForgotPasswordTestNoEmail() throws Exception{
        poLogin.RetrievePassword("", new AccountAuthentication.OnRetrievePasswordCallback() {
            @Override
            public void OnSuccessRetrieve(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedRetrieve(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });

        assertFalse(isSucccess);
        assertEquals("Please enter email.", message);
    }

    @Test
    public void test02ForgotPasswordTestInvalidEmail() throws Exception{
        poLogin.RetrievePassword("mikegarcia87@gmail.com", new AccountAuthentication.OnRetrievePasswordCallback() {
            @Override
            public void OnSuccessRetrieve(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedRetrieve(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });

        assertFalse(isSucccess);
        assertEquals("Invalid account detected.", message);
    }

    @Test
    public void test03ForgotPasswordTest() throws Exception{
        poLogin.RetrievePassword("garciamike8748@gmail.com", new AccountAuthentication.OnRetrievePasswordCallback() {
            @Override
            public void OnSuccessRetrieve(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedRetrieve(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });
        assertTrue(isSucccess);
    }
}
