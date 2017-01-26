package com.brachialste.mvpexample.presenter;

import com.brachialste.mvpexample.MVPDefinition;
import com.brachialste.mvpexample.http.ApiModuleForName;
import com.brachialste.mvpexample.http.MoreInfoApiService;
import com.brachialste.mvpexample.http.MovieApiService;
import com.brachialste.mvpexample.model.Repository;
import com.brachialste.mvpexample.model.TopMoviesModel;
import com.brachialste.mvpexample.model.TopMoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imacmovil on 25/01/17.
 */

@Module(includes = {ApiModuleForName.class})

public class TopMoviesModule {

    @Provides
    public MVPDefinition.Presenter provideTopMoviesActivityPresenter(MVPDefinition.Model topMoviesModel) {
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public MVPDefinition.Model provideTopMoviesActivityModel(Repository repository) {
        return new TopMoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        return new TopMoviesRepository(movieApiService, moreInfoApiService);
    }

}
