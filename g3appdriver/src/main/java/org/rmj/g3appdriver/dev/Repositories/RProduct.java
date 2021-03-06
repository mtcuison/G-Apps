package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.FilterType;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Account.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class RProduct {
    private static final String TAG = RProduct.class.getSimpleName();

    private final Context mContext;
    private final DProduct poDao;

    private JSONObject data;
    private String message;

    private final MutableLiveData<oFilterx> poProdType = new MutableLiveData<>();

    public RProduct(Context context){
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).prodctDao();
    }

    public JSONObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public boolean ImportProductList(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            params.put("bsearch", true);
            params.put("descript", "");
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportProducts(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    JSONArray laDetail = loResponse.getJSONArray("detail");
                    List<EProducts> loProdcts = new ArrayList<>();
                    for(int x = 0; x < laDetail.length(); x++){
                        JSONObject joDetail = laDetail.getJSONObject(x);
                        EProducts loProdct = new EProducts();
                        loProdct.setListngID(joDetail.getString("sListngID"));
                        loProdct.setBriefDsc(joDetail.getString("sBriefDsc"));
                        loProdct.setDescript(joDetail.getString("sDescript"));
                        loProdct.setBarCodex(joDetail.getString("xBarCodex"));
                        loProdct.setDescrptx(joDetail.getString("xDescript"));
                        loProdct.setBrandNme(joDetail.getString("xBrandNme"));
                        loProdct.setModelNme(joDetail.getString("xModelNme"));
                        loProdct.setColorNme(joDetail.getString("xColorNme"));
                        loProdct.setCategrNm(joDetail.getString("xCategrNm"));
                        loProdct.setTotalQty(joDetail.getString("nTotalQty"));
                        loProdct.setQtyOnHnd(joDetail.getString("nQtyOnHnd"));
                        loProdct.setResvOrdr(joDetail.getString("nResvOrdr"));
                        loProdct.setSoldQtyx(joDetail.getString("nSoldQtyx"));
                        loProdct.setUnitPrce(joDetail.getString("nUnitPrce"));
                        loProdct.setListStrt(joDetail.getString("dListStrt"));
                        loProdct.setListEndx(joDetail.getString("dListEndx"));
                        loProdct.setTranStat(joDetail.getString("cTranStat"));
                        loProdcts.add(loProdct);
                    }
                    poDao.SaveProductInfo(loProdcts);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<List<EProducts>> GetProductList(int fnIndex){
        return poDao.GetProductList(fnIndex);
    }

    public LiveData<EProducts> GetProductInfo(String fsListID){
        return poDao.GetProductInfo(fsListID);
    }

    public boolean GetProductRatings(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportReviewsAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    data = loResponse;
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean GetQuestionsAndAnswers(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getQuestionsAndAnswersAPI(),
                    new JSONObject().toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    data = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public void setFilterType(oFilterx foVal){
        this.poProdType.setValue(foVal);
    }

    public LiveData<oFilterx> GetFilterType(){
        return poProdType;
    }

    public LiveData<List<DProduct.oProduct>> GetProductsList(int fnIndex, FilterType foType, String fsArgs1, String fsArgs2){
        switch (foType){
            case PRICE_DESCENDING:
                return poDao.GetProductsListPriceSortDESC(fnIndex);
            case PRICE_ASCENDING:
                return poDao.GetProductsListPriceSortASC(fnIndex);
            case CATEGORY:
                return poDao.GetProductsListFilterCategory(fnIndex, fsArgs1);
            case BRAND_NAME:
                return poDao.GetProductsListFilterBrandName(fnIndex, fsArgs1);
            case PRICE_RANGE:
                return poDao.GetProductsListFilterPriceRange(fnIndex, fsArgs1, fsArgs2);
            default:
                return poDao.GetProductsList(fnIndex);
        }
    }

    public static class oFilterx{
        private final FilterType oFilter;
        private final String fnArgs1, fnArgs2;

        public oFilterx(FilterType oFilter, String fnArgs1, String fnArgs2) {
            this.oFilter = oFilter;
            this.fnArgs1 = fnArgs1;
            this.fnArgs2 = fnArgs2;
        }

        public FilterType getFilter() {
            return oFilter;
        }

        public String getArgs1() {
            return fnArgs1;
        }

        public String getArgs2() {
            return fnArgs2;
        }
    }
}
