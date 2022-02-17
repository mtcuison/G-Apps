package org.rmj.guanzongroup.appcore.API;


import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.rmj.guanzongroup.appcore.Account.AccountAuthentication;
import org.rmj.guanzongroup.appcore.ServerRequest.HttpHeaders;
import org.rmj.guanzongroup.appcore.ServerRequest.WebClient;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class DataImportTest {

    private Context mContext;

    private static boolean isSuccess = false;

    @Before
    public void setUp() throws Exception {
        mContext = ApplicationProvider.getApplicationContext();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test01LoginAccount() throws Exception{
        AccountAuthentication loAuth = new AccountAuthentication(mContext);
        loAuth.LoginAccount(new AccountAuthentication.LoginCredentials("mikegarcia8748@gmail.com", "12345678", "09270359402"), new AccountAuthentication.OnLoginCallback() {
            @Override
            public void OnSuccessLogin(String message) {
                isSuccess = true;
            }

            @Override
            public void OnFailedLogin(String message) {
                isSuccess = false;
            }
        });

        assertTrue(isSuccess);
    }

    @Test
    public void test02DownloadBranch() throws Exception{
        String lsAddress = "http://192.168.10.141/gcard/mx/import_branch.php";

        String lsResponse = WebClient.httpsPostJSon(lsAddress, new JSONObject().toString(), new HttpHeaders(mContext).getHeaders());
        if(lsResponse == null){
            isSuccess = false;
        } else {
            JSONObject loJson = new JSONObject(lsResponse);
            if(loJson.getString("result").equalsIgnoreCase("success")){
                JSONArray laJson = loJson.getJSONArray("detail");
                JSONObject loDetail = laJson.getJSONObject(0);
                String cRecdStat = loDetail.getString("cRecdStat");
                String dTimeStmp = loDetail.getString("dTimeStmp");
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        }
        assertTrue(isSuccess);
    }

}
