package com.example.mydagger;

import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.internal.operators.observable.ObservableInterval;

/**
 * Created by oleh on 11.10.16.
 */

public class Retrofit1 implements RetrofitInterface {
    @Override
    public Callable<String> getInfo() {

        return ()->{
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Log.e("Retrofit","Inerrupted");
        }
            return "Retrofit 1";
        };
    }
}
