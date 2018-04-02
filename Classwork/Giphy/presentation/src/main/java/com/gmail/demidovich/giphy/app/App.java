package com.gmail.demidovich.giphy.app;

import android.app.Application;

import com.gmail.demidovich.giphy.injection.AppComponent;
import com.gmail.demidovich.giphy.injection.AppModule;
import com.gmail.demidovich.giphy.injection.DaggerAppComponent;

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
