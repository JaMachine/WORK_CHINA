package com.example.myapplication;

import static com.example.myapplication.AllStrings.startCash;
import static com.example.myapplication.AllStrings.startFlow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class Playa extends AppCompatActivity {
    TextView cash, flow;
    CashVariableUnit cashUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setContentView(R.layout.activity_playa);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View overlay = findViewById(R.id.p_a);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        cash = findViewById(R.id.cash);
        flow = findViewById(R.id.flow);
        cashUnit = new CashVariableUnit();
        cash.setText(startCash);
        flow.setText(startFlow);
        flow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double d = cashUnit.stringToDouble(flow.getText().toString());
                d += 1;
                if (d > 50) {
                    d = 1;
                }
                flow.setText(cashUnit.doubleToString(d));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View overlay = findViewById(R.id.p_a);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}