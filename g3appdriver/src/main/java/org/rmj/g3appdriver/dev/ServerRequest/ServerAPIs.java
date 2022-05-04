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
    private static final String IMPORT_BARANGAY = "integsys/param/download_barangay.php";
    private static final String IMPORT_TOWN = "integsys/param/download_town.php";
    private static final String IMPORT_PROVINCE = "integsys/param/download_province.php";
    private static final String IMPORT_COUNTRIES = "integsys/param/download_country.php";

    private static final String REGISTER_ACCOUNT = "integsys/marketplace/add_new_client.php";
    private static final String IMPORT_ACCOUNT_INFO = "integsys/marketplace/get_client_info.php";
    private static final String UPDATE_ACCOUNT_INFO = "integsys/marketplace/update_client_info.php";
    private static final String UPDATE_MOBILE_NO = "integsys/marketplace/request_mobile_update.php";
    private static final String UPDATE_ADDRESS = "integsys/marketplace/request_address_update.php";
    private static final String URL_UPDATE_ADDRESS = "integsys/dcp/request_address_update.php";
    private static final String URL_UPDATE_MOBILE = "integsys/dcp/request_mobile_update.php";
    private static final String IMPORT_PAYMENT_METHODS = "";
    private static final String UPDATE_PAYMENT_METHOD = "";
    private static final String IMPORT_SHIPPING_INFO = "";
    private static final String IMPORT_TOP_SELLING_ITEMS = "";
    private static final String IMPORT_PROMO_ITEMS = "integsys/marketplace/download_item_list.php";
    private static final String IMPORT_SEARCH_RESULTS = "";
    private static final String IMPORT_PRODUCT_INFO = "";
    private static final String ADD_TO_CART_ITEM = "integsys/marketplace/add_to_cart.php";
    private static final String UPDATE_CART_ITEM = "integsys/marketplace/remove_to_cart.php";
    private static final String IMPORT_CART_ITEMS = "";
    private static final String MKTPL_PLACE_ORDER = "integsys/marketplace/place_order.php";
    private static final String IMPORT_PLACED_ORDERS = "";
    private static final String IMPORT_RETRIEVE_SHIPPING_ADDRESS = "";
    private static final String UPDATE_SHIPPING_ADDRESS = "";
    private static final String IMPORT_DEFAULT_PAYMENT_METHOD = "";
    private static final String UPDATE_DEFAULT_PAYMENT_METHOD = "";
    private static final String IMPORT_SHIPPING_STATUS = "";
    private static final String IMPORT_ORDER_SUMMARY = "";
    private static final String IMPORT_REVIEWS = "";
    private static final String IMPORT_QUESTIONS_AND_ANSWERS = "";

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

    public String getRegisterAcountAPI() {
        if(isTestUnit){
            return LOCAL + REGISTRATION;
        }
        return LIVE + REGISTRATION;
    }

    public String getRetrievePasswordAPI() {
        if(isTestUnit){
            return LOCAL + RETRIEVE_PASSWORD;
        }
        return LIVE + RETRIEVE_PASSWORD;
    }

    public String getCheckAppVersionAPI() {
        if(isTestUnit){
            return LOCAL + URL_CHECK_APP_VERSION;
        }
        return LIVE + URL_CHECK_APP_VERSION;
    }

    public String getAddNewGCardAPI() {
        if(isTestUnit){
            return LOCAL + URL_ADD_NEW_GCARD;
        }
        return LIVE + URL_ADD_NEW_GCARD;
    }

    public String getImportPromosAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_PROMOLINK;
        }
        return LIVE + URL_IMPORT_PROMOLINK;
    }

    public String getImportPlaceOrderAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_PLACE_ORDER;
        }
        return LIVE + URL_IMPORT_PLACE_ORDER;
    }

    public String getImportRedeemItemsAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_REDEEM_ITEMS;
        }
        return LIVE + URL_IMPORT_REDEEM_ITEMS;
    }

    public String getImportOfflineTransAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_OFFLINE;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_OFFLINE;
    }

    public String getImportOnlineTransAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_ONLINE;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_ONLINE;
    }

    public String getImportPreOrderAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_PREORDER;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_PREORDER;
    }

    public String getImportReedemptionsAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_TRANSACTIONS_REDEMPTION;
        }
        return LIVE + URL_IMPORT_TRANSACTIONS_REDEMPTION;
    }

    public String getMCRegistrationAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_MC_REGISTRATION;
        }
        return LIVE + URL_IMPORT_MC_REGISTRATION;
    }

    public String getServiceInfoAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_SERVICE;
        }
        return LIVE + URL_IMPORT_SERVICE;
    }

    public String getImportBranchesAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_BRANCH;
        }
        return LIVE + URL_IMPORT_BRANCH;
    }

    public String getImportGCardAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_GCARD;
        }
        return LIVE + URL_IMPORT_GCARD;
    }

    public String getRequestAvlPointsAPI() {
        if(isTestUnit){
            return LOCAL + URL_REQUEST_AVAIL_POINTS;
        }
        return LIVE + URL_REQUEST_AVAIL_POINTS;
    }

    public String getPlaceOrderAPI() {
        if(isTestUnit){
            return LOCAL + URL_PLACE_ODER;
        }
        return LIVE + URL_PLACE_ODER;
    }

    public String getCancelOrderAPI() {
        if(isTestUnit){
            return LOCAL + URL_CANCEL_ORDER;
        }
        return LIVE + URL_CANCEL_ORDER;
    }

    public String getImportEventsAPI() {
        if(isTestUnit){
            return LOCAL + URL_IMPORT_EVENTS;
        }
        return LIVE + URL_IMPORT_EVENTS;
    }

    public String getChangePasswordAPI() {
        if(isTestUnit){
            return LOCAL + URL_CHANGE_PASSWORD;
        }
        return LIVE + URL_CHANGE_PASSWORD;
    }

    public String getDevicesInfoAPI() {
        if(isTestUnit){
            return LOCAL + URL_REQUEST_DEVICES;
        }
        return LIVE + URL_REQUEST_DEVICES;
    }

    public String getClientLoginAPI() {
        return URL_CLIENT_LOGIN;
    }

    public String getSendResponseAPI() {
        return SEND_RESPONSE;
    }

    public String getSendRequestAPI() {
        return SEND_REQUEST;
    }

    public String getCheckUpdateAPI() {
        if(isTestUnit){
            return LOCAL + CHECK_UPDATE_URL;
        }
        return LIVE + CHECK_UPDATE_URL;
    }

    public String getCreateNewClientAPI(){
        if(isTestUnit){
            return LOCAL + REGISTER_ACCOUNT;
        }
        return LIVE + REGISTER_ACCOUNT;
    }

    public String getImportAccountInfoAPI() {
        if(isTestUnit){
            return LOCAL + IMPORT_ACCOUNT_INFO;
        }
        return LIVE + IMPORT_ACCOUNT_INFO;
    }

    public String getUpdateAccountInfo() {
        if(isTestUnit){
            return LOCAL + UPDATE_ACCOUNT_INFO;
        }
        return LIVE + UPDATE_ACCOUNT_INFO;
    }

    public String getImportPaymentMethods() {
        if(isTestUnit){
            return LOCAL + IMPORT_PAYMENT_METHODS;
        }
        return LIVE + IMPORT_PAYMENT_METHODS;
    }

    public String getUpdatePaymentMethod() {
        if(isTestUnit){
            return LOCAL + UPDATE_PAYMENT_METHOD;
        }
        return LIVE + UPDATE_PAYMENT_METHOD;
    }

    public String getImportShippingInfo() {
        if(isTestUnit){
            return LOCAL + IMPORT_SHIPPING_INFO;
        }
        return LIVE + IMPORT_SHIPPING_INFO;
    }

    public String getImportTopSellingItems() {
        if(isTestUnit){
            return LOCAL + IMPORT_TOP_SELLING_ITEMS;
        }
        return LIVE + IMPORT_TOP_SELLING_ITEMS;
    }

    public String getImportProducts() {
        if(isTestUnit){
            return LOCAL + IMPORT_PROMO_ITEMS;
        }
        return LIVE + IMPORT_PROMO_ITEMS;
    }

    public String getImportSearchResults() {
        if(isTestUnit){
            return LOCAL + IMPORT_SEARCH_RESULTS;
        }
        return LIVE + IMPORT_SEARCH_RESULTS;
    }

    public String getImportProductInfo() {
        if(isTestUnit){
            return LOCAL + IMPORT_PRODUCT_INFO;
        }
        return LIVE + IMPORT_PRODUCT_INFO;
    }

    public String getRemoveCartItemAPI() {
        if(isTestUnit){
            return LOCAL + UPDATE_CART_ITEM;
        }
        return LIVE + UPDATE_CART_ITEM;
    }

    public String getImportCartItems() {
        if(isTestUnit){
            return LOCAL + IMPORT_CART_ITEMS;
        }
        return LIVE + IMPORT_CART_ITEMS;
    }

    public String getImportPlacedOrders() {
        if(isTestUnit){
            return LOCAL + IMPORT_PLACED_ORDERS;
        }
        return LIVE + IMPORT_PLACED_ORDERS;
    }

    public String getImportRetrieveShippingAddress() {
        if(isTestUnit){
            return LOCAL + IMPORT_RETRIEVE_SHIPPING_ADDRESS;
        }
        return LIVE + IMPORT_RETRIEVE_SHIPPING_ADDRESS;
    }

    public String getUpdateShippingAddress() {
        if(isTestUnit){
            return LOCAL + UPDATE_SHIPPING_ADDRESS;
        }
        return LIVE + UPDATE_SHIPPING_ADDRESS;
    }

    public String getImportDefaultPaymentMethod() {
        if(isTestUnit){
            return LOCAL + IMPORT_DEFAULT_PAYMENT_METHOD;
        }
        return LIVE + IMPORT_DEFAULT_PAYMENT_METHOD;
    }

    public String getUpdateDefaultPaymentMethod() {
        if(isTestUnit){
            return LOCAL + UPDATE_DEFAULT_PAYMENT_METHOD;
        }
        return LIVE + UPDATE_DEFAULT_PAYMENT_METHOD;
    }

    public String getImportShippingStatus() {
        if(isTestUnit){
            return LOCAL + IMPORT_SHIPPING_STATUS;
        }
        return LIVE + IMPORT_SHIPPING_STATUS;
    }

    public String getImportOrderSummary() {
        if(isTestUnit){
            return LOCAL + IMPORT_ORDER_SUMMARY;
        }
        return LIVE + IMPORT_ORDER_SUMMARY;
    }

    public String getImportReviewsAPI() {
        if(isTestUnit){
            return LOCAL + IMPORT_REVIEWS;
        }
        return LIVE + IMPORT_REVIEWS;
    }

    public String getQuestionsAndAnswersAPI() {
        if(isTestUnit){
            return LOCAL + IMPORT_QUESTIONS_AND_ANSWERS;
        }
        return LIVE + IMPORT_QUESTIONS_AND_ANSWERS;
    }

    public String getUpdateMobileNo() {
        if(isTestUnit){
            return LOCAL + UPDATE_MOBILE_NO;
        }
        return LIVE + UPDATE_MOBILE_NO;
    }

    public String getUpdateAddress() {
        if(isTestUnit){
            return LOCAL + UPDATE_ADDRESS;
        }
        return LIVE + UPDATE_ADDRESS;
    }

    public String getImportBarangayAPI(){
        if(isTestUnit){
            return LOCAL + IMPORT_BARANGAY;
        }
        return LIVE + IMPORT_BARANGAY;
    }

    public String getImportTownAPI(){
        if(isTestUnit){
            return LOCAL + IMPORT_TOWN;
        }
        return LIVE + IMPORT_TOWN;
    }

    public String getImportProvinceAPI(){
        if(isTestUnit){
            return LOCAL + IMPORT_PROVINCE;
        }
        return LIVE + IMPORT_PROVINCE;
    }

    public String getImportCountriesAPI(){
        if(isTestUnit){
            return LOCAL + IMPORT_COUNTRIES;
        }
        return LIVE + IMPORT_COUNTRIES;
    }

    public String getAddressUpdateAPI(){
        if(isTestUnit){
            return LOCAL + URL_UPDATE_ADDRESS;
        }
        return LIVE + URL_UPDATE_ADDRESS;
    }

    public String getMobileUpdateAPI(){
        if(isTestUnit){
            return LOCAL + URL_UPDATE_MOBILE;
        }
        return LIVE + URL_UPDATE_MOBILE;
    }

    public String getAddToCartAPI(){
        if(isTestUnit){
            return LOCAL + ADD_TO_CART_ITEM;
        }
        return LIVE + ADD_TO_CART_ITEM;
    }

    public String getMarketPlaceOrderAPI(){
        if(isTestUnit){
            return LOCAL + MKTPL_PLACE_ORDER;
        }
        return LIVE + MKTPL_PLACE_ORDER;
    }
}
