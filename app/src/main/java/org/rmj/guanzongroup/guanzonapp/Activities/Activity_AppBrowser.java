package org.rmj.guanzongroup.guanzonapp.Activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.rmj.guanzongroup.guanzonapp.R;

public class Activity_AppBrowser extends AppCompatActivity {
    private static final String TAG = Activity_AppBrowser.class.getSimpleName();

    private Toolbar toolbar;
    private WebView webView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_browser);
        setupWidgets();


    }

   private void setupWidgets(){
        toolbar = findViewById(R.id.toolbar_appBrowser);
        webView = findViewById(R.id.webView_appBrowser);
        progressBar = findViewById(R.id.progress_bar_appBrowser);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
