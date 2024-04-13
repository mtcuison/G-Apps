package org.rmj.g3appdriver.lib.GCardCore;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.lib.Panalo.PanaloRewards;
import org.rmj.g3appdriver.utils.MySQLAESCrypt;

import java.util.ArrayList;

public class CodeGenerator {
    private static final String EncryptionKEY = "20190625";
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    MySQLAESCrypt poEncrypt = new MySQLAESCrypt();
    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
    static String EncryptedQrCode = "";
    static String scanType = "";

    public void setScanType(String ScanType){
        scanType = ScanType;
    }
    public String getScanType(){
        return scanType;
    }

    public void setEncryptedQrCode(String encryptedQrCode){
        EncryptedQrCode = encryptedQrCode;
    }
    /***********************************************************
     * QrCode is decrypted to get the original value
     * */
    public String decryptedQrCodeValue(){
        String decyptedQrCode = poEncrypt.Decrypt(EncryptedQrCode, EncryptionKEY);
        return decyptedQrCode;
    }

    /**
     * Generate QRCODE
     * Encrypt the String value of
     * SOURCE    this must be REDEEM/PREORDER...
     * DeviceIMEI
     * GCardNumber
     * UserID
     * MobileNumber
     * DateTime            DateTime Format must be(YYYYMMDDHHMMSS)
     * AvailablePoints
     * Transnox = NULL
     * TransNox value is null until a successful redemption of points*/
    public Bitmap generateQrCode(String SOURCE, String DeviceImei, String CardNumber, String UserID, String MobileNumber, String DateTime, double AvailablePoints, String sModelCde, String TransNox){
        Bitmap bitmap = null;
        String UnEncryptedString = SOURCE + "»" + DeviceImei + "»" + CardNumber + "»" + UserID + "»" + MobileNumber + "»" + DateTime + "»" + AvailablePoints + "»" + sModelCde + "»" + TransNox;
        String EncryptedCode = poEncrypt.Encrypt(UnEncryptedString, EncryptionKEY);
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(EncryptedCode, BarcodeFormat.QR_CODE, 900, 900);
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    public Bitmap GeneratePanaloRebateRedemptionQC(PanaloRewards rewards){
        Bitmap bitmap = null;
        String UnEncryptedString =
                rewards.getPanaloQC() + ";" +
                rewards.getPanaloCD() + ";" +
                rewards.getAcctNmbr() + ";" +
                rewards.getAmountxx() + ";" +
                rewards.getExpiryDt() + ";" +
                rewards.getDeviceID() + ";" +
                rewards.getUserIDxx() + ";" +
                rewards.getItemQtyx() + ";" +
                rewards.getRedeemxx() + ";" +
                new AppConstants().DATE_MODIFIED;
        String EncryptedCode = poEncrypt.Encrypt(UnEncryptedString, EncryptionKEY);
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(EncryptedCode, BarcodeFormat.QR_CODE, 900, 900);
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    public Bitmap GeneratePanaloOtherRedemptionQC(PanaloRewards rewards){
        Bitmap bitmap = null;
        String UnEncryptedString =
                rewards.getPanaloQC() + ";" +
                rewards.getPanaloCD() + ";" +
                rewards.getItemCode() + ";" +
                rewards.getItemQtyx() + ";" +
                rewards.getAmountxx() + ";" +
                rewards.getExpiryDt() + ";" +
                rewards.getDeviceID() + ";" +
                rewards.getUserIDxx() + ";" +
                new AppConstants().DATE_MODIFIED;
        String EncryptedCode = poEncrypt.Encrypt(UnEncryptedString, EncryptionKEY);
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(EncryptedCode, BarcodeFormat.QR_CODE, 900, 900);
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    public static Bitmap CreateRaffleEntryQrCode(String Transact, String ReferNo, String UserID, String DateTime) throws Exception{
        String lsEncrypt = Transact + ";" + ReferNo + ";" + UserID + ";" + DateTime;
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        String lsEncryptd = MySQLAESCrypt.Encrypt(lsEncrypt, EncryptionKEY);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(lsEncryptd, BarcodeFormat.QR_CODE, 700, 700);
        return barcodeEncoder.createBitmap(bitMatrix);

    }
    public Bitmap generateGCardCodex(String SOURCE,
                                     String DeviceImei,
                                     String CardNumber,
                                     String UserID,
                                     String MobileNumber,
                                     String DateTime,
                                     double AvailablePoints,
                                     String sModelCde,
                                     String TransNox){
        Bitmap GcardCodex = null;
        String UnEncryptedString = SOURCE + "»" + DeviceImei + "»" + CardNumber + "»" + UserID + "»" + MobileNumber + "»" + DateTime + "»" + AvailablePoints + "»" + sModelCde + "»" + TransNox;
        String EncryptedCode = poEncrypt.Encrypt(UnEncryptedString, EncryptionKEY);
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(EncryptedCode, BarcodeFormat.QR_CODE, 700, 700);
            GcardCodex = barcodeEncoder.createBitmap(bitMatrix);
            return GcardCodex;
        }catch(Exception e){
            e.printStackTrace();
            return GcardCodex;
        }
    }
    public String generateSecureNo(String SecureNo){
        poEncrypt = new MySQLAESCrypt();
        String lsValue = poEncrypt.Encrypt(SecureNo, EncryptionKEY);
        return lsValue;
    }
    public String encryptPassword(String Password){
        return poEncrypt.Encrypt(Password, EncryptionKEY);
    }
    public String decryptPassword(String EncryptedPassword){
        return poEncrypt.Encrypt(EncryptedPassword, EncryptionKEY);
    }

    /***********************************************************
     * QrCode Decrypted value is split into String array[]
     * index 0 = Source
     * index 1 = PIN
     * index 2 = sTransNox
     * index 3 = dTransact
     * index 4 = sSourceNo
     * index 5 = sSourceCD
     * index 6 = nPointsxx
     * index 7 = sOTPasswd
     * index 8 = sIMEINoxx
     * index 9 = sUserIDxx
     * index 10 = sCardNumber
     * index 11 = sMobileNo
     * */
    public String getKeyValueOf(String decryptedCode, int ArrayIndexPosition){
        String returnValue = "";
        ArrayList CodeValue = new ArrayList();

        try {
            String[] frstValue = decryptedCode.split(";");
            String[] scndValue;
            String[] thrdValue;

            if (frstValue.length >= 0) {
                CodeValue.clear();

                for (int sTransIndex = 0; sTransIndex < frstValue.length; sTransIndex++) {
                    scndValue = frstValue[0].split("»");

                    for (int x = 0; x < scndValue.length; x++) {
                        if (x == 6) {
                            thrdValue = scndValue[6].split("@");
                            for (int i = 0; i < thrdValue.length; i++) {
                                CodeValue.add(thrdValue[i]);
                            }
                        } else {
                            CodeValue.add(scndValue[x]);
                        }
                    }
                }
            }
            for (int index = 0; index < CodeValue.size(); index++) {
                returnValue = String.valueOf(CodeValue.get(ArrayIndexPosition));
                Log.d("CODE GENERATE", CodeValue.get(index).toString());
            }
        } catch (Exception e){
            e.printStackTrace();
            returnValue = "INVALID";
        }
        return  returnValue;
    }

    /** Get Transaction Source here (ONLINE || OFFLINE) */
    public String getTransSource(){
        try {
            String decryptedQrCode = decryptedQrCodeValue();
            String transSource = getKeyValueOf(decryptedQrCode, 0);

            return transSource;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get QrCode Decrypted value
     * Transaction PIN is inside the array with @ splitter
     * Transaction PIN is inside Array Index[7] */
    public String getTransactionPIN(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode,1);
    }

    /**
     * Get Device IMEI for Device Barcode Scanning
     * For Transaction Validation
     * If IMEI in the QRCode != current Device IMEI
     * Transaction is Unsuccessful/INVALID
     *
     *  Get current USERID for Validation
     *  Get current GCARD Number for Validation
     *  Get current MOBILE NUMBER for Validation
     *  All Details for validation must be met by current device scanning the QRCode...
     *  */
    public String getTransDevImei(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode,2).replaceAll("[^\\\\x20-\\\\x7e]", "");
    }
    public String getUserID(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode, 3).replaceAll("[^\\\\x20-\\\\x7e]", "");
    }
    public String getGCardNumber(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode,4).replaceAll("[^\\\\x20-\\\\x7e]", "");
    }
    public String getMobileNumber(){
        String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode,5);
    }
    public String getTransNox(){
        String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode, 6);
    }
    public String getDTransact(){
        String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode, 7);
    }
    public String getSourceNo(){
            String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode, 8);
    }
    public String getSourceCD(){
            String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode, 9);
    }
    public String getPointsxx(){
        String decryptedQrCode = decryptedQrCodeValue();
            return getKeyValueOf(decryptedQrCode, 10);
    }

    /**If Conditions above is not met Display an INVALID TRANSACTION.../
    /*Encryption Functions below are use to encrypt all points in local database */
    public String generateTransNox(){
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int count = 12;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    public boolean isCodeValid(){
        return !getTransSource().equalsIgnoreCase("INVALID");
    }
    public boolean isDeviceValid(String MobileNo, String GCardNumber) {
        String gcard = getGCardNumber();
        String mobileNo = getMobileNumber();

        String lsSourceCD = getTransSource();

        if(lsSourceCD.equalsIgnoreCase("PREORDER") ||
                lsSourceCD.equalsIgnoreCase("REDEMPTION") ||
                lsSourceCD.equalsIgnoreCase("ONLINE") ||
                lsSourceCD.equalsIgnoreCase("OFFLINE")){
            return gcard.equalsIgnoreCase(GCardNumber) &&
                    mobileNo.equalsIgnoreCase(MobileNo);
        } else {
            return mobileNo.equalsIgnoreCase(MobileNo);
        }


        //mac 2020.08.21
        /*return gcard.equalsIgnoreCase(GCardNumber) &&
                mobileNo.equalsIgnoreCase(MobileNo);*/

        //
        /**
         /**
         * Original code
         *  mac 2020.08.21
         *      removed the validation for user id since we are not getting
         *      the user id on G-Card Sytems anymore.
         */

        //return gcard.equalsIgnoreCase(GCardNumber) &&
        //        mobileNo.equalsIgnoreCase(MobileNo) &&
        //       user.equalsIgnoreCase(UserID);
    }
    public boolean isQrCodeTransaction(){
        return getTransSource().equalsIgnoreCase("PREORDER") ||
                getTransSource().equalsIgnoreCase("REDEMPTION") ||
                getTransSource().equalsIgnoreCase("ONLINE") ||
                getTransSource().equalsIgnoreCase("OFFLINE")||
                getTransSource().equalsIgnoreCase("OTP");
    }
    public boolean isTransactionVoid(){
        try {
            double points = Double.parseDouble(getPointsxx());
            return points < 0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String GetOTPCardNmbr(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode, 1);
    }
    public String GetOTP(){
        String decryptedQrCode = decryptedQrCodeValue();
        return getKeyValueOf(decryptedQrCode, 2);
    }

    public String encryptPointsxx(double sPointsxx){
        return poEncrypt.Encrypt(String.valueOf(Double.valueOf(sPointsxx)), EncryptionKEY);
    }
    public String decryptPointsxx(String encryptedPointsxx){
        return poEncrypt.Decrypt(encryptedPointsxx, EncryptionKEY);
    }
    public boolean isQrCodeApplication(){
        return getTransSource().equalsIgnoreCase("APPLICATION");
    }
}
