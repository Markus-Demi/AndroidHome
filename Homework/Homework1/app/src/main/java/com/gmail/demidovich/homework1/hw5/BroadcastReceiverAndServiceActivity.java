package com.gmail.demidovich.homework1.hw5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gmail.demidovich.homework1.R;

public class BroadcastReceiverAndServiceActivity extends AppCompatActivity {

    private static final String ACTION_MY_MESSAGE = "com.gmail.demidovich.homework1.hw5.ACTION_MY_MESSAGE";
    private static final String TAG = "My Tag for BReceiver";

    private Button mButton;

    //private ConnectivityManager mConnectivityManager;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            /*mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wifi = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (wifi.isConnected() || wifi.isAvailable()) {
                Log.e(TAG, "Wi-Fi is bumped");
            }*/
            Log.e(TAG, "Wi-Fi is bumped");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastreceiver_and_service);

        mButton = findViewById(R.id.button_wi_fi_id);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BroadcastReceiverAndServiceActivity.this, "smthng!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }
}
