package org.rmj.guanzongroup.useraccount.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMUserVerification;

import java.util.ArrayList;
import java.util.List;

public class Activity_IDSumittion extends AppCompatActivity {

    private VMUserVerification mViewModel;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_IDSumittion.this).get(VMUserVerification.class);
        setContentView(R.layout.activity_idsumittion);

        progressBar = findViewById(R.id.progress_horizontal);

        if(getIntent().hasExtra("oParametr")){
            String lsParams = getIntent().getStringExtra("oParametr");

            try {
                JSONObject params = new JSONObject(lsParams);

                RClientInfo.PhotoDetail poFront1 = new RClientInfo.PhotoDetail();
                RClientInfo.PhotoDetail poBackx1 = new RClientInfo.PhotoDetail();
                RClientInfo.PhotoDetail poFront2 = new RClientInfo.PhotoDetail();
                RClientInfo.PhotoDetail poBackx2 = new RClientInfo.PhotoDetail();

                JSONObject loFront1 = params.getJSONObject("oFrontIm1");
                poFront1.setFileLoct(loFront1.getString("sSourceCD"));
                poFront1.setFileLoct(loFront1.getString("sSourceNo"));
                poFront1.setFileLoct(loFront1.getString("sDtlSrcNo"));
                poFront1.setFileLoct(loFront1.getString("sFileCode"));
                poFront1.setFileLoct(loFront1.getString("sImageNme"));
                poFront1.setFileLoct(loFront1.getString("sMD5Hashx"));
                poFront1.setFileLoct(loFront1.getString("sFileLoct"));
                poFront1.setFileLoct(loFront1.getString("dCaptured"));

                JSONObject loBack1 = params.getJSONObject("oBackImg1");
                poBackx1.setFileLoct(loBack1.getString("sSourceCD"));
                poBackx1.setFileLoct(loBack1.getString("sSourceNo"));
                poBackx1.setFileLoct(loBack1.getString("sDtlSrcNo"));
                poBackx1.setFileLoct(loBack1.getString("sFileCode"));
                poBackx1.setFileLoct(loBack1.getString("sImageNme"));
                poBackx1.setFileLoct(loBack1.getString("sMD5Hashx"));
                poBackx1.setFileLoct(loBack1.getString("sFileLoct"));
                poBackx1.setFileLoct(loBack1.getString("dCaptured"));

                JSONObject loFront2 = params.getJSONObject("oFrontIm2");
                poFront2.setFileLoct(loFront2.getString("sSourceCD"));
                poFront2.setFileLoct(loFront2.getString("sSourceNo"));
                poFront2.setFileLoct(loFront2.getString("sDtlSrcNo"));
                poFront2.setFileLoct(loFront2.getString("sFileCode"));
                poFront2.setFileLoct(loFront2.getString("sImageNme"));
                poFront2.setFileLoct(loFront2.getString("sMD5Hashx"));
                poFront2.setFileLoct(loFront2.getString("sFileLoct"));
                poFront2.setFileLoct(loFront2.getString("dCaptured"));

                JSONObject loBack2 = params.getJSONObject("oBackImg2");
                poBackx2.setFileLoct(loBack2.getString("sSourceCD"));
                poBackx2.setFileLoct(loBack2.getString("sSourceNo"));
                poBackx2.setFileLoct(loBack2.getString("sDtlSrcNo"));
                poBackx2.setFileLoct(loBack2.getString("sFileCode"));
                poBackx2.setFileLoct(loBack2.getString("sImageNme"));
                poBackx2.setFileLoct(loBack2.getString("sMD5Hashx"));
                poBackx2.setFileLoct(loBack2.getString("sFileLoct"));
                poBackx2.setFileLoct(loBack2.getString("dCaptured"));

                List<RClientInfo.PhotoDetail> loDetail = new ArrayList<>();
                loDetail.add(poFront1);
                loDetail.add(poBackx1);
                loDetail.add(poFront2);
                loDetail.add(poBackx2);

                mViewModel.UploadIDVerification(loDetail, new VMUserVerification.OnIDVerificationSubmitCallback() {
                    @Override
                    public void OnProgress(int progress) {
                        progressBar.setProgress(progress);
                    }

                    @Override
                    public void OnSuccess(String message) {
                        Intent loIntent = new Intent();
                        loIntent.putExtra("result", "success");
                        setResult(1, loIntent);
                        finish();
                    }

                    @Override
                    public void OnFailed(String message) {
                        Intent loIntent = new Intent();
                        loIntent.putExtra("result", "error");
                        loIntent.putExtra("message", message);
                        setResult(1, loIntent);
                        finish();
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}