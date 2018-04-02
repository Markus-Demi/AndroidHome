package com.gmail.demidovich.domain.entity;

public class ImageEntity {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageEntity(String url) {
        this.url = url;
    }
}
