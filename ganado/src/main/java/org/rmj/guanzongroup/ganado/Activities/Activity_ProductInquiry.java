package org.rmj.guanzongroup.ganado.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import org.rmj.g3appdriver.etc.FormatUIText;
import org.rmj.g3appdriver.etc.MessageBox;
import org.rmj.g3appdriver.lib.Ganado.model.GConstants;
import org.rmj.g3appdriver.lib.Ganado.pojo.InstallmentInfo;
import org.rmj.g3appdriver.utils.ImageFileManager;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.OnSaveInfoListener;
import org.rmj.guanzongroup.ganado.ViewModel.VMProductInquiry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Activity_ProductInquiry extends AppCompatActivity {
    private VMProductInquiry mViewModel;
    private MessageBox poMessage;
    private MaterialTextView txtBranchNm, txtBrandNm, txtModelNm, txtModelCd, txtMinDP;
    private TextInputEditText txtDownPymnt,txtDownPymnt1, txtAmort, txtDTarget,txtCashPrice;
    private MaterialAutoCompleteTextView spn_color, spnPayment, spnPayment1, spnAcctTerm;
    private LinearLayout linearInstallment;
    private MaterialButton btnContinue,btnCalculate;
    private ShapeableImageView imgMC;
    private TextView myMP;
    private String MP;
    private String lsModelID, lsBrandID, lsImgLink, lsBrandNm,Buwanan;
    private double minimumDownpayment, lnInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_inquiry);
        initWidgets();

        spnPayment.setText(GConstants.PAYMENT_FORM[0]);
        spnPayment1.setText(GConstants.PAYMENT_FORM[0]);
        spnPayment.setAdapter(GConstants.getAdapter(Activity_ProductInquiry.this, GConstants.PAYMENT_FORM));
        spnPayment.setOnItemClickListener(new OnItemClickListener(spnPayment));
        spnAcctTerm.setText(GConstants.INSTALLMENT_TERM[0]);
        spnAcctTerm.setAdapter(GConstants.getAdapter(Activity_ProductInquiry.this, GConstants.INSTALLMENT_TERM));
        mViewModel.setBrandID(getIntent().getStringExtra("lsBrandID"));
        mViewModel.setModelID(getIntent().getStringExtra("lsModelID"));
        lsBrandID = getIntent().getStringExtra("lsBrandID");
        lsModelID = getIntent().getStringExtra("lsModelID");
        lsImgLink = getIntent().getStringExtra("lsImgLink");
        lsBrandNm = getIntent().getStringExtra("lsBrandNm");
        Log.e("sBrandIDx",lsBrandID);
        Log.e("sModelIDx",lsModelID);

        mViewModel.getModel().setBrandIDx(lsBrandID);
        mViewModel.getModel().setModelIDx(lsModelID);
        mViewModel.getModel().setTermIDxx("36");
        mViewModel.getModel().setPaymForm("0");
