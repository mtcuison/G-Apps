package org.rmj.g3appdriver.Etc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddress;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class AddressListTest {

    private Context mContext;
    private RAddress poAddress;

    private boolean isSuccess = false;
    private List<DAddress.oTownObj> poTownList;
    private List<EBarangayInfo> poBrgyList;
    private String message = "";

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() throws Exception{
        mContext = ApplicationProvider.getApplicationContext();
        poAddress = new RAddress(mContext);
    }

    @Test
    public void test01DownloadBarangay(){
        isSuccess = poAddress.ImportBarangayList();
        assertTrue(isSuccess);
    }

    @Test
    public void test02DownloadTown(){
        isSuccess = poAddress.ImportTownList();
        assertTrue(isSuccess);
    }

    @Test
    public void test03DownloadProvince(){
        isSuccess = poAddress.ImportProvinceList();
        assertTrue(isSuccess);
    }

    @Test
    public void test04GetTownProvinceList(){
        poAddress.GetTownList().observeForever(new Observer<List<DAddress.oTownObj>>() {
            @Override
            public void onChanged(List<DAddress.oTownObj> oTownObjs) {
                poTownList = oTownObjs;
            }
        });
        assertNotNull(poTownList);
        assertTrue(poTownList.size() > 0);
    }

    @Test
    public void test05GetBarangayList(){
        poAddress.GetBarangayList("0346").observeForever(new Observer<List<EBarangayInfo>>() {
            @Override
            public void onChanged(List<EBarangayInfo> eBarangayInfos) {
                poBrgyList = eBarangayInfos;
            }
        });
        assertNotNull(poBrgyList);
        assertTrue(poBrgyList.size() > 0);
    }
}
