package com.gmail.demidovich.classwork1.classwork6;

public class User {
    private String imgURL;
    private String name;
    private String surname;

    public User(String imgURL, String name, String surname) {
        this.imgURL = imgURL;
        this.name = name;
        this.surname = surname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
