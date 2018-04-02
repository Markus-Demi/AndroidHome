package com.gmail.demidovich.giphy;

import android.databinding.ObservableField;
import android.text.Editable;
import android.util.Log;

import com.gmail.demidovich.domain.entity.ImageEntity;
import com.gmail.demidovich.domain.usecases.SearchImgUsecase;
import com.gmail.demidovich.domain.usecases.TrendingUsecase;
import com.gmail.demidovich.giphy.app.App;
import com.gmail.demidovich.giphy.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GifViewModel extends BaseViewModel {

    public ObservableField<List<ImageEntity>> mListObservableField = new ObservableField<>();

    @Inject
    public TrendingUsecase mTrendingUsecase;

    @Inject
    public SearchImgUsecase mSearchImgUsecase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public GifViewModel() {
        super();

        mTrendingUsecase.trendingImages().subscribe(new Observer<List<ImageEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mCompositeDisposable.add(d);
            }

            @Override
            public void onNext(List<ImageEntity> imageEntities) {
                Log.e("random tag", "onNext()");
                mListObservableField.set(imageEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void searchImg(Editable txt) {
        mSearchImgUsecase.searchImage(txt.toString()).subscribe(new Observer<List<ImageEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mCompositeDisposable.add(d);
            }

            @Override
            public void onNext(List<ImageEntity> imageEntities) {
                mListObservableField.set(imageEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}