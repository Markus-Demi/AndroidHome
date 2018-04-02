package com.gmail.demidovich.domain.usecases;

import com.gmail.demidovich.domain.entity.ImageEntity;
import com.gmail.demidovich.domain.executor.PostExecutionThread;
import com.gmail.demidovich.domain.repository.ImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class SearchImgUsecase extends BaseUsecase {

    private ImageRepository mImageRepository;

    @Inject
    public SearchImgUsecase(PostExecutionThread postExecutionThread, ImageRepository imageRepository) {
        super(postExecutionThread);
        this.mImageRepository = imageRepository;
    }

    public Observable<List<ImageEntity>> searchImage(String search) {
        return mImageRepository
                .getSearch(search)
                .subscribeOn(mThreadExecution)
                .observeOn(mPostExecutionThread);
    }
}
