package com.example.myapplication;

import static android.content.ContentValues.TAG;
import static com.example.myapplication.AllStrings.lingXiaoyu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private FireConnect fireConnect;
    private WebView flow;
    WebSettings flowConfig;
    Handler ticker;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.test);
        fireConnect = new FireConnect(this);
        flow = findViewById(R.id.flow);
        flow.setWebViewClient(new WebViewClient());
        flow.setWebChromeClient(new WebChromeClient());
        flowConfig = flow.getSettings();
        flowConfig.setJavaScriptEnabled(true);
        Log.e(TAG, "XIAO = " + lingXiaoyu);
        startTicker();


    }

    private void startTicker() {
        ticker = new Handler();
        ticker.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (lingXiaoyu.equals("empty")) startTicker();
                else flow.loadUrl(lingXiaoyu);
            }
        }, 123);
    }


}