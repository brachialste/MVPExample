package com.brachialste.mvpexample.presenter;

import com.brachialste.mvpexample.MVPDefinition;
import com.brachialste.mvpexample.view.ViewModel;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by imacmovil on 25/01/17.
 */

public class TopMoviesPresenter implements MVPDefinition.Presenter {

    private MVPDefinition.View view;
    private Subscription subscription = null;
    private MVPDefinition.Model model;

    public TopMoviesPresenter(MVPDefinition.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {

        subscription = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewModel>() {
                    @Override
                    public void onCompleted() {
                        view.showSnackbar("Data loaded succesfully");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.showSnackbar("Error getting movies");
                        }
                    }

                    @Override
                    public void onNext(ViewModel viewModel) {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }
                });
    }

    @Override
    public void rxUnsubscribe() {

        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }

    }

    @Override
    public void setView(MVPDefinition.View view) {

        this.view = view;

    }
}
