package com.shishank.android;

import android.app.Application;

import lombok.Getter;
import timber.log.Timber;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Getter
    protected ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        apiComponent = DaggerApiComponent.create();
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