//        mViewModel.getModel().getCashPrce();
        mViewModel.GetModelColor(lsModelID).observe(Activity_ProductInquiry.this, colorList->{
        mViewModel.getModel().setColorIDx(colorList.get(0).getColorIDx());

        });
        mViewModel.GetModelBrand(lsBrandID, lsModelID).observe(Activity_ProductInquiry.this, eMcModel -> {
            try {
                txtModelCd.setText(eMcModel.getModelCde());
                txtModelNm.setText(eMcModel.getModelNme());
                txtBrandNm.setText(getIntent().getStringExtra("lsBrandNm"));
                String imgLink = (lsImgLink == null)? "": lsImgLink;

                ImageFileManager.LoadImageToView(lsImgLink, imgMC);
                Log.d("image mo ito",lsImgLink);
            }catch (NullPointerException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetModelColor(lsModelID).observe(Activity_ProductInquiry.this, colorList->{
            try {
                ArrayList<String> string = new ArrayList<>();
                for (int x = 0; x < colorList.size(); x++) {
                    String lsColor = colorList.get(x).getColorNme();
                    //                        String lsTown =  loList.get(x).sProvName ;
                    string.add(lsColor);

                }
                ArrayAdapter<String> adapters = new ArrayAdapter<>(Activity_ProductInquiry.this, android.R.layout.simple_spinner_dropdown_item, string.toArray(new String[0]));
                spn_color.setText(colorList.get(0).getColorNme());
                spn_color.setAdapter(adapters);
            }catch (NullPointerException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        spn_color.setSelection(0);
        spn_color.setOnItemClickListener(new OnItemClickListener(spn_color));
        spnAcctTerm.setOnItemClickListener(new OnItemClickListener(spnAcctTerm));
        txtDownPymnt.addTextChangedListener(new FormatUIText.CurrencyFormat(txtDownPymnt));
        txtDownPymnt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // The EditText lost focus, perform your action here
                    // For example, you can validate the input or save the data
                    // into a database.
                    // Your code here...
                    if(txtDownPymnt1.getText().toString().trim().isEmpty()){
                        poMessage.initDialog();
                        poMessage.setTitle("Ganado");
                        poMessage.setMessage("Downpayment field is required!");
                        poMessage.setPositiveButton("Okay", new MessageBox.DialogButton() {
                            @Override
                            public void OnButtonClick(View view, AlertDialog dialog) {
                                dialog.dismiss();
                            }
                        });
                    }
                    Calculate();

                }
            }
        });
        txtDTarget.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    Calculate();
                    mViewModel.getModel().setMonthAmr(String.valueOf(myMP.getText()));
                }
            }
        });


        mViewModel.GetModelID().observe(Activity_ProductInquiry.this, modelID -> {
            try{
                mViewModel.GetCashPrice(modelID).observe(this, cashPrice -> {
                    mViewModel.getModel().setCashPrce(cashPrice.CashPrce);
                    mViewModel.getModel().setPricexxx(cashPrice.Pricedxx);
                    txtCashPrice.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(cashPrice.CashPrce)));
                });
//                mViewModel.GetCashInfo(modelID).observe(this, cashPrice -> {
//                    Log.e("cashPrice",cashPrice.CashPrce + "");
////                    if(cashPrice.CashPrce != null){
////                        txtCashPrice.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(cashPrice.CashPrce)));
////                    }
//                });
//                if(mViewModel.GetCashInfo(modelID) !=  null){
//                    Log.e("cashPrice",FormatUIText.getCurrencyUIFormat(String.valueOf(mViewModel.GetCashInfo(modelID).CashPrce)) + "");
//                    txtCashPrice.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(mViewModel.GetCashInfo(modelID).CashPrce)));
//                    mViewModel.getModel().setCashPrce(cashPrice.CashPrce);
//                    mViewModel.getModel().setPricexxx(cashPrice.Pricedxx);
//                    txtCashPrce.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(cashPrice.CashPrce)));
//                }else{
//                    txtCashPrice.setText(FormatUIText.getCurrencyUIFormat("0.0"));
//                    Log.e("cashPrice",FormatUIText.getCurrencyUIFormat("0.0"));
//                }
                mViewModel.GetMinimumDownpayment(modelID, new VMProductInquiry.OnRetrieveInstallmentInfo() {
                    @Override
                    public void OnRetrieve(InstallmentInfo loResult) {
                        Log.e("getMonthlyAmortization",FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMonthlyAmortization())) + "");
                        Log.e("getMonthlyAmortization",FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMinimumDownpayment())) + "");
                        //txtDownPymnt.setText(String.valueOf(loResult.getMinimumDownpayment()));
                        txtDownPymnt1.setText(String.valueOf(loResult.getMinimumDownpayment()));
                        txtMinDP.setText("The required Minimum Downpayment is at least " + String.valueOf(loResult.getMinimumDownpayment()) + " Pesos");
//                        mViewModel.getModel().setMonthAmr(String.valueOf(loResult.getMonthlyAmortization()));
//                        txtAmort.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMonthlyAmortization())));

                        minimumDownpayment = loResult.getMinimumDownpayment();
