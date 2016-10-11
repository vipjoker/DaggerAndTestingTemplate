package com.example.mydagger;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydagger.databinding.ActivityMainBinding;

import java.util.Collections;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Component;
import dagger.internal.DaggerCollections;

public class MainActivity extends BaseActivity {
    @Inject
    @Named("Retrofit2")
    RetrofitInterface mRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String[] array = {"one","two"};

        ActivityMainBinding b = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        MainActivity_MembersInjector.injectMRetrofit(this);

        DaggerComponentDag.builder().build().inject(this);

        b.tvHello.setOnClickListener((e)->{
            String message = "Message" + mRetrofit.getInfo();
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
        });

    }


}
