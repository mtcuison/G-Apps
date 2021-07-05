package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.etc.GToast;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_QrCodeScanner;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Dialog_GcardSelection {
    @SuppressLint("StaticFieldLeak")
    private static Dialog_GcardSelection instance;

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private TextView lblGcard;
    private EditText txtGcardNumber;
    private EditText txtYear;
    private EditText txtMonth;
    private EditText txtDay;
    private RecyclerView recyclerView;
    private Toast toast;
    private EGcardApp gcard;
    public Dialog_GcardSelection(){

    }

    public Dialog_GcardSelection(Context context, EGcardApp gcard){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
        instance = this;
        this.gcard = gcard;
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_dashboard_gcard_selection, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
        setupWidgets(view);
//        setupGcardList();
    }

    private void setupWidgets(View v){
        lblGcard = v.findViewById(R.id.lbl_dialog_gcard_selection_label);
        txtGcardNumber = v.findViewById(R.id.txt_dialog_gcard_selection_gcardNumber);
        txtYear = v.findViewById(R.id.txt_dialog_gcard_selection_birthYear);
        txtMonth = v.findViewById(R.id.txt_dialog_gcard_selection_birthMonth);
        txtDay = v.findViewById(R.id.txt_dialog_gcard_selection_birthDay);

        MaterialButton btnRefreshList = v.findViewById(R.id.btn_dialog_refreshgcard);
        MaterialButton btnAddNewGcard = v.findViewById(R.id.btn_dialog_gcard_selection_addnewGcard);
        MaterialButton btnScnNewGcard = v.findViewById(R.id.btn_dialog_gcard_selection_scannewGcard);
        MaterialButton btnCloseDialog = v.findViewById(R.id.btn_dialog_gcard_selection_closeDialog);
        recyclerView = v.findViewById(R.id.recyclerview_dialog_gcard_selection);

        txtGcardNumber.addTextChangedListener(new InputTextWatcher(txtGcardNumber));
        txtYear.addTextChangedListener(new InputTextWatcher(txtYear));
        txtMonth.addTextChangedListener(new InputTextWatcher(txtMonth));
        txtDay.addTextChangedListener(new InputTextWatcher(txtDay));

//        btnRefreshList.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View view) {
////                new RefreshListTask().execute();
////            }
//        });

        btnAddNewGcard.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(isGcardDataValid()) {
//                    new GCardAction(mContext).addNewGCard(txtGcardNumber.getText().toString(), createBirthDate(),
//                            new GCardAction.onAddNewGCardListener() {
//                                @Override
//                                public void onAddResult(String Message) {
//                                    txtGcardNumber.setText("");
//                                    txtYear.setText("");
//                                    txtMonth.setText("");
//                                    txtDay.setText("");
//                                    customToast.setMessage(Message);
//                                    customToast.setType(CustomToast.CustomToastType.INFORMATION);
//                                    customToast.show();
//                                    new Fragment_DashBoard().getInstance().refreshUI();
//                                    new Activity_DashBoard().getInstance().invalidateOptionsMenu();
//                                }
//                    });
                } else {
                    GToast.CreateMessage(mContext,"Please check your Gcard details before proceeding.",GToast.WARNING).show();

                }
            }
        });

        btnScnNewGcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, Activity_QrCodeScanner.class));
            }
        });

        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public static Dialog_GcardSelection getInstance(){
        return instance;
    }

//    void refreshList(){
//        setupGcardList();
//    }

