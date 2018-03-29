package com.it.thoson.mvvmtutorial.di;

import com.it.thoson.mvvmtutorial.MyApplication;

import dagger.Module;

@Module
public class ApplicationModule {

    private MyApplication mainApplication;

    public ApplicationModule(MyApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

//    @Provides
//    @Singleton
//    MainApplication provideMainApplication() {
//        return mainApplication;
//    }
//
//    @Provides
//    @Singleton
//    SharedPreferences provideSharedPreferences(MainApplication mainApplication) {
//        return PreferenceManager.getDefaultSharedPreferences(mainApplication);
//    }
//
//    @Provides
//    @Singleton
//    Context provideContext() {
//        return mainApplication;
//    }

}
