package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.rmj.g3appdriver.etc.ImageFileHandler;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.scanner.base.CropperErrorType;
import org.rmj.guanzongroup.useraccount.scanner.base.DocumentScanActivity;
import org.rmj.guanzongroup.useraccount.scanner.libraries.PolygonView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Activity_DocumentScanner extends DocumentScanActivity {

    private Toolbar toolbar;

    private String psPath;
    private int cCapturex;

    private FrameLayout holderImageCrop;
    private ImageView imageView;
    private PolygonView polygonView;

    private boolean isInverted;
    private Bitmap poBMap;

    private final ActivityResultLauncher poCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result != null) {
            try {
                if(result.getResultCode() == RESULT_OK) {
                    poBMap = ImageFileHandler.getImagePreview(psPath);
                } else {
                    finish();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            startCropping();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_scanner);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("cCapturex")){
            cCapturex = getIntent().getIntExtra("cCapturex", 0);
            ImageFileHandler.InitializeMainCamera(Activity_DocumentScanner.this, (intent, path) -> {
                psPath = path;
                poCamera.launch(intent);
            });
        }

        holderImageCrop = findViewById(R.id.holderImageCrop);
        imageView = findViewById(R.id.imageView);
        polygonView = findViewById(R.id.polygonView);

        findViewById(R.id.ivRotate).setOnClickListener(v -> disposable.add(
                Observable.fromCallable(() -> {
                            if (isInverted)
                                invertColor();
                            poBMap = rotateBitmap(poBMap, 90);
                            return false;
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((result) -> {
//                            hideProgressBar();
                            startCropping();
                        })
        ));

        findViewById(R.id.ivInvert).setOnClickListener(v -> {
            disposable.add(
                    Observable.fromCallable(() -> {
                                invertColor();
                                return false;
                            })
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((result) -> {
//                                hideProgressBar();
                                Bitmap scaledBitmap = scaledBitmap(poBMap, holderImageCrop.getWidth(), holderImageCrop.getHeight());
                                imageView.setImageBitmap(scaledBitmap);
                            })
            );
        });

        findViewById(R.id.ivRebase).setOnClickListener(v -> {
            try {
                poBMap = ImageFileHandler.getImagePreview(psPath).copy(poBMap.getConfig(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isInverted = false;
            startCropping();
        });

        findViewById(R.id.btnImageCrop).setOnClickListener(v -> {
            disposable.add(
                    Observable.fromCallable(() -> {
                                poBMap = getCroppedImage();
                                return poBMap != null;
                            })
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((result) -> {
//                                hideProgressBar();
                                if (poBMap != null) {
                                    Intent loIntent = new Intent();
                                    loIntent.putExtra("args", psPath);
                                    loIntent.putExtra("cCapturex", cCapturex);
                                    setResult(1, loIntent);
                                    finish();
//                                    setResult(RESULT_OK);
//                                    finish();
                                }
                            })
            );
        });

        findViewById(R.id.btnClose).setOnClickListener(v -> finish());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected FrameLayout getHolderImageCrop() {
        return holderImageCrop;
    }

    @Override
    protected ImageView getImageView() {
        return imageView;
    }

    @Override
    protected PolygonView getPolygonView() {
        return polygonView;
    }

    @Override
    protected void showProgressBar() {

    }

    @Override
    protected void hideProgressBar() {

    }

    @Override
    protected void showError(CropperErrorType errorType) {

    }

    @Override
    protected Bitmap getBitmapImage() {
        return poBMap;
    }

    private void invertColor(){
        if (!isInverted) {
            Bitmap bmpMonochrome = Bitmap.createBitmap(poBMap.getWidth(), poBMap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bmpMonochrome);
            ColorMatrix ma = new ColorMatrix();
            ma.setSaturation(0);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(ma));
            canvas.drawBitmap(poBMap, 0, 0, paint);
            poBMap = bmpMonochrome.copy(bmpMonochrome.getConfig(), true);
        } else {
            poBMap = poBMap.copy(poBMap.getConfig(), true);
        }
        isInverted = !isInverted;
    }

    private String saveToInternalStorage(Bitmap bitmapImage) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "CROP" + "_" + timeStamp + ".png";
        File storageDir = getExternalFilesDir( "/" + "DocumentScan" + "/" + "Cropped");
        //File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
//        String imageFileName = "cropped_" + timeStamp + ".png";
        File mypath = new File(storageDir, imageFileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR Exception", e.getMessage());
        }
        Log.e("Crop Image Path", mypath.getAbsolutePath());

        return storageDir.getAbsolutePath();
    }
}