package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;
import org.rmj.guanzongroup.digitalgcard.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Activity_QrCodeScanner extends AppCompatActivity {

    private ZXingScannerView scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scanner);

        scanner = findViewById(R.id.scanner);
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        scanner.setResultHandler(rawResult -> {
                            CodeGenerator loCode = new CodeGenerator();
                            loCode.setEncryptedQrCode(rawResult.toString());
                            if(loCode.isQrCodeApplication()){
                                Intent loIntent = new Intent();
                                loIntent.putExtra("args", rawResult.toString());
                                setResult(1, loIntent);
                                finish();
                            } else {
                                Intent loIntent = new Intent();
                                loIntent.putExtra("args", rawResult.toString());
                                setResult(2, loIntent);
                                finish();
                            }
                        });
                        scanner.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(Activity_QrCodeScanner.this, "Please allow the permision", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .check();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}