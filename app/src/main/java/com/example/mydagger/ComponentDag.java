package com.example.mydagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by oleh on 11.10.16.
 */
@Singleton
@Component(modules = {ModuleApp.class})
public interface ComponentDag{


        void inject(MainActivity activity);
        // void inject(MyFragment fragment);
        // void inject(MyService service);

}
