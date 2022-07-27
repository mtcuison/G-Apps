package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMUserVerification;

import java.io.IOException;
import java.util.Objects;

public class Activity_ProfileVerification extends AppCompatActivity {

    private VMUserVerification mViewModel;

    private Toolbar toolbar;
    private ImageView imageView;

    private String psPath;
    private RClientInfo.PhotoDetail poPhoto;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

    private final ActivityResultLauncher<Intent> poCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result != null) {
            try {
                if(result.getResultCode() == RESULT_OK) {
                    imageView.setImageBitmap(ImageFileHandler.getImagePreview(psPath));
                    initializePhotoDetail();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    private final ActivityResultLauncher<Intent> poFileChooser = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
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
                                    Activity_ProfileVerification.this.getContentResolver(),
                                    selectedImageUri);
                            imageView.setImageBitmap(selectedImageBitmap);
                            initializePhotoDetail();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ProfileVerification.this).get(VMUserVerification.class);
        setContentView(R.layout.activity_profile_verification);
        poPhoto = new RClientInfo.PhotoDetail();
        poLoading = new Dialog_Loading(Activity_ProfileVerification.this);
        poDialogx = new Dialog_SingleButton(Activity_ProfileVerification.this);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Selfie Verification");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.img_profile);

        if(getIntent().hasExtra("cSkippedx")){
            if (getIntent().getBooleanExtra("cSkippedx", true)) {
                findViewById(R.id.btn_Skip).setVisibility(View.VISIBLE);
            }
        }

        findViewById(R.id.btnSelect).setOnClickListener(v -> ImageFileHandler.InitializeFileManager(intent -> poFileChooser.launch(intent)));

        findViewById(R.id.btnCapture).setOnClickListener(v -> {
            ImageFileHandler.InitializeFrontCamera(Activity_ProfileVerification.this, (intent, path, fileName) -> {
                psPath = path;
                poCamera.launch(intent);
            });
        });


        findViewById(R.id.btn_Submit).setOnClickListener(v -> {
            mViewModel.UploadForVerification(poPhoto, new VMUserVerification.OnSelfieVerificationSubmitCallback() {
                @Override
                public void OnLoad() {
                    poLoading.initDialog("Selfie Verification", "Uploading selfie verification. Please wait...");
                    poLoading.show();
                }

                @Override
                public void OnSuccess(String message) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", message, () -> {
                        poDialogx.dismiss();
                        Intent loIntent = new Intent(Activity_ProfileVerification.this, Activity_IDVerification.class);
                        loIntent.putExtra("cSkippedx", false);
                        startActivity(loIntent);
                        finish();
                        finish();
                    });
                    poDialogx.show();
                }

                @Override
                public void OnFailed(String message) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", message, () -> {
                        poDialogx.dismiss();
                    });
                    poDialogx.show();
                }
            });
        });

        findViewById(R.id.btn_Skip).setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_ProfileVerification.this, Activity_IDVerification.class);
            loIntent.putExtra("cSkippedx", true);
            startActivity(loIntent);
            finish();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializePhotoDetail(){
        String lsUserID = new AccountInfo(Activity_ProfileVerification.this).getUserID();

        poPhoto.setCaptured(new AppConstants().DATE_MODIFIED);
        poPhoto.setFileCode(AppConstants.DOC_FILE_APPLICANT_PHOTO);
        poPhoto.setSourceCD(AppConstants.SOURCE_CODE);
        poPhoto.setDtlSrcNo(lsUserID);
        poPhoto.setSourceNo(lsUserID);
        poPhoto.setFileLoct(psPath);
    }
}