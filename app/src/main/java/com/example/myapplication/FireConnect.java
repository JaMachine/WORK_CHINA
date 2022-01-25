package com.example.myapplication;

import static com.example.myapplication.AllStrings.lingXiaoyu;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class FireConnect {
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private Activity activity;
    private String fetch;

    public FireConnect(Activity activity) {
        this.activity = activity;
        connect();
    }

    private void connect() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        getString();
    }

    private void getString() {
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(activity, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            fetch = mFirebaseRemoteConfig.getString("tiger_shark");
                            lingXiaoyu = fetch;
                        }
                    }
                });
    }
}
