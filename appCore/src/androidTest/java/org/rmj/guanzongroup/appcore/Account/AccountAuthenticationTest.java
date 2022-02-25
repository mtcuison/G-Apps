package org.rmj.guanzongroup.appcore.Account;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.guanzongroup.appcore.Etc.SessionManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class AccountAuthenticationTest {

    private Context mContext;
    private AccountAuthentication poLogin;
    private AccountAuthentication.LoginCredentials poCredentials;
    private AccountAuthentication.AccountCredentials poAccount;

    private boolean isSucccess = false;
    private String message = "";

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poLogin = new AccountAuthentication(mContext);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test01createAccountTestNoLastName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter last name", poAccount.getMessage());
    }

    @Test
    public void test02createAccountTestNoFirstName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter first name", poAccount.getMessage());
    }

    @Test
    public void test03createAccountTestNoMiddleName() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter middle name", poAccount.getMessage());
    }

    @Test
    public void test04createAccountTestNoEmail() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
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
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter password", poAccount.getMessage());
    }

    @Test
    public void test06createAccountTestPasswordTooShort() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("12345");
        poAccount.setPasswrd2("12345");
        poAccount.setMobileNo("");
        assertFalse(poAccount.isDataValid());
        assertEquals("Password is too short", poAccount.getMessage());
    }

    @Test
    public void test07createAccountTestPasswordNotMatch() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("09171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Passwords does not match", poAccount.getMessage());
    }

    @Test
    public void test08createAccountTestNoMobileNo() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("123456");
        poAccount.setPasswrd2("123456");
        poAccount.setMobileNo("");
        assertFalse(poAccount.isDataValid());
        assertEquals("Please enter mobile no", poAccount.getMessage());
    }

    @Test
    public void test09createAccountTestInvalidMobileNo() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("0917187001");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must be 11 characters", poAccount.getMessage());
    }

    @Test
    public void test10createAccountTestInvalidMobileNo1() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("+639171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must start with '09'", poAccount.getMessage());
    }

    @Test
    public void test11createAccountTestInvalidMobileNo2() {
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
        poAccount.setPassword("1234567");
        poAccount.setPasswrd2("1234567");
        poAccount.setMobileNo("08171870011");
        assertFalse(poAccount.isDataValid());
        assertEquals("Mobile number must start with '09'", poAccount.getMessage());
    }

    @Test
    public void test12createAccountTestAccountAlreadyExist() throws Exception{
        poAccount = new AccountAuthentication.AccountCredentials();
        poAccount.setLastName("Garcia");
        poAccount.setFrstName("Michael");
        poAccount.setMiddName("Permison");
        poAccount.setEmailAdd("mikegarcia8748@gmail.com");
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
        poAccount.setLastName("Team");
        poAccount.setFrstName("MIS");
        poAccount.setMiddName("Android");
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

    @Test
    public void test14credentialsValidationTest() {
        poCredentials = new AccountAuthentication.LoginCredentials("", "", "09171870011");
        assertFalse(poCredentials.isDataValid());
        assertEquals("Please enter email", poCredentials.getMessage());
    }

    @Test
    public void test15credentialsValidationTestNoEmail() {
        poCredentials = new AccountAuthentication.LoginCredentials("", "123456", "09171870011");
        assertFalse(poCredentials.isDataValid());
        assertEquals("Please enter email", poCredentials.getMessage());
    }

    @Test
    public void test16credentialsValidationTestNoPassword() {
        poCredentials = new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "", "09171870011");
        assertFalse(poCredentials.isDataValid());
        assertEquals("Please enter password", poCredentials.getMessage());
    }

    @Test
    public void test17credentialsValidationTestInvalidMobileNo() {
        poCredentials = new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "123456", "+639171870011");
        assertFalse(poCredentials.isDataValid());
        assertEquals("Mobile number must start with '09'", poCredentials.getMessage());
    }

    @Test
    public void test18credentialsValidationTestLessMobileNo() {
        poCredentials = new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "123456", "0917187001");
        assertFalse(poCredentials.isDataValid());
        assertEquals("Mobile number must be 11 characters", poCredentials.getMessage());
    }

    @Test
    public void test19LoginAccountTest() throws Exception{
        AccountAuthentication loAuth = new AccountAuthentication(mContext);
        loAuth.LoginAccount(new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "12345678", "09270359402"), new AccountAuthentication.OnLoginCallback() {
            @Override
            public void OnSuccessLogin(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedLogin(String message) {
                isSucccess = false;
            }
        });

        assertTrue(isSucccess);
    }

    @Test
    public void test20LoginAccountTestIncorrectPassword() throws Exception{
        AccountAuthentication loAuth = new AccountAuthentication(mContext);
        loAuth.LoginAccount(new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "qwerty123", "09270359402"), new AccountAuthentication.OnLoginCallback() {
            @Override
            public void OnSuccessLogin(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedLogin(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });

        assertFalse(isSucccess);
        assertEquals("Invalid password detected.", message);
    }

    @Test
    public void test21LoginAccountTest() throws Exception{
        AccountAuthentication loAuth = new AccountAuthentication(mContext);
        loAuth.LoginAccount(new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "12345678", "09270359402"), new AccountAuthentication.OnLoginCallback() {
            @Override
            public void OnSuccessLogin(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedLogin(String fsMessage) {
                isSucccess = false;
            }
        });

        assertFalse(isSucccess);
    }

    @Test
    public void test22SessionManageAfterLoginTest() throws Exception{
        AccountInfo loSession = new AccountInfo(mContext);
        String lsUserIDx = loSession.getUserID();
        String lsEmailxx = loSession.getEmailAdd();
        String lsUserNme = loSession.getFullName();
        String lsMobilex = loSession.getMobileNo();
//        String lsCreated = loSession.getDateCreated();

        assertEquals("GAP0190554", lsUserIDx);
        assertEquals("mikegarcia8748@gmail.com", lsEmailxx);
        assertEquals("Doe, Garcia Michael ", lsUserNme);
        assertEquals("09270359402", lsMobilex);
//        assertEquals("2019-08-28 09:20:25", lsCreated);
    }

    @Test
    public void test23LoginAccountTestInvalidEmail() throws Exception{
        AccountAuthentication loAuth = new AccountAuthentication(mContext);
        loAuth.LoginAccount(new AccountAuthentication.LoginCredentials("garciamike8748@gmail.com", "qwerty123", "09270359402"), new AccountAuthentication.OnLoginCallback() {
            @Override
            public void OnSuccessLogin(String message) {
                isSucccess = true;
            }

            @Override
            public void OnFailedLogin(String fsMessage) {
                isSucccess = false;
                message = fsMessage;
            }
        });

        assertFalse(isSucccess);
        assertEquals("Invalid email detected.", message);
    }

    @Test
    public void test24ForgotPasswordTestNoEmail() throws Exception{
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
    public void test25ForgotPasswordTestInvalidEmail() throws Exception{
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

        assertFalse(isSucccess);
        assertEquals("Invalid account detected.", message);
    }

    @Test
    public void test26ForgotPasswordTest() throws Exception{
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