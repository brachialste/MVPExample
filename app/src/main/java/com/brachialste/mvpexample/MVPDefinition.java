package com.brachialste.mvpexample;

import com.brachialste.mvpexample.view.ViewModel;

import rx.Observable;

/**
 * Created by imacmovil on 25/01/17.
 */

public interface MVPDefinition {

    interface View {

        void updateData(ViewModel viewModel);

        void showSnackbar(String s);

    }

    interface Presenter {

        void loadData();

        void rxUnsubscribe();

        void setView(MVPDefinition.View view);

    }

    interface Model {

        Observable<ViewModel> result();

    }
}
