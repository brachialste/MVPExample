package com.brachialste.mvpexample.model;

import android.util.Log;

import com.brachialste.mvpexample.MVPDefinition;
import com.brachialste.mvpexample.http.apimodel.Result;
import com.brachialste.mvpexample.root.App;
import com.brachialste.mvpexample.view.ViewModel;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by imacmovil on 25/01/17.
 */

public class TopMoviesModel implements MVPDefinition.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {

        return Observable.zip(repository.getResultData(), repository.getCountryData(), new Func2<Result, String, ViewModel>() {
            @Override
            public ViewModel call(Result result, String s) {
                Log.d(App.TAG, "result.id = " + result.id);
                Log.d(App.TAG, "result.title = " + result.title);
                Log.d(App.TAG, "s = " + s);

                return new ViewModel(result.title, s);
            }
        });
    }
}
