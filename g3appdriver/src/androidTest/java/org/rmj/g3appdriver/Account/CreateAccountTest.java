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
public class CreateAccountTest {

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
        poConfig.setTestCase(false);
    }

    @Test
    public void test01createAccountTestNoLastName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter last name", poAccount.getMessage());
    }

    @Test
    public void test02createAccountTestNoFirstName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter first name", poAccount.getMessage());
    }

    @Test
    public void test03createAccountTestNoMiddleName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter middle name", poAccount.getMessage());
    }

    @Test
    public void test04createAccountTestNoEmail() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter email", poAccount.getMessage());
    }

    @Test
    public void test05createAccountTestNoPassword() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter password", poAccount.getMessage());
    }

    @Test
    public void test06createAccountTestPasswordTooShort() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("12345");
        poAccount.setPasswrd2("12345");
        poAccount.setMobileNo("");
        assertFalse(poAccount.isDataValid());
        assertEquals("Password is too short", poAccount.getMessage());
    }

    @Test
    public void test07createAccountTestPasswordNotMatch() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Passwords does not match", poAccount.getMessage());
    }

    @Test
    public void test08createAccountTestNoMobileNo() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter mobile no", poAccount.getMessage());
    }

    @Test
    public void test09createAccountTestInvalidMobileNo() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("0917187001");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must be 11 characters", poAccount.getMessage());
    }

    @Test
    public void test10createAccountTestInvalidMobileNo1() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("+639171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must start with '09'", poAccount.getMessage());
    }

    @Test
    public void test11createAccountTestInvalidMobileNo2() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("08171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must start with '09'", poAccount.getMessage());
    }


    @Test
    public void test12createAccountTestAccountAlreadyExist() throws Exception{
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Garcia");
        poAccount.setEmailAdd("garciamike8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");

        poLogin.RegisterAccount(poAccount, new AccountAuthentication.OnCreateAccountCallback() {
            @Override
            public void OnSuccessRegister(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedRegister(String fsMessage) {

                isSucccess = false;
                message = fsMessage;
            }
        });
        assertFalse(isSucccess);
        assertEquals("Email account was already registered", message);
    }

    @Test
    public void test13createAccountTestAccount() throws Exception{
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setUserName("Doe");
        poAccount.setEmailAdd("rmjbranchapps75@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");

        poLogin.RegisterAccount(poAccount, new AccountAuthentication.OnCreateAccountCallback() {
            @Override
            public void OnSuccessRegister(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedRegister(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });
        //this will return false and fail the test cause email use to test registration is already registered...
        assertTrue(isSucccess);
    }
}
