package org.rmj.guanzongroup.useraccount.Activity;

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
import android.widget.ImageView;

import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.guanzongroup.useraccount.R;

import java.io.IOException;

public class Activity_ProfileVerification extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageView imageView;

    private String psPath;

    private final ActivityResultLauncher poCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result != null) {
            try {
                if(result.getResultCode() == RESULT_OK) {
                    imageView.setImageBitmap(ImageFileHandler.getImagePreview(psPath));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    private final ActivityResultLauncher poFileChooser = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
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
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_verification);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Selfie Verification");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.img_profile);

        if(getIntent().hasExtra("cSkippedx")){
            if (getIntent().getBooleanExtra("cSkippedx", true)) {
                findViewById(R.id.btn_Skip).setVisibility(View.VISIBLE);
            }
        }

        findViewById(R.id.btnSelect).setOnClickListener(v -> ImageFileHandler.InitializeFileManager(intent -> poFileChooser.launch(intent)));

        findViewById(R.id.btnCapture).setOnClickListener(v -> {
            ImageFileHandler.InitializeFrontCamera(Activity_ProfileVerification.this, (intent, path) -> {
                psPath = path;
                poCamera.launch(intent);
            });
        });


        findViewById(R.id.btn_Submit).setOnClickListener(v -> {

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
}