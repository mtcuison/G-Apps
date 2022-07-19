package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.guanzongroup.useraccount.R;

public class Activity_IDVerification extends AppCompatActivity {

    private ImageView imageView;
    private String currentPhotoPath;

    private final ActivityResultLauncher poLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        ImageFileHandler.setImagePreview(currentPhotoPath, imageView);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_verification);
        imageView = findViewById(R.id.imageView);
        ImageFileHandler.InitializeCamera(Activity_IDVerification.this, (intent, path) -> {
            currentPhotoPath = path;
            poLauncher.launch(intent);
        });
    }
}