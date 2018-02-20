package com.gmail.demidovich.classwork1.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// here lies an events that I subscribe
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //intent.getAction();
        Log.e("RECEIVE", "MESSAGE RECEIVER");
    }
}
