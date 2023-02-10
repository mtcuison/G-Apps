package org.rmj.guanzongroup.useraccount.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import org.rmj.guanzongroup.documentscanner.DocScanner;
import org.rmj.guanzongroup.useraccount.R;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class Activity_DocumentScan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_scan);

        new DocScanner(Activity_DocumentScan.this).initScanner(new DocScanner.OnScanDocumentListener() {
            @Override
            public void OnScanned(Bitmap bitmap) {
                try {
                    String filename = "bitmap.png";
                    FileOutputStream stream = Activity_DocumentScan.this.openFileOutput(filename, Context.MODE_PRIVATE);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                    //Cleanup
                    stream.close();
                    bitmap.recycle();

                    //Pop intent
                    Intent loIntent = new Intent();
                    loIntent.putExtra("sImageInf", filename);
                    setResult(RESULT_OK, loIntent);
                    finish();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void OnFailed(String message) {
                setResult(RESULT_CANCELED);
                finish();
            }

            @Override
            public void OnCancelled() {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}