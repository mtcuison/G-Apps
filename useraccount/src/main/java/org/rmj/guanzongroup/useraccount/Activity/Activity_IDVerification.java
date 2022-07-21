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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.guanzongroup.useraccount.R;

import java.io.IOException;

public class Activity_IDVerification extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgFront, imgBack;
    private Spinner spnID;
    private String currentPhotoPath;

    private final ActivityResultLauncher poScanner = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        try {
            if (result != null) {
                Intent loIntent = result.getData();
                if (loIntent.hasExtra("args")) {
                    String lsPath = loIntent.getStringExtra("args");
                    int cCapturex = loIntent.getIntExtra("cCapturex", 0);
                    if (cCapturex == AppConstants.CAPTURE_FRONT) {
                        imgFront.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                    } else {
                        imgBack.setImageBitmap(ImageFileHandler.getImagePreview(lsPath));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    });

    private final ActivityResultLauncher poFileCooserF = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
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
                            imgFront.setImageBitmap(selectedImageBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    private final ActivityResultLauncher poFileCooserB = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
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
                            imgBack.setImageBitmap(selectedImageBitmap);
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
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Identity Verification");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spnID = findViewById(R.id.spn_validIDNames);
        imgFront = findViewById(R.id.img_frontID);
        imgBack = findViewById(R.id.img_backID);

        if(getIntent().hasExtra("cSkippedx")){
            if (getIntent().getBooleanExtra("cSkippedx", true)) {
                findViewById(R.id.btn_Skip).setVisibility(View.VISIBLE);
            }
        }

        spnID.setAdapter(new ArrayAdapter<>(Activity_IDVerification.this, android.R.layout.simple_dropdown_item_1line, AppConstants.ValidIDList));
        spnID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spnID.getSelectedItem().toString().toLowerCase().equalsIgnoreCase("others")){
                    findViewById(R.id.lblSpecify).setVisibility(View.VISIBLE);
                    findViewById(R.id.til_specifyID).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.lblSpecify).setVisibility(View.GONE);
                    findViewById(R.id.til_specifyID).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.btnSelectFront).setOnClickListener(v -> ImageFileHandler.InitializeFileManager(intent -> poFileCooserF.launch(intent)));

        findViewById(R.id.btnSelectBack).setOnClickListener(v -> ImageFileHandler.InitializeFileManager(intent -> poFileCooserB.launch(intent)));

        findViewById(R.id.btnCaptureFront).setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
            loIntent.putExtra("cCapturex", AppConstants.CAPTURE_FRONT);
            poScanner.launch(loIntent);
        });

        findViewById(R.id.btnCaptureBack).setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_IDVerification.this, Activity_DocumentScanner.class);
            loIntent.putExtra("cCapturex", AppConstants.CAPTURE_BACK);
            poScanner.launch(loIntent);
        });

        findViewById(R.id.btn_Skip).setOnClickListener(v -> {
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
}