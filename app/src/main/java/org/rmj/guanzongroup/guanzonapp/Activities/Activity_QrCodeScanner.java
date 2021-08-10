package org.rmj.guanzongroup.guanzonapp.Activities;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMQrCodeScanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class Activity_QrCodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private static final String TAG = Activity_QrCodeScanner.class.getSimpleName();

    private ZXingScannerView scanner;
    private VMQrCodeScanner mViewModel;
    private CodeGenerator codeGenerator;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scanner);
        mViewModel = ViewModelProviders.of(this).get(VMQrCodeScanner.class);
        scanner = findViewById(R.id.scanner);
        codeGenerator = new CodeGenerator();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Dexter.withActivity(this)
                    .withPermission(Manifest.permission.CAMERA)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                            scanner.setResultHandler(Activity_QrCodeScanner.this);
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
    }


    @Override
    protected void onDestroy() {
        scanner.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
//        new Fragment_DashBoard();
//        Fragment_DashBoard.newInstance().showScanResult(rawResult.toString());
        Intent intent = new Intent();
        intent.putExtra("result", rawResult.toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}
