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
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.FilterType;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class TestImportPreviewFilter {

    private Context mContext;
    private RProduct poProdct;

    private List<DProduct.oProduct> loList;
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
        poProdct.GetProductList(0).observeForever(new Observer<List<EProducts>>() {
            @Override
            public void onChanged(List<EProducts> eProducts) {
                if(eProducts.size() > 0){
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            }
        });
    }

    @Test
    public void test02GetProductsList() throws Exception{
        poProdct.setFilterType(new RProduct.oFilterx(FilterType.DEFAULT, null, null));
        poProdct.GetFilterType().observeForever(new Observer<RProduct.oFilterx>() {
            @Override
            public void onChanged(RProduct.oFilterx oFilterx) {
                poProdct.GetProductsList(0, oFilterx.getFilter(), oFilterx.getArgs1(), oFilterx.getArgs2()).observeForever(new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        loList = oProducts;
                    }
                });
            }
        });
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }

    @Test
    public void test03GetProductsPriceASC() throws Exception{
        poProdct.setFilterType(new RProduct.oFilterx(FilterType.PRICE_ASCENDING, null, null));
        poProdct.GetFilterType().observeForever(new Observer<RProduct.oFilterx>() {
            @Override
            public void onChanged(RProduct.oFilterx oFilterx) {
                poProdct.GetProductsList(0, oFilterx.getFilter(), oFilterx.getArgs1(), oFilterx.getArgs2()).observeForever(new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        loList = oProducts;
                    }
                });
            }
        });
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }

    @Test
    public void test04GetProductsPriceDESC() throws Exception{
        poProdct.setFilterType(new RProduct.oFilterx(FilterType.PRICE_DESCENDING, null, null));
        poProdct.GetFilterType().observeForever(new Observer<RProduct.oFilterx>() {
            @Override
            public void onChanged(RProduct.oFilterx oFilterx) {
                poProdct.GetProductsList(0, oFilterx.getFilter(), oFilterx.getArgs1(), oFilterx.getArgs2()).observeForever(new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        loList = oProducts;
                    }
                });
            }
        });
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }

    @Test
    public void test05GetProductsFilterBrandName() throws Exception{
        poProdct.setFilterType(new RProduct.oFilterx(FilterType.BRAND_NAME, "OPPO", null));
        poProdct.GetFilterType().observeForever(new Observer<RProduct.oFilterx>() {
            @Override
            public void onChanged(RProduct.oFilterx oFilterx) {
                poProdct.GetProductsList(0, oFilterx.getFilter(), oFilterx.getArgs1(), oFilterx.getArgs2()).observeForever(new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        loList = oProducts;
                    }
                });
            }
        });
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }

    @Test
    public void test06GetProductsPriceRange() throws Exception{
        poProdct.setFilterType(new RProduct.oFilterx(FilterType.PRICE_RANGE, "12000", "30000"));
        poProdct.GetFilterType().observeForever(new Observer<RProduct.oFilterx>() {
            @Override
            public void onChanged(RProduct.oFilterx oFilterx) {
                poProdct.GetProductsList(0, oFilterx.getFilter(), oFilterx.getArgs1(), oFilterx.getArgs2()).observeForever(new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        loList = oProducts;
                    }
                });
            }
        });
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }

    @Test
    public void test07SearchProduct() throws Exception{
        poProdct.SearchProducts("Samsung").observeForever(oProducts -> loList = oProducts);
        assertNotNull(loList);
        assertTrue(loList.size()>0);
    }
}
