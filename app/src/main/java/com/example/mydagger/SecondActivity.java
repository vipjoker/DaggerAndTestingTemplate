package com.example.mydagger;

import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by oleh on 11.10.16.
 */

public class SecondActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.second_acitivity);
//        DaggerComponentDag.builder().build().inject(this);

    }
}
