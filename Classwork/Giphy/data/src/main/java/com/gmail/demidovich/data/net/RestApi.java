package com.gmail.demidovich.data.net;

import com.gmail.demidovich.data.constants.Constants;
import com.gmail.demidovich.data.entity.DataImg;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestApi {

    @GET("v1/gifs/search")
    @Headers("api_key" + Constants.API_IMG_KEY)
    Observable<DataImg> searchImgs(@Query("q") String search);

    @GET("v1/gifs/trending")
    @Headers("api_key" + Constants.API_IMG_KEY)
    Observable<DataImg> trendingImgs();
}