//                        double mnmDPInput = Double.parseDouble(FormatUIText.getCurrencyUIFormat(String.valueOf(txtDownPymnt1.getText())));
                        //lnInput = Double.parseDouble(FormatUIText.getCurrencyUIFormat(String.valueOf(txtDownPymnt1.getText())));
                         //mViewModel.getModel().setDownPaym(String.valueOf(FormatUIText.getCurrencyUIFormat(lsInput)));
                        Log.d("input DP", String.valueOf(txtDownPymnt1.getText()));
                    }

                    @Override
                    public void OnFailed(String message) {

                    }
                });
            } catch (NullPointerException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        });
//        txtDTarget.setOnClickListener(v -> {
//            final Calendar newCalendar = Calendar.getInstance();
//            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
//
//            // Set the maximum date to one month from the current date
//            newCalendar.add(Calendar.MONTH, 1);
//            long maxDateInMillis = newCalendar.getTimeInMillis();
//
//            final DatePickerDialog StartTime = new DatePickerDialog(Activity_ProductInquiry.this,
//                    android.R.style.Theme_Holo_Dialog, (view131, year, monthOfYear, dayOfMonth) -> {
//                try {
//                    Calendar newDate = Calendar.getInstance();
//                    newDate.set(year, monthOfYear, dayOfMonth);
//
//                    // Check if the selected date is within one month from the current date
//                    if (newDate.getTimeInMillis() <= maxDateInMillis) {
//                        String lsDate = dateFormatter.format(newDate.getTime());
//                        txtDTarget.setText(lsDate);
//                        Date loDate = new SimpleDateFormat("MMMM dd, yyyy").parse(lsDate);
//                        lsDate = new SimpleDateFormat("yyyy-MM-dd").format(loDate);
//                        mViewModel.getModel().setTargetxx(lsDate);
//                    } else {
//                        // Show an error message or handle the case when the selected date is outside the allowed range
//                        Toast.makeText(Activity_ProductInquiry.this, "Please select a date within one month from the current date", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//
//            StartTime.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//            StartTime.getDatePicker().setMaxDate(maxDateInMillis); // Set the maximum date
//
//            StartTime.show();
//        });
        txtDTarget.setOnClickListener(v -> {
            final Calendar newCalendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");

            // Set the maximum date to one month from the current date
            newCalendar.add(Calendar.MONTH, 1);
            long maxDateInMillis = newCalendar.getTimeInMillis();

            final DatePickerDialog StartTime = new DatePickerDialog(Activity_ProductInquiry.this,
                    android.R.style.Theme_Holo_Dialog, (view131, year, monthOfYear, dayOfMonth) -> {
                try {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    // Check if the selected date is within one month from the current date
                    if (newDate.getTimeInMillis() <= maxDateInMillis) {
                        String lsDate = dateFormatter.format(newDate.getTime());
                        txtDTarget.setText(lsDate);
                        Calculate();
                        Date loDate = new SimpleDateFormat("MMMM dd, yyyy").parse(lsDate);
                        lsDate = new SimpleDateFormat("yyyy-MM-dd").format(loDate);
                        mViewModel.getModel().setTargetxx(lsDate);
                    } else {
                        // Show an error message or handle the case when the selected date is outside the allowed range
                        Toast.makeText(Activity_ProductInquiry.this, "Please select a date within one month from the current date", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

            // Set the default selection to the current date
            StartTime.getDatePicker().init(
                    newCalendar.get(Calendar.YEAR),
                    newCalendar.get(Calendar.MONTH),
                    newCalendar.get(Calendar.DAY_OF_MONTH),
                    null
            );

            StartTime.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            StartTime.getDatePicker().setMaxDate(maxDateInMillis); // Set the maximum date

            StartTime.show();

        });


//        txtDTarget.setOnClickListener(v -> {
//            final Calendar newCalendar = Calendar.getInstance();
//            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
//            final DatePickerDialog StartTime = new DatePickerDialog(Activity_ProductInquiry.this,
//                    android.R.style.Theme_Holo_Dialog, (view131, year, monthOfYear, dayOfMonth) -> {
//                try {
//                    Calendar newDate = Calendar.getInstance();
//                    newDate.set(year, monthOfYear, dayOfMonth);
//                    String lsDate = dateFormatter.format(newDate.getTime());
//                    txtDTarget.setText(lsDate);
//                    Date loDate = new SimpleDateFormat("MMMM dd, yyyy").parse(lsDate);
//                    lsDate = new SimpleDateFormat("yyyy-MM-dd").format(loDate);
//                    mViewModel.getModel().setTargetxx(lsDate);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//            StartTime.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//            StartTime.show();
//        });

//        btnCalculate.setOnClickListener(view -> {
//            String lsInput = txtDownPymnt.getText().toString().trim();
////
//            Double lnInput = FormatUIText.getParseDouble(lsInput);
//            mViewModel.CalculateNewDownpayment(lsModelID, Integer.parseInt(mViewModel.getModel().getTermIDxx()), lnInput, new VMProductInquiry.OnCalculateNewDownpayment() {
//                @Override
//                public void OnCalculate(double lnResult) {
//                    txtAmort.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(lnResult)));
//                }
//
//                @Override
//                public void OnFailed(String message) {
//                    poMessage.initDialog();
//                    poMessage.setTitle("Product Inquiry");
//                    poMessage.setMessage(message);
//                    poMessage.setPositiveButton("Okay", (view1, dialog) -> dialog.dismiss());
//                    poMessage.show();
//                    txtAmort.setText("0");
//                }
//            });
//        });


        btnContinue.setOnClickListener(view ->{


            lnInput = Double.parseDouble(txtDownPymnt1.getText().toString().trim());

                Calculate();
                //mViewModel.getModel().setMonthAmr(String.valueOf(txtAmort.getText()));
            Log.d("after calc", String.valueOf(String.valueOf(myMP.getText())));
                mViewModel.SaveData(new OnSaveInfoListener() {
                    @Override
                    public void OnSave(String args) {

                        Log.e("TransNox", args);
                        Intent loIntent = new Intent(Activity_ProductInquiry.this, Activity_ClientInfo.class);
                        loIntent.putExtra("sTransNox", args);
                        startActivity(loIntent);
                        overridePendingTransition(R.anim.anim_intent_slide_in_right, R.anim.anim_intent_slide_out_left);
                        finish();
                    }

                    @Override
                    public void OnFailed(String message) {
                        poMessage.initDialog();
                        poMessage.setTitle("Product Inquiry");
                        poMessage.setMessage(message);
                        poMessage.setPositiveButton("Okay", (view1, dialog) -> dialog.dismiss());
                        poMessage.show();
                    }
                });
        });
    }

    private void initWidgets(){
        mViewModel = new ViewModelProvider(Activity_ProductInquiry.this).get(VMProductInquiry.class);
        poMessage = new MessageBox(Activity_ProductInquiry.this);
        MaterialToolbar toolbar = findViewById(R.id.toolbar_Inquiry);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//
        linearInstallment = findViewById(R.id.linearInstallment);
        myMP = findViewById(R.id.lblMonthly);
        txtBrandNm = findViewById(R.id.lblBrand);
        txtModelCd = findViewById(R.id.lblModelCde);
        txtModelNm = findViewById(R.id.lblModelNme);
        txtDownPymnt = findViewById(R.id.txt_downpayment);
        txtDownPymnt1 = findViewById(R.id.txt_mindownpayment);
        txtCashPrice = findViewById(R.id.txt_cashPrice);
        txtAmort = findViewById(R.id.txt_monthlyAmort);
        txtDTarget = findViewById(R.id.txt_targetDate);
        spnPayment = findViewById(R.id.spn_paymentMethod);
        spnPayment1 = findViewById(R.id.paymMethod);
        spnAcctTerm = findViewById(R.id.spn_installmentTerm);
        spn_color = findViewById(R.id.spn_color);
        imgMC = findViewById(R.id.imgMC);
        txtMinDP = findViewById(R.id.txtyourmnmdp);

        btnContinue = findViewById(R.id.btnContinue);
        btnCalculate = findViewById(R.id.btnCalculate);
        loadInstallment(View.GONE);
        txtDownPymnt1.setEnabled(false);
    }
    private  void  msgBox(){
        if (lnInput<minimumDownpayment){
            poMessage.initDialog();
            poMessage.setTitle("Product Inquiry");
            poMessage.setMessage("The minimum down payment is less than the required minimum amount.");
            poMessage.setPositiveButton("Okay", (view1, dialog) -> dialog.dismiss());
            poMessage.show();
            txtDownPymnt1.setText(String.valueOf(minimumDownpayment));
//            Calculate();
        }
    }
    private void loadInstallment(int isLoad){
        linearInstallment.setVisibility(isLoad);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed () {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_intent_slide_in_left, R.anim.anim_intent_slide_out_right);
    }

    @Override
    protected void onDestroy () {
        getViewModelStore().clear();
        super.onDestroy();
    }

    private class OnItemClickListener implements AdapterView.OnItemClickListener {

        private final View loView;

        public OnItemClickListener(View loView) {
            this.loView = loView;
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(loView == spn_color){
                mViewModel.GetModelColor(lsModelID).observe(Activity_ProductInquiry.this, colorList->{
                    mViewModel.getModel().setColorIDx(colorList.get(i).getColorIDx());

                });
            } else if(loView == spnPayment) {
                if (i == 0) {
                    loadInstallment(View.GONE);
                    txtDownPymnt1.setEnabled(false);
                } else {
                    loadInstallment(View.VISIBLE);
                    txtDownPymnt1.setEnabled(true);
                    spnAcctTerm.setSelection(0);
                }
                mViewModel.getModel().setPaymForm(String.valueOf(i));

            } else if(loView == spnAcctTerm){
                if(i==0){
                    mViewModel.getModel().setTermIDxx("36");
                }else if(i==1){
                    mViewModel.getModel().setTermIDxx("24");
                }else if(i==2){
                    mViewModel.getModel().setTermIDxx("12");
                }


                String lsInput = txtDownPymnt1.getText().toString().trim();
                Double lnInput = FormatUIText.getParseDouble(lsInput);
                double lnMonthly = mViewModel.GetMonthlyAmortization(Integer.parseInt(mViewModel.getModel().getTermIDxx()));
                txtAmort.setText(String.valueOf(lnMonthly));
                myMP.setText(String.valueOf(lnMonthly));
                mViewModel.CalculateNewDownpayment(lsModelID, Integer.parseInt(mViewModel.getModel().getTermIDxx()), lnInput, new VMProductInquiry.OnCalculateNewDownpayment() {

                    public void OnCalculate(double lnResult) {
                        txtAmort.setText(String.valueOf(lnResult));
                        myMP.setText(String.valueOf(lnResult));
                    }


                    public void OnFailed(String message) {
                        txtAmort.setText("0");
                        myMP.setText("0");
                    }
                });


            }
//            Calculate();
        }
    }
    private void Calculate(){
        String lsInput = Objects.requireNonNull(txtDownPymnt1.getText()).toString().trim();
        lnInput = FormatUIText.getParseDouble(lsInput);
        mViewModel.getModel().setDownPaym(String.valueOf(lnInput));

        msgBox();
        mViewModel.CalculateNewDownpayment(lsModelID, Integer.parseInt(mViewModel.getModel().getTermIDxx()), lnInput, new VMProductInquiry.OnCalculateNewDownpayment() {

            public void OnCalculate(double lnResult) {
                myMP.setText(String.valueOf(lnResult));
                mViewModel.getModel().setMonthAmr(String.valueOf(lnResult));
                Log.d("MONTHLY PAYM", String.valueOf(lnResult));
            }


            public void OnFailed(String message) {
                txtAmort.setText("0");
                mViewModel.getModel().setMonthAmr("0.0");

                Log.d("ito false", String.valueOf(myMP.getText()));
            }

        });

    }

}
