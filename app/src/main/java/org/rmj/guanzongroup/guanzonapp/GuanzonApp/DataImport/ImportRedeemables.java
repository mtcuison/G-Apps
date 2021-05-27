package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

public class ImportRedeemables implements GapImportInstance {
    private static final String TAG = ImportRedeemables.class.getSimpleName();

    private Context mContext;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(Context context, onImportResultListener listener) {
        this.mContext = context;
        this.onImportResultListener = listener;
        new ImportRedeemableTask(context).execute();
    }

    private byte[] getItemImage(String ImageUrl) {
        Bitmap ItemImage;
        try {
            InputStream inputStream = new java.net.URL(ImageUrl).openStream();
            ItemImage = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ItemImage.compress(Bitmap.CompressFormat.PNG, 100, bos);
            return bos.toByteArray();
        }catch (Exception e){
            Log.e("IMAGE ERROR", "ITEM IMAGE CANNOT BE CREATED. ERROR: " + e.getMessage());
            return new byte[0];
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class ImportRedeemableTask extends AsyncTask<Void, Void, String>{
        private Context context;
        private String lsResult = "";
        private String message = "";
        private final RequestHeaders headers;
        private final ConnectionUtil connectionUtil;

        public ImportRedeemableTask(Context context) {
            this.context = context;
            headers = new RequestHeaders(mContext);
            connectionUtil = new ConnectionUtil(mContext);
        }

        @Override
        protected String doInBackground(Void... voids) {
            if(connectionUtil.isDeviceConnected()){
                new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_REDEEM_ITEMS(), new HttpRequestUtil.onServerResponseListener() {
                    @Override
                    public HashMap setHeaders() {
                        Log.e(TAG, "Import Redeemables headers has been set.");
                        return (HashMap)headers.getHeaders();
                    }

                    @Override
                    public JSONObject setData() {
                        return new JSONObject();
                    }

                    @Override
                    public void onResponse(JSONObject jsonResponse) {
                        try{
                            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
                            if(jsonArray.length()>0){
                                saveRedeemablesToLocal(jsonArray);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        lsResult = "success";
                    }

                    @Override
                    public void onErrorResponse(String msg) {
                        lsResult = "error";
                        message = msg;
                    }
                });
            } else {
                lsResult = "error";
            }
            return lsResult;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equalsIgnoreCase("success")){
                onImportResultListener.onSuccessImport();
                Log.e(TAG, "Redeemables has been imported successfully.");
            } else {
                onImportResultListener.onErrorResult();
                Log.e(TAG, "Redeemables failed to import.");
            }
        }

        void saveRedeemablesToLocal(JSONArray jsonArray) throws JSONException, SQLiteException {
            AppData db = AppData.getInstance(mContext);
            String lsSql = "INSERT OR REPLACE INTO tbl_redeemables(sTransNox, sPromoCde, sPromoDsc, nPointsxx, sImageUrl, dDateFrom, dDateThru, cPreOrder) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
            db.getWritableDb().beginTransaction();
            for(int x = 0; x < jsonArray.length(); x++){
                JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                //String imageBin = Base64.encodeToString(getItemImage(jsonDetail.getString("sImageURL")), Base64.NO_WRAP);
                loSql.clearBindings();
                loSql.bindString(1, jsonDetail.getString("sTransNox"));
                loSql.bindString(2, jsonDetail.getString("sPromCode"));
                loSql.bindString(3, jsonDetail.getString("sPromDesc"));
                loSql.bindString(4, jsonDetail.getString("nPointsxx"));
                loSql.bindString(5, jsonDetail.getString("sImageURL"));
                loSql.bindString(6, jsonDetail.getString("dDateFrom"));
                loSql.bindString(7, jsonDetail.getString("dDateThru"));
                loSql.bindString(8, jsonDetail.getString("cPreOrder"));
                loSql.execute();
            }
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
        }
    }
}
