package com.gmail.demidovich.classwork1.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gmail.demidovich.classwork1.R;

public class Classwork5Activity extends AppCompatActivity {

    private LocalBroadcastManager mLocalBroadcastManager;

    private static final String TAG = Classwork5Activity.class.getSimpleName();

    // just a little piece of unique!
    private static final String ACTION_MY_MESSAGE = "com.gmail.demidovich.classwork1.classwork5.ACTION_MY_MESSAGE";

    private Button mButtonCW5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(Classwork5Activity.this);
        setContentView(R.layout.activity_classwork5);
        mButtonCW5 = findViewById(R.id.button_cw5);
        mButtonCW5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_MY_MESSAGE);
                mLocalBroadcastManager.sendBroadcast(intent);

                //sendBroadcast(intent);
            }
        });

        Intent intentService = new Intent(this, MyService.class);
        startService(intentService);

        Intent intentService2 = new Intent(this, MyIntentService.class);
        intentService2.putExtra(MyIntentService.KEY_LINK, "http://film1");
        startService(intentService2);

        Intent intentService3 = new Intent(this, MyIntentService.class);
        intentService3.putExtra(MyIntentService.KEY_LINK, "http://film2");
        startService(intentService3);

        Intent intentService4 = new Intent(this, MyIntentService.class);
        intentService4.putExtra(MyIntentService.KEY_LINK, "http://film3");
        startService(intentService4);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.e(TAG, "MY MESSAGE FROM ACTIVITY");
        /*    boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            if (isAirplaneModeOn) {
                Log.e(TAG, "MESSAGE FROM ACTIVITY ON");
            } else {
                Log.e(TAG, "MESSAGE FROM ACTIVITY OFF");
            }*/
        }
    };

    // here we subscribe to broadcast:
    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);

        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);
    }

    // and here unsubscribe
    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(this, MyService.class));
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }
}
