/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.etc;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppConstants {

    public static String MainFolder = "/GuanzonApps/";

    public static final String SUB_FOLDER_CREDIT_APP = "/CreditApp";

    public static String ALL_DATA_SENT() throws Exception{
        JSONObject loJson = new JSONObject();
        loJson.put("result", "success");
        return loJson.toString();
    }

    public static String NO_INTERNET() throws Exception{
        JSONObject loJson = new JSONObject();
        JSONObject loError = new JSONObject();
        loJson.put("result", "error");
        loError.put("code", "503");
        loError.put("message", "Not connected to internet");
        loJson.put("error", loError);
        return loJson.toString();
    }

    public static String LOCAL_EXCEPTION_ERROR(String message) {
        JSONObject loJson = new JSONObject();
        JSONObject loError = new JSONObject();
        try {
            loJson.put("result", "error");
            loError.put("code", "202");
            loError.put("message", message);
            loJson.put("error", loError);
        } catch (Exception e){
            e.printStackTrace();
        }
        return loJson.toString();
    }

    public static String ERROR_SAVING_TO_LOCAL() throws Exception{
        JSONObject loJson = new JSONObject();
        JSONObject loError = new JSONObject();
        loJson.put("result", "error");
        loError.put("code", "503");
        loError.put("message", "Unable to save data to local. ");
        loJson.put("error", loError);
        return loJson.toString();
    }

    public static String SERVER_NO_RESPONSE() throws Exception{
        JSONObject loJson = new JSONObject();
        JSONObject loError = new JSONObject();
        loJson.put("result", "error");
        loError.put("code", "404");
        loError.put("message", "No response receive from server.\n Please check your internet connection \n and try again later.");
        loJson.put("error", loError);
        return loJson.getJSONObject("error").getString("message");
    }

    public static String SOURCE_CODE = "MPlc";
    public static String APP_CLIENT = "GGC_BGAP0";
    public static String FS_SCANNER = "GAP0";
    public static String DOC_FILE_APPLICANT_PHOTO = "0029";
    public static String DOC_FILE_VALID_ID = "0005";

    public static String getPaymentMethod(String fsCode){
        switch (fsCode){
            case "COD":
                return "Cash On Delivery";
            case "GCash":
                return "Paid through GCash";
            default:
                return "Paid through PayMaya";
        }
    }

    public final static String ID = "0";
    public final static String IMAGE = "1";
    public final static String PROFILE = "2";
    public final static String MOBILE = "3";
    public final static String EMAIL = "4";

//    public static String[][] ACCOUNT_SETTINGS_MENU = new String[][]{
//            new String[] {"0","Account Details","Manage Email, Mobile Number, Password and Personal Information."},
//            new String[] {"1","Payment Options","Manage payment options for transactions made in the app."},
//            new String[] {"2","Shipping Address","Manage shipping address for delivery of ordered products."},
//            new String[] {"3","My GCard", "Manage GCard account for Motorcyle Services and Points for Redeemables."}
//    };

    public static String[][] ACCOUNT_SETTINGS_MENU = new String[][]{
            new String[] {"0","Account Details","Manage Email, Mobile Number, Password and Personal Information."},
            new String[] {"2","Address Book","Manage billing and shipping address for delivery of ordered products."}
    };

    public String DATE_MODIFIED = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

    public static String CURRENT_DATE = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    public static String CURRENT_DATE_WORD = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(new Date());
    public String GCARD_DATE_TIME = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());

    public static String[] REQUEST_CODE = {
            "New",
            "Update",
            "Change"
    };

    public static String[] ValidIDList = new String[]{
            "Philippine Passport from Department of Foreign Affairs",
            "SSS ID or SSS UMID Card (SSS)",
            "GSIS ID or GSIS UMID Card (GSIS)",
            "Driver’s License from Land Transportation Office (LTO)",
            "PRC ID from Professional Regulatory Commission (PRC)",
            "OWWA ID Overseas Workers Welfare Administration (OWWA)",
            "iDOLE Card from Department of Labor and Employment (iDOLE)",
            "Voter’s ID from Commission on Elections (COMELEC)",
            "Voter’s Certification from the Officer of Election with Dry Seal",
            "Firearms License from Philippine National Police (PNP)",
            "Senior Citizen ID from Local Government Unit (LGU)",
            "Persons with Disabilities (PWD)",
            "NBI Clearance (NBI)",
            "Immigrant Certificate of Registration",
            "PhilHealth ID (digitized PVC)",
            "Government Office and GOCC ID",
            "Integrated Bar of the Philippines ID",
            "School ID (for students) from the current School or University",
            "Current Valid ePassport (For Renewal of ePassport)",
            "TIN ID",
            "Postal ID (issued 2015 onwards)",
            "Barangay Certification",
            "Government Service Insurance System (GSIS) e-Card",
            "Seaman’s Book",
            "Department of Social Welfare and Development (DSWD) Certification",
            "Police Clearance",
            "Barangay Clearance",
            "Cedula or Community Tax Certificate",
            "Government Service Record",
            "PSA Marriage Contract",
            "PSA Birth Certificate",
            "Others"};

    public static String parseTermCode(String fsVal){
        switch (fsVal){
            case "C001018":
                return "3 Months Installment";
            case "C001019":
                return "6 Months Installment";
            case "C001023":
                return "9 Months Installment";
            case "C001020":
                return "12 Months Installment";
            case "C001002":
                return "Cash On Delivery";
            default:
                return "Online Payment (GCash or PAYMaya)";
        }
    }
}
