package com.gmail.demidovich.giphy.injection;

import android.content.Context;

import com.gmail.demidovich.data.net.RestApi;
import com.gmail.demidovich.data.net.RestService;
import com.gmail.demidovich.data.repository.ImgRepositoryImplementation;
import com.gmail.demidovich.domain.executor.PostExecutionThread;
import com.gmail.demidovich.domain.repository.ImageRepository;
import com.gmail.demidovich.giphy.executor.UIThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUIThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    public ImageRepository getImageRepository(RestService restService) {
        return new ImgRepositoryImplementation(restService);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder().create();
    }
}