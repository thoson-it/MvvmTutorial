package com.it.thoson.mvvmtutorial;

import android.app.Application;

import com.it.thoson.mvvmtutorial.di.module.DaggerDiComponent;
import com.it.thoson.mvvmtutorial.di.module.DiComponent;
import com.it.thoson.mvvmtutorial.di.module.NetworkModule;

import java.io.File;

/**
 * Created by sonlt on 3/29/18.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initDagger();
    }

    private DiComponent diComponent;

    private void initDagger() {
        File cacheFile = new File(getCacheDir(), "responses");
        diComponent = DaggerDiComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .build();
    }

    public DiComponent getDiComponent() {
        return diComponent;
    }
}
