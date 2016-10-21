package com.example.mydagger;

import java.util.concurrent.Callable;

/**
 * Created by oleh on 11.10.16.
 */

public interface RetrofitInterface {
    Callable<String> getInfo();
}
