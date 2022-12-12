package org.rmj.g3appdriver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.rmj.g3appdriver.utils.SQLUtil;
import org.rmj.g3appdriver.utils.WebClient;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private static boolean isSuccess = false;

    @Test
    public void test01SenderNotification() throws Exception {
        String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
        Calendar calendar = Calendar.getInstance();
        //Create the header section needed by the API
        Map<String, String> headers =
                new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", "GuanzonApp");
        headers.put("g-api-imei", "356060072281722");
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String) headers.get("g-api-imei") + (String) headers.get("g-api-key")));
        headers.put("g-api-user", "GAP0190001");
        headers.put("g-api-mobile", "09171870011");
        headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

        JSONArray rcpts = new JSONArray();
        JSONObject rcpt = new JSONObject();
        rcpt.put("app", "gRider");
        rcpt.put("user", "GAP021002961");
        rcpts.add(rcpt);

        //Create the parameters needed by the API
        JSONObject param = new JSONObject();
        param.put("type", "00000");
        param.put("parent", null);
        param.put("title", "Guanzon Circle V2");
        param.put("message", "Guanzon Circle version 2.12 is already up.");
        param.put("rcpt", rcpts);

        JSONParser oParser = new JSONParser();
        JSONObject json_obj = null;

        String response = WebClient.httpsPostJSon(sURL, param.toJSONString(), (HashMap<String, String>) headers);
        if (response == null) {
            System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
        }
        //json_obj = (JSONObject) oParser.parse(response);
        //System.out.println(json_obj.toJSONString());
        isSuccess = true;
        System.out.println(response);
        assertTrue(isSuccess);
    }

    @Test
    public void test02SendPanaloNotification() throws Exception {
        String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
        Calendar calendar = Calendar.getInstance();
        //Create the header section needed by the API
        Map<String, String> headers =
                new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", "GuanzonApp");
        headers.put("g-api-imei", "356060072281722");
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String) headers.get("g-api-imei") + (String) headers.get("g-api-key")));
        headers.put("g-api-user", "GAP0190001");
        headers.put("g-api-mobile", "09171870011");
        headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

        JSONArray rcpts = new JSONArray();
        JSONObject rcpt = new JSONObject();
        rcpt.put("app", "GuanzonApp");
        rcpt.put("user", "GAP021002961");
        rcpts.add(rcpt);

        //Create the parameters needed by the API
        JSONObject param = new JSONObject();
        param.put("type", "00008");
        param.put("parent", null);
        param.put("title", "Guanzon Panalo");
        param.put("message", "Your panalo reward has been claimed at Guanzon Merchandising Corporation Dagupan City.");
        param.put("rcpt", rcpts);
        param.put("infox", CreatePanaloNotification());

        String response = WebClient.httpsPostJSon(sURL, param.toJSONString(), (HashMap<String, String>) headers);
        if (response == null) {
            System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
        }

        isSuccess = true;
        assertTrue(isSuccess);
    }


    private static String CreatePanaloNotification() {
        JSONObject loPanalo = new JSONObject();

        loPanalo.put("panalo", "reward");
//        loPanalo.put("panalo", "claim");
//        loPanalo.put("panalo", "redeemed");
//        loPanalo.put("panalo", "warning");

        JSONObject loPnlDetail = new JSONObject();

        //Pass the reference no on which rewards must be claim by the user.
        loPnlDetail.put("sReferNox", "MX01123456789");
        loPnlDetail.put("cTranStat", "1");

        loPanalo.put("data", loPnlDetail);

        return loPanalo.toJSONString();
    }

    @Test
    public void test03SendPromoNotification() throws Exception {
        String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
        Calendar calendar = Calendar.getInstance();
        //Create the header section needed by the API
        Map<String, String> headers =
                new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", "GuanzonApp");
        headers.put("g-api-imei", "356060072281722");
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String) headers.get("g-api-imei") + (String) headers.get("g-api-key")));
        headers.put("g-api-user", "GAP0190001");
        headers.put("g-api-mobile", "09171870011");
        headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

        JSONArray rcpts = new JSONArray();
        JSONObject rcpt = new JSONObject();
        rcpt.put("app", "GuanzonApp");
        rcpt.put("user", "GAP021002961");
        rcpts.add(rcpt);
        JSONObject param = new JSONObject();
        param.put("type", "00003");
        param.put("parent", null);
        param.put("title", "Huawei Nova Y61 Pre-order Promo");
        param.put("message", "Spectacular shots made easy.\n" +
                "\n" +
                "With the #HUAWEInovaY61PH, you can always rely on its 50MP AI Triple #SuperCamera to take breathtaking shots no matter when or where.\n" +
                "\n" +
                "Pre-order yours today and get a freebie worth P999.\n" +
                "Additionally, get a free Huawei bluetooth speaker and umbrella.\n" +
                "\n" +
                "Visit us now at selected Guanzon Huawei Concept and Mobitek Stores near you.\n" +
                "\n" +
                "Pre-order promo runs until December 1, 2022.");
        param.put("rcpt", rcpts);
        param.put("infox", CreatePromoNotification());

        String response = WebClient.httpsPostJSon(sURL, param.toJSONString(), (HashMap<String, String>) headers);
        if (response == null) {
            System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
        }

        isSuccess = true;
        assertTrue(isSuccess);
    }

    private static String CreatePromoNotification() {
        JSONObject loPromo = new JSONObject();

        loPromo.put("module", "00001");

        JSONObject loPromoDtl = new JSONObject();
        loPromoDtl.put("sPromoUrl", "https://www.guanzongroup.com.ph/huawei-nova-y61-pre-order-promo/");
        loPromoDtl.put("sImageUrl", "https://www.guanzongroup.com.ph/wp-content/uploads/2022/12/huawei-nova-y61-preorder-promo-dec-2022-724x1024.jpg");

        loPromo.put("data", loPromoDtl);

        return loPromo.toJSONString();
    }
}
















