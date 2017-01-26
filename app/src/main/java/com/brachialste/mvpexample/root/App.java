package com.brachialste.mvpexample.root;

import android.app.Application;

import com.brachialste.mvpexample.http.ApiModuleForInfo;
import com.brachialste.mvpexample.http.ApiModuleForName;
import com.brachialste.mvpexample.presenter.TopMoviesModule;

/**
 * Created by imacmovil on 25/01/17.
 */

public class App extends Application {

    public static final String TAG = "App";
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForName(new ApiModuleForName())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
