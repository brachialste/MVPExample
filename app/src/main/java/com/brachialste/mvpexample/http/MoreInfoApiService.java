package com.brachialste.mvpexample.http;

import com.brachialste.mvpexample.http.apimodel.OmdbApi;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by imacmovil on 25/01/17.
 */

public interface MoreInfoApiService {

    @GET("/")
    Observable<OmdbApi> getCountry(@Query("t") String title);

}
