package com.gmail.demidovich.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataImg {

    @SerializedName("data")
    private List<Image> data;

    public DataImg(List<Image> data) {
        this.data = data;
    }

    public List<Image> getData() {
        return data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }
}
