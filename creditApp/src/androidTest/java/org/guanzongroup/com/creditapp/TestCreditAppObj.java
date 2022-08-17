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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class TestCreditAppObj {
    private static final String TAG = TestCreditAppObj.class.getSimpleName();

    private MpCreditApp poApp;

    @Before
    public void setUp() throws Exception {
        poApp = new MpCreditApp();
    }

    @Test
    public void test01CreateObject() throws Exception{
        poApp.setModel("Sample");
        poApp.setUnitType("1");
        poApp.setDiscount("50");
        poApp.setAmortization("9000");
        poApp.setDownpayment("1500");
        poApp.setInstallmentTerm("");
        poApp.setMiscellaneousExpense("");

        Log.d(TAG, poApp.getData());
    }

    @Test
    public void test02SetPersonalInfo() throws Exception{
        poApp.clientInfo().setLastName("Garcia");
        poApp.clientInfo().setFirstName("Michael");
        poApp.clientInfo().setMiddleName("Permison");
        poApp.clientInfo().setGender("0");
        poApp.clientInfo().setCivilStatus("0");

        Log.d(TAG, poApp.getData());
    }

    @Test
    public void test03SetAddressInfo() throws Exception{
        poApp.addressInfo().setHouseNo("231");
        poApp.addressInfo().setAddress("Sitio Tawi-Tawi");
        poApp.addressInfo().setBarangayID("211");
        poApp.addressInfo().setTownID("123");
        poApp.addressInfo().setProvinceID("0123");
        poApp.addressInfo().setBarangayName("Bantayan");
        poApp.addressInfo().setTownName("Mangaldan");
        poApp.addressInfo().setProvinceName("Pangasinan");

        Log.d(TAG, poApp.getData());
    }

    @Test
    public void test04SetMeansInfo() throws Exception{
        poApp.meansInfo().setIndustry("Retail");
        poApp.meansInfo().setCompanyName("Guanzon");
        poApp.meansInfo().setPosition("Programmer");
        poApp.meansInfo().setSourceCD("0");
        poApp.meansInfo().setSalary("10000");

        boolean isSuccess = poApp.isDataValid();
        Log.d(TAG, poApp.getData());

        assertTrue(isSuccess);
    }

    @Test
    public void test05SetOtherInfo() throws Exception{
        poApp.setModel("Sample");
        poApp.setUnitType("1");
        poApp.setDiscount("50");
        poApp.setAmortization("9000");
        poApp.setDownpayment("1500");
        poApp.setInstallmentTerm("");
        poApp.setMiscellaneousExpense("");

        poApp.clientInfo().setLastName("Garcia");
        poApp.clientInfo().setFirstName("Michael");
        poApp.clientInfo().setMiddleName("Permison");
        poApp.clientInfo().setGender("0");
        poApp.clientInfo().setCivilStatus("0");

        poApp.addressInfo().setHouseNo("231");
        poApp.addressInfo().setAddress("Sitio Tawi-Tawi");
        poApp.addressInfo().setBarangayID("211");
        poApp.addressInfo().setTownID("123");
        poApp.addressInfo().setProvinceID("0123");
        poApp.addressInfo().setBarangayName("Bantayan");
        poApp.addressInfo().setTownName("Mangaldan");
        poApp.addressInfo().setProvinceName("Pangasinan");

        poApp.meansInfo().setIndustry("Retail");
        poApp.meansInfo().setCompanyName("Guanzon");
        poApp.meansInfo().setPosition("Programmer");
        poApp.meansInfo().setSourceCD("0");
        poApp.meansInfo().setSalary("10000");

        boolean isSuccess = poApp.isDataValid();
        Log.d(TAG, poApp.getData());

        assertTrue(isSuccess);
    }
}
