package com.gmail.demidovich.homework1.hw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gmail.demidovich.homework1.R;

public class BroadcastReceiverAndServiceActivity extends AppCompatActivity {

    private static final String TAG = "My Tag for BReceiver";

    private WifiManager mWifiManager;

    private ImageView mImageView;
    private Button mButton;

    private ServiceConnection mServiceConnection;
    private boolean mBound = false;
    private MyService.MyBinder mBinder;

    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBound) {
            unbindService(mServiceConnection);
        }
        mBound = false;
        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastreceiver_and_service);
        mImageView = findViewById(R.id.wifi_image_view);
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkWiFi();
            }
        };
        registerReceiver(mBroadcastReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (MyService.MyBinder) service;
                mBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mBound = false;
            }
        };

        bindService(new Intent(this, MyService.class), mServiceConnection, BIND_AUTO_CREATE);
        mButton = findViewById(R.id.button_wi_fi_id);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    mBinder.getService().changeWiFiState();
                }
            }
        });

        checkWiFi();
    }

    public void checkWiFi() {
        if (mWifiManager.isWifiEnabled()) {
            mImageView.setImageResource(R.drawable.ic_wi_fi_on);
            mButton.setText(R.string.turn_off_wi_fi);
            Log.e(TAG, "Wi-Fi is ON");
        } else {
            mImageView.setImageResource(R.drawable.ic_wi_fi_off);
            mButton.setText(R.string.turn_on_wi_fi);
            Log.e(TAG, "Wi-Fi is OFF");
        }
    }
}
