package com.gmail.demidovich.homework1.hw5;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private MyBinder mBinder;
    private WifiManager mWifiManager;

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    public void changeWiFiState() {
        mWifiManager.setWifiEnabled(!mWifiManager.isWifiEnabled());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mBinder = new MyBinder();
        return mBinder;
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
