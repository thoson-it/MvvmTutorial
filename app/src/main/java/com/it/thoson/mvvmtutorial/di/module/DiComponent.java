package com.it.thoson.mvvmtutorial.di.module;

import com.it.thoson.mvvmtutorial.di.ApplicationModule;
import com.it.thoson.mvvmtutorial.view.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        ApplicationModule.class
})
public interface DiComponent {
//
//    void inject(MainActivity activity);
//
//    void inject(ListVideoFragment fragment);

    void inject(LoginActivity loginActivity);
}
