package org.rmj.g3appdriver.Etc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;
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
        poApp.disbursementInfo().bankInfo().setAccountType("0");
        poApp.disbursementInfo().bankInfo().setBankName("BDO");

        Log.d(TAG, poApp.getData());
    }

    @Test
    public void test06SetMpCreditApp() throws Exception{
        String lsData = "{\"dAppliedx\":\"2022-09-20\",\"dCreatedx\":\"2022-09-20 01:16:37\",\"cUnitAppl\":\"1\",\"sModelIDx\":\"Samsung\",\"cUnitType\":\"1\",\"nDiscount\":\"50\",\"nAmortztn\":\"16000\",\"nDwnpymnt\":\"1500\",\"sInstlTrm\":\"\",\"sMiscExpn\":\"\",\"personal_info\":{\"sLastName\":\"Garcia\",\"sFrstName\":\"Michael\",\"sMiddName\":\"Permison\",\"sSuffixxx\":\"\",\"cCvilStat\":\"0\",\"cGenderxx\":\"0\",\"sMaidenNm\":\"\",\"sFBAcctxx\":\"\",\"address\":{\"sLandMark\":\"\",\"sHouseNox\":\"231\",\"sAddress1\":\"Sitio Tawi-Tawi\",\"sAddress2\":\"\",\"sBrgyIDxx\":\"211\",\"sTownIDxx\":\"123\",\"sProvIDxx\":\"0123\"}},\"means_info\":{\"employed\":{\"sIndstWrk\":\"Retail\",\"sPosition\":\"Developer\",\"nSalaryxx\":\"10000\"},\"self_employed\":{},\"pensioner\":{},\"financed\":{},\"other_income\":{},\"cSourceCD\":\"0\"},\"disbursement_info\":{\"bank_account\":{\"sAcctType\":\"0\",\"sBankName\":\"BDO\"}}}";

        MpCreditApp loApp = new MpCreditApp();
        loApp.setData(lsData);
        Log.d(TAG, loApp.getData());
        assertEquals(lsData, loApp.getData());
    }
}
