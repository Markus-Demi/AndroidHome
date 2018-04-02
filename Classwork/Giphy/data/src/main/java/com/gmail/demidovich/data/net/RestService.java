package com.gmail.demidovich.data.net;

import com.gmail.demidovich.data.entity.DataImg;
import com.gmail.demidovich.data.entity.Image;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

@Singleton
public class RestService {

    private RestApi mRestApi;

    @Inject
    public RestService(RestApi restApi) {
        this.mRestApi = restApi;
    }

    public Observable<List<Image>> searchImg(String search) {
        return mRestApi.searchImgs(search)
                .map(new Function<DataImg, List<Image>>() {
            @Override
            public List<Image> apply(DataImg dataImg) throws Exception {
                return dataImg.getData();
            }
        });
    }

    public Observable<List<Image>> trendingImg() {
        return mRestApi.trendingImgs()
                .map(new Function<DataImg, List<Image>>() {
            @Override
            public List<Image> apply(DataImg dataImg) throws Exception {
                return dataImg.getData();
            }
        });
    }
}
