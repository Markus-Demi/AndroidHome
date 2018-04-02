package com.gmail.demidovich.data.repository;

import com.gmail.demidovich.data.entity.Image;
import com.gmail.demidovich.data.net.RestService;
import com.gmail.demidovich.domain.repository.ImageRepository;
import com.gmail.demidovich.domain.entity.ImageEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ImgRepositoryImplementation implements ImageRepository {

    private RestService mRestService;

    @Inject
    public ImgRepositoryImplementation(RestService restService) {
        mRestService = restService;
    }

    @Override
    public Observable<List<ImageEntity>> getSearch(String search) {
        return mRestService.searchImg(search).map(new Function<List<Image>, List<ImageEntity>>() {
            @Override
            public List<ImageEntity> apply(List<Image> images) throws Exception {
                List<ImageEntity> list = new ArrayList<>();
                for (Image img : images) {
                    list.add(new ImageEntity(img.getUrl()));
                }
                return list;
            }
        });
    }

    @Override
    public Observable<List<ImageEntity>> getTrending() {
        return mRestService.trendingImg().map(new Function<List<Image>, List<ImageEntity>>() {
            @Override
            public List<ImageEntity> apply(List<Image> images) throws Exception {
                List<ImageEntity> list = new ArrayList<>();
                for (Image img : images) {
                    list.add(new ImageEntity(img.getUrl()));
                }
                return list;
            }
        });
    }
}