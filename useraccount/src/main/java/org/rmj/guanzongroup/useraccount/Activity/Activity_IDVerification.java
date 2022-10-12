package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMUserVerification;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Activity_IDVerification extends AppCompatActivity {
    private static final String TAG = Activity_IDVerification.class.getSimpleName();

    private VMUserVerification mViewModel;

    private ImageView imgFront1, imgBack1, imgFront2, imgBack2;
    private AutoCompleteTextView spnID1, spnID2;
    private TextInputEditText txtExpire1,
            txtExpire2,
            txtIDNox1,
            txtIDNox2;

    private String psID1 = "",
            psID2 = "",
            psExpiry1 = "",
            psExpiry2 = "";

    private String cHasExp1,
            cHasExp2,
            cHasBck1,
            cHasBck2;

    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoad;

    private final RClientInfo.PhotoDetail poFront1 = new RClientInfo.PhotoDetail();
    private final RClientInfo.PhotoDetail poBackx1 = new RClientInfo.PhotoDetail();
    private final RClientInfo.PhotoDetail poFront2 = new RClientInfo.PhotoDetail();
    private final RClientInfo.PhotoDetail poBackx2 = new RClientInfo.PhotoDetail();

    private final ActivityResultLauncher<Intent> poSubmit = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getData() != null){
                Intent loIntent = result.getData();
                if (loIntent.hasExtra("result")) {
                    String lsResult = loIntent.getStringExtra("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Identity Verification", "Your request for full verification has been submitted.", () -> {
                            poDialogx.dismiss();
                            finish();
                        });
                    } else {
                        String message = loIntent.getStringExtra("message");
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Identity Verification", message, () -> poDialogx.dismiss());
                    }
                    poDialogx.show();
                }
            }
        }
    });

    private final ActivityResultLauncher<Intent> poScanner = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        try {
            if (result.getData() != null) {
                Intent loIntent = result.getData();
                if (loIntent.hasExtra("args")) {
                    String lsPath = loIntent.getStringExtra("args");
                    int cCapturex = loIntent.getIntExtra("cCapturex", 0);
                    String lsUserID = new AccountInfo(Activity_IDVerification.this).getUserID();
                    String lsFileNm = loIntent.getStringExtra("sImageNme");
                    switch (cCapturex){
                        case AppConstants.CAPTURE_FRONT_1:
                            poFront1.setCaptured(new AppConstants().DATE_MODIFIED);
                            poFront1.setFileCode(AppConstants.DOC_FILE_VALID_ID);
                            poFront1.setSourceCD(AppConstants.SOURCE_CODE);
                            poFront1.setDtlSrcNo(lsUserID);
                            poFront1.setSourceNo(lsUserID);
                            poFront1.setFileLoct(lsPath);
                            poFront1.setImageNme(lsFileNm);
                            imgFront1.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                            break;
                        case AppConstants.CAPTURE_BACK_1:
                            poBackx1.setCaptured(new AppConstants().DATE_MODIFIED);
                            poBackx1.setFileCode(AppConstants.DOC_FILE_VALID_ID);
                            poBackx1.setSourceCD(AppConstants.SOURCE_CODE);
                            poBackx1.setDtlSrcNo(lsUserID);
                            poBackx1.setSourceNo(lsUserID);
                            poBackx1.setFileLoct(lsPath);
                            poBackx1.setImageNme(lsFileNm);
                            imgBack1.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                            break;
                        case AppConstants.CAPTURE_FRONT_2:
                            poFront2.setCaptured(new AppConstants().DATE_MODIFIED);
                            poFront2.setFileCode(AppConstants.DOC_FILE_VALID_ID);
                            poFront2.setSourceCD(AppConstants.SOURCE_CODE);
                            poFront2.setDtlSrcNo(lsUserID);
                            poFront2.setSourceNo(lsUserID);
                            poFront2.setFileLoct(lsPath);
                            poFront2.setImageNme(lsFileNm);
                            imgFront2.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                            break;
                        default:
                            poBackx2.setCaptured(new AppConstants().DATE_MODIFIED);
                            poBackx2.setFileCode(AppConstants.DOC_FILE_VALID_ID);
                            poBackx2.setSourceCD(AppConstants.SOURCE_CODE);
                            poBackx2.setDtlSrcNo(lsUserID);
                            poBackx2.setSourceNo(lsUserID);
                            poBackx2.setFileLoct(lsPath);
                            poBackx2.setImageNme(lsFileNm);
                            imgBack2.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                            break;
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    });

    private final ActivityResultLauncher<Intent> poFileCooserF = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    Activity_IDVerification.this.getContentResolver(),
                                    selectedImageUri);
                            imgFront1.setImageBitmap(selectedImageBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    private final ActivityResultLauncher<Intent> poFileCooserB = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    Activity_IDVerification.this.getContentResolver(),
                                    selectedImageUri);
                            imgBack1.setImageBitmap(selectedImageBitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


    private final ActivityResultLauncher<Intent> poFileCooserF1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    Activity_IDVerification.this.getContentResolver(),
                                    selectedImageUri);
                            imgFront2.setImageBitmap(selectedImageBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    private final ActivityResultLauncher<Intent> poFileCooserB1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    Activity_IDVerification.this.getContentResolver(),
                                    selectedImageUri);
                            imgBack2.setImageBitmap(selectedImageBitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_IDVerification.this).get(VMUserVerification.class);
        setContentView(R.layout.activity_id_verification);
        poDialogx = new Dialog_SingleButton(Activity_IDVerification.this);
        poLoad = new Dialog_Loading(Activity_IDVerification.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Identity Verification");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        spnID1 = findViewById(R.id.tie_validIDNames);
        spnID2 = findViewById(R.id.tie_validIDNames1);
        txtIDNox1 = findViewById(R.id.tie_idNox);
        txtIDNox2 = findViewById(R.id.tie_idNo1);

        txtExpire1 = findViewById(R.id.tie_expryDte1);
        txtExpire2 = findViewById(R.id.tie_expryDte2);

        imgFront1 = findViewById(R.id.img_frontID);
        imgBack1 = findViewById(R.id.img_backID);
        imgFront2 = findViewById(R.id.img_frontID1);
        imgBack2 = findViewById(R.id.img_backID1);

        if(getIntent().hasExtra("cSkippedx")){
            if (getIntent().getBooleanExtra("cSkippedx", true)) {
                findViewById(R.id.btn_Skip).setVisibility(View.VISIBLE);
            }
        }

        mViewModel.ImportValidIDCode(new VMUserVerification.OnImportIDCode() {
            @Override
            public void OnLoad() {
            }

            @Override
            public void OnSuccess(List<JSONObject> idCode) {
                try {
                    ArrayList<String> lsIDList = new ArrayList<>();
                    for (int x = 0; x < idCode.size(); x++) {
                        lsIDList.add(idCode.get(x).getString("sIDNamexx"));
                    }

                    spnID1.setAdapter(new ArrayAdapter<>(Activity_IDVerification.this, android.R.layout.simple_dropdown_item_1line, lsIDList));
                    spnID1.setOnItemClickListener((parent, view, position, id) -> {
                        try {
                            for (int x = 0; x < idCode.size(); x++) {
                                if (spnID1.getText().toString().trim().equalsIgnoreCase(idCode.get(x).getString("sIDNamexx"))) {
                                    psID1 = idCode.get(x).getString("sIDCodexx");
                                    cHasExp1 = idCode.get(x).getString("cWithExpr");
                                    if(cHasExp1.equalsIgnoreCase("1")){
                                        findViewById(R.id.til_expryDte1).setVisibility(View.VISIBLE);
                                    } else {
                                        findViewById(R.id.til_expryDte1).setVisibility(View.GONE);
                                    }

                                    findViewById(R.id.textview).setVisibility(View.VISIBLE);
                                    findViewById(R.id.img_frontID).setVisibility(View.VISIBLE);
                                    findViewById(R.id.btnCaptureFront).setVisibility(View.VISIBLE);
                                    findViewById(R.id.btnSelectFront).setVisibility(View.VISIBLE);

                                    cHasBck1 = idCode.get(x).getString("cWithBack");
                                    if(cHasBck1.equalsIgnoreCase("1")){
                                        findViewById(R.id.textview1).setVisibility(View.VISIBLE);
                                        findViewById(R.id.img_backID).setVisibility(View.VISIBLE);
                                        findViewById(R.id.btnCaptureBack).setVisibility(View.VISIBLE);
                                        findViewById(R.id.btnSelectBack).setVisibility(View.VISIBLE);
                                    } else {
                                        findViewById(R.id.textview1).setVisibility(View.GONE);
                                        findViewById(R.id.img_backID).setVisibility(View.GONE);
                                        findViewById(R.id.btnCaptureBack).setVisibility(View.GONE);
                                        findViewById(R.id.btnSelectBack).setVisibility(View.GONE);
                                    }
                                    Log.d(TAG, "Selected ID 1: " + psID1);
                                    Log.d(TAG, "Has expiration 1: " + cHasExp1);
                                    Log.d(TAG, "Has back 1: " + cHasBck1);
                                    break;
                                }
                            }
                            imgFront1.setImageBitmap(null);
                            imgBack1.setImageBitmap(null);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    });

                    spnID2.setAdapter(new ArrayAdapter<>(Activity_IDVerification.this, android.R.layout.simple_dropdown_item_1line, lsIDList));
                    spnID2.setOnItemClickListener((parent, view, position, id) -> {
                        try {
                            if(spnID2.getText().toString().trim().equalsIgnoreCase(spnID1.getText().toString().trim())){
                                Toast.makeText(Activity_IDVerification.this, "Unable to use the same ID for second valid ID.", Toast.LENGTH_SHORT).show();
                                spnID2.setText("");
                            } else {
                                for (int x = 0; x < idCode.size(); x++) {
                                    if (spnID2.getText().toString().trim().equalsIgnoreCase(idCode.get(x).getString("sIDNamexx"))) {
                                        psID2 = idCode.get(x).getString("sIDCodexx");
                                        cHasExp2 = idCode.get(x).getString("cWithExpr");
                                        if(cHasExp2.equalsIgnoreCase("1")){
                                            findViewById(R.id.til_expryDte2).setVisibility(View.VISIBLE);
                                        } else {
                                            findViewById(R.id.til_expryDte2).setVisibility(View.GONE);
                                        }

                                        findViewById(R.id.textview1).setVisibility(View.VISIBLE);
                                        findViewById(R.id.img_frontID1).setVisibility(View.VISIBLE);
                                        findViewById(R.id.btnCaptureFront1).setVisibility(View.VISIBLE);
                                        findViewById(R.id.btnSelectFront1).setVisibility(View.VISIBLE);

                                        cHasBck2 = idCode.get(x).getString("cWithBack");
                                        if(cHasBck2.equalsIgnoreCase("1")){
                                            findViewById(R.id.textview2).setVisibility(View.VISIBLE);
                                            findViewById(R.id.img_backID1).setVisibility(View.VISIBLE);
                                            findViewById(R.id.btnCaptureBack1).setVisibility(View.VISIBLE);
                                            findViewById(R.id.btnSelectBack1).setVisibility(View.VISIBLE);
                                        } else {
                                            findViewById(R.id.textview2).setVisibility(View.GONE);
                                            findViewById(R.id.img_backID1).setVisibility(View.GONE);
                                            findViewById(R.id.btnCaptureBack1).setVisibility(View.GONE);
                                            findViewById(R.id.btnSelectBack1).setVisibility(View.GONE);
                                        }
                                        Log.d(TAG, "Selected ID 2: " + psID2);
                                        Log.d(TAG, "Has expiration 2: " + cHasExp2);
                                        Log.d(TAG, "Has back 2: " + cHasBck2);
                                        break;
                                    }
                                }
                                imgFront2.setImageBitmap(null);
                                imgBack2.setImageBitmap(null);
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    });

                } catch (Exception e){
                    e.printStackTrace();
                    finish();
                }
            }

            @Override
            public void OnFailed(String message) {
            }
        });

        txtExpire1.setOnClickListener(v -> {
            final Calendar newCalendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            final DatePickerDialog StartTime = new DatePickerDialog(Activity_IDVerification.this, (view131, year, monthOfYear, dayOfMonth) -> {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String lsDate = dateFormatter.format(newDate.getTime());
                Log.d(TAG, "Valid ID 1 expiration date: " + lsDate);
                psExpiry1 = lsDate;
                txtExpire1.setText(getDate(lsDate));
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            StartTime.getDatePicker().setMinDate(new Date().getTime());
            StartTime.show();
        });

        txtExpire2.setOnClickListener(v -> {
            final Calendar newCalendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            final DatePickerDialog StartTime = new DatePickerDialog(Activity_IDVerification.this, (view131, year, monthOfYear, dayOfMonth) -> {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String lsDate = dateFormatter.format(newDate.getTime());
                Log.d(TAG, "Valid ID 2 expiration date: " + lsDate);
                psExpiry2 = lsDate;
                txtExpire2.setText(getDate(lsDate));
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            StartTime.getDatePicker().setMinDate(new Date().getTime());
            StartTime.show();
        });

        findViewById(R.id.btnSelectFront).setOnClickListener(v -> {
            if(!psID1.trim().isEmpty()) {
                ImageFileHandler.InitializeFileManager(poFileCooserF::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectBack).setOnClickListener(v -> {
            if(!psID1.trim().isEmpty()) {
                ImageFileHandler.InitializeFileManager(poFileCooserB::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectFront1).setOnClickListener(v -> {
            if(!psID2.trim().isEmpty()) {
                ImageFileHandler.InitializeFileManager(poFileCooserF1::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectBack1).setOnClickListener(v -> {
            if(!psID2.trim().isEmpty()) {
                ImageFileHandler.InitializeFileManager(poFileCooserB1::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureFront).setOnClickListener(v -> {
            if(!psID1.trim().isEmpty()) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_FRONT_1);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureBack).setOnClickListener(v -> {
            if(!psID1.trim().isEmpty()) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_BACK_1);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureFront1).setOnClickListener(v -> {
            if(!psID2.trim().isEmpty()) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_FRONT_2);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureBack1).setOnClickListener(v -> {
            if(!psID2.trim().isEmpty()) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_BACK_2);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_Submit).setOnClickListener(v -> submitForVerification());

        findViewById(R.id.btn_Skip).setOnClickListener(v -> finish());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void submitForVerification(){
        try {
            Log.d(TAG, "Valid ID 1 name: " + psID1);
            Log.d(TAG, "Valid ID 1 name: " + psID2);
            Log.d(TAG, "ID Number 1: " + Objects.requireNonNull(txtIDNox1.getText()).toString().trim());
            Log.d(TAG, "ID Number 2: " + Objects.requireNonNull(txtIDNox2.getText()).toString().trim());
            Log.d(TAG, "Has expiration 1: " + cHasExp1);
            Log.d(TAG, "Has expiration 2: " + cHasExp2);
            Log.d(TAG, "Expiry Date 1: " + psExpiry1);
            Log.d(TAG, "Expiry Date 2: " + psExpiry2);
            if(psID1.trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter the name of first valid ID", Toast.LENGTH_SHORT).show();
            } else if(psID2.trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter the name of second valid ID", Toast.LENGTH_SHORT).show();
            } else if(cHasExp1.equalsIgnoreCase("1") &&
                    psExpiry1.trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter the expiration date of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(cHasExp2.equalsIgnoreCase("1") &&
                    psExpiry2.trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter the expiration date of your second valid ID", Toast.LENGTH_SHORT).show();
            } else if(txtIDNox1.getText().toString().trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter ID number of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(txtIDNox2.getText().toString().trim().isEmpty()){
                Toast.makeText(Activity_IDVerification.this, "Please enter ID number date of your second valid ID", Toast.LENGTH_SHORT).show();
            } else if(poFront1.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a front photo of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(cHasBck1.equalsIgnoreCase("1") && poBackx1.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a back photo of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(poFront2.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a front photo of your second valid ID", Toast.LENGTH_SHORT).show();
            } else if(cHasBck2.equalsIgnoreCase("1") && poBackx2.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a back photo of your second valid ID", Toast.LENGTH_SHORT).show();
            } else {
                //Parent
                JSONObject loJson = new JSONObject();

                //Child
                JSONObject loFront1 = new JSONObject();
                loFront1.put("sSourceCD", poFront1.getSourceCD());
                loFront1.put("sSourceNo", poFront1.getSourceNo());
                loFront1.put("sDtlSrcNo", poFront1.getDtlSrcNo());
                loFront1.put("sFileCode", poFront1.getFileCode());
                loFront1.put("sImageNme", poFront1.getImageNme());
                loFront1.put("sMD5Hashx", poFront1.getMD5Hashx());
                loFront1.put("sFileLoct", poFront1.getFileLoct());
                loFront1.put("dCaptured", poFront1.getCaptured());
                Log.d(TAG, loFront1.toString());

                JSONObject loBack1 = new JSONObject();
                if(cHasBck1.equalsIgnoreCase("1")) {
                    loBack1.put("sSourceCD", poBackx1.getSourceCD());
                    loBack1.put("sSourceNo", poBackx1.getSourceNo());
                    loBack1.put("sDtlSrcNo", poBackx1.getDtlSrcNo());
                    loBack1.put("sFileCode", poBackx1.getFileCode());
                    loBack1.put("sImageNme", poBackx1.getImageNme());
                    loBack1.put("sMD5Hashx", poBackx1.getMD5Hashx());
                    loBack1.put("sFileLoct", poBackx1.getFileLoct());
                    loBack1.put("dCaptured", poBackx1.getCaptured());
                    loJson.put("oBackImg1", loBack1);
                    Log.d(TAG, loBack1.toString());
                }

                JSONObject loFront2 = new JSONObject();
                loFront2.put("sSourceCD", poFront2.getSourceCD());
                loFront2.put("sSourceNo", poFront2.getSourceNo());
                loFront2.put("sDtlSrcNo", poFront2.getDtlSrcNo());
                loFront2.put("sFileCode", poFront2.getFileCode());
                loFront2.put("sImageNme", poFront2.getImageNme());
                loFront2.put("sMD5Hashx", poFront2.getMD5Hashx());
                loFront2.put("sFileLoct", poFront2.getFileLoct());
                loFront2.put("dCaptured", poFront2.getCaptured());
                Log.d(TAG, loFront2.toString());

                JSONObject loBack2 = new JSONObject();
                if(cHasBck2.equalsIgnoreCase("1")) {
                    loBack2.put("sSourceCD", poBackx2.getSourceCD());
                    loBack2.put("sSourceNo", poBackx2.getSourceNo());
                    loBack2.put("sDtlSrcNo", poBackx2.getDtlSrcNo());
                    loBack2.put("sFileCode", poBackx2.getFileCode());
                    loBack2.put("sImageNme", poBackx2.getImageNme());
                    loBack2.put("sMD5Hashx", poBackx2.getMD5Hashx());
                    loBack2.put("sFileLoct", poBackx2.getFileLoct());
                    loBack2.put("dCaptured", poBackx2.getCaptured());
                    loJson.put("oBackImg2", loBack2);
                    Log.d(TAG, loBack2.toString());
                }

                JSONObject params = new JSONObject();
                params.put("sIDName1x", psID1);
                params.put("sIDName2x", psID2);
                params.put("sIDNmbr1x", txtIDNox1.getText().toString().trim());
                params.put("sIDNmbr2x", txtIDNox2.getText().toString().trim());
                params.put("cHasExp1x", cHasExp1);
                params.put("cHasExp2x", cHasExp2);
                params.put("dExpiry1x", psExpiry1);
                params.put("dExpiry2x", psExpiry2);
                params.put("sIDBack1x", "");
                params.put("sIDBack2x", "");
                params.put("sIDFrnt1x", poFront1.getImageNme());
                params.put("sIDFrnt2x", poFront2.getImageNme());

                if(cHasBck1.equalsIgnoreCase("1")){
                    params.put("sIDBack1x", poBackx1.getImageNme());
                } else {
                }

                if(cHasBck2.equalsIgnoreCase("1")){
                    params.put("sIDBack2x", poBackx2.getImageNme());
                }
                Log.d(TAG, params.toString());

                loJson.put("sDataDetl", params);
                loJson.put("oFrontIm1", loFront1);
                loJson.put("oFrontIm2", loFront2);
                Log.d(TAG, loJson.toString());
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_IDSumittion.class);
                loIntent.putExtra("oParametr", loJson.toString());
                poSubmit.launch(loIntent);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getDate(String val){
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        String formattedDate = null;
        try {
            formattedDate = formatter.format(fromUser.parse(val));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}