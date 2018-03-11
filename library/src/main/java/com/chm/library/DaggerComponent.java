package com.chm.library;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by xiaobailong24 on 2017/9/16.
 * Dagger Library Component
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        DaggerModule.class})
public interface DaggerComponent {
    Application application();

    void inject(DaggerDelegate daggerDelegate);
}
