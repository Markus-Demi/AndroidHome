package com.gmail.demidovich.giphy.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseViewModel() {
        super();
        createInject();
    }

    public abstract void createInject();

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }
}
