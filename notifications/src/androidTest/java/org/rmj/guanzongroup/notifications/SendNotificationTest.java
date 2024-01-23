package org.rmj.guanzongroup.notifications;

import static okhttp3.internal.Internal.instance;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.SecUtil;
import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
import org.rmj.g3appdriver.utils.SQLUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SendNotificationTest {
    private static String createJSON() throws Exception{
        JSONObject loJSON = new JSONObject();
        JSONObject loData = new JSONObject();

        loJSON.put("module", "00001");

        loData.put("table", "xxxSysConfig");

        JSONObject loKey = new JSONObject();
        loKey.put("sConfigCd", "dcp.coordinates.capturing.interval");
        loData.put("key", loKey);

        JSONObject loFields = new JSONObject();
        loFields.put("sConfigDs", "Capture collector coordinates with this interval.");
        loFields.put("sConfigVl", "15");
        loData.put("fields", loFields);

        loJSON.put("data", loData);

        return loJSON.toString();
    }

    private static String createBranchOpeningMessage() throws Exception{
        JSONObject loJSON = new JSONObject();

        loJSON.put("module", "00002");

        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();

        JSONObject loFields = new JSONObject();
        loFields.put("mktpl", "003");
        loFields.put("sOrderIDx", "MX011234560986");
//        loFields.put("sTimeOpen", "08:00 AM");
//        loFields.put("sOpenNowx", "07:45 AM");
////        loFields.put("sOpenNowx", time.format(now));
//        loFields.put("dSendDate", "2020-12-16");
//        loFields.put("dNotified", dtf.format(now));
//        loFields.put("dTimeStmp", dtf.format(now));

        loJSON.put("data", loFields);

        return loJSON.toString();
    }

    @Before
    public void setupTest(){

    }

    @Test
    public void test01SendNotification() throws Exception{
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
        headers.put("g-api-hash", SecUtil.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-user", "GAP0190001");
        headers.put("g-api-mobile", "09171870011");
        headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

        JSONArray rcpts = new JSONArray();
        JSONObject rcpt = new JSONObject();
        rcpt.put("app", "GuanzonApp");
        rcpt.put("user", "GAP021003575");
        rcpts.put(rcpt);
//        GAP021003575 GAP0190554

        for(int x = 0; x < 1; x++){
            //Create the parameters needed by the API
            JSONObject param = new JSONObject();
            param.put("type", "00000");
            param.put("parent", null);
            param.put("title", "Out for Delivery");
            param.put("message", "Your Order No. MX011234560986 will be delivered by our courier. Please prepare an amount of Php. 10,000 for your payment.");
            param.put("rcpt", rcpts);
            param.put("infox", createBranchOpeningMessage());

            JSONObject json_obj = null;

            String response = WebClient.httpsPostJSon(sURL, param.toString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }
            //json_obj = (JSONObject) oParser.parse(response);
            //System.out.println(json_obj.toJSONString());

            System.out.println(response);
        }
    }
}
