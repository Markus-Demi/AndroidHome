package com.gmail.demidovich.domain.repository;

import com.gmail.demidovich.domain.entity.ImageEntity;

import java.util.List;

import io.reactivex.Observable;

public interface ImageRepository {

    Observable<List<ImageEntity>> getSearch(String search);
    Observable<List<ImageEntity>> getTrending();

}
