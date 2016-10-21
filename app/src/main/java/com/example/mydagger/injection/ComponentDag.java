package com.example.mydagger.injection;

import com.example.mydagger.view.MainActivity;
import com.example.mydagger.ModuleApp;
import com.example.mydagger.view.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by oleh on 11.10.16.
 */
@Singleton
@Component(modules = {ModuleApp.class})
public interface ComponentDag{
        void inject(SecondActivity activity);

        void inject(MainActivity activity);
        // void inject(MyFragment fragment);
        // void inject(MyService service);

}
