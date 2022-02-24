package org.rmj.g3appdriver.dev.ServerRequest;

import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.GCARD;
import static org.rmj.g3appdriver.dev.ServerRequest.APILocation.SECURITY;

public class ServerAPIs {

    private static String SERVER = "";

    public ServerAPIs(boolean isLive) {
        if(!isLive) {
            SERVER = APILocation.LIVE;
        } else {
            SERVER = APILocation.LOCAL;
        }
    }

    public String SIGN_IN = SERVER + SECURITY + "signin.php";
    public String REGISTRATION = SERVER + SECURITY + "signup.php";
    public String RETRIEVE_PASSWORD = SERVER + SECURITY + "forgotpswd.php";

    public String URL_CHECK_APP_VERSION = SERVER + GCARD + "version_checker.php";
    public String URL_ADD_NEW_GCARD = SERVER + GCARD + "add_gcardnumber.php";
    public String URL_IMPORT_PROMOLINK = SERVER + GCARD + "import_promo_link.php";
    public String URL_IMPORT_PLACE_ORDER = SERVER + GCARD + "import_placed_orders.php";
    public String URL_IMPORT_REDEEM_ITEMS = SERVER + GCARD + "import_redeem_item.php";
    public String URL_IMPORT_TRANSACTIONS_OFFLINE = SERVER + GCARD + "import_trans_offline.php";
    public String URL_IMPORT_TRANSACTIONS_ONLINE = SERVER + GCARD + "import_trans_online.php";
    public String URL_IMPORT_TRANSACTIONS_PREORDER = SERVER + GCARD + "import_trans_preorder.php";
    public String URL_IMPORT_TRANSACTIONS_REDEMPTION = SERVER + GCARD + "import_trans_redemption.php";
    public String URL_IMPORT_MC_REGISTRATION = SERVER + GCARD + "import_registration.php";
    public String URL_IMPORT_SERVICE = SERVER + GCARD + "import_service.php";
    public String URL_IMPORT_BRANCH = SERVER + GCARD + "import_branch.php";
    public String URL_IMPORT_GCARD = SERVER + GCARD + "import_gcard.php";
    public String URL_REQUEST_AVAIL_POINTS = SERVER + GCARD + "request_avl_points.php";
    public String URL_PLACE_ODER = SERVER + GCARD + "place_order.php";
    public String URL_CANCEL_ORDER = SERVER + GCARD + "cancel_order_item.php";
    public String URL_IMPORT_EVENTS = SERVER + GCARD + "import_events.php";
    public String URL_CHANGE_PASSWORD = SERVER + SECURITY + "acctupdate.php";
    public String URL_REQUEST_DEVICES = SERVER + SECURITY + "acctdevice.php";
    public String URL_CLIENT_LOGIN = SERVER + SECURITY + "signin.php";

    public String SEND_RESPONSE = "https://restgk.guanzongroup.com.ph/notification/send_response.php";
    public String SEND_REQUEST = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
    public String CHECK_UPDATE_URL = "https://restgk.guanzongroup.com.ph/gcard/ms/version_checker.php";
}
