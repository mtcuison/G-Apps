package org.rmj.guanzongroup.appcore.ServerRequest;

import static org.rmj.guanzongroup.appcore.ServerRequest.APILocation.GCARD;
import static org.rmj.guanzongroup.appcore.ServerRequest.APILocation.LOCAL;
import static org.rmj.guanzongroup.appcore.ServerRequest.APILocation.SECURITY;
import static org.rmj.guanzongroup.appcore.ServerRequest.APILocation.LIVE;

public class GCardAPI {

    public static String URL_CHECK_APP_VERSION = LOCAL + GCARD + "version_checker.php";
    public static String URL_ADD_NEW_GCARD = LOCAL + GCARD + "add_gcardnumber.php";
    public static String URL_IMPORT_PROMOLINK = LOCAL + GCARD + "import_promo_link.php";
    public static String URL_IMPORT_PLACE_ORDER = LOCAL + GCARD + "import_placed_orders.php";
    public static String URL_IMPORT_REDEEM_ITEMS = LOCAL + GCARD + "import_redeem_item.php";
    public static String URL_IMPORT_TRANSACTIONS_OFFLINE = LOCAL + GCARD + "import_trans_offline.php";
    public static String URL_IMPORT_TRANSACTIONS_ONLINE = LOCAL + GCARD + "import_trans_online.php";
    public static String URL_IMPORT_TRANSACTIONS_PREORDER = LOCAL + GCARD + "import_trans_preorder.php";
    public static String URL_IMPORT_TRANSACTIONS_REDEMPTION = LOCAL + GCARD + "import_trans_redemption.php";
    public static String URL_IMPORT_MC_REGISTRATION = LOCAL + GCARD + "import_registration.php";
    public static String URL_IMPORT_SERVICE = LOCAL + GCARD + "import_service.php";
    public static String URL_IMPORT_BRANCH = LOCAL + GCARD + "import_branch.php";
    public static String URL_IMPORT_GCARD = LOCAL + GCARD + "import_gcard.php";
    public static String URL_REQUEST_AVAIL_POINTS = LOCAL + GCARD + "request_avl_points.php";
    public static String URL_PLACE_ODER = LOCAL + GCARD + "place_order.php";
    public static String URL_CANCEL_ORDER = LOCAL + GCARD + "cancel_order_item.php";
    public static String URL_IMPORT_EVENTS = LOCAL + GCARD + "import_events.php";
    public static String URL_CHANGE_PASSWORD = LOCAL + SECURITY + "acctupdate.php";
    public static String URL_REQUEST_DEVICES = LOCAL + SECURITY + "acctdevice.php";
    public static String URL_CLIENT_LOGIN = LOCAL + SECURITY + "signin.php";

    public static String SEND_RESPONSE = "https://restgk.guanzongroup.com.ph/notification/send_response.php";
    public static String SEND_REQUEST = "https://restgk.guanzongroup.com.ph/notification/send_request.php";
}
