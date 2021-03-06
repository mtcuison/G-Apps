package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import org.rmj.guanzongroup.guanzonapp.R;

import java.io.File;
import java.io.IOException;

public class Activity_Browser extends AppCompatActivity {
    private static final String TAG = Activity_Browser.class.getSimpleName();

    private Toolbar toolbar;
    private WebView webView;
    private ProgressBar progressBar;

    private String mCM;
    private ValueCallback<Uri> mUM;
    private ValueCallback<Uri[]> mUMA;
    private final static int FCR=1;

    private String urlClipBoard = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        initWidgets();
        ConfigureAppBrowser();
        LoadLink();

    }
    void initWidgets(){
        toolbar = findViewById(R.id.toolbar_appBrowser);
        webView = findViewById(R.id.webView_appBrowser);
        progressBar = findViewById(R.id.progress_bar_appBrowser);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getIntent().getStringExtra("args").equalsIgnoreCase("1")){
            getSupportActionBar().setTitle("Promos");
        }else{
            getSupportActionBar().setTitle("Events");
        }
    }

    private void ConfigureAppBrowser(){
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

    }

    private void LoadLink(){
        webView.loadUrl(getIntent().getStringExtra("url_link"));
        webView.setWebViewClient(new AppBrowserWebViewClient());
//        webView.setWebChromeClient(new AppBrowserChromeClient());
    }

    class AppBrowserWebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            progressBar.setVisibility(View.VISIBLE);
            webView.loadUrl(getIntent().getStringExtra("url_link"));
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            urlClipBoard = url;
            progressBar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}