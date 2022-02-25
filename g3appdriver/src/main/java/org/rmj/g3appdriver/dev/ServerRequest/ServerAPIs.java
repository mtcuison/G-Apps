package org.rmj.g3appdriver.dev.ServerRequest;

import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.GCARD;
import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.LIVE;
import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.LOCAL;
import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.SECURITY;

public class ServerAPIs {

    private final boolean isTestUnit;

    private static final String SIGN_IN = SECURITY + "signin.php";
    private static final String REGISTRATION = SECURITY + "signup.php";
    private static final String RETRIEVE_PASSWORD = SECURITY + "forgotpswd.php";

    private static final String URL_CHECK_APP_VERSION = GCARD + "version_checker.php";
    private static final String URL_ADD_NEW_GCARD = GCARD + "add_gcardnumber.php";
    private static final String URL_IMPORT_PROMOLINK = GCARD + "import_promo_link.php";
    private static final String URL_IMPORT_PLACE_ORDER = GCARD + "import_placed_orders.php";
    private static final String URL_IMPORT_REDEEM_ITEMS = GCARD + "import_redeem_item.php";
    private static final String URL_IMPORT_TRANSACTIONS_OFFLINE = GCARD + "import_trans_offline.php";
    private static final String URL_IMPORT_TRANSACTIONS_ONLINE = GCARD + "import_trans_online.php";
    private static final String URL_IMPORT_TRANSACTIONS_PREORDER = GCARD + "import_trans_preorder.php";
    private static final String URL_IMPORT_TRANSACTIONS_REDEMPTION = GCARD + "import_trans_redemption.php";
    private static final String URL_IMPORT_MC_REGISTRATION = GCARD + "import_registration.php";
    private static final String URL_IMPORT_SERVICE = GCARD + "import_service.php";
    private static final String URL_IMPORT_BRANCH = GCARD + "import_branch.php";
    private static final String URL_IMPORT_GCARD = GCARD + "import_gcard.php";
    private static final String URL_REQUEST_AVAIL_POINTS = GCARD + "request_avl_points.php";
    private static final String URL_PLACE_ODER = GCARD + "place_order.php";
    private static final String URL_CANCEL_ORDER = GCARD + "cancel_order_item.php";
    private static final String URL_IMPORT_EVENTS = GCARD + "import_events.php";
    private static final String URL_CHANGE_PASSWORD = SECURITY + "acctupdate.php";
    private static final String URL_REQUEST_DEVICES = SECURITY + "acctdevice.php";
    private static final String URL_CLIENT_LOGIN = SECURITY + "signin.php";

    private static final String SEND_RESPONSE = "https://restgk.guanzongroup.com.ph/notification/send_response.php";
    private static final String SEND_REQUEST = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
    private static final String CHECK_UPDATE_URL = "https://restgk.guanzongroup.com.ph/gcard/ms/version_checker.php";

    public ServerAPIs(boolean isUnitTest) {
        this.isTestUnit = isUnitTest;
    }

    public String getSIGN_IN() {
        if(isTestUnit){
            return LOCAL + SIGN_IN;
        }
        return LIVE + SIGN_IN;
    }

    public String getREGISTRATION() {
        if(isTestUnit){
            return LOCAL + REGISTRATION;
        }
        return LIVE + REGISTRATION;
    }

    public String getRETRIEVE_PASSWORD() {
        if(isTestUnit){
            return LOCAL + RETRIEVE_PASSWORD;
        }
        return LIVE + RETRIEVE_PASSWORD;
    }

    public String getURL_CHECK_APP_VERSION() {
        if(isTestUnit){
            return LOCAL + URL_CHECK_APP_VERSION;
        }
        return LIVE + URL_CHECK_APP_VERSION;
    }

    public String getURL_ADD_NEW_GCARD() {
        if(isTestUnit){
            return LOCAL + URL_ADD_NEW_GCARD;
        }
        return LIVE + URL_ADD_NEW_GCARD;
    }

    public String getURL_IMPORT_PROMOLINK() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_PROMOLINK;
        }
        return LIVE + URL_IMPORT_PROMOLINK;
    }

    public String getURL_IMPORT_PLACE_ORDER() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_PLACE_ORDER;
        }
        return LIVE + URL_IMPORT_PLACE_ORDER;
    }

    public String getURL_IMPORT_REDEEM_ITEMS() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_REDEEM_ITEMS;
        }
        return LIVE + URL_IMPORT_REDEEM_ITEMS;
    }

    public String getURL_IMPORT_TRANSACTIONS_OFFLINE() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_OFFLINE;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_OFFLINE;
    }

    public String getURL_IMPORT_TRANSACTIONS_ONLINE() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_ONLINE;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_ONLINE;
    }

    public String getURL_IMPORT_TRANSACTIONS_PREORDER() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_PREORDER;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_PREORDER;
    }

    public String getURL_IMPORT_TRANSACTIONS_REDEMPTION() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_REDEMPTION;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_REDEMPTION;
    }

    public String getURL_IMPORT_MC_REGISTRATION() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_MC_REGISTRATION;
        }
        return LIVE + URL_IMPORT_MC_REGISTRATION;
    }

    public String getURL_IMPORT_SERVICE() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_SERVICE;
        }
        return LIVE + URL_IMPORT_SERVICE;
    }

    public String getURL_IMPORT_BRANCH() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_BRANCH;
        }
        return LIVE + URL_IMPORT_BRANCH;
    }

    public String getURL_IMPORT_GCARD() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_GCARD;
        }
        return LIVE + URL_IMPORT_GCARD;
    }

    public String getURL_REQUEST_AVAIL_POINTS() {
        if(isTestUnit){
            return LOCAL + URL_REQUEST_AVAIL_POINTS;
        }
        return LIVE + URL_REQUEST_AVAIL_POINTS;
    }

    public String getURL_PLACE_ODER() {
        if(isTestUnit){
            return LOCAL + URL_PLACE_ODER;
        }
        return LIVE + URL_PLACE_ODER;
    }

    public String getURL_CANCEL_ORDER() {
        if(isTestUnit){
            return LOCAL + URL_CANCEL_ORDER;
        }
        return LIVE + URL_CANCEL_ORDER;
    }

    public String getURL_IMPORT_EVENTS() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_EVENTS;
        }
        return LIVE + URL_IMPORT_EVENTS;
    }

    public String getURL_CHANGE_PASSWORD() {
        if(isTestUnit){
            return LOCAL + URL_CHANGE_PASSWORD;
        }
        return LIVE + URL_CHANGE_PASSWORD;
    }

    public String getURL_REQUEST_DEVICES() {
        if(isTestUnit){
            return LOCAL + URL_REQUEST_DEVICES;
        }
        return LIVE + URL_REQUEST_DEVICES;
    }

    public String getURL_CLIENT_LOGIN() {
        return URL_CLIENT_LOGIN;
    }

    public String getSEND_RESPONSE() {
        return SEND_RESPONSE;
    }

    public String getSEND_REQUEST() {
        return SEND_REQUEST;
    }

    public String getCHECK_UPDATE_URL() {
        if(isTestUnit){
            return LOCAL + CHECK_UPDATE_URL;
        }
        return LIVE + CHECK_UPDATE_URL;
    }
}
