package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.rmj.guanzongroup.notifications.R;

public class Activity_Browser extends AppCompatActivity {
    private static final String TAG = Activity_Browser.class.getSimpleName();

    private Toolbar toolbar;
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView loading;
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
//        progressBar = findViewById(R.id.progress_bar_appBrowser);
        loading = findViewById(R.id.imgLoading);
//        progressBar.setMax(100);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getIntent().getStringExtra("args").equalsIgnoreCase("1")){
            getSupportActionBar().setTitle("Promos");
        }else if(getIntent().getStringExtra("args").equalsIgnoreCase("1")){
            getSupportActionBar().setTitle("Events");
        } else {
            getSupportActionBar().setTitle("Privacy & Policy");
        }
    }

    private void ConfigureAppBrowser(){
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
    }

    private void LoadLink(){
        webView.loadUrl(getIntent().getStringExtra("url_link"));

//        progressBar.setProgress(0);
        webView.setWebViewClient(new AppBrowserWebViewClient());
        webView.setWebChromeClient(new AppBrowserChromeClient());
    }

    class AppBrowserWebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webView.loadUrl(getIntent().getStringExtra("url_link"));
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            urlClipBoard = url;
            super.onPageFinished(view, url);
//            progressBar.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    class AppBrowserChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            progressBar.setProgress(newProgress);
            Log.e("progress :", String.valueOf(newProgress));
            if(newProgress == 100){
//                progressBar.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }


}