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
    public String URL_CHECK_APP_VERSION(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "version_checker.php";
    }

    /**FOR ADDING NEW GCARD NUMBER*/
    public String URL_ADD_NEW_GCARD(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "add_gcardnumber.php";
    }

    /**FOR IMPORTING PROMO LINKS AND IMAGES*/
    public String URL_IMPORT_PROMOLINK(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_promo_link.php";
    }

    /**FOR IMPORTING PLACE ORDERS*/
    public String URL_IMPORT_PLACE_ORDER(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_placed_orders.php";
    }

    /**FOR IMPORTING REDEEMABLES*/
    public String URL_IMPORT_REDEEM_ITEMS(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_redeem_item.php";
    }

    /**FOR IMPORTING TRANSACTIONS OFFLINE*/
    public String URL_IMPORT_TRANSACTIONS_OFFLINE(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_trans_offline.php";
    }

    /**FOR IMPORTING TRANSACTIONS ONLINE*/
    public String URL_IMPORT_TRANSACTIONS_ONLINE(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_trans_online.php";
    }

    /**FOR IMPORTING TRANSACTIONS PRE-ORDER*/
    public String URL_IMPORT_TRANSACTIONS_PREORDER(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_trans_preorder.php";
    }

    /**FOR IMPORTING TRANSACTIONS REDEMPTION*/
    public String URL_IMPORT_TRANSACTIONS_REDEMPTION(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_trans_redemption.php";
    }

    /**FOR IMPORTING MC REGISTRATION NOTICE*/
    public String URL_IMPORT_MC_REGISTRATION(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MX + "import_registration.php";
    }

    /**FOR REQUESTING MC SERVICE STATUS*/
    public String URL_IMPORT_SERVICE(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MX + "import_service.php";
    }

    /**FOR IMPORTING GUANZON MC AND MP BRANCHES*/
    public String URL_IMPORT_BRANCH(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_branch.php";
    }

    /**FOR IMPORTING USER GCARD*/
    public String URL_IMPORT_GCARD(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "import_gcard.php";
    }

    /**FOR REQUESTING AVAILABLE POINTS*/
    public String URL_REQUEST_AVAIL_POINTS(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "request_avl_points.php";
    }

    /**FOR PLACING A PRE ORDER TRANSACTION*/
    public String URL_PLACE_ODER(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "place_order.php";
    }

    /**FOR CANCELING PLACE ORDER*/
    public String URL_CANCEL_ORDER(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MS + "cancel_order_item.php";
    }

    /**FOR ACCOUNT SETTINGS CHANGING PASSWORD*/
    public String URL_CHANGE_PASSWORD(){
        return sharedPref.getAppServer() + URL_SECURITY + "/acctupdate.php";
    }

    /**FOR ACCOUNT SETTINGS REQUEST LOGIN DEVICES*/
    public String URL_REQUEST_DEVICES(){
        return sharedPref.getAppServer() + URL_SECURITY + "/acctdevice.php";
    }

    /** For importing events*/
    public String URL_IMPORT_EVENTS(){
        return sharedPref.getAppServer() + URL_GCARD + URL_MX + "import_events.php";
    }
    public static String URL_IMPORT_BRANCHES = "https://restgk.guanzongroup.com.ph/integsys/param/download_branch.php";

}
