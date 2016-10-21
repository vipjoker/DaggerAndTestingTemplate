package com.example.mydagger.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.mydagger.DaggerComponentDag;
import com.example.mydagger.R;
import com.example.mydagger.RetrofitInterface;
import com.example.mydagger.databinding.ActivityMainBinding;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends BaseActivity {
    @Inject
    @Named("Retrofit2")
    RetrofitInterface mRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String[] array = {"one","two"};

        ActivityMainBinding b = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        MainActivity_MembersInjector.injectMRetrofit(this);

        DaggerComponentDag.builder().build().inject(this);


    }


}
