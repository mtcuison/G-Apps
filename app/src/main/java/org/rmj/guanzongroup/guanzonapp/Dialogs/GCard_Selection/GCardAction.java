package org.rmj.guanzongroup.guanzonapp.Dialogs.GCard_Selection;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.WebRequest.AddNewGCard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.WebRequest.GapRequestInstance;
import org.rmj.guanzongroup.guanzonapp.etc.GCard_Constants;

public class GCardAction {
    private Context mContext;

    private AddNewGCard addNewGCard;
    private Handler handler = new android.os.Handler();
    private Runnable runnable;
    private Dialog_Loading loading;
    private Toast toast;
    private onAddNewGCardListener onAddNewGCardListener;

    public interface onAddNewGCardListener{
        void onAddResult(String Message);
    }

    public GCardAction(Context context){
        this.mContext = context;
        this.addNewGCard = new AddNewGCard();
        this.loading = new Dialog_Loading(mContext);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addNewGCard(String GCardNumber, String BirthDate, onAddNewGCardListener listener){
        this.onAddNewGCardListener = listener;
        addNewGCard.setEntryType(GCard_Constants.MANUAL_ENTRY);
        addNewGCard.setGCardNumber(GCardNumber);
        addNewGCard.setUserBirthDate(BirthDate);
        new AddGcardTask().execute();
    }

    private String parseErrorMessage(String errorMessage){
        try{
            JSONObject message = new JSONObject(errorMessage);
            JSONObject error = message.getJSONObject("error");
            return error.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
            return errorMessage;
        }
    }

    class AddGcardTask extends AsyncTask<Integer, Integer, String>{

        String result = "";
        String message = "";
        @SuppressLint("NewApi")
        @Override
        protected void onPreExecute() {
            loading.setMessage("Add your new GCard number. Please wait...");
            loading.showDialog();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            addNewGCard.sendRequest(mContext, new GapRequestInstance.onSendRequestResultListener() {
                @Override
                public void onSuccessResult() {
                    result = "success";
                }

                @Override
                public void onErrorResult(String ErrorMessage) {
                    result = "error";
                    message = ErrorMessage;
                }
            });
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            loading.dismissDialog();
            if(!s.equalsIgnoreCase("success")){
                if(!isGcardConfirmation(message)) {
                    toast = Toast.makeText(mContext, parseErrorMessage(message), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    askGCardConfirmation("Someone has registered the card from other device. Do you want to deactivate usage of card from other device?");
                }
            } else {
                new Dialog_GcardSelection().getInstance().refreshList();
                onAddNewGCardListener.onAddResult("You have successfully added a new GCard number.");
            }
            super.onPostExecute(s);
            this.cancel(true);
        }
    }

    private boolean isErrorJson(String message){
        try{
            new JSONObject(message);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isGcardConfirmation(String message){
        try{
            if(isErrorJson(message)){
                JSONObject lojson = new JSONObject(message);
                String lsCode = lojson.getString("code");
                if(lsCode.equalsIgnoreCase("CNF")){
                    return true;
                }
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private void askGCardConfirmation(String message){
        try {
            MessageBox loDialog = new MessageBox(mContext);
            loDialog.setDialogMessage(message);
            loDialog.setMessageType(MessageBox.MessageType.WARNING);
            loDialog.setNegativeButton("No", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    dialog.dismiss();
                }
            });
            loDialog.setPositiveButton("Yes", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    addNewGCard.setConfirmGcard("1");
                    new AddGcardTask().execute();
                    dialog.dismiss();
                }
            });
            loDialog.showDialog();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
