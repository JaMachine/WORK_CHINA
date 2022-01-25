package com.example.myapplication;

import static com.example.myapplication.AllInts.ticks;
import static com.example.myapplication.AllStrings.lingXiaoyu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private FireConnect fireConnect;
    private WebView flow;
    private WebSettings flowConfig;
    private Handler ticker;
    private ImageView screenHolder;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View overlay = findViewById(R.id.m_a);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        screenHolder = findViewById(R.id.screen_holder);
        fireConnect = new FireConnect(this);
        flow = findViewById(R.id.flow);
        flow.setWebViewClient(new WebViewClient());
        flow.setWebChromeClient(new WebChromeClient());
        flowConfig = flow.getSettings();
        flowConfig.setJavaScriptEnabled(true);
        startTicker();


    }

    private void startTicker() {
        --ticks;
        ticker = new Handler();
        ticker.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (lingXiaoyu.equals("empty")) {
                    if (ticks > 0) {
                        startTicker();
                    }
                    if (ticks < 1) {
                        startActivity(new Intent(MainActivity.this, Playa.class));
                    }
                } else {
                    flow.loadUrl(lingXiaoyu);
                    startLoader();
                }
            }
        }, 99);
    }

    private void startLoader() {
        --ticks;
        ticker = new Handler();
        ticker.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ticks > 0) {
                    if (!lingXiaoyu.equals(flow.getUrl())) {
                        screenHolder.setVisibility(View.GONE);
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                    } else startLoader();
                } else startActivity(new Intent(MainActivity.this, Playa.class));
            }
        }, 99);
    }

    @Override
    public void onBackPressed() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View overlay = findViewById(R.id.m_a);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        navBack();
    }

    private void navBack() {
        if (flow.canGoBack()) {
            flow.goBack();
            boolean x = true;
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View overlay = findViewById(R.id.m_a);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}