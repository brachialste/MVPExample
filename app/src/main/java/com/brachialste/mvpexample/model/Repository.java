package com.brachialste.mvpexample.model;

import com.brachialste.mvpexample.http.apimodel.Result;

import rx.Observable;

/**
 * Created by imacmovil on 25/01/17.
 */

public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();
}
