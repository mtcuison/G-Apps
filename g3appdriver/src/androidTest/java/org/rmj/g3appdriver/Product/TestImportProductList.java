package org.rmj.g3appdriver.Product;

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
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class TestImportProductList {

    private Context mContext;
    private RProduct poProdct;

    private List<EProducts> loList;
    private boolean isSuccess = false;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
        poProdct = new RProduct(mContext);
        new GuanzonAppConfig(mContext).setTestCase(true);
    }

    @Test
    public void test01ImportProducts() throws Exception{
        isSuccess = poProdct.ImportProductList();
        assertTrue(isSuccess);
    }

    @Test
    public void test02GetProductList() throws Exception{
        poProdct.GetProductList(10).observeForever(new Observer<List<EProducts>>() {
            @Override
            public void onChanged(List<EProducts> eProducts) {
                loList = eProducts;
            }
        });
        assertNotNull(loList);
    }
}
