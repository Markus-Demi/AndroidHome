package com.gmail.demidovich.data.entity;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public Image(String url) {
        this.url = url;
    }
}
