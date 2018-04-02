package com.gmail.demidovich.domain.usecases;

import com.gmail.demidovich.domain.entity.ImageEntity;
import com.gmail.demidovich.domain.executor.PostExecutionThread;
import com.gmail.demidovich.domain.repository.ImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TrendingUsecase extends BaseUsecase {

    private ImageRepository mImageRepository;

    @Inject
    public TrendingUsecase(PostExecutionThread postExecutionThread, ImageRepository imageRepository) {
        super(postExecutionThread);
        this.mImageRepository = imageRepository;
    }

    public Observable<List<ImageEntity>> trendingImages() {
        return mImageRepository
                .getTrending()
                .subscribeOn(mThreadExecution)
                .observeOn(mPostExecutionThread);
    }
}
