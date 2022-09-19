package org.guanzongroup.com.creditapp;

import static org.junit.Assert.assertTrue;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.guanzongroup.com.creditapp.Obj.MpCreditApp;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.etc.AppConstants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class TestCreditAppObj {
    private static final String TAG = TestCreditAppObj.class.getSimpleName();

    private MpCreditApp poApp;

    private static String psData;

    @Before
    public void setUp() throws Exception {
        poApp = new MpCreditApp();
    }

    @Test
    public void test01CreateObject() throws Exception{
        poApp.setDateApplied(new AppConstants().DATE_MODIFIED);
        poApp.setDateCreated(new AppConstants().DATE_MODIFIED);
        poApp.setUnitApplied("1");
        poApp.setModel("Sample");
        poApp.setUnitType("1");
        poApp.setDiscount("50");
        poApp.setAmortization("9000");
        poApp.setDownpayment("1500");
        poApp.setInstallmentTerm("");
        poApp.setMiscellaneousExpense("");

        psData = poApp.getData();

        Log.d(TAG, psData);
    }

    @Test
    public void test02SetPersonalInfo() throws Exception{
        poApp.setData(psData);
        poApp.clientInfo().setLastName("Garcia");
        poApp.clientInfo().setFirstName("Michael");
        poApp.clientInfo().setMiddleName("Permison");
        poApp.clientInfo().setGender("0");
        poApp.clientInfo().setCivilStatus("0");

        psData = poApp.getData();

        Log.d(TAG, psData);
    }

    @Test
    public void test03SetAddressInfo() throws Exception{
        poApp.setData(psData);
        poApp.clientInfo().addressInfo().setHouseNo("231");
        poApp.clientInfo().addressInfo().setAddress1("Sitio Tawi-Tawi");
        poApp.clientInfo().addressInfo().setBarangayID("211");
        poApp.clientInfo().addressInfo().setTownID("123");
        poApp.clientInfo().addressInfo().setProvinceID("0123");
        psData = poApp.getData();

        Log.d(TAG, psData);
    }

    @Test
    public void test04SetMeansInfo() throws Exception{
        poApp.setData(psData);
        poApp.meansInfo().setSourceCD("0");
        poApp.meansInfo().employment().setBusinessIndustry("Retail");
        poApp.meansInfo().employment().setPosition("Programmer");
        poApp.meansInfo().employment().setSalary("10000");

        psData = poApp.getData();
    }

    @Test
    public void test05SetOtherInfo() throws Exception{
        poApp.setData(psData);
        poApp.otherInfo().setOtherIncome("Freelancing");
        poApp.otherInfo().setEstimatedIncome("10000");
        poApp.otherInfo().setBankName("Secutiry Bank");
        poApp.otherInfo().setAccountType("Payroll");
        poApp.otherInfo().setFacebookAccount("mikegarcia8748");

        Log.d(TAG, poApp.getData());
    }
}
