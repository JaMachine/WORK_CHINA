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
import java.util.ArrayList;
import java.util.List;

public class Playa extends AppCompatActivity {
    TextView cash, flow;
    CashVariableUnit cashUnit;
    List<ImageView> s;

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
        s = new ArrayList<>();
        s.add(findViewById(R.id.s1));
        s.add(findViewById(R.id.s2));
        s.add(findViewById(R.id.s3));
        s.add(findViewById(R.id.s4));
        s.add(findViewById(R.id.s5));
        s.add(findViewById(R.id.s6));
        s.add(findViewById(R.id.s7));
        s.add(findViewById(R.id.s8));
        s.add(findViewById(R.id.s9));
        s.add(findViewById(R.id.s10));
        s.add(findViewById(R.id.s11));
        s.add(findViewById(R.id.s12));
        s.add(findViewById(R.id.s13));
        s.add(findViewById(R.id.s14));
        s.add(findViewById(R.id.s15));
        for (ImageView view : s) {
            randominoid(view);
        }
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

    private void randominoid(ImageView view) {
        int chooser = (int) (Math.random() * 12) + 1;
        switch (chooser) {
            case 1:
                view.setImageResource(R.drawable.s_1);
                break;
            case 2:
                view.setImageResource(R.drawable.s_2);
                break;
            case 3:
                view.setImageResource(R.drawable.s_3);
                break;
            case 4:
                view.setImageResource(R.drawable.s_4);
                break;
            case 5:
                view.setImageResource(R.drawable.s_5);
                break;
            case 6:
                view.setImageResource(R.drawable.s_6);
                break;
            case 7:
                view.setImageResource(R.drawable.s_7);
                break;
            case 8:
                view.setImageResource(R.drawable.s_8);
                break;
            case 9:
                view.setImageResource(R.drawable.s_9);
                break;
            case 10:
                view.setImageResource(R.drawable.s_10);
                break;
            case 11:
                view.setImageResource(R.drawable.s_11);
                break;
            case 12:
                view.setImageResource(R.drawable.s_12);
                break;


        }
    }
}