package org.rmj.guanzongroup.guanzonapp.Utils;

import android.annotation.SuppressLint;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.Http.WebClient;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AppVersion {

    private Context context;
    private RequestHeaders apiHeaders;
    private ConnectionUtil connectionChecker;

    private String curr_Version = BuildConfig.VERSION_NAME;
    private String result = "";
    private String message = "";
    private String response = null;

    public AppVersion(Context context){
        this.context = context;
        this.connectionChecker = new ConnectionUtil(context);
    }

    public void checkVersion(){
        if(connectionChecker.isDeviceConnected()) {
            checkOnlineVersion();
        } else {
            result = "updated";
        }
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    @SuppressLint("NewApi")
    private void checkOnlineVersion(){
        apiHeaders = new RequestHeaders(context);
        try{
            JSONObject params = new JSONObject();
            params.put("version", curr_Version);

            response = WebClient.httpsPostJSon(new WebApi(context).URL_CHECK_APP_VERSION(), params.toString(), (HashMap<String, String>) apiHeaders.getHeaders());

            if(response == null){
                result = "error";
                message = "Unable to check updates. Server connection is not establish";
            } else {
                JSONObject jsonResponse = new JSONObject(response);
                String result1 = jsonResponse.getString("result");
                if(result1.equalsIgnoreCase("success")){
                    String version = jsonResponse.getString("version");
                    int sVersion = getIntVersion(version);
                    int cur_version = getIntVersion(curr_Version);
                    if(sVersion>cur_version) {
                        String updateLevel = jsonResponse.getString("level");
                        if (updateLevel.equalsIgnoreCase("1")) {
                            result = "outdated";
                        } else {
                            result = "updated";
                        }
                    } else {
                        result = "updated";
                    }
                } else {
                    result = "error";
                    message = "unable to check for updates unknown server error occurred";
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getIntVersion(String version){
        ArrayList<Integer> list = new ArrayList();
        String[] laVersion = version.split("\\.");
        for(int x = 0; x < laVersion.length; x++) {
            list.add(Integer.valueOf(laVersion[x]));
        }
        return list.get(2);
    }
}
