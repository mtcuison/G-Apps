package org.rmj.g3appdriver.utils;

import android.content.Context;

import org.rmj.g3appdriver.etc.SharedPref;

public class WebApi {

    /**Main URL
     * WEB SERVER*/

    //TODO: create a function that will change the server for testing phase.
    private static String URL_MAIN;
    private SharedPref sharedPref;

    public WebApi(Context context){
        this.sharedPref = new SharedPref(context);
    }

    /**GCARD MANAGEMENT*/
    private static String URL_GCARD = "gcard/";

    /**ACCOUNT SECURITY*/
    private static String URL_SECURITY = "security/";

    /**MS MANAGEMENT*/
    private static String URL_MS = "ms/";

    private static String URL_MX = "mx/";

    /**WEB API
     * FOR CHECKING APP VERSION
     * THIS API IS APPLICABLE FOR ALL APP
     * INTEGSYS, GUANZON_APP, TELECOM*/
    public static String URL_CHECK_APP_VERSION = "https://restgk.guanzongroup.com.ph/gcard/ms/version_checker.php";
    public static String URL_ADD_NEW_GCARD = "https://restgk.guanzongroup.com.ph/gcard/ms/add_gcardnumber.php";
    public static String URL_IMPORT_PROMOLINK = "https://restgk.guanzongroup.com.ph/gcard/ms/import_promo_link.php";
    public static String URL_IMPORT_PLACE_ORDER = "https://restgk.guanzongroup.com.ph/gcard/ms/import_placed_orders.php";
    public static String URL_IMPORT_REDEEM_ITEMS = "https://restgk.guanzongroup.com.ph/gcard/ms/import_redeem_item.php";
    public static String URL_IMPORT_TRANSACTIONS_OFFLINE = "https://restgk.guanzongroup.com.ph/gcard/ms/import_trans_offline.php";
    public static String URL_IMPORT_TRANSACTIONS_ONLINE = "https://restgk.guanzongroup.com.ph/gcard/ms/import_trans_online.php";
    public static String URL_IMPORT_TRANSACTIONS_PREORDER = "https://restgk.guanzongroup.com.ph/gcard/ms/import_trans_preorder.php";
    public static String URL_IMPORT_TRANSACTIONS_REDEMPTION = "https://restgk.guanzongroup.com.ph/gcard/ms/import_trans_redemption.php";
    public static String URL_IMPORT_MC_REGISTRATION = "https://restgk.guanzongroup.com.ph/gcard/mx/import_registration.php";
    public static String URL_IMPORT_SERVICE = "https://restgk.guanzongroup.com.ph/gcard/mx/import_service.php";
    public static String URL_IMPORT_BRANCH = "https://restgk.guanzongroup.com.ph/gcard/ms/import_branch.php";
    public static String URL_IMPORT_GCARD = "https://restgk.guanzongroup.com.ph/gcard/ms/import_gcard.php";
    public static String URL_REQUEST_AVAIL_POINTS = "https://restgk.guanzongroup.com.ph/gcard/ms/request_avl_points.php";
    public static String URL_PLACE_ODER = "https://restgk.guanzongroup.com.ph/gcard/ms/place_order.php";
    public static String URL_CANCEL_ORDER = "https://restgk.guanzongroup.com.ph/gcard/ms/cancel_order_item.php";
    public static String URL_CHANGE_PASSWORD = "https://restgk.guanzongroup.com.ph/security/acctupdate.php";
    public static String URL_REQUEST_DEVICES = "https://restgk.guanzongroup.com.ph/security/acctdevice.php";
    public static String URL_IMPORT_EVENTS = "https://restgk.guanzongroup.com.ph/gcard/mx/import_events.php";
    public static String URL_CLIENT_LOGIN = "https://restgk.guanzongroup.com.ph/security/signin.php";

    public static String SEND_RESPONSE = "https://restgk.guanzongroup.com.ph/notification/send_response.php";
    public static String SEND_REQUEST = "https://restgk.guanzongroup.com.ph/notification/send_request.php";

;

}
