package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ContextUtils;
//import com.google.gson.internal.$Gson$Preconditions;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.AppConfig;
import org.rmj.g3appdriver.etc.GToast;
import org.rmj.g3appdriver.etc.LoadDialog;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_QrCodeScanner;
import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Gcard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMAddToCart;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.ArrayList;
import java.util.List;

public class Dialog_GcardSelection {
    private AlertDialog poDialogx;
    private AlertDialog.Builder loBuilder;
    private final Context context;
    private TextView lblGcard;
    private EditText txtGcardNumber;
    private EditText txtYear;
    private EditText txtMonth;
    private EditText txtDay;
    private RecyclerView recyclerView;
    private Toast toast;
    private List<EGcardApp> gcard;
    private RGcardApp gcardApp;
    private Application app;
    private MaterialButton btnCloseDialog, btnScnNewGcard, btnAddNewGcard, btnRefreshList;
    private VMDashboard mViewModel;
    private CustomToast customToast;
    private String message;
    public interface OnClientSelectListener{
        void OnAddNewGCard(AlertDialog dialog, String cardNo, String bdate);
        void onItemClick(AlertDialog dialog, String cardNo);
    }

    public Dialog_GcardSelection(Context context) {
        this.context = context;
        this.customToast = new CustomToast(context);
        this.loBuilder = new AlertDialog.Builder(context);
    }

    public void initDialog(List<EGcardApp> gcard, OnClientSelectListener listener){
        try{
            View v = LayoutInflater.from(context).inflate(R.layout.dialog_dashboard_gcard_selection, null, false);
            loBuilder.setCancelable(false)
                    .setView(v);
            poDialogx = loBuilder.create();
            poDialogx.setCancelable(false);

            lblGcard = v.findViewById(R.id.lbl_dialog_gcard_selection_label);
            txtGcardNumber = v.findViewById(R.id.txt_dialog_gcard_selection_gcardNumber);
            txtYear = v.findViewById(R.id.txt_dialog_gcard_selection_birthYear);
            txtMonth = v.findViewById(R.id.txt_dialog_gcard_selection_birthMonth);
            txtDay = v.findViewById(R.id.txt_dialog_gcard_selection_birthDay);

            btnRefreshList = v.findViewById(R.id.btn_dialog_refreshgcard);
            btnAddNewGcard = v.findViewById(R.id.btn_dialog_gcard_selection_addnewGcard);
            btnScnNewGcard = v.findViewById(R.id.btn_dialog_gcard_selection_scannewGcard);
            btnCloseDialog = v.findViewById(R.id.btn_dialog_gcard_selection_closeDialog);
            recyclerView = v.findViewById(R.id.recyclerview_dialog_gcard_selection);
            Adapter_Gcard adapter = new Adapter_Gcard(gcard);
            adapter.setOnGCardItemClickListener(new Adapter_Gcard.onGCardItemClickListener() {
                @Override
                public void onClick(String GCardNumber) {
                    listener.onItemClick(poDialogx,GCardNumber);
                }
            });
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            txtGcardNumber.addTextChangedListener(new InputTextWatcher(txtGcardNumber));
            txtYear.addTextChangedListener(new InputTextWatcher(txtYear));
            txtMonth.addTextChangedListener(new InputTextWatcher(txtMonth));
            txtDay.addTextChangedListener(new InputTextWatcher(txtDay));
//            btnRefreshList.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    new RefreshListTask().execute();
//                }
//            });
            btnAddNewGcard.setOnClickListener(view ->{
                if(isGcardDataValid()) {
                    String bday = txtYear.getText().toString() + "-" + txtMonth.getText().toString() + "-" + txtDay.getText().toString();
                    listener.OnAddNewGCard(poDialogx, txtGcardNumber.getText().toString(),bday);
                }else {
                    customToast.setMessage(message);
                    customToast.setType(CustomToast.CustomToastType.WARNING);
                    customToast.show();
                }

            });
            btnScnNewGcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, Activity_QrCodeScanner.class));
                }
            });

            btnCloseDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (poDialogx.getWindow().isFloating()){
                        poDialogx.dismiss();
                    }
                }
            });
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void show(){
        if(!poDialogx.isShowing()){
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
            poDialogx.show();
        }
        else{
            poDialogx.dismiss();
        }
    }

    private boolean isGcardDataValid(){
        return isGCardNumberValid() &&
                isYearValid() &&
                isMonthValid() &&
                isDayValid();
    }


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
            message = "Please check your Gcard details before proceeding.";
            return false;
        } else return txtGcardNumber.getText().toString().length() >= 13;
    }

    private boolean isYearValid(){
        message = "";
        if(txtYear.getText().toString().isEmpty()){
            message = "Year of birth required!";
            return false;
        } else if(txtYear.getText().toString().length() < 4){
            message = "Ivalid year of birth required!";
            return false;
        } else {
            return true;
        }
    }

    private boolean isMonthValid(){
        message = "";
        try {
            if (txtMonth.getText().toString().isEmpty()) {
                message = "month of birth required!";
                return false;
            } else if (txtMonth.getText().toString().length() != 2) {
                message = "Invalid month of birth required!";
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
        message = "";
        try {
            if (txtDay.getText().toString().isEmpty()) {
                message = "day of birth required!";
                return false;
            } else if (txtDay.getText().toString().length() != 2) {
                message = "day of birth required!";
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
