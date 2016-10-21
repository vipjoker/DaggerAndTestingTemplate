package com.example.mydagger.view;

import android.databinding.DataBindingUtil;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.example.mydagger.DaggerComponentDag;
import com.example.mydagger.R;
import com.example.mydagger.RetrofitInterface;
import com.example.mydagger.databinding.SecondAcitivityBinding;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by oleh on 11.10.16.
 */

public class SecondActivity extends BaseActivity {
    private SecondAcitivityBinding b;
    @Inject
    @Named("Retrofit")
    RetrofitInterface retrofitInterface;
    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.second_acitivity);
        b.btnPause.setOnClickListener(this::onPauseClicked);
        DaggerComponentDag.builder().build().inject(this);
    }

    private void onPauseClicked(View view) {
        Observable.fromCallable(retrofitInterface.getInfo())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess,this::onFailure);
    }

    private void onSuccess(String s) {
        Toast.makeText(this,"Result is " +  s, Toast.LENGTH_SHORT).show();
    }

    private void onFailure(Throwable throwable) {

    }

    private int getMiddle(int number){
        return number >>2;
    }

    private void setMediaPlayer(Camera camera,String outPutFile){
        if(camera ==null)return ;
        MediaRecorder recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        recorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_480P));
        camera.unlock();
        recorder.setCamera(camera);
        recorder.setOutputFile(outPutFile);
        try {
            recorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            releaseRessources(camera);
        }

    }

    private void releaseRessources(Camera camera) {
        if(camera != null){
            camera.release();
        }
    }
    private void releaseMediaPlayer(MediaRecorder recorder){
        if (recorder != null) {
            return;
        }
      recorder.reset();
        recorder.release();
//this is important        camera.lock()
    }


    private void scanForFile(String filePath){
        String[]paths = {filePath};
        MediaScannerConnection.scanFile(this, paths, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {
                Toast.makeText(SecondActivity.this, path + " " + uri.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean inFullHdSuppored(int cameraId){
        return CamcorderProfile.hasProfile(cameraId, CamcorderProfile.QUALITY_1080P);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