//    private void setupGcardList(){
//////        List<GcardItem> gcardItemList = new ArrayList<>();
////        ArrayList<ArrayList<String>> GCardList;
////        GCardList = new GcardAppMaster(mContext).getAllGCardNumber();
////        Adapter_Gcard adapter = new Adapter_Gcard(gcardItemList);
//
//        lblGcard.setText(getTextLabel());
//        recyclerView.setVisibility(getRecyclerViewVisibility(GCardList));
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        if(GCardList.size()>0){
//            for(int x = 0; x < GCardList.get(0).size(); x++){
//                GcardItem gcardItem = new GcardItem(GCardList.get(0).get(x),
//                        GCardList.get(1).get(x),
//                        GCardList.get(2).get(x),
//                        GCardList.get(3).get(x));
//                gcardItemList.add(gcardItem);
//            }
//            adapter.setOnGCardItemClickListener(new Adapter_Gcard.onGCardItemClickListener() {
//                @RequiresApi(api = Build.VERSION_CODES.M)
//                @Override
//                public void onClick(String GCardNumber) {
//                    new LoadGCardNumber(mContext).loadGcard(GCardNumber,
//                            new LoadGCardNumber.onLoadGcardNumberListener() {
//                                @Override
//                                public void isOnlineResult() {
//                                    customToast.setMessage("Points and transactions has been imported successfully.");
//                                    customToast.setType(CustomToast.CustomToastType.INFORMATION);
//                                    customToast.show();
//                                }
//
//                                @Override
//                                public void isOfflineLoad() {
//                                    customToast.setMessage("GCard loaded successfully without importing data.");
//                                    customToast.setType(CustomToast.CustomToastType.INFORMATION);
//                                    customToast.show();
//                                }
//                            });
//                    new Fragment_DashBoard().getInstance().refreshUI();
//                    new Activity_DashBoard().getInstance().invalidateOptionsMenu();
//                    dialog.dismiss();
//                }
//            });
//            recyclerView.setLayoutManager(layoutManager);
//            recyclerView.setAdapter(adapter);
//        }
//    }

    private boolean isGcardDataValid(){
        if(txtGcardNumber.getText().toString().isEmpty()){
            return false;
        } else if(txtGcardNumber.getText().length()!=13){
            txtGcardNumber.setText("");
            return false;
        } else if(txtYear.getText().toString().isEmpty()){
            return false;
        } else if(txtYear.getText().length()!=4){
            txtYear.setText("");
            return false;
        } else if(txtMonth.getText().toString().isEmpty()){
            return false;
        } else return !txtDay.getText().toString().isEmpty();
    }

//    private String getTextLabel(){
//        int count = new GcardAppMaster(mContext).getGCardCount();
//        if(count == 0){
//            return "You haven't add any GCard number to your account yet.";
//        } else if (count == 1){
//            return "You have only one active GCard registered in this account";
//        }
//        return "Tap your selected GCard number below to set as your active GCard number.";
//    }

    private int getRecyclerViewVisibility(ArrayList<ArrayList<String>> GCardList){
        if(GCardList.size() == 0){
            return View.GONE;
        }
        return View.VISIBLE;
    }

    private String createBirthDate(){
        return txtYear.getText().toString() + "-" + txtMonth.getText().toString() + "-" + txtDay.getText().toString();
    }

    class InputTextWatcher implements TextWatcher{

        View view;

        InputTextWatcher(View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int id = view.getId();
            if(id == R.id.txt_dialog_gcard_selection_gcardNumber){
                isGCardNumberValid();
            } else if(id == R.id.txt_dialog_gcard_selection_birthYear){
                isYearValid();
            } else if(id == R.id.txt_dialog_gcard_selection_birthMonth){
                isMonthValid();
            } else if(id == R.id.txt_dialog_gcard_selection_birthDay){
                isDayValid();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private boolean isGCardNumberValid(){
        if(txtGcardNumber.getText().toString().isEmpty()){
            return false;
        } else return txtGcardNumber.getText().toString().length() >= 13;
    }

    private boolean isYearValid(){
        if(txtYear.getText().toString().isEmpty()){
            return false;
        } else if(txtYear.getText().toString().length() < 4){
            return false;
        } else {
            return false;
        }
    }

    private boolean isMonthValid(){
        try {
            if (txtMonth.getText().toString().isEmpty()) {
                return false;
            } else if (txtMonth.getText().toString().length() != 2) {
                return false;
            } else if (Integer.parseInt(txtMonth.getText().toString()) > 12) {
                txtMonth.setText("");
                return false;
            } else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    private boolean isDayValid(){
        try {
            if (txtDay.getText().toString().isEmpty()) {
                return false;
            } else if (txtDay.getText().toString().length() != 2) {
                return false;
            } else if (Integer.parseInt(txtDay.getText().toString()) > 31) {
                txtDay.setText("");
                return false;
            } else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

//    @SuppressLint("StaticFieldLeak")
//    class RefreshListTask extends AsyncTask<Integer, Integer, String>{
//
//        Dialog_Loading dialog_loading;
//
//        @SuppressLint("NewApi")
//        @Override
//        protected void onPreExecute() {
//            dialog_loading = new Dialog_Loading(mContext);
//            dialog_loading.setMessage("Refreshing list. Please wait.");
//            dialog_loading.showDialog();
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(Integer... integers) {
//            final String[] result = {""};
//            new ImportAccountGcard().sendRequest(mContext, new onImportResultListener() {
//                @Override
//                public void onSuccessImport() {
//                    result[0] = "success";
//                }
//
//                @Override
//                public void onErrorResult() {
//                    result[0] = "error";
//                }
//            });
//            return result[0];
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            dialog_loading.dismissDialog();
//            if(s.equalsIgnoreCase("success")){
//                refreshList();
//                new Fragment_DashBoard().getInstance().refreshUI();
//            }
//            super.onPostExecute(s);
//        }
//    }
}
