package com.gmail.demidovich.classwork1.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String KEY_LINK = "KEY_LINK";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String intentExtras = intent.getStringExtra(KEY_LINK);
        Log.e("IntentService", "Intent service: " + intentExtras);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("IntentService", "IntentService onDestroy");
    }
}
