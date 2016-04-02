package com.raditya.goldprice;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 02/04/2016.
 */
public class GoldPriceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
