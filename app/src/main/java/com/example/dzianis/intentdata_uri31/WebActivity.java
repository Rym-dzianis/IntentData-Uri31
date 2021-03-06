package com.example.dzianis.intentdata_uri31;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl(getIntent().getData().toString());
        webView.setWebViewClient(new WebViewClient());
    }
}
