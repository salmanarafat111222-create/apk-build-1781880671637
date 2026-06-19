package com.app.main;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.view.*;
import android.graphics.Color;
public class MainActivity extends Activity {
    WebView w;
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE); getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w=new WebView(this); w.setBackgroundColor(Color.BLACK); setContentView(w);
        WebSettings s=w.getSettings();
        s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
        s.setLoadWithOverviewMode(true); s.setUseWideViewPort(true);
        s.setAllowFileAccess(true); s.setAllowFileAccessFromFileURLs(true);
        s.setAllowUniversalAccessFromFileURLs(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        w.setWebViewClient(new WebViewClient());
        w.setWebChromeClient(new WebChromeClient());
        w.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed(){if(w.canGoBack())w.goBack();else super.onBackPressed();}
}