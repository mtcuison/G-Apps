package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
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

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;

import java.io.IOException;
import java.util.Objects;

public class Activity_IDVerification extends AppCompatActivity {
    private static final String TAG = Activity_IDVerification.class.getSimpleName();

    private ImageView imgFront1, imgBack1, imgFront2, imgBack2;
    private AutoCompleteTextView spnID1, spnID2;

    private String psID1,
            psID2;

    private Dialog_SingleButton poDialogx;

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
                    String lsResult = getIntent().getStringExtra("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Identity Verification", "Your request for full verification has been submitted.", () -> poDialogx.dismiss());
                    } else {
                        String message = getIntent().getStringExtra("message");
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
        setContentView(R.layout.activity_id_verification);
        poDialogx = new Dialog_SingleButton(Activity_IDVerification.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Identity Verification");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        spnID1 = findViewById(R.id.tie_validIDNames);
        spnID2 = findViewById(R.id.tie_validIDNames1);

        imgFront1 = findViewById(R.id.img_frontID);
        imgBack1 = findViewById(R.id.img_backID);
        imgFront2 = findViewById(R.id.img_frontID1);
        imgBack2 = findViewById(R.id.img_backID1);

        if(getIntent().hasExtra("cSkippedx")){
            if (getIntent().getBooleanExtra("cSkippedx", true)) {
                findViewById(R.id.btn_Skip).setVisibility(View.VISIBLE);
            }
        }

        spnID1.setAdapter(new ArrayAdapter<>(Activity_IDVerification.this, android.R.layout.simple_dropdown_item_1line, AppConstants.ValidIDList));
        spnID1.setOnItemClickListener((parent, view, position, id) -> {
            if(spnID1.getText().toString().equalsIgnoreCase("others")){
                findViewById(R.id.lblSpecify).setVisibility(View.VISIBLE);
                findViewById(R.id.til_specifyID).setVisibility(View.VISIBLE);
            } else {
                psID1 = spnID1.getText().toString();
                findViewById(R.id.lblSpecify).setVisibility(View.GONE);
                findViewById(R.id.til_specifyID).setVisibility(View.GONE);
            }
            imgFront1.setImageBitmap(null);
            imgBack1.setImageBitmap(null);
        });

        spnID2.setAdapter(new ArrayAdapter<>(Activity_IDVerification.this, android.R.layout.simple_dropdown_item_1line, AppConstants.ValidIDList));
        spnID2.setOnItemClickListener((parent, view, position, id) -> {
            if(spnID2.getText().toString().equalsIgnoreCase("others")){
                findViewById(R.id.lblSpecify1).setVisibility(View.VISIBLE);
                findViewById(R.id.til_specifyID1).setVisibility(View.VISIBLE);
            } else {
                psID2 = spnID1.getText().toString();
                findViewById(R.id.lblSpecify1).setVisibility(View.GONE);
                findViewById(R.id.til_specifyID1).setVisibility(View.GONE);
            }
            imgFront2.setImageBitmap(null);
            imgBack2.setImageBitmap(null);
        });

        findViewById(R.id.btnSelectFront).setOnClickListener(v -> {
            if(psID1 != null) {
                ImageFileHandler.InitializeFileManager(poFileCooserF::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectBack).setOnClickListener(v -> {
            if(psID1 != null) {
                ImageFileHandler.InitializeFileManager(poFileCooserB::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectFront1).setOnClickListener(v -> {
            if(psID2 != null) {
                ImageFileHandler.InitializeFileManager(poFileCooserF1::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSelectBack1).setOnClickListener(v -> {
            if(psID2 != null) {
                ImageFileHandler.InitializeFileManager(poFileCooserB1::launch);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureFront).setOnClickListener(v -> {
            if(psID1 != null) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_FRONT_1);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureBack).setOnClickListener(v -> {
            if(psID1 != null) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_BACK_1);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 1 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureFront1).setOnClickListener(v -> {
            if(psID2 != null) {
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
                loIntent.putExtra("cCapturex", AppConstants.CAPTURE_FRONT_2);
                poScanner.launch(loIntent);
            } else {
                Toast.makeText(Activity_IDVerification.this, "Please select valid ID 2 first", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCaptureBack1).setOnClickListener(v -> {
            if(psID2 != null) {
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
            if(poFront1.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a front photo of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(poBackx1.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a back photo of your first valid ID", Toast.LENGTH_SHORT).show();
            } else if(poFront2.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a front photo of your second valid ID", Toast.LENGTH_SHORT).show();
            } else if(poBackx2.getImageNme() == null){
                Toast.makeText(Activity_IDVerification.this, "Please take a back photo of your second valid ID", Toast.LENGTH_SHORT).show();
            } else {

                JSONObject loFront1 = new JSONObject();
                loFront1.put("sSourceCD", poFront1.getSourceCD());
                loFront1.put("sSourceNo", poFront1.getSourceNo());
                loFront1.put("sDtlSrcNo", poFront1.getDtlSrcNo());
                loFront1.put("sFileCode", poFront1.getFileCode());
                loFront1.put("sImageNme", poFront1.getImageNme());
                loFront1.put("sMD5Hashx", poFront1.getMD5Hashx());
                loFront1.put("sFileLoct", poFront1.getFileLoct());
                loFront1.put("dCaptured", poFront1.getCaptured());

                JSONObject loBack1 = new JSONObject();
                loBack1.put("sSourceCD", poBackx1.getSourceCD());
                loBack1.put("sSourceNo", poBackx1.getSourceNo());
                loBack1.put("sDtlSrcNo", poBackx1.getDtlSrcNo());
                loBack1.put("sFileCode", poBackx1.getFileCode());
                loBack1.put("sImageNme", poBackx1.getImageNme());
                loBack1.put("sMD5Hashx", poBackx1.getMD5Hashx());
                loBack1.put("sFileLoct", poBackx1.getFileLoct());
                loBack1.put("dCaptured", poBackx1.getCaptured());

                JSONObject loFront2 = new JSONObject();
                loFront2.put("sSourceCD", poFront2.getSourceCD());
                loFront2.put("sSourceNo", poFront2.getSourceNo());
                loFront2.put("sDtlSrcNo", poFront2.getDtlSrcNo());
                loFront2.put("sFileCode", poFront2.getFileCode());
                loFront2.put("sImageNme", poFront2.getImageNme());
                loFront2.put("sMD5Hashx", poFront2.getMD5Hashx());
                loFront2.put("sFileLoct", poFront2.getFileLoct());
                loFront2.put("dCaptured", poFront2.getCaptured());

                JSONObject loBack2 = new JSONObject();
                loBack2.put("sSourceCD", poBackx2.getSourceCD());
                loBack2.put("sSourceNo", poBackx2.getSourceNo());
                loBack2.put("sDtlSrcNo", poBackx2.getDtlSrcNo());
                loBack2.put("sFileCode", poBackx2.getFileCode());
                loBack2.put("sImageNme", poBackx2.getImageNme());
                loBack2.put("sMD5Hashx", poBackx2.getMD5Hashx());
                loBack2.put("sFileLoct", poBackx2.getFileLoct());
                loBack2.put("dCaptured", poBackx2.getCaptured());

                JSONObject loJson = new JSONObject();
                loJson.put("oFrontIm1", loFront1);
                loJson.put("oBackImg1", loBack1);
                loJson.put("oFrontIm2", loFront2);
                loJson.put("oBackImg2", loBack2);
                Log.d(TAG, loJson.toString());
                Intent loIntent = new Intent(Activity_IDVerification.this, Activity_IDSumittion.class);
                loIntent.putExtra("oParametr", loJson.toString());
                poSubmit.launch(loIntent);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}