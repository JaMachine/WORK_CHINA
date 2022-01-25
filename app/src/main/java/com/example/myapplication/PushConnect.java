package com.example.myapplication;

import static com.example.myapplication.AllStrings.*;

import android.app.Application;

import com.onesignal.OneSignal;

public class PushConnect extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(OneSignalID);
    }
}
