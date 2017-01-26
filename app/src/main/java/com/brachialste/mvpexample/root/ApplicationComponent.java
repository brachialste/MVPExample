package com.brachialste.mvpexample.root;

import com.brachialste.mvpexample.view.MainActivity;
import com.brachialste.mvpexample.http.ApiModuleForInfo;
import com.brachialste.mvpexample.http.ApiModuleForName;
import com.brachialste.mvpexample.presenter.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by imacmovil on 25/01/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class, ApiModuleForInfo.class, TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);
}
