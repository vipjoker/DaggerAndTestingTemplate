package com.example.mydagger.presneter;

/**
 * Created by oleh on 21.10.16.
 */

public interface BasePresenter <T extends BaseMvpView>{
    public void attachView(T t);
}
