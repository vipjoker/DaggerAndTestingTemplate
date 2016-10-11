package com.example.mydagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oleh on 11.10.16.
 */
@Module
public class ModuleApp {

        @Provides()
        @Singleton
        @Named("Retrofit")
        RetrofitInterface provideContext() {
            return new Retrofit1();
        }

        @Provides
        @Singleton
        @Named("Retrofit2")
        RetrofitInterface provideDataManager() {
            return new Retrofit2();
        }
}
